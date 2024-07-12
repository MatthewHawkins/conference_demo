package com.webforj.demo.pages.sections.ecom;

import com.webforj.annotation.InlineStyleSheet;
import com.webforj.component.html.elements.Div;
import com.webforj.component.tabbedpane.TabbedPane;
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
        // addClassName("page page--ecom");

        Div productsPageWrapper = new Div();
        productsPageWrapper.addClassName("tab-page-container");
        productsPageWrapper.add(productsPage);

        Div detailsPageWrapper = new Div();
        detailsPageWrapper.addClassName("tab-page-container");
        detailsPageWrapper.add(productDetailsPage);

        Div checkoutPageWrapper = new Div();
        checkoutPageWrapper.addClassName("tab-page-container");
        checkoutPageWrapper.add(checkoutPage);

        self.add(productsPageWrapper, detailsPageWrapper, checkoutPageWrapper); 
    }

}