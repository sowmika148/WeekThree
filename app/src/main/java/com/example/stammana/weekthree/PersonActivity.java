package com.example.stammana.weekthree;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import com.example.stammana.weekthree.model.Person;

public class PersonActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_person);
        Intent intent = getIntent();
        Person person = ((Person)intent.getSerializableExtra("person"));
        ((TextView) findViewById(R.id.personNameDetail))
                .setText(person.getFirstName().toUpperCase());
        ((TextView) findViewById(R.id.personLastNameDetail))
                .setText(person.getLastName().toUpperCase());
        ((TextView) findViewById(R.id.personGenderDetail))
                .setText(person.getGender().toUpperCase());
        ((TextView) findViewById(R.id.personAgeDetail))
                .setText(person.getAge().toUpperCase());
    }
}
