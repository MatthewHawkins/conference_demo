package com.webforj.demo.pages.sections.ecom.productdetails.widgets;

import com.webforj.component.Composite;
import com.webforj.component.html.elements.Div;
import com.webforj.component.html.elements.Img;

public class ProductImage extends Composite<Div> {
    private Img mainImage;
    private Div thumbnailContainer;
    private String[] imageUrls;

    public ProductImage(String[] imageUrls) {
        this.imageUrls = imageUrls;

        mainImage = new Img(imageUrls[0]);
        mainImage.addClassName("main-image");

        thumbnailContainer = new Div().addClassName("thumbnail-container");

        for (int i = 0; i < imageUrls.length; i++) {
            final int index = i;
            Img thumbnail = new Img(imageUrls[i]);
            thumbnail.addClassName("thumbnail");
            thumbnail.addClickListener(e -> updateMainImage(index));
            thumbnailContainer.add(thumbnail);
        }

        getBoundComponent().addClassName("product-image")
            .add(mainImage, thumbnailContainer);

    }

    private void updateMainImage(int index) {
        mainImage.setSrc(imageUrls[index]);
    }
    
}
