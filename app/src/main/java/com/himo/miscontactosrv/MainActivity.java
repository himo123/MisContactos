package com.himo.miscontactosrv;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    ArrayList<Contacto> contactos;
    private RecyclerView listaContactos;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

/*        ArrayList<String> nombresContactos = new ArrayList<String>();
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
        }); */

        listaContactos = (RecyclerView) findViewById(R.id.rvContactos);

//        Layout para ver los contactos en forma de lista
        LinearLayoutManager llm = new LinearLayoutManager(this);
        llm.setOrientation(LinearLayoutManager.VERTICAL);
        listaContactos.setLayoutManager(llm);

//        Layout para ver los contactos en forma de grid
//        GridLayoutManager glm = new GridLayoutManager(this, 2);
//        listaContactos.setLayoutManager(glm);

        inicializarListaContactos();
        inicializarAdaptador();
    }

    public void inicializarAdaptador() {
        ContactoAdaptador adaptador = new ContactoAdaptador(contactos, this);
        listaContactos.setAdapter(adaptador);
    }

    public  void inicializarListaContactos() {
        contactos = new ArrayList<Contacto>();
        contactos.add(new Contacto(R.drawable.himo,"Hector I. Morales", "9931-65-19-81", "himo123@hotmail.com"));
        contactos.add(new Contacto(R.drawable.yuyi, "Yuridia Gonzalez", "9931-47-55-40", "yurimouse@hotmail.com"));
        contactos.add(new Contacto(R.drawable.heygo,"Grupo Heygo", "9931-40-65-09", "grupo_heygo@hotmail.com"));
        contactos.add(new Contacto(R.drawable.conchy,"Conchy Balcazar", "9933-51-13-26", "siluet_black@hotmail.com"));
        contactos.add(new Contacto(R.drawable.himo,"Ivan Daniel Morales", "9931-40-65-09", "idmg210@gmail.com"));
        contactos.add(new Contacto(R.drawable.himo,"Matias Adrian Morales", "9931-40-65-09", "matiasadrianmg12@gmail.com"));
        contactos.add(new Contacto(R.drawable.yuyi, "Mara Y. Morales", "9933002700","maraymorales@gmail.com"));
        contactos.add(new Contacto(R.drawable.yuyi, "Denisse C. Morales", "9931123456","decrymoba@hotmail.com"));
    }

}