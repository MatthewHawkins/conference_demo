package com.webforj.demo.pages.sections.ecom.productdetails.widgets;

import com.webforj.component.Composite;
import com.webforj.component.html.elements.Div;
import com.webforj.component.html.elements.Img;

public class ProductImage extends Composite<Div> {
  private Img mainImage;
  private Div thumbnailContainer = new Div();
  private String[] imageUrls;
  private ProductInfo productInfo;


  public ProductImage(String[] imageUrls, ProductInfo productInfo) {
    this.imageUrls = imageUrls;
    this.productInfo = productInfo;

    mainImage = new Img(imageUrls[0]);
    mainImage.addClassName("product-image__main-image");

    thumbnailContainer.addClassName("product-image__thumbnail-container");

    for (int i = 0; i < imageUrls.length; i++) {
      final int index = i;
      Img thumbnail = new Img(imageUrls[i]);
      thumbnail.addClassName("thumbnail-container__thumbnail");
      thumbnail.addClickListener(e -> updateMainImage(index));
      thumbnailContainer.add(thumbnail);
    }

    getBoundComponent().addClassName("product-image__container")
      .add(mainImage, thumbnailContainer);
  }

  private void updateMainImage(int index) {
    String shirtColor = "";
    mainImage.setSrc(imageUrls[index]);

    switch (index) {
      case 0:
        shirtColor = "Blue";
        break;
      case 1:
        shirtColor = "Red";
        break;
      case 2:
        shirtColor = "Yellow";
        break;
      case 3:
        shirtColor = "Green";
        break;
    }

    productInfo.updateTitleWithColor(shirtColor);
  }
    
}
