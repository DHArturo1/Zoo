package com.example.zoo.ui.eliminar;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;

import com.example.zoo.R;

public class EliminarFragment extends Fragment {

    private EliminarViewModel eliminarViewModel;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        eliminarViewModel =
                ViewModelProviders.of(this).get(EliminarViewModel.class);
        View root = inflater.inflate(R.layout.fragment_eliminar, container, false);
        final TextView textView = root.findViewById(R.id.text_eliminar);
        eliminarViewModel.getText().observe(this, new Observer<String>() {
            @Override
            public void onChanged(@Nullable String s) {
                textView.setText(s);
            }
        });
        return root;
    }
}