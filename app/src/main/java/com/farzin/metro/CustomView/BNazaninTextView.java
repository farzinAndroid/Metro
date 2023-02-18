package com.farzin.metro.CustomView;

import android.content.Context;
import android.graphics.Typeface;
import android.util.AttributeSet;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.widget.AppCompatTextView;

import com.farzin.metro.Utils.Constants;

public class BNazaninTextView extends AppCompatTextView {
    public BNazaninTextView(@NonNull Context context) {
        super(context);
        setFontTypeFace(context);
    }

    public BNazaninTextView(@NonNull Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        setFontTypeFace(context);
    }

    public BNazaninTextView(@NonNull Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        setFontTypeFace(context);
    }

    private void setFontTypeFace(@NonNull Context context) {
        Typeface typeface = Typeface.createFromAsset(context.getAssets(), Constants.FONTS_BNAZANIN);
        setTypeface(typeface);
    }
}
