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
        
        if (parent == null){
            
            TreeNode newparent = new TreeNode(maxsize);
            
            newparent.data.add(dnode);
            newparent.pointer.add(this);
            newparent.pointer.add(right);
            
            this.setParent(newparent);
            right.setParent(newparent);
            
            
        } else {
            
            if (! parent.isFull()){
                
                boolean dnodeinserted = false;
                
                for (int i = 0; !dnodeinserted && i < parent.data.size(); i++){
                    
                    if (((DataNode) parent.data.elementAt(i)).inOrder(dnode))
                        
                        parent.data.add(i, dnode);
                    
                        ((TreeNode) parent).pointer.add(i+1, right);
                        
                        dnodeinserted = true;
                    
                }
                
            }
            
        }
        
    }
    
    public int size(){
        return data.size();
    }
    
    Node(int degree){
        parent = null;
        
        data = new Vector();
        maxsize = degree;
    }
}
