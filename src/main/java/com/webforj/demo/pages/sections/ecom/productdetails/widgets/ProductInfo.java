package com.webforj.demo.pages.sections.ecom.productdetails.widgets;

import com.webforj.component.html.elements.Div;
import com.webforj.component.html.elements.Paragraph;
import com.webforj.component.html.elements.Span;

public class ProductInfo extends Div {

  public ProductInfo(Paragraph title, Paragraph rating, Paragraph stockStatus, String originalPrice, String discountedPrice, String description) {
    title.addClassName("product-title");
    rating.addClassName("product-rating");
    stockStatus.addClassName("stock-status");

    Span originalPriceSpan = new Span(originalPrice);
    originalPriceSpan.addClassName("original-price");
    Span discountedPriceSpan = new Span(discountedPrice);
    discountedPriceSpan.addClassName("discounted-price");

    Paragraph price = new Paragraph("Price: ");
    price.add(originalPriceSpan, discountedPriceSpan);
    price.addClassName("product-price");

    Div descContainer = new Div();
    descContainer.setText(description)
        .addClassName("product-description");

    this.add(title, rating, stockStatus, price, descContainer);
    this.addClassName("product-info-container");
  }
    
}
