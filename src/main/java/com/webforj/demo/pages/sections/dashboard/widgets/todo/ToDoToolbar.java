package com.webforj.demo.pages.sections.dashboard.widgets.todo;

import com.webforj.component.button.Button;
import com.webforj.component.html.elements.Div;
import com.webforj.component.html.elements.Paragraph;
import com.webforj.demo.pages.sections.dashboard.widgets.todo.model.ToDoRepository;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeEvent;
import static com.webforj.component.button.ButtonTheme.OUTLINED_PRIMARY;

public class ToDoToolbar extends Div {
  private final ToDoRepository repository;
  private Div toDoToolbar;
  private Paragraph remainingItems;

  /**
   * Creates a new instance of {@link TodoToolbar}.
   *
   * @param repository the repository to use
   */
  public ToDoToolbar(ToDoRepository repository) {
    this.repository = repository;
    this.repository.addChangeListener(new RepositoryChangeListener());

    toDoToolbar = new Div();
    toDoToolbar.addClassName("todo__toolbar");

    remainingItems = new Paragraph("");
    remainingItems.addClassName("todo__remainingItems");

    Button clearCompleted = new Button("Archive");
    clearCompleted.setTheme(OUTLINED_PRIMARY);
    clearCompleted.onClick(e -> {
      repository.removeCompletedItems();
    });

    update();
    toDoToolbar.add(remainingItems, clearCompleted);
    add(toDoToolbar);
  }

  private void update() {
    int total = repository.getItems().size();
    int remaining = total - repository.getCompletedItems().size();

    remainingItems.setText(remaining + " of " + total + " remaining");
  }

  private class RepositoryChangeListener implements PropertyChangeListener {
    @Override

    public void propertyChange(PropertyChangeEvent e) {
      String[] properties = {"added", "removed", "updated"};
      if (java.util.Arrays.asList(properties).contains(e.getPropertyName())) {
        update();
      }
    }
  }

}
