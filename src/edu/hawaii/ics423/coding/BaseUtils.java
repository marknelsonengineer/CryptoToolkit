/**
 * Copyright (c) Mark Nelson - 2015 - All rights reserved.
 */
package edu.hawaii.ics423.coding;

/**
 * Common utilities for all coding systems.
 *
 * TODO: Rename this class to something better.
 *
 * @author Mark Nelson
 */
public abstract class BaseUtils implements CodingSystem {

  /**
   * Print an integer array to the console.
   *
   * TODO: Make this output nicer.
   *
   * @param intArray
   *          The integer array to display.
   */
  public void printIntArray(final int[] intArray) {
    printIntArray(intArray, "");
  }


  /**
   * Print an integer array to the console.
   *
   * TODO: Improve output to hex-style / two column format.
   *
   * @param intArray
   *          The integer array to display.
   * @param prefix
   *          A string to prepend to each line.
   */
  public void printIntArray(final int[] intArray, String prefix) {
    System.out.print(prefix + "Int array values = ");

    for (int i : intArray) {
      System.out.print(i + " ");
    }

    System.out.print("   \"");
    for (int i : intArray) {
      System.out.print(intToChar(i));
    }

    System.out.println("\"");
  }


  /**
   * Print this base conversion table.
   */
  public void printTable() {
    for (int i = 0; i < this.getCipherBase(); i++) {
      System.out.printf("%2d ", i);
    }
    System.out.println("");
    for (int i = 0; i < this.getCipherBase(); i++) {
      System.out.printf(" %c ", this.intToChar(i));
    }

  }
}
