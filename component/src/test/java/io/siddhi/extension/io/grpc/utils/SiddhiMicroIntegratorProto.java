// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: siddhi_MI_connect.proto

package io.siddhi.extension.io.grpc.utils;

public final class SiddhiMicroIntegratorProto {
    private SiddhiMicroIntegratorProto() {}
    public static void registerAllExtensions(
            com.google.protobuf.ExtensionRegistryLite registry) {
    }

    public static void registerAllExtensions(
            com.google.protobuf.ExtensionRegistry registry) {
        registerAllExtensions(
                (com.google.protobuf.ExtensionRegistryLite) registry);
    }
    static final com.google.protobuf.Descriptors.Descriptor
            internal_static_invokesequence_SequenceCallRequest_descriptor;
    static final
    com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
            internal_static_invokesequence_SequenceCallRequest_fieldAccessorTable;
    static final com.google.protobuf.Descriptors.Descriptor
            internal_static_invokesequence_SequenceCallRequest_SynapseConfigsEntry_descriptor;
    static final
    com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
            internal_static_invokesequence_SequenceCallRequest_SynapseConfigsEntry_fieldAccessorTable;
    static final com.google.protobuf.Descriptors.Descriptor
            internal_static_invokesequence_SequenceCallResponse_descriptor;
    static final
    com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
            internal_static_invokesequence_SequenceCallResponse_fieldAccessorTable;
    static final com.google.protobuf.Descriptors.Descriptor
            internal_static_invokesequence_EmptyResponse_descriptor;
    static final
    com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
            internal_static_invokesequence_EmptyResponse_fieldAccessorTable;

    public static com.google.protobuf.Descriptors.FileDescriptor
    getDescriptor() {
        return descriptor;
    }
    private static  com.google.protobuf.Descriptors.FileDescriptor
            descriptor;
    static {
        String[] descriptorData = {
                "\n\027siddhi_MI_connect.proto\022\016invokesequenc" +
                        "e\"\312\001\n\023SequenceCallRequest\022\024\n\014sequenceNam" +
                        "e\030\001 \001(\t\022\025\n\rpayloadAsJSON\030\002 \001(\t\022O\n\016synaps" +
                        "eConfigs\030\003 \003(\01327.invokesequence.Sequence" +
                        "CallRequest.SynapseConfigsEntry\0325\n\023Synap" +
                        "seConfigsEntry\022\013\n\003key\030\001 \001(\t\022\r\n\005value\030\002 \001" +
                        "(\t:\0028\001\".\n\024SequenceCallResponse\022\026\n\016respon" +
                        "seAsJSON\030\001 \001(\t\"\017\n\rEmptyResponse2\336\001\n\016Invo" +
                        "keSequence\022g\n\030CallSequenceWithResponse\022#" +
                        ".invokesequence.SequenceCallRequest\032$.in" +
                        "vokesequence.SequenceCallResponse\"\000\022c\n\033C" +
                        "allSequenceWithoutResponse\022#.invokeseque" +
                        "nce.SequenceCallRequest\032\035.invokesequence" +
                        ".EmptyResponse\"\000BA\n\033io.siddhi.extension." +
                        "io.grpcB\032SiddhiMicroIntegratorProtoP\001\242\002\003" +
                        "SMIb\006proto3"
        };
        com.google.protobuf.Descriptors.FileDescriptor.InternalDescriptorAssigner assigner =
                new com.google.protobuf.Descriptors.FileDescriptor.    InternalDescriptorAssigner() {
                    public com.google.protobuf.ExtensionRegistry assignDescriptors(
                            com.google.protobuf.Descriptors.FileDescriptor root) {
                        descriptor = root;
                        return null;
                    }
                };
        com.google.protobuf.Descriptors.FileDescriptor
                .internalBuildGeneratedFileFrom(descriptorData,
                        new com.google.protobuf.Descriptors.FileDescriptor[] {
                        }, assigner);
        internal_static_invokesequence_SequenceCallRequest_descriptor =
                getDescriptor().getMessageTypes().get(0);
        internal_static_invokesequence_SequenceCallRequest_fieldAccessorTable = new
                com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
                internal_static_invokesequence_SequenceCallRequest_descriptor,
                new String[] { "SequenceName", "PayloadAsJSON", "SynapseConfigs", });
        internal_static_invokesequence_SequenceCallRequest_SynapseConfigsEntry_descriptor =
                internal_static_invokesequence_SequenceCallRequest_descriptor.getNestedTypes().get(0);
        internal_static_invokesequence_SequenceCallRequest_SynapseConfigsEntry_fieldAccessorTable = new
                com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
                internal_static_invokesequence_SequenceCallRequest_SynapseConfigsEntry_descriptor,
                new String[] { "Key", "Value", });
        internal_static_invokesequence_SequenceCallResponse_descriptor =
                getDescriptor().getMessageTypes().get(1);
        internal_static_invokesequence_SequenceCallResponse_fieldAccessorTable = new
                com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
                internal_static_invokesequence_SequenceCallResponse_descriptor,
                new String[] { "ResponseAsJSON", });
        internal_static_invokesequence_EmptyResponse_descriptor =
                getDescriptor().getMessageTypes().get(2);
        internal_static_invokesequence_EmptyResponse_fieldAccessorTable = new
                com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
                internal_static_invokesequence_EmptyResponse_descriptor,
                new String[] { });
    }

    // @@protoc_insertion_point(outer_class_scope)
}
