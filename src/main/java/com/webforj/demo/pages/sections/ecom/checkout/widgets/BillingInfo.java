package com.webforj.demo.pages.sections.ecom.checkout.widgets;

import com.webforj.App;
import com.webforj.component.button.Button;
import com.webforj.component.button.ButtonTheme;
import com.webforj.component.event.ToggleEvent;
import com.webforj.component.field.TextField;
import com.webforj.component.html.elements.Div;
import com.webforj.component.html.elements.Paragraph;
import com.webforj.component.layout.flexlayout.FlexLayout;
import com.webforj.component.list.ChoiceBox;
import com.webforj.component.maskednumberfield.MaskedNumberField;
import com.webforj.component.optioninput.CheckBox;

public class BillingInfo extends Div {
  private Paragraph title = new Paragraph("Billing Information");
  private Paragraph mailingTitle = new Paragraph("Mailing Information");
  private Paragraph subtitle = new Paragraph("Please fill in your billing information");
  private Paragraph mailingSubtitle = new Paragraph("Please fill in your mailing information");
  private TextField firstName = new TextField("First Name");
  private TextField lastName = new TextField("Last Name");
  private TextField email = new TextField("Email");
  private TextField phone = new TextField("Phone");
  private TextField address = new TextField("Address");
  private TextField city = new TextField("City");
  private ChoiceBox states = new ChoiceBox();
  private ChoiceBox mailingStates = new ChoiceBox();
  private ChoiceBox countries = new ChoiceBox();
  private ChoiceBox mailingCountries = new ChoiceBox();
  private MaskedNumberField zip = new MaskedNumberField();
  private CheckBox diffAddress = new CheckBox();
  private Button submit = new Button();
  private Button back = new Button();
  private TextField mailingFirstName = new TextField("First Name");
  private TextField mailingLastName = new TextField("Last Name");
  private TextField mailingEmail = new TextField("Email");
  private TextField mailingPhone = new TextField("Phone");
  private TextField mailingAddress = new TextField("Address");
  private TextField mailingCity = new TextField("City");
  private MaskedNumberField mailingZip = new MaskedNumberField();
  private FlexLayout mailingLayout;
  private FlexLayout mainLayout;
  private FlexLayout footerLayout;

  public BillingInfo() {
    populateStates();
    populateCountries();
    createBillingForm();
  }

  private void createBillingForm() {
    this.setStyle("display", "flex");
    this.setStyle("flex-direction", "column");
    zip.setAttribute("label", "Zip Code")
      .addClassName("customer-info__zip-code");

    diffAddress.setText("Ship to different address");
    diffAddress.addToggleListener(this::createMailingForm);

    back.setText("""
      <html>
        <div style='text-align: center;'>
          <dwc-icon name='arrow-left'></dwc-icon>
          Back to Shopping Cart
        </div>
      </html>
    """)
      .setTheme(ButtonTheme.GRAY)
      .addClassName("button-cancel");  

    // back.setHtml("""
    //     <div style='text-align: center;'>
    //       <dwc-icon name='arrow-left'></dwc-icon>
    //       Back to Shopping Cart
    //     </div>
    // """)
      // .setTheme(ButtonTheme.GRAY)
      // .addClassName("button-cancel");

    submit.setText("""
      <html>
        <div style='text-align: center;'>
          <dwc-icon name='truck-delivery'></dwc-icon>
            Proceed to Shipping
        </div>
      </html>
    """)
      .setTheme(ButtonTheme.SUCCESS)
      .addClassName("button-submit");

    // submit.setHtml("""
    //   <div style='text-align: center;'>
    //     <dwc-icon name='truck-delivery'></dwc-icon>
    //       Proceed to Shipping
    //   </div>
    // """)
    //   .setTheme(ButtonTheme.SUCCESS)
    //   .addClassName("button-submit");

    FlexLayout rowOne = FlexLayout.create(title, subtitle)
      .vertical()
      .build()
      .setStyle("gap", "0");    
    title.setStyle("font-size", "16px")
      .setStyle("margin", "0"); 
    subtitle.setStyle("font-size", "12px")
      .setStyle("color", "#9ba8af")
      .setStyle("margin-top", ".5em");
      
      FlexLayout rowTwo = FlexLayout.create(firstName, lastName)
        .horizontal()
        .build()
        .setItemBasis("50%", firstName)
        .setItemBasis("50%", lastName);
      
      FlexLayout rowThree = FlexLayout.create(email, phone)
        .horizontal()
        .build()
        .setItemBasis("50%", email)
        .setItemBasis("50%", phone);
      
      FlexLayout rowFour = FlexLayout.create(city, states, zip)
        .horizontal()
        .build()
        .setItemBasis("50%", city)
        .setItemBasis("30%", states);
        zip.setStyle("width", "20%");
      
      FlexLayout rowFive = FlexLayout.create(back, submit)
        .horizontal()
        .justify().between()
        .build()
        .setStyle("margin-top", "30px");
      
      mainLayout = FlexLayout.create(rowOne, rowTwo, address, rowThree, rowFour, countries, diffAddress)
        .vertical() 
        .build()
        .addClassName("billing-info order-div-1")
        .setStyle("gap", "40px")
        .setStyle("order", "1");
      
      footerLayout = FlexLayout.create(rowFive)
        .horizontal()
        .justify().between()
        .build()
        .addClassName("billing-info")
        .setStyle("margin-top", "30px")
        .setStyle("order", "3");


    this.add(mainLayout, footerLayout);
  }
  
