package com.servlet3.service;

import java.util.Date;

import javax.servlet.AsyncContext;

public class AsyncWebService implements Runnable {

    private AsyncContext asyncContext;

    public AsyncWebService(AsyncContext asyncContext) {
        this.asyncContext = asyncContext;
    }

    @Override
    public void run() {
        Date date = new Date();
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        asyncContext.dispatch("/servlet2?date=" + date);
    }

}
