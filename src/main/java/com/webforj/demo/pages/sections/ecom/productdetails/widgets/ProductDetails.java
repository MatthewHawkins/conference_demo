package com.webforj.demo.pages.sections.ecom.productdetails.widgets;

import com.webforj.component.Composite;
import com.webforj.component.button.Button;
import com.webforj.component.html.elements.Div;
import com.webforj.component.html.elements.Paragraph;
import com.webforj.demo.pages.sections.ecom.checkout.widgets.Rating;

public class ProductDetails extends Composite<Div> {
  private ProductInfo productInfo;
    
  public ProductDetails() {
    String heartIconHtml = "<dwc-icon name='heart' expanse='s'></dwc-icon>";
    String heartFilledIconHtml = "<dwc-icon name='heart-filled' expanse='s'></dwc-icon>";
    Button likeButton = new Button().setHtml(heartIconHtml)
      .addClassName("button__like");

    likeButton.addClickListener(e -> {
      String currentButtonIcon = likeButton.getHtml();
      String newButtonIcon = currentButtonIcon.equals(heartIconHtml) ? heartFilledIconHtml : heartIconHtml;
      likeButton.setHtml(newButtonIcon);
    });


    productInfo = new ProductInfo(new Paragraph("Jack & Jones Men's T-Shirt (Blue)"),
    new Paragraph(new Rating().setValue(4.).setReadOnly(true), new Paragraph(" (36 Customer Reviews)")),
    new Paragraph("In Stock"), "$80 USD",
    "$64 USD",
    "Experience the perfect blend of comfort and style with our Premium Cotton striped T-Shirt. "
    + "Made from 100% organic cotton, this tee is designed to provide a relaxed fit that is both "
    + "breathable and soft against your skin.");

    ProductControls productControls = new ProductControls();

    getBoundComponent().addClassName("product-details__container")
      .add(likeButton, productInfo, productControls);
    }

    public ProductInfo getProductInfo() {
      return productInfo;
    }
  }
