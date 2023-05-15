package com.cookandroid.lecture09;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;


/*

연습문제 테스트겸 코드. 실행할 코드는 아니기 때문에 메인에 추가하지 않음.

 */
public class Prac00 extends AppCompatActivity {

    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.activity_prac00);
        setContentView(new Remake(this));
    }
    private static class Remake extends View{
        public Remake(Context context){  // 책에서는 MyGraphicView 로 나와있는데 복붙하고 실수로 안바꾼듯..?
            super(context);
        }
        @Override
        protected void onDraw(Canvas canvas){
            super.onDraw(canvas);
            // 화면에 그려질 내용을 이곳에 코딩
        }
    }
    
    public boolean onTouchEvent(MotionEvent event){
        switch (event.getAction()){
            case MotionEvent.ACTION_DOWN:
                // 손가락으로 화면을 누르기 시작했을 때 할 일
                break;
            case MotionEvent.ACTION_MOVE:
                // 터치 후 손가락을 움직일 때 할 일
                break;
            case MotionEvent.ACTION_UP:
                // 손가락을 화면에서 땔 때 할 일
                break;
        }
        return true;
    }
    /*
    protected void onDraw(Canvas canvas){
        super.onDraw(canvas);

        Bitmap picture = BitmapFactory.decodeResource(getResources(), R.drawable.그림id);
        canvas.drawBitmap(picture, 시작x, 시작y, null);
        picture.recycle();
    }
     */

    /*
    protected void onDraw(Canvas canvas){
        super.onDraw(canvas);

        Bitmap picture = BitmapFactory.decodeFile("파일경로 및 파일");
        canvas.drawBitmap(picture, 시작x, 시작y, null);
        picture.recycle();
    }
     */
}