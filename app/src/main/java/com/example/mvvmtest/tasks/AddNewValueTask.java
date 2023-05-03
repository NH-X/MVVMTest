package com.example.mvvmtest.tasks;

import android.os.AsyncTask;
import androidx.lifecycle.MutableLiveData;
import com.example.mvvmtest.MainApplication;

import java.util.List;

public class AddNewValueTask extends AsyncTask<MutableLiveData<List<Integer>>,Void,Void> {
    private MutableLiveData<List<Integer>> mValues;
    private MutableLiveData<Boolean> mUpDating;

    @Override
    protected Void doInBackground(MutableLiveData<List<Integer>>... mutableLiveData) {
        mValues=mutableLiveData[0];
        List<Integer> currentValues=mValues.getValue();
        currentValues.add(MainApplication.getInstance().getIndex());
        mValues.postValue(currentValues);
        mUpDating.postValue(true);

        return null;
    }

    @Override
    protected void onPostExecute(Void unused) {
        super.onPostExecute(unused);
    }

    public void setUpDating(MutableLiveData<Boolean> upDating){
        mUpDating=upDating;
    }
}
