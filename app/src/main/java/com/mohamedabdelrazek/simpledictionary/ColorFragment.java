package com.mohamedabdelrazek.simpledictionary;

import android.media.MediaPlayer;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.ArrayList;

public class ColorFragment extends Fragment {
    ArrayList<Word> words;
    MediaPlayer mediaPlayer;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        View rootView = inflater.inflate(R.layout.activity_words, container, false);


        words = new ArrayList<>();
        words.add(new Word("alba", "white", R.drawable.color_white, R.raw.white));
        words.add(new Word("nigrum", "black", R.drawable.color_black, R.raw.black));
        words.add(new Word("flavum", "yellow", R.drawable.color_mustard_yellow, R.raw.yellow));
        words.add(new Word("viride", "green", R.drawable.color_green, R.raw.green));
        words.add(new Word("Brown", "brown", R.drawable.color_brown, R.raw.brown));
        words.add(new Word("red", "red", R.drawable.color_red, R.raw.red));
        words.add(new Word("gray", "gray", R.drawable.color_gray, R.raw.gray));
        WordAdapter adapter = new WordAdapter(getActivity(), words, R.color.category_colors);
        ListView familyListView = (ListView) rootView.findViewById(R.id.number_list_view);
        familyListView.setAdapter(adapter);
        familyListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                if (mediaPlayer != null) {
                    mediaPlayer.release();
                    mediaPlayer = null;
                }
                mediaPlayer = MediaPlayer.create(getActivity(), words.get(position).getSoundResource());

                mediaPlayer.start();
                mediaPlayer.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
                    @Override
                    public void onCompletion(MediaPlayer mp) {


                        if (mediaPlayer != null) {
                            mediaPlayer.release();
                            mediaPlayer = null;
                        }


                    }


                });
            }


        });


        return rootView;
    }
}
