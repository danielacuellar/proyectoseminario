package com.example.idiomas;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
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

import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.HashMap;
import java.util.Map;

public class RegisterActivity extends AppCompatActivity {
    EditText edtNombre, edtApellido,edtCorreo, edtUsuario, edtPassword;
    Button btnNuevoUsuario;
    public static Usuarios p;
    private AsyncHttpClient cliente;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        edtNombre = findViewById(R.id.edtNombre);
        edtApellido = findViewById(R.id.edtApellido);
        edtCorreo = findViewById(R.id.edtCorreo);
        edtUsuario = findViewById(R.id.edtUsuario);
        edtPassword = findViewById(R.id.edtPassword);

        btnNuevoUsuario = findViewById(R.id.btnNuevoUsuario);
        cliente = new AsyncHttpClient();
        p= new Usuarios();


        btnNuevoUsuario.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ValidarRegistro( "http://192.168.1.4/android/Ingresar_Usuario.php");
            }
        });
    }


    private void ValidarRegistro(String URL){
        StringRequest stringRequest = new StringRequest(Request.Method.POST, URL, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                if(!response.equals("1")){
                    validarUsuario( "http://192.168.1.4/android/validar_usuario.php");
                    Intent intent = new Intent(getApplicationContext(), PrincipalActivity.class);
                    startActivity(intent);
                }else{
                    Toast.makeText( RegisterActivity.this, "Error al guardar la informacion", Toast.LENGTH_SHORT).show();
                }

            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Toast.makeText(RegisterActivity.this, error.toString(), Toast.LENGTH_SHORT).show();

            }
        }){
            @Override
            protected Map<String, String> getParams() throws AuthFailureError {
                Map<String,String> parametros =  new HashMap<String,String>();
                parametros.put( "nombre",edtNombre.getText().toString());
                parametros.put( "apellido",edtApellido.getText().toString());
                parametros.put( "correo",edtCorreo.getText().toString());
                parametros.put( "usuario",edtUsuario.getText().toString());
                parametros.put( "password",getMd5(edtPassword.getText().toString()));
                return parametros;
            }
        };

        RequestQueue requestQueue = Volley.newRequestQueue(this);
        requestQueue.add(stringRequest);
    }


    private void validarUsuario(String URL){
        StringRequest stringRequest = new StringRequest(Request.Method.POST, URL, new Response.Listener<String>() {


            @Override
            public void onResponse(String response) {
                ListarUsuario(response);

            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {

            }
        }){
            @Override
            protected Map<String, String> getParams() throws AuthFailureError {
                Map<String,String> parametros =  new HashMap<String,String>();
                parametros.put( "usuario",edtUsuario.getText().toString());
                parametros.put( "password",getMd5(edtPassword.getText().toString()));
                return parametros;
            }
        };

        cliente.post(URL, new AsyncHttpResponseHandler() {
                    @Override
                    public void onSuccess(int statusCode, cz.msebera.android.httpclient.Header[] headers, byte[] responseBody) {
                        if(statusCode == 200){
                            ListarUsuario(new String(responseBody));
                        }
                    }

                    @Override
                    public void onFailure(int statusCode, cz.msebera.android.httpclient.Header[] headers, byte[] responseBody, Throwable error) {

                    }
                }

        );


        RequestQueue requestQueue = Volley.newRequestQueue(this);
        requestQueue.add(stringRequest);
    }
    private void ListarUsuario(String respuesta){

        try{
            if(!respuesta.equals("[]")){
                JSONArray jsonArreglo = new JSONArray(respuesta);


                p.setId(jsonArreglo.getJSONObject(0).getInt("id"));
                p.setNombre(jsonArreglo.getJSONObject(0).getString("NombreUsuario"));
                p.setApellido(jsonArreglo.getJSONObject(0).getString("ApellidoUsuario"));
                Toast.makeText( RegisterActivity.this, "Bienvenido: "+ p.getNombre()+ " "+p.getApellido()+"", Toast.LENGTH_SHORT).show();

            }



        }catch(Exception e){
            e.printStackTrace();
        }
    }

    public static String getMd5(String input)
    {
        try {

            // Static getInstance method is called with hashing MD5
            MessageDigest md = MessageDigest.getInstance("MD5");

            // digest() method is called to calculate message digest
            //  of an input digest() return array of byte
            byte[] messageDigest = md.digest(input.getBytes());

            // Convert byte array into signum representation
            BigInteger no = new BigInteger(1, messageDigest);

            // Convert message digest into hex value
            String hashtext = no.toString(16);
            while (hashtext.length() < 32) {
                hashtext = "0" + hashtext;
            }
            return hashtext;
        }

        // For specifying wrong message digest algorithms
        catch (NoSuchAlgorithmException e) {
            throw new RuntimeException(e);
        }
    }
}