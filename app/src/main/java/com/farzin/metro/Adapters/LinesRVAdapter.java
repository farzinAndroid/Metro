package com.farzin.metro.Adapters;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.graphics.Typeface;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.farzin.metro.Activities.StationListActivity;
import com.farzin.metro.R;
import com.farzin.metro.Utils.Constants;
import com.farzin.metro.databinding.LineRvLayoutBinding;
import com.farzin.metro.databinding.LineRvLayoutBinding;
import com.farzin.metro.databinding.StationsRvLayoutBinding;
import com.farzin.metro.model.Lines;

import java.util.List;

public class LinesRVAdapter extends RecyclerView.Adapter<LinesRVAdapter.MyViewHolder> {

    private List<Lines> lines;
    private Context context;

    public LinesRVAdapter(List<Lines> lines, Context context) {
        this.lines = lines;
        this.context = context;
    }

    //define layout
    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        LayoutInflater layoutInflater = LayoutInflater.from(context);
        LineRvLayoutBinding rvLayoutBinding = LineRvLayoutBinding.inflate(layoutInflater,parent,false);
        return new MyViewHolder(rvLayoutBinding);
    }


    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {

        holder.rvLayoutBinding.titlePersian.setText(lines.get(position).getTitle());
        holder.rvLayoutBinding.titleEnglish.setText(lines.get(position).getEnglishTitle());

        if (position == 0){
            holder.rvLayoutBinding.parent.setBackgroundColor(context.getResources().getColor(R.color.red));
        }
        else if (position == 1){
            holder.rvLayoutBinding.parent.setBackgroundColor(context.getResources().getColor(R.color.blue));
        }
        else if (position == 2){
            holder.rvLayoutBinding.parent.setBackgroundColor(context.getResources().getColor(R.color.lowBlue));
        }
        else if (position == 3){
            holder.rvLayoutBinding.parent.setBackgroundColor(context.getResources().getColor(R.color.yellow));
        }
        else if (position == 4){
            holder.rvLayoutBinding.parent.setBackgroundColor(context.getResources().getColor(R.color.green));
        }
        else if (position == 5){
            holder.rvLayoutBinding.parent.setBackgroundColor(context.getResources().getColor(R.color.purple));
        }

        holder.rvLayoutBinding.parent.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(context, StationListActivity.class);
                intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                intent.putExtra("id",lines.get(holder.getAdapterPosition()).getId());
                intent.putExtra("title_persian",lines.get(holder.getAdapterPosition()).getTitle());
                intent.putExtra("title_english",lines.get(holder.getAdapterPosition()).getEnglishTitle());
                context.startActivity(intent);
            }
        });

    }


    //array size
    @Override
    public int getItemCount() {
        return lines.size();
    }

    //first step
    class MyViewHolder extends RecyclerView.ViewHolder{

        LineRvLayoutBinding rvLayoutBinding;

        public MyViewHolder(@NonNull LineRvLayoutBinding rvLayoutBinding){
            super(rvLayoutBinding.getRoot());
            this.rvLayoutBinding = rvLayoutBinding;
        }


    }
}
