import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;


public class CreateJSONFile
{
		Object myNames;
		JSONObject jsonObject;
		JSONParser parser = new JSONParser();
	  JSONObject obj = new JSONObject();
	
	@SuppressWarnings("unchecked")
	CreateJSONFile()
	{
		
		
	   ///////////////////////////////////////////// json failo rasymas
	   
	   try
	   {
		myNames = parser.parse(new FileReader("myJSON.json"));
		jsonObject = (JSONObject) myNames;
		
		
		String name = (String) jsonObject.get("playerOneName");
		obj.put("playerOneName", name);
		
		name = (String) jsonObject.get("playerTwoName");
		obj.put("playerTwoName", name);
		
		name = (String) jsonObject.get("aiName");
		obj.put("aiName", name);
		
		
	   }   
	   catch(FileNotFoundException e) {e.printStackTrace();}
	   catch(IOException e) {e.printStackTrace();}
	   catch(ParseException e) {e.printStackTrace();}
	   catch(Exception e) {e.printStackTrace();}
	   
		
		obj.put("gameMode", "TwoPlayer");
		
	   JSONArray combo1 = new JSONArray();
	   combo1.add("Bash");
	   combo1.add("Kick");
	   combo1.add("Bash");
	   
	   JSONArray combo2 = new JSONArray();
	   combo2.add("Hook");
	   combo2.add("Hook");
	   combo2.add("Kick");
	   
	   JSONArray combo3 = new JSONArray();
	   combo3.add("Kick");
	   combo3.add("Hook");
	   combo3.add("Bash");
	   
	   obj.put("combo1", combo1);
	   obj.put("combo2", combo2);
	   obj.put("combo3", combo3);
	   
	   
	   
	   
	   try(FileWriter file = new FileWriter("myJSON.json"))
	   {
		   file.write(obj.toJSONString());
		   file.flush();
	   }
	   catch(IOException e)
	   {
		   e.printStackTrace();
	   }
	   
	   System.out.println(obj);
	   
	}
	
	
	
	
	
	@SuppressWarnings("unchecked")
	void setGameMode(String gameMode)
	{
		obj.put("gameMode", gameMode);
		
		try(FileWriter file = new FileWriter("myJSON.json"))
		   {
			   file.write(obj.toJSONString());
			   file.flush();
		   }
		   catch(IOException e)
		   {
			   e.printStackTrace();
		   }
	}
	
	
	
	
	
	@SuppressWarnings("unchecked")
	void setPlayerOne(String name)
	{
		obj.put("playerOneName", name);
		
		try(FileWriter file = new FileWriter("myJSON.json"))
		   {
			   file.write(obj.toJSONString());
			   file.flush();
		   }
		   catch(IOException e)
		   {
			   e.printStackTrace();
		   }
	}
	
	
	
	
	
	@SuppressWarnings("unchecked")
	void setPlayerTwo(String name)
	{
		obj.put("playerTwoName", name);
		
		
		try(FileWriter file = new FileWriter("myJSON.json"))
		   {
			   file.write(obj.toJSONString());
			   file.flush();
		   }
		   catch(IOException e)
		   {
			   e.printStackTrace();
		   }
	}
	
	
	@SuppressWarnings("unchecked")
	void setAiName(String name)
	{
		obj.put("aiName", name);
		
		
		try(FileWriter file = new FileWriter("myJSON.json"))
		   {
			   file.write(obj.toJSONString());
			   file.flush();
		   }
		   catch(IOException e)
		   {
			   e.printStackTrace();
		   }
	}
	
	
	
	
	
	
	
	
	
	
}