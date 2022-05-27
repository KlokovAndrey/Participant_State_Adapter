package com.avaya.ccaas.participant_state_adapter.service;

import org.springframework.stereotype.Service;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

@Service
public class RunAsyncService {

    private ExecutorService executorService = Executors.newCachedThreadPool();

    public void run(Runnable runnable){
        CompletableFuture.runAsync(runnable, executorService);
    }
}
