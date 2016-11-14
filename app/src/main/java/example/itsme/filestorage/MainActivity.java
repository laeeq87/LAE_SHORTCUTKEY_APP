package example.itsme.filestorage;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.res.AssetManager;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    ListView lv;
    String[] titles;
    ArrayList<String> first=new ArrayList<>();
    ArrayList<String> last=new ArrayList<>();
    public static final String LOGTAG="EXP";
    String item;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        lv= (ListView) findViewById(R.id.list);
        titles=getResources().getStringArray(R.array.titles);
//        final ArrayAdapter adapter=new ArrayAdapter(this,android.R.layout.simple_list_item_1,titles);
        ArrayAdapter<String> ShortcutArrayAdapter = new CustomAdapter(MainActivity.this,titles);


        lv.setAdapter(ShortcutArrayAdapter);
        lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
              item = (String) lv.getItemAtPosition(position);

                if (item.equals("General Shortcuts")) {

                    String name = readFileFromAsset("generalShortcuts.txt");
                }

                if(item.equals("MS Basic Shortcuts")){

                    String name = readFileFromAsset("MS_Basic_Shortcuts.txt");

                }
                if(item.equals("General Keyboard")){

                    String name = readFileFromAsset("The_general_shortcuts.txt");

                }


                Intent intent=new Intent(MainActivity.this,SecondActivity.class);
                intent.putExtra("Item_name",item);
                intent.putStringArrayListExtra("shortcut",first);
                Log.i(LOGTAG,"Paasing into Intent "+first);
                intent.putStringArrayListExtra("description",last);
                Log.i(LOGTAG,"Paasing into Intent "+last);
                startActivity(intent);
            }
        });
    }

    private String readFileFromAsset(String filename){
        BufferedReader reader=null;
        StringBuilder builder=new StringBuilder();
        String line;

        try {
            reader = new BufferedReader(new InputStreamReader(
                    getAssets().open(filename)));

            first.clear();
            last.clear();


            while ((line = reader.readLine()) != null) {

                String[] b=line.split(":");


                        first.add(b[0]);
                        last.add(b[1]);
                Log.i(LOGTAG,first.toString());
            }

        }catch (IOException e) {
            Toast.makeText(MainActivity.this,"This is Exception"+e.getMessage(),Toast.LENGTH_LONG).show();
        } finally {
            try {
                reader.close();
            } catch (IOException e) {
                e.printStackTrace();
            }

        }
        return null;

    }

}
