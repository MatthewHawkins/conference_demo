package com.webforj.demo.pages.sections.ecom.products.widgets;

import com.webforj.component.Composite;
import com.webforj.component.html.elements.Div;
import com.webforj.component.html.elements.Img;

public class ItemCard extends Composite<Div> {
    private Div imageDiv;
    private Div nameDiv;
    private Div priceDiv;
    private Div ratingDiv;
    private Div stockDiv;

    public ItemCard(String productName, Img productImage, String price, String rating, String stock) {
        imageDiv = new Div().addClassName("image");
        nameDiv = new Div().addClassName("name");
        priceDiv = new Div().addClassName("price");
        ratingDiv = new Div().addClassName("rating");
        stockDiv = new Div().addClassName("stock");

        this.nameDiv.setText(productName);
        this.priceDiv.setText(price);
        this.ratingDiv.setText(rating);
        this.stockDiv.setText("Stock: " + stock);

        imageDiv.add(productImage);
        imageDiv.setStyle("background-color", "var(--dwc-surface-1)");

        getBoundComponent().addClassName("itemcard")
            .add(imageDiv, nameDiv, priceDiv, ratingDiv, stockDiv);
    }

}
