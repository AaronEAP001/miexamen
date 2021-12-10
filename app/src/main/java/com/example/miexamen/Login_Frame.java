package com.example.miexamen;

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

public class Login_Frame extends Fragment {
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState){
        View view = inflater.inflate(R.layout.login_frame,container,false);
        final TextInputLayout passwordTextInput = view.findViewById(R.id.password_text_input);
        final TextInputEditText passwordEditText = view.findViewById(R.id.password_edit_input);
        MaterialButton loginButton = view.findViewById(R.id.login_button_star);

        loginButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (!isPasswordValid(passwordEditText.getText())){
                    passwordTextInput.setError(getString(R.string.login_error_message));
                }else {
                    passwordTextInput.setError(null);
                    ((NavigationHost) getActivity()).navigateTo(new HomeFragment(),false);
                }
            }
        });

        passwordEditText.setOnKeyListener(new View.OnKeyListener() {
            @Override
            public boolean onKey(View v, int keyCode, KeyEvent event) {
                if (!isPasswordValid(passwordEditText.getText())){
                    passwordTextInput.setError(getString(R.string.login_error_message));
                }
                return false;
            }
        });

        return view;
    }
    private boolean isPasswordValid(@Nullable Editable text){ return text!=null && text.length()>=6;}
}
