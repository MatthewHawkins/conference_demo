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
    addClassName("chartsWrapper__chart card card--lastSales");

    Paragraph header = new Paragraph();
    header.addClassName("card__header")
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
      double number = Math.floor(Math.random() * 800000) / 100;
      String formatted = String.format("%.2f", number);
      if (formatted.endsWith("0")) {
        number += 0.01;
      }
      row.add(number);

      number = Math.floor(Math.random() * 800000) / 100;
      formatted = String.format("%.2f", number);
      if (formatted.endsWith("0")) {
        number += 0.01;
      }
      row.add(number);
      data.add(row);
    }       

    chart.setData(data);
    add(chart);    
  }
}
