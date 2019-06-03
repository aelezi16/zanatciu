package frontend.zanatciu.com.zanatciu.PunetEMia.ActivityClasses;

import android.os.Bundle;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;

import frontend.zanatciu.com.zanatciu.R;

public class Login extends AppCompatActivity {

    private ActionBar actionBar;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login_interface);

        actionBar=getSupportActionBar();
        actionBar.hide();



    }
}
