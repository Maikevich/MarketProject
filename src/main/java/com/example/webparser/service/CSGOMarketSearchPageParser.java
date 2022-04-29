package com.example.webparser.service;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class CSGOMarketSearchPageParser {


    public static List<Elements> parseCSGOMarketSearchPages(List<String> urlsList) {

        List<Elements> csgoMarketSearchPagesList = new ArrayList<>();
        urlsList.forEach(url -> {
            try {
                csgoMarketSearchPagesList.add(Jsoup.connect(url).get().getElementsByClass("price"));
            } catch (IOException e) {
                e.printStackTrace();
            }
        });
        urlsList.forEach(System.out::println);
        return csgoMarketSearchPagesList;
    }
}
