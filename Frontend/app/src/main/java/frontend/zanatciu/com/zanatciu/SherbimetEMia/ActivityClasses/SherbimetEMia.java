package frontend.zanatciu.com.zanatciu.SherbimetEMia.ActivityClasses;

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
import frontend.zanatciu.com.zanatciu.Funksionalitete.ActivityClasses.Login;
import frontend.zanatciu.com.zanatciu.Kreu.ActivityClasses.Kreu;
import frontend.zanatciu.com.zanatciu.Kreu.ActivityClasses.SherbimItem;
import frontend.zanatciu.com.zanatciu.PunetEMia.ActivityClasses.PunetEMia;
import frontend.zanatciu.com.zanatciu.R;

public class SherbimetEMia  extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener{


    private Button shtoSherbim;



    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.navigation_menu_sherbimet_e_mia);

        shtoSherbim=(Button)findViewById(R.id.shtoSherbimButton);

        Toolbar toolbar = findViewById(R.id.toolbarSherbimetEMia);
        setSupportActionBar(toolbar);
        FloatingActionButton fab = findViewById(R.id.fabSherbimetEMia);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });
        DrawerLayout drawer = findViewById(R.id.drawer_layout_sherbimet_e_mia);
        NavigationView navigationView = findViewById(R.id.nav_view_sherbimet_e_mia);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();
        navigationView.setNavigationItemSelectedListener(this);


        shtoSherbim.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent goShtoSherbim=new Intent(SherbimetEMia.this, ShtoSherbim.class);
                startActivity(goShtoSherbim);
            }
        });

    }

    //deactivates back button form device
    @Override
    public void onBackPressed(){

        DrawerLayout drawer = findViewById(R.id.drawer_layout_sherbimet_e_mia);
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

            Intent intent=new Intent(SherbimetEMia.this, Cilesime.class);
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
            Intent intent=new Intent(SherbimetEMia.this, Kreu.class);
            startActivity(intent);
        } else if (id == R.id.sherbimetEMia) {



        } else if (id == R.id.punetEMia) {

            Intent intent=new Intent(SherbimetEMia.this, PunetEMia.class);
            startActivity(intent);

        } else if (id == R.id.abonimet) {

            Intent intent=new Intent(SherbimetEMia.this, Abonime.class);
            startActivity(intent);

        } else if (id == R.id.dilni) {

            Intent intent=new Intent(SherbimetEMia.this, Login.class);
            startActivity(intent);

        }

        DrawerLayout drawer = findViewById(R.id.drawer_layout_sherbimet_e_mia);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }


}
