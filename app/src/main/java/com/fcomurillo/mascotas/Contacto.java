package com.fcomurillo.mascotas;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.fcomurillo.mascotas.R;
import com.fcomurillo.mascotas.mail.GMailSender;

public class Contacto extends AppCompatActivity {

    TextView txtNombre, txtEmail, txtDescripcion;
    Button btnEnviar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_contacto);

        Toolbar miActionBar = findViewById(R.id.miActionBar);
        setSupportActionBar(miActionBar);

        txtNombre = findViewById(R.id.txtNombre);
        txtEmail = findViewById(R.id.txtEmail);
        txtDescripcion = findViewById(R.id.txtDescripcion);
        btnEnviar = findViewById(R.id.btnEnviarCorreo);

        btnEnviar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    //CAMBIAR POR TU EMAIL Y PASSWORD EN strings.xml
                    GMailSender sender = new GMailSender(getResources().getString(R.string.tucorreo), getResources().getString(R.string.tupassword));
                    sender.setMailData("Comentario",
                            "Mensaje de " + txtNombre.getText().toString() + "\n\n" + txtDescripcion.getText().toString(),
                            txtEmail.getText().toString(),
                            getResources().getString(R.string.tucorreo));

                    SendMail sm = new SendMail(Contacto.this);
                    sm.execute(sender);
                    //sm.get();
                } catch (Exception e) {
                    Log.e("SendMail", e.getMessage(), e);
                }
                /*Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("mailto:" + txtEmail.getText().toString()));
                intent.putExtra(Intent.EXTRA_SUBJECT, txtNombre.getText().toString());
                intent.putExtra(Intent.EXTRA_TEXT, txtDescripcion.getText().toString());
                startActivity(intent);
                txtEmail.setText("");
                txtNombre.setText("");
                txtDescripcion.setText("");*/
            }
        });
    }

    public void closeActivity()
    {
        finish();
    }
}
