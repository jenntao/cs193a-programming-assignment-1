/*
 * Jennifer Tao <jenntao@stanford.edu>
 * Final Grade Calculator - This app calculates a final or average grade from up to five inputs
 * (grades and their associated weights) from the user. Grades can be inputted as decimal values.
 * Weights can be inputted as integer values. Includes a button that clears all current inputs and
 * results.
 */



package com.example.jennifer.finalgradecalculator;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    // Instance variables to keep track of grade and weight values
    private double g1_val, g2_val, g3_val, g4_val, g5_val;
    private int w1_val, w2_val, w3_val, w4_val, w5_val;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        resetAllValues();
    }

    // Calculates the total or average grade from the user's inputted values
    public void calculateButtonClick(View view) {
        resetAllValues();
        setGrades();
        setWeights();

        TextView result = (TextView) findViewById(R.id.resultText);
        if (checkGradeWeightPairs()) {
            int weight_total = w1_val + w2_val + w3_val + w4_val + w5_val;
            if (weight_total == 0) {
                result.setText("Weight sums to 0");
            } else if (weight_total > 100) {
                result.setText("Weight sums to over 100");
            } else {
                double final_grade = (g1_val * w1_val) + (g2_val * w2_val) + (g3_val * w3_val)
                        + (g4_val * w4_val) + (g5_val * w5_val);
                final_grade /= weight_total;
                if (weight_total == 100) {
                    result.setText("Your final grade is " + final_grade);
                } else {
                    result.setText("Your current average grade is " + final_grade +
                            " for a total assignment weight of " + weight_total);
                }
            }
        } else {
            result.setText("Please check that each grade is assigned a weight, " +
                    "and each weight is assigned a grade");
        }
    }

    // Checks that each grade value has a respective weight value, and vice versa
    private boolean checkGradeWeightPairs() {
        if (((EditText)findViewById(R.id.grade1)).getText().toString().equals("") !=
                ((EditText)findViewById(R.id.weight1)).getText().toString().equals("")) {
            return false;
        }
        if (((EditText)findViewById(R.id.grade2)).getText().toString().equals("") !=
                ((EditText)findViewById(R.id.weight2)).getText().toString().equals("")) {
            return false;
        }
        if (((EditText)findViewById(R.id.grade3)).getText().toString().equals("") !=
                ((EditText)findViewById(R.id.weight3)).getText().toString().equals("")) {
            return false;
        }
        if (((EditText)findViewById(R.id.grade4)).getText().toString().equals("") !=
                ((EditText)findViewById(R.id.weight4)).getText().toString().equals("")) {
            return false;
        }
        if (((EditText)findViewById(R.id.grade5)).getText().toString().equals("") !=
                ((EditText)findViewById(R.id.weight5)).getText().toString().equals("")) {
            return false;
        }
        return true;
    }

    // Extracts the grades inputted by the user
    private void setGrades() {
        EditText g1 = (EditText) findViewById(R.id.grade1);
        if (!g1.getText().toString().equals("")) {
            g1_val = Double.parseDouble(g1.getText().toString());
        }
        EditText g2 = (EditText) findViewById(R.id.grade2);
        if (!g2.getText().toString().equals("")) {
            g2_val = Double.parseDouble(g2.getText().toString());
        }
        EditText g3 = (EditText) findViewById(R.id.grade3);
        if (!g3.getText().toString().equals("")) {
            g3_val = Double.parseDouble(g3.getText().toString());
        }
        EditText g4 = (EditText) findViewById(R.id.grade4);
        if (!g4.getText().toString().equals("")) {
            g4_val = Double.parseDouble(g4.getText().toString());
        }
        EditText g5 = (EditText) findViewById(R.id.grade5);
        if (!g5.getText().toString().equals("")) {
            g5_val = Double.parseDouble(g5.getText().toString());
        }
    }

    // Extracts the weights inputted by the user
    private void setWeights() {
        EditText w1 = (EditText) findViewById(R.id.weight1);
        if (!w1.getText().toString().equals("")) {
            w1_val = Integer.parseInt(w1.getText().toString());
        }
        EditText w2 = (EditText) findViewById(R.id.weight2);
        if (!w2.getText().toString().equals("")) {
            w2_val = Integer.parseInt(w2.getText().toString());
        }
        EditText w3 = (EditText) findViewById(R.id.weight3);
        if (!w3.getText().toString().equals("")) {
            w3_val = Integer.parseInt(w3.getText().toString());
        }
        EditText w4 = (EditText) findViewById(R.id.weight4);
        if (!w4.getText().toString().equals("")) {
            w4_val = Integer.parseInt(w4.getText().toString());
        }
        EditText w5 = (EditText) findViewById(R.id.weight5);
        if (!w5.getText().toString().equals("")) {
            w5_val = Integer.parseInt(w5.getText().toString());
        }
    }

    // Clears all existing user inputs and result outputs
    public void clearAll(View view) {
        resetAllValues();

        ((EditText) findViewById(R.id.weight1)).setText("");
        ((EditText) findViewById(R.id.weight2)).setText("");
        ((EditText) findViewById(R.id.weight3)).setText("");
        ((EditText) findViewById(R.id.weight4)).setText("");
        ((EditText) findViewById(R.id.weight5)).setText("");

        ((EditText) findViewById(R.id.grade1)).setText("");
        ((EditText) findViewById(R.id.grade2)).setText("");
        ((EditText) findViewById(R.id.grade3)).setText("");
        ((EditText) findViewById(R.id.grade4)).setText("");
        ((EditText) findViewById(R.id.grade5)).setText("");
        ((TextView) findViewById(R.id.resultText)).setText("");
    }

    // Resets all instance values to a default value of 0
    private void resetAllValues(){
        g1_val = g2_val = g3_val = g4_val = g5_val = 0.0;
        w1_val = w2_val = w3_val = w4_val = w5_val = 0;
    }
}