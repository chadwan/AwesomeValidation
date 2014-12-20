package com.strohwitwer.awesomevalidation.validator;

import android.graphics.Color;
import android.widget.EditText;

import com.strohwitwer.awesomevalidation.ValidationHolder;
import com.strohwitwer.awesomevalidation.helper.RangeHelper;
import com.strohwitwer.awesomevalidation.helper.SpanHelper;

import java.util.ArrayList;
import java.util.regex.Matcher;

public class ColorationValidator extends Validator {

    @Override
    public void trigger() {
        for (ValidationHolder validationHolder : mValidationHolderList) {
            EditText editText = validationHolder.getEditText();
            String text = editText.getText().toString();
            Matcher matcher = validationHolder.getPattern().matcher(text);
            if (!matcher.matches()) {
                ArrayList<int[]> listOfMatching = new ArrayList<int[]>();
                while (matcher.find()) {
                    listOfMatching.add(new int[]{matcher.start(), matcher.end() - 1});
                }
                ArrayList<int[]> listOfNotMatching = RangeHelper.inverse(listOfMatching, text.length());
                SpanHelper.setColor(editText, Color.RED, listOfNotMatching);
            }
        }
    }

}