package com.cookandroid.lecture09;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import java.util.HashMap;
import java.util.Map;

public class MainActivity extends AppCompatActivity {

    Map<Integer, Class> runMap = new HashMap<Integer, Class>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        runMap.put(R.id.main_btn_exam01, Exam01.class);
        runMap.put(R.id.main_btn_exam02, Exam02.class);
        runMap.put(R.id.main_btn_exam03, Exam03.class);
        runMap.put(R.id.main_btn_exam04, Exam04.class);
        runMap.put(R.id.main_btn_exam05, Exam05.class);
        runMap.put(R.id.main_btn_exam06, Exam06.class);
        runMap.put(R.id.main_btn_exam07, Exam07.class);
        runMap.put(R.id.main_btn_exam08, Exam08.class);
        runMap.put(R.id.main_btn_exam09, Exam09.class);

        runMap.put(R.id.main_btn_prac01, Prac01.class);
        runMap.put(R.id.main_btn_prac02, Prac02.class);
    }

    public void btnChecked(View v){
        try {openIntent(runMap.get(v.getId()));}
        catch (Exception e){
            Toast.makeText(getApplication(), "오류 발생. :" + e.toString(), Toast.LENGTH_LONG).show();}
    }

    public void openIntent(Class openJava){
        Intent intent = new Intent(getApplicationContext(), openJava);
        startActivity(intent);
    }
}