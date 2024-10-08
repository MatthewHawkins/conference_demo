package com.webforj.demo.pages.sections.dashboard.widgets.charts;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.webforj.App;
import com.webforj.component.googlecharts.GoogleChart;
import com.webforj.component.html.elements.Div;
import com.webforj.component.html.elements.Paragraph;
import com.webforj.utilities.Assets;

public final class RevenueLocation extends Div {
  
  public RevenueLocation() {
    addClassName("chartsWrapper__chart card card--revenueLocation");

    Paragraph header = new Paragraph();
    header.addClassName("card__header")
      .setText("Revenue By Location");
    add(header);

    GoogleChart chart = new GoogleChart();
    chart.setType(GoogleChart.Type.GEO)
      .setStyle("width", "100%");

    // options
    Map<String, Object> options = new Gson().fromJson(Assets.contentOf("public/charts.json"), new TypeToken<Map<String, Object>>(){}.getType());
    options.put("legend", "none");
    chart.setOptions(options);

    // data [cols, rows]
    List<Object> data = new ArrayList<>();
        
    // cols
    List<String> cols = new ArrayList<>();
    cols.add("Country");
    cols.add("Revenue");
    data.add(cols);

    String[] countries = new String[] { "Germany", "United States", "Brazil", "Canada", "France", "ZA", "AU", "IN", "EG", "ES", "JP" };

    // rows
    for (String country : countries) {
      List<Object> row = new ArrayList<>();
      row.add(country);
      double number = Math.floor(Math.random() * 1000000)/100;
      String formatted = String.format("%.2f", number);
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
