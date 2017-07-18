package com.smile.databindingsample.common.validation;

import android.databinding.adapters.ListenerUtil;
import android.support.annotation.Nullable;
import android.support.design.widget.TextInputLayout;
import android.text.Editable;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewParent;
import android.widget.TextView;

/**
 * Created by digimed on 7/18/17.
 */

public class EditTextHelper {
    public static void removeError(TextView textView) {
        EditTextHelper.setError(textView, null);
    }

    public static void setError(TextView textView, String errorMessage) {
        TextInputLayout textInputLayout = getTextInputLayout(textView);
        if (textInputLayout != null) {
            textInputLayout.setErrorEnabled(!TextUtils.isEmpty(errorMessage));
            textInputLayout.setError(errorMessage);
        } else {
            textView.setError(errorMessage);
        }
    }

    @Nullable
    private static TextInputLayout getTextInputLayout(TextView textView) {
        TextInputLayout textInputLayout = null;

        ViewParent parent = textView.getParent();
        while (parent instanceof View) {
            if (parent instanceof TextInputLayout) {
                textInputLayout = (TextInputLayout) parent;
                break;
            }
            parent = parent.getParent();
        }
        return textInputLayout;
    }
}
