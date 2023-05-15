package com.cookandroid.lecture09;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.BlurMaskFilter;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Toast;

public class Exam06 extends AppCompatActivity {

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(new MyGraphicView(this));
    }

    private static class MyGraphicView extends View {

        int state = 0;
        Toast toastMsg = makeToast(0);

        public Toast makeToast(int stateNumber){
            String toastStr = "상태 번호: " + stateNumber;
            return Toast.makeText(getContext(), toastStr, Toast.LENGTH_SHORT);
        }

        public MyGraphicView(Context context) {
            super(context);
        }

        @Override
        public boolean onTouchEvent(MotionEvent event) {
            switch (event.getAction()) {
                case MotionEvent.ACTION_DOWN:
                    state++;
                    if(state > 3) state = 0;
                    toastMsg.cancel();
                    toastMsg = makeToast(state);
                    toastMsg.show();
                    this.invalidate();
                    break;
            }
            return true;
        }

        @Override
        protected void onDraw(Canvas canvas) {
            super.onDraw(canvas);
            Bitmap picture = BitmapFactory.decodeResource(getResources(),
                    R.drawable.lena256);

            int picX = (this.getWidth() - picture.getWidth()) / 2;
            int picY = (this.getHeight() - picture.getHeight()) / 2;

            Paint paint = new Paint();
            BlurMaskFilter bMask = new BlurMaskFilter(30, BlurMaskFilter.Blur.NORMAL);

            switch (state){
                case 0:
                    bMask = new BlurMaskFilter(30, BlurMaskFilter.Blur.NORMAL);
                    break;
                case 1:
                    bMask = new BlurMaskFilter(30, BlurMaskFilter.Blur.INNER);
                    break;
                case 2:
                    bMask = new BlurMaskFilter(30, BlurMaskFilter.Blur.OUTER);
                    break;
                case 3:
                    bMask = new BlurMaskFilter (30, BlurMaskFilter.Blur.SOLID);
                    break;
            }


            paint.setMaskFilter(bMask);
            canvas.drawBitmap(picture, picX, picY, paint);
            picture.recycle();
        }
    }
}
