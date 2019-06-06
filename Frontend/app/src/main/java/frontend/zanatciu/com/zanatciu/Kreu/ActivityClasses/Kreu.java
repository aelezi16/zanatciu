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
import android.text.Editable;
import android.text.TextWatcher;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

import com.google.gson.Gson;

import java.util.ArrayList;

import frontend.zanatciu.com.zanatciu.Kreu.Interfaces.JobListResponse;
import frontend.zanatciu.com.zanatciu.Kreu.Interfaces.ServiceListResponse;
import frontend.zanatciu.com.zanatciu.Kreu.JsonBlueprintLayer.Responses.JobMarketListItem;
import frontend.zanatciu.com.zanatciu.Kreu.JsonBlueprintLayer.Responses.JobMarketListRes;
import frontend.zanatciu.com.zanatciu.Kreu.JsonBlueprintLayer.Responses.ServiceMarketListItem;
import frontend.zanatciu.com.zanatciu.Kreu.JsonBlueprintLayer.Responses.ServiceMarketListRes;
import frontend.zanatciu.com.zanatciu.Kreu.Tasks.JobListTask;
import frontend.zanatciu.com.zanatciu.Kreu.Tasks.ServiceListTask;
import frontend.zanatciu.com.zanatciu.Kreu.Utilities.CustomAdapterKreuPune;
import frontend.zanatciu.com.zanatciu.Kreu.Utilities.CustomAdapterKreuSherbim;
import frontend.zanatciu.com.zanatciu.Kreu.Utilities.PageNumberHolder;
import frontend.zanatciu.com.zanatciu.R;
import info.hoang8f.android.segmented.SegmentedGroup;

