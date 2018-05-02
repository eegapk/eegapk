package net.itss.kahm.eegappv3;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONObject;

public class LoginActivity extends AppCompatActivity implements View.OnClickListener,Response.Listener<JSONObject>,Response.ErrorListener {

    Button btnLogin, btnBorrar;
    EditText etUsuario, etClave, etIdDoc;
    StringBuilder conexion;
    boolean res;

    RequestQueue request;
    JsonObjectRequest jsonRequest;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        btnLogin = (Button) findViewById(R.id.btnLogin);
        btnBorrar = (Button) findViewById(R.id.btnBorrar);
        etUsuario = (EditText) findViewById(R.id.etUsuario);
        etIdDoc = (EditText) findViewById(R.id.etDocId);
        etClave = (EditText) findViewById(R.id.etPass);

        request= Volley.newRequestQueue(getApplicationContext());

        btnBorrar.setOnClickListener(this);
        btnLogin.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {

        switch (view.getId()){
            case R.id.btnLogin:
                /*if (etUsuario.getText().toString().equals("")&& etClave.getText().toString().equals("")) {
                    Toast.makeText(this, "Ingrese Usuario y Clave para continuar", Toast.LENGTH_SHORT).show();
                }else {
                    Intent vistaD=new Intent(LoginActivity.this,DoctorViewActivity.class);
                    vistaD.putExtra("nombre",etUsuario.getText().toString());
                    startActivity(vistaD);
                }*/

                cargarWebService();
                break;
            case R.id.btnBorrar:
                etUsuario.setText("");
                etClave.setText("");
                etIdDoc.setText("");
                break;
            default:
                break;
        }

    }

    private void cargarWebService() {
        String url="http://eegapk.000webhostapp.com/login_doctor.php?"+
                "nombre="+etUsuario.getText().toString()+
                "&clave="+etClave.getText().toString()+
                "&id_doctor="+etIdDoc.getText().toString();

        jsonRequest= new JsonObjectRequest(Request.Method.GET,url,null,this,this);
        request.add(jsonRequest);
    }

    @Override
    public void onErrorResponse(VolleyError error) {
        Toast.makeText(this,"Usuario no existe en Base de Datos",Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onResponse(JSONObject response) {

        JSONArray json=response.optJSONArray("clave");
        JSONObject jsonObject=null;

            Intent vistaD=new Intent(LoginActivity.this,DoctorViewActivity.class);
            vistaD.putExtra("nombre",etUsuario.getText().toString());
            startActivity(vistaD);
        //Toast.makeText(this,"Usuario existe",Toast.LENGTH_SHORT).show();

    }
}
