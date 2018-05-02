package net.itss.kahm.eegappv3;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.widget.Toast;

import com.android.volley.Response;
import com.android.volley.VolleyError;

import net.itss.kahm.eegappv3.Adapter.AdapterOriginal;
import net.itss.kahm.eegappv3.entidades.Usuarios;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;


public class VerTestEEGActivity extends AppCompatActivity implements Response.Listener<JSONObject>, Response.ErrorListener{

    private static final String TAG = VerTestEEGActivity.class.getSimpleName();
    public static final String SAMPLE_FILE = "PAOLA_AGUDELO.pdf";
    ArrayList<Usuarios> ImgOriginal;
    PDFView pdfView;
    Integer pageNumber = 0;
    String pdfFileName;

    RecyclerView rcvOriginal;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ver_test_eeg);

        ImgOriginal=new ArrayList<Usuarios>();
        rcvOriginal = (RecyclerView) findViewById(R.id.rvOriginales);
        displayFromAsset(SAMPLE_FILE);

        rcvOriginal.setLayoutManager(new LinearLayoutManager(this));

        llenarOriginales();
        AdapterOriginal adapterOriginal = new AdapterOriginal(ImgOriginal);
        rcvOriginal.setAdapter(adapterOriginal);
    }

    private void displayFromAsset(String sampleFile) {
    }

    public void llenarOriginales(){

    }


    @Override
    public void onResponse(JSONObject response) {
        Usuarios paciente = null;

        JSONArray json=response.optJSONArray("usuario");

        try {

            for (int i=0;i<json.length();i++){
                paciente= new Usuarios();
                JSONObject jsonObject=null;
                jsonObject=json.getJSONObject(i);

                paciente.setNombre(jsonObject.optString("nombre"));
                paciente.setApellido(jsonObject.optString("apellido"));
                paciente.setEdad(jsonObject.optString("edad"));
                paciente.setRutaImagen(jsonObject.optString("ruta_imagen"));
                ImgOriginal.add(paciente);
            }


        } catch (JSONException e) {
            e.printStackTrace();
            Toast.makeText(this, "No se ha podido establecer conexión con el servidor" +
                    " "+response, Toast.LENGTH_LONG).show();
        }
    }

    @Override
    public void onErrorResponse(VolleyError error) {
        Toast.makeText(this, "No se puede conectar "+error.toString(), Toast.LENGTH_LONG).show();
        System.out.println();
        Log.d("ERROR: ", error.toString());
    }



}
