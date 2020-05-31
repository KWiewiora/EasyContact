package com.easyContact.mobileapp.ui.user;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.easyContact.mobileapp.R;
import com.easyContact.mobileapp.data.servicesModel.AuthResponse;
import com.easyContact.mobileapp.ui.main.MainActivity;


public class UserFragment extends Fragment {

    TextView name;
    TextView email;
    TextView address;
    TextView phone;

    AuthResponse.UserInfo userInfo;

    public UserFragment() {
        // Required empty public constructor
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        setupContent();
        setupViews(view);

    }

    private void setupContent() {
        userInfo = ((MainActivity)requireActivity()).authResponse.getUserInfo();
    }

    private void setupViews(View view) {
        email = view.findViewById(R.id.emailTxt);
        name = view.findViewById(R.id.nameTxt);
        address = view.findViewById(R.id.addressTxt);
        phone = view.findViewById(R.id.phoneTxt);

        email.setText(userInfo.getEmail());
        name.setText(userInfo.getName());
        address.setText(userInfo.getAddress());
        phone.setText(userInfo.getPhoneNumber());
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_user, container, false);
    }
}
