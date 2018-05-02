package net.itss.kahm.eegappv3;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.Toast;

import net.itss.kahm.eegappv3.Adapter.AdapterOriginal;
import net.itss.kahm.eegappv3.entidades.OriginalEEG;

import java.util.ArrayList;


public class VerEEGOriginal extends AppCompatActivity {
    ArrayList<OriginalEEG>ImgOriginal;
    RecyclerView recyclerViewEEg;
    Spinner  opcPacientes;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ver_eegoriginal);

        ImgOriginal=new ArrayList<>();
        recyclerViewEEg=(RecyclerView) findViewById(R.id.rvEEGOriginal);
        opcPacientes=(Spinner)findViewById(R.id.spEEGOriginal);
        recyclerViewEEg.setLayoutManager(new LinearLayoutManager(this));



        String[] opcpaciente= {"Elige un Paciente","Luis Ochoa","Paula Agudelo","Albin Goncalves"};

        opcPacientes.setAdapter(new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, opcpaciente));
        opcPacientes.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                Toast.makeText(adapterView.getContext(),(String)adapterView.getItemAtPosition(i),Toast.LENGTH_SHORT).show();
                if(adapterView.getItemAtPosition(i).equals("Luis Ochoa")){
                    Toast.makeText(adapterView.getContext(),"No posee Analisis EEG en base de datos",
                            Toast.LENGTH_SHORT).show();
                    borrarEEG();
                    AdapterOriginal adapterOriginal = new AdapterOriginal(ImgOriginal);
                    recyclerViewEEg.setAdapter(adapterOriginal);
                }
                if(adapterView.getItemAtPosition(i).equals("Albin Goncalves")){
                    Toast.makeText(adapterView.getContext(),"No posee Analisis EEG en base de datos",
                            Toast.LENGTH_SHORT).show();
                    borrarEEG();
                    AdapterOriginal adapterOriginal = new AdapterOriginal(ImgOriginal);
                    recyclerViewEEg.setAdapter(adapterOriginal);

                }
                if(adapterView.getItemAtPosition(i).equals("Paula Agudelo")){
                    llenarOriginales();
                    AdapterOriginal adapterOriginal = new AdapterOriginal(ImgOriginal);
                    recyclerViewEEg.setAdapter(adapterOriginal);
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });

    }

    private void borrarEEG(){
        ImgOriginal.clear();
    }


    public void llenarOriginales(){

    }

}
