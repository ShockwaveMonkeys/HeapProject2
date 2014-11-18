/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package priorityqueue;

/**
 *
 * @author Luis Barreto
 */
public class Node 
{
    protected Node left;
    protected Node right;
    protected int value; // p
    protected int index;
    
    public Node(int value)
    {
        this.value = value;
        this.index = 0;
    }
    public int hasChildren()
    {
        if (this != null)
        {
            if((this.left != null)&&(this.right != null))
                return 2;
            else if((this.left != null)&&(this.right == null))
                return 1;
            else
                return 0;
        }
        else
            return 0;
    }
    public int smallestOfThree(Node nd)
    {
        if ((nd != null) && (nd.left != null)&& (nd.right != null))
        {
            if (nd.value < nd.left.value && nd.value < nd.right.value) 
            { 
                return nd.value; 
            } else if (nd.left.value < nd.value && nd.left.value < nd.right.value)
            { 
                return nd.left.value;
            } else if (nd.right.value < nd.value && nd.right.value < nd.left.value)
            { 
                return nd.right.value; 
            }
        }
            return nd.value;
    }


    
}
