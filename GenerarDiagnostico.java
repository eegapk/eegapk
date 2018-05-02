package net.itss.kahm.eegappv3;

import android.content.DialogInterface;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONObject;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class GenerarDiagnostico extends AppCompatActivity implements View.OnClickListener,Response.Listener<JSONObject>,Response.ErrorListener{

    Button btnDiag;
    Spinner spPacientes;
    EditText etDiag, etFirma;

    RequestQueue request;
    JsonObjectRequest jsonRequest;

    String id_paciente="1";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_generar_diagnostico);

        btnDiag = (Button) findViewById(R.id.btnSubirDiag);
        etDiag = (EditText) findViewById(R.id.txdiagnostico);
        etFirma = (EditText) findViewById(R.id.txfirma);
        spPacientes = (Spinner) findViewById(R.id.spPacienteDiag);

        String[] opcpaciente= {"Elige un Paciente","Luis Ochoa","Paula Agudelo","Albin Goncalves"};
        spPacientes.setAdapter(new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, opcpaciente));

        btnDiag.setOnClickListener(this);
        request= Volley.newRequestQueue(getApplicationContext());
        

    }


    @Override
    public void onClick(View view) {
        if(view.getId()==R.id.btnSubirDiag){

            /*AlertDialog.Builder dialogo1 = new AlertDialog.Builder(this);
            dialogo1.setTitle("Importante");
            dialogo1.setMessage("Problemas de comunicacion con 00WebHost intente mas tarde");
            dialogo1.setCancelable(false);
            dialogo1.setPositiveButton("Confirmar", new DialogInterface.OnClickListener() {
                public void onClick(DialogInterface dialogo1, int id) {
                    aceptar();
                }
            });
            dialogo1.setNegativeButton("Cancelar", new DialogInterface.OnClickListener() {
                public void onClick(DialogInterface dialogo1, int id) {
                    cancelar();
                }
            });
            dialogo1.show();*/
            paciente();
            cargarWebService();

            
        }
    }

    private void cargarWebService() {

        Date date = new Date();
        DateFormat hourFormat = new SimpleDateFormat("HH:mm:ss");
        DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd");


        String url="https://eegapk.000webhostapp.com/cargar_diagnostico.php?+"+
                "id_doctor=1"+
                "&id_paciente="+id_paciente+
                "&diagnostico="+etDiag.getText().toString()+
                "&fecha="+dateFormat.format(date)+
                "&firma="+etFirma.getText().toString();

        Log.d("fecha",dateFormat.format(date));



        jsonRequest= new JsonObjectRequest(Request.Method.GET,url.replace(" ","%20"),null,this,this);
        request.add(jsonRequest);
        Log.d("url",url);
    }

    public void aceptar() {
        Toast t=Toast.makeText(this,"En cuanto se logre Conectar con el servidor se cargara su diagnostico", Toast.LENGTH_SHORT);
        t.show();
    }

    public void cancelar() {
        finish();
    }


    @Override
    public void onErrorResponse(VolleyError error) {

        Toast.makeText(this,"Error al insertar Diagnostico",Toast.LENGTH_SHORT).show();

    }

    @Override
    public void onResponse(JSONObject response) {

        Toast.makeText(this,"Diagnostico Ingresado",Toast.LENGTH_SHORT).show();

    }


    public String paciente(){

        spPacientes.setOnItemSelectedListener( new AdapterView.OnItemSelectedListener() {
            public void onItemSelected(AdapterView<?> parent,
                                       View v, int position, long id) {
                if (parent.getItemAtPosition(position).equals("Paula Agudelo")) {
                        id_paciente="1";
                }
                else if (parent.getItemAtPosition(position).equals("Albin Goncalvez")) {
                        id_paciente="3";
                }
                else if (parent.getItemAtPosition(position).equals("Luis Ochoa")) {
                        id_paciente="2";
                }
                else if (parent.getItemAtPosition(position).equals("Elige un Paciente")) {
                    Toast.makeText(getApplicationContext(),"Debe Elegir un Paciente",Toast.LENGTH_SHORT).show();

                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });
        return id_paciente;
    }
}
