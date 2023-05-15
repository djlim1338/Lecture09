package com.cookandroid.lecture09;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.BlurMaskFilter;
import android.graphics.Canvas;
import android.graphics.ColorMatrix;
import android.graphics.ColorMatrixColorFilter;
import android.graphics.Paint;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Toast;

public class Exam07 extends AppCompatActivity {

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
            return Toast.makeText(getContext(), toastStr, Toast.LENGTH_LONG);
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

        public MyGraphicView(Context context) {
            super(context);
        }

        @Override
        protected void onDraw(Canvas canvas) {
            super.onDraw(canvas);

            Bitmap picture = BitmapFactory.decodeResource(getResources(),
                    R.drawable.lena256);

            int picX = (this.getWidth() - picture.getWidth()) / 2;
            int picY = (this.getHeight() - picture.getHeight()) / 2;

            Paint paint = new Paint();

            float[] array = {
                    2, 0, 0, 0, -25,
                    0, 2, 0, 0, -25,
                    0, 0, 2, 0, -25,
                    0, 0, 0, 1, 0
            };

            switch (state){
                case 0:
                    array = new float[]{
                            2, 0, 0, 0, -25,
                            0, 2, 0, 0, -25,
                            0, 0, 2, 0, -25,
                            0, 0, 0, 1, 0
                    };
                    break;
                case 1:
                    array = new float[]{
                            2, 0, 0, 0, -100,
                            0, 2, 0, 0, -100,
                            0, 0, 2, 0, -100,
                            0, 0, 0, 1, 0
                    };
                    break;
                case 2:
                    array = new float[]{
                            2, 0, 0, 0, 25,
                            0, 2, 0, 0, 25,
                            0, 0, 2, 0, 25,
                            0, 0, 0, 1, 0
                    };
                    break;
                case 3:
                    array = new float[]{
                            2, 0, 0, 0, 100,
                            0, 2, 0, 0, 100,
                            0, 0, 2, 0, 100,
                            0, 0, 0, 1, 0
                    };
                    break;
            }

            ColorMatrix cm = new ColorMatrix(array);
            paint.setColorFilter(new ColorMatrixColorFilter(cm));
            canvas.drawBitmap(picture, picX, picY, paint);
            picture.recycle();
        }
    }
}
