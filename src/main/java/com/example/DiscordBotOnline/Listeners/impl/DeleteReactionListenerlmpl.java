package com.example.DiscordBotOnline.Listeners.impl;

import org.javacord.api.event.message.reaction.ReactionAddEvent;
import org.javacord.api.listener.message.reaction.ReactionAddListener;
import org.springframework.stereotype.Component;

@Component
public class DeleteReactionListenerlmpl implements ReactionAddListener {

    @Override
    public void onReactionAdd(ReactionAddEvent reactionAddEvent) {
        if(reactionAddEvent.getEmoji().equalsEmoji("\uD83D\UDC4E")){
            reactionAddEvent.deleteMessage();
        }

    }
}
