package com.webforj.demo.pages.sections.ecom.checkout.widgets;

import com.webforj.component.button.Button;
import com.webforj.component.button.ButtonTheme;
import com.webforj.component.field.TextField;
import com.webforj.component.html.elements.Div;
import com.webforj.component.html.elements.Paragraph;
import com.webforj.component.layout.flexlayout.FlexLayout;
import com.webforj.component.list.ChoiceBox;
import com.webforj.component.maskednumberfield.MaskedNumberField;
import com.webforj.component.optioninput.RadioButton;

public class BillingInfo extends Div{
  private Paragraph title = new Paragraph("Billing Information");
  private Paragraph subtitle = new Paragraph("Fill in the form below to receive an invoice for your order.");
  private TextField firstName = new TextField();
  private TextField lastName = new TextField();
  private TextField email = new TextField();
  private TextField phone = new TextField();
  private TextField address = new TextField();
  private TextField city = new TextField();
  private TextField orderNotes = new TextField();
  private ChoiceBox states = new ChoiceBox();
  private ChoiceBox countries = new ChoiceBox();
  private MaskedNumberField zip = new MaskedNumberField();
  private RadioButton diffAddress = new RadioButton();
  private Button submit = new Button();
  private Button back = new Button();

  public BillingInfo() {
    firstName.setLabel("First Name");
    lastName.setLabel("Last Name");
    email.setLabel("Email");
    phone.setLabel("Phone");
    address.setLabel("Address");
    city.setLabel("City");
    zip.setAttribute("label", "Zip Code");

    populateStates();
    populateCountries();

    diffAddress.setText("Ship to different address?");
    orderNotes.setPlaceholder("Write order notes...")
      .setLabel("Order Notes");

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

    FlexLayout mainLayout = FlexLayout.create()
      .vertical() 
      .build()
      .addClassName("billing-info")
      .setStyle("gap", "40px");

    FlexLayout rowOne = FlexLayout.create(title, subtitle)
      .vertical()
      .build();
    title.setStyle("font-size", "16px");
    subtitle.setStyle("font-size", "12px")
      .setStyle("color", "#9ba8af");    

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

    mainLayout.add(rowOne, rowTwo, address, rowThree, rowFour, countries, diffAddress, orderNotes, rowFive);
      
    Div billingInfo = new Div(mainLayout);
    this.add(billingInfo);
  }

  private void populateCountries() {
    countries.setLabel("Country").setMaxRowCount(10); 
    countries.add("US", "United States");
    countries.add("CA", "Canada");
    countries.add("MX", "Mexico");
    countries.add("BR", "Brazil");
    countries.add("AR", "Argentina");
    countries.add("UK", "United Kingdom");
    countries.add("FR", "France");
    countries.add("DE", "Germany");
    countries.add("IT", "Italy");
    countries.add("ES", "Spain");
    countries.add("CN", "China");
    countries.add("JP", "Japan");
    countries.add("IN", "India");
    countries.add("AU", "Australia");
    countries.add("NZ", "New Zealand");
    countries.add("RU", "Russia");
    countries.add("ZA", "South Africa");
    countries.add("EG", "Egypt");
    countries.add("NG", "Nigeria");
    countries.add("KE", "Kenya");
    countries.add("SA", "Saudi Arabia");
    countries.add("AE", "United Arab Emirates");
    countries.add("SG", "Singapore");
    countries.add("TH", "Thailand");
    countries.add("KR", "South Korea");
  }

  private void populateStates() {
    states.setLabel("State").setMaxRowCount(10);
    states.add("AL", "Alabama");
    states.add("AK", "Alaska");
    states.add("AZ", "Arizona");
    states.add("AR", "Arkansas");
    states.add("CA", "California");
    states.add("CO", "Colorado");
    states.add("CT", "Connecticut");
    states.add("DE", "Delaware");
    states.add("FL", "Florida");
    states.add("GA", "Georgia");
    states.add("HI", "Hawaii");
    states.add("ID", "Idaho");
    states.add("IL", "Illinois");
    states.add("IN", "Indiana");
    states.add("IA", "Iowa");
    states.add("KS", "Kansas");
    states.add("KY", "Kentucky");
    states.add("LA", "Louisiana");
    states.add("ME", "Maine");
    states.add("MD", "Maryland");
    states.add("MA", "Massachusetts");
    states.add("MI", "Michigan");
    states.add("MN", "Minnesota");
    states.add("MS", "Mississippi");
    states.add("MO", "Missouri");
    states.add("MT", "Montana");
    states.add("NE", "Nebraska");
    states.add("NV", "Nevada");
    states.add("NH", "New Hampshire");
    states.add("NJ", "New Jersey");
    states.add("NM", "New Mexico");
    states.add("NY", "New York");
    states.add("NC", "North Carolina");
    states.add("ND", "North Dakota");
    states.add("OH", "Ohio");
    states.add("OK", "Oklahoma");
    states.add("OR", "Oregon");
    states.add("PA", "Pennsylvania");
    states.add("RI", "Rhode Island");
    states.add("SC", "South Carolina");
    states.add("SD", "South Dakota");
    states.add("TN", "Tennessee");
    states.add("TX", "Texas");
    states.add("UT", "Utah");
    states.add("VT", "Vermont");
    states.add("VA", "Virginia");
    states.add("WA", "Washington");
    states.add("WV", "West Virginia");
    states.add("WI", "Wisconsin");
    states.add("WY", "Wyoming");
  }

}