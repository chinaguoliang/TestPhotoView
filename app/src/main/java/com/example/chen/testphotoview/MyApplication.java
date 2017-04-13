package com.example.chen.testphotoview;

import android.app.Application;
import android.graphics.Color;

import com.nostra13.universalimageloader.core.ImageLoader;
import com.nostra13.universalimageloader.core.ImageLoaderConfiguration;

import cn.finalteam.galleryfinal.CoreConfig;
import cn.finalteam.galleryfinal.FunctionConfig;
import cn.finalteam.galleryfinal.GalleryFinal;
import cn.finalteam.galleryfinal.ThemeConfig;

/**
 * Created by Administrator on 2017/4/13.
 */
public class MyApplication extends Application {
    @Override
    public void onCreate() {
        super.onCreate();

        //创建默认的ImageLoader配置参数
        ImageLoaderConfiguration configuration = new ImageLoaderConfiguration.Builder(this)
                .writeDebugLogs() //打印log信息
                .build();


        //Initialize ImageLoader with configuration.
        ImageLoader.getInstance().init(configuration);


        initPhotoView();
    }

    private void initPhotoView() {
        ThemeConfig theme = new ThemeConfig.Builder().setTitleBarBgColor(Color.YELLOW)
        .build();
        //配置功能

        cn.finalteam.galleryfinal.ImageLoader imageloader = new UILImageloader();
        FunctionConfig functionConfig = new FunctionConfig.Builder()
                .setEnableCamera(true)
                .setEnableEdit(true)
                .setEnableCrop(true)
                .setEnableRotate(true)
                .setCropSquare(true)
                .setEnablePreview(true).build();

//设置核心配置信息
        CoreConfig coreConfig = new CoreConfig.Builder(this.getApplicationContext(), imageloader, theme)
                .setFunctionConfig(functionConfig)
                .build();
        GalleryFinal.init(coreConfig);
    }
}
