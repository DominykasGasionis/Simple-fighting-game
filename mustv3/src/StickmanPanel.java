import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

class StickmanPanel extends JPanel {
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	
	private int stickmanX; 
    private int stickmanY; 
    
    private int stickmanZ;
    private int stickmanQ;
    
    private final int STEP_SIZE = 5; 
    
    private Timer timer;
    

    public StickmanPanel() {
    	
        this.stickmanX = 70; 
        this.stickmanY = 150; 
        
        this.stickmanZ = 500; 
        this.stickmanQ = 150; 
    }

    public void startMoving() {
    	
    	int tempX = stickmanX;
    	int tempZ = stickmanZ;
    	
        if (timer == null || !timer.isRunning()) {
            timer = new Timer(10, new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    stickmanX += STEP_SIZE;
                    stickmanZ -= STEP_SIZE;
                    repaint();

                    // Stop the timer when the stickman reaches the max distance
                    if (stickmanX >= 260) {
                        timer.stop();
                        stickmanX = tempX;
                        stickmanZ = tempZ;
                        repaint();
                    }
                }
            });
            timer.start(); // Start the timer
        }
              
    }

    
    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g); 
        drawStickman(g, stickmanX, stickmanY); 
        
        drawStickman(g, stickmanZ, stickmanQ); 
    }

    private void drawStickman(Graphics g, int x, int y) {
       
        g.setColor(Color.BLACK);

   
        g.drawOval(x - 15, y - 40, 30, 30); 

      
        g.drawLine(x, y - 10, x, y + 40); 

  
        g.drawLine(x - 30, y + 10, x + 30, y + 10); 

        // Draw the legs
        g.drawLine(x, y + 40, x - 20, y + 80); 
        g.drawLine(x, y + 40, x + 20, y + 80); 
    }
}


