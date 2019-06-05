package frontend.zanatciu.com.zanatciu.Kreu.ActivityClasses;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.AdapterView;
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
import frontend.zanatciu.com.zanatciu.R;
import info.hoang8f.android.segmented.SegmentedGroup;

public class Kreu extends AppCompatActivity implements RadioGroup.OnCheckedChangeListener, JobListResponse<JobMarketListRes> , ServiceListResponse <ServiceMarketListRes> {

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

    @Override
    protected void onCreate(Bundle savedInstanceState){

        super.onCreate(savedInstanceState);
        setContentView(R.layout.kreu_pune_sherbim_interface);

        listViewMarket=(ListView)findViewById(R.id.list_market);
        segmented2=(SegmentedGroup)findViewById(R.id.segmented2);
        search=(EditText)findViewById(R.id.search);
        listLinearLayout=(LinearLayout) findViewById(R.id.linearLayoutListView);
        listLinearLayout.setVisibility(View.INVISIBLE);
        segmented2.setOnCheckedChangeListener(Kreu.this);

        //test arraylist from client

        arrayListJobs = new ArrayList<>();
        arrayListJobs.add(new JobMarketListItem("","sdsd", "Pastrues Eventi","","","Cmimi: 50 $"));
        arrayListJobs.add(new JobMarketListItem("","sdsd", "Pastrues Eventi","","","Cmimi: 50 $"));
        arrayListJobs.add(new JobMarketListItem("","sdsd", "Pastrues Eventi","","","Cmimi: 50 $"));


        arrayListServices=new ArrayList<>();



        jobListTaskAsync.delegate=this;
        serviceListTaskAsync.delegate=this;



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

                        Intent goSherbimItem= new Intent(Kreu.this,PuneItem.class);

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




    @Override
    public void onCheckedChanged(RadioGroup group, int checkedId) {
        switch (checkedId) {
            case R.id.button21:

                Toast toast = Toast.makeText(getApplicationContext(),
                        "Pune",
                        Toast.LENGTH_SHORT);

                toast.show();

                //jobListTaskAsync.execute();


                //below not here but in the response
                listLinearLayout.setVisibility(View.VISIBLE);
                customAdapterKreuPune=new CustomAdapterKreuPune(this,arrayListJobs);
                listViewMarket.setAdapter(customAdapterKreuPune);

                //listViewMarket.setAdapter(customAdapterKreuPune);
                //listViewMarket.setVisibility(View.VISIBLE);

                break;

            case R.id.button22:

                Toast toast1 = Toast.makeText(getApplicationContext(), "Sherbime", Toast.LENGTH_SHORT);
                toast1.show();


                //serviceListTaskAsync.execute();

                listLinearLayout.setVisibility(View.VISIBLE);
                customAdapterKreuSherbim=new CustomAdapterKreuSherbim(this,arrayListServices);
                listViewMarket.setAdapter(customAdapterKreuSherbim);





                break;




            default:
                // Nothing to do
        }
    }


    @Override
    public void onPostTaskJobs(JobMarketListRes jobMarketListRes) {

        arrayListJobs=jobMarketListRes.getJobMarketList();
        listLinearLayout.setVisibility(View.VISIBLE);
        customAdapterKreuPune=new CustomAdapterKreuPune(this,arrayListJobs);
        listViewMarket.setAdapter(customAdapterKreuPune);

    }


    @Override
    public void onPostTaskServices(ServiceMarketListRes serviceMarketListRes) {

        arrayListServices=serviceMarketListRes.getServiceMarketListItem();
        listLinearLayout.setVisibility(View.VISIBLE);
        customAdapterKreuSherbim=new CustomAdapterKreuSherbim(this,arrayListServices);
        listViewMarket.setAdapter(customAdapterKreuSherbim);


    }



}
