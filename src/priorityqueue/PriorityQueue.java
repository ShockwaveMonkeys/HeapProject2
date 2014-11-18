
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
    //static BTreeHeap  myHeap;
    /**
    * @param args
    */
    public static void main(String[] args) throws FileNotFoundException, IOException 
    {
    	BTreeHeap myHeap;
    	String inputFile = "/Users/kaya/Documents/LunaWorkspace/Heap/src/priorityqueue/input.txt";
    	String scriptFile = "/Users/kaya/Documents/LunaWorkspace/Heap/src/priorityqueue/script.txt";
    	String[] data;
    	String[] instructions;
    	int index = 0;
    	ManageText mt = new ManageText();
    	Node root;
    	
    	
    	
    	
    	data = mt.readInput(inputFile);
    	instructions = mt.readScript(scriptFile);
    	myHeap = new BTreeHeap(Integer.parseInt(data[index]));
    	root = myHeap.getRoot();
    	for(index = 1; index < data.length; index++)
    	{
    		myHeap.insert(root, Integer.parseInt(data[index]));
    	}
    	System.out.println("--heap print--");
    	myHeap.printHeap(root);
    	
    	
    	
    	
    	for(int i = 0; i < instructions.length ; i++)
    	{
    		mt.determineMethod(instructions[i], myHeap, root );
    	}
    	System.out.println("------heap print------");
    	myHeap.printHeap(root);
    	
    	
    	
    	
    	for(int i = 0; i<data.length;i++)
    	{
    		System.out.println("data = " + data[i]);
    		
    	}
    	for(int i = 0; i < instructions.length; i++)
    	{
    		System.out.printf("\n %d = " + instructions[i], i);	
    	}
    	
    	
    	
    	
    	
    	
    	//String[] data = 
    	
    	
        
        /*Node root = myHeap.getRoot();
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
        */
        
    }//main
}//class    
        