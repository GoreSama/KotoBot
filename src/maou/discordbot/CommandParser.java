package maou.discordbot;

import java.util.ArrayList;

import net.dv8tion.jda.core.events.message.MessageReceivedEvent;

public class CommandParser {
	public static CommandContainer parse(String rw, MessageReceivedEvent e) {
		ArrayList<String> split = new ArrayList<>();
		String raw = rw;
		String beheaded = raw.replaceFirst("!", "");
		String[] spiltBeheaded = beheaded.split(" ");
		for (String s : spiltBeheaded) {
			split.add(s);
		}
		String invoke = split.get(0);
		String[] args = new String[split.size() - 1];
		split.subList(1, split.size()).toArray(args);

		return new CommandContainer(raw, beheaded, spiltBeheaded, invoke, args, e);
	}

	public static class CommandContainer {
		public final String raw;
		public final String beheaded;
		public final String[] splitBeheaded;
		public final String invoke;
		public final String[] args;
		public final MessageReceivedEvent event;

		public CommandContainer(String rw, String beheaded, String[] splitBeheaded, String invoke, String[] args,
				MessageReceivedEvent event) {
			this.raw = rw;
			this.beheaded = beheaded;
			this.splitBeheaded = splitBeheaded;
			this.invoke = invoke;
			this.args = args;
			this.event = event;
		}
	}
}
