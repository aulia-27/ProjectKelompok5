package com.example.projectmobileapplaundry.Login;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.projectmobileapplaundry.MainActivity.MainActivity;
import com.example.projectmobileapplaundry.R;
import com.google.android.gms.auth.api.identity.BeginSignInRequest;
import com.google.android.gms.auth.api.signin.GoogleSignIn;
import com.google.android.gms.auth.api.signin.GoogleSignInAccount;
import com.google.android.gms.auth.api.signin.GoogleSignInClient;
import com.google.android.gms.auth.api.signin.GoogleSignInOptions;
import com.google.android.gms.common.SignInButton;
import com.google.android.gms.common.api.ApiException;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthCredential;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.auth.GoogleAuthProvider;

public class LoginActivity extends AppCompatActivity {
//    EditText editEmail, editPassword;
//    Button btnLogin, btnRegister;
//    TextView txtLupaKataSandi, txtSingUp;
//    ProgressDialog progresDialog;
//    SignInButton btnRegisterGoogle;
//    FirebaseAuth mAuth;
//    GoogleSignInClient googleSignInClient;
    EditText editEmailLogin, editPasswordLogin;
    Button btnLogin;
    SignInButton btnRegisterGoogle;
    TextView txtLupaPassword, txtSingUp;
    FirebaseAuth firebaseAuth;
    ProgressDialog progressDialog;
    GoogleSignInClient googleSignInClient;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        editEmailLogin = findViewById(R.id.editEmailLogin);
        editPasswordLogin = findViewById(R.id.editPasswordLogin);
        txtLupaPassword = findViewById(R.id.txtLupaPassword);
        txtSingUp = findViewById(R.id.txtSingUp);
        btnLogin = findViewById(R.id.btnLogin);
        btnRegisterGoogle = findViewById(R.id.btnRegisterGoogle);

        String email = editEmailLogin.getText().toString();
        String password = editPasswordLogin.getText().toString();

        firebaseAuth = FirebaseAuth.getInstance();
        progressDialog = new ProgressDialog(LoginActivity.this);
        progressDialog.setTitle("LOADING");
        progressDialog.setMessage("Mohon Ditunggu Sebentar");
        progressDialog.setCancelable(false);

        ///googleSignIn
        GoogleSignInOptions googleSignInOptions = new GoogleSignInOptions.Builder(GoogleSignInOptions.DEFAULT_GAMES_SIGN_IN).
                requestIdToken(getString(R.string.webclientid)).requestEmail().build();
        googleSignInClient = GoogleSignIn.getClient(this,googleSignInOptions);

        btnLogin.setOnClickListener(view -> {
            if (editEmailLogin.getText().length()> 0 && editPasswordLogin.getText().length()>0){
                LoginProccess(editEmailLogin.getText().toString(), editPasswordLogin.getText().toString());
            } else {
                if (email.isEmpty()){
                    editEmailLogin.setError("Silakan Masukan Email");
                } if(password.isEmpty()){
                    editPasswordLogin.setError("Silakan Isi Password");
                }
                Toast.makeText(getApplicationContext(), "Silakan Isi Username dan Password", Toast.LENGTH_LONG).show();
            }
        });

        btnRegisterGoogle.setOnClickListener(view -> {
            googleLogin();
        });

        txtLupaPassword.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(getApplicationContext(), ForgetPassword.class));
            }
        });

        txtSingUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(getApplicationContext(), RegisterActivity.class));
            }
        });
    }

    private void googleLogin() {
        Intent signInIntent = googleSignInClient.getSignInIntent();
        startActivityForResult(signInIntent, 1001);
    }

    private void LoginProccess(String email, String password) {
        // Initialize Firebase Auth
        progressDialog.show();
        firebaseAuth.signInWithEmailAndPassword(email, password). addOnCompleteListener(new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {
                if (task.isSuccessful() && task.getResult() != null){
                    if (task.getResult().getUser() != null){
                        Reload();
                    } else {
                        Toast.makeText(getApplicationContext(), "Maaf, Login Gagal !", Toast.LENGTH_LONG).show();
                    }
                    progressDialog.dismiss();
                }
            }
        });
    }

    public void onStart(){
        super.onStart();
        FirebaseUser firebaseUser = firebaseAuth.getCurrentUser();
        if (firebaseUser != null){
            Reload();
        }
    }

    private void Reload() {
        startActivity(new Intent(getApplicationContext(), MainActivity.class));
    }

    // [START onactivityresult]
    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        // Result returned from launching the Intent from GoogleSignInApi.getSignInIntent(...);
        if (requestCode == 1001) {
            Task<GoogleSignInAccount> task = GoogleSignIn.getSignedInAccountFromIntent(data);
            try {
                // Google Sign In was successful, authenticate with Firebase
                GoogleSignInAccount account = task.getResult(ApiException.class);
                Log.d("Google Sign In", "firebaseAuthWithGoogle:" + account.getId());
                firebaseAuthWithGoogle(account.getIdToken());
            } catch (ApiException e) {
                // Google Sign In failed, update UI appropriately
                Log.w("Google Sign In", "Google sign in failed", e);
            }
        }
    }

    // [START auth_with_google]
    private void firebaseAuthWithGoogle(String idToken) {
        AuthCredential credential = GoogleAuthProvider.getCredential(idToken, null);
        firebaseAuth.signInWithCredential(credential)
                .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if (task.isSuccessful()) {
                            // Sign in success, update UI with the signed-in user's information
                            Log.d("Google Sign In", "signInWithCredential:success");
                            FirebaseUser user = firebaseAuth.getCurrentUser();
                        } else {
                            // If sign in fails, display a message to the user.
                            Log.w("Google Sign In", "signInWithCredential:failure", task.getException());
                        }
                        Reload();
                    }
                });
    }
    // [END auth_with_google]
}