package frontend.zanatciu.com.zanatciu.Funksionalitete.ActivityClasses;

import android.content.Intent;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import frontend.zanatciu.com.zanatciu.Funksionalitete.Interfaces.LoginResponse;
import frontend.zanatciu.com.zanatciu.Funksionalitete.Interfaces.TokenResponse;
import frontend.zanatciu.com.zanatciu.Funksionalitete.JsonBlueprintLayer.Requests.LoginReq;
import frontend.zanatciu.com.zanatciu.Funksionalitete.JsonBlueprintLayer.Responses.LoginRes;
import frontend.zanatciu.com.zanatciu.Funksionalitete.JsonBlueprintLayer.Responses.TokenRes;
import frontend.zanatciu.com.zanatciu.Funksionalitete.Tasks.LoginTask;
import frontend.zanatciu.com.zanatciu.Funksionalitete.Tasks.TokenTask;
import frontend.zanatciu.com.zanatciu.Funksionalitete.TokenCache;
import frontend.zanatciu.com.zanatciu.Funksionalitete.UserProfile;
import frontend.zanatciu.com.zanatciu.Funksionalitete.Utilities.LoginUtility;
import frontend.zanatciu.com.zanatciu.Kreu.ActivityClasses.Kreu;
import frontend.zanatciu.com.zanatciu.Kreu.Tasks.JobListTask;
import frontend.zanatciu.com.zanatciu.R;

public class Login extends AppCompatActivity implements LoginResponse<LoginRes>, TokenResponse<String> {

    private ActionBar actionBar;
    private EditText username;
    private EditText password;
    private Button hyrje;
    private Button regjistrohu;
    private Button rifitoFjalekalim;
    private String result;
    private TextView test;

    private LoginTask loginTaskAsync=new LoginTask();
    private TokenTask tokenTaskAsync=new TokenTask();



    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.login_interface);

        actionBar=getSupportActionBar();
        actionBar.hide();


        username=(EditText)findViewById(R.id.Username);
        password=(EditText)findViewById(R.id.Password);
        hyrje=(Button)findViewById(R.id.Hyrje);
        test=(TextView)findViewById(R.id.test);
        regjistrohu=(Button)findViewById(R.id.Regjistrim);
        rifitoFjalekalim=(Button)findViewById(R.id.buttonRifitoFjalekalim);


        loginTaskAsync.delegate=this;
        tokenTaskAsync.delegate=this;


        hyrje.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                UserProfile.getInstance().setUsername(username.getText().toString());

                LoginUtility loginUtility=new LoginUtility(username.getText().toString(),password.getText().toString());

                tokenTaskAsync.execute(loginUtility);

            }
        });

        regjistrohu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                  Intent goRegjistrim=new Intent(Login.this,Regjistro.class);
                  startActivity(goRegjistrim);
            }
        });



        rifitoFjalekalim.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent goMerrFjalekalim=new Intent(Login.this,RifitoFjalekalim.class);
                startActivity(goMerrFjalekalim);

            }
        });

    }





    private String serializeLoginReq(String username,String Password)
    {
        LoginReq loginReq=new LoginReq();

        loginReq.setUserName(username);
        loginReq.setPassWord(Password);


        Gson gson = new GsonBuilder().registerTypeAdapter(LoginReq.class, new LoginReq.LoginSerializer()).create();
        String jsonString=gson.toJson(loginReq);
        return jsonString;
    }





    @Override
    public void onPostTaskLogin(LoginRes loginRes) {
        result+=loginRes.getUsername();

        Intent goKreu=new Intent(Login.this, Kreu.class);
        startActivity(goKreu);
    }





    @Override
    public void onPostTaskToken(String token) {

       //String requestContent= serializeLoginReq(username.getText().toString(),password.getText().toString());
        if(token!=null){
           TokenCache.getInstance().setToken(token);
           result=token;
           loginTaskAsync.execute();
        }
    }
}
