package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.example.myapplication.StudentInfoActivity;
import com.google.android.material.textfield.TextInputLayout;

public class PersonalInfoActivity extends AppCompatActivity {

    private TextInputLayout oIme;
    private TextInputLayout oPrezime;
    private EditText oDatum;
    private Button oButton;

    private String ime;
    private String prezime;
    private String datum;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_personal_info);

        oIme = (TextInputLayout)findViewById(R.id.inputIme);
        oPrezime = (TextInputLayout)findViewById(R.id.inputPrezime);
        oDatum = (EditText)findViewById(R.id.inputDatum);
        oButton = (Button)findViewById(R.id.personaInfoButton);

        oButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ime = oIme.getEditText().getText().toString();
                prezime = oPrezime.getEditText().getText().toString();
                datum = oDatum.getText().toString();

                Intent oProslijediPodatkeIntent = new Intent(getApplicationContext(), StudentInfoActivity.class);
                oProslijediPodatkeIntent.putExtra("ime", ime);
                oProslijediPodatkeIntent.putExtra("prezime", prezime);
                oProslijediPodatkeIntent.putExtra("datum", datum);

                startActivity(oProslijediPodatkeIntent);
            }
        });
    }
}
