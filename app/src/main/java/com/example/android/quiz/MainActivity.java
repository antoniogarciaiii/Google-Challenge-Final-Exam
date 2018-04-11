package com.example.android.quiz;

import android.content.Intent;
import android.net.Uri;
import android.nfc.Tag;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.util.Log;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    int score = 0;

    //each question adds 20 to the score--as in 20%, 'cause basic math.
    // finals, 'cause they don't change
    final int q1_Answer = R.id.q1_radiobutton_d;
    /* question 2 will be handled by its own method, because it's a
       checkbox w/2 answers that needs to work off a conditional statement */
    final String q3_Answer = "Development";
    final int q4_Answer = R.id.q4_b;
    final String q5_Answer = "calculateTip";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    // gets student's name, checks answers, displays score
    public void checkAnswers(View view){
        String studentName = findViewById(R.id.name_field).toString();

        checkQuestion1();
        checkQuestion2();
        checkQuestion3();
        checkQuestion4();
        checkQuestion5();

        String toastMessage = studentName + "you got " + score + "%";
        Toast grades = Toast.makeText(MainActivity.this, toastMessage, Toast.LENGTH_LONG);
        grades.show();
    }



    //checks question 1
    private /*boolean*/ void checkQuestion1() {
        //so, when i kept hitting the 'get a grade' button, it kept adding.
        //this is kind of a poor man's solution, but i'll find the proper solution later.
        score = 0;
        RadioGroup rg = (RadioGroup) findViewById(R.id.q1_group);

        if( rg.getCheckedRadioButtonId() == q1_Answer ) {
            score += 20;
//            return true;
        }

//        return false; // it's false, but we're not going to do anything with it. we're just kinda gonna move on.
    }

    // method to check question 2. i found an example online which makes a lovely use of conditional + AND statements
    private void checkQuestion2() {
        CheckBox q2CA = (CheckBox) findViewById(R.id.q2_a);
        CheckBox q2CB = (CheckBox) findViewById(R.id.q2_b);
        CheckBox q2CC = (CheckBox) findViewById(R.id.q2_c);
        CheckBox q2CD = (CheckBox) findViewById(R.id.q2_d);
        // if, and only if, A is checked, AND B is checked, AND C is not checked, AND C is not checked, return true.
        // the true value will be used when checking answers.
        if (q2CA.isChecked() && q2CB.isChecked() && !q2CC.isChecked() && !q2CD.isChecked()) {
            score += 20;
        }
    }

    // method to check question 3.
    private void checkQuestion3() {
        //EditText q3UserAnswer = (EditText) findViewById(R.id.q3_user_answer);
        String q3UserAnswer = findViewById(R.id.q3_user_answer).toString();
        if (q3UserAnswer == q3_Answer) {
            score += 20;
            //do we really need an else statement? can't we just have it move on if it's not right?
            //not getting the 20 points is penalty enough. i have a feeling we're just gonna have to void this.
        }
    }


    //check question 4
    private void checkQuestion4() {
        RadioGroup rg = (RadioGroup) findViewById(R.id.q4_group);

        if( rg.getCheckedRadioButtonId() == q4_Answer ) {
            score += 20;
        }

    }

    // method to check question 5.
    private void checkQuestion5() {
        String q5UserAnswer = findViewById(R.id.q5_user_answer).toString();
        // this should grab the text and turn it into a string, so that we can check it w/the answer
        if (q5UserAnswer == q5_Answer) {
            score += 20;
        }
    }

}
