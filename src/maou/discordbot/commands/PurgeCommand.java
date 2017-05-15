package maou.discordbot.commands;

import maou.discordbot.Command;
import net.dv8tion.jda.core.Permission;
import net.dv8tion.jda.core.entities.MessageHistory;
import net.dv8tion.jda.core.events.message.MessageReceivedEvent;
import net.dv8tion.jda.core.utils.PermissionUtil;

public class PurgeCommand implements Command {

	@Override
	public boolean called(String[] args, MessageReceivedEvent event) {
		return true;
	}

	@Override
	public void action(String[] args, MessageReceivedEvent event) {
		int numberOfMessagesToDelete;
		String[] separateString = event.getMessage().getContent().split(" ");
		if (separateString.length >= 2) {
			numberOfMessagesToDelete = Integer.parseInt(separateString[1]);
			if (numberOfMessagesToDelete >= 2 && numberOfMessagesToDelete <= 100) {
				MessageHistory messagesToDelete;
				if (numberOfMessagesToDelete == 0 || numberOfMessagesToDelete > 100) {
				} else {
					try {
						if (PermissionUtil.checkPermission(event.getTextChannel(), event.getMember(),
								Permission.MESSAGE_MANAGE)) {
							messagesToDelete = event.getChannel().getHistory();
							messagesToDelete.retrievePast(numberOfMessagesToDelete)
									.queue(messages -> event.getTextChannel().deleteMessages(messages).queue());
						} else {
							event.getTextChannel().sendMessage("No.").queue();
						}
					} catch (IllegalArgumentException e) {
					}
				}
			} else {
			}
		} else {
		}
	}

	@Override
	public String help() {
		return null;
	}

	@Override
	public void executed(boolean success, MessageReceivedEvent event) {

	}

}
