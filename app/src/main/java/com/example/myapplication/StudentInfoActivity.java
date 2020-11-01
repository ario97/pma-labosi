package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.textfield.TextInputLayout;

public class StudentInfoActivity extends AppCompatActivity {

    private String ime;
    private String prezime;
    private String datum;

    private TextInputLayout oPredmet;
    private TextInputLayout oProfesor;
    private TextInputLayout oAkGod;
    private TextInputLayout oSatiPredavanja;
    private TextInputLayout oSatiLva;
    private Button oDaljeButton;

    private String predmet;
    private String profesor;
    private String akGod;
    private String satiPredavanja;
    private String satiLva;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_student_info);

        final Bundle oExtras = getIntent().getExtras();
        ime = oExtras.getString("ime");
        prezime = oExtras.getString("prezime");
        datum = oExtras.getString("datum");

        oPredmet = (TextInputLayout) findViewById(R.id.inputPredmet);
        oProfesor = (TextInputLayout) findViewById(R.id.inputProfesor);
        oAkGod = (TextInputLayout) findViewById(R.id.inputAkGod);
        oSatiPredavanja = (TextInputLayout) findViewById(R.id.inputSatiPredavanja);
        oSatiLva = (TextInputLayout) findViewById(R.id.inputSatiLv);
        oDaljeButton = (Button)findViewById(R.id.studentInfoButton);

        oDaljeButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                predmet = oPredmet.getEditText().getText().toString();
                profesor = oProfesor.getEditText().getText().toString();
                akGod = oAkGod.getEditText().getText().toString();
                satiPredavanja = oSatiPredavanja.getEditText().getText().toString();
                satiLva = oSatiLva.getEditText().getText().toString();

                Intent ProslijediPodatkeIntent = new Intent(getApplicationContext(), SummaryActivity.class);
                ProslijediPodatkeIntent.putExtra("ime", ime);
                ProslijediPodatkeIntent.putExtra("prezime", prezime);
                ProslijediPodatkeIntent.putExtra("datum", datum);
                ProslijediPodatkeIntent.putExtra("predmet", predmet);
                ProslijediPodatkeIntent.putExtra("profesor", profesor);
                ProslijediPodatkeIntent.putExtra("akGod", akGod);
                ProslijediPodatkeIntent.putExtra("satiPredavanja", satiPredavanja);
                ProslijediPodatkeIntent.putExtra("satiLva", satiLva);

                startActivity(ProslijediPodatkeIntent);
            }
        });
    }
}