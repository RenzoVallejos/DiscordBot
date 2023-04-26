package com.example.DiscordBotOnline.Listeners.impl;

import com.example.DiscordBotOnline.Listeners.RateListener;
import org.javacord.api.event.message.MessageCreateEvent;
import org.springframework.stereotype.Component;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

@Component
public class RateListenerImpl implements RateListener {
    private final static Pattern pattern = Pattern.compile("!rate (\\w+)");
    @Override
    public void onMessageCreate(MessageCreateEvent messageCreateEvent) {
        if(messageCreateEvent.getMessageContent().startsWith("!rate")){
            Matcher matcher = pattern.matcher(messageCreateEvent.getMessageContent());
            if(matcher.matches()){
                int rating = (int) Math.floor(Math.random()*100+1);
                messageCreateEvent.getChannel().sendMessage(
                        messageCreateEvent.getMessageAuthor().getDisplayName() + " is " + rating + "% " + matcher.group(1)
                );

            }
            else{
                //send helpful message
                messageCreateEvent.getChannel().sendMessage("Are you trying to use the !rate command? Please use the syntax '!rate [word]'. Thanks!");
            }
        }
    }
}
