package maou.discordbot;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.HashMap;

import javax.security.auth.login.LoginException;

import maou.discordbot.commands.Hello;
import maou.discordbot.commands.Roll;
import maou.discordbot.commands.Shoot;
import net.dv8tion.jda.core.AccountType;
import net.dv8tion.jda.core.JDA;
import net.dv8tion.jda.core.JDABuilder;
import net.dv8tion.jda.core.exceptions.RateLimitedException;

public class Client {

	// lol
	private static JDA jda;
	public static final CommandParser parser = new CommandParser();
	public static HashMap<String, Command> commands = new HashMap<String, Command>();
	public static final String KOTOBOT_TOKEN = "";

	public static void main(String[] args) {
		String token = "";
		try {
			token = new String(Files.readAllBytes(Paths.get(KOTOBOT_TOKEN)));
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		try {
			jda = new JDABuilder(AccountType.BOT).setToken(token).addEventListener(new ListenerClass()).buildBlocking();
			jda.setAutoReconnect(true);
		} catch (LoginException | IllegalArgumentException | InterruptedException | RateLimitedException e) {
			e.printStackTrace();
		}
		commands.put("hello", new Hello());
		commands.put("roll", new Roll());
		commands.put("shoot", new Shoot()); // this has no significant value
											// honestly
	}

	public static void handleCommand(CommandParser.CommandContainer cmd) {
		if (commands.containsKey(cmd.invoke)) {
			boolean safe = commands.get(cmd.invoke).called(cmd.args, cmd.event);

			if (safe) {
				commands.get(cmd.invoke).action(cmd.args, cmd.event);
				commands.get(cmd.invoke).executed(safe, cmd.event);
			} else {
				commands.get(cmd.invoke).executed(safe, cmd.event);
			}
		}

	}

	public static void log(String evnt, String who) {
		FileOutputStream logOutput = null;
		try {
			logOutput = new FileOutputStream(new File("KotoBot.txt"));
			String log = "[" + LocalDate.now().format(DateTimeFormatter.ofPattern("dd/MM/yyyy")) + " "
					+ LocalDateTime.now().format(DateTimeFormatter.ofPattern("hh:mm:ss")) + "]" + " [" + evnt + " log] "
					+ who;
			logOutput.write(log.getBytes(StandardCharsets.UTF_8));
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				logOutput.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}

}
