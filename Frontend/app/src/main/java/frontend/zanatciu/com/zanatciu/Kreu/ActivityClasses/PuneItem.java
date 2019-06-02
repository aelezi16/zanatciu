package frontend.zanatciu.com.zanatciu.Kreu.ActivityClasses;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Type;

import de.hdodenhof.circleimageview.CircleImageView;
import frontend.zanatciu.com.zanatciu.Kreu.Interfaces.AplikoResponse;
import frontend.zanatciu.com.zanatciu.Kreu.Interfaces.MerrAplikimeResponse;
import frontend.zanatciu.com.zanatciu.Kreu.JsonBlueprintLayer.Responses.AplikimePuneRes;
import frontend.zanatciu.com.zanatciu.Kreu.JsonBlueprintLayer.Responses.AplikoRes;
import frontend.zanatciu.com.zanatciu.Kreu.JsonBlueprintLayer.Responses.JobMarketListItem;
import frontend.zanatciu.com.zanatciu.Kreu.Tasks.AplikoTask;
import frontend.zanatciu.com.zanatciu.Kreu.Tasks.MerrAplikimeTask;
import frontend.zanatciu.com.zanatciu.R;

public class PuneItem extends AppCompatActivity implements MerrAplikimeResponse<AplikimePuneRes> , AplikoResponse<AplikoRes> {


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
        setContentView(R.layout.pune_kerkoj_interface);

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


        emriPunedhenesi.setText(jobMarketListItem.getEmriPunedhenesit());

        pershkrimiTextArea.setText(jobMarketListItem.getTitle()+"\n"+jobMarketListItem.getPershkrimi());

        cmimi.setText(jobMarketListItem.getPrice_wage());


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
