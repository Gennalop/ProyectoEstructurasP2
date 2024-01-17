package util;

import java.util.List;

public class Tree<E> {
    
    private NodeTree<E> root;
    
    public Tree () {
        this.root = null; 
    }
    
    public Tree (E root) {
        this.root = new NodeTree<>(root);
    }
    
    public boolean isEmpty () {
        return this.root == null;
    }

    public E getRoot() {
        return root.getContent();
    }
    
    public void setRoot (E content) {
        this.root.setContent(content);
    }
    
    public NodeTree getRootNode(){
        return this.root;
    }
    
    public void setRootNode(NodeTree<E> root){
        this.root = root;
    }
    
    public boolean isLeaf () {
        return this.root.getChildren().isEmpty();
    }
    
    public List<Tree<E>> getChildren() {
        return this.root.getChildren();
    }
    
    public void setChildren(List<Tree<E>> children) {
        this.root.setChildren(children);
    }
    
    public String toString() {
        return "Raiz[\n" + root + "\nHijos{" + root.getChildren() + "}]";
    }
}