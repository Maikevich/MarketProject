package com.example.webparser.market.csgo;

import com.example.webparser.entity.CSGOItem;
import com.example.webparser.interfaces.pages.SignInPage;
import com.example.webparser.interfaces.pages.StartPage;
import com.example.webparser.market.csgo.CSGOMarketStartPageItemsParser;
import com.example.webparser.steam.SteamSignInPage;
import com.example.webparser.util.SeleniumConnector;
import lombok.AllArgsConstructor;
import lombok.Data;
import org.openqa.selenium.WebDriver;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Service;

import java.util.List;

@Data
@Service
@AllArgsConstructor
public class CSGOMarketLogginer {

    private final StartPage startPage;
    private final SignInPage signInPage;
    private SeleniumConnector seleniumConnector;


    @EventListener({ContextRefreshedEvent.class})
    public void start() {
        WebDriver webDriver = seleniumConnector.connect();
        MarketCSGOStartPage.openStartPage(webDriver);
        SteamSignInPage.signIn(webDriver);
    }

}
