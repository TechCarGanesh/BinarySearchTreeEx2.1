/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.mycompany.binarysearchtreeex2;

/**
 *
 * @author pk914828
 */

/**
   An interface of basic methods for the ADT tree.
   
   @author Frank M. Carrano
   @author Timothy M. Henry
   @version 4.0
*/
public interface TreeInterface<T>
{
   public T getRootData();
   public int getHeight();
   public int getNumberOfNodes();
   public boolean isEmpty();
   public void clear();
} // end TreeInterface
