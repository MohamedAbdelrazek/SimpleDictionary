package com.mohamedabdelrazek.simpledictionary;


/**
 * Created by Mohamed on 8/20/2016.
 */
public class Word {
    private String arabicWord;
    private String englishhWord;
    private int imageResouce;
    private int soundResource;

    public Word(String arabicWord, String englishhWord, int imageResouce, int soundResource) {
        this.arabicWord = arabicWord;
        this.englishhWord = englishhWord;
        this.imageResouce = imageResouce;
        this.soundResource = soundResource;
    }

    public Word(String arabicWord, String englishhWord ) {
        this.arabicWord = arabicWord;
        this.englishhWord = englishhWord;
    }


    public Word(String arabicWord, String englishhWord, int imageResouce) {
        this.arabicWord = arabicWord;
        this.englishhWord = englishhWord;
        this.imageResouce = imageResouce;
    }

    public int getSoundResource() {
        return soundResource;
    }

    public int getImageResouce() {
        return imageResouce;
    }

    public String getArabicWord() {
        return arabicWord;
    }

    public String getEnglishhWord() {
        return englishhWord;
    }

    public boolean hasImage() {
        return true;
    }
}
