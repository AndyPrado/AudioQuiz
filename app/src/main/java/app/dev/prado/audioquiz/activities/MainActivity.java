package app.dev.prado.audioquiz.activities;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import app.dev.prado.audioquiz.R;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void openAudiosActivity(View v){

        Intent intent = new Intent(MainActivity.this, AudiosActivity.class);
        intent.putExtra("TAG", v.getTag().toString());
        startActivity(intent);
    }
}
