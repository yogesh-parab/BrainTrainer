package com.example.braintrainer;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.CountDownTimer;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.Random;

public class Act2 extends AppCompatActivity {
    TextView t1,t2,t3,t4;
    Button b1,b2,b3,b4,b5;
    Random r=new Random();
    CountDownTimer c1;
    int NumberOfQuestions,Correct;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_act2);
        t1=(TextView) findViewById(R.id.textView);
        t2=(TextView)findViewById(R.id.textView2);
        t3=(TextView)findViewById(R.id.textView3);
        t4=(TextView)findViewById(R.id.textView4);
        b1=(Button)findViewById(R.id.button1);
        b2=(Button)findViewById(R.id.button2);
        b3=(Button)findViewById(R.id.button3);
        b4=(Button)findViewById(R.id.button4);
        b5=findViewById(R.id.button);
        b5.setEnabled(false);
        b5.setVisibility(View.INVISIBLE);

         c1=new CountDownTimer(30000,1000){

             @Override
             public void onTick(long millisUntilFinished) {

                 t2.setText(String.valueOf(millisUntilFinished/1000)+"s");

             }

             @Override
             public void onFinish() {
                 t3.setText("Done");
                 b5.setEnabled(true);
                 b5.setVisibility(View.VISIBLE);
                 b1.setEnabled(false);
                 b2.setEnabled(false);
                 b3.setEnabled(false);
                 b4.setEnabled(false);
                 t4.setText("Final Score:"+Correct+"/"+NumberOfQuestions);


             }
         }.start();
         newQuestion();

    }
    public void hello(View view){
        int q=(Integer)view.getTag();
        if(q==1) {
            Correct += 1;

            t4.setText("Right");
        }
        else
            t4.setText("Wrong");

        newQuestion();
        NumberOfQuestions+=1;
        t3.setText(Correct+"/"+NumberOfQuestions);

    }
    public void newQuestion(){

        int a= r.nextInt(50);

        int b=r.nextInt(50);
        String g=Integer.toString(a)+"+"+Integer.toString(b);

        t1.setText(g);
        int c=a+b;
        int ran=r.nextInt(4);
        if (ran==0)
        {
            b1.setText(Integer.toString(c));
            b1.setTag(1);
            b2.setText(Integer.toString(r.nextInt(100)));
            b3.setText(Integer.toString(r.nextInt(100)));
            b4.setText(Integer.toString(r.nextInt(100)));
            b2.setTag(0);
            b3.setTag(0);
            b4.setTag(0);

        }
        else if(ran==1)
        {
            b2.setText(Integer.toString(c));
            b1.setText(Integer.toString(r.nextInt(100)));
            b3.setText(Integer.toString(r.nextInt(100)));
            b4.setText(Integer.toString(r.nextInt(100)));
            b2.setTag(1);
            b1.setTag(0);
            b3.setTag(0);
            b4.setTag(0);
        }
        else if (ran==2){
            b3.setText(Integer.toString(c));
            b2.setText(Integer.toString(r.nextInt(100)));
            b1.setText(Integer.toString(r.nextInt(100)));
            b4.setText(Integer.toString(r.nextInt(100)));
            b2.setTag(0);
            b1.setTag(0);
            b3.setTag(1);
            b4.setTag(0);
        }
        else if(ran==3){
            b4.setText(Integer.toString(c));
            b2.setText(Integer.toString(r.nextInt(100)));
            b3.setText(Integer.toString(r.nextInt(100)));
            b1.setText(Integer.toString(r.nextInt(100)));
            b2.setTag(0);
            b1.setTag(0);
            b3.setTag(0);
            b4.setTag(1);
        }

    }

    public void playAgain(View view){
        view.setEnabled(false);
        view.setVisibility(View.INVISIBLE);
        c1.start();
        NumberOfQuestions=0;
        Correct=0;
        newQuestion();
        b1.setEnabled(true);
        b2.setEnabled(true);
        b3.setEnabled(true);
        b4.setEnabled(true);
        t4.setText("");

    }
}

