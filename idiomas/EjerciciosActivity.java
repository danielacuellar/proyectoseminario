package com.example.idiomas;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageButton;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.loopj.android.http.AsyncHttpClient;
import com.loopj.android.http.AsyncHttpResponseHandler;

import org.json.JSONArray;

import java.io.BufferedInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.net.URLConnection;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;

public class EjerciciosActivity extends Activity {

    Ejercicios p;
    int cont = 0;
    TextView txtPregunta;
    ImageButton imgImagen1;
    ImageButton imgImagen2;
    ImageButton imgImagen3;
    ImageButton imgImagen4;
    public static String resp;
    private AsyncHttpClient cliente;
    int leccionId;
    int nivelId;
    Usuarios usuariosId;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ejercicios);
        txtPregunta = findViewById(R.id.txtPregunta);
        imgImagen1 = findViewById(R.id.imgImagen1);
        imgImagen2 = findViewById(R.id.imgImagen2);
        imgImagen3 = findViewById(R.id.imgImagen3);
        imgImagen4 = findViewById(R.id.imgImagen4);
        cliente = new AsyncHttpClient();
        leccionId = getIntent().getIntExtra("Leccion",100);
        nivelId = getIntent().getIntExtra("Nivel",100);
        usuariosId = new Usuarios();
        obtenerEjercicios();
        ObtenerContador();


        imgImagen1.setOnClickListener(new View.OnClickListener() {
            @SuppressLint("ResourceType")
            public void onClick(View v) {
                if(imgImagen1.getId() == 1) {
                    cont = p.getCont();
                    if(cont >= 10){
                        //Saltar menu de lecciones/´
                        Intent intent = new Intent(getApplicationContext(),LeccionesActivity.class);
                        intent.putExtra("Nivel", nivelId);
                        startActivity(intent);
                    }
                   txtPregunta.setText("Correcto");
                    ValidarEjercicio();
                    obtenerEjercicios();
                    ObtenerContador();
                    //MyTask bmpInf = (MyTask) new MyTask().execute("http://192.168.0.5/1.jpg","http://192.168.0.5/2.jpg", "http://192.168.0.5/3.jpg", "http://192.168.0.5/4.jpg");

                }else {
                   // txt.setText("Incorrecto 0");
                }
            }
        });

        imgImagen2.setOnClickListener(new View.OnClickListener() {
            @SuppressLint("ResourceType")
            public void onClick(View v) {
                if(imgImagen2.getId() == 1) {
                    cont = p.getCont();
                    if(cont >= 10){
                        //Saltar menu de lecciones/´
                        Intent intent = new Intent(getApplicationContext(),LeccionesActivity.class);
                        intent.putExtra("Nivel", nivelId);
                        startActivity(intent);
                    }
                    txtPregunta.setText("Correcto");
                    ValidarEjercicio();
                    obtenerEjercicios();
                    ObtenerContador();
                    //MyTask bmpInf = (MyTask) new MyTask().execute("http://192.168.0.5/1.jpg","http://192.168.0.5/2.jpg", "http://192.168.0.5/3.jpg", "http://192.168.0.5/4.jpg");

                }else {
                    // txt.setText("Incorrecto 0");
                }
            }
        });

        imgImagen3.setOnClickListener(new View.OnClickListener() {
            @SuppressLint("ResourceType")
            public void onClick(View v) {
                if(imgImagen3.getId() == 1) {
                    cont = p.getCont();
                    if(cont >= 10){
                        //Saltar menu de lecciones/´
                        Intent intent = new Intent(getApplicationContext(),LeccionesActivity.class);
                        intent.putExtra("Nivel", nivelId);
                        startActivity(intent);
                    }
                    txtPregunta.setText("Correcto");
                    ValidarEjercicio();
                    obtenerEjercicios();
                    ObtenerContador();
                    //MyTask bmpInf = (MyTask) new MyTask().execute("http://192.168.0.5/1.jpg","http://192.168.0.5/2.jpg", "http://192.168.0.5/3.jpg", "http://192.168.0.5/4.jpg");

                }else {
                    // txt.setText("Incorrecto 0");
                }
            }
        });

        imgImagen4.setOnClickListener(new View.OnClickListener() {
            @SuppressLint("ResourceType")
            public void onClick(View v) {
                if(imgImagen4.getId() == 1) {
                    cont = p.getCont();
                    if(cont >= 10){
                        //Saltar menu de lecciones/´
                        Intent intent = new Intent(getApplicationContext(),LeccionesActivity.class);
                        intent.putExtra("Nivel", nivelId);
                        startActivity(intent);
                    }
                    txtPregunta.setText("Correcto");
                    ValidarEjercicio();
                    obtenerEjercicios();
                    ObtenerContador();
                    //MyTask bmpInf = (MyTask) new MyTask().execute("http://192.168.0.5/1.jpg","http://192.168.0.5/2.jpg", "http://192.168.0.5/3.jpg", "http://192.168.0.5/4.jpg");

                }else {
                    // txt.setText("Incorrecto 0");
                }
            }
        });

    }

    private void ValidarEjercicio(){
        String URL = "http://192.168.1.4/android/Ingresar_Resultado.php" ;
        StringRequest stringRequest = new StringRequest(Request.Method.POST, URL, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {


            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Toast.makeText(EjerciciosActivity.this, error.toString(), Toast.LENGTH_SHORT).show();

            }
        }){
            @Override
            protected Map<String, String> getParams() throws AuthFailureError {
                Map<String,String> parametros =  new HashMap<String,String>();
                parametros.put( "IdEjercicio",p.getId()+"");
                parametros.put("IdUsuario", usuariosId.getId()  +"" );
                return parametros;
            }
        };

        RequestQueue requestQueue = Volley.newRequestQueue(this);
        requestQueue.add(stringRequest);
    }





    private void obtenerEjercicios(){
        String url = "http://192.168.1.4/android/ejercicios.php?id=" + leccionId;
        cliente.post(url, new AsyncHttpResponseHandler() {
            @Override
            public void onSuccess(int statusCode, cz.msebera.android.httpclient.Header[] headers, byte[] responseBody) {
                if(statusCode == 200){
                    listarEjercicios(new String(responseBody));
                }
            }

            @Override
            public void onFailure(int statusCode, cz.msebera.android.httpclient.Header[] headers, byte[] responseBody, Throwable error) {

            }
        });
    }

    private void listarEjercicios(String respuesta){
       try{
            JSONArray jsonArreglo = new JSONArray(respuesta);
            p = new Ejercicios();
            p.setId(jsonArreglo.getJSONObject(0).getInt("IdEjercicio"));
            p.setPregunta(jsonArreglo.getJSONObject(0).getString("Pregunta"));
            p.setRespuesta(jsonArreglo.getJSONObject(0).getString("Respuesta"));

            p.setImagen1(jsonArreglo.getJSONObject(0).getString("Imagen1"));
            p.setImagen2(jsonArreglo.getJSONObject(0).getString("Imagen2"));
            p.setImagen3(jsonArreglo.getJSONObject(0).getString("Imagen3"));
            p.setImagen4(jsonArreglo.getJSONObject(0).getString("Imagen4"));

            txtPregunta.setText(p.getPregunta()+" "+p.getRespuesta()+" "+ cont);
           MyTask bmpInf = (MyTask) new MyTask().execute(p.getImagen1(),
                   p.getImagen2(),p.getImagen3(),p.getImagen4());



       }catch(Exception e){
            e.printStackTrace();
        }
    }


    private void ObtenerContador(){
        String url = "http://192.168.1.4/android/Obtener_Resultados.php?IdLeccion=" + leccionId+"&IdUsuario=" + usuariosId.getId()  +"";
        cliente.post(url, new AsyncHttpResponseHandler() {
            @Override
            public void onSuccess(int statusCode, cz.msebera.android.httpclient.Header[] headers, byte[] responseBody) {
                if(statusCode == 200){
                    listarContador(new String(responseBody));
                }
            }

            @Override
            public void onFailure(int statusCode, cz.msebera.android.httpclient.Header[] headers, byte[] responseBody, Throwable error) {

            }
        });
    }

    private void listarContador(String respuesta){
        try{
            JSONArray jsonArreglo = new JSONArray(respuesta);
            p = new Ejercicios();
            p.setCont(jsonArreglo.getJSONObject(0).getInt("Cont"));


        }catch(Exception e){
            e.printStackTrace();
        }
    }

    private class MyTask extends AsyncTask<String, Void, String> {
        Bitmap bm = null;
        Bitmap bm2 = null;
        Bitmap bm3 = null;
        Bitmap bm4 = null;
        @Override
        protected String doInBackground(String... params) {
            String url = params[0];
            String url2 = params[1];
            String url3 = params[2];
            String url4 = params[3];
            //url = "http://192.168.0.5/1.jpg";
            for(int x = 0; x <=3; x++){
                try {
                    URL aURL = null;
                    if (x==0)
                        aURL = new URL(url);
                    if (x==1)
                        aURL = new URL(url2);
                    if (x==2)
                        aURL = new URL(url3);
                    if (x==3)
                        aURL = new URL(url4);
                    //URL aURL = new URL("file:"+url);
                    URLConnection conn = aURL.openConnection();

                    conn.connect();
                    InputStream is = conn.getInputStream();
                    BufferedInputStream bis = new BufferedInputStream(is);
                    if (x==0)
                        bm = BitmapFactory.decodeStream(bis);
                    else if (x==1)
                        bm2 = BitmapFactory.decodeStream(bis);
                    else if (x==2)
                        bm3 = BitmapFactory.decodeStream(bis);
                    else if (x==3)
                        bm4 = BitmapFactory.decodeStream(bis);
                    //img.setImageBitmap(bm);
                    //txt.setText("s " + bm);
                    bis.close();
                    is.close();
                } catch (IOException e) {
                    Log.e("Erroooorrrr", "Error getting bitmap", e);
                    //txt.setText(e + " errrrorororor");
                }
            }



            //Toast.makeText(getApplicationContext(), "back", Toast.LENGTH_SHORT).show();
            return url;
        }

        @SuppressLint("ResourceType")
        @Override
        protected void onPostExecute(String result) {
            super.onPostExecute(result);
            //txt.setText(result + " exe");
            ArrayList<Bitmap> bmRan = new ArrayList<Bitmap>();
            Random rand = new Random();
            bmRan.add(bm);
            bmRan.add(bm2);
            bmRan.add(bm3);
            bmRan.add(bm4);
            for(int x = 0; x<=3; x++){
                int nran = rand.nextInt(bmRan.size());
                if(x == 0){
                    if(bmRan.get(nran).equals(bm)) {
                        imgImagen1.setId(1);
                    }else {
                        imgImagen1.setId(2);
                    }
                    imgImagen1.setImageBitmap(bmRan.remove(nran));
                }
                else if(x == 1) {
                    if(bmRan.get(nran).equals(bm)) {
                        imgImagen2.setId(1);
                    }else {
                        imgImagen2.setId(2);
                    }

                    imgImagen2.setImageBitmap(bmRan.remove(nran));
                }else if(x == 2) {
                    if(bmRan.get(nran).equals(bm)) {
                        imgImagen3.setId(1);
                    }else {
                        imgImagen3.setId(2);
                    }

                    imgImagen3.setImageBitmap(bmRan.remove(nran));
                }else if(x == 3) {
                    if(bmRan.get(nran).equals(bm)) {
                        imgImagen4.setId(1);
                    }else {
                        imgImagen4.setId(2);
                    }

                    imgImagen4.setImageBitmap(bmRan.remove(nran));
                }
            }
            //img2.setImageBitmap(bm2);
            // img3.setImageBitmap(bm3);
            // img4.setImageBitmap(bm4);
            // do something with result
        }
    }
}