package maou.discordbot.commands;

import java.util.Random;

import maou.discordbot.Client;
import maou.discordbot.Command;
import maou.discordbot.utils.SendMessage;
import net.dv8tion.jda.core.entities.TextChannel;
import net.dv8tion.jda.core.events.message.MessageReceivedEvent;

public class Roll implements Command {

	@Override
	public boolean called(String[] args, MessageReceivedEvent event) {
		return true;
	}

	@Override
	public void action(String[] args, MessageReceivedEvent event) {
		Client.log("Command", "Roll by" + event.getAuthor().getName());
		TextChannel channel = event.getTextChannel();
		Random r = new Random();
		int roll = r.nextInt(100) + 0;
		new SendMessage(channel, event.getAuthor().getName() + ", you rolled a " + roll + ".");
	}

	@Override
	public String help() {
		return null;
	}

	@Override
	public void executed(boolean success, MessageReceivedEvent event) {

	}

}
