package com.example.HCIdoodle2;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.util.AttributeSet;
import android.view.View;
import android.widget.ImageView;

import androidx.annotation.Nullable;

import java.util.ArrayList;

public class DrawingView extends androidx.appcompat.widget.AppCompatImageView {
    private ArrayList<Path> paths = new ArrayList<>();
    private ArrayList<Integer> colors = new ArrayList<>();
    private int currentColor = 0xFF000000;
    private ArrayList<Integer> widths = new ArrayList<>();
    private int currentWidth = 6;



    public DrawingView(Context context) {
        super(context);
    }

    public DrawingView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    public DrawingView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }



    public void addPath(Path path) {
        paths.add(path);
        colors.add(currentColor);
        widths.add(currentWidth);
    }

    public Path getLastPath() {
        if (paths.size() > 0) {
            return paths.get(paths.size() - 1);
        }

        return null;
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        int i = 0;
        for (Path path : paths) {

                Paint paint = new Paint();
                paint.setColor(colors.get(i));
                paint.setStyle(Paint.Style.STROKE);
                paint.setStrokeWidth(widths.get(i));
                canvas.drawPath(path, paint);
                i++;
        }
    }
    public void setCurrentColor(int color) {

        currentColor = color;
    }
    public void setCurrentWidth(int width) {
        currentWidth = (width + 1) * 4;
    }
    public void erase() {
        paths.clear();
        colors.clear();
        widths.clear();
        invalidate();
    }
}