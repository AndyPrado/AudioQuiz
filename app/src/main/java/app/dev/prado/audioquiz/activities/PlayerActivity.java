package app.dev.prado.audioquiz.activities;

import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.SeekBar;

import java.util.Timer;
import java.util.TimerTask;

import app.dev.prado.audioquiz.R;

public class PlayerActivity extends AppCompatActivity {
    private ImageView bannerPlayer;
    private SeekBar seekBar;
    private Button btnPlay;

    private MediaPlayer mPlayer;
    private String tag;
    private int idAudio;
    private boolean isPlaying = true;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_player);

        bannerPlayer = (ImageView) findViewById(R.id.imgBannerPlayer);
        seekBar = (SeekBar) findViewById(R.id.seekBar);
        btnPlay = (Button) findViewById(R.id.btnPlayPause);

        Intent i = getIntent();
        idAudio = i.getIntExtra("AUDIO_FILE", 0);
        tag = i.getStringExtra("TAG");

        manageTag(tag);

        mPlayer = MediaPlayer.create(this, idAudio);
        mPlayer.start();
        btnPlay.setBackgroundResource(R.drawable.ic_pause_circle_outline);

        seekBar.setMax(mPlayer.getDuration());

        //set the timer to follow with the audio progress
        new Timer().scheduleAtFixedRate(new TimerTask() {
            @Override
            public void run() {
                seekBar.setProgress(mPlayer.getCurrentPosition());
            }
        }, 0, 800);

        //monitors the changes of the bar
        seekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int i, boolean b) {

                if(b){
                    mPlayer.seekTo(i);
                }
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });
    }

    public void playAudio(View v){

        if(isPlaying){
            btnPlay.setBackgroundResource(R.drawable.ic_play_circle_outline);
            isPlaying = false;
            mPlayer.pause();
        }
        else{
            btnPlay.setBackgroundResource(R.drawable.ic_pause_circle_outline);
            isPlaying = true;
            mPlayer.start();
        }
    }

    public void manageTag(String tag){

        switch (tag) {
            case "Quiz 1":
                bannerPlayer.setImageResource(R.drawable.q1);
                break;
            case "Quiz 2":
                bannerPlayer.setImageResource(R.drawable.q2);
                break;
            case "Quiz 3":
                bannerPlayer.setImageResource(R.drawable.q3);
                break;
            case "Quiz 4":
                bannerPlayer.setImageResource(R.drawable.fq);
                break;
        }
    }

    @Override
    protected void onPause() {
        super.onPause();

        mPlayer.stop();
    }
}
