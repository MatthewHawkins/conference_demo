package com.webforj.demo.pages.sections.ecom.checkout;

import com.webforj.component.html.elements.Div;
import com.webforj.component.html.elements.Paragraph;
import com.webforj.demo.pages.sections.ecom.checkout.widgets.BillingInfo;
import com.webforj.demo.pages.sections.ecom.checkout.widgets.InfoControls;
import com.webforj.demo.pages.sections.ecom.checkout.widgets.OrderSummary;

public class CheckoutPage extends Div {

  public CheckoutPage() {
    Paragraph cartTitle = new Paragraph("Shopping Cart");
    cartTitle.addClassName("page-title");

    InfoControls infoControls = new InfoControls();
    OrderSummary orderSummary = new OrderSummary();
    Div leftSection = new Div(infoControls, orderSummary);
    leftSection.addClassName("checkout__left-container");

    BillingInfo billingInfo = new BillingInfo();
    Div rightSection = new Div(billingInfo);
    rightSection.addClassName("checkout__right-container");

    Div checkoutContainer = new Div(leftSection, rightSection);
    checkoutContainer.addClassName("checkout-container");

    this.add(cartTitle, checkoutContainer);
    this.addClassName("background");
  }

}
