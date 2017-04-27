package org.androidtown.client_register;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;

public class MainActivity extends AppCompatActivity {

    String getName="";
    String getGender="";
    String getContact="";

    EditText editText;
    RadioGroup radioGroup;
    RadioButton male;
    RadioButton female;
    CheckBox SMS;
    CheckBox eMail;
    Button button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editText = (EditText) findViewById(R.id.editText);
        radioGroup = (RadioGroup) findViewById(R.id.radioGroup);
        male = (RadioButton) findViewById(R.id.male);
        female = (RadioButton) findViewById(R.id.female);
        SMS = (CheckBox) findViewById(R.id.SMS);
        eMail = (CheckBox) findViewById(R.id.eMail);
        button = (Button) findViewById(R.id.button);

        button.setOnClickListener(new View.OnClickListener() {

            public void onClick(View v) {

                getName = editText.getText().toString();

                int radioId = radioGroup.getCheckedRadioButtonId();

                if (male.getId() == radioId)
                    getGender = "남";

                else if (female.getId() == radioId)
                    getGender = "여";

                if (SMS.isChecked()) {
                    getContact = getContact + "SMS";

                    if (eMail.isChecked())
                        getContact = getContact + " & e-mail";
                }

                else if (eMail.isChecked())
                    getContact = getContact + "e-mail";

                Intent intent = new Intent(getApplicationContext(), RegisterActivity.class);

                intent.putExtra("name", getName);
                intent.putExtra("gender", getGender);
                intent.putExtra("contact", getContact);

                startActivity(intent);


            }
        });


    }
}
