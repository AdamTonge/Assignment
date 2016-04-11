/**************************************************
 *  
 *  Class that can read documents and put words into
 *  a list.
 *  Author: Adam Tonge
 *  2016  
 *  
 ****************************************************/

package com.Assignment;
import java.io.File;
import java.util.Scanner;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ReadDoc
{    
    /**
     *
     * @param doc1
     * @param doc2
     */
    public void CreateList(String doc1, String doc2) 
    {
        ArrayList<String> list1 = new ArrayList<>();
        ArrayList<String> list2 = new ArrayList<>();
        
        try 
        {
            Scanner s = new Scanner(new File(doc1)); 
            while(s.hasNext())
            {
                list1.add(s.next());
            }
            Scanner s2 = new Scanner(new File(doc2)); 
            while(s2.hasNext())
            {
                list2.add(s2.next());
            }
        } 
        catch(FileNotFoundException ex) 
        {
            Logger.getLogger(ReadDoc.class.getName()).log(Level.SEVERE, null, ex);
        }
        DocCompare var2 = new DocCompare();
        var2.CompareList(list1, list2);
    
    }
}

