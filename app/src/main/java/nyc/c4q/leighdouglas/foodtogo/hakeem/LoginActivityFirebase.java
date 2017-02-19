package nyc.c4q.leighdouglas.foodtogo.hakeem;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

import nyc.c4q.leighdouglas.foodtogo.R;
import nyc.c4q.leighdouglas.foodtogo.leigh.RestaurantListActivity;
import nyc.c4q.leighdouglas.foodtogo.leigh.RestaurantProfileActivity;

public class LoginActivityFirebase extends AppCompatActivity {

    private EditText emailET, passwordET;
    private RadioButton runnerRadioBtn, restaurantRadioBtn;
    private Button nextBtn;
    private boolean checked;
    private int picked = 0;
    private FirebaseAuth mAuth;
    private FirebaseAuth.AuthStateListener mAuthListener;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        initViews();
        mAuth = FirebaseAuth.getInstance();
        mAuthListener = firebaseAuth -> {
            FirebaseUser user = firebaseAuth.getCurrentUser();
            if (user != null) {
                // User is signed in
                //Log.d(TAG, "onAuthStateChanged:signed_in:" + user.getUid());
            } else {
                // User is signed out
                //Log.d(TAG, "onAuthStateChanged:signed_out");
            }
            // ...
        };
    }

    @Override
    public void onStart() {
        super.onStart();
        mAuth.addAuthStateListener(mAuthListener);
    }

    @Override
    public void onStop() {
        super.onStop();
        if (mAuthListener != null) {
            mAuth.removeAuthStateListener(mAuthListener);
        }
    }

    private void initViews() {
        emailET = (EditText) findViewById(R.id.email_ET);
        passwordET = (EditText) findViewById(R.id.password_ET);
        runnerRadioBtn = (RadioButton) findViewById(R.id.runnerRadio_Btn);
        restaurantRadioBtn = (RadioButton) findViewById(R.id.restaurantRadio_Btn);
        nextBtn = (Button) findViewById(R.id.next_Btn);
        nextBtn.setOnClickListener(v -> signin(emailET.getText().toString(), passwordET.getText().toString()));
    }

    public void onRadioButtonClicked(View view) {
        checked = ((RadioButton) view).isChecked();
        switch (view.getId()) {
            case R.id.runnerRadio_Btn:
                if (checked)
                    picked = 1;
                break;
            case R.id.restaurantRadio_Btn:
                if (checked)
                    picked = 2;
                break;
        }

    }

    private void signin(String email, String password) {
        if ((email + "").equals("") || (password + "").equals("")) {
            Toast.makeText(getApplicationContext(), "enter username and password", Toast.LENGTH_SHORT).show();
        } else {
            mAuth.signInWithEmailAndPassword(email, password)
                    .addOnCompleteListener(this, task -> {

                        if (!task.isSuccessful()) {
                            // Log.w(TAG, "signInWithEmail", task.getException());
                            Toast.makeText(getApplicationContext(), "Authentication failed.",
                                    Toast.LENGTH_SHORT).show();
                        } else {
                            if (picked == 1) {
                                Toast.makeText(getApplicationContext(), "RUNNER", Toast.LENGTH_LONG).show();
                                Intent runner = new Intent(getApplicationContext(), RestaurantListActivity.class);
                                startActivity(runner);
                            } else if (picked == 2) {
                                Intent restaurant = new Intent(getApplicationContext(), RestaurantProfileActivity.class);
                                startActivity(restaurant);
                            }
                        }
                    });
        }
    }
}
