package com.example.accountbook.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.afollestad.materialdialogs.MaterialDialog;
import com.example.accountbook.R;
import com.example.accountbook.bean.BBill;
import com.example.accountbook.utils.DateUtils;
import com.example.accountbook.utils.ImageUtils;

import me.drakeet.multitype.ItemViewBinder;

import static com.example.accountbook.utils.DateUtils.FORMAT_HMS_CN;
import static com.example.accountbook.utils.DateUtils.FORMAT_YMD_CN;


public class MonthChartBillViewBinder extends ItemViewBinder<BBill, MonthChartBillViewBinder.ViewHolder> {

    private Context mContext;

    public MonthChartBillViewBinder(Context context){
        this.mContext=context;
    }

    @NonNull
    @Override
    protected ViewHolder onCreateViewHolder(@NonNull LayoutInflater inflater, @NonNull ViewGroup parent) {
        View root = inflater.inflate(R.layout.item_recycler_monthchart_rank, parent, false);
        return new ViewHolder(root);
    }

    @Override
    protected void onBindViewHolder(@NonNull ViewHolder holder, @NonNull BBill item) {

        holder.rank.setText(holder.getAdapterPosition() + 1 + "");
        holder.title.setText(item.getSortName());
        if (item.isIncome())
            holder.money.setText("+" + item.getCost());
        else
            holder.money.setText("-" + item.getCost());
        holder.root.setOnClickListener(v -> {
            new MaterialDialog.Builder(mContext)
                    .title(item.getSortName())
                    .content("\t\t" + Math.abs(item.getCost()) + "元\n\t\t" + item.getContent()
                            +"\n\n\t\t"+DateUtils.long2Str(item.getCrdate(), FORMAT_YMD_CN)
                            +"\n\t\t"+DateUtils.long2Str(item.getCrdate(), FORMAT_HMS_CN))
                    .positiveText("ok")
                    .icon(ImageUtils.getDrawable(item.getSortImg()))
                    .limitIconToDefaultSize()
                    .show();
        });
    }

    static class ViewHolder extends RecyclerView.ViewHolder {

        private View root;
        private TextView title;
        private TextView money;
        private TextView rank;

        public ViewHolder(View view) {
            super(view);
            root = view;
            title = view.findViewById(R.id.title);
            money = view.findViewById(R.id.money);
            rank = view.findViewById(R.id.rank);
        }
    }
}
