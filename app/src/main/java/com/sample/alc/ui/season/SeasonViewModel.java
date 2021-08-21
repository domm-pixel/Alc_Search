package com.sample.alc.ui.season;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class SeasonViewModel extends ViewModel {

    private MutableLiveData<String> mText;

    public SeasonViewModel() {
        mText = new MutableLiveData<>();
        mText.setValue("계절술 화면");
    }

    public LiveData<String> getText() {
        return mText;
    }
}