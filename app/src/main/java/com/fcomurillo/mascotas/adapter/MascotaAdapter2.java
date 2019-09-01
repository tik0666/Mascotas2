package com.fcomurillo.mascotas.adapter;

import android.app.Activity;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import com.fcomurillo.mascotas.R;
import com.fcomurillo.mascotas.pojo.Mascota;

import java.util.ArrayList;

public class MascotaAdapter2 extends RecyclerView.Adapter<MascotaAdapter2.ContactoViewHolder> {
    ArrayList<Mascota> contactos;
    Activity activity;

    public MascotaAdapter2(ArrayList<Mascota> contactos, Activity activity){
        this.contactos = contactos;
        this.activity = activity;
    }

    @NonNull
    //Inflar el layout y lo pasara al viewholder para que el obtenga los views
    @Override
    public ContactoViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View v = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.cardview_mascota2, viewGroup, false);
        return new ContactoViewHolder(v);
    }

    //int raking = 0;
    // valor = "";
    @Override
    //Asocia cada elemento de la lista a cada view
    public void onBindViewHolder(@NonNull final ContactoViewHolder contactoViewHolder, int i) {
        final Mascota contacto = contactos.get(i);
        contactoViewHolder.imagFoto.setImageResource(contacto.getFoto());
        //contactoViewHolder.tvNombre.setText(contacto.getNombre());
        contactoViewHolder.tvTotalHuesos.setText(String.valueOf(contacto.getCalificacion()));
    }

    @Override
    public int getItemCount() { //CANTIDAD DE ELEMENTOS QUE CONTIENE MI LISTA
        return contactos.size();
    }



    public static class ContactoViewHolder extends RecyclerView.ViewHolder{

        private ImageView imagFoto;
        //private TextView tvNombre;
        //private ImageButton btnLike;
        private TextView tvTotalHuesos;

        public ContactoViewHolder(@NonNull View itemView) {
            super(itemView);
            imagFoto = itemView.findViewById(R.id.imgFoto);
            //tvNombre = itemView.findViewById(R.id.tvNombre);
            //btnLike = itemView.findViewById(R.id.btnLike);
            tvTotalHuesos = itemView.findViewById(R.id.tvTotalHuesos);
        }
    }
}
