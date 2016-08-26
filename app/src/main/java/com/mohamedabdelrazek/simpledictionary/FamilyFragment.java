package com.mohamedabdelrazek.simpledictionary;

import android.media.MediaPlayer;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;

import com.mohamedabdelrazek.simpledictionary.Word;

import java.util.ArrayList;

public class FamilyFragment extends Fragment{

    ArrayList<Word> words;
    MediaPlayer mediaPlayer;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        View rootView = inflater.inflate(R.layout.activity_words, container, false);


        words = new ArrayList<>();
        words.add(new Word("avus", "grandfather", R.drawable.family_grandfather, R.raw.grandfather));
        words.add(new Word("avia", "grandmother", R.drawable.family_grandmother, R.raw.grandmother));
        words.add(new Word("pater", "father", R.drawable.family_father, R.raw.father));
        words.add(new Word("mater", "mother", R.drawable.family_mother, R.raw.mother));
        words.add(new Word("frater", "older brother", R.drawable.family_older_brother, R.raw.olderbrother));
        words.add(new Word("frater junior", "Younger brother", R.drawable.family_younger_brother, R.raw.youngerbrother));
        words.add(new Word("senior soror", "older sister", R.drawable.family_older_sister, R.raw.oldersister));
        words.add(new Word("minorem,", "younger sister", R.drawable.family_younger_sister, R.raw.youngersister));
        words.add(new Word("filius", "son", R.drawable.family_son, R.raw.son));
        words.add(new Word("filia", "daughter", R.drawable.family_daughter, R.raw.daughter));
        WordAdapter adapter = new WordAdapter(getActivity(), words, R.color.category_family);
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

