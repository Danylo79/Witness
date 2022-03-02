package dev.dankom.witness.discord;

import net.dv8tion.jda.api.JDA;
import net.dv8tion.jda.api.JDABuilder;

public abstract class DiscordBot {
    protected JDA jda;

    public DiscordBot(String token) {
        JDABuilder builder = JDABuilder.createDefault(token);
        preInit(builder);
    }

    public abstract void preInit(JDABuilder builder);
    public abstract void init(JDA jda);
}
