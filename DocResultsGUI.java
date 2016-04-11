/**************************************************
 *  
 *  Class that can print results to a GUI
 *  a list.
 *  Author: Adam Tonge
 *  2016  
 *  
 ****************************************************/

package com.Assignment;

import java.awt.FlowLayout;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class DocResultsGUI extends JFrame
{
    JLabel label1;
    JLabel label2;
    JLabel label3;
        
    public void PrintResults(float percentage, float num1, float num2, int nameDoc1, int nameDoc2)
    {
        setVisible(true);
        this.setTitle("DocuSim");     
        setLayout(new FlowLayout());
        setLocationRelativeTo(null);
        
        label1 = new JLabel("Document " + nameDoc2 + " has " + num2 + " words out of " + num1 + " overlapping with document " + nameDoc1, JLabel.CENTER);
	add(label1);
        
	label2 = new JLabel("So " + percentage + "% of Document " + nameDoc2 + " is similar to Document " + nameDoc1, JLabel.CENTER);
	add(label2);
        
        label3 = new JLabel("Unique words printed to \"DocuSimResults.txt\"");
        add(label3);
        
        setVisible(true);			
		
	//set size of box
	setSize(400, 400); 
	
	//stops java program running
	setDefaultCloseOperation (EXIT_ON_CLOSE);
		
    }    
}
