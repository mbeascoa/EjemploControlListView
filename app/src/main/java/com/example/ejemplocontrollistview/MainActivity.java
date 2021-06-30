package com.example.ejemplocontrollistview;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private String[] ciudades = { "Madrid", "Valencia", "Sevilla", "Zaragoza",
            "Malaga", "Gijón", "Palma", "Bilbao", "Alicante", "Vigo", "Lima", "Huanuco", "Amorebieta", "Pedraza", "Colmenar Viejo", "Colmenarejo"};
    private String[] habitantes = { "3233527", "797028", "702355",
            "679624", "567433", "441354", "407648", "351629",
            "334678", "297355" , "3521629", "35162324", "2223339", "2223339", "11122", "555666" };
    private TextView lblmensaje;
    private ListView lsvpantalla;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        this.lblmensaje = (TextView)findViewById(R.id.lblmensaje);
        this.lsvpantalla = (ListView)findViewById(R.id.lsvciudades);
        try {
            ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, ciudades);  //cargamos el array de ciudades
            this.lsvpantalla.setAdapter(adapter);   //ponemos en el list view el adaptar al ponerle setAdapte....ya hemos cargado las ciudades


               // queremos saber dónde he realizao un click en que fila
            this.lsvpantalla.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                @Override
                public void onItemClick(AdapterView parent, View view, int position, long id) {
                    lblmensaje.setText("La población de " + lsvpantalla.getItemAtPosition(position) + " es " + habitantes[position]);   //position devuelve un cero si se ha realizado click en la primera fila
                }
            });
        }catch (Exception ex)
        {
            lblmensaje.setText("Error: " + ex);
        }
    }
}
