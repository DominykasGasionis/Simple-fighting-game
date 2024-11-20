import java.awt.*;
//import java.awt.event.ActionEvent;
//import java.awt.event.ActionListener;
import java.util.LinkedList;
import javax.swing.*;
import javax.swing.border.LineBorder;

import org.json.simple.JSONObject;

public class Settings extends JFrame {

    private static final long serialVersionUID = 1L;

    JButton button1, button2, showHistoryButton, exitButton;
    JTextField textPlayer1, textPlayer2;
    JCheckBox aiModeCheckBox;
    JLabel labelTitle;

    CreateJSONFile jsonCreate;
    ReadJSONFile jsonRead;
    WinersJSONFile jsonHistory = new WinersJSONFile();

    Settings(CreateJSONFile jsonC, ReadJSONFile jsonR) {
    	
    	jsonCreate = jsonC;
    	jsonRead = jsonR;
    	
        // Frame Settings
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setTitle("Game Settings");
        this.setSize(600, 350);
        this.setLocationRelativeTo(null);
        this.setResizable(false);

        
        
        
        // Main Panel
        JPanel mainPanel = new JPanel();
        mainPanel.setLayout(new BorderLayout(10, 10));
        mainPanel.setBackground(Color.GRAY); 
        mainPanel.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));

        
        
        // Title Label
        labelTitle = new JLabel("Game settings", JLabel.CENTER);
        labelTitle.setFont(new Font("Arial", Font.BOLD, 24));
        labelTitle.setForeground(Color.BLACK);
        mainPanel.add(labelTitle, BorderLayout.NORTH);

        
        
        // Center Panel
        JPanel centerPanel = new JPanel();
        centerPanel.setLayout(new GridLayout(3, 3, 10, 10));
        centerPanel.setBackground(Color.GRAY);
        centerPanel.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));
        

        JLabel labelPlayer1 = createStyledLabel("Player 1 Name:");
        JLabel labelPlayer2 = createStyledLabel("Player 2 Name:");
        JLabel labelMode = createStyledLabel("Game Mode:");

        textPlayer1 = createStyledTextField(jsonRead.getPlayerNameOne());
        textPlayer2 = createStyledTextField(jsonRead.getPlayerNameTwo());

        aiModeCheckBox = new JCheckBox("AI Mode");
        aiModeCheckBox.setForeground(Color.BLACK);
        aiModeCheckBox.setBackground(Color.GRAY);

        button1 = createStyledButton("Save Player 1");
        button2 = createStyledButton("Save Player 2");
        
        showHistoryButton = createStyledButton("Show History");
        exitButton = createStyledButton("Exit");

        centerPanel.add(labelPlayer1);
        centerPanel.add(textPlayer1);
        centerPanel.add(button1);

        centerPanel.add(labelPlayer2);
        centerPanel.add(textPlayer2);
        centerPanel.add(button2);

        centerPanel.add(labelMode);
        centerPanel.add(aiModeCheckBox);

        mainPanel.add(centerPanel, BorderLayout.CENTER);

        
        
        
       
        JPanel footerPanel = new JPanel();
        footerPanel.setBackground(Color.GRAY);
        footerPanel.setLayout(new GridLayout(1, 2, 10, 10));
        footerPanel.add(showHistoryButton);
        footerPanel.add(exitButton);
        footerPanel.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));
        mainPanel.add(footerPanel, BorderLayout.SOUTH);

        
        
        
        this.add(mainPanel);
        this.setVisible(true);
        addActionListeners();
    }

    
    
    private JLabel createStyledLabel(String text) {
        JLabel label = new JLabel(text);
        label.setFont(new Font("Arial", Font.PLAIN, 16));
        label.setForeground(Color.BLACK);
        return label;
    }

    
    
    private JTextField createStyledTextField(String text) {
        JTextField textField = new JTextField(text);
        textField.setPreferredSize(new Dimension(250, 40));
        textField.setForeground(Color.WHITE);
        textField.setBackground(Color.BLACK);
        textField.setCaretColor(Color.WHITE);
        return textField;
    }

    
    
    private JButton createStyledButton(String text) {
        JButton button = new JButton(text);
        button.setBackground(Color.LIGHT_GRAY);
        button.setForeground(Color.BLACK);
        button.setFocusPainted(false);
        button.setFont(new Font("Arial", Font.BOLD, 14));
        button.setBorder(new LineBorder(Color.BLACK, 2));
        return button;
    }

    
    
    private void addActionListeners() {
        button1.addActionListener(e -> {
            String player1Name = textPlayer1.getText().trim();
            if (player1Name.isEmpty()) {
                JOptionPane.showMessageDialog(this, "Player 1 name cannot be empty.", "Error", JOptionPane.ERROR_MESSAGE);
            } else {
                jsonCreate.setPlayerOne(player1Name);
                JOptionPane.showMessageDialog(this, "Player 1 name saved successfully!", "Success", JOptionPane.INFORMATION_MESSAGE);
                jsonRead.refresh();
            }
        });

        button2.addActionListener(e -> {
            String player2Name = textPlayer2.getText().trim();
            if (player2Name.isEmpty()) {
                JOptionPane.showMessageDialog(this, "Player 2 name cannot be empty.", "Error", JOptionPane.ERROR_MESSAGE);
            } else {
                jsonCreate.setPlayerTwo(player2Name);
                JOptionPane.showMessageDialog(this, "Player 2 name saved successfully!", "Success", JOptionPane.INFORMATION_MESSAGE);
                jsonRead.refresh();
            }
        });

        aiModeCheckBox.addActionListener(e -> {
            if (aiModeCheckBox.isSelected()) {
                textPlayer2.setText(jsonRead.getAiName());
                textPlayer2.setEnabled(false);
                jsonCreate.setGameMode("AI");
                button2.doClick();
                jsonRead.refresh();
            } else {
            	textPlayer2.setEnabled(true);
                textPlayer2.setText(jsonRead.getPlayerNameTwo());
                jsonCreate.setGameMode("Two Player"); 
                jsonRead.refresh();
                button2.doClick();
            }
        });

        showHistoryButton.addActionListener(e -> {
            try {
	                LinkedList<JSONObject> history = jsonHistory.getLinkedList();
	                if (history == null || history.isEmpty()) JOptionPane.showMessageDialog(this, "No game history available.", "Game History", JOptionPane.INFORMATION_MESSAGE);
	                else 
	                {
	                    StringBuilder historyText = new StringBuilder();
	                    for (JSONObject record : history) 
	                    {
	                        Object id = record.get("id");
	                        Object name = record.get("name");
	                        String idText = (id != null) ? id.toString() : "Unknown ID";
	                        String nameText = (name != null) ? name.toString() : "Unknown Name";
	                        historyText.append("ID: ").append(idText).append(", Name: ").append(nameText).append("\n");
	                    }
	                    
	                    JOptionPane.showMessageDialog(this, historyText.toString(), "Game History", JOptionPane.INFORMATION_MESSAGE);
	                    
	                }
            	} 
            catch (Exception ex) 
            {
                JOptionPane.showMessageDialog(this, "Failed to load game history: " + ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
                ex.printStackTrace();
            }
        });

        exitButton.addActionListener(e -> {
            dispose();
            new MyFrame(jsonCreate, jsonRead);
            
        });
    }
}
