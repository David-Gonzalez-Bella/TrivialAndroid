package com.example.loltrivial;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RadioButton;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link FragmentoPregunta#newInstance} factory method to
 * create an instance of this fragment.
 */
public class FragmentoPregunta extends Fragment {

    public ArrayList<Pregunta> preguntas;
    public TextView enunciado;
    public RadioButton r1;
    public RadioButton r2;
    public RadioButton r3;
    public RadioButton r4;


    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public FragmentoPregunta() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment FragmentoPregunta.
     */
    // TODO: Rename and change types and number of parameters
    public static FragmentoPregunta newInstance(String param1, String param2) {
        FragmentoPregunta fragment = new FragmentoPregunta();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }
    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        enunciado= view.findViewById(R.id.enunciado2);
        r1= view.findViewById(R.id.respuesta1);
        r2= view.findViewById(R.id.respuesta2);
        r3= view.findViewById(R.id.respuesta3);
        r4= view.findViewById(R.id.respuesta4);

        preguntas = ListaPreguntas.INSTANCE.getPreguntas();

        enunciado.setText(preguntas.get(Jugar.preguntaId).getPregunta());
        r1.setText(preguntas.get(Jugar.preguntaId).getOpcion1());
        r2.setText(preguntas.get(Jugar.preguntaId).getOpcion2());
        r3.setText(preguntas.get(Jugar.preguntaId).getOpcion3());
        r4.setText(preguntas.get(Jugar.preguntaId).getOpcion4());
    }
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_fragmento_pregunta, container, false);
    }
}