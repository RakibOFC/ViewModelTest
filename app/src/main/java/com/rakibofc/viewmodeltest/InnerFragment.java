package com.rakibofc.viewmodeltest;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

public class InnerFragment extends Fragment {

    private TextPass text;

    public InnerFragment() {

    }

    public InnerFragment(TextPass text) {
        this.text = text;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View rootView = inflater.inflate(R.layout.fragment_inner, container, false);

        TextView textView = rootView.findViewById(R.id.text_view_inner);

        TextPassViewModel2 viewModel = new ViewModelProvider(requireActivity()).get(TextPassViewModel2.class);

        viewModel.getTextPassLiveData().observe(getViewLifecycleOwner(), textPass -> {

            if (text == null) {
                Log.d("TAG", "=============InnerFragment Null=============");

            } else {
                textView.setText("Inner Text Updated: " + textPass.getText());
                Log.d("TAG", "===========InnerFragment Not Null===========");
            }

        });

        viewModel.setTextPassLiveData(text);
        // textView.setText("Inner Text Updated: " + text.getText());

        return rootView;
    }
}