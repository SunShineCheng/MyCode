package com.xcc.xinxingdonghua;

import android.animation.TypeEvaluator;
import android.graphics.PointF;

/**
 * Created by SUN on 2016/10/29.
 * 我们自定义一个BezierEvaluator 实现 TypeEvaluator
 * 由于我们view的移动需要控制x y 所以就传入PointF 作为参数,是不是感觉完全契合
 */

public class BezierEvaluator implements TypeEvaluator<PointF> {

    private PointF pointF1;
    private PointF pointF2;
    public BezierEvaluator(PointF pointF1,PointF pointF2){
        this.pointF1 = pointF1;
        this.pointF2 = pointF2;
    }
    @Override
    public PointF evaluate(float time, PointF startValue,
                           PointF endValue) {

        float timeLeft = 1.0f - time;
        PointF point = new PointF();//结果

        // B(t)=P0(1-t)^3+3P1t(1-t)^2+3P2t^2(1-t)+P3t^3,t>=0 && t<=1

        point.x = timeLeft * timeLeft * timeLeft * (startValue.x)
                + 3 * timeLeft * timeLeft * time * (pointF1.x)
                + 3 * timeLeft * time * time * (pointF2.x)
                + time * time * time * (endValue.x);

        point.y = timeLeft * timeLeft * timeLeft * (startValue.y)
                + 3 * timeLeft * timeLeft * time * (pointF1.y)
                + 3 * timeLeft * time * time * (pointF2.y)
                + time * time * time * (endValue.y);
        return point;
    }

}
