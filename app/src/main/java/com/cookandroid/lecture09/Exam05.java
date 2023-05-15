package com.cookandroid.lecture09;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Toast;

public class Exam05 extends AppCompatActivity {

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(new MyGraphicView(this));
    }

    private static class MyGraphicView extends View {

        int state = 0;

        @Override
        public boolean onTouchEvent(MotionEvent event) {
            switch (event.getAction()) {
                case MotionEvent.ACTION_DOWN:
                    state++;
                    if(state > 3) state = 0;
                    String toastStr = "상태 번호: " + state;
                    Toast.makeText(getContext(), toastStr, Toast.LENGTH_SHORT).show();
                    this.invalidate();
                    break;
                case MotionEvent.ACTION_MOVE:
                case MotionEvent.ACTION_UP:
                    break;
            }
            return true;
        }

        public MyGraphicView(Context context) {
            super(context);
        }

        @Override
        protected void onDraw(Canvas canvas) {
            super.onDraw(canvas);
            Bitmap picture = BitmapFactory.decodeResource(getResources(), R.drawable.jeju14);

            int cenX = this.getWidth() / 2;
            int cenY = this.getHeight() / 2;
            int picX = (this.getWidth() - picture.getWidth()) / 2;
            int picY = (this.getHeight() - picture.getHeight()) / 2;

            switch(state){
                case 0:
                    canvas.rotate(45, cenX, cenY);
                    canvas.drawBitmap(picture, picX, picY, null);
                    break;
                case 1:
                    canvas.translate(-150, 200);
                    canvas.drawBitmap(picture, picX, picY, null);
                    break;
                case 2:
                    canvas.scale(2, 2, cenX, cenY);
                    canvas.drawBitmap(picture, picX, picY, null);
                    break;
                case 3:
                    canvas.skew (0.3f, 0.3f);
                    canvas.drawBitmap(picture, picX, picY, null);
                    break;
            }
            picture.recycle();
        }
    }
}
