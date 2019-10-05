package com.example.zoo.ui.crear;

import android.database.sqlite.SQLiteAbortException;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;

import com.example.zoo.R;
import com.example.zoo.sqlite;

public class CrearFragment extends Fragment {


    private CrearViewModel CrearViewModel;

    Spinner clasificacion, sexo, especie;
    EditText name, habitat, food, date_on, id_animal;
    Button btnlimpiar, btncancelar;
    String a, b, c;
    public com.example.zoo.sqlite sqlite;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        CrearViewModel =
                ViewModelProviders.of(this).get(CrearViewModel.class);
        View root = inflater.inflate(R.layout.fragment_crear, container, false);
        final TextView textView = root.findViewById(R.id.text_crear);
        CrearViewModel.getText().observe(this, new Observer<String>() {
            @Override
            public void onChanged(@Nullable String s) {
                textView.setText(s);
            }
        });

        id_animal = root.findViewById(R.id.ET2_FM1_CREAR_ID);
        clasificacion = root.findViewById(R.id.SP1_FM1_CLASIFICACION);
        especie = root.findViewById(R.id.SP2_FM1_ESPECIE);
        name = root.findViewById(R.id.ET1_FM1_CREAR_NOMBREANIMAL);
        sexo = root.findViewById(R.id.SP3_FM1_SEXO);
        date_on = root.findViewById(R.id.ET3_FM1_FECHAINGRESO);
        habitat = root.findViewById(R.id.ET4_FM1_HABITAT);
        food = root.findViewById(R.id.ET5_FM1_ALIMENTACION);

        btnlimpiar = root.findViewById(R.id.BT1_FM1_LIMPIAR);
        btncancelar = root.findViewById(R.id.BT1_FM1_GUARDAR);

        sqlite = new sqlite(getContext());
        sqlite.openDB();

        final ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(
                getContext(),R.array.opcion, android.R.layout.simple_spinner_item
        );

        clasificacion.setAdapter(adapter);
        clasificacion.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                String opc = String.valueOf(clasificacion.getSelectedItemId());
                int op = Integer.parseInt(opc);
                System.out.println(opc);
                if(op == 0){

                }

                if(op == 1) {
                    final ArrayAdapter<CharSequence> adapter1 = ArrayAdapter.createFromResource(getContext(), R.array.o1, android.R.layout.simple_spinner_item);
                    especie.setAdapter(adapter1);
                    a = adapter.getItem(1).toString();
                    especie.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {

                        @Override
                        public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                            String opc2 = String.valueOf(especie.getSelectedItemId());
                        }

                        @Override
                        public void onNothingSelected(AdapterView<?> adapterView) {

                        }
                    });
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });

        return root;
    }
}