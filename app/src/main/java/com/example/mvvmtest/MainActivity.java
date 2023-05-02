package com.example.mvvmtest;

import android.view.View;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.example.mvvmtest.adapters.RecyclerViewAdapter;
import com.example.mvvmtest.viewmodel.MainActivityViewModel;

import java.util.List;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    private static final String TAG = "MainActivity";

    private RecyclerView rv_values;

    private MainApplication myApp;
    private MainActivityViewModel mMainActivityViewModel;
    private RecyclerViewAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        myApp=MainApplication.getInstance();
        findViewById(R.id.fab_add).setOnClickListener(this);

        mMainActivityViewModel = new ViewModelProvider(this).get(MainActivityViewModel.class);
        mMainActivityViewModel.init();
        mMainActivityViewModel.getValues().observe(this, new Observer<List<Integer>>() {
            @Override
            public void onChanged(List<Integer> integers) {
                adapter.notifyDataSetChanged();
            }
        });

        mMainActivityViewModel.getIsUpDating().observe(this, new Observer<Boolean>() {
            @Override
            public void onChanged(Boolean aBoolean) {
                if(aBoolean){
                    rv_values.smoothScrollToPosition(mMainActivityViewModel.getValues().getValue().size()-1);
                }
            }
        });
        initRecycleView();
    }

    private void initRecycleView() {
        rv_values=findViewById(R.id.rv_values);
        adapter=new RecyclerViewAdapter(this,mMainActivityViewModel.getValues().getValue());
        RecyclerView.LayoutManager manager=new LinearLayoutManager(this);
        rv_values.setLayoutManager(manager);
        rv_values.setAdapter(adapter);
    }

    @Override
    public void onClick(View v) {
        if(v.getId()==R.id.fab_add){
            int index=myApp.getIndex();
            Toast.makeText(this, ""+index, Toast.LENGTH_SHORT).show();
            mMainActivityViewModel.addNewValue(index);
        }
    }
}