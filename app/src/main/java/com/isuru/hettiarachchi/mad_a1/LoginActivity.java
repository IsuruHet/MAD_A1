package com.isuru.hettiarachchi.mad_a1;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.QueryDocumentSnapshot;

import java.util.Objects;


public class LoginActivity extends AppCompatActivity {

    private EditText userIDEditText, passwordEditText;
    private FirebaseAuth mAuth;
    private FirebaseFirestore db;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        mAuth = FirebaseAuth.getInstance();
        db = FirebaseFirestore.getInstance();

        userIDEditText = findViewById(R.id.userID);  // Use Custom ID (S0001)
        passwordEditText = findViewById(R.id.password);
        Button loginButton = findViewById(R.id.signInBtn);

        loginButton.setOnClickListener(v -> {
            String userID = userIDEditText.getText().toString().trim();
            String password = passwordEditText.getText().toString().trim();

            if (!userID.isEmpty() && !password.isEmpty()) {
                loginUser(userID, password);
            } else {
                Toast.makeText(LoginActivity.this, "Enter User ID and Password", Toast.LENGTH_SHORT).show();
            }
        });
    }

    private void loginUser(String userID, String password) {
        // Step 1: Find the Firebase UID by searching for the userID in Firestore
        db.collection("users").whereEqualTo("userID", userID)
                .get()
                .addOnCompleteListener(task -> {
                    if (task.isSuccessful() && !task.getResult().isEmpty()) {
                        for (QueryDocumentSnapshot document : task.getResult()) {
                            String email = document.getString("email");  // Retrieve email
                            authenticateWithEmail(email, password);  // Step 2: Authenticate
                            return;
                        }
                    } else {
                        Toast.makeText(LoginActivity.this, "User ID not found", Toast.LENGTH_SHORT).show();
                    }
                });
    }

    private void authenticateWithEmail(String email, String password) {
        mAuth.signInWithEmailAndPassword(email, password)
                .addOnCompleteListener(task -> {
                    if (task.isSuccessful()) {
                        FirebaseUser user = mAuth.getCurrentUser();
                        if (user != null) {
                            Toast.makeText(LoginActivity.this, "Login Successful!", Toast.LENGTH_SHORT).show();
                            Intent intent = new Intent(this,DashboardActivity.class);
                            startActivity(intent);
                        }
                    } else {
                        Toast.makeText(LoginActivity.this, "Login Failed: " + Objects.requireNonNull(task.getException()).getMessage(), Toast.LENGTH_SHORT).show();
                    }
                });
    }
}
