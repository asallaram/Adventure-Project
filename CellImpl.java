package com.comp301.a02adventure;

public class CellImpl implements Cell {
  private final Position position;
  private String name;
  private String description;
  private Inventory chest;
  private boolean isVisited;

  public CellImpl(int x, int y, String name, String description) {
    if (name == null || description == null) {
      throw new IllegalArgumentException("Name and description cannot be null");
    }
    this.position = new PositionImpl(x, y);
    this.name = name;
    this.description = description;
    this.chest = null;
    this.isVisited = false;
  }

  public CellImpl(int x, int y) {
    this(x, y, "", "");
  }

  @Override
  public String getName() {
    return name;
  }

  @Override
  public void setName(String name) {
    if (name == null) {
      throw new IllegalArgumentException("Name cannot be null");
    }
    this.name = name;
  }

  @Override
  public String getDescription() {
    return description;
  }

  @Override
  public void setDescription(String description) {
    if (description == null) {
      throw new IllegalArgumentException("Description cannot be null");
    }
    this.description = description;
  }

  @Override
  public Position getPosition() {
    return position;
  }

  @Override
  public Inventory getChest() {
    return chest;
  }

  @Override
  public void setChest(Inventory chest) {
    if (chest == null) {
      throw new IllegalArgumentException("Chest cannot be null");
    }
    this.chest = chest;
  }

  @Override
  public boolean getIsVisited() {
    return isVisited;
  }

  @Override
  public boolean hasChest() {
    return chest != null;
  }

  @Override
  public void visit() {
    isVisited = true;
  }
}
