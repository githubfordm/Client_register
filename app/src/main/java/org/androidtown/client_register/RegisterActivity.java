package org.androidtown.client_register;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class RegisterActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        Intent intent = getIntent();

        if(intent!=null) {

            TextView getName = (TextView) findViewById(R.id.getName);
            TextView getGender = (TextView) findViewById(R.id.getGender);
            TextView getContact = (TextView) findViewById(R.id.getContact);
            Button button = (Button) findViewById(R.id.button);

            String forName = intent.getStringExtra("name");
            String forGender = intent.getStringExtra("gender");
            String forContact = intent.getStringExtra("contact");

            getName.setText(forName);
            getGender.setText(forGender);
            getContact.setText(forContact);

            button.setOnClickListener(new View.OnClickListener() {

                public void onClick(View v) {
                    finish();
                }
            });

        }




    }
}
