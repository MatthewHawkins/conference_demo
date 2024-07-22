package com.webforj.demo.pages.sections.ecom.products.widgets;

import com.webforj.component.html.elements.Div;
import com.webforj.component.html.elements.Img;

public  final class Products extends Div {

  public Products() {
    this.addClassName("carddisplay");

    this.add(new ItemCard("Jones Men's T-shirt (Blue)", new Img ("context://public/img/product-1.webp"), "$39", "★★★★☆", "98 pcs"));
    this.add(new ItemCard("Brown Hoodie for Men", new Img ("context://public/img/product-2.webp"), "$98", "★★★★☆", "56 pcs"));
    this.add(new ItemCard("Designer Awesome T-shirt", new Img ("context://public/img/product-3.webp"), "$49", "★★★★★", "235 pcs"));
    this.add(new ItemCard("Jones Awesome T-shirt", new Img ("context://public/img/product-4.webp"), "$29", "★★★★★", "385 pcs"));
    this.add(new ItemCard("Green T-shirt for Men", new Img ("context://public/img/product-5.webp"), "$49", "★★☆☆☆", "25 pcs"));
    this.add(new ItemCard("Blue Awesome Hoodie", new Img ("context://public/img/product-6.webp"), "$19", "★★★☆☆", "39 pcs"));
    this.add(new ItemCard("Jones Men's T-shirt (Green)", new Img ("context://public/img/product-7.webp"), "$99", "★★★★★", "36 pcs"));
    this.add(new ItemCard("Red Hoodie for Men", new Img ("context://public/img/product-8.webp"), "$29", "★★★★★", "128 pcs"));
  }
    
}
