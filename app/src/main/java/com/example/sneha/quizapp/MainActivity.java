package com.example.sneha.quizapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void calculateScore(View view) {
        String[] answers = evaluateGui();

        int result = evaluateQuiz(answers);

        toastResult(result);
    }

    public String[] evaluateGui() {
        String[] ret = new String[8];

        EditText editTextQuestion2 = (EditText) findViewById(R.id.question2);

        CheckBox checkBoxQuestion3Asia = (CheckBox) findViewById(R.id.question3_Asia);
        CheckBox checkBoxQuestion3Europe = (CheckBox) findViewById(R.id.question3_Europe);
        CheckBox checkBoxQuestion3North = (CheckBox) findViewById(R.id.question3_North_America);
        CheckBox checkBoxQuestion3South = (CheckBox) findViewById(R.id.question3_South_America);

        Boolean answerQuestion3 = false;

        if (checkBoxQuestion3Asia.isChecked() && checkBoxQuestion3Europe.isChecked() && !checkBoxQuestion3North.isChecked() && !checkBoxQuestion3South.isChecked()) {
            answerQuestion3 = true;
        }

        EditText editTextQuestion4 = (EditText) findViewById(R.id.question4);

        EditText editTextQuestion6 = (EditText) findViewById(R.id.question6);

        CheckBox checkBoxQuestion7AusOpen = (CheckBox) findViewById(R.id.question7_Australian_Open);
        CheckBox checkBoxQuestion7FrenchOpen = (CheckBox) findViewById(R.id.question7_French_Open);
        CheckBox checkBoxQuestion7Wimbledon = (CheckBox) findViewById(R.id.question7_Wimbledon);
        CheckBox checkBoxQuestion7USOpen = (CheckBox) findViewById(R.id.question7_US_Open);

        Boolean answerQuestion7 = false;

        Boolean aus = checkBoxQuestion7AusOpen.isChecked();
        Boolean french = checkBoxQuestion7FrenchOpen.isChecked();
        Boolean wimbledon = checkBoxQuestion7Wimbledon.isChecked();
        Boolean us = checkBoxQuestion7USOpen.isChecked();

        if (aus && !french && wimbledon && us) {
            answerQuestion7 = true;
        }

        EditText editTextQuestion8 = (EditText) findViewById(R.id.question8);

        ret[0] = evaluateRadioGroup(R.id.radioGroup_question1).toLowerCase();
        ret[1] = editTextQuestion2.getText().toString().toLowerCase();
        ret[2] = Boolean.toString(answerQuestion3);
        ret[3] = editTextQuestion4.getText().toString().toLowerCase();
        ret[4] = evaluateRadioGroup(R.id.radioGroup_question5).toLowerCase();
        ret[5] = editTextQuestion6.getText().toString().toLowerCase();
        ret[6] = Boolean.toString(answerQuestion7);
        ret[7] = editTextQuestion8.getText().toString().toLowerCase();

        return ret;
    }

    public int evaluateQuiz(String[] answers) {
        int result = 0;
        String[] correctAnswers = {"san juan", "jennifer aniston","true","china", "usain bolt", "czech republic", "true", "india"};

        for (int i = 0; i < correctAnswers.length; i++) {
            if (answers[i].equals(correctAnswers[i])) {
                result++;
            }
        }
        return result;
    }
    public void toastResult(int result) {
        String message = result + " out of 8. ";

        Toast reportResult = Toast.makeText(getApplicationContext(), message,
                Toast.LENGTH_SHORT);
        reportResult.show();
    }
    private String evaluateRadioGroup(int id) {
        RadioGroup radioGroupQuestion;
        RadioButton radioButtonQuestion;

        radioGroupQuestion = (RadioGroup) findViewById(id);

        int radioButtonId = radioGroupQuestion.getCheckedRadioButtonId();
        radioButtonQuestion = (RadioButton) findViewById(radioButtonId);

        if (radioButtonQuestion == null) {
            return "";
        }

        return (String)radioButtonQuestion.getText();
    }
    public void reset(View view) {
        RadioGroup radioGroup1 = (RadioGroup) findViewById(R.id.radioGroup_question1);
        radioGroup1.clearCheck();

        EditText editText2 = (EditText) findViewById(R.id.question2);
        editText2.setText("");

        CheckBox checkBox3 = (CheckBox) findViewById(R.id.question3_Asia);
        checkBox3.setChecked(false);

        checkBox3 = (CheckBox) findViewById(R.id.question3_Europe);
        checkBox3.setChecked(false);

        checkBox3 = (CheckBox) findViewById(R.id.question3_North_America);
        checkBox3.setChecked(false);

        checkBox3 = (CheckBox) findViewById(R.id.question3_South_America);
        checkBox3.setChecked(false);

        EditText editText4 = (EditText) findViewById(R.id.question4);
        editText4.setText("");

        RadioGroup radioGroup5 = (RadioGroup) findViewById(R.id.radioGroup_question5);
        radioGroup5.clearCheck();

        EditText editText6 = (EditText) findViewById(R.id.question6);
        editText6.setText("");

        CheckBox checkBox7 = (CheckBox) findViewById(R.id.question7_Australian_Open);
        checkBox7.setChecked(false);

        checkBox7 = (CheckBox) findViewById(R.id.question7_French_Open);
        checkBox7.setChecked(false);

        checkBox7 = (CheckBox) findViewById(R.id.question7_Wimbledon);
        checkBox7.setChecked(false);

        checkBox7 = (CheckBox) findViewById(R.id.question7_US_Open);
        checkBox7.setChecked(false);

        EditText editText8 = (EditText) findViewById(R.id.question8);
        editText8.setText("");
    }
}

