package com.hencoder.hencoderpracticedraw1.practice;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;

public class Practice10HistogramView extends View {

    public Practice10HistogramView(Context context) {
        super(context);
    }

    public Practice10HistogramView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    public Practice10HistogramView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

//        综合练习
//        练习内容：使用各种 Canvas.drawXXX() 方法画直方图
        int width = getWidth();
        int height = getHeight();
        Paint paint1 = new Paint();
        paint1.setColor(Color.parseColor("#eeffffff"));
        canvas.drawLine(width/8,height/4*3,width/8,height/8,paint1);
        canvas.drawLine(width/8,height/4*3,width/8*7+width/56,height/4*3,paint1);

        paint1.setTextAlign(Paint.Align.CENTER);
        paint1.setTextSize(60);
        canvas.drawText("直方图",(float)(width/8*4),(float)(height/4*3.5),paint1);
        paint1.setTextSize(30);


        Paint paint2 = new Paint();
        paint2.setColor(Color.YELLOW);
        String[] titles = {"Froyo","GB","ICS","JB","KitKat","L","M"};
        float spaceBetweenRect = width/56;
        float rectWidth = width/56*5;
        float startX = spaceBetweenRect;
        float startY = height/4*3;
        for (int i=0;i<7;i++){
            Double random = Math.random();
            drawRectWithTitile(width/8+startX+(rectWidth+spaceBetweenRect)*i,startY,rectWidth,(float)(height/16*9*random),titles[i],canvas,paint2,paint1);
        }
    }
    /*画直方图里一个矩形，带标题，默认在矩形下方，给定坐标值为左下角坐标值*/
    private void drawRectWithTitile(float x,float y,float width,float height,String title,Canvas canvas,Paint rectPaint,Paint textPaint){
        canvas.drawRect(x,y-height,x+width,y,rectPaint);
        canvas.drawText(title,x+width/2,y+30,textPaint);
    }
}
