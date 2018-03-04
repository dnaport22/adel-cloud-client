package mautini.assistant.demo.client.audio;

import mautini.assistant.demo.config.AudioConf;

import javax.sound.sampled.AudioFormat;

public class AudioUtil {
    /**
     * Defines the audio format for requests and responses
     */
    public static AudioFormat getAudioFormat(AudioConf audioConf) {
        return new AudioFormat(
                audioConf.getSampleRate(),
                audioConf.getSampleSizeInBits(),
                audioConf.getChannels(),
                audioConf.getSigned(),
                audioConf.getBigEndian());
    }
}
