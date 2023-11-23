package com.comp301.a02adventure;

import java.util.ArrayList;
import java.util.List;

public class InventoryImpl implements Inventory {
  private final List<Item> itemList;

  public InventoryImpl() {
    itemList = new ArrayList<>();
  }

  @Override
  public boolean isEmpty() {
    return itemList.isEmpty();
  }

  @Override
  public int getNumItems() {
    return itemList.size();
  }

  @Override
  public List<Item> getItems() {
    return new ArrayList<>(itemList); // Return a cloned list to prevent external modifications
  }

  @Override
  public void addItem(Item item) {
    itemList.add(item);
  }

  @Override
  public void removeItem(Item item) {
    itemList.remove(item);
  }

  @Override
  public void clear() {
    itemList.clear();
  }

  @Override
  public void transferFrom(Inventory other) {
    for (Item item : other.getItems()) {
      addItem(item);
    }
    other.clear();
  }
}
