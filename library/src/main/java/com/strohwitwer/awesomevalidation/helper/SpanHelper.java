package com.strohwitwer.awesomevalidation.helper;

import android.text.Spannable;
import android.text.SpannableString;
import android.text.style.BackgroundColorSpan;
import android.widget.EditText;

import java.util.ArrayList;

public class SpanHelper {

    private SpanHelper() {}

    public static void setColor(EditText editText, int color, ArrayList<int[]> ranges) {
        String text = editText.getText().toString();
        SpannableString spanText = new SpannableString(text);
        for (int[] range : ranges) {
            BackgroundColorSpan markup = new BackgroundColorSpan(color);
            spanText.setSpan(markup, range[0], range[1] + 1, Spannable.SPAN_INCLUSIVE_INCLUSIVE);
        }
        editText.setText(spanText);
    }

}