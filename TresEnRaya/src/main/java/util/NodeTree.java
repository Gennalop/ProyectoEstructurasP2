/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package util;

/**
 *
 * @author Usuario
 */
import java.util.LinkedList;
import java.util.List;

class TreeNode<E> {
    
    private E content;
    private List<Tree<E>> children;

    public TreeNode(E content) {
        this.content = content;
        this.children = null;
    }

    public E getContent() {
        return content;
    }

    public void setContent(E content) {
        this.content = content;
    }

    public List<Tree<E>> getChildren() {
        return children;
    }

    public void setChildren(List<Tree<E>> children) {
        this.children = children;
    }
    
    public String toString() {
        return content.toString();
    }
     
}
