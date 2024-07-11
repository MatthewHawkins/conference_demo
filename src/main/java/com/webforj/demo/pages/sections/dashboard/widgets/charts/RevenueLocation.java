package com.webforj.demo.pages.sections.dashboard.widgets.charts;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.webforj.component.html.elements.Div;
import com.webforj.component.html.elements.Paragraph;
import com.webforj.utilities.Assets;

public final class RevenueLocation extends Div {

    public RevenueLocation() {
        addClassName("chartsWrapper_chart card card--revenueLocation");

        Paragraph header = new Paragraph();
        header.addClassName("card_header");
        header.setText("Revenue By Location");
        add(header);

        GoogleChart chart = new GoogleChart();
        chart.setType(GoogleChart.Type.GEO);
        chart.setStyle("width", "100%");

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

        String[] countries = new String[] { "Germany", "United States", "Brazil", "Canada", "France", "RU" };

        // rows
        for (String country : countries) {
            List<Object> row = new ArrayList<>();
            row.add(country);
            row.add(Math.random() * 10000);
            data.add(row);
        }

        chart.setData(data);
        add(chart);
    }
    
}
