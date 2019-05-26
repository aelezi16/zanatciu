package frontend.zanatciu.com.zanatciu.Kreu.ActivityClasses;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ListView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

import java.util.ArrayList;

import frontend.zanatciu.com.zanatciu.Kreu.JsonBlueprintLayer.Responses.JobMarketListItem;
import frontend.zanatciu.com.zanatciu.Kreu.Utilities.CustomAdapterKreuPune;
import frontend.zanatciu.com.zanatciu.Kreu.Utilities.CustomAdapterKreuSherbim;
import frontend.zanatciu.com.zanatciu.R;
import info.hoang8f.android.segmented.SegmentedGroup;

public class Kreu extends AppCompatActivity implements RadioGroup.OnCheckedChangeListener {

    private ListView listViewMarket;
    private CustomAdapterKreuPune customAdapterKreuPune;
    private CustomAdapterKreuSherbim customAdapterKreuSherbim;
    private ArrayList<JobMarketListItem> arrayList;
    private SegmentedGroup segmented2;

    @Override
    protected void onCreate(Bundle savedInstanceState){

        super.onCreate(savedInstanceState);
        setContentView(R.layout.kreu_pune_sherbim_interface);

        listViewMarket=(ListView)findViewById(R.id.list_market);
        segmented2=(SegmentedGroup)findViewById(R.id.segmented2);

        segmented2.setOnCheckedChangeListener(Kreu.this);

        arrayList = new ArrayList<>();
        arrayList.add(new JobMarketListItem("sdsd", "Pastrues Eventi","Cmimi: 50 $"));
        arrayList.add(new JobMarketListItem("sdsd", "Pastrues Eventi","Cmimi: 50 $"));
        arrayList.add(new JobMarketListItem("sdsd", "Pastrues Eventi","Cmimi: 50 $"));



    }


    @Override
    public void onCheckedChanged(RadioGroup group, int checkedId) {
        switch (checkedId) {
            case R.id.button21:

                Toast toast = Toast.makeText(getApplicationContext(),
                        "Pune",
                        Toast.LENGTH_SHORT);

                toast.show();

                customAdapterKreuPune=new CustomAdapterKreuPune(this,arrayList);
                listViewMarket.setAdapter(customAdapterKreuPune);

                //listViewMarket.setAdapter(customAdapterKreuPune);
                //listViewMarket.setVisibility(View.VISIBLE);






                break;
            case R.id.button22:

                Toast toast1 = Toast.makeText(getApplicationContext(),
                        "Sherbime",
                        Toast.LENGTH_SHORT);

                toast1.show();

                break;




            default:
                // Nothing to do
        }
    }





}
