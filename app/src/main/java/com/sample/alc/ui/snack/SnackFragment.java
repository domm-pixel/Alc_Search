package com.sample.alc.ui.snack;

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

public class SnackFragment extends Fragment {

    private SnackViewModel snackViewModel;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        snackViewModel =
                ViewModelProviders.of(this).get(SnackViewModel.class);
        View root = inflater.inflate(R.layout.fragment_season, container, false);
        final TextView textView = root.findViewById(R.id.text_gallery);
        snackViewModel.getText().observe(getViewLifecycleOwner(), new Observer<String>() {
            @Override
            public void onChanged(@Nullable String s) {
                textView.setText(s);
            }
        });
        return root;
    }
}