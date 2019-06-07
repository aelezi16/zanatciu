package frontend.zanatciu.com.zanatciu.Funksionalitete.ActivityClasses;

import android.content.DialogInterface;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import frontend.zanatciu.com.zanatciu.Funksionalitete.Interfaces.RifitoFjalekalimResponse;
import frontend.zanatciu.com.zanatciu.Funksionalitete.Tasks.RifitoFjalekalimTask;
import frontend.zanatciu.com.zanatciu.R;

public class RifitoFjalekalim extends AppCompatActivity implements RifitoFjalekalimResponse<Integer> {


    private EditText email;
    private Button btnRifitoFjalekalim;
    private AlertDialog.Builder builder1;
    private AlertDialog alert11;
    private AlertDialog alert2;

    private RifitoFjalekalimTask rifitoFjalekalimTask=new RifitoFjalekalimTask();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.rifitim_fjalekalimi);


        email=(EditText)findViewById(R.id.emailRifitoFjalekalim);
        btnRifitoFjalekalim=(Button)findViewById(R.id.btnRifitoFjalekalim);

        rifitoFjalekalimTask.delegate=this;
        builder1 = new AlertDialog.Builder(RifitoFjalekalim.this);



        btnRifitoFjalekalim.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if(validate(email.getText().toString())){

                    rifitoFjalekalimTask.execute(email.getText().toString());


                }else{

                    AlertDialog.Builder builder1 = new AlertDialog.Builder(RifitoFjalekalim.this);
                    builder1.setMessage("Formati i emailit nuk eshte i sakte.\nJu lutemi rregulloni formatin e emailit dhe provoni perseri!");
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




    public static final Pattern VALID_EMAIL_ADDRESS_REGEX =
            Pattern.compile("^[A-Z0-9._%+-]+@[A-Z0-9.-]+\\.[A-Z]{2,6}$", Pattern.CASE_INSENSITIVE);



    public static boolean validate(String emailStr) {
        Matcher matcher = VALID_EMAIL_ADDRESS_REGEX .matcher(emailStr);
        return matcher.find();
    }



    @Override
    public void onPostTaskRifitoFjalekalim(Integer result) {

        int code=result;

        if(code==200) {

            builder1.setMessage("Kerkesa per te rifituar fjalekalimin u dergua me sukses\nJu lutemi kontrolloni emailin tuaj per te ndryshuar fjalekalimin.");
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

            alert11 = builder1.create();
            alert11.show();


        }else{



            builder1.setMessage("Kerkesa per ndryshim fjalekalimi!");
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

            alert11 = builder1.create();
            alert11.show();


        }

    }


}
