package com.webforj.demo.pages.sections.dashboard.widgets.todo.model;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
import java.util.ArrayList;
import java.util.List;

public final class ToDoRepository {
  private final List<ToDoItem> toDoItems = new ArrayList<>();
  private final PropertyChangeSupport propertyChangeSupport = new PropertyChangeSupport(this);
  private final PropertyChangeListener toDoItemChangeListener = new ToDoItemChangeListener();

  public List<ToDoItem> getTodoItems() {
    return toDoItems;
  }

  /**
   * Adds a new TodoItem to the repository.
   *
   * @param toDoItem the TodoItem to add
   */
  public void addItem(ToDoItem toDoItem) {
    toDoItems.add(toDoItem);
    propertyChangeSupport.firePropertyChange("added", null, toDoItem);
    toDoItem.addChangeListener(toDoItemChangeListener);
  }

  /**
   * Adds a new TodoItem to the repository.
   *
   * @param text      the text to set
   * @param completed the completed state to set
   * @return the added TodoItem
   */
  public ToDoItem addItem(String text, boolean completed) {
    ToDoItem toDoItem = new ToDoItem(text, completed);
    addItem(toDoItem);
    return toDoItem;
  }

  /**
   * Adds a new TodoItem to the repository.
   *
   * @param text the text to set
   * @return the added TodoItem
   */
  public ToDoItem addItem(String text) {
    return addItem(text, false);
  }

  /**
   * Removes a TodoItem from the repository.
   *
   * @param toDoItem the TodoItem to remove
   */
  public void removeItem(ToDoItem toDoItem) {
    toDoItems.remove(toDoItem);
    toDoItem.removeChangeListener(toDoItemChangeListener);
    propertyChangeSupport.firePropertyChange("removed", null, toDoItem);
  }

  /**
   * Removes all completed TodoItems from the repository.
   */
  public void removeCompletedItems() {
    List<ToDoItem> completedItems = getCompletedItems();
    for (ToDoItem toDoItem : completedItems) {
      removeItem(toDoItem);
    }
  }

  /**
   * Gets all TodoItems from the repository.
   *
   * @return the TodoItems
   */
  public List<ToDoItem> getItems() {
    return toDoItems;
  }

  /**
   * Gets all completed TodoItems from the repository.
   *
   * @return the completed TodoItems
   */
  public List<ToDoItem> getCompletedItems() {
    List<ToDoItem> completedItems = new ArrayList<>();

    for (ToDoItem toDoItem : toDoItems) {
      if (toDoItem.isCompleted()) {
        completedItems.add(toDoItem);
      }
    }

    return completedItems;
  }

  /**
   * Finds a TodoItem by its id.
   *
   * @param id the id to search for
   * @return the TodoItem or null if not found
   */
  public ToDoItem findById(String id) {
    for (ToDoItem toDoItem : toDoItems) {
      if (toDoItem.getId().equals(id)) {
        return toDoItem;
      }
    }

    return null;
  }

  /**
   * Adds a listener to the repository.
   *
   * @param listener the listener to add
   * @return this
   */
  public ToDoRepository addChangeListener(PropertyChangeListener listener) {
    propertyChangeSupport.addPropertyChangeListener(listener);
    return this;
  }

  private class ToDoItemChangeListener implements PropertyChangeListener {

    @Override
    public void propertyChange(PropertyChangeEvent evt) {
      propertyChangeSupport.firePropertyChange("updated", null, evt.getSource());
    }
  }
}
