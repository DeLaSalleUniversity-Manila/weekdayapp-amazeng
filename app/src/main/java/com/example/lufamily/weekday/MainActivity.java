package com.example.lufamily.weekday;

import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;


public class MainActivity extends ActionBarActivity {

    private TextView tv_out;
    private int d, m, y1, y2, y, day;
    private String day_text;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

    }

    private void getInputValues()
    {
        EditText et_day = (EditText) findViewById(R.id.editTextDay);
        EditText et_month = (EditText) findViewById(R.id.editTextMonth);
        EditText et_year = (EditText) findViewById(R.id.editTextYear);

        day = Integer.parseInt(et_day.getText().toString());
        m = Integer.parseInt(et_month.getText().toString());
        y = Integer.parseInt(et_year.getText().toString());
    }

    public void onClickCompute(View v)
    {
        getInputValues();
        computeDay();
        printDay();
    }

    public void printDay()
    {
        tv_out = (TextView) findViewById(R.id.textViewOut);
        tv_out.setText(day_text);
    }

    private void computeDay()
    {
        y1 = y / 100;
        y2 = y % 100;

        if(m == 1)
        {
            m = 13;
        }

        if (m == 2)
        {
            m = 14;
        }

        d = (day + ((26*(m + 1))/10) + y2 + (y2 / 4) + (y1 / 4) + (5 * y1)) % 7;

        switch(d)
        {
            case 0:
                day_text = "The day is Saturday";
                break;
            case 1:
                day_text = "The day is Sunday";
                break;
            case 2:
                day_text = "The day is Monday";
                break;
            case 3:
                day_text = "The day is Tuesday";
                break;
            case 4:
                day_text = "The day is Wednesday";
                break;
            case 5:
                day_text = "The day is Thursday";
                break;
            case 6:
                day_text = "The day is Friday";
                break;
        }
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
}
