package com.himo.miscontactos;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    ArrayList<Contacto> contactos;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        contactos = new ArrayList<Contacto>();

        contactos.add(new Contacto("Hector Morales", "9931-65-19-81", "himo123@hotmail.com"));
        contactos.add(new Contacto("Yuridia Gonzalez", "9931-47-55-40", "yurimouse@hotmail.com"));
        contactos.add(new Contacto("Grupo Heygo", "9931-40-65-09", "grupo_heygo@hotmail.com"));
        contactos.add(new Contacto("Conchy Balcazar", "9933-51-13-26", "siluet_black@hotmail.com"));

        ArrayList<String> nombresContactos = new ArrayList<String>();
        for (Contacto contacto: contactos) {
            nombresContactos.add(contacto.getNombre());
        }

        ListView lstListaContactos = findViewById(R.id.lstListaContactos);
        lstListaContactos.setAdapter(new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, nombresContactos));
        lstListaContactos.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intento = new Intent(MainActivity.this, DetalleContacto.class);
                intento.putExtra(getResources().getString(R.string.pnombre), contactos.get(position).getNombre());
                intento.putExtra(getResources().getString(R.string.ptelefono), contactos.get(position).getTelefono());
                intento.putExtra(getResources().getString(R.string.pemail), contactos.get(position).getEmail());
                startActivity(intento);
                finish();
            }
        });

    }
}