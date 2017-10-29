package com.innovative.foodciti.adapter;

import android.app.Activity;
import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.innovative.foodciti.R;
import com.innovative.foodciti.models.Items;
import com.innovative.foodciti.models.OrderSummary;

import java.util.List;

/**
 * Created by pulkit on 29/8/17.
 */

public class OrderSummaryAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    private List<Items> itemsList;
    private Activity context;

    public OrderSummaryAdapter(Activity context, List<Items> itemsList) {
        this.itemsList = itemsList;
        this.context = context;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new OrderSummaryHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.adapter_ordered_items, parent, false));
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        OrderSummaryHolder summaryHolder = (OrderSummaryHolder) holder;

        summaryHolder.tvItemName.setText(itemsList.get(position).getItem());
        summaryHolder.tvItemPrice.setText(itemsList.get(position).getPrice());

        for (int i = 0; i < itemsList.get(position).getSubitem().size(); i++) {
            View view = context.getLayoutInflater().inflate(R.layout.activity_subitems, null);
            TextView tvSubitemName = (TextView) view.findViewById(R.id.tv_subitem_name);
            TextView tvSubitemPrice = (TextView) view.findViewById(R.id.tv_subitem_price);

            tvSubitemName.setText(itemsList.get(position).getSubitem().get(i).getSubitem());
            tvSubitemPrice.setText(itemsList.get(position).getSubitem().get(i).getPrice());
            ((OrderSummaryHolder) holder).subitemContainer.addView(view);
        }
    }

    @Override
    public int getItemCount() {
        return itemsList.size();
    }

    private class OrderSummaryHolder extends RecyclerView.ViewHolder {

        TextView tvItemName, tvItemPrice;
        LinearLayout subitemContainer;

        private OrderSummaryHolder(View itemView) {
            super(itemView);

            tvItemName = (TextView) itemView.findViewById(R.id.tv_item_name);
            tvItemPrice = (TextView) itemView.findViewById(R.id.tv_item_price);
            subitemContainer = (LinearLayout) itemView.findViewById(R.id.subitem_container);
        }

    }

}
