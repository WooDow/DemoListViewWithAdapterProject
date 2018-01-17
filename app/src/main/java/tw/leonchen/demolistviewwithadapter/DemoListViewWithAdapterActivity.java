package tw.leonchen.demolistviewwithadapter;

import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.Toast;

public class DemoListViewWithAdapterActivity extends AppCompatActivity {

    //private String[] color = {"red", "green", "blue", "purple", "pink", "yellow", "black"};
    private String[] color;
    private ListView listView;
    private int colorCode;
    private LinearLayout linear;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_demo_list_view_with_adapter);

        color = getResources().getStringArray(R.array.myColors);

        linear = (LinearLayout) findViewById(R.id.linear);

        ArrayAdapter<String> adapter = new ArrayAdapter<String>(DemoListViewWithAdapterActivity.this, android.R.layout.simple_list_item_1, color);
        listView = (ListView)findViewById(R.id.listView);
        listView.setAdapter(adapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long id) {
                colorCode = 0;

                switch(position){
                    case 0:
                        colorCode = Color.RED;
                        linear.setBackgroundColor(colorCode);
                        break;
                    default:
                        linear.setBackgroundColor(colorCode);
                        break;
                }

                Toast.makeText(DemoListViewWithAdapterActivity.this, color[position], Toast.LENGTH_SHORT).show();
            }
        });
    }
}
