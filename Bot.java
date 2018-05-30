package Bots.ValtteriBOTtas;

import javax.security.auth.login.LoginException;

import net.dv8tion.jda.core.AccountType;
import net.dv8tion.jda.core.JDA;
import net.dv8tion.jda.core.JDABuilder;

public class Bot {
	public static JDA jda;
	
	public static final String BOT_TOKEN = "Token removed for GitHub Upload";
	
	public static void main (String[] args){
		
		try {
			jda = new JDABuilder(AccountType.BOT).setToken(BOT_TOKEN).addEventListener(new BotListener()).buildBlocking();
			
			//jda.
		} catch (LoginException | IllegalArgumentException | InterruptedException e) {
			e.printStackTrace();
		}
		//System.out.println("This is PinguBot 2.0, Hello!");
		
	}
}
