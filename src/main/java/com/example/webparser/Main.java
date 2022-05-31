package com.example.webparser;

import com.example.webparser.entity.CSGOItem;
import com.example.webparser.entity.SteamItem;
import com.example.webparser.market.csgo.CSGOMarketStartPageItemsParser;
import com.example.webparser.service.ProfitableItemsFinder;
import com.example.webparser.steam.SteamItemAnalogSearcher;

import java.io.IOException;
import java.util.List;

public class Main {
    public static void main(String[] args) throws IOException {
        List<CSGOItem> items = CSGOMarketStartPageItemsParser.parseStartPageForItems();
        List<SteamItem> list = SteamItemAnalogSearcher.searchItemAnalogOnSteam(items);
        ProfitableItemsFinder.findProfitableItems(items, list   );

    }
}