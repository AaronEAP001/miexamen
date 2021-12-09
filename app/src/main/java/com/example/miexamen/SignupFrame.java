package com.example.miexamen;

import android.app.Activity;
import android.os.Bundle;
import android.text.Editable;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.google.android.material.button.MaterialButton;
import com.google.android.material.textfield.TextInputEditText;
import com.google.android.material.textfield.TextInputLayout;

public class SignupFrame extends Fragment {
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState){
        View view = inflater.inflate(R.layout.signup_frame,container,false);

        final TextInputLayout nameTextInput = view.findViewById(R.id.sigup_full_input);
        final TextInputEditText nameEditText = view.findViewById(R.id.sigup_full_edit);
        final TextInputLayout nickTextInput = view.findViewById(R.id.sigup_user_input);
        final TextInputEditText nickEditText = view.findViewById(R.id.sigup_username_edit);
        final TextInputLayout passwordTextInput = view.findViewById(R.id.sigup_password_input);
        final TextInputEditText passwordEditText = view.findViewById(R.id.sigup_password_edit);

        MaterialButton registroBtn = view.findViewById(R.id.login_button_signup);

        registroBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (passwordEditText.getText().length()==0){
                    passwordTextInput.setError(getString(R.string.helper_text));
                }else if(nickEditText.getText().length()==0){
                    nickTextInput.setError(getString(R.string.helper_text));
                }else if(nameEditText.getText().length()==0){
                    nameTextInput.setError(getString(R.string.helper_text));
                }
                else {
                    passwordTextInput.setError(null);
                    nameTextInput.setError(null);
                    nickTextInput.setError(null);
                    ((NavigationHost)getActivity()).navigateTo(new HomeFragment(),false);
                }
            }
        });

        nameEditText.setOnKeyListener(new View.OnKeyListener() {
            @Override
            public boolean onKey(View v, int keyCode, KeyEvent event) {
                if(nameEditText.getText().length()==0){
                    nameTextInput.setError(getString(R.string.helper_text));
                }
                return false;
            }
        });
        nickEditText.setOnKeyListener(new View.OnKeyListener() {
            @Override
            public boolean onKey(View v, int keyCode, KeyEvent event) {
                if(nickEditText.getText().length()==0){
                    nickTextInput.setError(getString(R.string.helper_text));
                }
                return false;
            }
        });
        passwordEditText.setOnKeyListener(new View.OnKeyListener() {
            @Override
            public boolean onKey(View v, int keyCode, KeyEvent event) {
                if (passwordEditText.getText().length()==0){
                    passwordTextInput.setError(getString(R.string.helper_text));
                }
                return false;
            }
        });

        return view;
    }

}
