package com.rakibofc.viewmodeltest;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.TextView;

public class OuterFragment extends Fragment {

    private TextPass text;

    public OuterFragment(TextPass text) {
        this.text = text;
    }

    public OuterFragment() {

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View rootView = inflater.inflate(R.layout.fragment_outer, container, false);
        TextView textView = rootView.findViewById(R.id.text_view_outer);

        TextPassViewModel viewModel = new ViewModelProvider(requireActivity()).get(TextPassViewModel.class);

        viewModel.getTextPassLiveData().observe(getViewLifecycleOwner(), textPass -> {

            if (text == null) {
                Log.d("TAG", "=============OuterFragment Null=============");

            } else {
                Log.d("TAG", "===========OuterFragment Not Null===========");
            }

            textView.setText("Outer Top: " + text.getText());

            Fragment fragment = new InnerFragment(text);
            requireActivity().getSupportFragmentManager().beginTransaction()
                    .replace(R.id.fragment_container_outer, fragment)
                    .addToBackStack(null) // Optional: Add transaction to back stack
                    .commit();

        });

        viewModel.setTextPassLiveData(text);

        return rootView;
    }
}