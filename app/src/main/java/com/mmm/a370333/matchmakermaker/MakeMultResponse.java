package com.mmm.a370333.matchmakermaker;

import android.app.Activity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

/**
 * Created by 370333 on 6/8/17.
 */
public class MakeMultResponse extends Activity{

    public void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.make_multresponse);
        Integer[] pointItems = {0, 1, 2, 3, 4, 5};
        Spinner point1 = (Spinner) findViewById(R.id.spn_pts1);
        Spinner point2 = (Spinner) findViewById(R.id.spn_pts2);
        Spinner point3 = (Spinner) findViewById(R.id.spn_pts3);
        ArrayAdapter<Integer> adapter = new ArrayAdapter<Integer>(this, R.layout.support_simple_spinner_dropdown_item, pointItems);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        point1.setAdapter(adapter);
        point2.setAdapter(adapter);
        point3.setAdapter(adapter);
    }
}
