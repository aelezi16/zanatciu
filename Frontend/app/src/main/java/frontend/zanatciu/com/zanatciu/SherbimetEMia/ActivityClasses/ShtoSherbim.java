package frontend.zanatciu.com.zanatciu.SherbimetEMia.ActivityClasses;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;
import android.widget.Button;

import frontend.zanatciu.com.zanatciu.PunetEMia.ActivityClasses.PunetEMia;
import frontend.zanatciu.com.zanatciu.PunetEMia.ActivityClasses.ShtoPune;
import frontend.zanatciu.com.zanatciu.R;

public class ShtoSherbim extends AppCompatActivity {


    private Button shto,anullo;


    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.shtim_sherbimi_interface);

        shto=(Button)findViewById(R.id.shtoSherbim);
        anullo=(Button)findViewById(R.id.anulloShtoSherbim);


        getSupportActionBar().setDisplayShowHomeEnabled(true);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);





    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        int id=item.getItemId();
        if(id==android.R.id.home)
        {
            Intent intent=new Intent(ShtoSherbim.this, SherbimetEMia.class);
            startActivity(intent);
        }

        return super.onOptionsItemSelected(item);
    }
}
