package frontend.zanatciu.com.zanatciu.Abonimet.ActivityClasses;

import android.os.Bundle;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;

import de.hdodenhof.circleimageview.CircleImageView;
import frontend.zanatciu.com.zanatciu.R;

public class Login extends AppCompatActivity {

    private ActionBar actionBar;
    CircleImageView circleImageView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login_interface);


        circleImageView=findViewById(R.id.profile_image);

        actionBar=getSupportActionBar();
        actionBar.hide();



    }
}
