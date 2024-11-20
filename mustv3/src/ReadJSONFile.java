import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Queue;
import java.io.FileReader;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

public class ReadJSONFile {
	
	private Queue<String> combo1 = new LinkedList<>();
	private Queue<String> combo2 = new LinkedList<>();
	private Queue<String> combo3 = new LinkedList<>();
	private String playerOneName;
	private String playerTwoName;
	private String aiName;
	private String gameMode;
	
	
	Object obj;
	JSONObject jsonObject;
	JSONParser parser = new JSONParser();
	
	@SuppressWarnings("unchecked")
	ReadJSONFile(){
		
		
		
		try
		{
			obj = parser.parse(new FileReader("myJSON.json"));
			jsonObject = (JSONObject) obj;
			
			
			String name = (String) jsonObject.get("playerOneName");
			playerOneName = name;
			
			name = (String) jsonObject.get("playerTwoName");
			playerTwoName = name;
			
			name = (String) jsonObject.get("aiName");
			aiName = name;
			
			String mode = (String) jsonObject.get("gameMode");
			gameMode = mode;
			
			
			//combo1
			JSONArray getCombo = (JSONArray) jsonObject.get("combo1");
			Iterator<String> iterator = getCombo.iterator();
			
			while(iterator.hasNext())
			{
				combo1.add(iterator.next());
			}
			
			
			
			//combo2
			getCombo = (JSONArray) jsonObject.get("combo2");
			iterator = getCombo.iterator();
			
			while(iterator.hasNext())
			{
				combo1.add(iterator.next());
			}
			
			
			
			//combo3
			getCombo = (JSONArray) jsonObject.get("combo3");
			iterator = getCombo.iterator();
			
			while(iterator.hasNext())
			{
				combo1.add(iterator.next());
			}
			
			
			
		}
		catch(FileNotFoundException e) {e.printStackTrace();}
		catch(IOException e) {e.printStackTrace();}
		catch(ParseException e) {e.printStackTrace();}
		catch(Exception e) {e.printStackTrace();}
		
		
		
		   
	     
	}
	
	
	
	public void refresh()
	{
		try
		{
		
		obj = parser.parse(new FileReader("myJSON.json"));
		jsonObject = (JSONObject) obj;
		
		
		String name = (String) jsonObject.get("playerOneName");
		playerOneName = name;
		
		name = (String) jsonObject.get("playerTwoName");
		playerTwoName = name;
		
		String mode = (String) jsonObject.get("gameMode");
		gameMode = mode;
		
		}
		catch(FileNotFoundException e) {e.printStackTrace();}
		catch(IOException e) {e.printStackTrace();}
		catch(ParseException e) {e.printStackTrace();}
		catch(Exception e) {e.printStackTrace();}
		
	}
	
	
	public String getPlayerNameOne()
	{
		return playerOneName;
	}
	
	
	
	public String getPlayerNameTwo()
	{
		return playerTwoName;
	}
	
	
	
	public String getAiName()
	{
		return aiName;
	}

	
	
	public String getGameMode()
	{
		return gameMode;
	}
	
	
	
	
	
	
	
	public Queue<String> getCombo1() 
	   {
		  
	       for (String element : combo1) System.out.print(element + " ");
	       System.out.println(" ");
	       
	       return combo1; 
	   }
	
	
	public Queue<String> getCombo2() 
	   {
		  
	       for (String element : combo2) System.out.print(element + " ");
	       System.out.println(" ");
	       
	       return combo2; 
	   }
	
	
	public Queue<String> getCombo3() 
	   {
		  
	       for (String element : combo3) System.out.print(element + " ");
	       System.out.println(" ");
	       
	       return combo3; 
	   }
		  
	       
	       
	      
	
}
