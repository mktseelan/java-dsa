package BinaryTree;

import java.util.Scanner;

public class BinaryTree {

    private Node root;

    private static class Node{
        public int val;
        public Node right;
        public Node left;

        public Node(){
            this(0);
        }
        public Node(int x){
            this.val = x;
            this.right = null;
            this.left = null;
        }

    }

    public void populateTree(Scanner sc){
        System.out.println("Enter root node value: ");
        int val = sc.nextInt();
        this.root = new Node(val);
        populateTree(sc , root);
    }

    private void populateTree(Scanner sc , Node node){

        System.out.println("Do you want to enter a node to the left of "+node.val + ":");
        String input = sc.next();
        if(input.equals("yes")){
            System.out.println("Enter the value:");
            int val = sc.nextInt();
            node.left = new Node(val);
            populateTree(sc , node.left);
        }
        System.out.println("Do you want to enter a node to the right of "+node.val + ":");
        input = sc.next();
        if(input.equals("yes")){
            System.out.println("Enter the value:");
            int val = sc.nextInt();
            node.right = new Node(val);
            populateTree(sc , node.right);
        }

    }

    public void display(){
        display(root , "");
    }

    private void display(Node node , String indent){
        if(node == null)
            return;
        
        System.out.println(indent + node.val);
        display(node.left , indent + "\t");
        display(node.right , indent + "\t");
    }
}
