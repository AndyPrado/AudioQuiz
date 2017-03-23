package app.dev.prado.audioquiz.activities;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.SeekBar;

import app.dev.prado.audioquiz.R;

public class PlayerActivity extends AppCompatActivity {
    private ImageView bannerPlayer;
    private SeekBar seekBar;
    private Button btnPlay;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_player);

        bannerPlayer = (ImageView) findViewById(R.id.imgBannerPlayer);
        seekBar = (SeekBar) findViewById(R.id.seekBar);
        btnPlay = (Button) findViewById(R.id.btnPlayPause);
    }
}
