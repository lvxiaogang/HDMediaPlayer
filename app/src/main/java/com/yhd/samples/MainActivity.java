package com.yhd.samples;

import android.app.Activity;
import android.os.Bundle;
import android.os.Handler;
import android.util.Log;
import android.view.SurfaceView;
import android.view.View;

import com.yhd.hdmediaplayer.MediaPlayerHelper;

public class MainActivity extends Activity {
    private static final String TAG="MainActivity";
    private final static String URL="http://file.xjkb.com/group1/M00/00/1A/eEzdEFh8Z-mAQdc6AcR3DvBgTPU994.mp4";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        new Handler().post(new Runnable() {
            @Override
            public void run() {
                MediaPlayerHelper.getInstance().setSurfaceView((SurfaceView)findViewById(R.id.surfaceView)).playAsset(MainActivity.this,"test.mp3");
            }
        });
    }

    protected void onEditClick(View v){
        if(v.getId()==R.id.urlButton){
            MediaPlayerHelper.getInstance().play(URL);
        }else if(v.getId()==R.id.assetsMP3Button){
            MediaPlayerHelper.getInstance().playAsset(MainActivity.this,"test.mp3");
        }else if(v.getId()==R.id.assetsMP4Button){
            MediaPlayerHelper.getInstance().playAsset(MainActivity.this,"test.mp4");
        }
    }

    protected void onStart(){
        super.onStart();
        MediaPlayerHelper.getInstance().setProgressInterval(1000).setMediaPlayerHelperCallBack(new MediaPlayerHelper.MediaPlayerHelperCallBack() {
            @Override
            public void onCallBack(MediaPlayerHelper.CallBackState state, MediaPlayerHelper mediaPlayerHelper, Object... args) {
                Log.v(TAG,"--"+state.toString());
                if(state== MediaPlayerHelper.CallBackState.PROGRESS){
                    int percent=(int)args[0];
                    Log.v(TAG,"--progress:"+percent);
                }
            }
        });
    }

    protected void onStop(){
        super.onStop();
        if(MediaPlayerHelper.getInstance().getMediaPlayer()!=null){
            MediaPlayerHelper.getInstance().getMediaPlayer().stop();
        }
    }

    protected void onDestroy(){
        super.onDestroy();
        MediaPlayerHelper.getInstance().release();
    }
}
