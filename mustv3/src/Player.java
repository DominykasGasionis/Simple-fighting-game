import javax.swing.JPanel;

import java.util.LinkedList;
import java.util.Queue;

public class Player extends JPanel
{
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private String name;
    private int health;
    private int stamina;
    private boolean check = false;
   
    private Queue<String> eile = new LinkedList<>();
    
    public Player( int health, int stamina) 
    {
        this.health = health;
        this.stamina = stamina;
    }

    
    
  
    
    public boolean isAlive() 
    {
    	return health > 0;
    }
    
    
    public String getName()
    {
    	return name;
    }
    
    
    public void setName(String name)
    {
    	this.name = name;
    }
   
    public int getHealth()
    {
    	return health;
    }
    
    public int getStamina()
    {
    	return stamina;
    }
    
    public boolean getCheck()
    {
    	return check;
    }
    
    
    void setQueue(Queue<String> eile)
    {
    	this.eile = eile;
    }
    
    
    void setHealth(int health)
    {
    	this.health = health;
    }
    
    
    void setStamina(int stamina)
    {
    	this.stamina = stamina;
    }
    //////////////////////////////////////////////////////////////////
    
    
    
   public void bash()
   {
	   if(check == false) 
	   {
		   eile.add("Bash");
		   check = true;
	   }
	   else 
	   {
		   removeLast(eile);
		   eile.add("Bash");
	   }
	   
   }
   
   public void hook()
   {
	   if(check == false) 
	   {
		   eile.add("Hook");
		   check = true;
	   }
	   else 
	   {
		   removeLast(eile);
		   eile.add("Hook");
	   }
   }
   
   public void kick()
   {
	   if(check == false) 
	   {
		   eile.add("Kick");
		   check = true;
	   }
	   else 
	   {
		   removeLast(eile);
		   eile.add("Kick");
	   }
   }
   
   public void crit()
   {
	   if(check == false) 
	   {
		   eile.add("Crit");
		   check = true;
	   }
	   else 
	   {
		   removeLast(eile);
		   eile.add("Crit");
	   }
   }
   
   public Queue<String> returnQueue() 
   {
       return eile; 
   }
   
   
   public int getQueueLenght()
   {
	   return eile.size();
   }
    
    
    //////////////////////////////////////////////////////////////////////
    
    
   public void removeLast(Queue<String> eile) 
   {
       
	   if (eile.isEmpty()) return;
       
	   
     
       Queue<String> tempQueue = new LinkedList<>();


       while (eile.size() > 1) 
       {
           tempQueue.add(eile.remove());
       }


       eile.remove();
       eile.addAll(tempQueue);
       
   }
   
   
   public String getLast() 
   {
	   
       if (eile == null || eile.isEmpty()) return null; 
       
       
       Queue<String> tempQueue = new LinkedList<>();
       String lastElement = null;

    
       while (!eile.isEmpty()) 
       {
           lastElement = eile.remove();
           tempQueue.add(lastElement);
       }

  
       eile.addAll(tempQueue);

       return lastElement; 
       
   }
   
   public void removeElements() 
   {
	   if (eile.isEmpty()) return;
       
       while (!eile.isEmpty()) 
       {
           eile.remove();
       }
       
   }
    
    /////////////////////////////////////////////////////////////////////////////////
   
   
   
   
   	void gainDamage()
   	{
   		health -= 10;
   	}
   	
   	void gainComboDamage()
   	{
   		health -= 35;
   	}
   	
   	void gainStamina()
   	{
   		stamina +=25;
   	}
   	
   	void rearmCheck()
   	{
   		check = false;
   	}
   
   	void gainHealth()
   	{
   		health += 40;
   	}
   	
   	void resetStamina()
   	{
   		stamina = 0;
   	}
   
   
   	
   
   
   
   
   
   
   
   
   
   
   
   
   
}