@AppTitle("Simple Counter")
class Application : App() {
  private var count = 0
  private val text = Paragraph("Count: 0")
  private val button = Button("Counter")

  override fun run() {
    val mainFrame = Frame()
    mainFrame.add(text, button)

    button.onClick {
      count++
      text.text = "Count: $count"
    }
  }
}