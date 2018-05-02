package net.itss.kahm.eegappv3;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Spinner;
import android.widget.ArrayAdapter;
import android.widget.Toast;

import net.itss.kahm.eegappv3.Adapter.AdapterEEG;
import net.itss.kahm.eegappv3.entidades.ImagenEEg;

import java.util.ArrayList;

public class VerEEGActivity extends AppCompatActivity {

    ArrayList<ImagenEEg>EEGimg;
    RecyclerView recyclerViewEEg;
    Spinner opcCanal, opcPaciente;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ver_eeg);


        EEGimg = new ArrayList<>();
        recyclerViewEEg= (RecyclerView) findViewById(R.id.rvEEG);
        opcCanal=(Spinner) findViewById(R.id.canales);
        opcPaciente=(Spinner)findViewById(R.id.pacienteseeg);
        recyclerViewEEg.setLayoutManager(new LinearLayoutManager(this));


        String[] opccanal= {"Elige una opcion","1","2","3","4",
                "5", "6", "7", "8", "9","10","11","12","13","14","15","16","18"};
        String[] opcpaciente= {"Elige un Paciente","Luis Ochoa","Paula Agudelo","Albin Goncalves"};

        opcPaciente.setAdapter(new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, opcpaciente));
        opcCanal.setAdapter(new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, opccanal));

        opcPaciente.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                Toast.makeText(adapterView.getContext(),(String)adapterView.getItemAtPosition(i),Toast.LENGTH_SHORT).show();
                if(adapterView.getItemAtPosition(i).equals("Luis Ochoa")){
                    Toast.makeText(adapterView.getContext(),"No posee Analisis EEG en base de datos",
                            Toast.LENGTH_SHORT).show();
                    borrarEEG();
                    AdapterEEG adapterEEG= new AdapterEEG(EEGimg);
                    recyclerViewEEg.setAdapter(adapterEEG);
                }
                if(adapterView.getItemAtPosition(i).equals("Albin Goncalves")){
                    Toast.makeText(adapterView.getContext(),"No posee Analisis EEG en base de datos",
                            Toast.LENGTH_SHORT).show();
                    borrarEEG();
                    AdapterEEG adapterEEG= new AdapterEEG(EEGimg);
                    recyclerViewEEg.setAdapter(adapterEEG);
                }
                if(adapterView.getItemAtPosition(i).equals("Paula Agudelo")){
                    Toast.makeText(adapterView.getContext(),"Ahora seleccione un canal",
                            Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });

        opcCanal.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {

            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int pos, long l) {
                if(adapterView.getItemAtPosition(pos).equals("1")){
                    llenarEEG();
                    AdapterEEG adapterEEG= new AdapterEEG(EEGimg);
                    recyclerViewEEg.setAdapter(adapterEEG);
                }
                if(adapterView.getItemAtPosition(pos).equals("2")){
                    llenarEEGCanal2();
                    AdapterEEG adapterEEG= new AdapterEEG(EEGimg);
                    recyclerViewEEg.setAdapter(adapterEEG);
                }
                if(adapterView.getItemAtPosition(pos).equals("3")){
                    llenarEEGCanal3();
                    AdapterEEG adapterEEG= new AdapterEEG(EEGimg);
                    recyclerViewEEg.setAdapter(adapterEEG);
                }
                if(adapterView.getItemAtPosition(pos).equals("4")){
                    llenarEEGCanal4();
                    AdapterEEG adapterEEG= new AdapterEEG(EEGimg);
                    recyclerViewEEg.setAdapter(adapterEEG);
                }
                if(adapterView.getItemAtPosition(pos).equals("5")){
                    llenarEEGCanal5();
                    AdapterEEG adapterEEG= new AdapterEEG(EEGimg);
                    recyclerViewEEg.setAdapter(adapterEEG);
                }
                if(adapterView.getItemAtPosition(pos).equals("6")){
                    llenarEEGCanal6();
                    AdapterEEG adapterEEG= new AdapterEEG(EEGimg);
                    recyclerViewEEg.setAdapter(adapterEEG);
                }
                if(adapterView.getItemAtPosition(pos).equals("7")){
                    llenarEEGCanal7();
                    AdapterEEG adapterEEG= new AdapterEEG(EEGimg);
                    recyclerViewEEg.setAdapter(adapterEEG);
                }
                if(adapterView.getItemAtPosition(pos).equals("8")){
                    llenarEEGCanal8();
                    AdapterEEG adapterEEG= new AdapterEEG(EEGimg);
                    recyclerViewEEg.setAdapter(adapterEEG);
                }
                if(adapterView.getItemAtPosition(pos).equals("9")){
                    llenarEEGCanal9();
                    AdapterEEG adapterEEG= new AdapterEEG(EEGimg);
                    recyclerViewEEg.setAdapter(adapterEEG);
                }
                if(adapterView.getItemAtPosition(pos).equals("10")){
                    llenarEEGCanal10();
                    AdapterEEG adapterEEG= new AdapterEEG(EEGimg);
                    recyclerViewEEg.setAdapter(adapterEEG);
                }
                if(adapterView.getItemAtPosition(pos).equals("11")){
                    llenarEEGCanal11();
                    AdapterEEG adapterEEG= new AdapterEEG(EEGimg);
                    recyclerViewEEg.setAdapter(adapterEEG);
                }
                if(adapterView.getItemAtPosition(pos).equals("12")){
                    llenarEEGCanal12();
                    AdapterEEG adapterEEG= new AdapterEEG(EEGimg);
                    recyclerViewEEg.setAdapter(adapterEEG);
                }
                if(adapterView.getItemAtPosition(pos).equals("13")){
                    llenarEEGCanal13();
                    AdapterEEG adapterEEG= new AdapterEEG(EEGimg);
                    recyclerViewEEg.setAdapter(adapterEEG);
                }
                if(adapterView.getItemAtPosition(pos).equals("14")){
                    llenarEEGCanal4();
                    AdapterEEG adapterEEG= new AdapterEEG(EEGimg);
                    recyclerViewEEg.setAdapter(adapterEEG);
                }
                if(adapterView.getItemAtPosition(pos).equals("15")){
                    llenarEEGCanal5();
                    AdapterEEG adapterEEG= new AdapterEEG(EEGimg);
                    recyclerViewEEg.setAdapter(adapterEEG);
                }
                if(adapterView.getItemAtPosition(pos).equals("16")){
                    llenarEEGCanal16();
                    AdapterEEG adapterEEG= new AdapterEEG(EEGimg);
                    recyclerViewEEg.setAdapter(adapterEEG);
                }
                if(adapterView.getItemAtPosition(pos).equals("17")){
                    llenarEEGCanal17();
                    AdapterEEG adapterEEG= new AdapterEEG(EEGimg);
                    recyclerViewEEg.setAdapter(adapterEEG);
                }
                if(adapterView.getItemAtPosition(pos).equals("18")){
                    llenarEEGCanal18();
                    AdapterEEG adapterEEG= new AdapterEEG(EEGimg);
                    recyclerViewEEg.setAdapter(adapterEEG);
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });




    }

    private void llenarEEGCanal18() {
    }

    private void llenarEEGCanal17() {
    }

    private void llenarEEGCanal16() {
    }

    private void llenarEEGCanal13() {
    }

    private void llenarEEGCanal12() {
    }

    private void llenarEEGCanal11() {
    }

    private void llenarEEGCanal10() {
    }

    private void llenarEEGCanal9() {
        EEGimg.clear();
    }

    private void llenarEEGCanal8() {
        EEGimg.clear();
    }

    private void llenarEEGCanal7() {
        EEGimg.clear();
    }

    private void llenarEEGCanal6() {


    }

    private void llenarEEGCanal4() {


    }

    private void llenarEEGCanal5(){


    }

    private void llenarEEG() {

    }

    private void llenarEEGCanal2(){

    }

    private void llenarEEGCanal3(){



    }

    private void borrarEEG(){
        EEGimg.clear();
    }
}
