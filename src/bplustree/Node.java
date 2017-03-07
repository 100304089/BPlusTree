/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bplustree;

import java.util.Vector;

/**
 *
 * @author dot
 */
public abstract class Node {
    
    //Data pointers
    protected Vector<DataNode> data;
    //Parent Node
    protected Node parent;
    //Capacity of the Node
    protected int maxsize;
    
    public boolean isLeafNode(){
        return this.getClass().getName().trim().equals("LeafNode");
    }
    
    abstract Node insert(DataNode dnode);
    
    abstract boolean serach(DataNode x);
    
    protected boolean isFull() {
        return data.size() == maxsize - 1;
    }
    
    protected void propagate(DataNode dnode, Node right){
        
        
        
    }
}
