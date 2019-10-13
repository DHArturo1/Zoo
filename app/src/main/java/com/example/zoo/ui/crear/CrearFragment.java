package com.example.zoo.ui.crear;

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
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;

import com.example.zoo.R;
import com.example.zoo.BaseDatos.sqlite;

public class CrearFragment extends Fragment {


    private CrearViewModel CrearViewModel;

    Spinner clasificacion, sexo, especie;
    EditText name, habitat, food, date_on, id_animal;
    Button btnlimpiar, btnguardar;
    String a, b, c;
    public sqlite sqlite;

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
        btnguardar = root.findViewById(R.id.BT1_FM1_GUARDAR);

        sqlite = new sqlite(getContext());
        sqlite.openDB();

        final ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(
                getContext(),R.array.opcion, android.R.layout.simple_spinner_item
        );

        clasificacion.setAdapter(adapter);
        clasificacion.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                String opcion = String.valueOf(clasificacion.getSelectedItemId());
                int op = Integer.parseInt(opcion);
                System.out.println(opcion);
                if(op == 0){

                }

                if(op == 1) {
                    final ArrayAdapter<CharSequence> adapter1 = ArrayAdapter.createFromResource(getContext(), R.array.o1, android.R.layout.simple_spinner_item);
                    especie.setAdapter(adapter1);
                    a=adapter.getItem(1).toString();
                    especie.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                        @Override
                        public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                            String opcion = String.valueOf(especie.getSelectedItemId());
                            int op = Integer.parseInt(opcion);
                            System.out.println(opcion);
                            if (op == 0){

                            }

                            if (op == 1){
                                b = adapter1.getItem(1).toString();
                                Toast.makeText(getContext(), a+" "+b, Toast.LENGTH_SHORT).show();
                            } else if (op == 2){
                                b = adapter1.getItem(2).toString();
                                Toast.makeText(getContext(), a+" "+b, Toast.LENGTH_SHORT).show();
                            } else if (op == 3){
                                b = adapter1.getItem(3).toString();
                                Toast.makeText(getContext(), a+" "+b, Toast.LENGTH_SHORT).show();
                            } else if (op == 4){
                                b = adapter1.getItem(4).toString();
                                Toast.makeText(getContext(), a+" "+b, Toast.LENGTH_SHORT).show();
                            }
                        }

