/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.binarysearchtreeex2;

/*
Name: Ganesh Kumar
Instructor: Professor Miraseid Abolghasemi
Team Name: TheBugatti
Date: 03/01/2025
Project Information: Create a class BinaryTree. 
A class that implements the ADT binary tree.
*/

/**
 *
 * @author pkuma
 */
import java.util.Iterator;
import java.util.NoSuchElementException;


/**
 *
 * @author Ganesh Kumar
 */
// BinaryTree implements the BinaryTreeInterface
public class BinaryTree<T> implements BinaryTreeInterface<T>
{
    private BinaryNode<T> root;
    
    public BinaryTree()
    {
        root = null;
    } // end default constructor

    public BinaryTree(T rootData)
    {
        root = new BinaryNode<>(rootData);
    } // end constructor

    // Construct with root, leftTree, and rightTree.
    public BinaryTree(T rootData, BinaryTree<T> leftTree,
    BinaryTree<T> rightTree)
    {
        privateSetTree(rootData, leftTree, rightTree);
    } // end constructor

    // Set binary tree root data.
    public void setTree(T rootData)
    {
        root = new BinaryNode<>(rootData);
    } // end setTree

    // Set binary tree root data.
    public void setTree(T rootData, BinaryTreeInterface<T> leftTree,
    BinaryTreeInterface<T> rightTree)
    {
        privateSetTree(rootData, (BinaryTree<T>)leftTree,
        (BinaryTree<T>)rightTree);
    } // end setTree

    private void privateSetTree(T rootData, BinaryTree<T> leftTree,
    BinaryTree<T> rightTree)
    {
        root = new BinaryNode<>(rootData);

        if ((leftTree != null) && !leftTree.isEmpty())
        root.setLeftChild(leftTree.root);

        if ((rightTree != null) && !rightTree.isEmpty())
        {
            if (rightTree != leftTree)
                root.setRightChild(rightTree.root);
            else
                root.setRightChild(rightTree.root.copy());
        } // end if

        if ((leftTree != null) && (leftTree != this))
            leftTree.clear();

        if ((rightTree != null) && (rightTree != this))
            rightTree.clear();
    } // end privateSetTree
    
    // Return root data.
    public T getRootData()
    {
        T rootData = null;
        if (root != null)
            rootData = root.getData();
        return rootData;
    } // end getRootData
    
    // Return true if empty, else return false.
    public boolean isEmpty()
    {
        return root == null;
    } // end isEmpty
    
    // Set root to null.
    public void clear()
    {
        root = null;
    } // end clear
    
    // Set the root data.
    protected void setRootData(T rootData)
    {
        root.setData(rootData);
    } // end setRootData
    
    // Set the root node.
    protected void setRootNode(BinaryNode<T> rootNode)
    {
        root = rootNode;
    } // end setRootNode
    
    // Return root.
    protected BinaryNode<T> getRootNode()
    {
        return root;
    } // end getRootNode
    
    // InorderIterator
    public Iterator<T> getInorderIterator()
    {
        return new InorderIterator();
    } // end getInorderIterator
    public Iterator<T> getPostorderIterator()
    {
        return new PostorderIterator();
    } // end getPostorderIterator
    public Iterator<T> getPreorderIterator()
    {
        return new PreorderIterator();
    } // end getPreorderIterator
    public Iterator<T> getLevelOrderIterator()
    {
        return new LevelOrderIterator();
    }
    public int getHeight()
    {
        return root.getHeight();
    } // end getHeight
    public int getNumberOfNodes()
    {
        return root.getNumberOfNodes();
    } // end getNumberOfNodes 

    private class PreorderIterator implements Iterator<T>
    {
        private StackInterface<BinaryNode<T>> nodeStack;

        public PreorderIterator()
        {
            nodeStack = new LinkedStack<>();
            if (root != null)
                nodeStack.push(root);
        } // end default constructor

        public boolean hasNext()
        {
            return !nodeStack.isEmpty();
        } // end hasNext

        public T next()
        {
            BinaryNode<T> nextNode;

            if (hasNext())
            {
                nextNode = nodeStack.pop();
                BinaryNode<T> leftChild = nextNode.getLeftChild();
                BinaryNode<T> rightChild = nextNode.getRightChild();

            // Push into stack in reverse order of recursive calls
            if (rightChild != null)
                nodeStack.push(rightChild);

            if (leftChild != null)
                nodeStack.push(leftChild);
            }
            else
            {
                throw new NoSuchElementException();
            }

            return nextNode.getData();
        } // end next

        public void remove()
        {
            throw new UnsupportedOperationException();
        } // end remove
    } // end PreorderIterator

    public void iterativePreorderTraverse()
    {
        StackInterface<BinaryNode<T>> nodeStack = new LinkedStack<>();
        if (root != null)
            nodeStack.push(root);
        BinaryNode<T> nextNode;
        while (!nodeStack.isEmpty())
        {
            nextNode = nodeStack.pop();
            BinaryNode<T> leftChild = nextNode.getLeftChild();
            BinaryNode<T> rightChild = nextNode.getRightChild();

        // Push into stack in reverse order of recursive calls
        if (rightChild != null)
            nodeStack.push(rightChild);

        if (leftChild != null)
            nodeStack.push(leftChild);

    System.out.print(nextNode.getData() + " ");
        } // end while
    } // end iterativePreorderTraverse

