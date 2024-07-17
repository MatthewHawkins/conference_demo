package com.webforj.demo.pages.sections.dashboard.widgets.charts;

import java.text.DateFormatSymbols;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.webforj.component.googlecharts.GoogleChart;
import com.webforj.component.html.elements.Div;
import com.webforj.component.html.elements.Paragraph;
import com.webforj.utilities.Assets;

public final class LastSales extends Div {
    
  public LastSales() {
    addClassName("charsWrapper_chart card card--lastSales");

    Paragraph header = new Paragraph();
    header.addClassName("card_header")
      .setText("Sales Last Quarter");
    add(header);

    GoogleChart chart = new GoogleChart();
    chart.setType(GoogleChart.Type.COLUMN)
      .setStyle("width", "100%");

    Map<String, Object> options = new Gson().fromJson(Assets.contentOf("public/charts.json"), new TypeToken<Map<String, Object>>(){}.getType());

    chart.setOptions(options);

    // data [cols, rows]
    List<Object> data = new ArrayList<>();

    // cols
    List<Map<String, String>> cols = new ArrayList<>();
    String[] colNames = new String[] { "Month", "Sales", "Expenses" };
    String[] colTypes = new String[] { "string", "number", "number" };

    for (int i = 0; i < colNames.length; i++) {
      Map<String, String> col = new HashMap<>();
      col.put("label", colNames[i]);
      col.put("type", colTypes[i]);
      cols.add(col);
    }

    data.add(cols);

    // rows
    for (int i = 0; i < 3; i++) {
      List<Object> row = new ArrayList<>();
      row.add(new DateFormatSymbols().getShortMonths()[i]);
      row.add(Math.random() * 8000);
      row.add(Math.random() * 8000);
      data.add(row);
    }       

    chart.setData(data);
    add(chart);    
  }
}
