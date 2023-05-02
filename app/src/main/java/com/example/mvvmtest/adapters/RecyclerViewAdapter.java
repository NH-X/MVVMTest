package com.example.mvvmtest.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import com.example.mvvmtest.R;
import org.jetbrains.annotations.NotNull;

import java.util.List;

public class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    private Context context;
    private List<Integer> values;

    public RecyclerViewAdapter(Context context, List<Integer> values){
        this.context=context;
        this.values=values;
    }

    @NonNull
    @NotNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull @NotNull ViewGroup parent, int viewType) {
        View v= LayoutInflater.from(context).inflate(R.layout.item_value_detail,parent,false);
        return new ItemHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull @NotNull RecyclerView.ViewHolder holder, int position) {
        ItemHolder itemHolder= (ItemHolder) holder;
        itemHolder.tv_value.setText(values.get(position)+"");
        itemHolder.ll_item.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {
                return true;
            }
        });
    }

    @Override
    public int getItemCount() {
        return values.size();
    }

    private class ItemHolder extends RecyclerView.ViewHolder{
        private LinearLayout ll_item;
        public TextView tv_value;

        public ItemHolder(@NonNull @NotNull View itemView) {
            super(itemView);
            ll_item=itemView.findViewById(R.id.ll_item);
            tv_value=itemView.findViewById(R.id.tv_value);
        }
    }
}
