package com.smile.databindingsample.viewmodels;

import android.databinding.BaseObservable;

/**
 * Created by digimed on 7/17/17.
 */

public class LoginViewModel extends BaseObservable {
    public String username;
    public String password;

    /**
     * validate username and password.Username and password cannot be blank
     */
    public void validate(){
    }

    /**
     *  call login api
     */
    public void login(){

     }
     public String getUsernameError(){
         if (username == null || username.isEmpty()){
             return "Error";
         } return null;
     }


}
