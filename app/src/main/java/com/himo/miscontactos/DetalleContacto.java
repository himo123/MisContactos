package com.himo.miscontactos;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.widget.TextView;

public class DetalleContacto extends AppCompatActivity {

    private TextView tvNombreContacto;
    private TextView tvTelefonoContacto;
    private TextView tvEmailContacto;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detalle_contacto);

        Bundle parametros = getIntent().getExtras();
        String nombre = parametros.getString(getResources().getString(R.string.pnombre));
        String telefono = parametros.getString(getResources().getString(R.string.ptelefono));
        String email = parametros.getString(getResources().getString(R.string.pemail));

        tvNombreContacto = findViewById(R.id.tvNombreContacto);
        tvTelefonoContacto = findViewById(R.id.tvTelefonoContacto);
        tvEmailContacto = findViewById(R.id.tvEmailContacto);

        tvNombreContacto.setText(nombre);
        tvTelefonoContacto.setText(telefono);
        tvEmailContacto.setText(email);
    }

    public void llamar(View v) {
        String telefono = tvTelefonoContacto.getText().toString();
        if (ActivityCompat.checkSelfPermission(this, Manifest.permission.CALL_PHONE) != PackageManager.PERMISSION_GRANTED) {
            // TODO: Consider calling
            //    ActivityCompat#requestPermissions
            // here to request the missing permissions, and then overriding
            //   public void onRequestPermissionsResult(int requestCode, String[] permissions,
            //                                          int[] grantResults)
            // to handle the case where the user grants the permission. See the documentation
            // for ActivityCompat#requestPermissions for more details.
            return;
        }
        startActivity(new Intent(Intent.ACTION_CALL, Uri.parse("tel:" + telefono)));
    }

    public void mandarMail(View v){
        String email = tvEmailContacto.getText().toString();
        Intent emailIntento = new Intent(Intent.ACTION_SENDTO);
        emailIntento.setData(Uri.parse("mailto:"));
        emailIntento.putExtra(Intent.EXTRA_EMAIL, email);
        emailIntento.setType("message/rfc822");
        startActivity(Intent.createChooser(emailIntento, "Enviar correo"));
    }

    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if (keyCode == KeyEvent.KEYCODE_BACK) {
            Intent intentoMain = new Intent(DetalleContacto.this, MainActivity.class);
            startActivity(intentoMain);
        }
        return super.onKeyDown(keyCode, event);
    }
}