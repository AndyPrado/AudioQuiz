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
    private int audioId;
    private int[] audios = new int[4];
    private String currentQuiz;

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
                audioId = audios[position];
                currentQuiz = quizzes[position];
                openPlayer();
            }
        });

        //manage the tag received and load the correct picture to each tag
        Intent intent = getIntent();
        tag = intent.getStringExtra("TAG");
        manageTag(tag);
    }

    public void manageTag(String tag){

        switch (tag) {
            case "c1 Adults":
                banner.setImageResource(R.drawable.c1adults);
                audios[0] = R.raw.q1_c1_adult;
                audios[1] = R.raw.q2_c1_adult;
                audios[2] = R.raw.q3_c1_adult;
                audios[3] = R.raw.q4_c1_adult;
                break;
            case "c2 Adults":
                banner.setImageResource(R.drawable.c2adults);
                audios[0] = R.raw.q1_c2_adults;
                audios[1] = R.raw.q2_c2_adults;
                audios[2] = R.raw.q3_c2_adults;
                audios[3] = R.raw.q4_c2_adults;
                break;
            case "c1 Teens":
                banner.setImageResource(R.drawable.c1teens);
                audios[0] = R.raw.q1_c1_teens;
                audios[1] = R.raw.q2_c1_teens;
                audios[2] = R.raw.q3_c1_teens;
                audios[3] = R.raw.q4_c1_teens;
                break;
            case "c2 Teens":
                banner.setImageResource(R.drawable.c2teens);
                audios[0] = R.raw.q1_c2_teens;
                audios[1] = R.raw.q2_c2_teens;
                audios[2] = R.raw.q3_c2_teens;
                audios[3] = R.raw.q4_c2_teens;
                break;
            case "s1 Adults":
                banner.setImageResource(R.drawable.s1adults);
                audios[0] = R.raw.q1_s1_adult;
                audios[1] = R.raw.q2_s1_adult;
                audios[2] = R.raw.q3_s1_adult;
                audios[3] = R.raw.q4_s1_adult;
                break;
            case "s2 Adults":
                banner.setImageResource(R.drawable.s2adults);
                audios[0] = R.raw.q1_s2_adult;
                audios[1] = R.raw.q2_s2_adult;
                audios[2] = R.raw.q3_s2_adult;
                audios[3] = R.raw.q4_s2_adult;
                break;
            case "s1 Teens":
                banner.setImageResource(R.drawable.s1teens);
                audios[0] = R.raw.q1_s1_teens;
                audios[1] = R.raw.q2_s1_teens;
                audios[2] = R.raw.q3_s1_teens;
                audios[3] = R.raw.q4_s1_teens;
                break;
            case "s2 Teens":
                banner.setImageResource(R.drawable.s2teens);
                audios[0] = R.raw.q1_s2_teens;
                audios[1] = R.raw.q2_s2_teens;
                audios[2] = R.raw.q3_s2_teens;
                audios[3] = R.raw.q4_s2_teens;
                break;
            case "a1 Adults":
                banner.setImageResource(R.drawable.a1adults);
                audios[0] = R.raw.q1_a1_adult;
                audios[1] = R.raw.q2_a1_adult;
                audios[2] = R.raw.q3_a1_adult;
                audios[3] = R.raw.q4_a1_adult;
                break;
            case "a2 Adults":
                banner.setImageResource(R.drawable.a2adults);
                audios[0] = R.raw.q1_a2_adult;
                audios[1] = R.raw.q2_a2_adult;
                audios[2] = R.raw.q3_a2_adult;
                audios[3] = R.raw.q4_a2_adult;
                break;
            case "a1 Teens":
                banner.setImageResource(R.drawable.a1teens);
                audios[0] = R.raw.q1_a1_teens;
                audios[1] = R.raw.q2_a1_teens;
                audios[2] = R.raw.q3_a1_teens;
                audios[3] = R.raw.q4_a1_teens;
                break;
            case "a2 Teens":
                banner.setImageResource(R.drawable.a2teens);
                audios[0] = R.raw.q1_a2_teens;
                audios[1] = R.raw.q2_a2_teens;
                audios[2] = R.raw.q3_a2_teens;
                audios[3] = R.raw.q4_a2_teens;
                break;
        }
    }

    public void openPlayer(){

        Intent i = new Intent(AudiosActivity.this, PlayerActivity.class);
        i.putExtra("AUDIO_FILE", audioId);
        i.putExtra("TAG", currentQuiz);
        startActivity(i);
    }
}
