
package priorityqueue;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

/**
 *
 * @author Luis Barreto
 */
public class PriorityQueue 
{
    static BTreeHeap  myHeap;
    /**
    * @param args
    */
    public static void main(String[] args) throws FileNotFoundException, IOException 
    {
    	//String inputFile = 
    	//String[] data = 
    	
    	
        
        Node root = myHeap.getRoot();
        myHeap.insert(root, 1);

        myHeap.insert(root, 6);
 
        myHeap.insert(root, 8);

        myHeap.insert(root, 4);
        myHeap.insert(root, 3);
        myHeap.insert(root, 10);
        myHeap.insert(root, 9);
        myHeap.printHeap(root);
        myHeap.heapify(root);
        myHeap.printHeap(root);
        myHeap.indexHeap(root);
        myHeap.printHeap(root);
        //myHeap.increaseKey(9,1);
        //myHeap.findNode(12);
        
        
    }//main
}//class    
        