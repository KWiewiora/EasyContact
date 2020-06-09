package com.easyContact.mobileapp.data.repository;

import androidx.lifecycle.MutableLiveData;

import org.jetbrains.annotations.NotNull;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

class BaseRepository<T> {

    MutableLiveData<Resource<T>> getData(Call<T> data) {
        final MutableLiveData<Resource<T>> resourceMutableLiveData = new MutableLiveData<>();
        data.enqueue(new Callback<T>() {
            @Override
            public void onResponse(Call<T> call, @NotNull Response<T> response) {
                if (response.isSuccessful()) {
                    Resource<T> resource = new Resource<T>();
                    resource.setSuccessfull(true);
                    resource.setResponse(response.body());
                    resourceMutableLiveData.setValue(resource);
                }
            }

            @Override
            public void onFailure(@NotNull Call<T> call, Throwable t) {
                Resource<T> resource = new Resource<T>();
                resource.setSuccessfull(false);
                resourceMutableLiveData.setValue(resource);
            }
        });
        return resourceMutableLiveData;
    }
}