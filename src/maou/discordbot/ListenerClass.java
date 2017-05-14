package maou.discordbot;

import net.dv8tion.jda.core.events.ReadyEvent;
import net.dv8tion.jda.core.events.message.MessageReceivedEvent;
import net.dv8tion.jda.core.hooks.ListenerAdapter;

public class ListenerClass extends ListenerAdapter {
	//plzno
	public enum Emotes {
		GRINNING("😀"),
		GRIMACING("😀"),
		GRIN("😀"),
		JOY("😀"),
		SMILEY("😀"),
		SMILE("😀"),
		SWEATSMILE("😀"),
		LAUGHING("😀"),
		INNOCENT("😀"),
		WINK("😀"),
		BLUSH("😀"),
		SLIGHT_SMILE("😀");
		
		//I'm not even going to finish adding all this manually, not sure why I event started
		//consdering how many fucking emotes there are zz
		
		
		private String emote = "";
		
		private Emotes(String emote) {
			this.emote = emote;
		}
		
		private String getEmote() {
			return emote;
		}
		
	}
	
	
	
	@Override
	public void onMessageReceived(MessageReceivedEvent event) {
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
	}

	@Override
	public void onReady(ReadyEvent event) {
	}

}
