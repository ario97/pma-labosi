package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class SummaryActivity extends AppCompatActivity {

    private String ime;
    private String prezime;
    private String datum;
    private String predmet;
    private String profesor;
    private String akGod;
    private String satiPredavanja;
    private String satiLva;

    private TextView oIme;
    private TextView oPrezime;
    private TextView oDatum;
    private TextView oPredmet;
    private TextView oProfesor;
    private TextView oAkGod;
    private TextView oSatiPredavanja;
    private TextView oSatiLva;
    private Button oSumButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_summary);

        final Bundle oExtras = getIntent().getExtras();
        ime = oExtras.getString("ime");
        prezime = oExtras.getString("prezime");
        datum = oExtras.getString("datum");
        predmet = oExtras.getString("predmet");
        profesor = oExtras.getString("profesor");
        akGod = oExtras.getString("akGod");
        satiPredavanja = oExtras.getString("satiPredavanja");
        satiLva = oExtras.getString("satiLva");

        oIme = (TextView)findViewById(R.id.labelIme);
        oPrezime = (TextView)findViewById(R.id.labelPrezime);
        oDatum = (TextView)findViewById(R.id.labelDatum);
        oPredmet = (TextView)findViewById(R.id.labelPredmet);
        oProfesor = (TextView)findViewById(R.id.labelProfesor);
        oAkGod = (TextView)findViewById(R.id.labelAkGod);
        oSatiPredavanja = (TextView)findViewById(R.id.labelSatiPredavanja);
        oSatiLva = (TextView)findViewById(R.id.labelSatiLv);
        oSumButton = (Button)findViewById(R.id.summaryButton);

        oIme.setText(ime);
        oPrezime.setText(prezime);
        oDatum.setText(datum);
        oPredmet.setText(predmet);
        oProfesor.setText(profesor);
        oAkGod.setText(akGod);
        oSatiPredavanja.setText(satiPredavanja);
        oSatiLva.setText(satiLva);

        oSumButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent a = new Intent(getApplicationContext(), PersonalInfoActivity.class);
                a.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                startActivity(a);
            }
        });
    }
}