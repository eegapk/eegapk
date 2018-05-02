package net.itss.kahm.eegappv3;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class RegistroActivity extends AppCompatActivity implements View.OnClickListener{

    Button btnRegistroD, btnRegistroP;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registro);

        btnRegistroD = (Button) findViewById(R.id.btnRDoctor);
        btnRegistroP = (Button) findViewById(R.id.btnRPaciente);

        btnRegistroP.setOnClickListener(this);
        btnRegistroD.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.btnRDoctor:
                Intent intRegistroD = new Intent(RegistroActivity.this,RegistroDActivity.class);
                startActivity(intRegistroD);
            break;

            case R.id.btnRPaciente:
                Intent intRegistroP = new Intent(RegistroActivity.this,RegistroPaciente.class);
                startActivity(intRegistroP);
            break;
            default:
            break;
        }
    }
}
