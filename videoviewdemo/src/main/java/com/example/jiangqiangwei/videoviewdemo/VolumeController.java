package com.example.jiangqiangwei.videoviewdemo;

import android.content.Context;
import android.media.AudioManager;

/**
 * Created by Rock on 2016/9/7.
 */
public class VolumeController {
    /**
     *
     * @param context
     * @param yDelta    < 0
     * @param screenWidth
     */
    public static void volumeUp(Context context, float yDelta, int screenWidth){
        // 获取声音的管理者
        AudioManager audioManager = (AudioManager) context.getSystemService(Context.AUDIO_SERVICE);
        // 获取当前音量
        int currentVolume = audioManager.getStreamVolume(AudioManager.STREAM_MUSIC);
        // 获取最大音量
        int maxVolume = audioManager.getStreamMaxVolume(AudioManager.STREAM_MUSIC);
        // 计算增加的音量   add < 0
        double add = 2 * maxVolume * yDelta / screenWidth;
        double changed = Math.min(maxVolume, currentVolume - add);
        // 设置音量
        audioManager.setStreamVolume(AudioManager.STREAM_MUSIC, (int) changed, AudioManager.FLAG_SHOW_UI);
    }

    public static void volumeDown(Context context, float yDelta, int screenWidth){
        // 获取声音的管理者
        AudioManager audioManager = (AudioManager) context.getSystemService(Context.AUDIO_SERVICE);
        // 获取当前音量
        int currentVolume = audioManager.getStreamVolume(AudioManager.STREAM_MUSIC);
        // 获取最大音量
        int maxVolume = audioManager.getStreamMaxVolume(AudioManager.STREAM_MUSIC);
        // 计算增加的音量   add < 0
        double reduce = 2 * maxVolume * yDelta / screenWidth;
        double changed = Math.max(0, currentVolume - reduce);
        // 设置音量
        audioManager.setStreamVolume(AudioManager.STREAM_MUSIC, (int) changed, AudioManager.FLAG_SHOW_UI);
    }

}
