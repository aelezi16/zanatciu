package frontend.zanatciu.com.zanatciu.PunetEMia.Utilities;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.TextView;

import java.util.ArrayList;

import de.hdodenhof.circleimageview.CircleImageView;
import frontend.zanatciu.com.zanatciu.Kreu.JsonBlueprintLayer.Responses.JobMarketListItem;
import frontend.zanatciu.com.zanatciu.R;

public class CustomAdapterAplikimePune extends BaseAdapter {

    ArrayList<JobMarketListItem> jobMarketList;

    Context context;
    CircleImageView profileImagePunedhenesi;
    TextView emriPunedhenesit;
    Button aprovo;
    TextView afatiKohorIAplikimit;


    public CustomAdapterAplikimePune(Context context, ArrayList<JobMarketListItem> jobMarketList) {

        this.context = context;
        this.jobMarketList = jobMarketList;

    }


    @Override
    public int getCount() {
        return 0;
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        LayoutInflater layoutInflater = LayoutInflater.from(context);
        convertView = layoutInflater.inflate(R.layout.aplikime_custom_list_item, null);

        profileImagePunedhenesi = convertView.findViewById(R.id.profile_image);
        emriPunedhenesit = convertView.findViewById(R.id.emri);
        aprovo = convertView.findViewById(R.id.Aprovo);
        afatiKohorIAplikimit = convertView.findViewById(R.id.countDownValidation);

        jobMarketList.get(position);


        //Kusht if user profile punedhenes nga abonimi atehere lejoje te beje aprovim ndryshe
        //ngjyra e butonit ndryshon edhe nuk klikon dot


        aprovo.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {

                //dergo Request per aprovim ne keto te dhena do kete edhe te dhenat e user profilit qe ne kete rast eshte

            }
        });

        return convertView;
    }
}
