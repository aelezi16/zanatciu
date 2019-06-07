package frontend.zanatciu.com.zanatciu.Funksionalitete.ActivityClasses;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;

import frontend.zanatciu.com.zanatciu.Abonimet.ActivityClasses.Karta;
import frontend.zanatciu.com.zanatciu.Kreu.ActivityClasses.Kreu;
import frontend.zanatciu.com.zanatciu.R;


public class Cilesime extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.karta_interface);

        getSupportActionBar().setDisplayShowHomeEnabled(true);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        int id=item.getItemId();
        if(id==android.R.id.home)
        {
            Intent intent=new Intent(Cilesime.this, Kreu.class);
            startActivity(intent);
        }

        return super.onOptionsItemSelected(item);
    }
}
