package com.himo.miscontactosrv;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class ContactoAdaptador extends RecyclerView.Adapter<ContactoAdaptador.ContactoViewHolder> {

ArrayList<Contacto> contactos;
Activity activity;

    public ContactoAdaptador(ArrayList<Contacto> contactos, Activity activity) {
        this.contactos = contactos;
        this.activity = activity;
    }

    public static class ContactoViewHolder extends RecyclerView.ViewHolder {
        private ImageView imgFoto;
        private ImageButton btnLike;
        private TextView tvNombreCV;
        private TextView tvTelefonoCV;
        private TextView tvEmailCV;

        public ContactoViewHolder(@NonNull View itemView) {
            super(itemView);
            imgFoto       = (ImageView) itemView.findViewById(R.id.imgFoto);
            btnLike       = (ImageButton) itemView.findViewById(R.id.btnLike);
            tvNombreCV    = (TextView) itemView.findViewById(R.id.tvNombreCV);
            tvTelefonoCV  = (TextView) itemView.findViewById(R.id.tvTelefonoCV);
            tvEmailCV     = (TextView) itemView.findViewById(R.id.tvEmailCV);
        }
    }

    @NonNull  @Override  //Inflar el layout y los pasa al ViewHolder para que obtenga los views
    public ContactoViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflar = LayoutInflater.from(parent.getContext());
        View elemento = inflar.inflate(R.layout.cardview_contacto, parent, false);
        return new ContactoViewHolder(elemento);
    }

    @Override  //asocia cada elemento de la lista con cada view
    public void onBindViewHolder(@NonNull ContactoViewHolder holder, int position) {
        final Contacto contacto = contactos.get(position);
        holder.imgFoto.setImageResource(contacto.getFoto());
        holder.tvNombreCV.setText(contacto.getNombre());
        holder.tvTelefonoCV.setText(contacto.getTelefono());
        holder.tvEmailCV.setText(contacto.getEmail());

        holder.imgFoto.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intento = new Intent(activity, DetalleContacto.class);
                intento.putExtra(activity.getResources().getString(R.string.pnombre), contacto.getNombre());
                intento.putExtra(activity.getResources().getString(R.string.ptelefono), contacto.getTelefono());
                intento.putExtra(activity.getResources().getString(R.string.pemail), contacto.getEmail());
                activity.startActivity(intento);
            }
        });

        holder.btnLike.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(activity, "Diste like a " + contacto.getNombre(), Toast.LENGTH_SHORT).show();
            }
        });
    }

    @Override
    public int getItemCount() {  //Cantidad de elementos que contiene la lista
        return contactos.size();
    }

}
