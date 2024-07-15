package com.webforj.demo.pages.sections.ecom.checkout.widgets;

import com.webforj.component.Composite;
import com.webforj.component.button.Button;
import com.webforj.component.button.ButtonTheme;
import com.webforj.component.html.elements.Div;

public class InfoControls extends Composite<Div> {
    
  private Button billingBtn = new Button();
  private Button shippingBtn = new Button();
  private Button paymentBtn = new Button();

  public InfoControls() {
    billingBtn.setText("""
      <html>
        <div style='text-align: center'>
          <dwc-icon name='user' style='display: block; margin: auto; margin-bottom: 10px;'></dwc-icon>
          <span style='display: block; margin-top: 10px;'>
            Billing Info
          </span>
        </div>
      </html>
    """)
      .setTheme(ButtonTheme.INFO)
      .addClassName("checkout-step");

    shippingBtn.setText("""
      <html>
        <div style='text-align: center'>
          <dwc-icon name='truck-delivery' style='display: block; margin: auto; margin-bottom: 10px;'></dwc-icon>
          <span style='display: block; margin-top: 10px;'>
            Shipping Info
          </span>
        </div>
      </html>
    """)
      .addClassName("checkout-step");

    paymentBtn.setText("""
      <html>
        <div style='text-align: center'>
          <dwc-icon name='cash' style='display: block; margin: auto; margin-bottom: 10px;'></dwc-icon>
          <span style='display: block; margin-top: 10px;'>
            Payment Info
          </span>
        </div>
      </html>        
    """)
      .addClassName("checkout-step");
  
    getBoundComponent().addClassName("info-controls-container")
      .add(billingBtn, shippingBtn, paymentBtn);
  }
    
}
