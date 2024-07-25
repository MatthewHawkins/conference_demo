@NodeName("sl-qr-code")
@JavaScript(
    value = "shoelace-style/shoelace.js",
    attributes = {
      @Attribute(name = "type", value = "module")
    }
)
public final class QRCode extends ElementComposite {

  private final PropertyDescriptor<String> VALUE =
      PropertyDescriptor.property("value", "");

  /** Get the value */
  public String getValue() {
    return get(VALUE);
  }

  /** Set the value */
  public QRCode setValue(String value) {
    set(VALUE, value);
    return this;
  }
}