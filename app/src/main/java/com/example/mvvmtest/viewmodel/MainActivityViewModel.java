package com.example.mvvmtest.viewmodel;

import android.os.AsyncTask;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;
import com.example.mvvmtest.MainApplication;
import com.example.mvvmtest.repositories.ValueRepository;

import java.util.List;

public class MainActivityViewModel extends ViewModel {
    private ValueRepository mRepo;
    private MutableLiveData<List<Integer>> mValues;
    private MutableLiveData<Boolean> mUpDating = new MutableLiveData<>();

    public void init(){
        if(mValues != null){
            return;
        }
        mRepo=ValueRepository.getInstance();
        mValues=mRepo.getValues();
    }

    public void addNewValue(final Integer value){
        mUpDating.setValue(false);
        new AsyncTask<Void,Void,Void>(){
            @Override
            protected void onPostExecute(Void unused) {
                super.onPostExecute(unused);
                List<Integer> currentValues=mValues.getValue();
                currentValues.add(value);
                mValues.postValue(currentValues);
                mUpDating.postValue(true);
            }

            @Override
            protected Void doInBackground(Void... voids) {
                return null;
            }
        }.execute();
    }

    public LiveData<List<Integer>> getValues(){
        return mValues;
    }

    public LiveData<Boolean> getIsUpDating(){
        return mUpDating;
    }
}