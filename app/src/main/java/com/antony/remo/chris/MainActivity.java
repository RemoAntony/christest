package com.antony.remo.chris;

import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;


public class MainActivity extends ActionBarActivity {
TextView t1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        t1=(TextView)findViewById(R.id.t1);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    public void remo(View view)
    {
        SQLiteDatabase db=openOrCreateDatabase("chris",MODE_PRIVATE,null);

        LinearLayout lv=(LinearLayout)findViewById(R.id.linlayout);
        String temp=t1.getText().toString();
        Toast.makeText(MainActivity.this,"Hello chris"+temp,Toast.LENGTH_LONG).show();
        LayoutInflater li=(LayoutInflater)getSystemService(LAYOUT_INFLATER_SERVICE);
        for(int i=0;i<100;i++)
        {
            TextView t=(TextView)li.inflate(R.layout.customtext,null);
            TextView tv=new TextView(this);
            tv.setText("Text"+i);
            tv.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    TextView t = (TextView) view;
                    Toast.makeText(MainActivity.this, "" + t.getText().toString(), Toast.LENGTH_LONG).show();
                }
            });
            lv.addView(tv);
        }

    }
}
