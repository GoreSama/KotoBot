package maou.discordbot;

import maou.discordbot.utils.SendMessage;
import net.dv8tion.jda.core.entities.TextChannel;
import net.dv8tion.jda.core.events.ReadyEvent;
import net.dv8tion.jda.core.events.message.MessageReceivedEvent;
import net.dv8tion.jda.core.hooks.ListenerAdapter;

public class ListenerClass extends ListenerAdapter {
	//plzno
		
	@Override
	public void onMessageReceived(MessageReceivedEvent event) {
		TextChannel channel = event.getTextChannel();
		System.out.println(event.getAuthor().getName() + ": " + event.getMessage().getContent());
		if (event.getMessage().getContent().startsWith("!")
				&& event.getMessage().getAuthor().getId() != event.getJDA().getSelfUser().getId()) {
			Client.handleCommand(Client.parser.parse(event.getMessage().getContent().toLowerCase(), event));
		}
		if (event.getMessage().getContent().equalsIgnoreCase("ayy")) {
			event.getTextChannel().addReactionById(event.getMessageId(), "🇱").queue();
			event.getTextChannel().addReactionById(event.getMessageId(), "🇲").queue();
			event.getTextChannel().addReactionById(event.getMessageId(), "🇦").queue();
			event.getTextChannel().addReactionById(event.getMessageId(), "🇴").queue();
		}
		if (event.getMessage().getContent().contains("nigg")) {
			new SendMessage(channel, "TriHard");
		}
	}

	@Override
	public void onReady(ReadyEvent event) {
	}

}
