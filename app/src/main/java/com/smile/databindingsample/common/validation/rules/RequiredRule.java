package com.smile.databindingsample.common.validation.rules;

import android.text.TextUtils;
import android.widget.TextView;

import com.smile.databindingsample.common.validation.EditTextHelper;

/**
 * Created by digimed on 7/18/17.
 */

public class RequiredRule extends BaseRule<TextView> {

    public RequiredRule(TextView txtContent, CharSequence errorMessage) {
       super(txtContent,errorMessage);
    }
    @Override
    protected boolean isValid() {
        return this.view != null && !TextUtils.isEmpty(view.getText());
    }

    @Override
    protected void onUpdatedResultValidation(boolean result) {
        if (result){
            EditTextHelper.removeError(this.view);
        } else {
            EditTextHelper.setError(this.view,this.errorMessage.toString());
        }
    }
}
