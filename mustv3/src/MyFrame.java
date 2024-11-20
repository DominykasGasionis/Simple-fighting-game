import javax.swing.*;
import javax.swing.border.LineBorder;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

public class MyFrame extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	
	Player player1 = new Player(100, 0);
	Player player2 = new Player(100, 0);
	List<Player> players = new ArrayList<>();
	
	
	CreateJSONFile jsonCreate;
	ReadJSONFile jsonRead;
	 

	public MyFrame(CreateJSONFile jsonCreat, ReadJSONFile jsonRea) 
    {
		
		jsonCreate = jsonCreat;
    	jsonRead = jsonRea;	
		
    	jsonRead.refresh();
    	player1.setName(jsonRead.getPlayerNameOne());
    	player2.setName(jsonRead.getPlayerNameTwo());
		
		players.add(player1);
		players.add(player2);
		
        // Set up the frame
        setTitle("Mustynes");
        setSize(400, 200);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setResizable(false);

        
        
        // Create a panel to hold buttons
        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(3, 1, 5, 15)); 
        panel.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20)); 
        panel.setBackground(Color.GRAY); 
        
        
        
        
        // Create buttons
        JButton Start = new JButton("Start game");
        JButton Settings = new JButton("Settings");
        JButton Exit = new JButton("Exit");

        
        
        
        // Set button background and text color
        Start.setBackground(Color.LIGHT_GRAY); 
        Start.setForeground(Color.BLACK);             
        Start.setBorder(new LineBorder(Color.BLACK, 2)); 
        
        Settings.setBackground(Color.LIGHT_GRAY); 
        Settings.setForeground(Color.BLACK);           
        Settings.setBorder(new LineBorder(Color.BLACK, 2)); 

        Exit.setBackground(Color.LIGHT_GRAY); 
        Exit.setForeground(Color.BLACK);          
        Exit.setBorder(new LineBorder(Color.BLACK, 2)); 
        
        
        
        
        Start.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                dispose(); 
                
                if (jsonRead != null)
                {
                    if ("AI".equals(jsonRead.getGameMode())) new GameAI(players, jsonCreate, jsonRead);
                    else new Game(players, jsonCreate, jsonRead);
                } 
                else 
                {
                    System.err.println("Error: jsonRead is null. Unable to determine game mode.");
                }
            }
        });

        
        
        Settings.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
            	dispose();
            	new Settings(jsonCreate, jsonRead);
        		
            }
        });

        
        
        Exit.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                System.exit(0); // Exit the application
            }
        });

        
        
    
        panel.add(Start);
        panel.add(Settings);
        panel.add(Exit);
        add(panel, BorderLayout.CENTER);
        setVisible(true);
    }
    
    
    
    
    
}