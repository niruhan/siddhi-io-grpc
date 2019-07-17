package io.siddhi.extension.io.grpc.sink;

import io.grpc.Server;
import io.grpc.ServerBuilder;
import io.grpc.stub.StreamObserver;
import io.siddhi.core.SiddhiAppRuntime;
import io.siddhi.core.SiddhiManager;
import io.siddhi.core.stream.input.InputHandler;
import io.siddhi.extension.io.grpc.utils.MIService.InvokeSequenceGrpc;
import io.siddhi.extension.io.grpc.utils.MIService.SequenceCallRequest;
import io.siddhi.extension.io.grpc.utils.MIService.SequenceCallResponse;
import io.siddhi.extension.io.grpc.utils.MIService.SiddhiMicroIntegratorProto;
import io.siddhi.extension.io.grpc.utils.Message;
import io.siddhi.extension.io.grpc.utils.MessageUtils;
import org.apache.log4j.Logger;
import org.testng.annotations.Test;

import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.concurrent.TimeUnit;

public class TestCaseOfGrpcSink {
    private static final Logger log = Logger.getLogger(TestCaseOfGrpcSink.class);
    private Server server;

    @Test
    public void test1() throws Exception {
        log.info("");
        SiddhiManager siddhiManager = new SiddhiManager();

        startServer();
        String payload =  String.valueOf(server.getPort());
        String inStreamDefinition = ""
                + "@sink(type='grpc', port = \'" + payload +"\', service = \'InvokeSequence\', method = \'CallSequenceWithResponse\') "
                + "define stream FooStream (message String);";

        SiddhiAppRuntime siddhiAppRuntime = siddhiManager.createSiddhiAppRuntime(inStreamDefinition);
        InputHandler fooStream = siddhiAppRuntime.getInputHandler("FooStream");


        System.out.println(server.getPort());
        try {
            siddhiAppRuntime.start();

            fooStream.send(new Object[]{payload});

            Thread.sleep(5000);
            siddhiAppRuntime.shutdown();
        } finally {
            stopServer();
        }
    }

    private void startServer() throws IOException {
        if (server != null) {
            throw new IllegalStateException("Already started");
        }
        server = ServerBuilder.forPort(0).addService(new InvokeSequenceGrpc.InvokeSequenceImplBase() {
            @Override
            public void callSequenceWithResponse(SequenceCallRequest request, StreamObserver<SequenceCallResponse> responseObserver) {
                System.out.println("Server hit");
//                super.callSequenceWithResponse(request, responseObserver);
                SequenceCallResponse response = new SequenceCallResponse();
                responseObserver.onNext(response);
                responseObserver.onCompleted();
            }
        }).build();
        server.start();
    }

    private void stopServer() throws InterruptedException {
        Server s = server;
        if (s == null) {
            throw new IllegalStateException("Already stopped");
        }
        server = null;
        s.shutdown();
        if (s.awaitTermination(1, TimeUnit.SECONDS)) {
            return;
        }
        s.shutdownNow();
        if (s.awaitTermination(1, TimeUnit.SECONDS)) {
            return;
        }
        throw new RuntimeException("Unable to shutdown server");
    }

    @Test
    public void test2() throws Exception {
        Message sample = MessageUtils.generateProtoMessage("hi", SiddhiMicroIntegratorProto.getDescriptor().findMessageTypeByName("SequenceCallResponse"));
        System.out.println(SiddhiMicroIntegratorProto.getDescriptor().toProto().toString());
//        String content = Files.readString(path, StandardCharsets.US_ASCII);
    }

    @Test
    public void test3() throws Exception {
        String path = "/Users/niruhan/My_Tasks/task10_synapse_siddhi/source_codes/siddhi-io-grpc/component/src/main/java/io/siddhi/extension/io/grpc/utils/protoContract";
        String content = readFile(path, StandardCharsets.US_ASCII);
        System.out.println(content);
        String[] descriptorData = new String[]{content};
        final com.google.protobuf.Descriptors.FileDescriptor[] descriptor = new com.google.protobuf.Descriptors.FileDescriptor[1];
        com.google.protobuf.Descriptors.FileDescriptor.InternalDescriptorAssigner assigner =
                new com.google.protobuf.Descriptors.FileDescriptor.InternalDescriptorAssigner() {
                    public com.google.protobuf.ExtensionRegistry assignDescriptors(
                            com.google.protobuf.Descriptors.FileDescriptor root) {
                        descriptor[0] = root;
                        return null;
                    }
                };
        com.google.protobuf.Descriptors.FileDescriptor.internalBuildGeneratedFileFrom(descriptorData,
                        new com.google.protobuf.Descriptors.FileDescriptor[] {
                        }, assigner);
        System.out.println("hi");
    }

    static String readFile(String path, Charset encoding)
            throws IOException
    {
        byte[] encoded = Files.readAllBytes(Paths.get(path));
        return new String(encoded, encoding);
    }
}
