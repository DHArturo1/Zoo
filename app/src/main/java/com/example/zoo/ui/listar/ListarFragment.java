package com.example.zoo.ui.listar;

import android.database.Cursor;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;

import com.example.zoo.R;
import com.example.zoo.BaseDatos.sqlite;

import java.util.ArrayList;

public class ListarFragment extends Fragment {

    private ListarViewModel listarViewModel;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        listarViewModel =
                ViewModelProviders.of(this).get(ListarViewModel.class);
        View root = inflater.inflate(R.layout.fragment_listar, container, false);
        final TextView textView = root.findViewById(R.id.text_listar);
        listarViewModel.getText().observe(this, new Observer<String>() {
            @Override
            public void onChanged(@Nullable String s) {
                textView.setText(s);
            }
        });

        ListView lista = root.findViewById(R.id.text_listar);
        sqlite sqlite = new sqlite(getContext());
        sqlite.openDB();
        Cursor cursor = sqlite.getRegister();
        ArrayList<String> reg = sqlite.getRegister();
        ArrayAdapter<String> adaptador = new ArrayAdapter<String>(getContext(), android.R.layout.simple_list_item_1, reg);
        lista.setAdapter(adaptador);
        return root;
    }
}