package com.example.DiscordBotOnline;

import com.example.DiscordBotOnline.Listeners.PingListener;
import com.example.DiscordBotOnline.Listeners.RateListener;
import org.javacord.api.DiscordApi;
import org.javacord.api.DiscordApiBuilder;
import org.javacord.api.entity.intent.Intent;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.core.env.Environment;

@SpringBootApplication
public class DiscordBotOnline {
    @Autowired
    private Environment env;

    @Autowired
    private PingListener pingListener;

    @Autowired
    private RateListener rateListener;

    public static void main(String[] args) {
        SpringApplication.run(DiscordBotOnline.class, args);
    }


    @Bean
    @ConfigurationProperties(value = "discord-api")

    public DiscordApi discordApi(){
        String token = env.getProperty("Token");
        DiscordApi api = new DiscordApiBuilder().setToken(token)
                //.setAllNonPrivilegedIntents()
                .addIntents(Intent.MESSAGE_CONTENT)

                .login()
                .join();

        api.addMessageCreateListener(pingListener);
        api.addMessageCreateListener(rateListener);
        return api;
    }


}


