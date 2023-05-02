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
        return null;
    }

    @Override
    protected void onPostExecute(Void unused) {
        super.onPostExecute(unused);
        List<Integer> currentValues=mValues.getValue();
        currentValues.add(MainApplication.getInstance().getIndex());
        mValues.postValue(currentValues);
        mUpDating.postValue(true);
    }

    public void setValues(MutableLiveData<List<Integer>> values){
        mValues=values;
    }

    public void setUpDating(MutableLiveData<Boolean> upDating){
        mUpDating=upDating;
    }
}
