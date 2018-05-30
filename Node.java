package Bots.ValtteriBOTtas;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class Node {
	private int count;
	private String path = null;
	
	public Node(String p) throws IOException {
		path = p;
		
		FileReader fr;
		try {
			fr = new FileReader(path);
		} catch (FileNotFoundException e) {
			//creates new file with entry 0 if no file found
			FileWriter writer = new FileWriter(path);
			writer.write(Integer.toString(0));
			writer.close();
			fr = new FileReader(path);
		}
		
		//file found, read count value into program
		BufferedReader reader = new BufferedReader(fr);
		try {
			count = Integer.parseInt((reader.readLine()));
		} catch (NumberFormatException e){
			//catches event of non-numerical string
			count = 0;
		}
		
		reader.close();
		return;
	}
	
	public void increment() throws IOException{
		count++;
		//update and write to file
		FileWriter f1 = new FileWriter(path, false);
		String s = Integer.toString(count);
		
		f1.write(s);
		f1.close();
		System.out.println("incremented");
		return;
	}
	
	public void multiply() throws IOException{
		count = count * 2;
		
		FileWriter f1 = new FileWriter(path, false);
		f1.write(Integer.toString(count));
		f1.close();
		return;
	}
	
	public int getCount(){
		return count;
	}
}
