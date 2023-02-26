package com.example.gamabubakar.radiocheck;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
CheckBox cb;
RadioButton rbmale;
RadioButton rbfemale;
Switch sw;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        cb=findViewById(R.id.checkBox2);
        rbmale=findViewById(R.id.rbmale);
        rbfemale=findViewById(R.id.rbfemale);
        sw=findViewById(R.id.switched);
    }

    public void ClickMe(View view) {
        String result="";
        int flag=0;
        if(cb.isChecked()) {
            result = "Married";
            flag++;
        }
        else
            result="not Married";
        if(rbmale.isChecked()) {
            result = result + ", and he is male";
            flag++;
        }
        else
            result=result+", and she is female";
        if(sw.isChecked()) {
            result = result + ", and happy";
            flag++;
        }
        else
            result=result+", and not happy";


            LayoutInflater myinflater=getLayoutInflater();
            View view1=myinflater.inflate(R.layout.custom_toast,null);
            TextView tv=view1.findViewById(R.id.result);
            tv.setText(result);
        ImageView iv=view1.findViewById(R.id.imageView);
        //iv.setImageResource(R.drawable.ic_launcher_background);
        if(flag==1)
            iv.setAlpha(0.3f);
        else if(flag==2)
            iv.setAlpha(0.6f);
        else if(flag==3)
            iv.setAlpha(1.0f);
        else
            iv.setAlpha(0.1f);
            Toast t=new Toast(getApplicationContext());
            t.setView(view1);
            t.setDuration(Toast.LENGTH_LONG);
            t.setGravity(Gravity.CENTER,0,0);
            t.show();
    }
}
