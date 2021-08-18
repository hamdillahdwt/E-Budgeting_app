package com.aplikasi.eBudgeting;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

import java.util.HashMap;
import java.util.Map;

public class UpdateAkun extends AppCompatActivity {

    private EditText userEmail, oldpass, newpass;
    private Button bataltBtn, ubahBtn;

    FirebaseAuth fAuth;
    FirebaseUser user;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_update_akun);

        bataltBtn = findViewById(R.id.batalBtn);
        ubahBtn = findViewById(R.id.ubahBtn);
        userEmail  = findViewById(R.id.UBAH_email);
        oldpass = findViewById(R.id.oldPassword);
        newpass = findViewById(R.id.newPassword);

        fAuth = FirebaseAuth.getInstance();
        user = fAuth.getCurrentUser();

        userEmail.setText(FirebaseAuth.getInstance().getCurrentUser().getEmail());


        bataltBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(UpdateAkun.this, AccountActivity.class);
                startActivity(intent);
            }
        });

        ubahBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                final String email = userEmail.getText().toString();
                final String password = newpass.getText().toString();
                final String confirmPass = oldpass.getText().toString();

                if (userEmail.getText().toString().isEmpty() || newpass.getText().toString().isEmpty()
                        || oldpass.getText().toString().isEmpty()) {
                    Toast.makeText(UpdateAkun.this, "Kolom Tidak Boleh Kosong!", Toast.LENGTH_SHORT).show();
                    return;
                }
                if (!password.equals(confirmPass)){
                    newpass.setError("Password Tidak Sesuai!");
                    return;
                }
                user.updatePassword(password).addOnSuccessListener(new OnSuccessListener<Void>() {
                    @Override
                    public void onSuccess(Void aVoid) {
                        user.updateEmail(email);
                        Toast.makeText(UpdateAkun.this, "Akun Updated", Toast.LENGTH_SHORT).show();
                        startActivity(new Intent(getApplicationContext(), AccountActivity.class));
                    }
                }).addOnFailureListener(new OnFailureListener() {
                    @Override
                    public void onFailure(@NonNull Exception e) {
                        Toast.makeText(UpdateAkun.this, e.getMessage(), Toast.LENGTH_SHORT).show();
                    }
                });
            }

        });}
}