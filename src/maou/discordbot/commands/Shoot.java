package maou.discordbot.commands;

import maou.discordbot.Client;
import maou.discordbot.Command;
import net.dv8tion.jda.core.entities.TextChannel;
import net.dv8tion.jda.core.events.message.MessageReceivedEvent;

public class Shoot implements Command {

	@Override
	public boolean called(String[] args, MessageReceivedEvent event) {
		return true;
	}

	@Override
	public void action(String[] args, MessageReceivedEvent event) {
		Client.log("Command", "Shoot by " + event.getAuthor().getName());
		TextChannel channel = event.getTextChannel();
		event.getTextChannel().addReactionById(event.getMessageId(), "🇧").queue();
		event.getTextChannel().addReactionById(event.getMessageId(), "🇦").queue();
		event.getTextChannel().addReactionById(event.getMessageId(), "🇳").queue();
		event.getTextChannel().addReactionById(event.getMessageId(), "🇬").queue();
		event.getTextChannel().addReactionById(event.getMessageId(), "🐸").queue();
		event.getTextChannel().addReactionById(event.getMessageId(), "🔫").queue();
	}

	@Override
	public String help() {
		return "Nope";
	}

	@Override
	public void executed(boolean success, MessageReceivedEvent event) {

	}

}
