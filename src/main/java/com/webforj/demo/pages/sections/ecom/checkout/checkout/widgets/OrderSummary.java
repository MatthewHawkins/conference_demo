package com.webforj.demo.pages.sections.ecom.checkout.checkout.widgets;

import com.webforj.component.html.elements.Div;
import com.webforj.component.html.elements.Img;
import com.webforj.component.html.elements.Paragraph;
import com.webforj.component.html.elements.Span;

public class OrderSummary extends Div {
    private Paragraph title, name1, name2, name3;
    private Img image1, image2, image3;
    private Span quantityAndPrice1, quantityAndPrice2, quantityAndPrice3, subtotalLabel, subtotalValue, shippingLabel, shippingValue, totalLabel, totalValue;

    public OrderSummary() {
        title = new Paragraph("Order Summary");
        title.addClassName("order-summary-title");

        Div item1 = new Div().addClassName("order-item");
        image1 = new Img("context://public/img/product-1.png");
        image1.addClassName("order-image");
        name1 = new Paragraph("Polo Navy Blue T-Shirt").addClassName("item-name");
        quantityAndPrice1 = new Span("1 x $39").addClassName("item-quantity-price");
        item1.add(image1, name1, quantityAndPrice1);

        Div item2 = new Div().addClassName("order-item");
        image2 = new Img("context://public/img/product-2.png");
        image2.addClassName("order-image");
        name2 = new Paragraph("Red Hoodie for Men").addClassName("item-name");
        quantityAndPrice2 = new Span("2 x $98").addClassName("item-quantity-price");
        item2.add(image2, name2, quantityAndPrice2);

        Div item3 = new Div().addClassName("order-item");
        image3 = new Img("context://public/img/product-3.png");
        image3.addClassName("order-image");
        name3 = new Paragraph("Designer Awesome T-Shirt").addClassName("item-name");
        quantityAndPrice3 = new Span("1 x $49").addClassName("item-quantity-price");
        item3.add(image3, name3, quantityAndPrice3);

        Div subtotalLine = new Div().addClassName("total-line-item");
        subtotalLabel = new Span("Subtotal").addClassName("total-label");
        subtotalValue = new Span("$284").addClassName("total-value");
        subtotalLine.add(subtotalLabel, subtotalValue);

        Div shippingLine = new Div().addClassName("total-line-item");
        shippingLabel = new Span("Shipping").addClassName("total-label");
        shippingValue = new Span("FREE").addClassName("total-value");
        shippingLine.add(shippingLabel, shippingValue);

        Div totalLine = new Div().addClassName("total-line-item");
        totalLabel = new Span("Total").addClassName("total-label");
        totalValue = new Span("$284").addClassName("total-value");
        totalLine.add(totalLabel, totalValue);

        this.add(title, item1, item2, item3, subtotalLine, shippingLine, totalLine);
        this.addClassName("order-summary");
    }

}
