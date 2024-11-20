
//import java.io.FileWriter;
//import java.io.IOException;
//import java.util.ArrayList;
//import java.util.List;

//import org.json.simple.JSONArray;
//import org.json.simple.JSONObject;


public class Main 
{
	//@SuppressWarnings("unchecked")
	public static void main(String[] args)
	{
		
		CreateJSONFile jsonCreate = new CreateJSONFile(); 
		ReadJSONFile jsonRead = new ReadJSONFile();
    
	   new MyFrame(jsonCreate, jsonRead);
	   
	   
	}
	
}
