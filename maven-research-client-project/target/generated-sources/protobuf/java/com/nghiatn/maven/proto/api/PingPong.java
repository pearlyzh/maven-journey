// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: PingPong.proto

package com.nghiatn.maven.proto.api;

public final class PingPong {
  private PingPong() {}
  public static void registerAllExtensions(
      com.google.protobuf.ExtensionRegistryLite registry) {
  }

  public static void registerAllExtensions(
      com.google.protobuf.ExtensionRegistry registry) {
    registerAllExtensions(
        (com.google.protobuf.ExtensionRegistryLite) registry);
  }
  static final com.google.protobuf.Descriptors.Descriptor
    internal_static_com_nghiatn_maven_proto_api_PingRequest_descriptor;
  static final 
    com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internal_static_com_nghiatn_maven_proto_api_PingRequest_fieldAccessorTable;
  static final com.google.protobuf.Descriptors.Descriptor
    internal_static_com_nghiatn_maven_proto_api_PingResponse_descriptor;
  static final 
    com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internal_static_com_nghiatn_maven_proto_api_PingResponse_fieldAccessorTable;

  public static com.google.protobuf.Descriptors.FileDescriptor
      getDescriptor() {
    return descriptor;
  }
  private static  com.google.protobuf.Descriptors.FileDescriptor
      descriptor;
  static {
    java.lang.String[] descriptorData = {
      "\n\016PingPong.proto\022\033com.nghiatn.maven.prot" +
      "o.api\"\r\n\013PingRequest\" \n\014PingResponse\022\020\n\010" +
      "response\030\001 \001(\t2n\n\017PingGRpcService\022[\n\004pin" +
      "g\022(.com.nghiatn.maven.proto.api.PingRequ" +
      "est\032).com.nghiatn.maven.proto.api.PingRe" +
      "sponseB\037\n\033com.nghiatn.maven.proto.apiP\001b" +
      "\006proto3"
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
    internal_static_com_nghiatn_maven_proto_api_PingRequest_descriptor =
      getDescriptor().getMessageTypes().get(0);
    internal_static_com_nghiatn_maven_proto_api_PingRequest_fieldAccessorTable = new
      com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
        internal_static_com_nghiatn_maven_proto_api_PingRequest_descriptor,
        new java.lang.String[] { });
    internal_static_com_nghiatn_maven_proto_api_PingResponse_descriptor =
      getDescriptor().getMessageTypes().get(1);
    internal_static_com_nghiatn_maven_proto_api_PingResponse_fieldAccessorTable = new
      com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
        internal_static_com_nghiatn_maven_proto_api_PingResponse_descriptor,
        new java.lang.String[] { "Response", });
  }

  // @@protoc_insertion_point(outer_class_scope)
}