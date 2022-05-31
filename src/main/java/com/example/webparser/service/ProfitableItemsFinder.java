package com.example.webparser.service;

import com.example.webparser.entity.CSGOItem;
import com.example.webparser.entity.SteamItem;

import java.util.List;

public class ProfitableItemsFinder {


    public static void findProfitableItems(List<CSGOItem> csgoItemList, List<SteamItem> steamItemsList) {
        csgoItemList.forEach(csgoItem -> steamItemsList
                .forEach(steamItem -> {
                    if (steamItem.getPrice() > 0.0 &&
                            csgoItem.getName().equals(steamItem.getName()) && csgoItem.getCondition().equals(steamItem.getCondition())) {
                        if (csgoItem.getPrice() - steamItem.getPrice() > (csgoItem.getPrice() * 0.1)) {
                            System.out.println(csgoItem + "\n" + steamItem);
                        }
                    }
                }));
    }

}
