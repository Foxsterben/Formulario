package com.ss_baez.formulario;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.view.KeyEvent;
import android.widget.TextView;

public class ConfirmarDatos extends AppCompatActivity {

    private TextView tv_nombreContacto;
    private TextView tv_fechaContacto;
    private TextView tv_telContacto;
    private TextView tv_emailContacto;
    private TextView tv_descripcionContacto;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_confirmar_datos);

        tv_nombreContacto = (TextView) findViewById(R.id.tv_nombreContacto);
        tv_fechaContacto = (TextView) findViewById(R.id.tv_fechaContacto);
        tv_telContacto = (TextView) findViewById(R.id.tv_telContacto);
        tv_emailContacto = (TextView) findViewById(R.id.tv_emailContacto);
        tv_descripcionContacto = (TextView) findViewById(R.id.tv_descripcionContacto);

        Intent intent = this.getIntent();

        //Aqui se cachan los datos que manda el MainActivity
        String nombre = intent.getStringExtra(getResources().getString(R.string.par_nombre));
        String fecha = intent.getStringExtra(getResources().getString(R.string.par_fecha));
        String telefono = intent.getStringExtra(getResources().getString(R.string.par_telefono));
        String email = intent.getStringExtra(getResources().getString(R.string.par_email));
        String descripcion = intent.getStringExtra(getResources().getString(R.string.par_descripcion));


        //Se asignan lo que se obtuvo del parametro
        tv_nombreContacto.setText(nombre);
        tv_fechaContacto.setText(fecha);
        tv_telContacto.setText(telefono);
        tv_emailContacto.setText(email);
        tv_descripcionContacto.setText(descripcion);

        //Listener
        Button btn_editar = (Button) findViewById(R.id.btn_editar);
        btn_editar.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                Intent intent = new Intent(ConfirmarDatos.this, MainActivity.class);
                intent.putExtra(getResources().getString(R.string.par_nombre2), tv_nombreContacto.getText().toString());
                intent.putExtra(getResources().getString(R.string.par_fecha2), tv_fechaContacto.getText().toString());
                intent.putExtra(getResources().getString(R.string.par_telefono2), tv_telContacto.getText().toString());
                intent.putExtra(getResources().getString(R.string.par_email2), tv_emailContacto.getText().toString());
                intent.putExtra(getResources().getString(R.string.par_descripcion), tv_descripcionContacto.getText().toString());
                startActivity(intent);
            }
        });

    }

    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event){

        if (keyCode == KeyEvent.KEYCODE_BACK){
            Intent intent = new Intent (ConfirmarDatos.this, MainActivity.class);
            startActivity(intent);
        }
        return super.onKeyDown(keyCode, event);
    }

}
