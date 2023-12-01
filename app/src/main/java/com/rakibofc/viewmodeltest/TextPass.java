package com.rakibofc.viewmodeltest;

import androidx.lifecycle.ViewModel;

public class TextPass extends ViewModel {

    private String text;

    public TextPass(String text) {
        this.text = text;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }
}
