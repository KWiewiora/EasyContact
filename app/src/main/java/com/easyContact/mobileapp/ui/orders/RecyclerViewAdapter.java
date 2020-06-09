package com.easyContact.mobileapp.ui.orders;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.easyContact.mobileapp.R;
import com.easyContact.mobileapp.data.servicesModel.AuthResponse;

import java.util.List;

public class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerViewAdapter.ViewHolder> {

    private List<AuthResponse.Orders> orders;
    private String userType;
    private OnItemClickListener itemClickListener;

    RecyclerViewAdapter(List<AuthResponse.Orders> orders, String userType, OnItemClickListener itemClickListener) {
        this.orders = orders;
        this.userType = userType;
        this.itemClickListener = itemClickListener;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.orders_list_item, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.name.setText(orders.get(position).getWare());
        holder.quantity.setText(orders.get(position).getQuantity());
        holder.warehouseFrom.setText(orders.get(position).getWareFromName());
        holder.warehouseTo.setText(orders.get(position).getWareToName());
        holder.principal.setText(orders.get(position).getPrincipalName());
        holder.executionDate.setText(orders.get(position).getDeliveryDate());
        holder.executor.setText(orders.get(position).getExecutorName());
        setupCancelButton(holder.cancelButton, position);
        setupAssignButton(holder.assignMeButton, position);
        holder.bind(itemClickListener, position);
    }

    private void setupCancelButton(TextView cancelButton, int position) {
        if (orders.get(position).getExecutorName().equals("Nie znaleziono") && userType.equals("PRINCIPAL"))
            cancelButton.setVisibility(View.VISIBLE);
    }

    private void setupAssignButton(TextView assignMeButton, int position) {
        if (orders.get(position).getExecutorName().equals("Nie znaleziono") && userType.equals("SUPPLY"))
            assignMeButton.setVisibility(View.VISIBLE);
        else assignMeButton.setVisibility(View.GONE);
    }

    @Override
    public int getItemCount() {
        return orders.size();
    }

    class ViewHolder extends RecyclerView.ViewHolder {
        TextView name;
        TextView quantity;
        TextView warehouseFrom;
        TextView warehouseTo;
        TextView principal;
        TextView executionDate;
        TextView executor;
        TextView cancelButton;
        TextView assignMeButton;

        ViewHolder(View itemView) {
            super(itemView);
            name = itemView.findViewById(R.id.wareTxt);
            quantity = itemView.findViewById(R.id.quantityTxt);
            warehouseFrom = itemView.findViewById(R.id.wareFromTxt);
            warehouseTo = itemView.findViewById(R.id.wareToTxt);
            principal = itemView.findViewById(R.id.principalTxt);
            executionDate = itemView.findViewById(R.id.executionDateTxt);
            executor = itemView.findViewById(R.id.executorTxt);
            cancelButton = itemView.findViewById(R.id.cancelButton);
            assignMeButton = itemView.findViewById(R.id.assignMeButton);
        }

        private void bind(OnItemClickListener onItemClickListener, int position) {
            cancelButton.setOnClickListener(view -> onItemClickListener.onCancelButtonClicked(orders.get(position), position));
            assignMeButton.setOnClickListener(view -> onItemClickListener.onAssignMeButtonClicked(orders.get(position), position));
        }
    }

    interface OnItemClickListener {
        void onCancelButtonClicked(AuthResponse.Orders orders, int positon);
        void onAssignMeButtonClicked(AuthResponse.Orders orders, int positon);
    }

}
