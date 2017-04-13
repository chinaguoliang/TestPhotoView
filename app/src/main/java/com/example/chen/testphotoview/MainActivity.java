package com.example.chen.testphotoview;

import android.app.Activity;
import android.graphics.drawable.Drawable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import java.util.List;

import cn.finalteam.galleryfinal.FunctionConfig;
import cn.finalteam.galleryfinal.GalleryFinal;
import cn.finalteam.galleryfinal.ImageLoader;
import cn.finalteam.galleryfinal.model.PhotoInfo;
import cn.finalteam.galleryfinal.widget.GFImageView;

public class MainActivity extends AppCompatActivity  implements ImageLoader,GalleryFinal.OnHanlderResultCallback {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button btn = (Button)this.findViewById(R.id.my_testbtn);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                GalleryFinal.openGalleryMuti(10,8, MainActivity.this);//带配置


//                FunctionConfig config = new FunctionConfig.Builder()
//                        .setMutiSelectMaxSize(8)
//                        .build();
//                GalleryFinal.openCamera(10, MainActivity.this);

//                FunctionConfig config = new FunctionConfig.Builder(MainActivity.this).setMutiSelectMaxSize(8).build();
//                GalleryFinal.openGalleryMuti(REQUEST_CODE_GALLERY, functionConfig, mOnHanlderResultCallback);
            }
        });
    }

    @Override
    public void displayImage(Activity activity, String path, GFImageView imageView, Drawable defaultDrawable, int width, int height) {
        Log.d("result","mypath:" + path);
    }

    @Override
    public void clearMemoryCache() {

    }

    @Override
    public void onHanlderSuccess(int reqeustCode, List<PhotoInfo> resultList) {
        Log.d("result","success");

    }

    @Override
    public void onHanlderFailure(int requestCode, String errorMsg) {

    }
}
