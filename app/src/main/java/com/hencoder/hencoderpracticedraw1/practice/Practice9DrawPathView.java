package com.hencoder.hencoderpracticedraw1.practice;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;

public class Practice9DrawPathView extends View {

    public Practice9DrawPathView(Context context) {
        super(context);
    }

    public Practice9DrawPathView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    public Practice9DrawPathView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

//        练习内容：使用 canvas.drawPath() 方法画心形
        int width = getWidth();
        int height = getHeight();
        Paint paint = new Paint();

        Path path = new Path();
        path.moveTo(width/2,height/2);
        path.arcTo(width/2,height/2-100,width/2+200,height/2+100,-180,225,true);
        path.lineTo(width/2,height/2+241.4f);
        path.arcTo(width/2-200,height/2-100,width/2,height/2+100,-225,225,false);
        canvas.drawPath(path,paint);
    }
}
