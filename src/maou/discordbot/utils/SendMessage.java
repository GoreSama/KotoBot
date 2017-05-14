package maou.discordbot.utils;

import net.dv8tion.jda.core.entities.TextChannel;
import net.dv8tion.jda.core.exceptions.PermissionException;

public class SendMessage {
	private TextChannel channel;
	private String message;

	private void send() {
		try {
			channel.sendMessage(message).queue();
		} catch (PermissionException e) {
			e.printStackTrace();
			System.out.println("Permission error.");
		}
	}

	public SendMessage(TextChannel channel, String message) {
		this.channel = channel;
		this.message = message;
		send();
	}

}