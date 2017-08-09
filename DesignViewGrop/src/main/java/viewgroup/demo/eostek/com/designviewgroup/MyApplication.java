package viewgroup.demo.eostek.com.designviewgroup;

import android.app.Application;
import android.content.Context;

import com.nostra13.universalimageloader.core.ImageLoader;
import com.nostra13.universalimageloader.core.ImageLoaderConfiguration;

/**
 * Created by a on 17-6-12.
 */

public class MyApplication extends Application {

    public ImageLoaderConfiguration mImageLoader;

    public static MyApplication mIntance;

    @Override
    public void onCreate() {
        super.onCreate();
        mIntance = this;
        ImageLoaderConfiguration imageLoaderConfiguration = ImageLoaderConfiguration.createDefault(this);
        ImageLoader.getInstance().init(imageLoaderConfiguration);

    }

    public static MyApplication getIntance() {
        if (mIntance == null) {
            synchronized (MyApplication.class) {
                while (mIntance == null) {
                    try {
                        Thread.sleep(200);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }
        return mIntance;
    }
}
