package com.abdullah.Servers;
    // AVL Tree Implementation
    public class AVL {
        Node root;

        public void insert(int serverId) {
            root = insert(serverId, root);
        }

        private Node insert(int val, Node node) {
            if (node == null) {
                return new Node(val);
            }
            if (val > node.data) {
                node.right = insert(val, node.right);
            } else if (val < node.data) {
                node.left = insert(val, node.left);
            } else {
                return node;
            }

            node.height = Math.max(height(node.left), height(node.right)) + 1;

            int balanceFactor = getBalance(node);

            if (balanceFactor > 1 && val < node.left.data) {
                return rightRotate(node);
            }
            if (balanceFactor < -1 && val > node.right.data) {
                return leftRotate(node);
            }
            if (balanceFactor > 1 && val > node.left.data) {
                node.left = leftRotate(node.left);
                return rightRotate(node);
            }
            if (balanceFactor < -1 && val < node.right.data) {
                node.right = rightRotate(node.right);
                return leftRotate(node);
            }

            return node;
        }

        public Node leftRotate(Node node) {
            Node y = node.right;
            Node t2 = y.left;
            y.left = node;
            node.right = t2;
            node.height = Math.max(height(node.left), height(node.right)) + 1;
            y.height = Math.max(height(y.left), height(y.right)) + 1;
            return y;
        }

        public Node rightRotate(Node node) {
            Node y = node.left;
            Node t2 = y.right;
            y.right = node;
            node.left = t2;
            node.height = Math.max(height(node.left), height(node.right)) + 1;
            y.height = Math.max(height(y.left), height(y.right)) + 1;
            return y;
        }

        public int height(Node node) {
            if (node == null)
                return 0;
            return node.height;
        }

        public int getBalance(Node node) {
            if (node == null)
                return 0;
            return height(node.left) - height(node.right);
        }

        public void inOrder() {
            inOrder(root);
        }

        private void inOrder(Node node) {
            if (node != null) {
                inOrder(node.left);
                System.out.print(node.data + " ");
                inOrder(node.right);
            }
        }
        public void delete(int serverId) {
            root = delete(serverId, root);
        }

        private Node delete(int val, Node node) {
            if (node == null) {
                return null;
            }

            if (val < node.data) {
                node.left = delete(val, node.left);
            } else if (val > node.data) {
                node.right = delete(val, node.right);
            } else {
                if (node.left == null || node.right == null) {
                    Node temp = (node.left != null) ? node.left : node.right;

                    if (temp == null) {
                        return null;
                    } else {
                        return temp;
                    }
                } else {
                    Node successor = getMinValueNode(node.right);
                    node.data = successor.data;
                    node.right = delete(successor.data, node.right);
                }
            }

            node.height = Math.max(height(node.left), height(node.right)) + 1;

            int balanceFactor = getBalance(node);

            if (balanceFactor > 1 && getBalance(node.left) >= 0) {
                return rightRotate(node);
            }
            if (balanceFactor > 1 && getBalance(node.left) < 0) {
                node.left = leftRotate(node.left);
                return rightRotate(node);
            }
            if (balanceFactor < -1 && getBalance(node.right) <= 0) {
                return leftRotate(node);
            }
            if (balanceFactor < -1 && getBalance(node.right) > 0) {
                node.right = rightRotate(node.right);
                return leftRotate(node);
            }

            return node;
        }

        private Node getMinValueNode(Node node) {
            Node current = node;
            while (current.left != null) {
                current = current.left;
            }
            return current;
        }
        static class Node {
            int data;
            int height;
            Node left;
            Node right;

            public Node(int data) {
                this.data = data;
                this.height = 1;
            }
        }
    }
