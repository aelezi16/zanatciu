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
import frontend.zanatciu.com.zanatciu.Funksionalitete.ActivityClasses.Login;
import frontend.zanatciu.com.zanatciu.Kreu.Interfaces.AplikoResponse;
import frontend.zanatciu.com.zanatciu.Kreu.Interfaces.MerrAplikimeResponse;
import frontend.zanatciu.com.zanatciu.Kreu.JsonBlueprintLayer.Responses.AplikimePuneRes;
import frontend.zanatciu.com.zanatciu.Kreu.JsonBlueprintLayer.Responses.AplikoRes;
import frontend.zanatciu.com.zanatciu.Kreu.JsonBlueprintLayer.Responses.JobMarketListItem;
import frontend.zanatciu.com.zanatciu.Kreu.Tasks.AplikoTask;
import frontend.zanatciu.com.zanatciu.Kreu.Tasks.MerrAplikimeTask;
import frontend.zanatciu.com.zanatciu.PunetEMia.ActivityClasses.PunetEMia;
import frontend.zanatciu.com.zanatciu.R;
import frontend.zanatciu.com.zanatciu.SherbimetEMia.ActivityClasses.SherbimetEMia;

public class PuneItem extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener,
                            MerrAplikimeResponse<AplikimePuneRes> ,
                            AplikoResponse<AplikoRes> {


    private CircleImageView profileImage;
    private TextView emriPunedhenesi;
    private TextView pershkrimiTextArea;
    private TextView cmimi;
    private Button aplikime;
    private Button apliko;
    private JobMarketListItem jobMarketListItem;


    private AplikoTask aplikoTask=new AplikoTask();
    private MerrAplikimeTask merrAplikimeTask=new MerrAplikimeTask();

    @Override
    protected void onCreate(Bundle savedInstanceState){

        super.onCreate(savedInstanceState);
        setContentView(R.layout.navigation_menu_pune_item);


        Toolbar toolbar = findViewById(R.id.toolbarPuneIten);
        setSupportActionBar(toolbar);
        FloatingActionButton fab = findViewById(R.id.fabPuneItem);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });
        DrawerLayout drawer = findViewById(R.id.drawer_layout_pune_item);
        NavigationView navigationView = findViewById(R.id.nav_view_pune_item);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();
        navigationView.setNavigationItemSelectedListener(this);


        profileImage=(CircleImageView)findViewById(R.id.profile_image);
        emriPunedhenesi=(TextView)findViewById(R.id.emriTextView);
        pershkrimiTextArea=(TextView)findViewById(R.id.textArea);
        cmimi=(TextView)findViewById(R.id.cmimi);
        aplikime=(Button) findViewById(R.id.aplikimeButton);
        apliko=(Button) findViewById(R.id.aplikoButton);



        Bundle bundle = getIntent().getExtras();

        String empStr = bundle.getString("itemClicked");
        Gson gson = new Gson();
        Type type = new TypeToken<JobMarketListItem>() {
        }.getType();

        jobMarketListItem = gson.fromJson(empStr, type);


        emriPunedhenesi.setText(jobMarketListItem.getUsername());

        pershkrimiTextArea.setText(jobMarketListItem.getTitle()+"\n"+jobMarketListItem.getDescription());

        cmimi.setText(jobMarketListItem.getPrice().toString());


        aplikoTask.delegate=this;
        merrAplikimeTask.delegate=this;

        aplikime.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {

                merrAplikimeTask.execute();

            }
        });



        apliko.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                aplikoTask.execute();



            }
        });







    }


    //deactivates back button form device
    @Override
    public void onBackPressed(){

        DrawerLayout drawer = findViewById(R.id.drawer_layout_pune_item);
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

            Intent intent=new Intent(PuneItem.this, Cilesime.class);
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
            Intent intent=new Intent(PuneItem.this, Kreu.class);
            startActivity(intent);
        } else if (id == R.id.sherbimetEMia) {
            Intent intent=new Intent(PuneItem.this, SherbimetEMia.class);
            startActivity(intent);

        } else if (id == R.id.punetEMia) {

            Intent intent=new Intent(PuneItem.this, PunetEMia.class);
            startActivity(intent);

        } else if (id == R.id.abonimet) {

            Intent intent=new Intent(PuneItem.this, Abonime.class);
            startActivity(intent);

        } else if (id == R.id.dilni) {

            Intent intent=new Intent(PuneItem.this, Login.class);
            startActivity(intent);

        }

        DrawerLayout drawer = findViewById(R.id.drawer_layout_pune_item);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }


    @Override
    public void onPostTaskMerrAplikime(AplikimePuneRes aplikimePuneRes) {

        Intent goAplikimePune=new Intent(PuneItem.this,AplikimePune.class);

        String serializedAplikimeRes=new Gson().toJson(aplikimePuneRes) ;

        goAplikimePune.putExtra("serializedAplikimeRes",serializedAplikimeRes);

        startActivity(goAplikimePune);


    }

    @Override
    public void onPostTaskApliko(AplikoRes baseRes) {

      //show alert dialog on result ok or not

    }
}
