/**
 * Copyright (c) Mark Nelson - 2015 - All rights reserved.
 */
package edu.hawaii.ics423.math;

/**
 * An (x, y) coordinate pair. Used in the Playfair Cipher.
 *
 * @author Mark nelson
 */
public class Coordinate {

  /** The x coordinate. */
  public int x;

  /** The y coordinate. */
  public int y;


  /**
   * Create an x, y pair.
   * 
   * @param inX
   *          The x coordinate.
   * @param inY
   *          The y coordinate.
   */
  public Coordinate(final int inX, final int inY) {
    this.x = inX;
    this.y = inY;
  }
}
