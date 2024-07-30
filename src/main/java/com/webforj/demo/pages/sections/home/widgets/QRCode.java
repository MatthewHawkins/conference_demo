package com.webforj.demo.pages.sections.home.widgets;

import com.webforj.annotation.Attribute;
import com.webforj.annotation.JavaScript;
import com.webforj.component.element.ElementComposite;
import com.webforj.component.element.PropertyDescriptor;
import com.webforj.component.element.annotation.NodeName;

import java.awt.Color;

/**
 * QRCode Generator using Shoelace QRCode component
 */
@JavaScript(
  value = "https://cdn.jsdelivr.net/npm/@shoelace-style/shoelace@2.16.0/cdn/shoelace-autoloader.js",
  attributes = {@Attribute(name = "type", value = "module")})
@NodeName("sl-qr-code")

public final class QRCode extends ElementComposite {
  private final PropertyDescriptor<String> VALUE = PropertyDescriptor.property("value", "");
  private final PropertyDescriptor<Integer> SIZE = PropertyDescriptor.property("size", 200);
  private final PropertyDescriptor<String> COLOR = PropertyDescriptor.property("fill", "#000000");

  /**
    * Create a new QRCode
  */
  public QRCode() { 
    super();
  }

  /**
    * Create a new QRCode with the given value
    *
    * @param value the value of the QRCode
  */
  public QRCode(String value) {
    super();
    this.setValue(value);
  }

  /**
    * Create a new QRCode with the given value and size
    *
    * @param value the value of the QRCode
    * @param size  the size of the QRCode
  */
  public QRCode(String value, int size) {
    super();
    this.setValue(value);
    this.setSize(size);
  }

  /**
    * Get the value of the QRCode
    *
    * @return the value of the QRCode
  */
  public String getValue() {
    return get(VALUE);
  }

  /**
    * Set the value of the QRCode
    *
    * @param value the value of the QRCode
  */
  public QRCode setValue(String value) {
    set(VALUE, value);
    return this;
  }

  /**
    * Get the size of the QRCode
    *
    * @return the size of the QRCode
  */
  public int getSize() {
    return get(SIZE);
  }
  
  /**
    * Set the size of the QRCode
    *
    * @param size the size of the QRCode
  */
  public QRCode setSize(int size) {
    set(SIZE, size);
    return this;
  }

  /**
    * Get the color of the QRCode
    *
    * @return the color of the QRCode
  */
  public Color getColor() {
    String hex = get(COLOR);
    return Color.decode(hex);
  }

  /**
    * Set the color of the QRCode
    *
    * @param color the color of the QRCode
  */
  public QRCode setColor(Color color) {
    String hex = String.format("#%02x%02x%02x", color.getRed(), color.getGreen(), color.getBlue());
    set(COLOR, hex);
    return this;
  }
    
}