  private void createMailingForm(ToggleEvent e) {
    if (e.isToggled()) {
      if (mailingStates.isEmpty() || mailingCountries.isEmpty()) {
        mailingZip.setAttribute("label", "Zip Code")
          .addClassName("customer-info__zip-code");

        populateStates();
        populateCountries();
        
        FlexLayout rowOne = FlexLayout.create(mailingTitle, mailingSubtitle)
          .vertical()
          .build()
          .setStyle("gap", "0"); 
        mailingTitle.setStyle("font-size", "16px")
          .setStyle("margin", "0"); 
        mailingSubtitle.setStyle("font-size", "12px")
          .setStyle("margin-top", ".5em")
          .setStyle("color", "#9ba8af");    
        
        FlexLayout rowTwo = FlexLayout.create(mailingFirstName, mailingLastName)
          .horizontal()
          .build()
          .setItemBasis("50%", mailingFirstName)
          .setItemBasis("50%", mailingLastName);
        
        FlexLayout rowThree = FlexLayout.create(mailingEmail, mailingPhone)
          .horizontal()
          .build()
          .setItemBasis("50%", mailingEmail)
          .setItemBasis("50%", mailingPhone);
        
        FlexLayout rowFour = FlexLayout.create(mailingCity, mailingStates, mailingZip)
          .horizontal()
          .build()
          .setItemBasis("50%", mailingCity)
          .setItemBasis("30%", mailingStates);
        mailingZip.setStyle("width", "20%");
        
        mailingLayout = FlexLayout.create(rowOne, rowTwo, mailingAddress, rowThree, rowFour, mailingCountries)
          .vertical() 
          .build()
          .addClassName("billing-info order-div-2")
          .setStyle("gap", "40px")
          .setStyle("order", "2");

        this.add(mailingLayout);
      } else {
        mailingLayout.setVisible(true);
      }
    } else {
      mailingLayout.setVisible(false);
      mailingAddress.setText("");
      mailingCity.setText("");
      mailingEmail.setText("");
      mailingFirstName.setText("");
      mailingLastName.setText("");
      mailingPhone.setText("");
      mailingCountries.deselect();
      mailingStates.deselect();
    }
  }

