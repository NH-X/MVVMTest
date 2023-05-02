package com.example.mvvmtest.repositories;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import java.util.ArrayList;
import java.util.List;

public class ValueRepository {
    private static ValueRepository instance;
    private List<Integer> dataSet = new ArrayList<>();

    public static ValueRepository getInstance() {
        if (null == instance) {
            instance = new ValueRepository();
        }
        return instance;
    }

    public MutableLiveData<List<Integer>> getValues() {
        MutableLiveData<List<Integer>> data=new MutableLiveData<>();
        data.setValue(dataSet);

        return data;
    }
}