package com.snail.freechat.ui.widget.circleimage;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Path;
import android.util.AttributeSet;
import android.view.View;
import android.widget.ImageView;

/**
 * Created by fenghb on 2014/5/16.
 */
public class CornerImageViewCircle extends ImageView {
    private Path mPath = new Path();

    public CornerImageViewCircle(Context context) {
        this(context, null);
    }

    public CornerImageViewCircle(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public CornerImageViewCircle(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
        setLayerType(View.LAYER_TYPE_SOFTWARE, null);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        float cx = getMeasuredWidth() / 2;
        float cy = getMeasuredHeight() / 2;
        float cr = cx < cy ? cx : cy;

        mPath.reset();
        mPath.addCircle(cx, cy, cr, Path.Direction.CCW);
        canvas.clipPath(mPath);
        super.onDraw(canvas);
    }
}
