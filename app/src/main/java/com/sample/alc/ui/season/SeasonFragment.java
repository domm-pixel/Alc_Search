package com.sample.alc.ui.season;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;

import com.sample.alc.R;

public class SeasonFragment extends Fragment {

    private SeasonViewModel seasonViewModel;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        seasonViewModel =
                ViewModelProviders.of(this).get(SeasonViewModel.class);
        View root = inflater.inflate(R.layout.fragment_snack, container, false);
        final TextView textView = root.findViewById(R.id.text_slideshow);
        seasonViewModel.getText().observe(getViewLifecycleOwner(), new Observer<String>() {
            @Override
            public void onChanged(@Nullable String s) {
                textView.setText(s);
            }
        });
        return root;
    }
}