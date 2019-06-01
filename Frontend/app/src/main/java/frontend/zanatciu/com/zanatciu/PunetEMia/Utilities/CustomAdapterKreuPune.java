package frontend.zanatciu.com.zanatciu.PunetEMia.Utilities;

import android.content.Context;
import android.database.DataSetObserver;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListAdapter;
import android.widget.TextView;

import java.util.ArrayList;

import de.hdodenhof.circleimageview.CircleImageView;
import frontend.zanatciu.com.zanatciu.Kreu.JsonBlueprintLayer.Responses.JobMarketListItem;
import frontend.zanatciu.com.zanatciu.R;


public class CustomAdapterKreuPune implements ListAdapter {

    ArrayList<JobMarketListItem> jobMarketList;
    Context context;


    public CustomAdapterKreuPune(Context context, ArrayList<JobMarketListItem> jobMarketList) {

        this.context=context;
        this.jobMarketList=jobMarketList;

    }

    @Override
    public boolean areAllItemsEnabled() {
        return false;
    }

    @Override
    public boolean isEnabled(int position) {
        return false;
    }

    @Override
    public void registerDataSetObserver(DataSetObserver observer) {

    }

    @Override
    public void unregisterDataSetObserver(DataSetObserver observer) {

    }

    @Override
    public boolean hasStableIds() {
        return false;
    }

    @Override
    public int getItemViewType(int position) {
        return 0;
    }

    @Override
    public int getViewTypeCount() {
        return 1;
    }

    @Override
    public boolean isEmpty() {
        return false;
    }

    @Override
    public int getCount() {
        return jobMarketList.size();
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
        convertView = layoutInflater.inflate(R.layout.kreu_custom_list_item,null);

        CircleImageView circleImageView = convertView.findViewById(R.id.profile_image);
        TextView title=convertView.findViewById(R.id.title);
        TextView price_wage=convertView.findViewById(R.id.price_wage);


        JobMarketListItem jobMarketListItem=jobMarketList.get(position);


        circleImageView.setImageResource(R.drawable.logo2);
        title.setText(jobMarketListItem.getTitle());
        price_wage.setText(jobMarketListItem.getPrice_wage());

        return convertView;
    }


}
