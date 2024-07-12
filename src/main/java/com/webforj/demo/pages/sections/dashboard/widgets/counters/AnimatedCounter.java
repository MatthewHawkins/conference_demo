package com.webforj.demo.pages.sections.dashboard.widgets.counters;

import com.webforj.annotation.Attribute;
import com.webforj.annotation.InlineJavaScript;
import com.webforj.component.element.ElementComposite;
import com.webforj.component.element.PropertyDescriptor;
import com.webforj.component.element.annotation.NodeName;
import com.webforj.component.html.elements.Div;
import com.webforj.concern.HasClassName;
import com.webforj.concern.HasStyle;

@NodeName("animated-counter")
@InlineJavaScript(id = "animated-counter", value = "context://components/animated-counter.js", attributes = {
    @Attribute(name = "type", value = "module")
})
public final class AnimatedCounter extends ElementComposite implements HasClassName<AnimatedCounter>, HasStyle<AnimatedCounter> {

  /**
   * The theme of the card
   */
  public enum Theme {
    PRIMARY("primary"),
    DANGER("danger"),
    SUCCESS("success"),
    INFO("info"),
    WARNING("warning"),
    DEFAULT("");

    private final String value;

    private Theme(String value) {
      this.value = value;
    }

    public String getValue() {
      return value;
    }

    public static Theme fromValue(String value) {
      for (Theme theme : Theme.values()) {
        if (theme.value.equals(value)) {
          return theme;
        }
      }
      return null;
    }
  }

  private final PropertyDescriptor<String> LABEL = PropertyDescriptor.property("label", "");
  private final PropertyDescriptor<Integer> START = PropertyDescriptor.property("start", 0);
  private final PropertyDescriptor<Integer> SPEED = PropertyDescriptor.property("speed", 1000);
  private final PropertyDescriptor<String> THEME = PropertyDescriptor.property("theme", Theme.DEFAULT.getValue());
  private final PropertyDescriptor<Double> VALUE = PropertyDescriptor.property("value", 0.0);
  private final PropertyDescriptor<String> PREFIX = PropertyDescriptor.property("valuePrefix", "");
  private final PropertyDescriptor<String> SUFFIX = PropertyDescriptor.property("valueSuffix", "");

  /**
   * Create a new AnimatedCounter instance
   */
  public AnimatedCounter() {
    super();
  }

  /**
   * Create a new AnimatedCounter instance
   *
   * @param label the label
   * @param value the value
   * @param theme the theme
   */
  public AnimatedCounter(String label, double value, Theme theme) {
    super();
    setLabel(label);
    setValue(value);
    setTheme(theme);
  }

  /**
   * Create a new AnimatedCounter instance
   *
   * @param label the label
   * @param value the value
   */
  public AnimatedCounter(String label, double value) {
    this(label, value, Theme.DEFAULT);
  }

  /**
   * Set the icon of the card
   *
   * @param name the name of the icon
   * @param pool the pool of the icon
   *
   * @return this
   */
  public AnimatedCounter setIcon(String name, String pool) {
    getElement().add("icon", new Div().setHtml("<dwc-icon name=\"" + name + "\" pool=\"" + pool + "\"></dwc-icon>"));
    return this;
  }

  /**
   * Set the icon of the card
   *
   * @param name the name of the icon
   *
   * @return this
   */
  public AnimatedCounter setIcon(String name) {
    return setIcon(name, "tabler");
  }

  /**
   * Set the card's label
   *
   * @param label the label
   * @return this
   */
  public AnimatedCounter setLabel(String label) {
    set(LABEL, label);
    return this;
  }

  /**
   * Get the card's label
   *
   * @return the label
   */
  public String getLabel() {
    return get(LABEL);
  }

  /**
   * Set the start value of the counter
   *
   * The start value is the value the counter will start animating from.
   *
   * @param start the start value
   * @return this
   */
  public AnimatedCounter setStart(int start) {
    set(START, start);
    return this;
  }

  /**
   * Get the start value of the counter
   *
   * @return the start value
   */
  public int getStart() {
    return get(START);
  }

  /**
   * Set the speed of the animation
   *
   * @param speed the speed
   * @return this
   */
  public AnimatedCounter setSpeed(int speed) {
    set(SPEED, speed);
    return this;
  }

  /**
   * Get the speed of the animation
   *
   * @return the speed
   */
  public int getSpeed() {
    return get(SPEED);
  }

  /**
   * Set the theme of the card
   *
   * @param theme the theme
   * @return this
   */
  public AnimatedCounter setTheme(Theme theme) {
    set(THEME, theme.getValue());
    return this;
  }

  /**
   * Get the theme of the card
   *
   * @return the theme
   */
  public Theme getTheme() {
    return Theme.fromValue(get(THEME));
  }

  /**
   * Set the value of the counter
   *
   * @param value the value
   * @return this
   */
  public AnimatedCounter setValue(double value) {
    set(VALUE, value);
    return this;
  }

  /**
   * Get the value of the counter
   *
   * @return the value
   */
  public double getValue() {
    return get(VALUE);
  }

  /**
   * Set the prefix of the counter
   *
   * @param prefix the prefix
   * @return this
   */
  public AnimatedCounter setPrefix(String prefix) {
    set(PREFIX, prefix);
    return this;
  }

  /**
   * Get the prefix of the counter
   *
   * @return the prefix
   */
  public String getPrefix() {
    return get(PREFIX);
  }

  /**
   * Set the suffix of the counter
   *
   * @param suffix the suffix
   * @return this
   */
  public AnimatedCounter setSuffix(String suffix) {
    set(SUFFIX, suffix);
    return this;
  }

  /**
   * Get the suffix of the counter
   *
   * @return the suffix
   */
  public String getSuffix() {
    return get(SUFFIX);
  }

  /**
   * {@inheritDoc}
   */
  @Override
  public AnimatedCounter addClassName(String... className) {
    getElement().addClassName(className);
    return this;
  }

  /**
   * {@inheritDoc}
   */
  @Override
  public AnimatedCounter removeClassName(String... className) {
    getElement().removeClassName(className);
    return this;
  }

  @Override
  public String getStyle(String s) {
    return getElement().getStyle(s);
  }

  @Override
  public String getComputedStyle(String s) {
    return getElement().getComputedStyle(s);
  }

  /**
   * {@inheritDoc}
   */
  @Override
  public AnimatedCounter setStyle(String property, String value) {
    getElement().setStyle(property, value);
    return this;
  }

  @Override
  public AnimatedCounter removeStyle(String s) {
    getElement().removeStyle(s);
    return this;
  }
}