package com.easyContact.mobileapp.data.repository;

public class Resource<T> {

    public boolean isSuccessfull() {
        return isSuccessfull;
    }

    public T getResponse() {
        return response;
    }

    public void setResponse(T response) {
        this.response = response;
    }

    private T response;

    public void setSuccessfull(boolean successfull) {
        isSuccessfull = successfull;
    }

    private boolean isSuccessfull;
}