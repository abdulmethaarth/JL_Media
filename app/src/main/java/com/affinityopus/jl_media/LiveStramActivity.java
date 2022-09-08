package com.affinityopus.jl_media;

import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.content.ContextCompat;

import android.app.Activity;
import android.content.pm.ActivityInfo;
import android.content.res.Configuration;
import android.graphics.drawable.ColorDrawable;
import android.os.Build;
import android.os.Bundle;
import android.view.Menu;
import android.view.OrientationEventListener;
import android.view.View;
import android.view.WindowManager;
import android.webkit.WebView;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;


public class LiveStramActivity extends Activity {

    WebView wv_web;
    TextView date_time;

    @RequiresApi(api = Build.VERSION_CODES.N)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_live_stram);

        String pattern = "E, dd MMM yyyy";
        SimpleDateFormat simpleDateFormat =new SimpleDateFormat(pattern, new Locale("en", "IN"));
        String date = simpleDateFormat.format(new Date());

        date_time = (TextView)findViewById(R.id.date_time);
        date_time.setText(date);

        wv_web=findViewById(R.id.wv_web);
        wv_web.getSettings().setLoadsImagesAutomatically(true);
        wv_web.getSettings().setJavaScriptEnabled(true);
        wv_web.setScrollBarStyle(View.SCROLLBARS_INSIDE_OVERLAY);
        wv_web.loadUrl("https://play.webvideocore.net/popplayer.php?it=62a0or6nkh0k&is_link=1&w=720&h=405&pause=1&title=JL+MEDIA+LIVE&skin=3&repeat=&brandNW=1&start_volume=34&bg_gradient1=%23ffffff&bg_gradient2=%23e9e9e9&fullscreen=1&fs_mode=2&skinAlpha=50&colorBase=%23250864&colorIcon=%23ffffff&colorHighlight=%237f54f8&direct=false&no_ctrl=&auto_hide=1&viewers_limit=0&cc_position=bottom&cc_positionOffset=70&cc_multiplier=0.03&cc_textColor=%23ffffff&cc_textOutlineColor=%23ffffff&cc_bkgColor=%23000000&cc_bkgAlpha=0.1&image=https%3A%2F%2Fmember.streamingvideoprovider.com%2Fpanel%2Fserver%2Fclip%3Fa%3DGenerateThumbnail%26clip_id%3D4264666%26size%3Dlarge&mainBg_Color=%23ffffff&aspect_ratio=16%3A9&play_button=1&play_button_style=pulsing&sleek_player=1&stretch=&auto_play=&auto_play_type=unMute&floating_player=none");

        OrientationEventListener orientationEventListener = new OrientationEventListener(LiveStramActivity.this) {
            @Override
            public void onOrientationChanged(int orientation) {
                int epsilon = 10;
                int leftLandscape = 90;
                int rightLandscape = 270;
                if(epsilonCheck(orientation, leftLandscape, epsilon) ||
                        epsilonCheck(orientation, rightLandscape, epsilon)){
                    LiveStramActivity.this.setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_SENSOR);
                }
            }

            private boolean epsilonCheck(int a, int b, int epsilon) {
                return a > b - epsilon && a < b + epsilon;
            }
        };
        orientationEventListener.enable();

    }
}