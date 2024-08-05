package com.webforj.demo.pages.sections.ecom.checkout.widgets;

import com.webforj.component.html.elements.Div;
import com.webforj.component.html.elements.Img;
import com.webforj.component.html.elements.Paragraph;
import com.webforj.component.html.elements.Span;

public class OrderSummary extends Div {
  private Paragraph title = new Paragraph("Order Summary");
  private Paragraph name1 = new Paragraph("Polo Navy Blue T-Shirt");
  private Paragraph name2 = new Paragraph("Red Hoodie for Men");
  private Paragraph name3 = new Paragraph("Designer Awesome T-Shirt");
  private Img image1 = new Img("context://public/img/product-1.webp");
  private Img image2 = new Img("context://public/img/product-2.webp");
  private Img image3 = new Img("context://public/img/product-3.webp");
  private Span quantityAndPrice1 = new Span("1 x $39");
  private Span quantityAndPrice2 = new Span("2 x $98");
  private Span quantityAndPrice3 = new Span("1 x $49");
  private Span subtotalLabel = new Span("Subtotal");
  private Span subtotalValue = new Span("$284");
  private Span shippingLabel = new Span("Shipping");
  private Span shippingValue = new Span("FREE");
  private Span totalLabel = new Span("Total");
  private Span totalValue = new Span("$284");

  public OrderSummary() {
    title.addClassName("order-summary__title");

    Div item1 = new Div().addClassName("order-summary__order-item");
    image1.addClassName("order-item__image");
    name1.addClassName("order-item__name");
    quantityAndPrice1.addClassName("order-item__quantity-price");
    item1.add(image1, name1, quantityAndPrice1);

    Div item2 = new Div().addClassName("order-summary__order-item");
    image2.addClassName("order-item__image");
    name2.addClassName("order-item__name");
    quantityAndPrice2.addClassName("order-item__quantity-price");
    item2.add(image2, name2, quantityAndPrice2);

    Div item3 = new Div().addClassName("order-summary__order-item");
    image3.addClassName("order-item__image");
    name3.addClassName("order-item__name");
    quantityAndPrice3.addClassName("order-item__quantity-price");
    item3.add(image3, name3, quantityAndPrice3);

    Div subtotalLine = new Div().addClassName("order-summary__total-line-item");
    subtotalLabel.addClassName("total-line-item__label");
    subtotalValue.addClassName("total-line-item__value");
    subtotalLine.add(subtotalLabel, subtotalValue);

    Div shippingLine = new Div().addClassName("order-summary__total-line-item");
    shippingLabel.addClassName("total-line-item__label");
    shippingValue.addClassName("total-line-item__value");
    shippingLine.add(shippingLabel, shippingValue);

    Div totalLine = new Div().addClassName("order-summary__total-line-item");
    totalLabel.addClassName("total-line-item__label");
    totalValue.addClassName("total-line-item__value");
    totalLine.add(totalLabel, totalValue);

    this.add(title, item1, item2, item3, subtotalLine, shippingLine, totalLine);
    this.addClassName("order-summary");
  }

}
