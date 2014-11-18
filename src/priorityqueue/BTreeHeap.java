package priorityqueue;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */



import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;


/**
 *
 * @author Luis Barreto
 */
public class BTreeHeap 
{
    private Node root;
    private int counter = 1;
    private Node swapNode;
    private int tempInt;
    
    public Node getRoot()
    {
        return this.root;
    }
    public BTreeHeap(int value)
    {
        this.root = new Node(value);
    }
    public void indexHeap(Node n)
    {
       // ArrayList<Integer> output = new ArrayList<Integer>();
        Queue<Node> queue =  new LinkedList<Node>();
        counter = 1;
        queue.add(n);
        int node = 1; //because at root
        int child = 0; //initialize it with 0 
        while(queue.size() != 0)
        {
            Node n1 = queue.remove();
            node--;
            //output.add(n1.value);
            n1.index = counter;
            
            if(n1.left !=null)
            {
                queue.add(n1.left);
                child ++;
            }
            if(n1.right != null)
            {
                queue.add(n1.right);
                child ++;
            }
            if( node == 0)
            {
                node = child ;
                child = 0;
            }
            counter++;
        }
        //System.out.print(output);
      //  for(int i =0; i < output.size(); i++)
      //  {
       //     System.out.print(output.get(i)+" ");
      //  }
      //  System.out.println();
      //  output = null;
    }
    public void printHeap(Node n)
    {
        ArrayList<String> output = new ArrayList<String>();
        Queue<Node> queue =  new LinkedList<Node>();
        
        queue.add(n);
        int node = 1; //because at root
        int child = 0; //initialize it with 0 
        while(queue.size() != 0)
        {
            Node n1 = queue.remove();
            node--;
            output.add("["+ n1.value+" "+n1.index+"]");
            if(n1.left !=null)
            {
                queue.add(n1.left);
                child ++;
            }
            if(n1.right != null)
            {
                queue.add(n1.right);
                child ++;
            }
            if( node == 0)
            {
                node = child ;
                child = 0;
            }
        }
        //System.out.print(output);
        for(int i =0; i < output.size(); i++)
        {
            System.out.print(output.get(i)+" ");
        }
        System.out.println();
        output = null;
}
    public void insert(Node nd, int value)
    {
        if(nd.left != null)
        {
            if(nd.right != null)
            {
                if (nd.left.hasChildren()>1)
                    insert(nd.right, value);
                else
                    insert(nd.left, value);
            }
            else
            {
                nd.right = new Node(value);
            }
        }
        else
        {
            nd.left = new Node(value);
        }
    }
    public void heapify(Node nd)
    {
        int x;
        if (nd != null)
        {
            if ((nd.left != null)&&(nd.right != null))
            {
                x = nd.smallestOfThree(nd);
                if (nd.left.value == x) 
                {
                    nd.left.value = nd.value;
                    nd.value = x;
                    heapify(nd.left);
                    heapify(nd.right);
                }
                else if (nd.right.value == x)
                {
                    nd.right.value = nd.value;
                    nd.value = x;
                    heapify(nd.right);
                    heapify(nd.left);
                }
            }
            else if ((nd.left != null)&&(nd.right == null))
            {
                //x = nd.smallestOfThree(nd);
                if (nd.left.value < nd.value) 
                {
                    x = nd.left.value;
                    nd.left.value = nd.value;
                    nd.value = x;
                    heapify(nd.left);
                }
            }
            else if ((nd.left == null)&&(nd.right == null))
            {
                return;
            }
        }
    }
    
    // @author Younggun Chung
    // buildArray, deleteMin, decreaseKey, increaseKey, delete
    
    public void buildArray(Node nd){
    	ArrayList<Integer> output = new ArrayList<Integer>();
    	ArrayList<Integer> index = new ArrayList<Integer>();
    	
        Queue<Node> queue =  new LinkedList<Node>();
        
        queue.add(nd);
        int node = 1; //because at root
        int child = 0; //initialize it with 0 
        while(queue.size() != 0)
        {
            Node n1 = queue.remove();
            node--;
            output.add(n1.value);
            index.add(n1.index);
            if(n1.left !=null)
            {
                queue.add(n1.left);
                child ++;
            }
            if(n1.right != null)
            {
                queue.add(n1.right);
                child ++;
            }
            if( node == 0)
            {
                node = child ;
                child = 0;
            }
        }
        //System.out.print(output);
        for(int i =0; i < output.size(); i++)
        {
            if(output.get(i) > 511){
            	break;
            }
        	
        	if(output.get(i) == -1){
            	i++;
            }
            else{
            		System.out.print(output.get(i)+" ");
            }
            
        }
        System.out.println();
        output = null;
    }
    
    public void deleteMin(Node nd){
    	if(nd != null){
    		nd.setValue(512);    		
    		
    		heapify(nd);
    		indexHeap(nd);
    	}
    }
    
    public void decreaseKey(Node nd, int p, int delta){
    	if(nd != null){
    		if((delta-p) < 1){
    			delta = 1;
    		}
    		
    		if(nd.index == delta){
    			nd.setIndex(nd.getIndex()+30);
    			
    			if((nd.left != null) || (nd.right != null)){
    				setDecIndex(nd.left, delta);
    				setDecIndex(nd.right, delta);
    			}
    		}
    		else{
    			if((nd.left != null) || (nd.right != null)){
    				decreaseKey(nd.left, p, delta);
    				decreaseKey(nd.right, p, delta);
    			}
    		}
    		
    	}
    }
   
	public void setDecIndex(Node nd, int delta){
		if(nd != null){
			if((nd.left != null) || (nd.right != null)){
				nd.setIndex(nd.getIndex()+30);
				setDecIndex(nd.left, delta);
				setDecIndex(nd.right, delta);
			}
		}
	}
	
	public void decreaseDone(Node nd, int p, int delta){
    	if(nd != null){
    		if((delta-p) < 1){
    			delta = 1;
    		}
    		
    		if(nd.index == p){
    			nd.setIndex(p-delta);
    		}	
    		else{
    			if((nd.left != null) || (nd.right != null)){
    				decreaseDone(nd.left, p, delta);
    				decreaseDone(nd.right, p, delta);
    			}
    		}
    		
    	}
    }
	
    
    
    public void increaseKey(Node nd, int p, int delta){
    	if(nd != null){
    		
    		
    	}
    }
    
    public void delete(Node nd, int p){
    	if(nd != null){
    		
    		if(nd.getIndex() == p){
    			nd.setValue(512);
    			
        		heapify(nd);
        		indexHeap(nd);
    		}
    		else{
    			if((nd.left != null) || (nd.right != null)) {
    				delete(nd.left, p);
    				delete(nd.right, p);
    			}
    		}
    	}
    }
    
}
