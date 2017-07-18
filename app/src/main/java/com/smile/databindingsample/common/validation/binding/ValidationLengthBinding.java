package com.smile.databindingsample.common.validation.binding;

import android.databinding.BindingAdapter;
import android.widget.TextView;

import com.smile.databindingsample.R;
import com.smile.databindingsample.common.validation.TagViewHelper;
import com.smile.databindingsample.common.validation.rules.RequiredRule;

/**
 * Created by digimed on 7/18/17.
 */

public class ValidationLengthBinding {
    @BindingAdapter(value = {"validateRequired", "validateRequiredErrorMessage"}, requireAll = true)
    public static void bindingRequiredField(TextView view,boolean required,String errorMessage) {
        if (required)
        TagViewHelper.appendValue(R.id.validation, view, new RequiredRule(view, errorMessage));
    }
}
