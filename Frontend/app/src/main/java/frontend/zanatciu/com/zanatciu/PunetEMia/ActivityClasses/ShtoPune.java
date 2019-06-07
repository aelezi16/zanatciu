package frontend.zanatciu.com.zanatciu.PunetEMia.ActivityClasses;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;

import frontend.zanatciu.com.zanatciu.Funksionalitete.ActivityClasses.Cilesime;
import frontend.zanatciu.com.zanatciu.Kreu.ActivityClasses.Kreu;
import frontend.zanatciu.com.zanatciu.R;

public class ShtoPune extends AppCompatActivity {


    private Button shto,anullo;


    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.shtim_pune_interface);

        getSupportActionBar().setDisplayShowHomeEnabled(true);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        shto=(Button)findViewById(R.id.shtoPune);
        anullo=(Button)findViewById(R.id.anulloShtoPune);

        shto.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });

        anullo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });


    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        int id=item.getItemId();
        if(id==android.R.id.home)
        {
            Intent intent=new Intent(ShtoPune.this, PunetEMia.class);
            startActivity(intent);
        }

        return super.onOptionsItemSelected(item);
    }
}
