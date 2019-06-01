package frontend.zanatciu.com.zanatciu.Kreu.ActivityClasses;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.widget.ListView;

import java.util.ArrayList;

import frontend.zanatciu.com.zanatciu.Kreu.JsonBlueprintLayer.Responses.AplikimePuneItem;
import frontend.zanatciu.com.zanatciu.Kreu.Utilities.CustomAdapterAplikimePune;
import frontend.zanatciu.com.zanatciu.Kreu.Utilities.CustomAdapterKreuPune;
import frontend.zanatciu.com.zanatciu.R;


public class AplikimePune extends AppCompatActivity {

    private ListView listView ;
    private CustomAdapterAplikimePune customAdapterAplikimePune;
    private ArrayList<AplikimePuneItem> arraListAplikimePune;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.aplikime_pune_interface);

        arraListAplikimePune=new ArrayList<>();


        listView=(ListView)findViewById(R.id.list_aplikime_pune);
        customAdapterAplikimePune=new CustomAdapterAplikimePune(this,arraListAplikimePune);


    }
}
