package com.webforj.demo.pages.sections.dashboard.widgets.todo.model;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;

public final class ToDoItem {
  private final PropertyChangeSupport propertyChangeSupport = new PropertyChangeSupport(this);
  private String id = java.util.UUID.randomUUID().toString();
  private String text;
  private boolean completed;

  /**
   * Creates a new TodoItem with the given text.
   *
   * @param text      the text to set
   * @param completed the completed state to set
   */
  public ToDoItem(String text, boolean completed) {
    this.setText(text);
    this.setCompleted(completed);
  }

  /**
   * Creates a new TodoItem with the given text.
   *
   * @param text the text to set
   */
  public ToDoItem(String text) {
    this(text, false);
  }

  /**
   * Get the id of this TodoItem.
   *
   * @return the id
   */
  public String getId() {
    return id;
  }

  /**
   * Sets the text of this TodoItem.
   *
   * @param text the text to set
   * @return this
   */
  public ToDoItem setText(String text) {
    String oldText = this.text;
    this.text = text;
    propertyChangeSupport.firePropertyChange("text", oldText, text);
    return this;
  }

  /**
   * Gets the text of this TodoItem.
   *
   * @return the text
   */
  public String getText() {
    return text;
  }

  /**
   * Sets the completed state of this TodoItem.
   *
   * @param completed the completed state to set
   * @return this
   */
  public ToDoItem setCompleted(boolean completed) {
    boolean oldCompleted = this.completed;
    this.completed = completed;
    propertyChangeSupport.firePropertyChange("completed", oldCompleted, completed);
    return this;
  }

  /**
   * Gets the completed state of this TodoItem.
   *
   * @return the completed state
   */
  public boolean isCompleted() {
    return completed;
  }

  /**
   * Adds a property change listener to this TodoItem.
   *
   * @param listener the listener to add
   * @return this
   */
  public ToDoItem addChangeListener(PropertyChangeListener listener) {
    propertyChangeSupport.addPropertyChangeListener(listener);
    return this;
  }

  /**
   * Removes a property change listener from this TodoItem.
   *
   * @param listener the listener to remove
   * @return this
   */
  public ToDoItem removeChangeListener(PropertyChangeListener listener) {
    propertyChangeSupport.removePropertyChangeListener(listener);
    return this;
  }
}