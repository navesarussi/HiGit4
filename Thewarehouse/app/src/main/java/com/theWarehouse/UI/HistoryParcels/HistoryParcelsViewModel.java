package com.theWarehouse.UI.HistoryParcels;

import android.app.Application;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.MutableLiveData;
import com.theWarehouse.Data.ParcelRepository;
import com.theWarehouse.Entities.Parcel;

import java.util.ArrayList;


public class HistoryParcelsViewModel extends AndroidViewModel {
    ParcelRepository parcelRepository=new ParcelRepository(getApplication());

    public HistoryParcelsViewModel(Application application) {
        super(application);
    }

    public MutableLiveData<ArrayList<Parcel>> getAllParcelsThat()
    {
       return parcelRepository.getAllParcelsThat();
    }
}
