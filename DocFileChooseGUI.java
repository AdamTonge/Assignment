/**************************************************
 *  
 *  A file chooser GUI class for DocuSim
 *  Author: Adam Tonge
 *  2016  
 *  
 * 
 * Comments: I took a premade file chooser class online
 * and molded it and changed it to suit my code and provide
 * functionality.
 * (http://www.tutorialspoint.com/swing/swing_jfilechooser.htm)
 * It saved a lot of time as I already spent some time making
 * a non file chooser GUI.
 ****************************************************/
package com.Assignment;


import java.awt.*;
import java.awt.event.*;
import javax.swing.*;


public class DocFileChooseGUI 
{
   private JFrame mainFrame;
   private JLabel headerLabel;
   private JLabel statusLabel;
   private JPanel controlPanel;
   String doc1 = "";
   String doc2 = "";
   
   
   public DocFileChooseGUI()
   {
      prepareGUI();
   }    

   private void prepareGUI()
   {
        mainFrame = new JFrame("DocuSim");
        mainFrame.setSize(400,400);
        mainFrame.setLayout(new GridLayout(3, 1));
        mainFrame.addWindowListener(new WindowAdapter() 
        {
        @Override
        public void windowClosing(WindowEvent windowEvent)
        {
            System.exit(0);
        }        
        });    
        headerLabel = new JLabel("", JLabel.CENTER);        
        statusLabel = new JLabel("",JLabel.CENTER);    

        statusLabel.setSize(350,100);

        controlPanel = new JPanel();
        controlPanel.setLayout(new FlowLayout());

        mainFrame.add(headerLabel);
        mainFrame.add(controlPanel);
        mainFrame.add(statusLabel);
        mainFrame.setVisible(true); 
        mainFrame.setLocationRelativeTo(null); //centers the frame
   }

   void showFileChooserDemo(){
        headerLabel.setText("Choose 2 files you want to compare the size of: (left first)"); 
        ReadDoc var1 = new ReadDoc();         
                 
        final JFileChooser  fileDialog1 = new JFileChooser();
        JButton showFileDialogButton1 = new JButton("Open File");
        showFileDialogButton1.addActionListener(new ActionListener() 
        {
            @Override
            public void actionPerformed(ActionEvent e) 
            {
                //if the filechooser is clicked, it shows a status
                // and gets the file path of the file chosen
                int returnVal1 = fileDialog1.showOpenDialog(mainFrame);
                if (returnVal1 == JFileChooser.APPROVE_OPTION) 
                {
                    java.io.File file = fileDialog1.getSelectedFile();
                    statusLabel.setText("File Selected :" + file.getName());
                    doc1 = file.getAbsolutePath();                  
                }
                else{
                    statusLabel.setText("Open command cancelled by user." );
                }
            }
        });
        final JFileChooser  fileDialog2 = new JFileChooser();
        JButton showFileDialogButton2 = new JButton("Open File");
        showFileDialogButton2.addActionListener((ActionEvent e) -> 
        {
            //if the filechooser is clicked, it shows a status 
            // and gets the file path of the file chosen
            int returnVal2 = fileDialog2.showOpenDialog(mainFrame);
            if (returnVal2 == JFileChooser.APPROVE_OPTION) {
                java.io.File file = fileDialog2.getSelectedFile();
                statusLabel.setText("File Selected :" + file.getName());
                doc2 = file.getAbsolutePath();
                //System.out.println("File path : " + doc2); 
                var1.CreateList(doc1, doc2);
                mainFrame.setVisible(false);
            }                             
            else{
                 statusLabel.setText("Open command cancelled by user." );
            }     
        });  
        
        controlPanel.add(showFileDialogButton1);
        controlPanel.add(showFileDialogButton2);
        mainFrame.setVisible(true);  
   }

    private String getAbsolutePath() 
    {
        throw new UnsupportedOperationException("Not supported yet."); 
    }
}
