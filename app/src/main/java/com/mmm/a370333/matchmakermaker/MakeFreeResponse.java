package com.mmm.a370333.matchmakermaker;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Button;
import android.view.View;

/**
 * Created by 370333 on 5/30/17.
 */
public class MakeFreeResponse extends Activity {
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.make_freeresponse);
        final Bundle bundle = getIntent().getExtras();
        final int questionNumber = (int)bundle.get("questionAmount");
        final String[] fr_questions = bundle.getStringArray("fr_questions");
        final String[] fr_answers = bundle.getStringArray("fr_answers");
        System.out.println(fr_questions);
        //final Bundle bundle = getIntent().getExtras();
        //int questionAmount = bundle.getInt("questionAmount");
        final EditText question = (EditText)findViewById(R.id.et_question);
        final EditText answer = (EditText) findViewById(R.id.et_answer);
        Integer[] pointItems = {0, 1, 2, 3, 4, 5};
        final Spinner pointValue = (Spinner) findViewById(R.id.spn_questionPoints);
        ArrayAdapter<Integer> adapter = new ArrayAdapter<Integer>(this, R.layout.support_simple_spinner_dropdown_item, pointItems);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        pointValue.setAdapter(adapter);
        //questionAmount--;

        //Intent intentBundle = new Intent(MakeFreeResponse.this,QuestionType.class);
        //final Bundle bundleNew = new Bundle();
        //bundle.putInt("questionAmount",questionAmount);

        Button btn_next = (Button) findViewById(R.id.btn_next);
        btn_next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent int_next = new Intent(v.getContext(), QuestionType.class);
                fr_questions[questionNumber] = question.getText().toString();
                fr_answers[questionNumber] = answer.getText().toString();

                int_next.putExtras(bundle);
                startActivityForResult(int_next, 0);
            }
        });
    }
}
