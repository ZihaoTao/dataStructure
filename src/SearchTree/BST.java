package SearchTree;

import LinearSort.SortTestHelper;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Created by tino on 1/15/19.
 */

//O(logn) unbalanced: degradation
public class BST {
    private class Node{
        private int key;
        private int value;
        private Node left;
        private Node right;
        private Node(int key, int value) {
            this.key = key;
            this.value = value;
        }
    }

    Node root;
    int count;
    public BST() {
        root = null;
        count = 0;
    }

    public int size() {
        return count;
    }

    public boolean isEmpty() {
        return count == 0;
    }
    // ------------------------------------------------------------
    public void insert(int key, int value) {
        root = insert(root, key, value);
    }

    private Node insert(Node node, int key, int value) {
        if(node == null) {
            count ++;
            return new Node(key, value);
        }
        if(key == node.key) {
            node.value = value;
        } else if(key < node.key) {
            node.left = insert(node.left, key, value);
        } else {
            node.right = insert(node.right, key, value);
        }
        return node;
    }
    // ------------------------------------------------------------
    public boolean contain (int key) {
        return contain(root, key);
    }

    private boolean contain(Node node, int key) {
        if(node == null) {
            return false;
        }
        if(node.key == key) {
            return true;
        } else if(key < node.key) {
            return contain(node.left, key);
        } else {
            return contain(node.right, key);
        }
    }
    // ------------------------------------------------------------
    public int[] search (int key) {
        return search(root, key);
    }

    private int[] search(Node node, int key) {
        if(node == null) {
            return null;
        }
        int[] res = new int[1];
        if(key == node.key) {
            res[0] = node.value;
            return res;
        } else if(key < node.key) {
            return search(node.left, key);
        } else {
            return search(node.right, key);
        }
    }
    // ------------------------------------------------------------
    public void preOrder() {
        preOrder(root);
    }

    private void preOrder(Node node) {
        if(node == null) {
            return;
        }

        System.out.println(node.key);
        preOrder(node.left);
        preOrder(node.right);
    }
    // ------------------------------------------------------------
    public void inOrder() {
        inOrder(root);
    }

    private void inOrder(Node node) {
        if(node == null) {
            return;
        }
        inOrder(node.left);
        System.out.println(node.key);
        inOrder(node.right);
    }
    // ------------------------------------------------------------
    public void postOrder() {
        postOrder(root);
    }

    private void postOrder(Node node) {
        if(node == null) {
            return;
        }
        postOrder(node.left);
        postOrder(node.right);
        System.out.println(node.key);
    }
    // ------------------------------------------------------------
    public void levelOrder() {
        Queue<Node> q = new LinkedList<>();
        q.add(root);
        while(!q.isEmpty()) {
            Node node = q.remove();
            System.out.println(node.key);
            if(node.left != null) {
                q.add(node.left);
            }
            if(node.right != null) {
                q.add(node.right);
            }
        }
    }
    // ------------------------------------------------------------
    public int minimum() {
        assert(count > 0);
        return minimum(root).key;
    }

    private Node minimum(Node node) {
        if(node.left == null) {
            return node;
        }
        return minimum(node.left);
    }
    // ------------------------------------------------------------
    public void removeMin() {
        if(root != null) {
            root = removeMin(root);
        }
    }

    private Node removeMin(Node node) {
        if(node.left == null) {
            count--;
            return node.right;
        }
        node.left = removeMin(node.left);
        return node;
    }
    // ------------------------------------------------------------
    public int maximum() {
        assert(count > 0);
        return maximum(root).key;
    }

    private Node maximum(Node node) {
        if(node.right == null) {
            return node;
        }
        return maximum(node.right);
    }
    // ------------------------------------------------------------
    public void removeMax() {
        if(root != null) {
            root = removeMax(root);
        }
    }

    private Node removeMax(Node node) {
        if(node.right == null) {
            count--;
            return node.left;
        }
        node.right = removeMax(node.right);
        return node;
    }
    // ------------------------------------------------------------
    public void remove(int key) {
        root = remove(root, key);
    }

    private Node remove(Node node, int key) {
        if(node == null) {
            return null;
        }
        if(key < node.key) {
            node.left = remove(node.left, key);
            return node;
        } else if(key > node.key) {
            node.right = remove(node.right, key);
            return node;
        } else { // key == key.node
            if(node.left == null) {
                count--;
                return node.right;
            }
            if(node.right == null) {
                count--;
                return node.left;
            }
            Node successor = minimum(node.right);
            successor.right = removeMin(node.right);
            successor.left = node.left;
            return successor;
        }
    }
    // ------------------------------------------------------------


    public static void main(String[] args) {
        int n = 10;
        int[] arr = SortTestHelper.generateRandomUniqueArray(n, 0, n);
        BST bst = new BST();
        for(int i = 0; i < arr.length; i++) {
            bst.insert(arr[i], i);
        }
        bst.remove(5);
    }


}
