package com.example.webparser.market.csgo;

import com.example.webparser.entity.CSGOItem;
import com.example.webparser.service.CSGOMarketSearchPageParser;
import com.example.webparser.service.FromCSGOMarketToSteamNameConverter;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

@Data
@NoArgsConstructor
public class CSGOMarketStartPageItemsParser {


    private static final List<Document> csgoMarketStartPagesList = new ArrayList<>();

    static {
        try {
            for (int i = 1; i < 2; i++) {
                csgoMarketStartPagesList.add(Jsoup.connect("https://market.csgo.com/?t=all&p=" + i + "&sd=desc").get());
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static List<CSGOItem> parseStartPageForItems() {
        List<List<String>> csgoMarketItemNameList = getItemNamesFromPage();
        List<Double> csgoMarketPriceList = getPricesFromCSGOMarketStartPage(csgoMarketItemNameList);
        List<String> csgoMarketUrlsList = getItemUrlsFromPage();


        List<CSGOItem> csgoItemList = new ArrayList<>();
        for (int i = 0; i < csgoMarketPriceList.size(); i++) {
            CSGOItem item = new CSGOItem();
            item.setPrice(csgoMarketPriceList.get(i));
            item.setName(csgoMarketItemNameList.get(0).get(i));
            item.setCondition(csgoMarketItemNameList.get(1).get(i));
            item.setUrl(csgoMarketUrlsList.get(i));
            csgoItemList.add(item);
        }
        csgoItemList.stream().forEach(System.out::println);
        return csgoItemList;
    }

    private static List<String> getItemUrlsFromPage() {
        List<String> urls = new ArrayList<>();
        for (Document document : csgoMarketStartPagesList) {
            Arrays.stream(document.toString()
                            .split("href=\""))
                    .skip(70)
                    .limit(56)
                    .map(el -> Stream.of(el.split("\">")).findFirst())
                    .forEach(result -> urls.add(result.get()));
        }
        return urls;
    }

    private static List<Double> getPricesFromCSGOMarketStartPage(List<List<String>> fullNamesAndConditionsList) {

        List<Double> csgoStartPagesPrices = new ArrayList<>();
        List<String> csgoStartPagesPricesUrls = new ArrayList<>();
        for (int i = 0; i < fullNamesAndConditionsList.get(0).size(); i++) {
            csgoStartPagesPricesUrls.add("https://market.csgo.com/?s=price&t=all&search=" +
                    fullNamesAndConditionsList
                            .get(0)
                            .get(i)
                            .replaceAll(" ", "%20")
                            .replaceAll("\\|", "%7C")
                    + "%20" +
                    fullNamesAndConditionsList
                            .get(1)
                            .get(i)
                            .replaceAll(" ", "%20") + "&sd=asc"
            );
        }

        List<Elements> csgoMarketSearchPages;
        csgoMarketSearchPages = CSGOMarketSearchPageParser.parseCSGOMarketSearchPages(csgoStartPagesPricesUrls);
        csgoMarketSearchPages.stream().forEach(el ->
                csgoStartPagesPrices.add(Double.valueOf(el.stream()
                        .map(element -> element.toString().replaceAll("[<div class=\"price\">&nbsp;<small></small>\n" +
                                "</div>]", ""))
                        .findFirst()
                        .get())
                ));


        return csgoStartPagesPrices;
    }





    private static List<List<String>> getItemNamesFromPage() {
        List<String> csgoMarketItemsConvertedConditionsList = new ArrayList<>();
        List<String> csgoItemsFullConvertedNamesList = new ArrayList<>();

        for (Document document : csgoMarketStartPagesList) {
            Elements elements = document.getElementsByClass("name");

            elements.stream()
                    .limit(elements.size() - 9)
                    .forEach(el -> Stream.of(el.toString().split(">"))
                            .skip(1)
                            .forEach(lastEl -> Stream.of(lastEl.split("<"))
                                    .limit(1)
                                    .map(String::trim)
                                    .forEach(fullName -> {
                                        if (!fullName.contains(")")) {
                                            csgoItemsFullConvertedNamesList.add(fullName);
                                            csgoMarketItemsConvertedConditionsList.add("");
                                        }
                                        Stream.of(fullName.split("[()]"))
                                                .map(String::trim)
                                                .reduce((el1, el2) -> csgoMarketItemsConvertedConditionsList
                                                        .add(FromCSGOMarketToSteamNameConverter.convertCondition(el2.trim()))
                                                        + "" +
                                                        Stream.of(el1.trim().split("\\|"))
                                                                .map(String::trim)
                                                                .reduce((name, nick) ->
                                                                        String.valueOf(csgoItemsFullConvertedNamesList
                                                                                .add(name + " | " +
                                                                                        FromCSGOMarketToSteamNameConverter
                                                                                                .convertNickName(nick))))
                                                );
                                    })
                            )
                    );
        }

        List<List<String>> resultList = List.of(csgoItemsFullConvertedNamesList, csgoMarketItemsConvertedConditionsList);
        return resultList;
    }


}