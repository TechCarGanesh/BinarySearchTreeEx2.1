/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.mycompany.binarysearchtreeex2;

/**
 *
 * @author pk914828
 */

import java.util.Iterator;
/**
   An interface of iterators for the ADT tree.
   
   @author Frank M. Carrano
   @author Timothy M. Henry
   @version 4.0
*/
public interface TreeIteratorInterface<T>
{
   public Iterator<T> getPreorderIterator();
   public Iterator<T> getPostorderIterator();
   public Iterator<T> getInorderIterator();
   public Iterator<T> getLevelOrderIterator();
} // end TreeIteratorInterface
