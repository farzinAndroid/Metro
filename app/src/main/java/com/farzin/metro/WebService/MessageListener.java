package com.farzin.metro.WebService;

public interface MessageListener<T> {

    public void onSuccess(T responseMessage);
    public void onError(String errorMessage);
}
