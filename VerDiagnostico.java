package net.itss.kahm.eegappv3;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;

import net.itss.kahm.eegappv3.Adapter.AdapterDiagnostico;
import net.itss.kahm.eegappv3.entidades.Diagnosticos;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

public class VerDiagnostico extends AppCompatActivity implements Response.Listener<JSONObject>,Response.ErrorListener{

    ArrayList<Diagnosticos>diagnosticos;

    RecyclerView recyclerDiagnostico;
    RequestQueue request;
    JsonObjectRequest jsonObjectRequest;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ver_diagnostico);
        recyclerDiagnostico = (RecyclerView) findViewById(R.id.rcDiagnostico);

        recyclerDiagnostico.setLayoutManager(new LinearLayoutManager(this));
        recyclerDiagnostico.setHasFixedSize(true);

        diagnosticos = new ArrayList<>();
        request = Volley.newRequestQueue(getApplicationContext());

        buscar_diag();

        AdapterDiagnostico adapter = new AdapterDiagnostico(diagnosticos);
        recyclerDiagnostico.setAdapter(adapter);


    }


    public void buscar_diag(){

        String url="http://eegapk.000webhostapp.com/lista_diagnostico.php";

        jsonObjectRequest= new JsonObjectRequest(Request.Method.GET,url,null,this,this);
        request.add(jsonObjectRequest);
    }


    @Override
    public void onErrorResponse(VolleyError error) {

        System.out.println();
        Log.d("Error", error.toString());

    }

    @Override
    public void onResponse(JSONObject response) {

        Diagnosticos listdiagnosticos = null;

        JSONArray json=response.optJSONArray("diagnosticos");

        try {
            for(int i=0; i<json.length();i++){
                String titulo, diagnostico,fecha;

                JSONObject jsonObject=null;
                jsonObject=json.getJSONObject(i);

                titulo=jsonObject.optString("firma");
                diagnostico=jsonObject.optString("diagnostico");
                fecha=jsonObject.optString("fecha");

                listdiagnosticos= new Diagnosticos(titulo,diagnostico, fecha);

                listdiagnosticos.setId_Paciente(jsonObject.optString("firma"));
                listdiagnosticos.setDiagnostico(jsonObject.optString("diagnostico"));
                listdiagnosticos.setFecha(jsonObject.optString("fecha"));
                diagnosticos.add(listdiagnosticos);

            }

            AdapterDiagnostico adapter = new AdapterDiagnostico(diagnosticos);
            recyclerDiagnostico.setAdapter(adapter);
        }catch (JSONException e) {
            e.printStackTrace();
        }
    }

}

