package com.avaya.ccaas.participant_state_adapter;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableAsync;

@EnableAsync
@SpringBootApplication
public class ParticipantStateAdapterApplication {

    public static void main(String[] args) {
        SpringApplication.run(ParticipantStateAdapterApplication.class, args);
    }

}
