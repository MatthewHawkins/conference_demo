package com.webforj.demo.pages.sections.dashboard.widgets.todo;

import com.webforj.component.button.Button;
import com.webforj.component.field.TextField;
import com.webforj.component.html.elements.Div;
import com.webforj.demo.pages.sections.dashboard.widgets.todo.model.ToDoRepository;
import static com.webforj.component.button.ButtonTheme.PRIMARY;

public final class ToDoInput extends Div {
  private final ToDoRepository repository;

  /**
   * Creates a new instance of {@link TodoInput}.
   *
   * @param repository the repository to use
   */
  public ToDoInput() {
    this(null);
  }
  public ToDoInput(ToDoRepository repository) {
    this.repository = repository;
    Div wrapper = new Div()
      .addClassName("todo__inputWrapper");

    TextField input = new TextField()
      .addClassName("todo__input")
      .setPlaceholder("What needs to be done?");

    Button button = new Button("Add")
      .setTheme(PRIMARY)
      .addClassName("todo__button");
    button.onClick(e -> {
      repository.addItem(input.getText());
      input.setText("");
    });

    wrapper.add(input, button);
    add(wrapper);
  }
}