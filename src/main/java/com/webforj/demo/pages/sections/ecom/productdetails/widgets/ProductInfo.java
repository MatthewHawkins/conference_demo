package com.webforj.demo.pages.sections.ecom.productdetails.widgets;

import com.webforj.component.html.elements.Div;
import com.webforj.component.html.elements.Paragraph;
import com.webforj.component.html.elements.Span;

public class ProductInfo extends Div {
  private Paragraph title;
  private String baseTitle;

  public ProductInfo(Paragraph title, Paragraph rating, Paragraph stockStatus, String originalPrice, String discountedPrice, String description) {
    this.title = title;
    this.baseTitle = title.getText();
    
    title.addClassName("product-info-container__title");
    rating.addClassName("product-info-container__rating");
    stockStatus.addClassName("product-info-container__stock-status");

    Span originalPriceSpan = new Span(originalPrice);
    originalPriceSpan.addClassName("product-info-container__original-price");
    Span discountedPriceSpan = new Span(discountedPrice);
    discountedPriceSpan.addClassName("product-info-container__discounted-price");

    Paragraph price = new Paragraph("Price: ");
    price.add(originalPriceSpan, discountedPriceSpan);
    price.addClassName("product-info-container__price");

    Div descContainer = new Div();
    descContainer.setText(description)
        .addClassName("product-info-container__description");

    this.add(title, rating, stockStatus, price, descContainer);
    this.addClassName("product-info-container");
  }

  public void updateTitleWithColor(String newShirtColor) {
    String updatedTitle = baseTitle.replaceFirst("\\(.*\\)", "(" + newShirtColor + ")");
    title.setText(updatedTitle);
  }
    
}
