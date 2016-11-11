package com.xcc.surfaceandmediaplayerdemo;

import android.content.pm.ActivityInfo;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.v7.app.AppCompatActivity;
import android.view.SurfaceHolder;
import android.view.SurfaceView;
import android.view.WindowManager;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.SeekBar;
import android.widget.TextView;

import java.io.IOException;


public class MainActivity extends AppCompatActivity implements
        SurfaceHolder.Callback, CompoundButton.OnCheckedChangeListener, Handler.Callback, SeekBar.OnSeekBarChangeListener {

    private SurfaceView surfaceview;
    //播放,暂停
    private CheckBox checkPlay;
    //切换屏幕
    private CheckBox checkchangeScreen;
    //显示当前视屏时间
    private TextView txtCurentTime;
    //总的视频时长
    private TextView totleTime;
    //视频播放进度
    private SeekBar seekbar;
    private SurfaceHolder holder;
    //播放器
    private MediaPlayer mediaPlayer;
    //网络的视频文件地址
    private String path = "http://flv.bn.netease.com/videolib3/1601/13/RzAQP8148/HD/RzAQP8148-mobile.mp4";
    //判断视频是否准备完成
    private int isPrepeared = 0;
    //handler:更新时间
    private Handler handler;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
        setLinstener();
        handler = new Handler(this);

    }

    @Override
    public boolean handleMessage(Message msg) {
        if (msg.what == 1) {
            //设置当前时间
            txtCurentTime.setText(CommonUtil.parseTime(mediaPlayer.getCurrentPosition()));
            //更新进度条
            seekbar.setProgress(mediaPlayer.getCurrentPosition());
            handler.sendEmptyMessageDelayed(1, 1000);
        }
        return false;
    }

    private void setLinstener() {
        checkPlay.setOnCheckedChangeListener(this);
        checkchangeScreen.setOnCheckedChangeListener(this);
        seekbar.setOnSeekBarChangeListener(this);
    }

    private void initMediaPlay() {
        mediaPlayer = new MediaPlayer();
        //设置播放界面
        mediaPlayer.setDisplay(holder);
        //设置播放视频的路径
        try {
            mediaPlayer.setDataSource(path);
            //设置异步准备
            mediaPlayer.prepareAsync();
            //设置视频准备的监听
            mediaPlayer.setOnPreparedListener(new MediaPlayer.OnPreparedListener() {
                @Override
                public void onPrepared(MediaPlayer mp) {
                    if (mp.getVideoWidth() > 0) {
                        //mp.start();
                        isPrepeared = 1;
                        //加载完视频之后可以直接获取视频的时长
                        totleTime.setText(CommonUtil.parseTime(mp.getDuration()));
                        //发送消息:每隔一秒刷新当前时间
                        handler.sendEmptyMessageDelayed(1, 1000);
                        //设置进度条总的时长
                        seekbar.setMax(mp.getDuration());

                    }
                }
            });
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void initView() {
        surfaceview = (SurfaceView) findViewById(R.id.sufaceView);
        checkPlay = (CheckBox) findViewById(R.id.checkbox_playorpause);
        checkchangeScreen = (CheckBox) findViewById(R.id.checkbox_changescreen);
        txtCurentTime = (TextView) findViewById(R.id.txt_currenttime);
        totleTime = (TextView) findViewById(R.id.txt_totletime);
        seekbar = (SeekBar) findViewById(R.id.seekbar_progress);
        //获得holder
        holder = surfaceview.getHolder();
        holder.addCallback(this);
    }

    @Override
    public void surfaceCreated(SurfaceHolder holder) {
        //进行视频播放
        initMediaPlay();
    }

    @Override
    public void surfaceChanged(SurfaceHolder holder, int format, int width, int height) {

    }

    @Override
    public void surfaceDestroyed(SurfaceHolder holder) {

    }

    //////////////////////
    //checkbox的监听事件
    @Override
    public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
        switch (buttonView.getId()) {
            case R.id.checkbox_playorpause:
                if (isChecked && isPrepeared == 1) {
                    mediaPlayer.start();
                } else {
                    if (mediaPlayer.isPlaying()) {
                        mediaPlayer.pause();
                    }
                }
                break;
            case R.id.checkbox_changescreen:
                if (isChecked) {
                    //设置全屏的标记
                    getWindow().addFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN);
                    //设置屏幕为横屏
                    setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE);
                } else {
                    //清除标记
                    getWindow().clearFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN);
                    //设置为竖屏
                    setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
                }
                break;
        }
    }

    ///////////////////////////////////
    //设置seekbar的拖动监听
    @Override
    public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {

    }

    @Override
    public void onStartTrackingTouch(SeekBar seekBar) {

    }

    @Override
    public void onStopTrackingTouch(SeekBar seekBar) {
        //设置视频播放的位置
        mediaPlayer.seekTo(seekBar.getProgress());
    }
}
