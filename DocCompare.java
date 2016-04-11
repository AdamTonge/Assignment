/**************************************************
 *  
 *  Compare 2 lists 
 *  Author: Adam Tonge
 *  2016  
 *  
 ****************************************************/

package com.Assignment;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class DocCompare  
{
    public void CompareList(ArrayList<String> list1, ArrayList<String> list2)
    {   
        float doc1 = list1.size();
        float doc2 = list2.size();
        //Make an array list with stopwords 
        ArrayList<String> list3 = new ArrayList<>(Arrays.asList("a","an","the","i","me","he","him","she","her","it","we","us","you","they","them","who","what","this","that","these","those","mine","our","his","hers","here","have","thus","their","there","from","which","whether","might"));
        
        //if doc2 has less words
        if(doc2 < doc1)
        {
            int nameDoc1 = 1;
            int nameDoc2 = 2;
            //retain all similar elements in list1 and list2 and put them into list1
            list1.retainAll(list2);
            
            // remove any words that are similar to the stopwords from list 3
            list2.removeAll(list3);
            float num1 = list2.size(); //get size of list 2
        
            list1.removeAll(list3);
            float num2 = list1.size();      
        
            //calculate precentage of similar words then print out
            float percentage = num2/num1;
            percentage = percentage*100;               
            
            DocResultsGUI var1 = new DocResultsGUI();
            var1.PrintResults(percentage, num1, num2, nameDoc1, nameDoc2);  
           
            //turn the list into set so only unique values then send to 
            //write to file method in write file class
            Set<String> set = new HashSet<>(list1);
            DocWriteFile var2 = new DocWriteFile();
            var2.WriteToFile(set);
            
        }
        else //if doc1 has less words
        {
           int nameDoc1 = 2;
           int nameDoc2 = 1;
           list2.retainAll(list1);
           
           list1.removeAll(list3);
           float num1 = list1.size(); //same var name as only one loop will be used
           
           list2.removeAll(list3);
           float num2 = list2.size();
           
           float percentage = num2/num1;
           percentage = percentage*100;
           
           DocResultsGUI var1 = new DocResultsGUI();
           var1.PrintResults(percentage, num1, num2, nameDoc1, nameDoc2); 
           
           
           Set<String> set = new HashSet<>(list2);
           DocWriteFile var2 = new DocWriteFile();
           var2.WriteToFile(set);          
        }
       
        
        
       
       
        
    }      
}