package net.itss.kahm.eegappv3;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

public class InicioActivity extends AppCompatActivity implements OnClickListener{

    Button btnRegistrar, btnIngresar, btnIngresarP;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_inicio);

        btnIngresar = (Button) findViewById(R.id.btnIngresar);
        btnRegistrar = (Button) findViewById(R.id.btnRegistro);
        btnIngresarP = (Button) findViewById(R.id.btnIngresarPaciente);

        btnRegistrar.setOnClickListener(this);
        btnIngresar.setOnClickListener(this);
        btnIngresarP.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.btnIngresar:
                Intent intIngresar= new Intent(InicioActivity.this,LoginActivity.class);
                startActivity(intIngresar);
            break;
            case R.id.btnIngresarPaciente:
                Intent intIngresarp = new Intent(InicioActivity.this,LoginPacienteActivity.class);
                startActivity(intIngresarp);
                break;
            case R.id.btnRegistro:
                Intent intRegistro = new Intent(InicioActivity.this,RegistroActivity.class);
                startActivity(intRegistro);
             break;

             default:
             break;
        }

    }
}
