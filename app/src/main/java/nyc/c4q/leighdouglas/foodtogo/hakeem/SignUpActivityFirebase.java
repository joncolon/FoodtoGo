package nyc.c4q.leighdouglas.foodtogo.hakeem;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

import nyc.c4q.leighdouglas.foodtogo.R;

/**
 * Created by leighdouglas on 2/18/17.
 */

public class SignUpActivityFirebase extends AppCompatActivity {
    private FirebaseAuth mAuth;
    private FirebaseAuth.AuthStateListener mAuthListenerSUA;
    private static String TAG = "FireBase";
    EditText userName;
    EditText name;
    EditText password;
    EditText passwordConfirm;
    EditText email;
    EditText emailConfirm;
    Button

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mAuth = FirebaseAuth.getInstance();
        mAuthListenerSUA = new FirebaseAuth.AuthStateListener() {
            @Override
            public void onAuthStateChanged(@NonNull FirebaseAuth firebaseAuth) {
                FirebaseUser user = firebaseAuth.getCurrentUser();
                if (user != null) {
                    // User is signed in
                    Log.d(TAG, "onAuthStateChanged:signed_in:" + user.getUid());
                } else {
                    // User is signed out
                    Log.d(TAG, "onAuthStateChanged:signed_out");
                }// ...
            }
        };
        userName = (EditText) findViewById(R.id.username_signup);
        name = (EditText) findViewById(R.id.name_signup);
        password = (EditText) findViewById(R.id.password_signup);
        passwordConfirm = (EditText) findViewById(R.id.confirm_password_signup);
        email = (EditText) findViewById(R.id.email_signup);
        emailConfirm = (EditText) findViewById(R.id.confirm_email_signup);
    }

    private void createAccount(String email, String password) {
        mAuth.createUserWithEmailAndPassword(email, password)
                .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                       // Log.d(TAG, "createUserWithEmail:onComplete:" + task.isSuccessful());

                        if (!task.isSuccessful()) {
                            Toast.makeText(getApplicationContext(), "Authentication failed.",
                                    Toast.LENGTH_SHORT).show();
                        }else{
                            Intent intent = new Intent(getApplicationContext(), LoginActivityFirebase.class);
                            startActivity(intent);
                        }
                    }
                });
    }

    private boolean isFormComplete() {
        boolean bool = (userName.getText().toString() + "").equals("") ||
                (name.getText().toString() + "").equals("") ||
                (emailConfirm.getText().toString() + "").equals("") ||
                (email.getText().toString() + "").equals("") ||
                (password.getText().toString() + "").equals("") ||
                (passwordConfirm.getText().toString() + "").equals("");
        return bool;
    }
}

