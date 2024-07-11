package com.webforj.demo.pages.sections.ecom.checkout.checkout.widgets;

import com.webforj.component.Composite;
import com.webforj.component.button.Button;
import com.webforj.component.button.ButtonTheme;
import com.webforj.component.html.elements.Div;

public class InfoControls extends Composite<Div> {
    
    private Button billingBtn;
    private Button shippingBtn;
    private Button paymentBtn;

    public InfoControls() {
        billingBtn = new Button("""
            <html>
                <div style='text-align: center'>
                    <dwc-icon name='user' style='display: block; margin: auto; margin-bottom: 10px;'></dwc-icon>
                    <span style='display: block; margin-top: 10px;'>
                        Billing Info
                    </span>
                </div>
            </html>
        """).setTheme(ButtonTheme.INFO);
        billingBtn.addClassName("checkout-step");

        shippingBtn = new Button("""
            <html>
                <div style='text-align: center'>
                    <dwc-icon name='truck-delivery' style='display: block; margin: auto; margin-bottom: 10px;'></dwc-icon>
                    <span style='display: block; margin-top: 10px;'>
                        Shipping Info
                    </span>
                </div>
            </html>
        """);
        shippingBtn.addClassName("checkout-step");

        paymentBtn = new Button("""
            <html>
                <div style='text-align: center'>
                    <dwc-icon name='cash' style='display: block; margin: auto; margin-bottom: 10px;'></dwc-icon>
                    <span style='display: block; margin-top: 10px;'>
                        Payment Info
                    </span>
                </div>
            </html>        
        """);
        paymentBtn.addClassName("checkout-step");
    
        getBoundComponent().addClassName("info-controls-container")
            .add(billingBtn, shippingBtn, paymentBtn);
    }
    
}
