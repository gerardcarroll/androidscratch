package com.sprint_two.ronanclancy.slaughtered;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Bitmap;
import android.graphics.BitmapShader;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.RectF;
import android.graphics.Shader;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.util.Log;
import android.widget.ImageView;

/**
 * Created by afinn on 1/27/2016.
 */
public class RoundedCornerImageView extends ImageView {


    /*  Class to demo creating a custom view widget
        Creates an image view that has rounded corners
     */
    int radius;

    public RoundedCornerImageView(Context context, AttributeSet attrs) {
        super(context, attrs);
        TypedArray a = context.getTheme().obtainStyledAttributes(attrs,
                R.styleable.RoundedCornerImageView,
                0, 0);
        try{
            radius = a.getInt(R.styleable.RoundedCornerImageView_radius,0);
        } finally {
            a.recycle();
        }
    }

    public int getRadius(){
        return radius;
    }

    public void setRadius(int r){
        radius = r;
        invalidate();
        requestLayout();
    }

    @Override
    protected void onDraw(Canvas canvas) {

        Drawable drawable = getDrawable();

        if (drawable == null) {
            return;
        }

        int width = getWidth(), height = getHeight();

        if (width == 0 || height == 0) {
            return;
        }

        Bitmap b = ((BitmapDrawable) drawable).getBitmap();
        Bitmap bitmap = b.copy(Bitmap.Config.ARGB_8888, true);

        BitmapShader shader;
        shader = new BitmapShader(bitmap, Shader.TileMode.CLAMP, Shader.TileMode.CLAMP);

        Paint paint = new Paint();
        paint.setAntiAlias(true);
        paint.setShader(shader);

        RectF rect = new RectF(0.0f, 0.0f, width, height);

        // rect contains the bounds of the shape
        // radius is the radius in pixels of the rounded corners
        // paint contains the shader that will texture the shape
        Log.d("CUSTOM_VIEW","Rendering rounded rect with radius " + radius);
        canvas.drawRoundRect(rect, radius, radius, paint);
    }


}
