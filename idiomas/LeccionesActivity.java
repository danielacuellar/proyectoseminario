package com.example.idiomas;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.loopj.android.http.AsyncHttpClient;
import com.loopj.android.http.AsyncHttpResponseHandler;

import org.json.JSONArray;

import java.io.BufferedInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.net.URLConnection;
import java.util.ArrayList;
import java.util.List;

import com.example.idiomas.CustomListViewAdapter;

public class LeccionesActivity extends Activity{


    ListView lstLecciones;
    public static String resp;
    private AsyncHttpClient cliente;
    int nivelId;
    Usuarios usuariosId;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lecciones);
        lstLecciones = findViewById(R.id.lstLecciones);

        cliente = new AsyncHttpClient();
        nivelId = getIntent().getIntExtra("Nivel",100);
        usuariosId = new Usuarios();
        obtenerLecciones();

        lstLecciones.setOnItemClickListener(new AdapterView.OnItemClickListener(){
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Lecciones item = (Lecciones) adapterView.getItemAtPosition(i);

                Intent intent = new Intent(getApplicationContext(),EjerciciosActivity.class);
                intent.putExtra("Leccion", item.getId());
                intent.putExtra("Nivel", nivelId);
                //based on item add info to intent
                startActivity(intent);
            }

        });

    }

    private void obtenerLecciones(){
        String url = "http://192.168.1.4/android/lecciones.php?IdNivel=" + nivelId;
        cliente.post(url, new AsyncHttpResponseHandler() {
            @Override
            public void onSuccess(int statusCode, cz.msebera.android.httpclient.Header[] headers, byte[] responseBody) {
                if(statusCode == 200){
                    listarLecciones(new String(responseBody));
                }
            }

            @Override
            public void onFailure(int statusCode, cz.msebera.android.httpclient.Header[] headers, byte[] responseBody, Throwable error) {

            }
        });
    }

    private void listarLecciones(String respuesta){
        final ArrayList<Lecciones> lista = new ArrayList <Lecciones> ();
        try{
            JSONArray jsonArreglo = new JSONArray(respuesta);
            for(int i=0;i<jsonArreglo.length();i++){
                Lecciones p = new Lecciones();
                p.setId(jsonArreglo.getJSONObject(i).getInt("IdLeccion"));
                p.setNombre(jsonArreglo.getJSONObject(i).getString("NombreLeccion"));
                p.setContador(jsonArreglo.getJSONObject(i).getInt("Contador"));
                p.setImagen(jsonArreglo.getJSONObject(i).getString("Imagen"));
                lista.add(p);

           }

           ArrayAdapter<Lecciones> a = new ArrayAdapter(this,android.R.layout.simple_list_item_1,lista);
           lstLecciones.setAdapter(a);

           // CustomListViewAdapter adapter = new CustomListViewAdapter(this, R.layout.fila_lecciones, lista);
           // lstLecciones.setAdapter(adapter);


        }catch(Exception e){
            e.printStackTrace();
        }
    }



}