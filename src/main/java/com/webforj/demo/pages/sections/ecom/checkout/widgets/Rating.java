package com.webforj.demo.pages.sections.ecom.checkout.widgets;

import com.webforj.annotation.Attribute;
import com.webforj.annotation.JavaScript;
import com.webforj.annotation.StyleSheet;
import com.webforj.component.element.ElementComposite;
import com.webforj.component.element.PropertyDescriptor;
import com.webforj.component.element.annotation.NodeName;
import com.webforj.demo.pages.sections.home.widgets.QRCode;

@StyleSheet("https://cdn.jsdelivr.net/npm/@shoelace-style/shoelace@2.16.0/cdn/themes/light.css")

  @JavaScript(
    value = "https://cdn.jsdelivr.net/npm/@shoelace-style/shoelace@2.0.0-beta.87/dist/shoelace.js",
    attributes = {
      @Attribute(name = "type", value = "module")
    }
  )

  @NodeName("sl-rating")

  public final class Rating extends ElementComposite {    

    private final PropertyDescriptor<Double> PRECISION = PropertyDescriptor.property("precision", 1.);
    private final PropertyDescriptor<Double> VALUE = PropertyDescriptor.property("value", 0.);
    private final PropertyDescriptor<Boolean> READONLY = PropertyDescriptor.property("readonly", false);

    public Rating() {
      super();
    }

    public Rating setPrecision(Double precision) {
      set(PRECISION, precision);
      return this;
    }

    public Double getPrecision() {
      return get(PRECISION);
    }

    public Rating setValue(Double value) {
      set(VALUE, value);
      return this;
    }

    public Double getValue() {
      return get(VALUE);
    }

    public Rating setReadOnly(Boolean readOnly) {
      set(READONLY, readOnly);
      return this;
    }

    public Double getReadOnly() {
      return get(VALUE);
    }

  }
