package io.siddhi.extension.io.grpc.utils;

import io.grpc.BindableService;
import io.grpc.MethodDescriptor;
import io.grpc.ServerCallHandler;
import io.grpc.ServerServiceDefinition;
import io.grpc.stub.ServerCalls;
import io.grpc.stub.StreamObserver;
import io.siddhi.extension.io.grpc.utils.GRPCService.EmptyResponse;

import java.io.ByteArrayInputStream;
import java.io.InputStream;

public class TestService implements BindableService {
    private String SERVICE_NAME = "TestService";
    @Override
    public ServerServiceDefinition bindService() {
        ServerServiceDefinition.Builder ssd = ServerServiceDefinition.builder(SERVICE_NAME);
        ServerCallHandler<GRPCService.Request, GRPCService.EmptyResponse> serverCallHandler = ServerCalls.asyncUnaryCall((request, responseObserver) -> create(request, responseObserver));
        ssd.addMethod(CREATE_METHOD, serverCallHandler);
        return ssd.build();
    }

    public void create(GRPCService.Request request, StreamObserver<GRPCService.EmptyResponse> responseObserver) {
        System.out.println("server hit!");
        EmptyResponse emptyResponse = new EmptyResponse();
        responseObserver.onNext(emptyResponse);
        responseObserver.onCompleted();
    }

    public MethodDescriptor<GRPCService.Request, EmptyResponse> CREATE_METHOD =
            MethodDescriptor.newBuilder(
                    marshallerForReq(GRPCService.Request.class),
                    marshallerForResp(EmptyResponse.class))
                    .setFullMethodName(
                            MethodDescriptor.generateFullMethodName(SERVICE_NAME, "Create"))
                    .setType(MethodDescriptor.MethodType.UNARY)
                    .setSampledToLocalTracing(true)
                    .build();

    static <T> MethodDescriptor.Marshaller<T> marshallerForReq(Class<T> clz) {
        return new MethodDescriptor.Marshaller<T>() {
            @Override
            public InputStream stream(T value) {
                return new ByteArrayInputStream(((GRPCService.Request) value).getValue());
            }

            @Override
            public T parse(InputStream stream) {
                System.out.println("received");
//                stream.;
                byte[] myvar = "Any String you want".getBytes();
                GRPCService.Request request = new GRPCService.Request(myvar);
                return (T) request; //gson.fromJson(new InputStreamReader(stream, StandardCharsets.UTF_8), clz);
                //todo: find way to get byte[] from inputstream
            }
        };
    }

    static <T> MethodDescriptor.Marshaller<T> marshallerForResp(Class<T> clz) {
        return new MethodDescriptor.Marshaller<T>() {
            @Override
            public InputStream stream(T value) {
                return new ByteArrayInputStream(((EmptyResponse) value).getResponse());
            }

            @Override
            public T parse(InputStream stream) {
                System.out.println("received");
//                stream.;
                byte[] myvar = "Any String you want".getBytes();
                EmptyResponse response = new EmptyResponse();
                return (T) response; //gson.fromJson(new InputStreamReader(stream, StandardCharsets.UTF_8), clz);
                //todo: find way to get byte[] from inputstream
            }
        };
    }

}
