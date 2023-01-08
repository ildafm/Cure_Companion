package com.rekom.CureCompanion;

import static com.rekom.CureCompanion.R.id.progressBarOfotpAuth;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseAuthInvalidCredentialsException;
import com.google.firebase.auth.PhoneAuthCredential;
import com.google.firebase.auth.PhoneAuthProvider;

public class otpAuthentication extends AppCompatActivity {

    TextView mChangeNumber;
    EditText mgetOtp;
    Button mVerifyOtp;
    String enterotp;

    FirebaseAuth firebaseAuth;
    ProgressBar mProgressOfOtpAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_otp_authentication);

        mChangeNumber = findViewById(R.id.changenumber);
        mgetOtp = findViewById(R.id.getotp);
        mVerifyOtp = findViewById(R.id.verifyotp);
        mProgressOfOtpAuth = findViewById(progressBarOfotpAuth);

        firebaseAuth = FirebaseAuth.getInstance();

        mChangeNumber.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(otpAuthentication.this, MainActivity.class);
                startActivity(intent);
            }
        });

        mVerifyOtp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                enterotp = mgetOtp.getText().toString();
                if (enterotp.isEmpty()) {
                    Toast.makeText(getApplicationContext(), "Enter Your OTP First", Toast.LENGTH_SHORT).show();
                } else {
                    mProgressOfOtpAuth.setVisibility(View.VISIBLE);
                    String codeReceived = getIntent().getStringExtra("otp");
                    PhoneAuthCredential credential = PhoneAuthProvider.getCredential(codeReceived, enterotp);
                    signInWithPhoneAuthCreadential(credential);
                }
            }
        });


    }

    private void signInWithPhoneAuthCreadential(PhoneAuthCredential credential)
    {
        firebaseAuth.signInWithCredential(credential).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {
                if(task.isSuccessful())
                {
                    mProgressOfOtpAuth.setVisibility(View.INVISIBLE);
                    Toast.makeText(getApplicationContext(), "Login Success", Toast.LENGTH_SHORT).show();
                    Intent intent=new Intent(otpAuthentication.this,setProfile.class);
                    startActivity(intent);
                    finish();
                }
                else
                {
                    if(task.getException() instanceof FirebaseAuthInvalidCredentialsException)
                    {
                        mProgressOfOtpAuth.setVisibility(View.INVISIBLE);
                        Toast.makeText(getApplicationContext(), "Login Failed", Toast.LENGTH_SHORT).show();
                    }
                }
            }
        });
    }

}