package com.example.webparser.market.csgo;

import com.example.webparser.entity.CSGOItem;
import lombok.Data;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Data
public class CSGOMarketStartPageItemsParser {
    private CSGOMarketStartPageItemsParser() {
    }

    private static final List<Document> documentsList = new ArrayList<>();

    static {
        try {
            for (int i = 1; i < 11; i++) {
                documentsList.add(Jsoup.connect("https://market.csgo.com/?t=all&p=" + i + "&sd=desc").get());
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static List<CSGOItem> parseStartPageForItems() {
        List<String> urlsList = getItemUrlsFromPage();
        List<Double> priceList = getPricesFromPage();
        List<String> nameList = getItemNamesFromPage();
        List<CSGOItem> itemsList = new ArrayList<>();
        for (int i = 0; i < priceList.size(); i++) {
            CSGOItem item = new CSGOItem();
            item.setPrice(priceList.get(i));
            item.setNameAndCondition(nameList.get(i));
            item.setUrl(urlsList.get(i));
            itemsList.add(item);
        }
        return itemsList;
    }

    private static List<Double> getPricesFromPage() {
        List<Double> prices = new ArrayList<>();
        for (Document document : documentsList) {
            Elements elements = document.getElementsByClass("price");

            for (int i = 0; i < elements.size() - 9; i++) {
                String[] arr = elements.get(i).toString()
                        .replace("<div class=\"price\">", "")
                        .replace("&nbsp;<small></small>", "")
                        .replace("</div>", "").trim().replaceAll(" ", "").split(" ");
                Arrays.stream(arr).forEach(el -> prices.add(Double.parseDouble(el)));
            }
        }
        return prices;
    }

    private static List<String> getItemNamesFromPage() {
        List<String> names = new ArrayList<>();
        for (Document document : documentsList) {
            Elements elements = document.getElementsByClass("name");
            for (int i = 0; i < elements.size() - 9; i++) {
                String[] arr = elements.get(i).toString().split(">");
                String[] arr2 = arr[1].split("<");
                names.add(arr2[0].trim());

            }
        }
        return names;
    }

    private static List<String> getItemUrlsFromPage() {
        List<String> urls = new ArrayList<>();
        for (Document document : documentsList) {
            String[] arr = document.toString().split("href=\"");
            for (int i = 70; i < 126; i++) {
                String[] arr2 = arr[i].split("\">");
                urls.add(arr2[0]);
            }
        }
        return urls;
    }
}