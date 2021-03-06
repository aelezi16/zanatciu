package frontend.zanatciu.com.zanatciu.Abonimet.ActivityClasses;

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

import frontend.zanatciu.com.zanatciu.Funksionalitete.ActivityClasses.Cilesime;
import frontend.zanatciu.com.zanatciu.Funksionalitete.ActivityClasses.Login;
import frontend.zanatciu.com.zanatciu.Kreu.ActivityClasses.Kreu;
import frontend.zanatciu.com.zanatciu.PunetEMia.ActivityClasses.PunetEMia;
import frontend.zanatciu.com.zanatciu.R;
import frontend.zanatciu.com.zanatciu.SherbimetEMia.ActivityClasses.SherbimetEMia;

public class Abonime extends
                        AppCompatActivity
                               implements
                                      NavigationView.OnNavigationItemSelectedListener{


    private Button karta;


    @Override
    protected void onCreate(Bundle savedInstanceState){

        super.onCreate(savedInstanceState);
        setContentView(R.layout.navigation_menu_abonimet);

        karta=(Button)findViewById(R.id.kartaButton);


        Toolbar toolbar = findViewById(R.id.toolbarAbonime);
        setSupportActionBar(toolbar);
        FloatingActionButton fab = findViewById(R.id.fabAbonime);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });
        DrawerLayout drawer = findViewById(R.id.drawer_layout_abonime);
        NavigationView navigationView = findViewById(R.id.nav_view_abonimet);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();
        navigationView.setNavigationItemSelectedListener(this);




        karta.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent goKartaCreditDebit=new Intent(Abonime.this,Karta.class);
                startActivity(goKartaCreditDebit);
            }
        });


      }


    //deactivates back button form device
    @Override
    public void onBackPressed(){

        DrawerLayout drawer = findViewById(R.id.drawer_layout);
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

            Intent intent=new Intent(Abonime.this, Cilesime.class);
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
            Intent intent=new Intent(Abonime.this, Kreu.class);
            startActivity(intent);
        } else if (id == R.id.sherbimetEMia) {
            Intent intent=new Intent(Abonime.this, SherbimetEMia.class);
            startActivity(intent);

        } else if (id == R.id.punetEMia) {

            Intent intent=new Intent(Abonime.this, PunetEMia.class);
            startActivity(intent);

        } else if (id == R.id.abonimet) {

            Intent intent=new Intent(Abonime.this, Abonime.class);
            startActivity(intent);

        } else if (id == R.id.dilni) {

            Intent intent=new Intent(Abonime.this, Login.class);
            startActivity(intent);

        }

        DrawerLayout drawer = findViewById(R.id.drawer_layout_abonime);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }

}
