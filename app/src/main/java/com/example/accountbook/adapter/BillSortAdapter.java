package com.example.accountbook.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import com.example.accountbook.R;
import com.example.accountbook.bean.BSort;
import com.example.accountbook.utils.ImageUtils;

import java.util.List;

public class BillSortAdapter extends RecyclerView.Adapter<BillSortAdapter.MyItemViewHolder> {

    private Context mContext;
    private List<BSort> mData;

    public BillSortAdapter(Context mContext, List<BSort> mData) {
        this.mContext = mContext;
        this.mData = mData;
    }

    public void setItems(List<BSort> items){
        this.mData=items;
    }

    @Override
    public MyItemViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(mContext).inflate(R.layout.item_recycler_note_sort, parent, false);
        return new MyItemViewHolder(view);
    }

    @Override
    public void onBindViewHolder(MyItemViewHolder holder, int position) {
        holder.item_name.setText(mData.get(position).getSortName());
        holder.item_img.setImageDrawable(ImageUtils.getDrawable(mData.get(position).getSortImg()));
    }

    @Override
    public int getItemCount() {
        if (mData == null)
            return 0;
        return mData.size();
    }

    public static class MyItemViewHolder extends RecyclerView.ViewHolder {
        TextView item_name;
        ImageView item_img;

        MyItemViewHolder(View view) {
            super(view);
            item_img = view.findViewById(R.id.item_note_edit_iv);
            item_name = view.findViewById(R.id.item_note_edit_tv);
        }
    }
}
