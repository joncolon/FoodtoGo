package nyc.c4q.leighdouglas.foodtogo.hakeem;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
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
    private final String TAG = "FireBase";
    EditText userName;
    EditText name;
    EditText password;
    EditText passwordConfirm;
    EditText emailSignup;
    EditText emailConfirm;
    Button signUpButton;
    private Firebase myFirebaseRef;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup);
        mAuth = FirebaseAuth.getInstance();
        myFirebaseRef = new Firebase("https://foodtogo-e8afc.firebaseio.com/");

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
        emailSignup = (EditText) findViewById(R.id.email_signup);
        emailConfirm = (EditText) findViewById(R.id.confirm_email_signup);
        signUpButton = (Button) findViewById(R.id.sign_up_button);
        signUpButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (isFormComplete()) {
                    createAccount(emailSignup.getText().toString(), password.getText().toString());
                } else {
                    Toast.makeText(getApplicationContext(),"enter usermame password and email",Toast.LENGTH_SHORT);
                }
            }
        });
    }
    @Override
    public void onStart() {
        super.onStart();
        mAuth.addAuthStateListener(mAuthListenerSUA);
    }
    @Override
    public void onStop() {
        super.onStop();
        if (mAuthListenerSUA != null) {
            mAuth.removeAuthStateListener(mAuthListenerSUA);
        }
    }
    private void createAccount(String email, String password) {
        if ((email + "").equals("") || (password + "").equals("")) {
            Toast.makeText(getApplicationContext(), "enter username and password", Toast.LENGTH_SHORT);
        } else {
            mAuth.createUserWithEmailAndPassword(email, password)
                    .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                        @Override
                        public void onComplete(@NonNull Task<AuthResult> task) {
                            // Log.d(TAG, "createUserWithEmail:onComplete:" + task.isSuccessful());
                            if (!task.isSuccessful()) {

                                Log.d(TAG, "onComplete: " +task.getException().getMessage());
                                Toast.makeText(getApplicationContext(), "Authentication failed.",
                                        Toast.LENGTH_SHORT).show();
                             }else {
//                                myFirebaseRef.authWithPassword(email, password, new Firebase.AuthResultHandler() {
//                                    @Override
//                                    public void onAuthenticated(AuthData authData) {
//                                        System.out.println("User ID: " + authData.getUid() + ", Provider: " + authData.getProvider());
//                                        //business name address phone# isrunner
//                                    }
//                                    @Override
//                                    public void onAuthenticationError(FirebaseError firebaseError) {
//                                        // there was an error
//                                    }});
                                User user = new User(userName.getText().toString(),emailSignup.getText().toString());
                                myFirebaseRef.child("users").child(mAuth.getCurrentUser().getProviderId()).setValue(user);
                                Intent intent = new Intent(getApplicationContext(), LoginActivityFirebase.class);
                                startActivity(intent);
                            }
                        }
                    });
        }
    }

    private boolean isFormComplete() {
        boolean bool = !(userName.getText().toString() + "").equals("") &&
                !(name.getText().toString() + "").equals("") &&
                !(emailConfirm.getText().toString() + "").equals("") &&
                !(emailSignup.getText().toString() + "").equals("") &&
                !(password.getText().toString() + "").equals("") &&
                !(passwordConfirm.getText().toString() + "").equals("");
        return bool;
    }
}

