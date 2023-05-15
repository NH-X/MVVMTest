package com.example.mvvmtest.repositories;

import androidx.lifecycle.MutableLiveData;

import com.example.mvvmtest.tasks.AddNewValueTask;

import java.util.ArrayList;
import java.util.List;

public class ValueRepository {
    private static ValueRepository instance;
    private List<Integer> dataSet = new ArrayList<>();
    private MutableLiveData<List<Integer>> data = new MutableLiveData<>();

    public static ValueRepository getInstance() {
        if (null == instance) {
            instance = new ValueRepository();
        }
        return instance;
    }

    public MutableLiveData<List<Integer>> getValues() {
        data=new MutableLiveData<>();
        data.setValue(dataSet);

        return data;
    }

    public void startRequest(MutableLiveData<Boolean> isUpDating){
        isUpDating.setValue(false);

        AddNewValueTask task=new AddNewValueTask();
        task.setUpDating(isUpDating);
        task.execute(data);
    }
}