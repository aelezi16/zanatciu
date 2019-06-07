package frontend.zanatciu.com.zanatciu.Kreu.ActivityClasses;

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
import android.widget.TextView;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Type;

import de.hdodenhof.circleimageview.CircleImageView;
import frontend.zanatciu.com.zanatciu.Abonimet.ActivityClasses.Abonime;
import frontend.zanatciu.com.zanatciu.Funksionalitete.ActivityClasses.Cilesime;
import frontend.zanatciu.com.zanatciu.Kreu.JsonBlueprintLayer.Responses.JobMarketListItem;
import frontend.zanatciu.com.zanatciu.Kreu.JsonBlueprintLayer.Responses.ServiceMarketListItem;
import frontend.zanatciu.com.zanatciu.PunetEMia.ActivityClasses.PunetEMia;
import frontend.zanatciu.com.zanatciu.R;
import frontend.zanatciu.com.zanatciu.SherbimetEMia.ActivityClasses.SherbimetEMia;

public class SherbimItem extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener{


    private CircleImageView profileImage;
    private TextView emriSherbimOfruesi;
    private TextView pershkrimiTextArea;
    private TextView cmimi;
    private Button aplikime;
    private Button apliko;
    private ServiceMarketListItem serviceMarketListItem;

    @Override
    protected void onCreate(Bundle savedInstanceState){

        super.onCreate(savedInstanceState);
        setContentView(R.layout.sherbim_kerkoj_interface);

        profileImage=(CircleImageView)findViewById(R.id.profile_image);
        emriSherbimOfruesi=(TextView)findViewById(R.id.emriTextView);
        pershkrimiTextArea=(TextView)findViewById(R.id.textArea);
        cmimi=(TextView)findViewById(R.id.cmimi);
        aplikime=(Button) findViewById(R.id.aplikimeButton);
        apliko=(Button) findViewById(R.id.prenotimeButton);


        Toolbar toolbar = findViewById(R.id.toolbarSherbimItem);
        setSupportActionBar(toolbar);
        FloatingActionButton fab = findViewById(R.id.fabSherbimItem);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });
        DrawerLayout drawer = findViewById(R.id.drawer_layout);
        NavigationView navigationView = findViewById(R.id.nav_view);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();
        navigationView.setNavigationItemSelectedListener(this);


        Bundle bundle = getIntent().getExtras();

        String empStr = bundle.getString("itemClicked");
        Gson gson = new Gson();
        Type type = new TypeToken<ServiceMarketListItem>() {
        }.getType();

        serviceMarketListItem = gson.fromJson(empStr, type);


        emriSherbimOfruesi.setText(serviceMarketListItem.getUsername());

        pershkrimiTextArea.setText(serviceMarketListItem.getTitle()+"\n"+serviceMarketListItem.getDescription());

        cmimi.setText(serviceMarketListItem.getPrice().toString());




        aplikime.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {

                Intent goAplikimePune=new Intent(SherbimItem.this,AplikimePrenotimeSherbim.class);
                startActivity(goAplikimePune);

            }
        });



        apliko.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                //metoda e exekutimit te taskut per pronotim



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

            Intent intent=new Intent(SherbimItem.this, Cilesime.class);
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
            Intent intent=new Intent(SherbimItem.this, Kreu.class);
            startActivity(intent);
        } else if (id == R.id.sherbimetEMia) {
            Intent intent=new Intent(SherbimItem.this, SherbimetEMia.class);
            startActivity(intent);

        } else if (id == R.id.punetEMia) {

            Intent intent=new Intent(SherbimItem.this, PunetEMia.class);
            startActivity(intent);

        } else if (id == R.id.abonimet) {

            Intent intent=new Intent(SherbimItem.this, Abonime.class);
            startActivity(intent);

        } else if (id == R.id.dilni) {

            //Intent intent=new Intent(Kreu.this, Abonime.class);
            //startActivity(intent);

        }

        DrawerLayout drawer = findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }


}
