package com.comp301.a02adventure;

public class MapImpl implements Map {
  private final int width;
  private final int height;
  private final int numItems;
  private final Cell[][] grid;

  public MapImpl(int width, int height, int numItems) {
    if (width <= 0 || height <= 0) {
      throw new IllegalArgumentException("Width and height must be positive");
    }
    this.width = width;
    this.height = height;
    this.numItems = numItems;
    this.grid = new Cell[width][height];
  }

  @Override
  public int getWidth() {
    return width;
  }

  @Override
  public int getHeight() {
    return height;
  }

  @Override
  public Cell getCell(int x, int y) {
    if (x < 0 || x >= width || y < 0 || y >= height) {
      throw new IndexOutOfBoundsException("Coordinates are not on the map");
    }
    return grid[x][y];
  }

  @Override
  public Cell getCell(Position position) {
    int x = position.getX();
    int y = position.getY();
    return getCell(x, y);
  }

  @Override
  public void initCell(int x, int y) {
    if (x < 0 || x >= width || y < 0 || y >= height) {
      throw new IndexOutOfBoundsException("Coordinates are not on the map");
    }
    grid[x][y] = new CellImpl(x, y);
  }

  @Override
  public int getNumItems() {
    return numItems;
  }
}
