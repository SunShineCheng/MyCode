package com.xcc.picassodemo;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ImageView;

import com.squareup.picasso.Picasso;

public class MainActivity extends AppCompatActivity {
    public static final String  URL="https://ss0.bdstatic.com/5aV1bjqh_Q23odCf/static/superman/img/logo/bd_logo1_31bdc765.png";
    private ImageView imageView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
         initView();
         getData();
    }

    private void getData() {
//        Picasso.with(this).load(URL);
          Picasso.with(this)
                 .load(URL)
                  .resize(200,100)
                 .into(imageView);
    }

    private void initView() {
        imageView = (ImageView) findViewById(R.id.img);
    }


}
