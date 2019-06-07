package frontend.zanatciu.com.zanatciu.Kreu.ActivityClasses;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.widget.ListView;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Type;
import java.util.ArrayList;

import frontend.zanatciu.com.zanatciu.Kreu.JsonBlueprintLayer.Responses.AplikimePuneItem;
import frontend.zanatciu.com.zanatciu.Kreu.JsonBlueprintLayer.Responses.JobMarketListItem;
import frontend.zanatciu.com.zanatciu.Kreu.Utilities.CustomAdapterAplikimePune;
import frontend.zanatciu.com.zanatciu.Kreu.Utilities.CustomAdapterKreuPune;
import frontend.zanatciu.com.zanatciu.R;


public class AplikimePune extends AppCompatActivity {

    private ListView listView;
    private CustomAdapterAplikimePune customAdapterAplikimePune;
    private ArrayList<AplikimePuneItem> arraListAplikimePune;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.aplikime_pune_interface);

        arraListAplikimePune = new ArrayList<>();


        Bundle bundle = getIntent().getExtras();

        String empStr = bundle.getString("serializedAplikimeRes");
        Gson gson = new Gson();
        Type type = new TypeToken<AplikimePuneItem>() {
        }.getType();

        arraListAplikimePune = gson.fromJson(empStr, type);


        listView = (ListView) findViewById(R.id.list_aplikime_pune);
        customAdapterAplikimePune = new CustomAdapterAplikimePune(this, arraListAplikimePune);


    }
}
