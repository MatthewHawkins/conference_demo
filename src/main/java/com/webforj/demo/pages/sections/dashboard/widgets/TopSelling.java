package com.webforj.demo.pages.sections.dashboard.widgets;

import com.webforj.component.html.elements.Div;
import com.webforj.component.html.elements.Paragraph;
import com.webforj.component.table.Table;
import com.webforj.component.table.renderer.Renderer;
import com.webforj.demo.pages.sections.dashboard.widgets.table.ProductRecord;
import com.webforj.demo.pages.sections.dashboard.widgets.table.Service;

public final class TopSelling extends Div {

  public TopSelling() {
    Div card = new Div()
      .addClassName("card card__top-selling");

    Paragraph header = new Paragraph("Top Selling Products")
      .addClassName("card__header")
      .setText("Top Selling Products");
    card.add(header);

    Table<ProductRecord> table = new Table<>();
    table.setStyle("width", "100%")
      .setStyle("height", "542px")
      .setRowHeight(60.0)
      .setHeaderHeight(60.0);

    table.addColumn("ProductName", ProductRecord::getProduct).setHidden(true);
    table.addColumn("Product", new AvatarRenderer()).setMinWidth(300f);
    table.addColumn("Price", ProductRecord::getPrice).setComparator((a, b) -> {
      String numericPartA = a.getPrice().substring(1);
      String numericPartB = b.getPrice().substring(1);
      if(Float.parseFloat(numericPartA) > Float.parseFloat(numericPartB)){
        return 1;
      } else if (Float.parseFloat(numericPartB) > Float.parseFloat(numericPartA)){
        return -1;
      } else{
        return 0;
      }
    });
    table.addColumn("Quantity", ProductRecord::getQuantity);
    table.addColumn("Amount", ProductRecord::getAmount).setComparator((a, b) -> {
      String numericPartA = a.getAmount().replaceAll("[$,]", "");
      String numericPartB = b.getAmount().replaceAll("[$,]", "");
      if(Float.parseFloat(numericPartA) > Float.parseFloat(numericPartB)){
        return 1;
      } else if (Float.parseFloat(numericPartB) > Float.parseFloat(numericPartA)){
        return -1;
      } else{
        return 0;
      }
    });
    table.addColumn("Image", ProductRecord::getImageURL).setHidden(true);

    table.getColumns().forEach(column -> {
      if (column.getLabel().equalsIgnoreCase("product")) {
        return;
      }
      column.setSortable(true);
    });

    table.setRepository(Service.getProductRecords())
      .addClassName("table");
    card.add(table);

    add(card);
  }

  class AvatarRenderer extends Renderer<ProductRecord> {
    @Override

    public String build() {
      return /* html */"""
        <%
        const product = cell.row.getValue('ProductName');
        const imageURL = cell.row.getValue('Image')
        %>
        <div part='avatar-renderer'>
          <img
            part='avatar-img'
            src='<%= imageURL %>' />
          <div part="avatar-text">
            <%= product %>
          </div>
        </div>
      """;
    }
  }
}
