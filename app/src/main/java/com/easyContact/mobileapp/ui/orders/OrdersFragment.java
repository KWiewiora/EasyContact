package com.easyContact.mobileapp.ui.orders;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.easyContact.mobileapp.R;
import com.easyContact.mobileapp.data.servicesModel.AuthResponse;
import com.easyContact.mobileapp.ui.main.MainActivity;
import com.easyContact.mobileapp.ui.orders.deleteOrder.EditOrdersViewModel;

import java.util.List;

public class OrdersFragment extends Fragment implements RecyclerViewAdapter.OnItemClickListener {

    List<AuthResponse.Orders> orders;
    AuthResponse.UserInfo userInfo;
    private EditOrdersViewModel editOrdersViewModel;
    private TextView noOrdersTxt;

    RecyclerView recyclerView;
    RecyclerViewAdapter recyclerViewAdapter;

    public OrdersFragment() {
        // Required empty public constructor
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        setupData();
        setupViews(view);
        editOrdersViewModel = new ViewModelProvider(this).get(EditOrdersViewModel.class);
    }

    private void setupData() {
        orders = ((MainActivity) requireActivity()).authResponse.getOrders();
        userInfo = ((MainActivity) requireActivity()).authResponse.getUserInfo();
    }

    private void setupViews(View view) {
        setupRecycler(view);
        setNoOrdersTxt(orders.isEmpty());
    }

    private void setupRecycler(View view) {
        recyclerView = view.findViewById(R.id.recyclerView);
        recyclerViewAdapter = new RecyclerViewAdapter(orders, userInfo.getUserType(), this);
        recyclerView.setAdapter(recyclerViewAdapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        noOrdersTxt = view.findViewById(R.id.noOrdersTxt);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_orders, container, false);
    }

    @Override
    public void onCancelButtonClicked(AuthResponse.Orders order, int position) {
        editOrdersViewModel.deleteOrder(userInfo.getEmail(), order.getId()).observe(getViewLifecycleOwner(), authResponseResource -> deleteItemFromRecycler(authResponseResource.getResponse().getOrders(), position));
    }

    @Override
    public void onAssignMeButtonClicked(AuthResponse.Orders order, int position) {
        editOrdersViewModel.updateOrder(order.getId(), userInfo.getId(), userInfo.getEmail()).observe(getViewLifecycleOwner(), authResponseResource -> updateItemFromRecycler(authResponseResource.getResponse().getOrders(), position));
    }

    private void deleteItemFromRecycler(List<AuthResponse.Orders> orders, int position) {
        this.orders.remove(position);
        recyclerView.removeViewAt(position);
        recyclerViewAdapter.notifyItemRemoved(position);
        recyclerViewAdapter.notifyItemRangeChanged(position, orders.size());
        recyclerViewAdapter.notifyDataSetChanged();
        setNoOrdersTxt(orders.isEmpty());
    }

    private void updateItemFromRecycler(List<AuthResponse.Orders> updatedOrders, int position) {
        this.orders.set(position, updatedOrders.get(position));
        recyclerViewAdapter.notifyItemChanged(position);
        setNoOrdersTxt(this.orders.isEmpty());
    }

    private void setNoOrdersTxt(boolean isListEmpty) {
        if (isListEmpty) {
            noOrdersTxt.setVisibility(View.VISIBLE);
        }
    }
}
