package com.isuru.hettiarachchi.mad_a1;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ImageButton;
import android.widget.Spinner;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import com.isuru.hettiarachchi.mad_a1.fragments.CalendarFragment;
import com.isuru.hettiarachchi.mad_a1.fragments.ClockFragment;
import com.isuru.hettiarachchi.mad_a1.fragments.HomeFragment;
import com.isuru.hettiarachchi.mad_a1.fragments.SettingsFragment;


public class DashboardActivity extends AppCompatActivity {
    ImageButton homeBtn, clockBtn, calendarBtn, settingsBtn;
    ImageButton selectedButton = null;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_dashboard);
        homeBtn = findViewById(R.id.navHome);
        clockBtn = findViewById(R.id.navClock);
        calendarBtn = findViewById(R.id.navCalender);
        settingsBtn = findViewById(R.id.navSettings);
        Spinner spinner = findViewById(R.id.spinner);

        String[] technologies = {
                "Information and Communication Technology",
                "Engineering Technology",
                "Biosystem Technology"
        };

        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_item,technologies);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(adapter);



        // Load Home Fragment by default
        loadFragment(new HomeFragment(),homeBtn);

        homeBtn.setOnClickListener(view -> loadFragment(new HomeFragment(),homeBtn));
        clockBtn.setOnClickListener(view -> loadFragment(new ClockFragment(),clockBtn));
        calendarBtn.setOnClickListener(view -> loadFragment(new CalendarFragment(),calendarBtn));
        settingsBtn.setOnClickListener(view -> loadFragment(new SettingsFragment(),settingsBtn));
    }

    private void loadFragment(Fragment fragment,ImageButton clickedButton) {
        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction transaction = fragmentManager.beginTransaction();
        transaction.replace(R.id.fragmentContainer, fragment);
        transaction.commit();

        if(selectedButton != null){
            selectedButton.setSelected(false);

        }

        clickedButton.setSelected(true);
        selectedButton = clickedButton;

    }
}