package com.example.attempt;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.MutableLiveData;

import android.location.Location;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.RadioGroup;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.EnumSet;
import java.util.List;

public class AddParcelActivity extends AppCompatActivity {
    MutableLiveData<List<Parcel>> planetsList = new MutableLiveData<>();
    static ArrayList<Parcel> planetsList1 = new ArrayList<>();
    static int ID=0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_parcel);
    }

    public MutableLiveData<List<Parcel>> get() {
        return planetsList;
    }

    public void Add(View view) {
        int parcelType;
        int breakable;
        int weight;
        String toName;
        String toLocation;
        final String toPhoneNumber;
        String toMail;
        parcelType = ((RadioGroup) findViewById(R.id.ParcelType)).indexOfChild(findViewById(((RadioGroup) findViewById(R.id.ParcelType)).getCheckedRadioButtonId()));
        breakable = ((RadioGroup) findViewById(R.id.Breakable)).indexOfChild(findViewById(((RadioGroup) findViewById(R.id.Breakable)).getCheckedRadioButtonId()));
        weight = ((RadioGroup) findViewById(R.id.Weight)).indexOfChild(findViewById(((RadioGroup) findViewById(R.id.Weight)).getCheckedRadioButtonId()));
        toName = ((EditText) findViewById(R.id.ToName)).getText().toString();
        toLocation = ((EditText) findViewById(R.id.ToLocation)).getText().toString();
        toPhoneNumber = ((EditText) findViewById(R.id.PhoneNumber)).getText().toString();
        toMail = ((EditText) findViewById(R.id.ToMail)).getText().toString();

        final String storageLocation = "WarehouseLocation";
        final String idStorage = "WarehouseID";
        Date dateNow = new Date();
        SimpleDateFormat dt1 = new SimpleDateFormat("yyyy-MM-dd");
        dt1.set2DigitYearStart(dateNow);

        Parcel parcel = new Parcel(Enumes.ParcelType.ENVELOPE, false, Enumes.Weight.UKG, storageLocation, toName, new Location("fg"), toPhoneNumber, toMail, dt1, dt1, Enumes.ParcelStatus.RECIVED, "sdf", idStorage);
        parcel.setID(++ID);
        planetsList1.add(parcel);
        planetsList.postValue(planetsList1);
        finish();
    }
}
