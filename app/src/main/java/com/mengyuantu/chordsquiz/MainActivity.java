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
    private int score(boolean questionOneRight, boolean questionTwoRightOne, boolean questionTwoRightTwo, boolean questionThreeRight, boolean questionFourRight){

        int baseScore = 0;

        if (questionOneRight){
            baseScore = baseScore + 1;
        }
        if (questionTwoRightOne && questionTwoRightTwo){
            baseScore = baseScore + 1;
        }
        if (questionThreeRight){
            baseScore = baseScore + 1;
        }
        if (questionFourRight){
            baseScore = baseScore + 1;
        }

        return baseScore * 25;
    }
    private String createSummary(String name, int score, boolean questionOneRight, boolean questionTwoRightOne, boolean questionTwoRightTwo,boolean questionThreeRight, boolean questionFourRight){
        String summary = "Hi, " + name;
        summary += "\n" + "Question one's answer is F chord";
        if (questionOneRight){
            summary += "\n" + "Your answer is right";
        }
        else {
            summary += "\n" + "Your anwer is wrong";
        }
        summary += "\n" + "Question two's answer is A chord and E chord";
        if (questionTwoRightOne && questionTwoRightTwo){
            summary += "\n" +"Your anwer is right";
        }
        else{
            summary += "\n" + "Your anwer is wrong";
        }
        summary += "\n" + "Question Three's answer is Bm chord";
        if (questionThreeRight){
            summary += "\n" + "Your answer is right";
        }
        else {
            summary += "\n" + "Your answer is wrong";
        }
        summary += "\n" + "Question Three's answer is G chord";
        if (questionFourRight){
            summary += "\n" + "Your answer is right";
        }
        else {
            summary += "\n" + "Your answer is wrong";
        }
        summary += "\n" + "Your total score is " + score;

        return summary;

    }
    public void submit(View view){
        EditText nameField = (EditText)findViewById(R.id.name_input);
        String name = nameField.getText().toString();

        RadioButton questionOne = (RadioButton)findViewById(R.id.question_one_answer);
        boolean questionOneRight = questionOne.isChecked();

        CheckBox questionTwoAnswerOne = (CheckBox)findViewById(R.id.question_two_answer_one);
        boolean questionTwoRightOne = questionTwoAnswerOne.isChecked();

        CheckBox questionTwoAnswerTwo = (CheckBox)findViewById(R.id.question_two_answer_two);
        boolean questionTwoRightTwo = questionTwoAnswerTwo.isChecked();

        RadioButton questionThree = (RadioButton)findViewById(R.id.question_three_answer);
        boolean questionThreeRight = questionThree.isChecked();

        RadioButton questionFour = (RadioButton)findViewById(R.id.question_four_answer);
        boolean questionFourRight = questionThree.isChecked();

        int totalScore = score(questionOneRight,questionTwoRightOne,questionTwoRightTwo,questionThreeRight, questionFourRight);

        String Message = createSummary(name,totalScore,questionOneRight,questionTwoRightOne,questionTwoRightTwo,questionThreeRight, questionFourRight);

        Toast.makeText(MainActivity.this, Message, Toast.LENGTH_LONG).show();
    }

}
