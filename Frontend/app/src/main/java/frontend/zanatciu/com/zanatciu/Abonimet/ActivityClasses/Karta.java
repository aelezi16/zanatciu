package frontend.zanatciu.com.zanatciu.Abonimet.ActivityClasses;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;

import frontend.zanatciu.com.zanatciu.Funksionalitete.ActivityClasses.Login;
import frontend.zanatciu.com.zanatciu.Funksionalitete.ActivityClasses.Regjistro;
import frontend.zanatciu.com.zanatciu.R;

public class Karta extends AppCompatActivity {

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
            Intent intent=new Intent(Karta.this, Abonime.class);
            startActivity(intent);
        }

        return super.onOptionsItemSelected(item);
    }

}
