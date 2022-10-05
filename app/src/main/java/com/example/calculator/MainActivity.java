package com.example.calculator;
import android.annotation.SuppressLint;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import java.util.ArrayList;
import java.util.StringTokenizer;
public class MainActivity extends AppCompatActivity {
    Button b1,b2,b3,b4,b5,b6,b7,b8,b9,b0,bP,bS,bM,bD,bE,bC;
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
        dP = findViewById(R.id.textViewDP);
    }
    public void num(View v)
    {
        switch(v.getId())
        {
            case R.id.button0:
                work("0");
                break;
            case R.id.button1:
                work("1");
                break;
            case R.id.button2:
                work("2");
                break;
            case R.id.button3:
                work("3");
                break;
            case R.id.button4:
                work("4");
                break;
            case R.id.button5:
                work("5");
                break;
            case R.id.button6:
                work("6");
                break;
            case R.id.button7:
                work("7");
                break;
            case R.id.button8:
                work("8");
                break;
            case R.id.button9:
                work("9");
                break;
            case R.id.buttonPlus:
                work2(" + ");
                break;
            case R.id.buttonMinius:
                work2(" - ");
                break;
            case R.id.buttonMulti:
                work2(" * ");
                break;
            case R.id.buttonDiv:
                work2(" / ");
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
    public void work2(String s)
    {
        ans = dP.getText().toString();
        ans += s;
        dP.setText(ans);
    }
    @SuppressLint("SetTextI18n")
    public void calculations()
    {
        try
        {
            ans = dP.getText().toString();
            StringTokenizer st = new StringTokenizer(ans," ");
            ArrayList<String> calc = new ArrayList<>();
            do
            {
                calc.add(st.nextToken());
            }while(st.hasMoreTokens());
            while(calc.contains("*")||calc.contains("/")||calc.contains("+")||calc.contains("-"))
            {
                if(calc.contains("*")||calc.contains("/"))
                {

                    int mD = 0;
                    while(calc.contains("*")||calc.contains("/"))
                    {
                        if(calc.get(mD).equals("*")||calc.get(mD).equals("/"))
                        {
                            double a1 = Double.parseDouble(calc.get(mD-1));
                            double a2 = Double.parseDouble(calc.get(mD+1));
                            double aT = 0.0;
                            if(calc.get(mD).equals("*"))
                                aT = a1*a2;
                            else if(calc.get(mD).equals("/"))
                                aT = a1/a2;
                            String a = Double.toString(aT);
                            calc.set(mD-1,a);
                            calc.remove(mD+1);
                            calc.remove(mD);
                            ans = calc.get(0);
                            mD=0;
                        }
                        mD++;
                    }
                }
                else if(calc.contains("+")||calc.contains("-"))
                {
                    int aS = 0;
                    while(calc.contains("+")||calc.contains("-"))
                    {
                        if(calc.get(aS).equals("+")||calc.get(aS).equals("-"))
                        {
                            double a1 = Double.parseDouble(calc.get(aS-1));
                            double a2 = Double.parseDouble(calc.get(aS+1));
                            double aT = 0;
                            if(calc.get(aS).equals("+"))
                            {
                                aT = a1+a2;
                            }
                            else
                            {
                                aT = a1-a2;
                            }
                            String a = Double.toString(aT);
                            calc.set(aS-1,a);
                            calc.remove(aS+1);
                            calc.remove(aS);
                            aS = 0;
                            ans = calc.get(0);
                        }
                        aS++;

                    }
                }
            }
            if(ans.equalsIgnoreCase("Infinity"))
            {
                ans = "Error";
            }
            dP.setText(ans);
        }catch(Exception e)
        {
            dP.setText("Error");
        }
    }
}