  private void populateCountries() {
    ChoiceBox countryDrop = new ChoiceBox();

    if (diffAddress.isChecked()) {
      countryDrop = mailingCountries;
    } else {
      countryDrop = countries;
    }
    
    countryDrop.setLabel("Country").setMaxRowCount(10); 
    countryDrop.add("US", "United States");
    countryDrop.add("CA", "Canada");
    countryDrop.add("MX", "Mexico");
    countryDrop.add("BR", "Brazil");
    countryDrop.add("AR", "Argentina");
    countryDrop.add("UK", "United Kingdom");
    countryDrop.add("FR", "France");
    countryDrop.add("DE", "Germany");
    countryDrop.add("IT", "Italy");
    countryDrop.add("ES", "Spain");
    countryDrop.add("CN", "China");
    countryDrop.add("JP", "Japan");
    countryDrop.add("IN", "India");
    countryDrop.add("AU", "Australia");
    countryDrop.add("NZ", "New Zealand");
    countryDrop.add("RU", "Russia");
    countryDrop.add("ZA", "South Africa");
    countryDrop.add("EG", "Egypt");
    countryDrop.add("NG", "Nigeria");
    countryDrop.add("KE", "Kenya");
    countryDrop.add("SA", "Saudi Arabia");
    countryDrop.add("AE", "United Arab Emirates");
    countryDrop.add("SG", "Singapore");
    countryDrop.add("TH", "Thailand");
    countryDrop.add("KR", "South Korea");
  }

  private void populateStates() {
    ChoiceBox stateDrop = new ChoiceBox();
    
    if (diffAddress.isChecked()) {
      stateDrop = mailingStates;
    } else {
      stateDrop = states;
    }

    stateDrop.setLabel("State").setMaxRowCount(10);
    stateDrop.add("AL", "Alabama");
    stateDrop.add("AK", "Alaska");
    stateDrop.add("AZ", "Arizona");
    stateDrop.add("AR", "Arkansas");
    stateDrop.add("CA", "California");
    stateDrop.add("CO", "Colorado");
    stateDrop.add("CT", "Connecticut");
    stateDrop.add("DE", "Delaware");
    stateDrop.add("FL", "Florida");
    stateDrop.add("GA", "Georgia");
    stateDrop.add("HI", "Hawaii");
    stateDrop.add("ID", "Idaho");
    stateDrop.add("IL", "Illinois");
    stateDrop.add("IN", "Indiana");
    stateDrop.add("IA", "Iowa");
    stateDrop.add("KS", "Kansas");
    stateDrop.add("KY", "Kentucky");
    stateDrop.add("LA", "Louisiana");
    stateDrop.add("ME", "Maine");
    stateDrop.add("MD", "Maryland");
    stateDrop.add("MA", "Massachusetts");
    stateDrop.add("MI", "Michigan");
    stateDrop.add("MN", "Minnesota");
    stateDrop.add("MS", "Mississippi");
    stateDrop.add("MO", "Missouri");
    stateDrop.add("MT", "Montana");
    stateDrop.add("NE", "Nebraska");
    stateDrop.add("NV", "Nevada");
    stateDrop.add("NH", "New Hampshire");
    stateDrop.add("NJ", "New Jersey");
    stateDrop.add("NM", "New Mexico");
    stateDrop.add("NY", "New York");
    stateDrop.add("NC", "North Carolina");
    stateDrop.add("ND", "North Dakota");
    stateDrop.add("OH", "Ohio");
    stateDrop.add("OK", "Oklahoma");
    stateDrop.add("OR", "Oregon");
    stateDrop.add("PA", "Pennsylvania");
    stateDrop.add("RI", "Rhode Island");
    stateDrop.add("SC", "South Carolina");
    stateDrop.add("SD", "South Dakota");
    stateDrop.add("TN", "Tennessee");
    stateDrop.add("TX", "Texas");
    stateDrop.add("UT", "Utah");
    stateDrop.add("VT", "Vermont");
    stateDrop.add("VA", "Virginia");
    stateDrop.add("WA", "Washington");
    stateDrop.add("WV", "West Virginia");
    stateDrop.add("WI", "Wisconsin");
    stateDrop.add("WY", "Wyoming");
  }

}