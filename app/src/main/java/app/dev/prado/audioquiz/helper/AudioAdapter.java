package app.dev.prado.audioquiz.helper;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import app.dev.prado.audioquiz.R;

public class AudioAdapter extends ArrayAdapter<String> {

    public AudioAdapter(Context context, String[] quizzes) {
        super(context, R.layout.list_item_custom ,quizzes);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        LayoutInflater inflater = LayoutInflater.from(getContext());
        View customView = inflater.inflate(R.layout.list_item_custom, parent, false);

        String singleQuiz = getItem(position);
        TextView textList = (TextView) customView.findViewById(R.id.tv_list_quiz);

        textList.setText(singleQuiz);

        return customView;
    }
}
