package com.fcomurillo.mascotas.fragment;


import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.fcomurillo.mascotas.R;
import com.fcomurillo.mascotas.adapter.MascotaAdapter;
import com.fcomurillo.mascotas.pojo.Mascota;

import java.util.ArrayList;

public class RecyclerViewFragment extends Fragment {

    ArrayList<Mascota> contactos;
    private RecyclerView listaContactos;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.fragment_recyclerview, container, false);

        listaContactos = v.findViewById(R.id.rvContactos);

        LinearLayoutManager llm = new LinearLayoutManager(getActivity());
        llm.setOrientation(LinearLayoutManager.VERTICAL);

        //GridLayoutManager glm = new GridLayoutManager(this, 2);


        listaContactos.setLayoutManager(llm);
        inicializarListaContactos();
        inicializarAdaptador();

        return v;
    }

    public void inicializarAdaptador() {
        MascotaAdapter adaptador = new MascotaAdapter(contactos, getActivity());
        listaContactos.setAdapter(adaptador);
    }

    public void inicializarListaContactos() {
        contactos = new ArrayList<Mascota>();

        contactos.add(new Mascota(R.drawable.pet1, "Pelusa", Mascota.count1));
        contactos.add(new Mascota(R.drawable.pet2, "Pirrurris", Mascota.count2));
        contactos.add(new Mascota(R.drawable.pet3, "Minino", Mascota.count3));
        contactos.add(new Mascota(R.drawable.pet4, "Rayas", Mascota.count4));
        contactos.add(new Mascota(R.drawable.pet5, "Huesos", Mascota.count5));
        contactos.add(new Mascota(R.drawable.pet6, "Manotas", Mascota.count6));
        contactos.add(new Mascota(R.drawable.pet7, "Gatito", Mascota.count7));
        contactos.add(new Mascota(R.drawable.pet8, "Dumbo", Mascota.count8));
        contactos.add(new Mascota(R.drawable.pet9, "Ghost", Mascota.count9));
        contactos.add(new Mascota(R.drawable.pet10, "Rulo", Mascota.count10));
        contactos.add(new Mascota(R.drawable.pet11, "Currito", Mascota.count11));
        contactos.add(new Mascota(R.drawable.pet12, "Blue", Mascota.count12));
        contactos.add(new Mascota(R.drawable.pet13, "Guacamayo", Mascota.count13));
        contactos.add(new Mascota(R.drawable.pet14, "Tone", Mascota.count14));
        contactos.add(new Mascota(R.drawable.pet15, "Bola", Mascota.count15));
        contactos.add(new Mascota(R.drawable.pet16, "Erizo", Mascota.count16));
    }

}
