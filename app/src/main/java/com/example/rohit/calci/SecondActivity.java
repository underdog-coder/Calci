package com.example.rohit.calci;

import android.content.DialogInterface;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class SecondActivity extends AppCompatActivity {
    private EditText editText;
    private String input="";
    private int positionOfCursor;
    private Button zero;
    private Button dot;
    private Button divide;
    private Button equals;
    private Button one;
    private Button two;
    private Button three;
    private Button multiply;
    private Button four;
    private Button five;
    private Button six;
    private Button minus;
    private Button seven;
    private Button eight;
    private Button nine;
    private Button plus;
    private Button start;
    private Button end;
    private Button erase;
    private Button cancel;
    protected void onCreate(Bundle myState){
        super.onCreate(myState);
        setContentView(R.layout.second_layout);
        editText  = findViewById(R.id.editText);
        zero = findViewById(R.id.zero);
        dot = findViewById(R.id.buttonDot);
        divide = findViewById(R.id.buttonDivide);
        equals = findViewById(R.id.equals);
        one = findViewById(R.id.one);
        two = findViewById(R.id.two);
        three = findViewById(R.id.three);
        multiply = findViewById(R.id.multiply);
        four = findViewById(R.id.four);
        five = findViewById(R.id.five);
        six = findViewById(R.id.six);
        minus = findViewById(R.id.minus);
        seven = findViewById(R.id.seven);
        eight = findViewById(R.id.eight);
        nine = findViewById(R.id.nine);
        plus = findViewById(R.id.plus);
        start = findViewById(R.id.startBracket);
        end = findViewById(R.id.endBracket);
        erase = findViewById(R.id.oneStepErase);
        cancel = findViewById(R.id.cancel);

        zero.setOnClickListener(new myOnClickListener1());
        dot.setOnClickListener(new myOnClickListener1());
        divide.setOnClickListener(new myOnClickListener1());
        equals.setOnClickListener(new myOnClickListener4());
        one.setOnClickListener(new myOnClickListener1());
        two.setOnClickListener(new myOnClickListener1());
        three.setOnClickListener(new myOnClickListener1());
        multiply.setOnClickListener(new myOnClickListener1());
        four.setOnClickListener(new myOnClickListener1());
        five.setOnClickListener(new myOnClickListener1());
        six.setOnClickListener(new myOnClickListener1());
        minus.setOnClickListener(new myOnClickListener1());
        seven.setOnClickListener(new myOnClickListener1());
        eight.setOnClickListener(new myOnClickListener1());
        nine.setOnClickListener(new myOnClickListener1());
        plus.setOnClickListener(new myOnClickListener1());
        start.setOnClickListener(new myOnClickListener1());
        end.setOnClickListener(new myOnClickListener1());
        erase.setOnClickListener(new myOnClickListener2());
        cancel.setOnClickListener(new myOnClickListener3());
        editText.setShowSoftInputOnFocus(false);
    }
    class myOnClickListener1 implements View.OnClickListener{
        @Override
        public void onClick(View v) {
            Button btn = (Button)v;
            input += btn.getText().toString();
            editText.setText(input);
            positionOfCursor = editText.getText().length();
            editText.setSelection(positionOfCursor);
        }
    }
    class myOnClickListener2 implements View.OnClickListener{
        @Override
        public void onClick(View v) {
            input ="";
            editText.setText(input);
            positionOfCursor = editText.getText().length();
            editText.setSelection(positionOfCursor);
        }
    }
    class myOnClickListener3 implements View.OnClickListener{
        @Override
        public void onClick(View v) {
            try{
                input = input.substring(0,input.length()-1);
                editText.setText(input);
                positionOfCursor = editText.getText().length();
                editText.setSelection(positionOfCursor);
            }catch (Exception e){

            }
        }
    }
    class myOnClickListener4 implements View.OnClickListener{
        public void onClick(View v){
        }
    }

}
