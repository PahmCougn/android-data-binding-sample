package com.smile.databindingsample.common.validation;

import android.databinding.ViewDataBinding;
import android.view.View;
import android.view.ViewGroup;

import com.smile.databindingsample.R;
import com.smile.databindingsample.common.validation.rules.BaseRule;

import java.util.Collections;
import java.util.List;

/**
 * Created by digimed on 7/18/17.
 */

public class Validator {
    private ViewDataBinding viewDataBinding;
    public Validator(ViewDataBinding viewDataBinding){
        this.viewDataBinding = viewDataBinding;
    }
    public boolean validate(){
        return viewDataBinding != null && isValid();
    }

    private List<View> getViewsWithValidation() {
        if(viewDataBinding.getRoot() instanceof ViewGroup) {
            return TagViewHelper.getViewsByTag((ViewGroup) viewDataBinding.getRoot(), R.id.validation);
        }
        return Collections.singletonList(viewDataBinding.getRoot());
    }

    private boolean isValid(){
        boolean result = true;
        List<View> viewWithValidations = getViewsWithValidation();
        for (View viewWithValidation : viewWithValidations) {
            boolean viewValid = true;
            List<BaseRule> rules = (List) viewWithValidation.getTag(R.id.validation);
            for (BaseRule rule : rules) {
                viewValid = viewValid && rule.validate();
                result = result && viewValid;
            }

        }
        return result;
    }
}
