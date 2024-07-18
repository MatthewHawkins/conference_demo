package com.webforj.demo.pages.sections.dashboard.widgets.todo;

import com.webforj.component.html.elements.Div;
import com.webforj.component.html.elements.Paragraph;
import com.webforj.demo.pages.sections.dashboard.widgets.todo.model.ToDoRepository;

public class ToDo extends Div {

  public ToDo() {
    Div card = new Div();
    card.addClassName("card card--todo");

    Paragraph header = new Paragraph();
    header.addClassName("card__header");
    header.setText("Todo");
    card.add(header);

    ToDoRepository repository = new ToDoRepository();
    repository.addItem("Contact the organizers");
    repository.addItem("Register for the event", true);
    repository.addItem("Book a hotel room");
    repository.addItem("Book a flight");
    repository.addItem("Start testing your application", true);
    repository.addItem("Start preparing your presentation", true);
    repository.addItem("Build your demo application", true);
    repository.addItem("Book a demo for webforj");
    repository.addItem("Prepare for meeting with the boss");

    card.add(
        new ToDoToolbar(repository),
        new ToDoList(repository),
        new ToDoInput(repository));
    add(card);
  }
}