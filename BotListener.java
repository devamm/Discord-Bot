package Bots.ValtteriBOTtas;

import java.io.File;
//import java.io.File;
import java.io.IOException;

import net.dv8tion.jda.core.entities.User;
import net.dv8tion.jda.core.events.message.MessageReceivedEvent;
import net.dv8tion.jda.core.hooks.ListenerAdapter;

public class BotListener extends ListenerAdapter {
	public void onMessageReceived(MessageReceivedEvent event){
	
		User author = event.getAuthor();
		boolean isBot = author.isBot();
		Node intens = null,hype = null; 
		String msg = event.getMessage().getContentRaw().toLowerCase();
		//Node sven = null;
		try {
			intens = new Node("intens.txt");
			hype = new Node("ferrari.txt");
			//sven = new Node("sven.txt");
		} catch (IOException e1) {
			//to keep compiler happy
		}
		
		
		if( ((msg.contains("ferrari") && msg.contains("hype")) || (((msg.contains("seb") || msg.contains("kimi")) && (msg.contains("win") || msg.contains("won") )))) && !isBot ){
			int fer = hype.getCount();
			if (fer == 1){
				event.getChannel().sendMessage("Choo Choo! The Ferrari hype train has departed the station at 1 mile/hour").queue();
				try {
					hype.increment();
				} catch (IOException e) {}
			}
			try {
				hype.multiply();
				event.getChannel().sendMessage("Choo Choo! The Ferrari hype train is now traveling at "+hype.getCount()+" miles/hour").queue();
			} catch (IOException e) {
				
			}
			
		}
		
		if(msg.startsWith("@") && isBot){
			String tweet = msg.substring(18);
			if(tweet.startsWith("report:")){
				if(tweet.contains("valtteri") || tweet.contains("bottas")){
					if(tweet.contains("win") || tweet.contains("victory")){
						//bottas won the race (most likely)
						event.getChannel().sendMessage("🎉🎉🎉🎉").queue();
						
					}
				}
			}
		}
		
		switch(msg) {
			case "intensify":
				try {
					intens.multiply();
					event.getChannel().sendMessage("Valtteri BOTtas operating at "+intens.getCount()+" CPU cycles/second").queue();
				} catch (IOException e) {}
				break;
			case "!happy":
			case "!sad":
			case "!angry":
			case "!wow":
			case "!pls":
			case "!hello":
				File file =  new File("gifs/"+msg.substring(1)+".gif");	
				try {
					event.getChannel().sendTyping().queue();
					event.getChannel().sendFile(file).queue();
				} catch (IllegalArgumentException e) {
					event.getChannel().sendMessage("error, file not found").queue();
				}
				break;
		
		
		
		}
		
		
		
		
	}	

	
		
}
