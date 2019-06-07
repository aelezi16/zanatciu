package frontend.zanatciu.com.zanatciu.PunetEMia.ActivityClasses;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.NavigationView;
import android.support.design.widget.Snackbar;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;

import frontend.zanatciu.com.zanatciu.Abonimet.ActivityClasses.Abonime;
import frontend.zanatciu.com.zanatciu.Funksionalitete.ActivityClasses.Cilesime;
import frontend.zanatciu.com.zanatciu.Kreu.ActivityClasses.Kreu;
import frontend.zanatciu.com.zanatciu.R;
import frontend.zanatciu.com.zanatciu.SherbimetEMia.ActivityClasses.SherbimetEMia;
import frontend.zanatciu.com.zanatciu.SherbimetEMia.ActivityClasses.ShtoSherbim;

public class PunetEMia extends AppCompatActivity
                                      implements
                                         NavigationView.OnNavigationItemSelectedListener {


    private Button shtoPune;



    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.navigation_menu_punet_e_mia);

        shtoPune=(Button)findViewById(R.id.shtoPuneButton);


        Toolbar toolbar = findViewById(R.id.toolbarPunetEMia);
        setSupportActionBar(toolbar);
        FloatingActionButton fab = findViewById(R.id.fabPuneteMia);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });

        DrawerLayout drawer = findViewById(R.id.drawer_layout_punet_e_mia);
        NavigationView navigationView = findViewById(R.id.nav_view_punet_e_mia);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();
        navigationView.setNavigationItemSelectedListener(this);

        shtoPune.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent goShtoPune=new Intent(PunetEMia.this, ShtoPune.class);
                startActivity(goShtoPune);
            }
        });

    }
    //deactivates back button form device
    @Override
    public void onBackPressed(){

        DrawerLayout drawer = findViewById(R.id.drawer_layout_punet_e_mia);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }



    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {

            Intent intent=new Intent(PunetEMia.this, Cilesime.class);
            startActivity(intent);

            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        if (id == R.id.kreu) {
            Intent intent=new Intent(PunetEMia.this, Kreu.class);
            startActivity(intent);
        } else if (id == R.id.sherbimetEMia) {
            Intent intent=new Intent(PunetEMia.this, SherbimetEMia.class);
            startActivity(intent);

        } else if (id == R.id.punetEMia) {


        } else if (id == R.id.abonimet) {

            Intent intent=new Intent(PunetEMia.this, Abonime.class);
            startActivity(intent);

        } else if (id == R.id.dilni) {

            //Intent intent=new Intent(Kreu.this, Abonime.class);
            //startActivity(intent);

        }

        DrawerLayout drawer = findViewById(R.id.drawer_layout_punet_e_mia);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }


}
