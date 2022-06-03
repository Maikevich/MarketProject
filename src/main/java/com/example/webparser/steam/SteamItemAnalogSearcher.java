package com.example.webparser.steam;

import com.example.webparser.entity.CSGOItem;
import com.example.webparser.entity.SteamItem;
import lombok.Data;
import org.jsoup.HttpStatusException;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;

import java.io.IOException;
import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;
import java.util.stream.Collectors;

@Data
public class SteamItemAnalogSearcher {
    private SteamItemAnalogSearcher() {
    }

    public static List<SteamItem> searchItemAnalogOnSteam(List<CSGOItem> itemsList) {
        System.out.println("Ищу аналоги на стиме");
        List<SteamItem> steamItems = new ArrayList<>();
        AtomicReference<AtomicInteger> count = new AtomicReference<>(new AtomicInteger());
        itemsList.forEach(item -> {
            if (!item.getCondition().equals("")) {
                try {

                    String itemUrl = item.getName()
                            .replace(" ", "+") + "+" + item.getCondition().replace(" ", "+");
                    String encodedUrl = URLEncoder.encode(itemUrl.replace("\\|", "%7C"), StandardCharsets.UTF_8);

                    itemUrl = "https://steamcommunity.com/market/search?q=" + encodedUrl;
                    steamItems.add(new SteamItem(item.getName(), item.getCondition(),
                            getItemUrl(Jsoup.connect(itemUrl)
                                    .get()
                                    .getElementsByClass("market_listing_row_link")),
                            getPriceByName(item.getName() + " " + item.getCondition())));
                    count.get().getAndIncrement();
                    if (count.get().get() == 15) {
                        System.out.println("Передышка 5 мин");
                        Thread.sleep(300000);
                        System.out.println("За работу");
                        count.set(new AtomicInteger());
                    }
                } catch (IOException | InterruptedException e) {
                    e.printStackTrace();

                }
            }
        });
        return steamItems;
    }

    private static String getItemUrl(Elements elements) {
        if (!elements.isEmpty()) {
            String[] arr = elements.get(0).toString().split("href=\"");
            String[] arr2 = arr[1].split("\"");
            return arr2[0];
        }
        return "Нет в продаже";
    }

    public static Double getPriceByName(String name) throws IOException {
        System.out.println(name);
        String price = "";
        String url = "https://steamcommunity.com/market/" +
                "itemordershistogram?country=AT&language=russian&currency=" +
                "5&item_nameid=" + SteamItemsCodeMap.getMap().get(name) + "&two_factor=0";

        try {
            price = parsePrice(Jsoup.connect(url).ignoreContentType(true).get());
        } catch (NumberFormatException n) {
            System.out.println("Цена не конвертируется");

        } catch (HttpStatusException hse) {
            System.out.println(name + " нет в списке id");
        }
        if (!price.isEmpty()) {
            return Double.parseDouble(price);
        }
        return 0.0;
    }

    private static String parsePrice(Document doc) {
        String str = doc.toString();
        try {
            return Arrays.stream(Arrays.stream
                    (Arrays.stream
                            (Arrays.stream
                                    (str.split(("Запросов на покупку:")))
                                    .collect(Collectors.toList())
                                    .get(1).split("span"))
                            .collect(Collectors.toList())
                            .get(3).split("\">"))
                    .collect(Collectors.toList())
                    .get(1).split(" "))
                    .collect(Collectors.toList())
                    .get(0).trim().replace(",", ".");
        } catch (
                ArrayIndexOutOfBoundsException a) {
            System.out.println("цену не распарсить");
        }
        return "0.0";
    }

}
