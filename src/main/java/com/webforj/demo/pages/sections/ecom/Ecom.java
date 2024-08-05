package com.webforj.demo.pages.sections.ecom;

import com.webforj.annotation.InlineStyleSheet;
import com.webforj.component.html.elements.Div;
import com.webforj.demo.pages.BasePage;
import com.webforj.demo.pages.sections.ecom.checkout.CheckoutPage;
import com.webforj.demo.pages.sections.ecom.productdetails.ProductDetailsPage;
import com.webforj.demo.pages.sections.ecom.products.ProductsPage;

@InlineStyleSheet("context://public/pages/ecom.css")

public class Ecom extends BasePage<Ecom> {
  private ProductsPage productsPage = new ProductsPage();
  private ProductDetailsPage productDetailsPage = new ProductDetailsPage();
  private CheckoutPage checkoutPage = new CheckoutPage();

  public Ecom(){
    self.addClassName("page page__ecom");

    Div productsPageWrapper = new Div();
    productsPageWrapper.add(productsPage);

    Div detailsPageWrapper = new Div();
    detailsPageWrapper.add(productDetailsPage);

    Div checkoutPageWrapper = new Div();
    checkoutPageWrapper.add(checkoutPage);

    self.add(productsPageWrapper, detailsPageWrapper, checkoutPageWrapper); 
  }

}