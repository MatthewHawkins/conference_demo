package com.webforj.demo.pages.sections.dashboard.widgets.table;

import java.util.ArrayList;

import com.webforj.data.repository.CollectionRepository;
import com.webforj.data.repository.Repository;

public final class Service {

  public Service() {   
  }

  public static Repository<ProductRecord> getProductRecords() {
    String[] products = new String[] { 
      "Jones Men's Blue T-Shirt",
      "Brown Hoodie for Men",
      "Cut Sleeve Shirt",
      "Blue T-Shirt",
      "Green T-Shirt",
      "Heavy Hoodie for Women",
      "Branded Half Sleeve",
      "Long Sleeve Shirt" 
    }; 

    String[] prices = new String[] {
      "$79.49",
      "$128.50",
      "$39.99",
      "$20.00",
      "$28.49",
      "$79.49",
      "$39.99",
      "$20.00"
    };

    String[] quantities = new String[] {
        "82",
        "37",
        "64",
        "184",
        "69",
        "82",
        "64",
        "184"
    };
    
    String[] amounts = new String[] { 
      "$6,518.18",
      "$4,754.50",
      "$2,559.36",
      "$3,680.00",
      "$1,965.81",
      "$6,518.18",
      "$2,559.36",
      "$3,680.00"
    };
    
    String[] photoURL = new String[] { 
      "https://coderthemes.com/ubold/layouts/default/assets/images/products/product-1.png", 
      "https://coderthemes.com/ubold/layouts/default/assets/images/products/product-2.png", 
      "https://coderthemes.com/ubold/layouts/default/assets/images/products/product-3.png", 
      "https://coderthemes.com/ubold/layouts/default/assets/images/products/product-4.png", 
      "https://coderthemes.com/ubold/layouts/default/assets/images/products/product-5.png", 
      "https://coderthemes.com/ubold/layouts/default/assets/images/products/product-6.png", 
      "https://coderthemes.com/ubold/layouts/default/assets/images/products/product-7.png", 
      "https://coderthemes.com/ubold/layouts/default/assets/images/products/product-8.png"
    };

    ArrayList<ProductRecord> data = new ArrayList<>();
    for (int i = 0; i < products.length; i++) {
      ProductRecord record = new ProductRecord();
      record.setProduct(products[i]);
      record.setPrice(prices[i]);
      record.setQuantity(quantities[i]);
      record.setAmount(amounts[i]);
      record.setImageURL(photoURL[i]);
      data.add(record);
    }

    return new CollectionRepository<>(data);
  }
  
}
