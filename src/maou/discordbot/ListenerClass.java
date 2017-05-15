package maou.discordbot;

import net.dv8tion.jda.core.entities.Message;
import net.dv8tion.jda.core.entities.TextChannel;
import net.dv8tion.jda.core.events.ReadyEvent;
import net.dv8tion.jda.core.events.message.MessageReceivedEvent;
import net.dv8tion.jda.core.hooks.ListenerAdapter;

public class ListenerClass extends ListenerAdapter {
	//plzno
		
	@Override
	public void onMessageReceived(MessageReceivedEvent event) {
		if (event.getAuthor().isBot()) return;
		Message message = event.getMessage();
		String content = message.getRawContent();
		TextChannel textChannel = event.getTextChannel();
		//
		if (content.startsWith("!")
				&& event.getMessage().getAuthor().getId() != event.getJDA().getSelfUser().getId()) {
			Client.handleCommand(Client.parser.parse(content.toLowerCase(), event));
		}
		if (content.equalsIgnoreCase("ayy")) {
			textChannel.addReactionById(event.getMessageId(), "🇱").queue();
			textChannel.addReactionById(event.getMessageId(), "🇲").queue();
			textChannel.addReactionById(event.getMessageId(), "🇦").queue();
			textChannel.addReactionById(event.getMessageId(), "🇴").queue();
		}
	}

	@Override
	public void onReady(ReadyEvent event) {
		if (event instanceof ReadyEvent)
			System.out.println("Connected.");
	}

}