                        @Override
                        public void onNothingSelected(AdapterView<?> adapterView) {

                        }
                    });
                }// Seleccion 1
                else if(op == 2) {
                    final ArrayAdapter<CharSequence> adapter1 = ArrayAdapter.createFromResource(getContext(), R.array.o2, android.R.layout.simple_spinner_item);
                    especie.setAdapter(adapter1);
                    a=adapter.getItem(2).toString();
                    especie.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                        @Override
                        public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                            String opcion = String.valueOf(especie.getSelectedItemId());
                            int op = Integer.parseInt(opcion);
                            System.out.println(opcion);
                            if (op == 0){

                            }

                            if (op == 1){
                                b = adapter1.getItem(1).toString();
                                Toast.makeText(getContext(), a+" "+b, Toast.LENGTH_SHORT).show();
                            } else if (op == 2){
                                b = adapter1.getItem(2).toString();
                                Toast.makeText(getContext(), a+" "+b, Toast.LENGTH_SHORT).show();
                            } else if (op == 3){
                                b = adapter1.getItem(3).toString();
                                Toast.makeText(getContext(), a+" "+b, Toast.LENGTH_SHORT).show();
                            } else if (op == 4){
                                b = adapter1.getItem(4).toString();
                                Toast.makeText(getContext(), a+" "+b, Toast.LENGTH_SHORT).show();
                            }
                        }

                        @Override
                        public void onNothingSelected(AdapterView<?> adapterView) {

                        }
                    });
                }//Seleccion 2
                else if(op == 3) {
                    final ArrayAdapter<CharSequence> adapter1 = ArrayAdapter.createFromResource(getContext(), R.array.o3, android.R.layout.simple_spinner_item);
                    especie.setAdapter(adapter1);
                    a=adapter.getItem(3).toString();
                    especie.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                        @Override
                        public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                            String opcion = String.valueOf(especie.getSelectedItemId());
                            int op = Integer.parseInt(opcion);
                            System.out.println(opcion);
                            if (op == 0){

                            }

                            if (op == 1){
                                b = adapter1.getItem(1).toString();
                                Toast.makeText(getContext(), a+" "+b, Toast.LENGTH_SHORT).show();
                            } else if (op == 2){
                                b = adapter1.getItem(2).toString();
                                Toast.makeText(getContext(), a+" "+b, Toast.LENGTH_SHORT).show();
                            } else if (op == 3){
                                b = adapter1.getItem(3).toString();
                                Toast.makeText(getContext(), a+" "+b, Toast.LENGTH_SHORT).show();
                            } else if (op == 4){
                                b = adapter1.getItem(4).toString();
                                Toast.makeText(getContext(), a+" "+b, Toast.LENGTH_SHORT).show();
                            }
                        }

                        @Override
                        public void onNothingSelected(AdapterView<?> adapterView) {

                        }
                    });
                }//Seleccion 3
                else if(op == 4) {
                    final ArrayAdapter<CharSequence> adapter1 = ArrayAdapter.createFromResource(getContext(), R.array.o4, android.R.layout.simple_spinner_item);
                    especie.setAdapter(adapter1);
                    a=adapter.getItem(4).toString();
                    especie.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                        @Override
                        public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                            String opcion = String.valueOf(especie.getSelectedItemId());
                            int op = Integer.parseInt(opcion);
                            System.out.println(opcion);
                            if (op == 0){

                            }

                            if (op == 1){
                                b = adapter1.getItem(1).toString();
                                Toast.makeText(getContext(), a+" "+b, Toast.LENGTH_SHORT).show();
                            } else if (op == 2){
                                b = adapter1.getItem(2).toString();
                                Toast.makeText(getContext(), a+" "+b, Toast.LENGTH_SHORT).show();
                            } else if (op == 3){
                                b = adapter1.getItem(3).toString();
                                Toast.makeText(getContext(), a+" "+b, Toast.LENGTH_SHORT).show();
                            } else if (op == 4){
                                b = adapter1.getItem(4).toString();
                                Toast.makeText(getContext(), a+" "+b, Toast.LENGTH_SHORT).show();
                            }
                        }

                        @Override
                        public void onNothingSelected(AdapterView<?> adapterView) {

                        }
                    });
                }//Seleccion 4

                final ArrayAdapter<CharSequence> adapter2 = ArrayAdapter.createFromResource(
                        getContext(), R.array.oX, android.R.layout.simple_spinner_item
                );
                sexo.setAdapter(adapter2);
                sexo.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                    @Override
                    public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                        String opcion = String.valueOf(sexo.getSelectedItemId());
                        int op = Integer.parseInt(opcion);
                        System.out.println(opcion);
                        if (op == 0){
                            c = "MACHO";
                        }else if (op == 1){
                            c = "HEMBRA";
                        }
                    }

                    @Override
                    public void onNothingSelected(AdapterView<?> adapterView) {

                    }
                });
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });

        btnguardar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(!id_animal.getText().toString().equals("") &&
                        !name.getText().toString().equals("") &&
                        !habitat.getText().toString().equals("") &&
                        !food.getText().toString().equals("")){
                    Toast.makeText(getContext(), a+" "+b+
                            " "+name.getText().toString().toUpperCase()+" "+
                            " "+c+
                            " "+date_on.getText().toString()+" "+
                            habitat.getText().toString().toUpperCase()+" "+
                            food.getText().toString().toUpperCase(), Toast.LENGTH_SHORT).show();
                    if (sqlite.addReg(Integer.parseInt(id_animal.getText().toString())
                            , a, b, name.getText().toString().toUpperCase(),c,date_on.getText().toString(),
                            habitat.getText().toString().toUpperCase(),
                            food.getText().toString().toUpperCase())){
                        Toast.makeText(getContext(), "Registro añadido", Toast.LENGTH_SHORT).show();
                        id_animal.setText("");
                        name.setText("");
                        date_on.setText("");
                        habitat.setText("");
                        food.setText("");
                        especie.setId(0);
                        clasificacion.setId(0);
                        sexo.setId(0);
                    } else {
                        Toast.makeText(getContext(),
                                "Error, Compruebe que los datos sean correctos", Toast.LENGTH_SHORT).show();
                    }
                } else {
                    Toast.makeText(getContext(), "Error, no puede haber campos vacios", Toast.LENGTH_SHORT).show();
                }
            }
        });

        return root;
    }
}