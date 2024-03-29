package com.example.medicalapplicationsystem;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    EditText username;
    EditText password;
    Button loginbutton;

    private Button button,empbutton,fai;
   TextView signtext;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        empbutton = findViewById(R.id.emg);
        fai = findViewById(R.id.fai);

        username = findViewById(R.id.username);
        password = findViewById(R.id.password);
        loginbutton = findViewById(R.id.loginbutton);
        signtext = findViewById(R.id.signtext);
        signtext.setOnClickListener(view -> {
            Intent intent = new Intent(this, Register.class);
            startActivities(new Intent[]{intent});
        }); fai.setOnClickListener(view -> {
            Intent intent = new Intent(this, Firstaid.class);
            startActivities(new Intent[]{intent});
        });
        empbutton.setOnClickListener(view -> {
            DatabaseHelper dbHelper = new DatabaseHelper(getApplicationContext());
            String emergencyPhoneNumber = dbHelper.getEmergencyPhoneNumber();
            Toast.makeText(MainActivity.this,"Calling Emergency PhoneNumber",Toast.LENGTH_SHORT).show();
            if (emergencyPhoneNumber != null) {
                Intent intent = new Intent(Intent.ACTION_DIAL);
                intent.setData(Uri.parse("tel:"+emergencyPhoneNumber));
                startActivity(intent);
            }
            else{
                Toast.makeText(MainActivity.this,"No Emergency Phone Number Saved",Toast.LENGTH_SHORT).show();

            }
        });
        loginbutton.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view) {
                if(username.getText().toString().equalsIgnoreCase("admin") && password.getText().toString().equalsIgnoreCase("admin"))
                {
                    Toast.makeText(MainActivity.this, "Login Successfully processed", Toast.LENGTH_SHORT).show();
                    openHomepage2();
                } else   {
                    String urname = username.getText().toString();
                    String pssword = password.getText().toString();
                    if (isValidCredentials(urname, pssword)) {
                        openHomepage();
                    }
                    else
                    {
                        Toast.makeText(MainActivity.this, "Username or Password Incorrect!", Toast.LENGTH_SHORT).show();
                    }
                }

            }

        });
    }

    private void openHomepage2() {
        Intent intent = new Intent(this, Admin.class);
        startActivities(new Intent[]{intent});
    }

    private boolean isValidCredentials(String username, String password) {
        // Query the SQLite database to check if the provided username and password match any user
        DatabaseHelper dbHelper = new DatabaseHelper(MainActivity.this);
        return dbHelper.checkUser(username, password); // This method should return true if credentials are valid
    }

    public void openHomepage()
    {
        Intent intent = new Intent(this, HomeNew.class);
        startActivities(new Intent[]{intent});
    }
}