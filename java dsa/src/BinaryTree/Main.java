package BinaryTree;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        BinaryTree bt = new BinaryTree();
        Scanner sc = new Scanner(System.in);

        bt.populateTree(sc);

        bt.display();

    }
}
