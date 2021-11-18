package com.example.idiomas;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import androidx.appcompat.app.AppCompatActivity;

import com.android.volley.Header;
import com.loopj.android.http.*;

import org.json.JSONArray;

import java.io.Serializable;
import java.util.ArrayList;


public class PrincipalActivity extends AppCompatActivity {

    ListView lstIdiomas;
    public static String resp;
    private AsyncHttpClient cliente;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_principal);
        lstIdiomas = findViewById(R.id.lstIdiomas);
        cliente = new AsyncHttpClient();

        obtenerIdiomas();

        lstIdiomas.setOnItemClickListener(new AdapterView.OnItemClickListener(){
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Idioma item = (Idioma) adapterView.getItemAtPosition(i);

                Intent intent = new Intent(getApplicationContext(),NivelActivity.class);
                intent.putExtra("Idioma", item.getId());
                //based on item add info to intent
                startActivity(intent);
            }

        });



    }



    private void obtenerIdiomas(){
        String url = "http://192.168.1.4/android/Idiomas.php";
        cliente.post(url, new AsyncHttpResponseHandler() {
            @Override
            public void onSuccess(int statusCode, cz.msebera.android.httpclient.Header[] headers, byte[] responseBody) {
                if(statusCode == 200){
                    listarIdiomas(new String(responseBody));
                }
            }

            @Override
            public void onFailure(int statusCode, cz.msebera.android.httpclient.Header[] headers, byte[] responseBody, Throwable error) {

            }
        });
    }

    private void listarIdiomas(String respuesta){
        final ArrayList<Idioma> lista = new ArrayList <Idioma> ();
        try{
            JSONArray jsonArreglo = new JSONArray(respuesta);
            for(int i=0;i<jsonArreglo.length();i++){
                Idioma p = new Idioma();
                p.setId(jsonArreglo.getJSONObject(i).getInt("id"));
                p.setNombre(jsonArreglo.getJSONObject(i).getString("Nombre"));


                lista.add(p);
            }

            ArrayAdapter<Idioma> a = new ArrayAdapter(this,android.R.layout.simple_list_item_1,lista);
            lstIdiomas.setAdapter(a);


        }catch(Exception e){
            e.printStackTrace();
        }
    }
}