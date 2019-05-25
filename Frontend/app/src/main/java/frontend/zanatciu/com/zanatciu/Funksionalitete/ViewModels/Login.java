package frontend.zanatciu.com.zanatciu.Funksionalitete.ViewModels;

import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

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
