package com.mengyuantu.chordsquiz;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    private int score(boolean questionOneRight, boolean questionTwoRightOne, boolean questionTwoRightTwo, boolean questionTwoRightThree, boolean questionThreeRight, boolean questionFourRight, int questionFiveRight) {

        int baseScore = 0;

        if (questionOneRight) {
            baseScore++;
        }
        if (questionTwoRightOne && questionTwoRightTwo && !questionTwoRightThree) {
            baseScore++;
        }
        if (questionThreeRight) {
            baseScore++;
        }
        if (questionFourRight) {
            baseScore++;
        }
        if (questionFiveRight == 6) {
            baseScore++;
        }
        return baseScore * 20;
    }

    private String createSummary(int score, boolean questionOneRight, boolean questionTwoRightOne, boolean questionTwoRightTwo, boolean questionTwoRightThree, boolean questionThreeRight, boolean questionFourRight, int questionFiveRight) {
        String summary = "Question one's answer is F chord";
        if (questionOneRight) {
            summary += "\n" + "Your answer is right";
        } else {
            summary += "\n" + "Your anwer is wrong";
        }
        summary += "\n" + "Question two's answer is A chord and E chord";
        if (questionTwoRightOne && questionTwoRightTwo && !questionTwoRightThree) {
            summary += "\n" + "Your anwer is right";
        } else {
            summary += "\n" + "Your anwer is wrong";
        }
        summary += "\n" + "Question Three's answer is Bm chord";
        if (questionThreeRight) {
            summary += "\n" + "Your answer is right";
        } else {
            summary += "\n" + "Your answer is wrong";
        }
        summary += "\n" + "Question Four's answer is G chord";
        if (questionFourRight) {
            summary += "\n" + "Your answer is right";
        } else {
            summary += "\n" + "Your answer is wrong";
        }
        summary += "\n" + "Question Five's answer is 6";
        if (questionFiveRight == 6) {
            summary += "\n" + "Your answer is right";
        } else {
            summary += "\n" + "Your answer is wrong";
        }
        summary += "\n" + "Your total score is " + score;

        return summary;

    }

    public void submit(View view) {

        RadioButton questionOne = (RadioButton) findViewById(R.id.question_one_answer);
        boolean questionOneRight = questionOne.isChecked();

        CheckBox questionTwoAnswerOne = (CheckBox) findViewById(R.id.question_two_answer_one);
        boolean questionTwoRightOne = questionTwoAnswerOne.isChecked();

        CheckBox questionTwoAnswerTwo = (CheckBox) findViewById(R.id.question_two_answer_two);
        boolean questionTwoRightTwo = questionTwoAnswerTwo.isChecked();

        CheckBox questionTwoAnswerThree = (CheckBox) findViewById(R.id.question_two_answer_three);
        boolean questionTwoRightThree = questionTwoAnswerThree.isChecked();

        RadioButton questionThree = (RadioButton) findViewById(R.id.question_three_answer);
        boolean questionThreeRight = questionThree.isChecked();

        RadioButton questionFour = (RadioButton) findViewById(R.id.question_four_answer);
        boolean questionFourRight = questionFour.isChecked();

        EditText stringNumber = (EditText) findViewById(R.id.question_five_answer);
        int questionFiveRight = Integer.parseInt(stringNumber.getText().toString());


        int totalScore = score(questionOneRight, questionTwoRightOne, questionTwoRightTwo, questionTwoRightThree, questionThreeRight, questionFourRight, questionFiveRight);

        String Message = createSummary(totalScore, questionOneRight, questionTwoRightOne, questionTwoRightTwo, questionTwoRightThree, questionThreeRight, questionFourRight, questionFiveRight);

        Toast.makeText(MainActivity.this, Message, Toast.LENGTH_LONG).show();
    }

}
