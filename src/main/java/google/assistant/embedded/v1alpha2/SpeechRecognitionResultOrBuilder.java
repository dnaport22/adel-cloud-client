// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: google/assistant/embedded/v1alpha2/embedded_assistant.proto

package com.google.assistant.embedded.v1alpha2;

public interface SpeechRecognitionResultOrBuilder extends
    // @@protoc_insertion_point(interface_extends:google.assistant.embedded.v1alpha2.SpeechRecognitionResult)
    com.google.protobuf.MessageOrBuilder {

  /**
   * <pre>
   * *Output-only* Transcript text representing the words that the user spoke.
   * </pre>
   *
   * <code>string transcript = 1;</code>
   */
  java.lang.String getTranscript();
  /**
   * <pre>
   * *Output-only* Transcript text representing the words that the user spoke.
   * </pre>
   *
   * <code>string transcript = 1;</code>
   */
  com.google.protobuf.ByteString
      getTranscriptBytes();

  /**
   * <pre>
   * *Output-only* An estimate of the likelihood that the Assistant will not
   * change its guess about this result. Values range from 0.0 (completely
   * unstable) to 1.0 (completely stable and final). The default of 0.0 is a
   * sentinel value indicating `stability` was not set.
   * </pre>
   *
   * <code>float stability = 2;</code>
   */
  float getStability();
}
