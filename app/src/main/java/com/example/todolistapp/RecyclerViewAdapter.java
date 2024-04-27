package com.example.todolistapp;

import android.annotation.SuppressLint;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;


public class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerViewAdapter.ItemViewHolder> {

    private List<TaskEntity> itemList;


    public RecyclerViewAdapter(List<TaskEntity> itemList) {
        this.itemList = itemList;
    }
    // Custom method to set the list of items
    public void setItemList(List<TaskEntity> itemList) {
        this.itemList = itemList;
    }

    @NonNull
    @Override
    public ItemViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.item_view,parent,false);
        return new ItemViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ItemViewHolder holder, int position) {
        TaskEntity currentTask=itemList.get(position);
        holder.taskTitle.setText(currentTask.getTaskName());
        holder.taskDate.setText(currentTask.getTaskDate());

        holder.deleatItem.setOnClickListener(v -> {
            itemList.remove(position);
            notifyItemRemoved(position);
        });

    }

    @Override
    public int getItemCount() {
        return itemList.size();
    }

    public static class ItemViewHolder extends RecyclerView.ViewHolder{
        TextView taskTitle, taskDate;
        ImageButton deleatItem;
        public ItemViewHolder(@NonNull View itemView) {
            super(itemView);
            taskTitle=itemView.findViewById(R.id.taskTitle);
            taskDate=itemView.findViewById(R.id.taskDate);
            deleatItem=itemView.findViewById(R.id.deleatItem);
        }
    }
}

