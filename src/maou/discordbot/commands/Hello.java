package maou.discordbot.commands;

import maou.discordbot.Command;
import net.dv8tion.jda.core.events.message.MessageReceivedEvent;

public class Hello implements Command {
	private final String HELP = "Lol..";

	@Override
	public boolean called(String[] args, MessageReceivedEvent event) {
		return true;
	}

	@Override
	public void action(String[] args, MessageReceivedEvent event) {
		event.getTextChannel().sendMessage("Hello.").queue();
	}

	@Override
	public String help() {
		return HELP;
	}

	@Override
	public void executed(boolean success, MessageReceivedEvent event) {
		return;
	}

}
