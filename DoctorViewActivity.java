package net.itss.kahm.eegappv3;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class DoctorViewActivity extends AppCompatActivity implements View.OnClickListener {

    Button btnPacientes,btnConsultas;
    TextView NombreD;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_doctor_view);

        btnPacientes=(Button)findViewById(R.id.btnVerPacientes);
        btnConsultas=(Button) findViewById(R.id.btnVerConsul);
        NombreD=(TextView)findViewById(R.id.tvNUsuD);

        btnConsultas.setOnClickListener(this);
        btnPacientes.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.btnVerPacientes:
                Intent verPaciente = new Intent(DoctorViewActivity.this,VerPacientesActivity.class);
                startActivity(verPaciente);
                break;
            case R.id.btnVerConsul:
                Intent verConsultas = new Intent(DoctorViewActivity.this,VerPacientesActivity.class);
                startActivity(verConsultas);
                break;
        }
    }
}
