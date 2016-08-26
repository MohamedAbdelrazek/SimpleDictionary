package com.mohamedabdelrazek.simpledictionary;

import android.content.Context;
import android.support.v4.content.ContextCompat;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;


/**
 * Created by Mohamed on 8/20/2016.
 */
public class WordAdapter extends ArrayAdapter {
    private ArrayList word;
    private Context context;
    private int mRcolor;

    public WordAdapter(Context context, ArrayList<Word> list, int color) {
        super(context, 0, list);
        word = new ArrayList(list);
        this.mRcolor = color;
    }


    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View listItemView = convertView;
        if (listItemView == null) {
            listItemView = LayoutInflater.from(getContext()).inflate(
                    R.layout.number_list_items, parent, false);
        }

        View Container = listItemView.findViewById(R.id.layout_container);

        Container.setBackgroundColor(ContextCompat.getColor(getContext(), mRcolor));
        Word myWord = (Word) getItem(position);
        TextView arabicT = (TextView) listItemView.findViewById(R.id.arabic_word);
        arabicT.setText(myWord.getArabicWord());
        TextView englishT = (TextView) listItemView.findViewById(R.id.english_word);
        englishT.setText(myWord.getEnglishhWord());
        ImageView image = (ImageView) listItemView.findViewById(R.id.image);
        int imageValue = myWord.getImageResouce();

            image.setImageResource(imageValue);


        return listItemView;
    }
}
