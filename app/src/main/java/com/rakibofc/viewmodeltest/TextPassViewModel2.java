package com.rakibofc.viewmodeltest;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class TextPassViewModel2 extends AndroidViewModel {

    private MutableLiveData<TextPass> textPassLiveData;

    public TextPassViewModel2(@NonNull Application application) {
        super(application);
        textPassLiveData = new MutableLiveData<>();
    }

    public LiveData<TextPass> getTextPassLiveData() {
        return textPassLiveData;
    }

    public void setTextPassLiveData(TextPass textPass) {
        textPassLiveData.setValue(textPass);
    }
}
