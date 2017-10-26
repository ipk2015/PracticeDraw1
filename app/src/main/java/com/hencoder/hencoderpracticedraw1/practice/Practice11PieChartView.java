package com.hencoder.hencoderpracticedraw1.practice;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;

public class Practice11PieChartView extends View {

    public Practice11PieChartView(Context context) {
        super(context);
    }

    public Practice11PieChartView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    public Practice11PieChartView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

//        综合练习
//        练习内容：使用各种 Canvas.drawXXX() 方法画饼图
        int width = getWidth();
        int height = getHeight();
        Paint paint = new Paint();
        float r = height/4;
        float left = width/2-r;
        float right = width/2+r;
        float top = height/2-r;
        float bottom = height/2+r;

        int[] colors = {Color.BLUE,Color.GRAY,Color.YELLOW,Color.RED,Color.BLACK};
        float[] angles = {90,60,140,20,360-90-60-140-20};
        String[] titles = {"Marshmallow","Froyo","Gingerbread","Ice Cream Sandwich","KitKat"};

        Paint textPaint = new Paint();
        textPaint.setColor(Color.parseColor("#eeffffff"));
        textPaint.setTextSize(30);

        float startAngle = 30;
        for(int i =0;i<angles.length;i++){
            //画扇形，思路就是将扇形沿其中轴线平移一定距离，需要算出坐标轴方向平移距离
            paint.setColor(colors[i]);
            float random = (float)Math.random() * 30;
            //这里注意的是Math.sin的参数是弧度制，不是角度制，要转换过来，否则会出问题
            //这里的detaX和detaY可正可负，而其正负也代表了图的平移方向，但很多时候正负都不用考虑，算法是普遍适用的。绘制文字时需要判断以校正文字对齐
            float detaY = (float) (Math.sin(Math.toRadians((double) (startAngle+angles[i]/2))));
            float detaX = (float) (Math.cos(Math.toRadians((double) (startAngle+angles[i]/2))));
            canvas.drawArc(left+random*detaX,top+random*detaY,right+random*detaX,bottom+random*detaY,startAngle,angles[i],true,paint);
            //画线，起始点是扇形边缘的中间点，即中轴线与扇形边缘交点,沿中轴线方向延伸
            float lineStartX = width/2+(random+r)*detaX;
            float lineStartY = height/2+(random+r)*detaY;
            canvas.drawLine(lineStartX,lineStartY,lineStartX+50*detaX,lineStartY+50*detaY,textPaint);
            canvas.drawLine(lineStartX+50*detaX,lineStartY+50*detaY,lineStartX+50*detaX+100*(detaX>0?1:-1),lineStartY+50*detaY,textPaint);
            //画文字，以上面线的终点为起点，这里有个文字对齐的注意点，当线为向X轴正方向延伸时，左对齐；否则右对齐
            if(detaX>0){
                textPaint.setTextAlign(Paint.Align.LEFT);
            }else{
                textPaint.setTextAlign(Paint.Align.RIGHT);
            }
            canvas.drawText(titles[i],lineStartX+50*detaX+120*(detaX>0?1:-1),lineStartY+50*detaY,textPaint);

            startAngle+=angles[i];
        }

    }

}
