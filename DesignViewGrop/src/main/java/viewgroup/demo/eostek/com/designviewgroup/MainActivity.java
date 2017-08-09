package viewgroup.demo.eostek.com.designviewgroup;

import android.app.Activity;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.nostra13.universalimageloader.core.DisplayImageOptions;
import com.nostra13.universalimageloader.core.ImageLoader;
import com.nostra13.universalimageloader.core.listener.SimpleImageLoadingListener;

import viewgroup.demo.eostek.com.designviewgroup.view.SingleTouchView;

public class MainActivity extends Activity implements View.OnClickListener {

    private ImageView imageView;

    private SingleTouchView mSingleTouchView;

    private BitmapDrawable mBitmapDrawable;

    private Bitmap mBitmap;

    private RecyclerView mRecyclerView;

    private Button mButton;

    private Button mButton2;

    private Button mButton4;

    private Context applicationContext = MyApplication.getIntance();


    DisplayImageOptions options = new DisplayImageOptions.Builder()
            .showImageOnLoading(R.mipmap.empty_photo)
            .cacheInMemory(true)
            .cacheOnDisk(true)
            .bitmapConfig(Bitmap.Config.RGB_565)
            .build();

    String imageUrl =
            "https://lh6.googleusercontent.com/-55osAWw3x0Q/URquUtcFr5I/AAAAAAAAAbs/rWlj1RUKrYI/s1024/A%252520Photographer.jpg";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        imageView = (ImageView) findViewById(R.id.imageview);

        mSingleTouchView = (SingleTouchView) findViewById(R.id.singletouchview);

        mButton = (Button) findViewById(R.id.button);

        mButton2 = (Button) findViewById(R.id.button2);

        mButton4 = (Button) findViewById(R.id.button4);


        setListener();

        /*ImageLoader.getInstance().loadImage(imageUrl, options, new SimpleImageLoadingListener(){
            @Override
            public void onLoadingComplete(String requestUri, View view, Object dataObject) {
                super.onLoadingComplete(requestUri, view, dataObject);
                imageView.setImageBitmap((Bitmap) dataObject);
                String className = dataObject.getClass().getName();
                Log.v("tag","className : " + className);
            }

            @Override
            public void onLoadingFailed(String requestUri, View view, FailReason failReason) {
                super.onLoadingFailed(requestUri, view, failReason);
                Log.v("tag","failReason : " + failReason.toString());
                Log.v("tag","getType : " + failReason.getType().toString());
                Log.v("tag","getCause : " + failReason.getCause());

            }


        });*/
        ImageLoader.getInstance().displayImage(imageUrl, imageView, options, new SimpleImageLoadingListener() {
            @Override
            public void onLoadingComplete(String requestUri, View view, Object dataObject) {
                super.onLoadingComplete(requestUri, view, dataObject);
                mBitmap = (Bitmap) dataObject;
                mBitmapDrawable = new BitmapDrawable(mBitmap);
                mSingleTouchView.setImageBitmap(mBitmap);
                mSingleTouchView.setVisibility(View.GONE);
            }
        });
    }


    private void setListener() {
        mButton.setOnClickListener(this);
        mButton2.setOnClickListener(this);
        mButton4.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.button:
                Intent intent = new Intent();
/*                ComponentName name =
                        new ComponentName("viewgroup.demo.eostek.com.designviewgroup","viewgroup.demo.eostek.com.designviewgroup.RecylerviewActivity");
                intent.setComponent(name);*/
                //intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                intent.setAction("com.eostek.demo.Action.recyclerview");
                startActivity(intent);
                break;
            case R.id.button2:
                Intent intent1 = new Intent();
                //intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                intent1.setAction("com.eostek.demo.Action.iconActivity");
                startActivity(intent1);
                break;
            case R.id.button4:
                Intent intent2 =new Intent(MainActivity.this,MainViewPagerActivity.class);
                startActivity(intent2);
                break;

            default:
                break;
        }
    }
}
