package com.xcc.glide;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;

import com.bumptech.glide.Glide;

public class MainActivity extends AppCompatActivity {

    private ImageView image;
    private static final String URL="http://img2.imgtn.bdimg.com/it/u=3842202031,1903513727&fm=21&gp=0.jpg";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
        getData();
    }

    private void getData() {
        Glide.with(this)
                .load(URL)
                .into(image);
    }

    private void initView() {
        image = (ImageView)findViewById(R.id.image);
    }


}
