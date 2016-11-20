package com.ss_baez.formulario;


import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.TextView;
import java.util.Calendar;


public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Get a new instance of Calendar
        final Calendar c= Calendar.getInstance();
        int year = c.get(c.YEAR);
        int month = c.get(c.MONTH);
        int dayOfMonth = c.get(c.DAY_OF_MONTH);

        //Get the widgets reference from XML layout
        final TextView tv = (TextView) findViewById(R.id.tv);
        Button btnUpdateDate = (Button) findViewById(R.id.btn_update_date);
        Button btnGetDate = (Button) findViewById(R.id.btn_get_date);
        final DatePicker dp = (DatePicker) findViewById(R.id.dp);

        //Display the DatePicker initial date
        tv.setText("Fecha de nacimiento: " + month + "/" + dayOfMonth + "/" + year);

        btnUpdateDate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                //updateDate(int year, int month, int dayOfMonth) Update the current date.
                //Here we added 1 year 2 month and 10 days with current system date
                dp.updateDate(c.get(c.YEAR) + 1, c.get(c.MONTH) + 2, c.get(c.DAY_OF_MONTH) + 10);
                tv.setText("");
            }
        });

        btnGetDate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Get the DatePicker Selected Date
                tv.setText("Fecha de nacimiento: ");
                tv.setText(tv.getText() + "" + dp.getMonth() + "/" + dp.getDayOfMonth() + "/"+dp.getYear());
                dp.updateDate(c.get(c.YEAR) + 1, c.get(c.MONTH) + 2, c.get(c.DAY_OF_MONTH) + 10);
            }
        });

        //Listener
        final EditText etNombre_completo= (EditText) findViewById(R.id.etNombre_completo);
        final EditText etTelefono       = (EditText) findViewById(R.id.etTelefono);
        final EditText etEmailAddress   = (EditText) findViewById(R.id.etEmailAddress);
        final EditText etDescripcion    = (EditText) findViewById(R.id.etDescripcion);

        Button bt_siguiente = (Button) findViewById(R.id.bt_siguiente);
        bt_siguiente.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, ConfirmarDatos.class);//Donde estoy y hacia donde quiero ir
                intent.putExtra(getResources().getString(R.string.par_nombre), etNombre_completo.getText().toString()); //Clave del parametro y su valor
                intent.putExtra(getResources().getString(R.string.par_fecha), tv.getText().toString());
                intent.putExtra(getResources().getString(R.string.par_telefono), etTelefono.getText().toString());
                intent.putExtra(getResources().getString(R.string.par_email), etEmailAddress.getText().toString());
                intent.putExtra(getResources().getString(R.string.par_descripcion), etDescripcion.getText().toString());
                startActivity(intent);
                finish();
            }
        });

        Intent intent = this.getIntent();

        String nombre2 = intent.getStringExtra(getResources().getString(R.string.par_nombre2));
        String fecha2 = intent.getStringExtra(getResources().getString(R.string.par_fecha2));
        String telefono2 = intent.getStringExtra(getResources().getString(R.string.par_telefono2));
        String email2 = intent.getStringExtra(getResources().getString(R.string.par_email2));
        String descripcion = intent.getStringExtra(getResources().getString(R.string.par_descripcion2));

        etNombre_completo.setText(nombre2);
        tv.setText(fecha2);
        etTelefono.setText(telefono2);
        etEmailAddress.setText(email2);
        etDescripcion.setText(descripcion);

    }
}
