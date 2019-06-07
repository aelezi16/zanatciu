package frontend.zanatciu.com.zanatciu.PunetEMia.Utilities;


import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.ArrayList;

import de.hdodenhof.circleimageview.CircleImageView;
import frontend.zanatciu.com.zanatciu.Kreu.JsonBlueprintLayer.Responses.ServiceMarketListItem;
import frontend.zanatciu.com.zanatciu.R;

public class CustomAdapterKreuSherbim extends BaseAdapter {

    ArrayList<ServiceMarketListItem> serviceMarketListItems;
    Context context;
    CircleImageView circleImageView;
    TextView title;
    TextView price_wage;


    public CustomAdapterKreuSherbim(Context context, ArrayList<ServiceMarketListItem> serviceMarketListItems) {

        this.context = context;
        this.serviceMarketListItems = serviceMarketListItems;

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
        convertView = layoutInflater.inflate(R.layout.kreu_custom_list_item, null);

        circleImageView = convertView.findViewById(R.id.profile_image);
        title = convertView.findViewById(R.id.title);
        price_wage = convertView.findViewById(R.id.price_wage);

        serviceMarketListItems.get(position);


        return convertView;
    }
}
