package net.itss.kahm.eegappv3;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;


import java.util.ArrayList;
import java.util.List;

import net.itss.kahm.eegappv3.Adapter.PacientesAdapter;
import net.itss.kahm.eegappv3.entidades.Usuarios;

public class VerPacientesActivity extends AppCompatActivity implements Response.Listener<JSONObject>,Response.ErrorListener {

    public String nombre;
    public String apellido;
    public String edad;
    ListView ListaPacientes;

    RecyclerView recyclerPacientes;
    ArrayList<Usuarios> listaPacientes;
    List<Usuarios> UsuariosList;

    RequestQueue request;
    JsonObjectRequest jsonObjectRequest;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ver_pacientes);

        listaPacientes  = new ArrayList<Usuarios>();
        recyclerPacientes= (RecyclerView) findViewById(R.id.reciclerPacientes);
        //recyclerPacientes.setLayoutManager(new LinearLayoutManager(this.getApplicationContext()));
        //recyclerPacientes.setHasFixedSize(true);
        ListaPacientes = (ListView) findViewById(R.id.listPacientes);

        ArrayList<String>vistaPacientes = new ArrayList<String>();

        String[] pacienteslist = {"Paula Agudelo edad:55 ","Albin Gponacaleves edad:27 ","Luis Ochoa edad:22 ","Prueba prueba edad:45",
                "Prueba2 prueba2 edad:25"};
        for(int i=0; i<pacienteslist.length; i++){
            vistaPacientes.add(Integer.toString(i));
        }

            ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,pacienteslist);
        ListaPacientes.setAdapter(adapter);

       // request = Volley.newRequestQueue(getApplicationContext());

        //cargarVebService();
    }

    private void cargarVebService() {

        String url="http://192.168.0.105:8080/eegserverv3/buscar_paciente.php";
        jsonObjectRequest=new JsonObjectRequest(Request.Method.GET,url,null,this,this);
         request.add(jsonObjectRequest);

    }

    public void cargarPacientes(){
        UsuariosList.add(new Usuarios());
        UsuariosList.add(new Usuarios());
        UsuariosList.add(new Usuarios());
    }

    @Override
    public void onErrorResponse(VolleyError error) {

        Toast.makeText(getApplicationContext(), "No se puede conectar "+error.toString(), Toast.LENGTH_LONG).show();
        System.out.println();
        Log.d("ERROR: ", error.toString());

    }

    @Override
    public void onResponse(JSONObject response) {

        Usuarios paciente = null;

        JSONArray json= response.optJSONArray("pacientes");
        try {
        for (int i=0;i<json.length();i++) {
            paciente = new Usuarios();
            JSONObject jsonObject = null;

            jsonObject = json.getJSONObject(i);

            paciente.setNombre(jsonObject.optString("nombre"));
            paciente.setApellido(jsonObject.optString("apellido"));
            paciente.setEdad(jsonObject.optString("edad"));
            listaPacientes.add(paciente);
        }
                PacientesAdapter adapter=new PacientesAdapter(listaPacientes);
                recyclerPacientes.setAdapter(adapter);
            } catch (JSONException e) {
                e.printStackTrace();

                e.printStackTrace();
                Toast.makeText(getApplicationContext(), "No se ha podido establecer conexión con el servidor" +
                        " "+response, Toast.LENGTH_LONG).show();
            }

        }


    public String getNombre() {
        return nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public String getEdad() {
        return edad;
    }
}
