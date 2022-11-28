import java.awt.Graphics;
import java.awt.Graphics2D;

import javax.swing.JComponent;
import javax.swing.JFrame;

public class Snowflake extends JComponent{
	private static Graphics2D g2d;
	
	
	public static void main(String[] args) {
		JFrame mainFrame = new JFrame("Snowflake");
		Snowflake drawing = new Snowflake();
		
		mainFrame.setSize(800,800);
		mainFrame.setLocationRelativeTo(null); //OCD Line
		mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		mainFrame.getContentPane().add(drawing);
		mainFrame.setVisible(true);
		
		
	}	
	
	public void paintComponent(Graphics g) {
		g2d = (Graphics2D) g;
		kTriangle(100,600,400,80,700,600, 15);
		
	}
	
	public void kTriangle(float x1, float y1, float x2, float y2, float x3, float y3, int depth) {
		kLine(x1, y1, x2, y2, depth);
        kLine(x2, y2, x3, y3, depth);
        kLine(x3, y3, x1, y1, depth);
	}
	public void kLine(float x1, float y1,float x2,float y2, int depth) {
		
		if (depth > 0) {
			depth--;
			float q1x = x1+(x2-x1)/3;
			float q1y = y1+(y2-y1)/3;
			float q2x = (float)(x1+(x2-x1)/2+Math.sqrt(3)*(y2-y1)/6);
			float q2y = (float)(y1+(y2-y1)/2-Math.sqrt(3)*(x2-x1)/6);
			float q3x = x2-(x2-x1)/3;
			float q3y = y2-(y2-y1)/3;
			
			kLine((int)x1, (int)y1, q1x, q1y, depth);
			kLine(q1x, q1y, q2x, q2y, depth);
			kLine(q2x, q2y, q3x, q3y, depth);
			kLine(q3x, q3y, (int)x2, (int)y2, depth);
		} else
			g2d.drawLine((int)x1, (int)y1, (int)x2, (int)y2);
		
		
	}
	
	
	
	
	
	
	

}
