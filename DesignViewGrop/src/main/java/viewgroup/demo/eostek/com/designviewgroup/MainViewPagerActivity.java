package viewgroup.demo.eostek.com.designviewgroup;

import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.v4.app.FragmentActivity;
import android.view.KeyEvent;

public class MainViewPagerActivity extends FragmentActivity {

    private MainActivityHolder mainActivityHolder;

    private Handler mHandler = new Handler(){
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            switch (msg.what) {
                case 0:
                    break;
                case 1:
                    break;
                case 2:
                    break;

                default:
                    break;
            }
        }
    };
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.viewpager_layout);
        mainActivityHolder = new MainActivityHolder(this ,mHandler);
    }

    @Override
    protected void onResume() {
        super.onResume();
    }

    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if(keyCode == KeyEvent.KEYCODE_BACK){
            if(mainActivityHolder.isOpenedLeftMenu()){
                mainActivityHolder.closeLeftMenu();
                return true;
            }
        }
        return super.onKeyDown(keyCode, event);
    }
}
