package com.smile.databindingsample.common.validation.rules;

import android.view.View;

/**
 * Created by digimed on 7/18/17.
 */

public abstract class BaseRule <V extends View> {
    protected V view;
    public CharSequence errorMessage;

    public BaseRule(V view,CharSequence errorMessage) {
        this.view = view;
        this.errorMessage = errorMessage;
    }

    public final boolean validate(){
        boolean result =  this.isValid();
        this.onUpdatedResultValidation(result);
        return result;
    }

    protected abstract boolean isValid();
    protected abstract void onUpdatedResultValidation(boolean isError);

}
