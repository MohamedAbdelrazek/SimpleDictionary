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

/**
 * A simple {@link Fragment} subclass.
 */
public class NumberFragment extends Fragment {
    private ListView numberListView;
    private ArrayList<Word> words;
    private MediaPlayer mediaPlayer;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,Bundle savedInstanceState) {

        View rootView = inflater.inflate(R.layout.activity_words, container, false);

        words = new ArrayList<>();

        words.add(new Word("unum", "One", R.drawable.number_one, R.raw.one));
        words.add(new Word("duo", "Two", R.drawable.number_two, R.raw.two));
        words.add(new Word("tribus", "Three", R.drawable.number_three, R.raw.three));
        words.add(new Word("quattuor", "Four", R.drawable.number_four, R.raw.four));
        words.add(new Word("quinque", "Five", R.drawable.number_five, R.raw.five));
        words.add(new Word("sex", "Six", R.drawable.number_six, R.raw.six));
        words.add(new Word("Septem", "Seven", R.drawable.number_seven, R.raw.seven));
        words.add(new Word("Octo", "Eight", R.drawable.number_eight, R.raw.eight));
        words.add(new Word("Novem", "Nine", R.drawable.number_nine, R.raw.nine));
        words.add(new Word("decem", "Ten", R.drawable.number_ten, R.raw.ten));


        WordAdapter adapter = new WordAdapter(getActivity(), words, R.color.category_numbers);
        numberListView = (ListView) rootView.findViewById(R.id.number_list_view);
        numberListView.setAdapter(adapter);
        numberListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
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
