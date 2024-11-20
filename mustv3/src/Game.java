import javax.swing.*;
import javax.swing.border.LineBorder;
import javax.swing.text.BadLocationException;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;


public class Game extends JFrame{
	
	  /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private Queue<String> combo1 = new LinkedList<>();
	private Queue<String> combo2 = new LinkedList<>();
	private Queue<String> combo3 = new LinkedList<>();
	
	
	

	
	private JTextArea consoleArea; 
	private List<Player> players;
	private int currentPlayerIndex;
	
	JButton button1 = new JButton("Bash");
    JButton button2 = new JButton("Kick");
    JButton button3 = new JButton("Hook");
    JButton button4 = new JButton("End turn");
    JButton button5 = new JButton("Crit");
    JButton button6 = new JButton("Heal");
    JButton button7 = new JButton("Drain");
    JButton button8 = new JButton("Exit");
    
    Player currentPlayer;
    Player currentTarget;
    
    private JProgressBar healthBarOne;
    private JProgressBar staminaBarOne;

    private JProgressBar healthBarTwo;
    private JProgressBar staminaBarTwo;
    
    StickmanPanel stickmanPanel = new StickmanPanel();
    
    
    
    ReadJSONFile jsonRead;
    CreateJSONFile jsonCreate;
    
	    public Game(List<Player> players, CreateJSONFile jsonC, ReadJSONFile jsonR) 
	    {
	    	 
	    	
	    	
	    	this.players = players;
	        this.currentPlayerIndex = 0;
	        
	        jsonRead = jsonR;
	        jsonCreate = jsonC;
	        
	        
	    	///////////////////////////////////////////////////////////////////////
	    	
	     
	        setTitle("Mustynes");
	        setSize(800, 400);
	        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	        setLocationRelativeTo(null);
	        setResizable(false); 

	       
	        consoleArea = new JTextArea();
	        consoleArea.setEditable(false); 
	        consoleArea.setLineWrap(true);
	        consoleArea.setWrapStyleWord(true);
	        
	      

	        
	    
	        JScrollPane scrollPane = new JScrollPane(consoleArea);
	        scrollPane.setPreferredSize(new Dimension(10, 33));
			
	        
	       
	        JPanel panel = new JPanel();
	        panel.setLayout(new GridLayout(2, 4, 10, 10)); 
	        panel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10)); 
	        panel.setPreferredSize(new Dimension(100, 90));
	        
	        JPanel playerOneStats = new JPanel();
	        playerOneStats.setLayout(new GridLayout(1, 2, 5, 5)); 
	        playerOneStats.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20)); 
	        
	        JPanel playerTwoStats = new JPanel();
	        playerTwoStats.setLayout(new GridLayout(1, 2, 5, 5)); 
	        playerTwoStats.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20)); 
	        
	        
	        
	        
	        
	        
	        
	        //Health and stamina ——— playerOne
	        
	        healthBarOne = new JProgressBar(0, 100); 
	        healthBarOne.setValue(100);
	        healthBarOne.setStringPainted(false);  
	        healthBarOne.setOrientation(SwingConstants.VERTICAL);
	        healthBarOne.setPreferredSize(new Dimension(30, 20));  
	        
	        healthBarOne.setForeground(Color.RED);    
	        healthBarOne.setBackground(Color.LIGHT_GRAY); 
	       
	        healthBarOne.setBorder(new LineBorder(Color.BLACK, 3));
	        playerOneStats.add(healthBarOne);
	        
	        
	        staminaBarOne = new JProgressBar(0, 100); 
	        staminaBarOne.setValue(0);
	        staminaBarOne.setStringPainted(false);  
	        staminaBarOne.setOrientation(SwingConstants.VERTICAL);
	        staminaBarOne.setPreferredSize(new Dimension(30, 20));  
	        
	        staminaBarOne.setForeground(Color.BLUE);      
	        staminaBarOne.setBackground(Color.LIGHT_GRAY); 
	        staminaBarOne.setBorder(new LineBorder(Color.BLACK, 3));
	        
	        
	        playerOneStats.add(staminaBarOne);
	        
	        
	        
	        
	        
	        
	        
	        //Health and stamina ——— playerOne
	        
	        healthBarTwo = new JProgressBar(0, 100); 
	        healthBarTwo.setValue(100);
	        healthBarTwo.setStringPainted(false);  
	        healthBarTwo.setOrientation(SwingConstants.VERTICAL);
	        healthBarTwo.setPreferredSize(new Dimension(30, 20));  
	        
	        healthBarTwo.setForeground(Color.RED);       
	        healthBarTwo.setBackground(Color.LIGHT_GRAY); 
	        healthBarTwo.setBorder(new LineBorder(Color.BLACK, 3));
	        
	        playerTwoStats.add(healthBarTwo);
	        
	        
	        staminaBarTwo = new JProgressBar(0, 100); 
	        staminaBarTwo.setValue(0);
	        staminaBarTwo.setStringPainted(false);  
	        staminaBarTwo.setOrientation(SwingConstants.VERTICAL);
	        staminaBarTwo.setPreferredSize(new Dimension(30, 20));  
	        
	        staminaBarTwo.setForeground(Color.BLUE);       
	        staminaBarTwo.setBackground(Color.LIGHT_GRAY); 
	        staminaBarTwo.setBorder(new LineBorder(Color.BLACK, 3));
	        
	        
	        playerTwoStats.add(staminaBarTwo);
	        
	        
	        
	        
	        
	        
	        
	        
	        
	        
	   
	        button1.addActionListener(new ActionListener() {
	        	@Override
                public void actionPerformed(ActionEvent e) {
	        		button4.setEnabled(true);
	        		
	        		currentPlayer.bash();
	        		if(currentPlayer.getCheck() == true) 
	        		{
	        			clearCurrentLine(consoleArea); // Clears the current line
	        			consoleArea.append("\r");      // Moves the cursor to the beginning of the line
	        		}
	        		Queue<String> temp = currentPlayer.returnQueue();
	    	        for (String element : temp) consoleArea.append(element + " "); 
                }
            });
	        
	        button2.addActionListener(new ActionListener() {
	        	@Override
                public void actionPerformed(ActionEvent e) {
	        		button4.setEnabled(true);
	        		
	        		currentPlayer.kick();
	        		if(currentPlayer.getCheck() == true) 
	        		{
	        			clearCurrentLine(consoleArea); // Clears the current line
	        			consoleArea.append("\r");      // Moves the cursor to the beginning of the line
	        		}
	        		Queue<String> temp = currentPlayer.returnQueue();
	    	        for (String element : temp) consoleArea.append(element + " "); 
                }
            });
	        
	        button3.addActionListener(new ActionListener() {
	        	@Override
                public void actionPerformed(ActionEvent e) {
	        		button4.setEnabled(true);
	        		
	        		currentPlayer.hook();
	        		if(currentPlayer.getCheck() == true) 
	        		{
	        			clearCurrentLine(consoleArea); // Clears the current line
	        			consoleArea.append("\r");      // Moves the cursor to the beginning of the line
	        		}
	        		Queue<String> temp = currentPlayer.returnQueue();
	    	        for (String element : temp) consoleArea.append(element + " "); 
                }
            });
            
            
            button4.addActionListener(new ActionListener() {
            	@Override
                public void actionPerformed(ActionEvent e) {
            		if(currentPlayerIndex == 1) 
            		{
            			stickmanPanel.startMoving();
            			calculateDamage();
            		}
                    nextTurn();
                }
            });
            
            
            button5.addActionListener(new ActionListener() {
            	@Override
                public void actionPerformed(ActionEvent e) {
            		button4.setEnabled(true);
	        		
	        		currentPlayer.crit();
	        		if(currentPlayer.getCheck() == true) 
	        		{
	        			clearCurrentLine(consoleArea); // Clears the current line
	        			consoleArea.append("\r");      // Moves the cursor to the beginning of the line
	        		}
	        		Queue<String> temp = currentPlayer.returnQueue();
	    	        for (String element : temp) consoleArea.append(element + " "); 
	    	        
    
            		currentPlayer.resetStamina();
            		
            		if(currentPlayerIndex == 1) staminaBarTwo.setValue(currentPlayer.getStamina());
            		else staminaBarOne.setValue(currentPlayer.getStamina());
            		
            		button7.setEnabled(false);
            		button6.setEnabled(false);
            		button5.setEnabled(false);
            		
                }
            });
            
            
            
            button6.addActionListener(new ActionListener() {
            	@Override
                public void actionPerformed(ActionEvent e) {
            		currentPlayer.gainHealth();
            		currentPlayer.resetStamina();
            		
            		if(currentPlayerIndex == 1)
            		{  	
            	    	healthBarTwo.setValue(currentPlayer.getHealth());
            	    	staminaBarTwo.setValue(currentPlayer.getStamina());
            		}
            		else
            		{
            			healthBarOne.setValue(currentPlayer.getHealth());
            	    	staminaBarOne.setValue(currentPlayer.getStamina());
            		}
            		
                	
            		button7.setEnabled(false);
            		button6.setEnabled(false);
            		button5.setEnabled(false);
                }
            });
            
           
            button7.addActionListener(new ActionListener() {
            	@Override
                public void actionPerformed(ActionEvent e) {
            		
            		int temp = currentTarget.getStamina();
            		currentPlayer.setStamina(temp);
            		currentTarget.setStamina(temp-80);
            		
            		if(currentPlayerIndex == 1)
            		{  	
            	    	staminaBarTwo.setValue(currentPlayer.getStamina());
            	    	staminaBarOne.setValue(currentTarget.getStamina());
            		}
            		else
            		{
            	    	staminaBarOne.setValue(currentPlayer.getStamina());
            	    	staminaBarTwo.setValue(currentTarget.getStamina());
            		}
            		
            		button7.setEnabled(false);
            		button6.setEnabled(false);
            		button5.setEnabled(false);
            		
                }
            });
            
            
            button8.addActionListener(new ActionListener() {
            	@Override
                public void actionPerformed(ActionEvent e) {
            		dispose();
            		new MyFrame(jsonCreate, jsonRead);
                }
            });
	        
            
            
            
            
            
            
            button1.setBackground(Color.LIGHT_GRAY);
            button1.setForeground(Color.BLACK);
            button1.setFocusPainted(false);
            button1.setFont(new Font("Arial", Font.BOLD, 14));
            button1.setBorder(new LineBorder(Color.BLACK, 2));
            
            button2.setBackground(Color.LIGHT_GRAY);
            button2.setForeground(Color.BLACK);
            button2.setFocusPainted(false);
            button2.setFont(new Font("Arial", Font.BOLD, 14));
            button2.setBorder(new LineBorder(Color.BLACK, 2));
            
            button3.setBackground(Color.LIGHT_GRAY);
            button3.setForeground(Color.BLACK);
            button3.setFocusPainted(false);
            button3.setFont(new Font("Arial", Font.BOLD, 14));
            button3.setBorder(new LineBorder(Color.BLACK, 2));
            
            button4.setBackground(Color.LIGHT_GRAY);
            button4.setForeground(Color.BLACK);
            button4.setFocusPainted(false);
            button4.setFont(new Font("Arial", Font.BOLD, 14));
            button4.setBorder(new LineBorder(Color.BLACK, 2));
            
            button5.setBackground(Color.LIGHT_GRAY);
            button5.setForeground(Color.BLACK);
            button5.setFocusPainted(false);
            button5.setFont(new Font("Arial", Font.BOLD, 14));
            button5.setBorder(new LineBorder(Color.BLACK, 2));
            
            button6.setBackground(Color.LIGHT_GRAY);
            button6.setForeground(Color.BLACK);
            button6.setFocusPainted(false);
            button6.setFont(new Font("Arial", Font.BOLD, 14));
            button6.setBorder(new LineBorder(Color.BLACK, 2));
         
            button7.setBackground(Color.LIGHT_GRAY);
            button7.setForeground(Color.BLACK);
            button7.setFocusPainted(false);
            button7.setFont(new Font("Arial", Font.BOLD, 14));
            button7.setBorder(new LineBorder(Color.BLACK, 2));
            
            button8.setBackground(Color.LIGHT_GRAY);
            button8.setForeground(Color.BLACK);
            button8.setFocusPainted(false);
            button8.setFont(new Font("Arial", Font.BOLD, 14));
            button8.setBorder(new LineBorder(Color.BLACK, 2));
            
            
            
	
	        panel.add(button1);
	        panel.add(button2);
	        panel.add(button3);
	        panel.add(button4);
	        panel.add(button5);
	        panel.add(button6);
	        panel.add(button7);
	        panel.add(button8);
	        
	        
	        
	
	        add(scrollPane, BorderLayout.NORTH); 
	        add(panel, BorderLayout.SOUTH);       
	        add(stickmanPanel, BorderLayout.CENTER);
	        add(playerOneStats, BorderLayout.WEST);
	        add(playerTwoStats, BorderLayout.EAST);
	        setVisible(true);
	        
	        
	        /////////////////////////////////////////////////////////////////////////////////////////////
	        
	        
	       
	       combo1 = jsonRead.getCombo1();
	       combo2 = jsonRead.getCombo2();
	       combo3 = jsonRead.getCombo3();
	        
	        
	        takeTurn();
	        
	    }

	  
	    
	    
	    
	    
	    
	    
	    
	    private void takeTurn() {
	        if (!isGameActive()) 
	        {
	            consoleArea.append("\n\nGame over! ");
	            if(currentPlayer.isAlive() == true) consoleArea.append("The winner is "+ currentPlayer.getName() + "!");
	            else consoleArea.append("The winner is "+ currentTarget.getName() + "!");
	            
	            button1.setEnabled(false);
	            button2.setEnabled(false);
	            button3.setEnabled(false);
	            button4.setEnabled(false);
	            button5.setEnabled(false);
	            button6.setEnabled(false);
	            button7.setEnabled(false);
	          
	            
	            // parasyti laimetojo varda i json faila
	            if(currentPlayer.isAlive() == true) new WinersJSONFile(currentPlayer.getName());
	            else new WinersJSONFile(currentTarget.getName());
	            return;
	        }
	        
	        
	        
	        button4.setEnabled(false);
	        currentPlayer = players.get(currentPlayerIndex);
	        currentTarget = players.get((currentPlayerIndex + 1) % players.size());
	        
	       
	        
	        if(currentPlayer.getStamina()>=100) 
	        {
	        	button5.setEnabled(true);
	        	button6.setEnabled(true);
	        	button7.setEnabled(true);
	        }
	        else
	        {
	        	button5.setEnabled(false);
	        	button6.setEnabled(false);
	        	button7.setEnabled(false);
	        }

	        consoleArea.append("\n It's " + currentPlayer.getName() + "'s turn. Targeting " + currentTarget.getName() + ".\n");
	        
	        
	        Queue<String> temp = currentPlayer.returnQueue();
	        for (String element : temp) consoleArea.append(element + " ");
	        
	        
	    }
	    
	    
	    
	    private boolean isGameActive() 
	    {
	        return players.stream().allMatch(Player::isAlive);
	    }

	    
	    
	    private void nextTurn() 
	    {
	        currentPlayerIndex = (currentPlayerIndex + 1) % players.size();
	        takeTurn();  
	    }
	    
	    
	    
	    

	    public static void clearCurrentLine(JTextArea textArea) {
	        try 
	        {
	            int caretPos = textArea.getCaretPosition();
	            int line = textArea.getLineOfOffset(caretPos);

	            int startOffset = textArea.getLineStartOffset(line);
	            int endOffset = textArea.getLineEndOffset(line);

	            textArea.replaceRange("", startOffset, endOffset);
	            
	        } 
	        catch (BadLocationException e) {e.printStackTrace();}
	        
	    }
	    
	    
	    
	    
	    public static boolean containsInOrder(Queue<String> playerQueue, Queue<String> combo) {
	       
	        String[] mainArray = playerQueue.toArray(new String[0]); 
	        String[] subArray = combo.toArray(new String[0]); 

	        // Validate inputs
	        if (mainArray == null || subArray == null) return false;
	        if (mainArray.length == 0 || subArray.length == 0) return false;     
	        if (mainArray.length < 2) return false; 

	  
	        for (int i = 0; i <= mainArray.length - 3; i++) 
	        {
	            System.out.println("Checking index " + i);
	            if (mainArray[i].equals(subArray[0]) && mainArray[i + 1].equals(subArray[1]) && mainArray[i + 2].equals(subArray[2])) 
	            {

	                System.out.println("Match found:");
	                System.out.println(mainArray[i] + " == " + subArray[0]);
	                System.out.println(mainArray[i + 1] + " == " + subArray[1]);
	                System.out.println(mainArray[i + 2] + " == " + subArray[2]);
	                return true;
	            }
	            
	        }

	        return false;
	    }

	    
	    
	    public void calculateDamage()
	    {
	    	String attack1 = currentPlayer.getLast();
	    	String attack2 = currentTarget.getLast();
	

	    	//Crit
	    	
	    	if(attack1 == "Crit" && attack2 == "Kick") //Crit laimi pries Kick
	    	{
	    		currentTarget.gainComboDamage();
	    		currentTarget.removeElements();
	    		currentPlayer.removeElements();
	    	}
	    	else if(attack1 == "Crit" && attack2 == "Bash") //Bash laimi pries Kick
	    	{
	    		currentTarget.gainComboDamage();
	    		currentTarget.removeElements();
	    		currentPlayer.removeElements();
	    	}
	    	else if(attack1 == "Crit" && attack2 == "Hook") //Bash laimi pries Kick
	    	{
	    		currentTarget.gainComboDamage();
	    		currentTarget.removeElements();
	    		currentPlayer.removeElements();
	    	}
	    	
	    	else if(attack1 == "Kick" && attack2 == "Crit") //Crit laimi pries Kick
	    	{
	    		currentPlayer.gainComboDamage();
	    		currentPlayer.removeElements();
	    		currentTarget.removeElements();
	    	}
	    	else if(attack1 == "Bash" && attack2 == "Crit") //Bash laimi pries Kick
	    	{
	    		currentPlayer.gainComboDamage();
	    		currentPlayer.removeElements();
	    		currentTarget.removeElements();
	    	}
	    	else if(attack1 == "Hook" && attack2 == "Crit") //Bash laimi pries Kick
	    	{
	    		currentPlayer.gainComboDamage();
	    		currentPlayer.removeElements();
	    		currentTarget.removeElements();
	    	}
	    	
	    	
	    	
	    	//Combo
	    	
	    	else if(containsInOrder(currentPlayer.returnQueue(), combo1))
	    	{
	    		currentTarget.gainComboDamage();
	    		currentTarget.removeElements();
	    		currentPlayer.removeElements();
	    	}
	    	else if(containsInOrder(currentPlayer.returnQueue(), combo2))
	    	{
	    		currentTarget.gainComboDamage();
	    		currentTarget.removeElements();
	    		currentPlayer.removeElements();
	    	}
	    	else if(containsInOrder(currentPlayer.returnQueue(), combo3))
	    	{
	    		currentTarget.gainComboDamage();
	    		currentTarget.removeElements();
	    		currentPlayer.removeElements();
	    	}
	    	else if(containsInOrder(currentTarget.returnQueue(), combo1))
	    	{
	    		currentPlayer.gainComboDamage();
	    		currentPlayer.removeElements();
	    		currentTarget.removeElements();
	    	}
	    	else if(containsInOrder(currentTarget.returnQueue(), combo2))
	    	{
	    		currentPlayer.gainComboDamage();
	    		currentPlayer.removeElements();
	    		currentTarget.removeElements();
	    	}
	    	else if(containsInOrder(currentTarget.returnQueue(), combo3))
	    	{
	    		currentPlayer.gainComboDamage();
	    		currentPlayer.removeElements();
	    		currentTarget.removeElements();
	    	}
	    	
	    	
	    	
	    	
	    	//Visos kitos atakos
	    	
	    	else if(attack1 == "Bash" && attack2 == "Kick") //Bash laimi pries Kick
	    	{
	    		currentTarget.gainDamage();
	    		currentTarget.removeElements();
	    		
	    		currentPlayer.gainStamina();
	    	}
	    	else if(attack1 == "Kick" && attack2 == "Bash") //Bash laimi pries Kick
	    	{
	    		currentPlayer.gainDamage();
	    		currentPlayer.removeElements();
	    		
	    		currentTarget.gainStamina();
	    	}  	
	    	
	    	
	    	
	    	
	    	
	    	else if(attack1 == "Kick" && attack2 == "Hook") //Kick laimi pries Hook
	    	{
	    		currentTarget.gainDamage();
	    		currentTarget.removeElements();
	    		
	    		currentPlayer.gainStamina();
	    	}
	    	else if(attack1 == "Hook" && attack2 == "Kick") //Kick laimi pries Hook
	    	{
	    		currentPlayer.gainDamage();
	    		currentPlayer.removeElements();
	    		
	    		currentTarget.gainStamina();
	    	}
	    	
	    	
	    	
	    	
	    	else if(attack1 == "Hook" && attack2 == "Bash") //Hook laimi pries Bash
	    	{
	    		currentTarget.gainDamage();
	    		currentTarget.removeElements();
	    		
	    		currentPlayer.gainStamina();
	    	}
	    	else if(attack1 == "Bash" && attack2 == "Hook") //Hook laimi pries Bash
	    	{
	    		currentPlayer.gainDamage();
	    		currentPlayer.removeElements();
	    		
	    		currentTarget.gainStamina();
	    	}
	    	
	    	
	    	
	    	else
	    	{
	    		currentTarget.gainStamina();
	    		currentPlayer.gainStamina();
	    	}
	    	
	    	
	    	healthBarOne.setValue(currentTarget.getHealth());
	    	staminaBarOne.setValue(currentTarget.getStamina());
	    	
	    	healthBarTwo.setValue(currentPlayer.getHealth());
	    	staminaBarTwo.setValue(currentPlayer.getStamina());
	    	
	    	currentTarget.rearmCheck();
	    	currentPlayer.rearmCheck();
	    	
	    	
	    	//undo logic
	   
	    	
	    	
	    	
	    }

}
