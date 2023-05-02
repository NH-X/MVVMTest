package com.example.mvvmtest.viewmodel;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;
import com.example.mvvmtest.repositories.ValueRepository;
import com.example.mvvmtest.tasks.AddNewValueTask;

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

    public void addNewValue(){
        mUpDating.setValue(false);
        AddNewValueTask task=new AddNewValueTask();
        task.setValues(mValues);
        task.setUpDating(mUpDating);
        task.execute();
    }

    public LiveData<List<Integer>> getValues(){
        return mValues;
    }

    public LiveData<Boolean> getIsUpDating(){
        return mUpDating;
    }
}