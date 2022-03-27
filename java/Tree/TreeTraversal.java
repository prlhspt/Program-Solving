package Tree;

public class TreeTraversal {

    static class Node {
        private int key;
        Node left, right;

        public Node(int item) {
            key = item;
            left = right = null;
        }
    }

    static class BinaryTree {
        Node root;

        public BinaryTree() {
            root = null;
        }

        void printPostorder(Node node) {
            if (node == null)
                return;

            printPostorder(node.left);
            printPostorder(node.right);
            System.out.println(node.key + " ");

        }

        void printInorder(Node node) {
            if (node == null)
                return;

            printInorder(node.left);
            System.out.println(node.key + " ");
            printInorder(node.right);

        }

        void printPreorder(Node node) {
            if (node == null)
                return;

            System.out.println(node.key + " ");
            printPreorder(node.left);
            printPreorder(node.right);

        }

        void printPostorder() {
            printPostorder(root);
        }

        void printInorder() {
            printInorder(root);
        }

        void printPreorder() {
            printPreorder(root);
        }

    }


    public static void main(String[] args) {

        BinaryTree tree = new BinaryTree();
        tree.root = new Node(1);
        tree.root.left = new Node(2);
        tree.root.right = new Node(3);
        tree.root.left.left = new Node(4);
        tree.root.left.right = new Node(5);
        tree.root.right.left = new Node(6);
        tree.root.right.right = new Node(7);

        System.out.println("Preorder Traversal of binary tree is ");
        tree.printPreorder();

        System.out.println("\nPreorder Traversal of binary tree is ");
        tree.printInorder();

        System.out.println("\nPostorder Traversal of binary tree is ");
        tree.printPostorder();
    }
}
