package com.example.rohit.calci;

import android.content.Context;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.content.res.Configuration;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.Stack;

public class SecondActivity extends AppCompatActivity {
    private EditText editText;
    private String input = "";
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
    private String append = "";
    private int op =0;
    private double exp1, exp2, exp3;
    private String s,s1,s2,s3;
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
            try{
                Button btn = (Button)v;
                positionOfCursor = editText.getSelectionStart();
                append = input.substring(0,positionOfCursor);
                append += btn.getText().toString();
                input = append + input.substring(positionOfCursor,input.length());
                editText.setText(input);
                editText.setSelection(append.length());
                append="";
            }catch (Exception e){

            }
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
                positionOfCursor = editText.getSelectionStart();
                if(positionOfCursor == editText.getText().length()){
                    input = input.substring(0,input.length()-1);
                    editText.setText(input);
                    positionOfCursor = editText.getText().length();
                }
                else{
                    append = input.substring(positionOfCursor,input.length());
                    input = input.substring(0,positionOfCursor-1)+ append;
                    append="";
                    editText.setText(input);
                    positionOfCursor -= 1;
                }
                editText.setSelection(positionOfCursor);
            }catch (Exception e){

            }
        }
    }
    class myOnClickListener4 implements View.OnClickListener{
        private Context context;
        private int flag = 0;
        private Stack <Character> stack = new Stack<Character>();
        private Stack <String>  solution = new Stack<String>();
        public void onClick(View v){
            stack.clear();
            flag = 0;
            if(input.charAt(input.length()-1) == '+'||input.charAt(input.length()-1) == '-'||input.charAt(input.length()-1) == '*'||input.charAt(input.length()-1) == '/'||input.charAt(input.length()-1) == '('||input.charAt(0) == '*' || input.charAt(0) == '/'){
                context = getApplicationContext();
                CharSequence text = "Incorrect Input !!!";
                int duration = Toast.LENGTH_SHORT;
                Toast toast = Toast.makeText(context,text,duration);
                toast.show();
                flag = 1;
            }
            else {
                for (int i = 0; i < input.length() - 1; i++) {
                    if (input.charAt(i) == input.charAt(i + 1) && (input.charAt(i) == '/' || input.charAt(i) == '*' || input.charAt(i) == '-' || input.charAt(i) == '+')) {
                        context = getApplicationContext();
                        CharSequence text = "Incorrect Input !!!";
                        int duration = Toast.LENGTH_SHORT;
                        Toast toast = Toast.makeText(context, text, duration);
                        toast.show();
                        flag = 1;
                    } else if ((input.charAt(i) == '/' && input.charAt(i + 1) == '*') || (input.charAt(i) == '*' && input.charAt(i + 1) == '/') || (input.charAt(i) == '/' && input.charAt(i + 1) == '+') || (input.charAt(i) == '+' && input.charAt(i + 1) == '/') || (input.charAt(i) == '/' && input.charAt(i + 1) == '-') || (input.charAt(i) == '-' && input.charAt(i + 1) == '/') || (input.charAt(i) == '+' && input.charAt(i + 1) == '-') || (input.charAt(i) == '-' && input.charAt(i + 1) == '+') || (input.charAt(i) == '+' && input.charAt(i + 1) == '*') || (input.charAt(i) == '*' && input.charAt(i + 1) == '+') || (input.charAt(i) == '-' && input.charAt(i + 1) == '*') || (input.charAt(i) == '*' && input.charAt(i + 1) == '-') || (input.charAt(i) == '(' && input.charAt(i + 1) == ')') || (input.charAt(i) == '(' && input.charAt(i + 1) == '*') || (input.charAt(i) == '(' && input.charAt(i + 1) == '/')) {
                        context = getApplicationContext();
                        CharSequence text = "Incorrect Input !!!";
                        int duration = Toast.LENGTH_SHORT;
                        Toast toast = Toast.makeText(context, text, duration);
                        toast.show();
                        flag = 1;
                    }
                    else if(i > 0 && ((input.charAt(i) == '+' || input.charAt(i) == '-' || input.charAt(i) == '*' || input.charAt(i) == '/') && input.charAt(i-1) == '(' && input.charAt(i+1) == ')')){
                        context = getApplicationContext();
                        CharSequence text = "Incorrect Input !!!";
                        int duration = Toast.LENGTH_SHORT;
                        Toast toast = Toast.makeText(context, text, duration);
                        toast.show();
                        flag = 1;
                    }
                }
                if(flag != 1) {
                    try {
                        for (int i = 0; i < input.length(); i++) {
                            if (input.charAt(i) == '(' || input.charAt(i) == ')') {
                                if (input.charAt(i) == '(')
                                    stack.push('(');

                                else if (input.charAt(i) == ')') {
                                    if (stack.empty() == true) {
                                        context = getApplicationContext();
                                        CharSequence text = "Incorrect Input !!!";
                                        int duration = Toast.LENGTH_SHORT;
                                        Toast toast = Toast.makeText(context, text, duration);
                                        toast.show();
                                        flag = 1;
                                        break;
                                    } else
                                        stack.pop();
                                }
                            }
                        }
                        if (stack.empty() != true) {
                            context = getApplicationContext();
                            CharSequence text = "Incorrect Input !!!";
                            int duration = Toast.LENGTH_SHORT;
                            Toast toast = Toast.makeText(context, text, duration);
                            toast.show();
                            flag = 1;
                        }
                    } catch (Exception e) {
                    }
                }
            }
            if(flag == 0){
                input = calculation(input);
                editText.setText(input);
                editText.setSelection(input.length());
            }
        }
        private String calculation(String str) {
            try{
                if(str.length()==0)
                    return str;
                int i = 0,j=0,ie,fe,k,br=0,brcn=0;
                for(i=0;i<str.length();i++){
                    if(str.charAt(i)=='π'){
                        if(i>0){
                            if((str.charAt(i-1)>='0'&&str.charAt(i-1)<='9')||str.charAt(i-1)=='.'||str.charAt(i-1)==')'||str.charAt(i-1)=='π') {
                                str = str.replace(str.substring(i - 1, i + 1), str.charAt(i - 1) + "*π");
                            }
                            else if(i<str.length()-1){
                                //Toast.makeText(getApplicationContext(),i+" "+str.length(),Toast.LENGTH_SHORT).show();

                                if((str.charAt(i+1)>='0'&&str.charAt(i+1)<='9'||str.charAt(i+1)=='.'||str.charAt(i+1)=='π')){
                                    str=str.replace(str.substring(i,i+2),"π*"+str.charAt(i+1));
                                }}
                        }
                        if(i==0){
                            if(i<str.length()-1){
                                //Toast.makeText(getApplicationContext(),i+" "+str.length(),Toast.LENGTH_SHORT).show();

                                if((str.charAt(i+1)>='0'&&str.charAt(i+1)<='9'||str.charAt(i+1)=='.'||str.charAt(i+1)=='π'||str.charAt(i+1)=='√')){
                                    str=str.replace(str.substring(i,i+2),"π*"+str.charAt(i+1));
                                }}
                        }

                    }
                    else if(str.charAt(i)=='('&&i>0){
                        if(((str.charAt(i-1)>='0'&&str.charAt(i-1)<='9') || str.charAt(i-1) =='.') || str.charAt(i-1) == ')')
                            str=str.replace(str.substring(i-1,i+1),str.charAt(i-1)+"*(");
                    }
                    else if(str.charAt(i)==')'&&i<str.length()-1){
                        if(str.charAt(i+1)>='0'&&str.charAt(i+1)<='9')
                            str=str.replace(str.substring(i,i+2),")*"+str.charAt(i+1));
                    }
                    else if(str.charAt(i)=='√'&&i>0){
                        //Toast.makeText(getApplicationContext(),str+" "+str.charAt(i-1),Toast.LENGTH_SHORT).show();
                        if(str.charAt(i-1)!='+'&&str.charAt(i-1)!='-'&&str.charAt(i-1)!='/'&&str.charAt(i-1)!='^'&&str.charAt(i-1)!='*') {
                            //Toast.makeText(getApplicationContext(), "1", Toast.LENGTH_SHORT).show();
                            str = str.replace(str.substring(i - 1, i + 1), str.charAt(i - 1) + "*√");
                        }
                    }
                    //Toast.makeText(getApplicationContext(),str,Toast.LENGTH_SHORT).show();
                }
                str=str.replace("π","3.1415926536");
                while (true) {
                    op=0;
                    j=str.length();
                    for (i = 0; i < str.length() - 1; i++) {
                        //   Toast.makeText(getApplicationContext(),str,Toast.LENGTH_SHORT).show();
                        if ((str.charAt(i)<'0'&&str.charAt(i)!='.')||str.charAt(i)>'9'){
                            if(str.charAt(i)=='('){
                                brcn=0;
                                for(br=i+1;;br++){
                                    if(brcn==0&&str.charAt(br)==')'){
                                        String tempstr=str.substring(i+1,br);
                                        str=str.replace(str.substring(i,br+1),calculation(tempstr));
                                        i=-1;
                                        op=0;
                                        j=str.length();
                                        break;
                                    }
                                    else if(str.charAt(br)=='('){
                                        brcn++;
                                    }
                                    else if(str.charAt(br)==')')
                                        brcn--;
                                }
                                //Toast.makeText(getApplicationContext(),str+" "+i+" "+op+" "+j,Toast.LENGTH_SHORT).show();
                                continue;
                            }
                            else if(str.charAt(i)=='√'){
                                if(op<=6){
                                    j=i;
                                    op=6;
                                }
                            }
                            else if(str.charAt(i)=='^'){
                                if(op<=5){
                                    j=i;
                                    op=5;
                                }
                            }
                            else if(str.charAt(i)=='/'){
                                if(op<4){
                                    j=i;
                                    op=4;
                                }
                            }
                            else if(str.charAt(i)=='*'){
                                if(op<3){
                                    j=i;
                                    op=3;
                                }
                            }
                            else if(str.charAt(i)=='-'){
                                if(i==0)
                                    continue;
                                else if(str.charAt(i-1)>'9'||(str.charAt(i-1)<'0'&&str.charAt(i-1)!='.'))
                                    continue;
                                if(op<2){
                                    j=i;
                                    op=2;
                                }
                            }
                            else if(str.charAt(i)=='+'){
                                if(op<1){
                                    j=i;
                                    //Toast.makeText(getApplicationContext(),j+"",Toast.LENGTH_SHORT).show();
                                    op=1;
                                }
                            }
                        }
                    }

                    if(op==0)
                        break;
                    k=j-1;
                    ie=0;
                    fe=str.length();
                    while(k>=0&&op!=6){
                        if((str.charAt(k)<'0'&&str.charAt(k)!='.')||str.charAt(k)>'9'){
                            ie=k+1;
                            if(k==0)
                                ie=k;
                            else if(str.charAt(k-1)>'9'||(str.charAt(k-1)<'0'&&str.charAt(k-1)!='.'))
                                ie=k;
                            break;
                        }
                        k--;
                    }
                    k=j+1;
                    if(str.charAt(k)=='-')
                        k++;
                    while(k<str.length()) {
                        if (((str.charAt(k) < '0' && str.charAt(k) != '.') || str.charAt(k) > '9')) {
                            fe = k;
                            break;
                        }
                        k++;
                    }

                    //Toast.makeText(getBaseContext(),ie+" "+fe,Toast.LENGTH_SHORT).show();
                    s1=str.substring(ie,j);
                    s2=str.substring(j+1,fe);
                    if(op!=6)
                        exp1=Double.parseDouble(s1);
                    exp2=Double.parseDouble(s2);
                    if(op==6){
                        exp3=Math.sqrt(exp2);
                    }
                    else if(op==5){
                        exp3=Math.pow(exp1,exp2);
                    }
                    else if(op==4){
                        exp3=exp1/exp2;
                    }
                    else if(op==3){
                        exp3=exp1*exp2;
                    }
                    else if(op==2){
                        exp3=exp1-exp2;
                    }
                    else if(op==1){
                        exp3=exp1+exp2;
                    }
                    s3=String.valueOf(exp3);
                    if(op!=6)
                        str=str.replace(str.substring(ie,fe),s3);
                    else
                        str=str.replace(str.substring(j,fe),s3);
                    //Toast.makeText(getBaseContext(),str,Toast.LENGTH_SHORT).show();
                }
                boolean tempdot=false;
                int strcnt=0,indexstr=str.length()-1;
                for(i=0;i<str.length();i++){
                    if(str.charAt(i)=='.'){
                        tempdot=true;
                    }
                    if(tempdot&&str.charAt(i)=='0'){
                        strcnt++;
                    }
                    else if(tempdot){
                        strcnt=0;
                        indexstr=i;
                    }
                    if(strcnt==10) {
                        for(int index=str.length()-1;index>=str.length()-5;index--){
                            if(str.charAt(index)=='E'){
                                String tem,tem2;
                                tem=str.substring(index,str.length());
                                tem2=str.substring(indexstr+2,str.length());
                                indexstr+=str.length()-index+1;
                                str=str.replace(tem2,tem);
                                break;
                            }
                        }
                        str = str.substring(0, indexstr + 1);
                        break;
                    }
                }
                if(str.length()>=2)
                    if(str.charAt(str.length()-2)=='.'&&str.charAt(str.length()-1)=='0')
                        str=str.substring(0,str.length()-2);
                if(str.length()>0)
                    if(str.charAt(str.length()-1)=='.')
                        str=str.substring(0,str.length()-1);
                return  str;
            }catch (Exception e){}
            return str;
        }
    }

}