public class Kreu extends AppCompatActivity implements  NavigationView.OnNavigationItemSelectedListener ,
                                             RadioGroup.OnCheckedChangeListener,
                                             JobListResponse<JobMarketListRes>,
                                             ServiceListResponse <ServiceMarketListRes> {

    private ListView listViewMarket;
    private CustomAdapterKreuPune customAdapterKreuPune;
    private CustomAdapterKreuSherbim customAdapterKreuSherbim;
    private ArrayList<JobMarketListItem> arrayListJobs;


    private ArrayList<ServiceMarketListItem> arrayListServices;
    private SegmentedGroup segmented2;
    private EditText search;
    private LinearLayout listLinearLayout;

    private JobListTask jobListTaskAsync= new JobListTask();
    private ServiceListTask serviceListTaskAsync= new ServiceListTask();


    private Button next,previous;


    @Override
    protected void onCreate(Bundle savedInstanceState){

        super.onCreate(savedInstanceState);
        setContentView(R.layout.navigation_menu);


        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        FloatingActionButton fab = findViewById(R.id.fab);
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






        listViewMarket=(ListView)findViewById(R.id.list_market);
        segmented2=(SegmentedGroup)findViewById(R.id.segmented2);
        search=(EditText)findViewById(R.id.search);
        listLinearLayout=(LinearLayout) findViewById(R.id.linearLayoutListView);
        next=(Button)findViewById(R.id.next);
        previous=(Button)findViewById(R.id.previous);
        listLinearLayout.setVisibility(View.INVISIBLE);
        segmented2.setOnCheckedChangeListener(Kreu.this);

        //test arraylist from client

        arrayListJobs = new ArrayList<>();
        arrayListServices=new ArrayList<>();



        jobListTaskAsync.delegate=this;
        serviceListTaskAsync.delegate=this;



        next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {



                Integer counter=0;
                if(listViewMarket.getAdapter().equals(customAdapterKreuPune)) {


                    if(arrayListJobs.size()==50) {
                        PageNumberHolder.getInstance().incrementJobPageCounter();
                        counter = PageNumberHolder.getInstance().getCounterPageJobs();
                        jobListTaskAsync.execute(counter);
                    }


                }else {

                    if(arrayListJobs.size()==50) {
                        PageNumberHolder.getInstance().incrementServicePageCounter();
                        counter = PageNumberHolder.getInstance().getCounterPageJobs();
                        serviceListTaskAsync.execute(counter);
                    }

                }
            }
        });


        previous.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Integer counter=0;

                if(listViewMarket.getAdapter().equals(customAdapterKreuPune)) {

                    if (PageNumberHolder.getInstance().getCounterPageJobs() > 0) {

                        PageNumberHolder.getInstance().decrementJobPageCounter();
                        counter=PageNumberHolder.getInstance().getCounterPageJobs();
                        jobListTaskAsync.execute(counter);

                    }




                }else {

                    if (PageNumberHolder.getInstance().getCounterPageJobs() > 0) {

                        PageNumberHolder.getInstance().decrementServicePageCounter();
                        counter=PageNumberHolder.getInstance().getCounterPageServices();
                        serviceListTaskAsync.execute(counter);
                    }

                }
            }
        });

        listViewMarket.setOnItemClickListener(new AdapterView.OnItemClickListener() {

                @Override
                public void onItemClick(AdapterView<?> parent, View view, int position, long id) {




                    if(listViewMarket.getAdapter().equals(customAdapterKreuPune)) {


                        JobMarketListItem clickedJob = arrayListJobs.get(position);

                        String clickedJobSerialized = new Gson().toJson(clickedJob);

                        Intent goPuneItem = new Intent(Kreu.this, PuneItem.class);

                        goPuneItem.putExtra("itemClicked", clickedJobSerialized);

                        startActivity(goPuneItem);

                    }else {

                        ServiceMarketListItem clickedService=arrayListServices.get(position);

                        String clickedServiceSerialized=new Gson().toJson(clickedService);

                        Intent goSherbimItem= new Intent(Kreu.this,SherbimItem.class);

                        goSherbimItem.putExtra("itemClicked",clickedServiceSerialized);

                        startActivity(goSherbimItem);

                    }
                }


            });







        search.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {

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
            // Handle the camera action
        } else if (id == R.id.sherbimetEMia) {

        } else if (id == R.id.punetEMia) {

        } else if (id == R.id.abonimet) {

        } else if (id == R.id.dilni) {

        }

        DrawerLayout drawer = findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }



    @Override
    public void onCheckedChanged(RadioGroup group, int checkedId) {
        switch (checkedId) {
            case R.id.button21:

                Toast toast = Toast.makeText(getApplicationContext(),
                        "Pune",
                        Toast.LENGTH_SHORT);

                toast.show();

                //jobListTaskAsync.execute();

                PageNumberHolder.getInstance().setCounterPageJobs(0);

                Integer counter=PageNumberHolder.getInstance().getCounterPageJobs();
                jobListTaskAsync.execute(counter);




                break;

            case R.id.button22:

                Toast toast1 = Toast.makeText(getApplicationContext(), "Sherbime", Toast.LENGTH_SHORT);
                toast1.show();


                PageNumberHolder.getInstance().setCounterPageServices(0);

                Integer counterpageservice=PageNumberHolder.getInstance().getCounterPageJobs();

                serviceListTaskAsync.execute(counterpageservice);



                break;


            default:
                // Nothing to do
        }
    }


    @Override
    public void onPostTaskJobs(JobMarketListRes jobMarketListRes) {

        arrayListJobs.clear();
        arrayListJobs=jobMarketListRes.getJobMarketList();
        listLinearLayout.setVisibility(View.VISIBLE);
        customAdapterKreuPune=new CustomAdapterKreuPune(this,arrayListJobs);
        listViewMarket.setAdapter(customAdapterKreuPune);
        jobListTaskAsync= new JobListTask();
        jobListTaskAsync.delegate=this;


    }


    @Override
    public void onPostTaskServices(ServiceMarketListRes serviceMarketListRes) {

        arrayListServices.clear();
        arrayListServices=serviceMarketListRes.getServiceMarketListItem();
        listLinearLayout.setVisibility(View.VISIBLE);
        customAdapterKreuSherbim=new CustomAdapterKreuSherbim(this,arrayListServices);
        listViewMarket.setAdapter(customAdapterKreuSherbim);
        serviceListTaskAsync= new ServiceListTask();
        serviceListTaskAsync.delegate=this;

    }



}
