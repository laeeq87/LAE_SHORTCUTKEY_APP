package example.itsme.filestorage;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class SecondActivity extends AppCompatActivity {

    TableLayout tableLayout;
    ArrayList<String> shortcuts = new ArrayList<>();
    ArrayList<String> description = new ArrayList<>();
    TableRow tr;
    public static final String LOGTAG = "EXP";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        String ItemName = getIntent().getStringExtra("Item_name");
        shortcuts = getIntent().getStringArrayListExtra("shortcut");
        description = getIntent().getStringArrayListExtra("description");
//    Log.i(LOGTAG,"This is Detail aactivity "+ItemName);
//    Log.i(LOGTAG,"This is Detail aactivity shortcuts "+shortcuts);
//    Log.i(LOGTAG,"This is Detail aactivity  description "+description);
        TextView title = (TextView) findViewById(R.id.tvTitle);
        title.setText(ItemName);


        tableLayout = (TableLayout) findViewById(R.id.table_layout);
        tableLayout.setStretchAllColumns(true);
        tableLayout.bringToFront();


        for (int i = 0; i < shortcuts.size(); i++) {
            LayoutInflater inflater = (LayoutInflater) this.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            tr = (TableRow) inflater.inflate(R.layout.single_row, null);

            TextView tv = (TextView) tr.findViewById(R.id.key);
            tv.setText(shortcuts.get(i));
//        Log.i(LOGTAG,"This is tv set in Row"+tv);

            TextView des = (TextView) tr.findViewById(R.id.description);
            des.setText(description.get(i));

            tableLayout.addView(tr);

        }


    }
}

