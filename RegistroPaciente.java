package net.itss.kahm.eegappv3;

import android.app.ProgressDialog;
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

import org.json.JSONObject;


public class RegistroPaciente extends AppCompatActivity implements Response.Listener<JSONObject>,Response.ErrorListener {

    Button btnCrearP;
    EditText etNombreP, etApellidoP, etCedulaP, etEdadP, etClaveP, etFechaN, etNtelP;
    ProgressDialog progreso;

    RequestQueue request2;
    JsonObjectRequest jsonObjectRequest;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registro_paciente);

        btnCrearP = (Button) findViewById(R.id.btnRegistrarP);
        etNombreP = (EditText) findViewById(R.id.etNombreP);
        etApellidoP = (EditText)findViewById(R.id.etApellidoP);
        etClaveP = (EditText) findViewById(R.id.etClaveP);
        etNtelP = (EditText) findViewById(R.id.etNTlf);
        etEdadP = (EditText) findViewById(R.id.etEdadP);
        etFechaN = (EditText) findViewById(R.id.etFechaN);
        etCedulaP = (EditText) findViewById(R.id.etCedulaP);
        request2= Volley.newRequestQueue(getApplicationContext());


        btnCrearP.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                crearPaciente();
            }
        });
    }


    private void crearPaciente() {

        String url2="http://eegapk.000webhostapp.com/registrar_paciente.php?"+
                "nombre="+etNombreP.getText().toString() +
                "&apellido="+etApellidoP.getText().toString() +
                "&cedula="+etCedulaP.getText().toString() +
                "&tlf="+etNtelP.getText().toString() +
                "&clave="+etClaveP.getText().toString() +
                "&edad="+etEdadP.getText().toString() +
                "&fecha_nacimiento="+etFechaN.getText().toString()+
                "&id_doctor=1";

        //url2=url2.replace("","%20");
        jsonObjectRequest= new JsonObjectRequest(Request.Method.GET,url2,null,this,this);
        request2.add(jsonObjectRequest);
    }

    @Override
    public void onErrorResponse(VolleyError error) {
        Toast.makeText(this,"Error al ingresar",Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onResponse(JSONObject response) {
        Toast.makeText(this,"Paciente Ingresado Exitosamente",Toast.LENGTH_SHORT).show();
        //  progreso.hide();
        etNombreP.setText("");
        etApellidoP.setText("");
        etClaveP.setText("");
        etEdadP.setText("");
        etFechaN.setText("");
        etNtelP.setText("");
        etCedulaP.setText("");
    }
}
