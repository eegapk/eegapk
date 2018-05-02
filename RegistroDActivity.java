package net.itss.kahm.eegappv3;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
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

import org.json.JSONObject;

public class RegistroDActivity extends AppCompatActivity implements Response.Listener<JSONObject>,Response.ErrorListener{

    Button btnRDoctor;
    EditText etNombreD,etApellidoD,etCedulaD,etNTlfPD,etNtlfOD,etEmailD,etClaveD,etEspD, etCrede;
    String IdDoc;

    RequestQueue request;
    JsonObjectRequest jsonRequest;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registro_d);

        btnRDoctor = (Button) findViewById(R.id.btnRegistrarD);
        etNombreD = (EditText)  findViewById(R.id.etNombreD);
        etApellidoD = (EditText) findViewById(R.id.etApellidoD);
        etCedulaD = (EditText) findViewById(R.id.etCedulaD);
        etClaveD = (EditText) findViewById(R.id.etClave);
        etEmailD = (EditText)findViewById(R.id.etEmail);
        etEspD = (EditText) findViewById(R.id.etEspecialidaD);
        etNtlfOD = (EditText) findViewById(R.id.etNTlfO);
        etNTlfPD = (EditText)findViewById(R.id.etNTlfPD);
        etCrede = (EditText) findViewById(R.id.etIdDoc);


        request= Volley.newRequestQueue(getApplicationContext());

        btnRDoctor.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                cargarWebService();

            }
        });

    }

    private void cargarWebService() {

        //IdDoc=etNombreD.getText().toString().substring(0,4)+etCrede.getText().toString().substring(4,8);
        String url="http://eegapk.000webhostapp.com/registrar_doctor.php?" +
                "nombre="+etNombreD.getText().toString()+
                "&apellido="+etApellidoD.getText().toString()+
                "&cedula="+etCedulaD.getText().toString()+
                "&tlf_personal="+etNTlfPD.getText().toString()+
                "&tlf_fijo=" +etNtlfOD.getText().toString()+
                "&especialidad="+etEspD.getText().toString()+
                "&email="+etEmailD.getText().toString() +
                "&clave="+etClaveD.getText().toString()+
                "&id_doctor="+etCrede.getText().toString();

        jsonRequest= new JsonObjectRequest(Request.Method.GET,url.replace(" ","%20"),null,this,this);
        request.add(jsonRequest);

        Log.d("url",url);

    }

    @Override
    public void onErrorResponse(VolleyError error) {
        //progreso.hide();
        Toast.makeText(this,"Doctor Ingresado Exitosamente",Toast.LENGTH_SHORT).show();
        etNombreD.setText("");
        etApellidoD.setText("");
        etClaveD.setText("");
        etEmailD.setText("");
        etEspD.setText("");
        etNtlfOD.setText("");
        etNTlfPD.setText("");
        etCedulaD.setText("");
        etCrede.setText("");


    }

    @Override
    public void onResponse(JSONObject response) {
        Toast.makeText(this,"Doctor Ingresado Exitosamente",Toast.LENGTH_SHORT).show();
      //  progreso.hide();
        etNombreD.setText("");
        etApellidoD.setText("");
        etClaveD.setText("");
        etEmailD.setText("");
        etEspD.setText("");
        etNtlfOD.setText("");
        etNTlfPD.setText("");
        etCedulaD.setText("");
        etCrede.setText("");
    }
}
