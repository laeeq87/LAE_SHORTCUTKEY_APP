package example.itsme.filestorage;

import android.app.Activity;
import android.content.Context;
import android.support.annotation.NonNull;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

/**
 * Created by itsme on 11/14/2016.
 */

public class CustomAdapter extends ArrayAdapter<String> {

    Context context;

    public CustomAdapter(Context context,String[] titles) {
        super(context,R.layout.single_list_item,titles);
        this.context=context;
    }

    @NonNull
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        LayoutInflater inflater= (LayoutInflater) context.getSystemService(Activity.LAYOUT_INFLATER_SERVICE);
        View view=inflater.inflate(R.layout.single_list_item,null);


        String title=getItem(position);

        TextView tv_title = (TextView) view.findViewById(R.id.tv_title);
        tv_title.setText(title);


        return view;
    }
}
