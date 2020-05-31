package com.easyContact.mobileapp.data.repository;

import androidx.lifecycle.MutableLiveData;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

class BaseRepository {

    class Repository<T> {
        MutableLiveData<T> getData(Call<T> data) {
            final MutableLiveData<T> mutableLiveData = new MutableLiveData<>();
            data.enqueue(new Callback<T>() {
                @Override
                public void onResponse(Call<T> call,
                                       Response<T> response) {
                    if (response.isSuccessful()) {
                        mutableLiveData.setValue(response.body());
                    }
                }

                @Override
                public void onFailure(Call<T> call, Throwable t) {
                    mutableLiveData.setValue(null);
                }
            });
            return mutableLiveData;
        }
    }

}