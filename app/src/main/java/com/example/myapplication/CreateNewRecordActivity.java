package com.example.myapplication;


import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;
import androidx.fragment.app.FragmentTransaction;
import androidx.viewpager.widget.ViewPager;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentPagerAdapter;
import androidx.viewpager.widget.ViewPager;

import android.os.Bundle;

import com.example.myapplication.PersonalInfoFragment;
import com.example.myapplication.R;
import com.example.myapplication.StudentInfoFragment;
import com.example.myapplication.SummaryFragment;
import com.example.myapplication.MyAdapter;

import android.os.Bundle;

public class CreateNewRecordActivity extends AppCompatActivity implements PersonalInfoFragment.PersonalInfoListener, StudentInfoFragment.StudentInfoListener {

    public static ViewPager viewPager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_new_record);

        viewPager = findViewById(R.id.vpPager);
        viewPager.setOffscreenPageLimit(2);

        MyAdapter viewPagerAdapter = new MyAdapter(getSupportFragmentManager());
        viewPager.setAdapter(viewPagerAdapter);
    }

    @Override
    public void onPersonalInfoSent(String ime, String prezime, String datum) {
        String tag = "android:switcher:" + R.id.vpPager + ":" + 2;
        SummaryFragment fragment = (SummaryFragment) getSupportFragmentManager().findFragmentByTag(tag);
        fragment.updatePersonalInfo(ime, prezime, datum);
    }

    @Override
    public void onStudentInfoSent(String predmet, String ime_profesora, String akademska_godina, String sati_predavanja, String sati_LV) {
        String tag = "android:switcher:" + R.id.vpPager + ":" + 2;
        SummaryFragment fragment = (SummaryFragment) getSupportFragmentManager().findFragmentByTag(tag);
        fragment.updateStudentInfo(predmet, ime_profesora, akademska_godina, sati_predavanja, sati_LV);
    }

    public static void setCurrentItem (int item, boolean smoothScroll) {
        viewPager.setCurrentItem(item, smoothScroll);
    }
}

