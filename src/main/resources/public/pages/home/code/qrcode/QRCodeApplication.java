public class QrCodeApplication extends App {

    @Override
    public void run() throws WebforjException {
      String text = "https://dwcj.org/";
  
      QRCode qr = new QRCode();
      qr.setValue(text);
  
      TextField input = new TextField(text);
      input.onEditModify(e -> {
        qr.setValue(input.getText());
      });
    }
  }