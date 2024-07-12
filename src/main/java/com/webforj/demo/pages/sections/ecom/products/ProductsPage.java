package com.webforj.demo.pages.sections.ecom.products;

import com.webforj.component.html.elements.Div;
import com.webforj.component.html.elements.Paragraph;
import com.webforj.component.navigator.Navigator;
import com.webforj.component.navigator.Navigator.Layout;
import com.webforj.demo.pages.sections.ecom.products.widgets.Products;
import com.webforj.demo.pages.sections.ecom.products.widgets.SearchBar;

public class ProductsPage extends Div {
    
    public ProductsPage() {
        Paragraph productsTitle = new Paragraph("Products");
        productsTitle.addClassName("page-title");

        Products products = new Products();

        SearchBar searchBar = new SearchBar();

        Navigator nav = new Navigator(100);
        nav.setLayout(Layout.PAGES);
        nav.getPaginator().setMax(5);

        this.add(productsTitle, searchBar, products, nav);
        this.addClassName("background");
    }
    
}
