package com.mmm.a370333.matchmakermaker;

        import android.app.Activity;
        import android.content.Intent;
        import android.support.v7.app.AppCompatActivity;
        import android.os.Bundle;
        import android.view.View;
        import android.widget.*;

/**
 * Created by 370333 on 5/24/17.
 */
public class QuestionAmount extends Activity{

    public void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.questionprompt);
        final Spinner questionNumber = (Spinner)findViewById(R.id.spn_questionAmount);
        Integer[] items = {5, 10, 15};
        ArrayAdapter<Integer> adapter = new ArrayAdapter<Integer>(this, R.layout.support_simple_spinner_dropdown_item, items);
        questionNumber.setAdapter(adapter);


        //This seems weird to me. Does this just mean that when the new activity starts, it will have this Intent.
        //Not that the new activity is called and started by this one
        //startActivity(intentBundle);

        Button btn_next = (Button) findViewById(R.id.btn_next);
        btn_next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Bundle bundle = new Bundle();
                final Intent intentBundle = new Intent(v.getContext(), QuestionType.class);
                bundle.putInt("questionAmount", (int) questionNumber.getSelectedItem());
                intentBundle.putExtras(bundle);
                int test = (Integer) intentBundle.getExtras().get("questionAmount");
                String[] fr_questions = new String[(int)questionNumber.getSelectedItem()];
                bundle.putStringArray("fr_questions",fr_questions);
                System.out.println(bundle.getStringArray("fr_questions"));
                String[] fr_answers = new String[(int)questionNumber.getSelectedItem()];
                bundle.putStringArray("fr_answers",fr_answers);
                int[] fr_points = new int[(int)questionNumber.getSelectedItem()];
                bundle.putIntArray("fr_points",fr_points);
                Intent int_next = new Intent(v.getContext(), QuestionType.class);
                //startActivityForResult(int_next, 0);
                intentBundle.putExtras(bundle);
                startActivity(intentBundle);
            }
        });

    }
}
