package app.dev.prado.audioquiz.activities;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.ListAdapter;
import android.widget.ListView;

import app.dev.prado.audioquiz.R;
import app.dev.prado.audioquiz.helper.AudioAdapter;

public class AudiosActivity extends AppCompatActivity {

    private ImageView banner;
    private ListView listView;

    private String tag;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_audios);

        banner = (ImageView) findViewById(R.id.imageViewAudio);
        listView = (ListView) findViewById(R.id.lv_audios);

        //fill the list
        final String[] quizzes = new String[]{"Quiz 1", "Quiz 2", "Quiz 3", "Quiz 4" };
        ListAdapter adapter = new AudioAdapter(this, quizzes);
        listView.setAdapter(adapter);

        //manage the list listeners
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long l) {
               //TODO handle the item click
            }
        });

        //manage the tag received and load the correct picture to each tag
        Intent intent = getIntent();
        tag = intent.getStringExtra("TAG");

        switch (tag) {
            case "c1 Adults":
                banner.setImageResource(R.drawable.c1adults);
                break;
            case "c2 Adults":
                banner.setImageResource(R.drawable.c2adults);
                break;
            case "c1 Teens":
                banner.setImageResource(R.drawable.c1teens);
                break;
            case "c2 Teens":
                banner.setImageResource(R.drawable.c2teens);
                break;
            case "s1 Adults":
                banner.setImageResource(R.drawable.s1adults);
                break;
            case "s2 Adults":
                banner.setImageResource(R.drawable.s2adults);
                break;
            case "s1 Teens":
                banner.setImageResource(R.drawable.s1teens);
                break;
            case "s2 Teens":
                banner.setImageResource(R.drawable.s2teens);
                break;
            case "a1 Adults":
                banner.setImageResource(R.drawable.a1adults);
                break;
            case "a2 Adults":
                banner.setImageResource(R.drawable.a2adults);
                break;
            case "a1 Teens":
                banner.setImageResource(R.drawable.a1teens);
                break;
            case "a2 Teens":
                banner.setImageResource(R.drawable.a2teens);
                break;
        }
    }
}
