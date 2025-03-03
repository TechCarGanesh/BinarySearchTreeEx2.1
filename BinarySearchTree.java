/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.binarysearchtreeex2;

/**
 *
 * @author pk914828
 */
public class BinarySearchTree<T extends Comparable<? super T>>
extends BinaryTree<T> implements SearchTreeInterface<T>
{
    public BinarySearchTree()
    {
        super();
    } // end default constructor

    public BinarySearchTree(T rootEntry)
    {
        super();
        setRootNode(new BinaryNode<>(rootEntry));
    } // end constructor

    public void setTree(T rootData) // Disable setTree (see Segment 25.6)
    {
        throw new UnsupportedOperationException();
    } // end setTree

    public void setTree(T rootData, BinaryTreeInterface<T> leftTree, BinaryTreeInterface<T> rightTree)
    {
        throw new UnsupportedOperationException();
    } // end setTree

        @Override
    public T add(T newEntry)
    {
        T result = null;
        if (isEmpty())
            setRootNode(new BinaryNode<T>(newEntry));
        else
            result = addEntry(getRootNode(), newEntry);
        return result;
    } // end add


    private T addEntry(BinaryNode<T> rootNode, T newEntry)
    {
        assert rootNode != null;
        T result = null;
        int comparison = newEntry.compareTo(rootNode.getData());
        if (comparison == 0)
        {
            result = rootNode.getData();
            rootNode.setData(newEntry);
        }
        else if (comparison < 0)
        {
            if (rootNode.hasLeftChild())
                result = addEntry(rootNode.getLeftChild(), newEntry);
            else
                rootNode.setLeftChild(new BinaryNode<>(newEntry));
        }
        else
        {
            assert comparison > 0;
            if (rootNode.hasRightChild())
                result = addEntry(rootNode.getRightChild(), newEntry);
            else
                rootNode.setRightChild(new BinaryNode<>(newEntry));
        }

        return result;
    }

    public T remove(T entry)
    {
        ReturnObject oldEntry = new ReturnObject(null);
        BinaryNode<T> newRoot = removeEntry(getRootNode(), entry, oldEntry);
        setRootNode(newRoot);

        return oldEntry.get();
    } // end remove

    // Removes an entry from the tree rooted at a given node.
    // rootNode is a reference to the root of a tree.
    // entry is the object to be removed.
    // oldEntry is an object whose data field is null.
    // Returns the root node of the resulting tree; if entry matches
    // an entry in the tree, oldEntry's data field is the entry
    // that was removed from the tree; otherwise it is null.
    private BinaryNode<T> removeEntry(BinaryNode<T> rootNode,
        T entry, ReturnObject oldEntry)
    {
        if (rootNode != null)
        {
            T rootData = rootNode.getData();
            int comparison = entry.compareTo(rootData);
            if (comparison == 0) // entry == root entry
            {
                oldEntry.set(rootData);
                rootNode = removeFromRoot(rootNode);
            }
            else if (comparison < 0) // entry < root entry
            {
                BinaryNode<T> leftChild = rootNode.getLeftChild();
                BinaryNode<T> subtreeRoot = removeEntry(leftChild,
                entry, oldEntry);
                rootNode.setLeftChild(subtreeRoot);
            }
            else // entry > root entry
            {
                BinaryNode<T> rightChild = rootNode.getRightChild();
                rootNode.setRightChild(removeEntry(rightChild, entry, oldEntry));
            } // end if
        } // end if
        return rootNode;
    } // end removeEntry
    
    // Removes the entry in a given root node of a subtree.
    // rootNode is the root node of the subtree.
    // Returns the root node of the revised subtree.
    private BinaryNode<T> removeFromRoot(BinaryNode<T> rootNode)
    {
        // Case 1: rootNode has two children
        if (rootNode.hasLeftChild() && rootNode.hasRightChild())
        {
            // find node with largest entry in left subtree
            BinaryNode<T> leftSubtreeRoot = rootNode.getLeftChild();
            BinaryNode<T> largestNode = findLargest(leftSubtreeRoot);
            // replace entry in root
            rootNode.setData(largestNode.getData());
            // remove node with largest entry in left subtree
            rootNode.setLeftChild(removeLargest(leftSubtreeRoot));
        } // end if
        // Case 2: rootNode has at most one child
        else if (rootNode.hasRightChild())
            rootNode = rootNode.getRightChild();
        else
            rootNode = rootNode.getLeftChild();
            // Assertion: if rootNode was a leaf, it is now null
        return rootNode;
    } // end removeEntry
    
    private BinaryNode<T> findLargest(BinaryNode<T> rootNode)
    {
        if (rootNode.hasRightChild())
            rootNode = findLargest(rootNode.getRightChild());
        return rootNode;
    } // end findLargest
    
    private BinaryNode<T> removeLargest(BinaryNode<T> rootNode)
    {
        if (rootNode.hasRightChild())
        {
            BinaryNode<T> rightChild = rootNode.getRightChild();
            BinaryNode<T> root = removeLargest(rightChild);
            rootNode.setRightChild(root);
        }
        else
            rootNode = rootNode.getLeftChild();
    return rootNode;
    } // end removeLargest

    @Override
    public boolean contains(T entry)
    {
        return getEntry(entry) != null;
    } // end contains

    @Override
    public T getEntry(T entry)
    {
        return findEntry(getRootNode(), entry);
    } // end getEntry
    private T findEntry(BinaryNode<T> rootNode, T entry)
    {
        T result = null;
        if (rootNode != null)
        {
            T rootEntry = rootNode.getData();
            if (entry.equals(rootEntry))
                result = rootEntry;
            else if (entry.compareTo(rootEntry) < 0)
                result = findEntry(rootNode.getLeftChild(), entry);
            else
                result = findEntry(rootNode.getRightChild(), entry);
        } // end if
        return result;
    } // end findEntry




    private class ReturnObject
    {
        private T item;

        private ReturnObject(T entry)
        {
            item = entry;
        } // end constructor

        public T get()
        {
            return item;
        } // end get

        public void set(T entry)
        {
            item = entry;
        } // end set
    } // end ReturnObject
} // end BinarySearchTree


 
