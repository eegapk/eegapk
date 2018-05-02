package net.itss.kahm.eegappv3;

import android.content.Intent;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class BienvenidaActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bienvenida);

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent int1 = new Intent(BienvenidaActivity.this,InicioActivity.class);
                startActivity(int1);
            }
        },4000);
    }


}
