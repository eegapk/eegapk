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


public class LoginPacienteActivity extends AppCompatActivity implements View.OnClickListener, Response.Listener<JSONObject>,Response.ErrorListener  {

    Button btnLoginP, btnBorrarP;
    EditText etUsuP, etclaveP;

    RequestQueue request;
    JsonObjectRequest jsonRequest;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login_paciente);

        etclaveP=(EditText) findViewById(R.id.etPassP);
        etUsuP=(EditText) findViewById(R.id.etUsuarioPa);
        btnLoginP=(Button) findViewById(R.id.btnLoginP);
        btnBorrarP=(Button) findViewById(R.id.btnLoginP);

        request= Volley.newRequestQueue(getApplicationContext());

        btnBorrarP.setOnClickListener(this);
        btnLoginP.setOnClickListener(this);
    }


    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.btnLoginP:
                cargarWebService();
              break;

            case R.id.btnBorrarP:
                etUsuP.setText("");
                etclaveP.setText("");
                break;
        }
    }

    private void cargarWebService() {

        String url="http://eegapk.000webhostapp.com/login_paciente.php?"+
                "nombre="+etUsuP.getText().toString()+
                "&clave="+etclaveP.getText().toString();

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

        Intent int0= new Intent(LoginPacienteActivity.this,PacienteViewActivity.class);
        int0.putExtra("nombre", etUsuP.getText().toString());
        startActivity(int0);

    }
}
