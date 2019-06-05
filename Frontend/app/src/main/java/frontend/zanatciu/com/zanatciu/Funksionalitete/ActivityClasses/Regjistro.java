package frontend.zanatciu.com.zanatciu.Funksionalitete.ActivityClasses;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import frontend.zanatciu.com.zanatciu.Funksionalitete.Interfaces.LoginResponse;
import frontend.zanatciu.com.zanatciu.Funksionalitete.Interfaces.RegjistroResponse;
import frontend.zanatciu.com.zanatciu.Funksionalitete.JsonBlueprintLayer.Requests.LoginReq;
import frontend.zanatciu.com.zanatciu.Funksionalitete.JsonBlueprintLayer.Requests.RegjistroReq;
import frontend.zanatciu.com.zanatciu.Funksionalitete.JsonBlueprintLayer.Responses.LoginRes;
import frontend.zanatciu.com.zanatciu.Funksionalitete.Tasks.LoginTask;
import frontend.zanatciu.com.zanatciu.Funksionalitete.Tasks.RegjistroTask;
import frontend.zanatciu.com.zanatciu.Funksionalitete.Tasks.TokenTask;
import frontend.zanatciu.com.zanatciu.Funksionalitete.TokenCache;
import frontend.zanatciu.com.zanatciu.Funksionalitete.UserProfile;
import frontend.zanatciu.com.zanatciu.Kreu.ActivityClasses.Kreu;
import frontend.zanatciu.com.zanatciu.R;

public class Regjistro extends AppCompatActivity implements RegjistroResponse<String>, LoginResponse<LoginRes> {

    private EditText firstName;
    private EditText secondName;
    private EditText perdoruesi;
    private EditText personalNo;
    private EditText email;
    private EditText phoneNo;
    private EditText password;
    private EditText perseritpassword;
    private Button regjistrohu;

    private LoginTask loginTaskAsync=new LoginTask();
    private RegjistroTask regjistroTask=new RegjistroTask();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.regjistrim_interface);

        getSupportActionBar().setDisplayShowHomeEnabled(true);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        firstName=(EditText)findViewById(R.id.emri);
        secondName=(EditText)findViewById(R.id.mbiemri);
        perdoruesi=(EditText)findViewById(R.id.perdoruesi);
        personalNo=(EditText)findViewById(R.id.personalNr);
        email=(EditText)findViewById(R.id.email);
        phoneNo=(EditText)findViewById(R.id.nrTel);
        password=(EditText)findViewById(R.id.fjalekalim);
        perseritpassword=(EditText)findViewById(R.id.perseritFjalekalim);
        regjistrohu=(Button)findViewById(R.id.btnRegisterHere);



        loginTaskAsync.delegate=this;
        regjistroTask.delegate=this;

        regjistrohu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if(password.getText().toString().equals(perseritpassword.getText().toString())){

                    regjistroTask.execute(serializeLoginReq());

                }else
                {
                    AlertDialog.Builder builder1 = new AlertDialog.Builder(Regjistro.this);
                    builder1.setMessage("Fjalekalimi i perseritur nuk perputhet me Fjalekalimin.\nJu lutemi provoni perseri!");
                    builder1.setCancelable(true);

                    builder1.setPositiveButton(
                            "Yes",
                            new DialogInterface.OnClickListener() {
                                public void onClick(DialogInterface dialog, int id) {
                                    dialog.cancel();
                                }
                            });

                    builder1.setNegativeButton(
                            "No",
                            new DialogInterface.OnClickListener() {
                                public void onClick(DialogInterface dialog, int id) {
                                    dialog.cancel();
                                }
                            });

                    AlertDialog alert11 = builder1.create();
                    alert11.show();
                }
            }
        });



    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        int id=item.getItemId();
        if(id==android.R.id.home)
        {
            Intent intent=new Intent(Regjistro.this, Login.class);
            startActivity(intent);
        }

        return super.onOptionsItemSelected(item);
    }





    private String serializeLoginReq()
    {
        RegjistroReq regjistroReq=new RegjistroReq();

        /*
        regjistroReq.setFirstName(firstName.getText().toString());
        regjistroReq.setLastName(secondName.getText().toString());
        regjistroReq.setUsername(perdoruesi.getText().toString());
        regjistroReq.setPersonalNo(personalNo.getText().toString());
        regjistroReq.setEmail(email.getText().toString());
        regjistroReq.setPhoneNo(phoneNo.getText().toString());
        regjistroReq.setPassword(password.getText().toString());*/

        regjistroReq.setFirstName("geri");
        regjistroReq.setLastName("geri");
        regjistroReq.setUsername("geri");
        regjistroReq.setPersonalNo("geri");
        regjistroReq.setEmail("geri");
        regjistroReq.setPhoneNo("geri");
        regjistroReq.setPassword("geri");


        Gson gson = new GsonBuilder().registerTypeAdapter(RegjistroReq.class, new RegjistroReq.RegjistroReqSerializer()).create();
        String jsonString=gson.toJson(regjistroReq);
        return jsonString;
    }

    @Override
    public void onPostTaskRegjistro(String token) {

        TokenCache.getInstance().setToken(token);
        UserProfile.getInstance().setUsername("geri");
        loginTaskAsync.execute();

    }

    @Override
    public void onPostTaskLogin(LoginRes loginRes) {

        if(loginRes!=null){
        Intent goKreu=new Intent(Regjistro.this, Kreu.class);
        startActivity(goKreu);

        }

    }
}
