package com.example.calculator;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.solver.ArrayLinkedVariables;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class MainActivity extends AppCompatActivity {

    Button b1;
    Button b2;
    Button b3;
    Button b4;
    Button b5;
    Button b6;
    Button b7;
    Button b8;
    Button b9;
    Button b0;
    Button bP;
    Button bS;
    Button bM;
    Button bD;
    Button bE;
    Button bC;
    TextView dP;
    String ans;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        b0 = findViewById(R.id.button0);
        b1 = findViewById(R.id.button1);
        b2 = findViewById(R.id.button2);
        b3 = findViewById(R.id.button3);
        b4 = findViewById(R.id.button4);
        b5 = findViewById(R.id.button5);
        b6 = findViewById(R.id.button6);
        b7 = findViewById(R.id.button7);
        b8 = findViewById(R.id.button8);
        b9 = findViewById(R.id.button9);
        bP = findViewById(R.id.buttonPlus);
        bS = findViewById(R.id.buttonMinius);
        bM = findViewById(R.id.buttonMulti);
        bD = findViewById(R.id.buttonDiv);
        bE = findViewById(R.id.buttonEquals);
        bC = findViewById(R.id.buttonClear);
        dP = (TextView)findViewById(R.id.textViewDP);



    }
    public void num(View v)
    {
        switch(v.getId())
        {
            case R.id.button0:
                work(" 0");
                break;
            case R.id.button1:
                work(" 1");
                break;
            case R.id.button2:
                work(" 2");
                break;
            case R.id.button3:
                work(" 3");
                break;
            case R.id.button4:
                work(" 4");
                break;
            case R.id.button5:
                work(" 5");
                break;
            case R.id.button6:
                work(" 6");
                break;
            case R.id.button7:
                work(" 7");
                break;
            case R.id.button8:
                work(" 8");
                break;
            case R.id.button9:
                work(" 9");
                break;
            case R.id.buttonPlus:
                work(" +");
                break;
            case R.id.buttonMinius:
                work(" -");
                break;
            case R.id.buttonMulti:
                work(" *");
                break;
            case R.id.buttonDiv:
                work(" /");
                break;
            case R.id.buttonEquals:
                calculations();
                break;
            case R.id.buttonClear:
                dP.setText("0");
                break;

        }
    }
    public void work(String s)
    {
        if(dP.getText().toString().equals("0"))
        {
            ans = dP.getText().toString();
            ans = s;
            dP.setText(ans);
        }
        else
        {
            ans = dP.getText().toString();
            ans += s;
            dP.setText(ans);
        }

    }
    public void calculations()
    {
        ans = dP.getText().toString();
        StringTokenizer st = new StringTokenizer(ans," ");
        ArrayList<String> calc = new ArrayList<String>();
        do
        {
            calc.add(st.nextToken());
        }while(st.hasMoreTokens()==true);
        

    }
}

