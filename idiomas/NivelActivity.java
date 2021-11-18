package com.example.idiomas;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.ProgressBar;

import com.loopj.android.http.AsyncHttpClient;
import com.loopj.android.http.AsyncHttpResponseHandler;

import org.json.JSONArray;

import java.util.ArrayList;

public class NivelActivity extends AppCompatActivity {

    ProgressBar pgbNiveles;
    ListView lstNiveles;
    public static String resp;
    private AsyncHttpClient cliente;
    int idiomaId;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_nivel);
        lstNiveles = findViewById(R.id.lstNiveles);
        cliente = new AsyncHttpClient();
        idiomaId = getIntent().getIntExtra("Idioma",100);
        obtenerNiveles();

        lstNiveles.setOnItemClickListener(new AdapterView.OnItemClickListener(){
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Niveles item = (Niveles) adapterView.getItemAtPosition(i);

                Intent intent = new Intent(getApplicationContext(),LeccionesActivity.class);
                intent.putExtra("Nivel", item.getId());
                //based on item add info to intent
                startActivity(intent);
            }

        });

        //ProgressBar Basico =(ProgressBar)findViewById(R.id.progressBarNivel);
        //Basico.setMax(100);
        //Basico.setProgress(50);
        // 50 default
    }

    private void obtenerNiveles(){
        String url = "http://192.168.1.4/android/niveles.php?id=" + idiomaId;
        cliente.post(url, new AsyncHttpResponseHandler() {
            @Override
            public void onSuccess(int statusCode, cz.msebera.android.httpclient.Header[] headers, byte[] responseBody) {
                if(statusCode == 200){
                    listarNiveles(new String(responseBody));
                }
            }

            @Override
            public void onFailure(int statusCode, cz.msebera.android.httpclient.Header[] headers, byte[] responseBody, Throwable error) {

            }
        });
    }

    private void listarNiveles(String respuesta){
        final ArrayList<Niveles> lista = new ArrayList <Niveles> ();
        try{
            JSONArray jsonArreglo = new JSONArray(respuesta);
            for(int i=0;i<jsonArreglo.length();i++){
                Niveles p = new Niveles();
                Niveles x = new Niveles();
                p.setId(jsonArreglo.getJSONObject(i).getInt("IdNivel"));
                p.setNombre(jsonArreglo.getJSONObject(i).getString("NombreNivel"));
                p.setPorcentaje((float) jsonArreglo.getJSONObject(i).getDouble("Porcentaje"));

                lista.add(p);


            }

            ArrayAdapter<Niveles> a = new ArrayAdapter(this,android.R.layout.simple_list_item_1,lista);
            lstNiveles.setAdapter(a);


        }catch(Exception e){
            e.printStackTrace();
        }
    }
}