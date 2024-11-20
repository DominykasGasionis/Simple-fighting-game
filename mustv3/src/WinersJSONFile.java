import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.LinkedList;
import java.io.FileReader;
import java.io.FileWriter;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

public class WinersJSONFile {
	
	String filePath = "winners.json";
	String winnerName;
    LinkedList<JSONObject> historyLinkedList = new LinkedList<>();
    
	
	@SuppressWarnings("unchecked")
	WinersJSONFile(String name)
	{
		
		winnerName = name;

	        try {
	        	
	        	
	        	
	        	// Step 1: Check if file exists and read its contents
	            File file = new File(filePath);
	            if (!file.exists() || file.length() == 0) 
	            {
	                // If file is empty or does not exist, initialize with an empty JSON array
	                System.out.println("Failo nera arba jis tuscias");
	            } 
	            else 
	            {
	                // Step 2: Read the file content
	                FileReader reader = new FileReader(file);
	                BufferedReader bufferedReader = new BufferedReader(reader);
	                StringBuilder content = new StringBuilder();
	                String line;
	                
	                while ((line = bufferedReader.readLine()) != null) 
	                {
	                    content.append(line.trim());
	                }
	                bufferedReader.close();

	                
	                
	                // Step 3: Handle empty content (e.g., whitespace or empty file)
	                if (content.length() == 0) 
	                {
	                    System.out.println("Failas tuscias");
	                } 
	                else 
	                {
	                    // Parse the valid JSON content
	                    JSONParser parser = new JSONParser();
	                    Object obj = parser.parse(content.toString());

	                    if (obj instanceof JSONArray) 
	                    {
	                        JSONArray jsonArray = (JSONArray) obj;

	                        // Step 4: Convert JSON array to LinkedList
	                        for (Object item : jsonArray) 
	                        {
	                        	historyLinkedList.add((JSONObject) item);
	                        }
	                    }
	                }
	                
	                
	                
	            }

	            // Step 5: Display the LinkedList contents
	            if (historyLinkedList.isEmpty()) {
	                System.out.println("LinkedList is currently empty.");
	            } else {
	                System.out.println("Data in LinkedList:");
	                for (JSONObject jsonObject : historyLinkedList) {
	                    System.out.println("ID: " + jsonObject.get("id") + ", Name: " + jsonObject.get("name"));
	                }
	            }

	            JSONObject newEntry = new JSONObject();
		        newEntry.put("id", historyLinkedList.size() + 1); // Increment ID based on size of the list
		        newEntry.put("name", winnerName);
		        historyLinkedList.add(newEntry);
		
		        // Step 7: Convert the LinkedList back to a JSON array and save to the file
		        JSONArray updatedJsonArray = new JSONArray();
		        updatedJsonArray.addAll(historyLinkedList);
		
		        FileWriter writer = new FileWriter(filePath);
		        writer.write(updatedJsonArray.toJSONString());
		        writer.close();
		
		        System.out.println("\nNew data appended successfully and saved back to the file!");

			
			
		}
		catch(FileNotFoundException e) {e.printStackTrace();}
		catch(IOException e) {e.printStackTrace();}
		catch(ParseException e) {e.printStackTrace();}
		catch(Exception e) {e.printStackTrace();}
		
		
		
		   
	     
	}
	
	
	WinersJSONFile()
	{
		
	

	        try {
	        	
	        	
	        	
	        	// Step 1: Check if file exists and read its contents
	            File file = new File(filePath);
	            if (!file.exists() || file.length() == 0) 
	            {
	                // If file is empty or does not exist, initialize with an empty JSON array
	                System.out.println("Failo nera arba jis tuscias");
	            } 
	            else 
	            {
	                // Step 2: Read the file content
	                FileReader reader = new FileReader(file);
	                BufferedReader bufferedReader = new BufferedReader(reader);
	                StringBuilder content = new StringBuilder();
	                String line;
	                
	                while ((line = bufferedReader.readLine()) != null) 
	                {
	                    content.append(line.trim());
	                }
	                bufferedReader.close();

	                
	                
	                // Step 3: Handle empty content (e.g., whitespace or empty file)
	                if (content.length() == 0) 
	                {
	                    System.out.println("Failas tuscias");
	                } 
	                else 
	                {
	                    // Parse the valid JSON content
	                    JSONParser parser = new JSONParser();
	                    Object obj = parser.parse(content.toString());

	                    if (obj instanceof JSONArray) 
	                    {
	                        JSONArray jsonArray = (JSONArray) obj;

	                        // Step 4: Convert JSON array to LinkedList
	                        for (Object item : jsonArray) 
	                        {
	                        	historyLinkedList.add((JSONObject) item);
	                        }
	                    }
	                }
	                
	                
	                
	            }

	            // Step 5: Display the LinkedList contents
	            if (historyLinkedList.isEmpty()) {
	                System.out.println("LinkedList is currently empty.");
	            } else {
	                System.out.println("Data in LinkedList:");
	                for (JSONObject jsonObject : historyLinkedList) {
	                    System.out.println("ID: " + jsonObject.get("id") + ", Name: " + jsonObject.get("name"));
	                }
	            }    

			
			
		}
		catch(FileNotFoundException e) {e.printStackTrace();}
		catch(IOException e) {e.printStackTrace();}
		catch(ParseException e) {e.printStackTrace();}
		catch(Exception e) {e.printStackTrace();}
		
		
		
		   
	     
	}
	
	
	public  LinkedList<JSONObject> getLinkedList()
	{
		return historyLinkedList;
	}
	
	
	
	
	
   
	      
	
}
