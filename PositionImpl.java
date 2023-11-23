package com.comp301.a02adventure;

public class PositionImpl implements Position {
  private final int x;
  private final int y;

  public PositionImpl(int x, int y) {
    this.x = x;
    this.y = y;
  }

  @Override
  public int getX() {
    return x;
  }

  @Override
  public int getY() {
    return y;
  }

  @Override
  public Position getNeighbor(Direction direction) {
    int newX = x;
    int newY = y;

    switch (direction) {
      case NORTH:
        newY++;
        break;
      case SOUTH:
        newY--;
        break;
      case EAST:
        newX++;
        break;
      case WEST:
        newX--;
        break;
    }

    return new PositionImpl(newX, newY);
  }
}
