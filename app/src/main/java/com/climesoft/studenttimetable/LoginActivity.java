package com.climesoft.studenttimetable;

import android.support.annotation.NonNull;
import android.support.design.widget.TextInputLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

import com.climesoft.studenttimetable.util.ActivityUtil;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseUser;

public class LoginActivity extends BaseActivity {
    private TextInputLayout txtEmail;
    private TextInputLayout txtPass;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if(user!=null){
            ActivityUtil.moveToActivity(LoginActivity.this, TimeTableActivity.class);
            LoginActivity.this.finish();
        }
        setContentView(R.layout.activity_login);
        txtEmail = findViewById(R.id.textInputEmail);
        txtPass = findViewById(R.id.textInputPassword);
    }

    public void login(final View view){
        String email = txtEmail.getEditText().getText().toString();
        String password = txtPass.getEditText().getText().toString();
        if(email.isEmpty() || password.isEmpty()){
            ActivityUtil.showMessage(this, "Fill all fields!");
            return;
        }
        view.setEnabled(false);
        mAuth.signInWithEmailAndPassword(email.trim(), password)
                .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        loginToServer(task, view);
                    }
                });
    }

    private void loginToServer(Task<AuthResult> task, View view) {
        if (task.isSuccessful()) {
            ActivityUtil.moveToActivity(LoginActivity.this, TimeTableActivity.class);
            LoginActivity.this.finish();
        } else {
            ActivityUtil.showMessage(LoginActivity.this, "Login Failed!");
            Log.d("LoginActivity", "", task.getException());
        }
        view.setEnabled(true);
    }

    public void registerActivity(View view) {
        ActivityUtil.moveToActivity(this, RegistrationActivity.class);
        this.finish();
    }

    public void forget(View view) {
        ActivityUtil.moveToActivity(this, PasswordResetActivity.class);
        this.finish();
    }

    public void questLogin(final View view) {
        view.setEnabled(false);
        mAuth.signInAnonymously()
                .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        loginToServer(task, view);
                    }
                });
    }
}
