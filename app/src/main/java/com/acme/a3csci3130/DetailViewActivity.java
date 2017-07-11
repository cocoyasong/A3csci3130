package com.acme.a3csci3130;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class DetailViewActivity extends Activity {

    private EditText nameField, numberField,primaryField,addressField,provinceField;
    private Button update,erase;
    Contact receivedPersonInfo;
    private MyApplicationData appState;

    /**
     * when view the information of individuals
     * @param savedInstanceState
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_view);
        receivedPersonInfo = (Contact)getIntent().getSerializableExtra("Contact");
        appState = ((MyApplicationData) getApplicationContext());

        nameField = (EditText) findViewById(R.id.name);
        numberField = (EditText) findViewById(R.id.number);
        primaryField = (EditText) findViewById(R.id.primary);
        addressField = (EditText) findViewById(R.id.address);
        provinceField = (EditText) findViewById(R.id.province);

        update = (Button) findViewById(R.id.updateButton);
        erase = (Button) findViewById(R.id.deleteButton);

        if(receivedPersonInfo != null){
            nameField.setText(receivedPersonInfo.name);
            numberField.setText(receivedPersonInfo.number);
            primaryField.setText(receivedPersonInfo.primary);
            addressField.setText(receivedPersonInfo.address);
            provinceField.setText(receivedPersonInfo.province);

        }
    }

    /**
     * updating information
     * @param v
     */
    public void updateContact(View v){
        receivedPersonInfo.number=numberField.getText().toString();
        receivedPersonInfo.name=nameField.getText().toString();
        receivedPersonInfo.primary=primaryField.getText().toString();
        receivedPersonInfo.address=addressField.getText().toString();
        receivedPersonInfo.province=provinceField.getText().toString();
        appState.firebaseReference.child(receivedPersonInfo.uid).setValue(receivedPersonInfo);

        finish();

    }

    /**
     * delete information
     * @param v
     */
    public void eraseContact(View v)
    {
        appState.firebaseReference.child(receivedPersonInfo.uid).removeValue();
        finish();
    }
}
