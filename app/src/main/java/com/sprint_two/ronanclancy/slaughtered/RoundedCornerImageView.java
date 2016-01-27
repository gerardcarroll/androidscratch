package com.sprint_two.ronanclancy.slaughtered;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapShader;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.RectF;
import android.graphics.Shader;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.widget.ImageView;

/**
 * Created by afinn on 1/27/2016.
 */
public class RoundedCornerImageView extends ImageView {


    /*  Class to demo creating a custom view widget
        Creates an image view that has rounded corners

        Inspired by:
        * @link{http://stackoverflow.com/questions/2459916/how-to-make-an-imageview-with-rounded-corners}
        * @link{http://stackoverflow.com/questions/16208365/create-a-circular-image-view-in-android}

        For a more complete example of a rounded-corner image view see: @link{https://github.com/Pkmmte/CircularImageView}
     */

    public RoundedCornerImageView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    @Override
    protected void onDraw(Canvas canvas) {

        Drawable drawable = getDrawable();

        if (drawable == null) {
            return;
        }

        if (getWidth() == 0 || getHeight() == 0) {
            return;
        }

        if (getWidth() == 0 || getHeight() == 0) {
            return;
        }

        Bitmap b = ((BitmapDrawable) drawable).getBitmap();
        Bitmap bitmap = b.copy(Bitmap.Config.ARGB_8888, true);

        BitmapShader shader;
        shader = new BitmapShader(bitmap, Shader.TileMode.CLAMP, Shader.TileMode.CLAMP);

        int width = getWidth(), height = getHeight();

        Paint paint = new Paint();
        paint.setAntiAlias(true);
        paint.setShader(shader);

        RectF rect = new RectF(0.0f, 0.0f, width, height);

// rect contains the bounds of the shape
// radius is the radius in pixels of the rounded corners
// paint contains the shader that will texture the shape
        int radius = 200;
        canvas.drawRoundRect(rect, radius, radius, paint);
    }


}
