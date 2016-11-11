package com.example.jiangqiangwei.videoviewdemo;

import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.provider.Settings;
import android.support.v7.app.AppCompatActivity;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.LinearLayout;

/**
 * 视频播放(VideoView),手势调节音量,屏幕亮度,屏幕切换
 */
public class MainActivity extends AppCompatActivity implements CompoundButton.OnCheckedChangeListener, View.OnTouchListener {

    private MyFullVideoView videoView;
    private CheckBox checkPlay, checkChengeScreen;
    //网络的视频文件地址
    private String path = "http://flv.bn.netease.com/videolib3/1601/13/RzAQP8148/HD/RzAQP8148-mobile.mp4";
    //原来的屏幕高度值
    private int oldHeight;
    //底部导航布局
    private LinearLayout bottomBar;
    //导航条是否显示
    private boolean isShow = false;
    //最开始按下的X坐标值
    private float startX;
    //最开始按下的Y坐标值
    private float startY;
    //移动的x坐标点
    private float moveX;
    //移动的Y坐标点
    private float moveY;
    private int screenWidth;
    private int heightScreen;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
        setListener();
        //当前编译版本大于6.0有些权限需要动态申请
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            if (!Settings.System.canWrite(this)) {
                Intent intent = new Intent(Settings.ACTION_MANAGE_WRITE_SETTINGS,
                        Uri.parse("package:" + getPackageName()));
                startActivity(intent);
            }

        }
    }

    private void setListener() {
        checkPlay.setOnCheckedChangeListener(this);
        checkChengeScreen.setOnCheckedChangeListener(this);
        //设置onTouchListnener
        videoView.setOnTouchListener(this);
    }

    private void initView() {
        videoView = (MyFullVideoView) findViewById(R.id.videoview);
        checkPlay = (CheckBox) findViewById(R.id.checkbox_playorpause);
        checkChengeScreen = (CheckBox) findViewById(R.id.checkbox_changescreen);
        bottomBar = (LinearLayout) findViewById(R.id.guide_buttombar);
        videoView.setVideoPath(path);
        //视频控制器
        //videoView.setMediaController(new MediaController(this));
        //videoView.start();
        //获取屏幕的宽高
        screenWidth = getWindowManager().getDefaultDisplay().getWidth();
        heightScreen = getWindowManager().getDefaultDisplay().getHeight();
    }

    @Override
    public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
        switch (buttonView.getId()) {
            case R.id.checkbox_playorpause:
                //点击播放或者暂停
                if (isChecked) {
                    videoView.start();
                } else {
                    videoView.pause();
                }
                break;
            case R.id.checkbox_changescreen:
                if (isChecked) {
                    oldHeight = videoView.getHeight();
                    getWindow().addFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN);
                    setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE);
                    //获得控件的布局信息
                    ViewGroup.LayoutParams layoutParams = videoView.getLayoutParams();
                    //更改高度值
                    layoutParams.height = WindowManager.LayoutParams.MATCH_PARENT;
                    //更改后的布局信息在设置给控件
                    videoView.setLayoutParams(layoutParams);

                } else {
                    getWindow().clearFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN);
                    setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
                    //修改控件的高度设置为旋转之前的高度
                    ViewGroup.LayoutParams layoutParams = videoView.getLayoutParams();
                    layoutParams.height = oldHeight;
                    videoView.setLayoutParams(layoutParams);
                }
                break;
        }
    }


    @Override
    public boolean onTouch(View v, MotionEvent event) {

        switch (event.getAction()) {
            case MotionEvent.ACTION_DOWN:
                //按下的时候记录坐标值
                startX = event.getRawX();
                startY = event.getRawY();
                break;
            case MotionEvent.ACTION_MOVE:
                moveX = event.getRawX();
                moveY = event.getRawY();
                if (startX > screenWidth / 2) {
                    //TODO 音量调节
                    //判断移动方向
                    float change = moveY - startY;
                    //将移动的值取个绝对值,当他大于一定值的时候才视为调节
                    float abs = Math.abs(change);
                    if (change < 0 && abs > 5) {
                        //音量变大 向上滑动
                        VolumeController.volumeUp(this, change, screenWidth);
                    } else if (change > 0 && abs > 5) {
                        //音量变小 向下滑动
                        VolumeController.volumeDown(this, change, screenWidth);
                    }
                } else {
                    //TODO 亮度调节
                    //判断移动方向
                    float change = moveY - startY;
                    //将移动的值取个绝对值,当他大于一定值的时候才视为调节
                    float abs = Math.abs(change);
                    if (change < 0 && abs > 5) {
                        //亮度调节
                        LightController.lightUp(this, change, screenWidth);
                    } else if (change > 0 && abs > 5) {
                        //亮度降低
                        LightController.lightDown(this, change, screenWidth);
                    }

                }
                startX = moveX;
                startY = moveY;
                break;
            case MotionEvent.ACTION_UP:
                hideBottomBar();
                break;
        }
        return true;
    }

    private void hideBottomBar() {
        if (isShow) {
            //如果是显示出来就控制隐藏
            bottomBar.setVisibility(View.INVISIBLE);
            isShow = false;
        } else {
            //如果隐藏的就设置为显示状态
            bottomBar.setVisibility(View.VISIBLE);
            isShow = true;
        }
    }
}
