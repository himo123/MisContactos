package com.himo.miscontactos;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class ContactoAdaptador {

    public static class ContactoViewHolder extends RecyclerView.ViewHolder {

        private ImageView imgFoto;
        private TextView tvNombreCV;
        private TextView tvTelefonoCV;


        public ContactoViewHolder(@NonNull View itemView) {
            super(itemView);
            imgFoto       = itemView.findViewById(R.id.imgFoto);
            tvNombreCV    = itemView.findViewById(R.id.tvNombreCV);
            tvTelefonoCV  = itemView.findViewById(R.id.tvTelefonoCV);
            //me quedé en el minuto 37:00 del video
        }
    }
}
