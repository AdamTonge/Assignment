/**************************************************
 *  
 *  Class that writes results to a file
 *  a list.
 *  Author: Adam Tonge
 *  2016  
 *  
 ****************************************************/

package com.Assignment;

import java.io.PrintWriter;
import java.util.Set;

public class DocWriteFile 
{

    /**
     *
     * @param set
     */
    public void WriteToFile(Set<String> set)
    {
        try
        {
            PrintWriter myOutFile = new PrintWriter("DocuSimResults.txt");        
            myOutFile.print(set);
            myOutFile.close();
        }
        catch(Exception ex)
        {
            System.out.println("exception " + ex.getMessage() + "caught");
        }
    }
}
