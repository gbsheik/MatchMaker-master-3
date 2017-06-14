package com.mmm.a370333.matchmakermaker;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.TextView;

/**
 * Created by 370333 on 5/30/17.
 */
public class QuestionType extends Activity{
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        int questionAmount = 0;
        final Bundle bundle = getIntent().getExtras();
        if (getIntent() != null) {
            questionAmount = (int) bundle.get("questionAmount");
        }
        /*if (bundle.get("fr_questions") != null){
            System.out.println(((String[])bundle.get("fr_questions"))[(int)bundle.get("questionAmount")]);
        }*/
        bundle.putInt("questionAmount", questionAmount-1);
        System.out.println(questionAmount);
        questionAmount = (int) bundle.get("questionAmount");
        final TextView questionNum = (TextView) findViewById(R.id.questionNumber);
        //questionNum.setText("asdf" + questionAmount);

        if (questionAmount > 0) {
            setContentView(R.layout.questiontype);
            final Spinner questionType = (Spinner) findViewById(R.id.spn_questionType);
            ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this, R.array.sa_questionType, android.R.layout.simple_spinner_item);
            adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
            questionType.setAdapter(adapter);

            questionAmount--;
            Button btn_next = (Button) findViewById(R.id.btn_make);
            btn_next.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    String type = questionType.getSelectedItem().toString();
                    if (type.equals("Free Response")) {
                        Intent int_next = new Intent(v.getContext(), MakeFreeResponse.class);
                        int_next.putExtras(bundle);
                        startActivityForResult(int_next, 0);
                    } else if (type.equals("Multiple Choice")) {
                        Intent int_next = new Intent(v.getContext(), MakeMultResponse.class);
                        int_next.putExtras(bundle);
                        startActivityForResult(int_next, 0);
                    }
                }
            });
        }
    }
}

