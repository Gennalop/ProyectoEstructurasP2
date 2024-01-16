/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package util;

import java.util.List;

/**
 *
 * @author Usuario
 */
public class Tree<E> {
    
    private TreeNode<E> root;
    
    public Tree () {
        this.root = null; 
    }
    
    public Tree (E root) {
        this.root = new TreeNode<>(root);
    }
    
    public boolean isEmpty () {
        return this.root == null;
    }

    public E getRoot() {
        return root.getContent();
    }
    
    private TreeNode getRootNode () {
        return this.root;
    }

    private void setRootNode(TreeNode<E> root) {
        this.root = root;
    }
    
    public void setRoot (E content) {
        this.root.setContent(content);
    }
    
    public boolean isLeaf () {
        return this.root.getChildren().isEmpty();
    }
    
    public void setChildren(List<Tree<E>> children) {
        this.root.setChildren(children);
    }
    
    public String toString() {
        return "Raiz[\n" + root + "\nHijos{" + root.getChildren() + "}]";
    }
}
