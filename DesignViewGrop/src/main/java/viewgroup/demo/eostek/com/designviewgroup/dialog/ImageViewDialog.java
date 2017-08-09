package viewgroup.demo.eostek.com.designviewgroup.dialog;

import android.app.Dialog;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.annotation.IntRange;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.annotation.StyleRes;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.view.Window;
import android.widget.ImageView;
import android.widget.RelativeLayout;

import com.bumptech.glide.DrawableRequestBuilder;
import com.bumptech.glide.Glide;
import com.bumptech.glide.load.resource.drawable.GlideDrawable;
import com.bumptech.glide.request.RequestListener;
import com.bumptech.glide.request.animation.GlideAnimation;
import com.bumptech.glide.request.target.SimpleTarget;
import com.bumptech.glide.request.target.Target;
import com.bumptech.glide.request.target.ViewTarget;
import com.nostra13.universalimageloader.core.DisplayImageOptions;
import com.nostra13.universalimageloader.core.ImageLoader;
import com.nostra13.universalimageloader.core.assist.FailReason;
import com.nostra13.universalimageloader.core.listener.ImageLoadingListener;

import viewgroup.demo.eostek.com.designviewgroup.R;
import viewgroup.demo.eostek.com.designviewgroup.view.RoundImageDrawable;
import viewgroup.demo.eostek.com.designviewgroup.view.SingleTouchView;

/**
 * Created by a on 17-6-28.
 */

public class ImageViewDialog extends Dialog {

    private Context mContext;

    private ImageView imageView;

    private Drawable drawable;

    private String mUrl;

    private int width = 0;

    private int height = 0;

    private DisplayImageOptions options = new DisplayImageOptions.Builder()
            .showImageOnLoading(R.mipmap.loading2)
            .cacheInMemory(false)
            .cacheOnDisk(true)
            .bitmapConfig(Bitmap.Config.RGB_565)
            .build();

    private Handler mHandler = new Handler() {
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
        }
    };


    public ImageViewDialog(@NonNull Context context, String extra) {
        super(context);
        mContext = context;
        mUrl = extra;
    }

    public ImageViewDialog(@NonNull Context context, @StyleRes int themeResId, String extra) {
        super(context, themeResId);
        mContext = context;
        mUrl = extra;
    }

    protected ImageViewDialog(@NonNull Context context, boolean cancelable, @Nullable OnCancelListener cancelListener) {
        super(context, cancelable, cancelListener);
        mContext = context;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.image_layout);
        initView();
        setListener();
    }

    private void setListener() {

    }

    @Override
    public void cancel() {
        super.cancel();
    }

    @Override
    public void dismiss() {
        super.dismiss();
    }


    private void initView() {
        imageView = (ImageView) findViewById(R.id.imageview);
        //ImageLoader.getInstance().displayImage(mUrl,imageView,options);
        Glide.with(mContext).load(mUrl)
                .asBitmap()
                .placeholder(R.mipmap.loading2)
                .into(new SimpleTarget<Bitmap>() {
                    @Override
                    public void onResourceReady(Bitmap bitmap, GlideAnimation glideAnimation) {
                        imageView.setImageDrawable(new RoundImageDrawable(bitmap));
                    }
                });
    }

    @Override
    public void show() {
        Window dialogWindow = getWindow();
        dialogWindow.setWindowAnimations(R.style.dialogWindowAnim);
        super.show();
    }
}
