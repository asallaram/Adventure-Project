package com.comp301.a02adventure;

import java.util.List;

public class GameImpl implements Game {
  private final Map map;
  private final Player player;

  public GameImpl(Map map, Player player) {
    if (map == null || player == null) {
      throw new IllegalArgumentException("Map and player cannot be null");
    }
    this.map = map;
    this.player = player;
  }

  @Override
  public Position getPlayerPosition() {
    return player.getPosition();
  }

  @Override
  public String getPlayerName() {
    return player.getName();
  }

  @Override
  public List<Item> getPlayerItems() {
    return player.getInventory().getItems();
  }

  @Override
  public boolean getIsWinner() {
    return getPlayerItems().size() == map.getNumItems();
  }

  @Override
  public void printCellInfo() {
    Cell currentCell = map.getCell(player.getPosition());
    System.out.println("Location: " + currentCell.getName());
    System.out.println(currentCell.getDescription());

    if (currentCell.getIsVisited()) {
      System.out.println("You have already visited this location.");
    }

    if (currentCell.hasChest()) {
      System.out.println("You found a chest! Type 'open' to see what's inside, or keep moving.");
    }

    currentCell.visit();
  }

  @Override
  public void openChest() {
    Cell currentCell = map.getCell(player.getPosition());

    if (currentCell.hasChest()) {
      Inventory chest = currentCell.getChest();
      if (chest.isEmpty()) {
        System.out.println("The chest is empty.");
      } else {
        player.getInventory().transferFrom(chest);
        List<Item> collectedItems = player.getInventory().getItems();
        System.out.println("You collected these items: " + collectedItems);
      }
    } else {
      System.out.println("No chest to open, sorry!");
    }
  }

  @Override
  public boolean canMove(Direction direction) {
    Position newPosition = player.getPosition().getNeighbor(direction);
    int newX = newPosition.getX();
    int newY = newPosition.getY();
    return newX >= 0
        && newX < map.getWidth()
        && newY >= 0
        && newY < map.getHeight()
        && map.getCell(newPosition) != null;
  }

  @Override
  public void move(Direction direction) {
    if (canMove(direction)) {
      player.move(direction);
      printCellInfo();
    } else {
      System.out.println("You can't go that way! Try another direction.");
    }
  }
}
