package com.webforj.demo.pages.sections.ecom.productdetails;

import com.webforj.component.html.elements.Div;
import com.webforj.component.html.elements.Paragraph;
import com.webforj.demo.pages.sections.ecom.productdetails.widgets.ProductDetails;
import com.webforj.demo.pages.sections.ecom.productdetails.widgets.ProductImage;


public class ProductDetailsPage extends Div{

  public ProductDetailsPage() {
    Paragraph productDetailTitle = new Paragraph("Product Details");
    productDetailTitle.addClassName("page-title");

    String[] imageUrls = {
      "context://public/img/thumbnail-1.webp",
      "context://public/img/thumbnail-2.webp",
      "context://public/img/thumbnail-3.webp",
      "context://public/img/thumbnail-4.webp",
    };

    ProductImage productImage = new ProductImage(imageUrls);
    ProductDetails productDetails = new ProductDetails();
    
    Div imageContainer = new Div();
    imageContainer.addClassName("product-details-container__image-container")
      .add(productImage);
    
    Div productDetailsContainer = new Div();
    productDetailsContainer.addClassName("product-details-container")
      .add(imageContainer, productDetails);

    this.add(productDetailTitle, productDetailsContainer);
    this.addClassName("background");
  }
  
}
