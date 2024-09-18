package com.webforj.demo.pages.sections.ecom.products.widgets;

import com.webforj.component.html.elements.Div;
import com.webforj.component.html.elements.Img;

public  final class Products extends Div {

  public Products() {
    this.addClassName("products__item-card-display");

    this.add(new ItemCard("Jones Men's T-shirt (Blue)", new Img ("context://public/img/product-1.webp"), "$39", 5, "98 pcs", "(36 Customer Reviews)"));
    this.add(new ItemCard("Brown Hoodie for Men", new Img ("context://public/img/product-2.webp"), "$98", 4, "56 pcs", "(328 Customer Reviews)"));
    this.add(new ItemCard("Designer Awesome T-shirt", new Img ("context://public/img/product-3.webp"), "$49", 5, "235 pcs", "(45 Customer Reviews)"));
    this.add(new ItemCard("Jones Awesome T-shirt", new Img ("context://public/img/product-4.webp"), "$29", 5, "385 pcs", "(106 Customer Reviews)"));
    this.add(new ItemCard("Green T-shirt for Men", new Img ("context://public/img/product-5.webp"), "$49", 3, "25 pcs", "(18 Customer Reviews)"));
    this.add(new ItemCard("Blue Awesome Hoodie", new Img ("context://public/img/product-6.webp"), "$19", 4, "39 pcs", "(689 Customer Reviews)"));
    this.add(new ItemCard("Jones Men's T-shirt (Green)", new Img ("context://public/img/product-7.webp"), "$99", 5, "36 pcs", "(26 Customer Reviews)"));
    this.add(new ItemCard("Red Hoodie for Men", new Img ("context://public/img/product-8.webp"), "$29", 3, "128 pcs", "(82 Customer Reviews)"));
  }
    
}
