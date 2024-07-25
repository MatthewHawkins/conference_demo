@AppTitle("Simple Counter")
public final class Application extends App {

  private int count = 0;
  Paragraph text = new Paragraph("Count: 0");
  Button button = new Button("Counter");

  @Override
  public void run() throws WebforjException {

    Frame mainFrame = new Frame();
    mainFrame.add(text, button);

    button.onClick(e -> {
      count++;
      text.setText("Count: " + count);
    });
  }
}