    private class InorderIterator implements Iterator<T>
    {
        private StackInterface<BinaryNode<T>> nodeStack;
        private BinaryNode<T> currentNode;
        public InorderIterator()
        {
            nodeStack = new LinkedStack<>();
            currentNode = root;
        } // end default constructor
        public Iterator<T> getInorderIterator() {
            return new InorderIterator();
        }
        public boolean hasNext()
        {
            return !nodeStack.isEmpty() || (currentNode != null);
        } // end hasNext
        public T next()
        {
            BinaryNode<T> nextNode = null;
            // Find leftmost node with no left child
            while (currentNode != null)
            {
                nodeStack.push(currentNode);
                currentNode = currentNode.getLeftChild();
            } // end while
            // Get leftmost node, then move to its right subtree
            if (!nodeStack.isEmpty())
            {
                nextNode = nodeStack.pop();
                assert nextNode != null; // Since nodeStack was not empty
                // before the pop
                currentNode = nextNode.getRightChild();
            }
            else
                throw new NoSuchElementException();
            return nextNode.getData();
        } // end next
        public void remove()
        {
            throw new UnsupportedOperationException();
        } // end remove
    } // end InorderIterator
    public void iterativeInorderTraverse()
    {
        StackInterface<BinaryNode<T>> nodeStack = new LinkedStack<>();
        BinaryNode<T> currentNode = root;
        while (!nodeStack.isEmpty() || (currentNode != null))
        {
            // Find leftmost node with no left child
            while (currentNode != null)
            {
                nodeStack.push(currentNode);
                currentNode = currentNode.getLeftChild();
            } // end while
            // Visit leftmost node, then traverse its right subtree
            if (!nodeStack.isEmpty())
            {
                BinaryNode<T> nextNode = nodeStack.pop();
                assert nextNode != null; // Since nodeStack was not empty
                // before the pop
                System.out.print(nextNode.getData() + " ");
                currentNode = nextNode.getRightChild();
            } // end if
        } // end while
    } // end iterativeInorderTraverse

    private class PostorderIterator implements Iterator<T>
    {
        private StackInterface<BinaryNode<T>> nodeStack;
        private BinaryNode<T> currentNode;
        
        public PostorderIterator()
        {
            nodeStack = new LinkedStack<>();
            currentNode = root;
        } // end default constructor
        
        public Iterator<T> getPostorderIterator() {
            return new PostorderIterator();
        }
        
        public boolean hasNext()
        {
            return !nodeStack.isEmpty() || (currentNode != null);
        } // end hasNext
        public T next()
        {
            BinaryNode<T> leftChild, rightChild, nextNode = null;
            // Find leftmost leaf
            while (currentNode != null)
            {
                nodeStack.push(currentNode);
                leftChild = currentNode.getLeftChild();
                if (leftChild == null)
                    currentNode = currentNode.getRightChild();
                else
                    currentNode = leftChild;
            } // end while

            // Stack is not empty either because we just pushed a node, or
            // it wasn't empty to begin with since hasNext() is true.
            // But Iterator specifies an exception for next() in case
            // hasNext() is false.
            if (!nodeStack.isEmpty())
            {
                nextNode = nodeStack.pop();
                // nextNode != null since stack was not empty before pop
                BinaryNode<T> parent = null;
                if (!nodeStack.isEmpty())
                {
                    parent = nodeStack.peek();
                    if (nextNode == parent.getLeftChild())
                        currentNode = parent.getRightChild();
                    else
                        currentNode = null;
                }
                else
                    currentNode = null;
            }
            else
            {
                throw new NoSuchElementException();
            } // end if
            return nextNode.getData();
        } // end next
        public void remove()
        {
            throw new UnsupportedOperationException();
        } // end remove
    } // end PostorderIterator
    private class LevelOrderIterator implements Iterator<T>
    {
        private QueueInterface<BinaryNode<T>> nodeQueue;
        public LevelOrderIterator()
        {
            nodeQueue = new LinkedQueue<>();
            if (root != null)
                nodeQueue.enqueue(root);
        } // end default constructor
        
        public Iterator<T> getLevelOrderIterator() {
            return new LevelOrderIterator();
        }
        public boolean hasNext()
        {
            return !nodeQueue.isEmpty();
        } // end hasNext
        public T next()
        {
            BinaryNode<T> nextNode;
            if (hasNext())
            {
                nextNode = nodeQueue.dequeue();
                BinaryNode<T> leftChild = nextNode.getLeftChild();
                BinaryNode<T> rightChild = nextNode.getRightChild();
                // Add to queue in order of recursive calls
                if (leftChild != null)
                    nodeQueue.enqueue(leftChild);
                if (rightChild != null)
                    nodeQueue.enqueue(rightChild);
            }
            else
            {
                throw new NoSuchElementException();
            }
            return nextNode.getData();
        } // end next
        public void remove()
        {
            throw new UnsupportedOperationException();
        } // end remove
    } // end LevelOrderIterator
} // end BinaryTree
