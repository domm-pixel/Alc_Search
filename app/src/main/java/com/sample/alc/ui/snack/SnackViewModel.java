package com.sample.alc.ui.snack;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class SnackViewModel extends ViewModel {

    private MutableLiveData<String> mText;

    public SnackViewModel() {
        mText = new MutableLiveData<>();
        mText.setValue("추천안주 화면");
    }

    public LiveData<String> getText() {
        return mText;
    }
}