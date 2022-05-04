package com.example.webparser;

import com.example.webparser.interfaces.SignInPage;
import com.example.webparser.interfaces.StartPage;
import com.example.webparser.util.SeleniumConnector;
import lombok.AllArgsConstructor;
import lombok.Data;
import org.openqa.selenium.WebDriver;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Service;

@Data
@Service
@AllArgsConstructor
public class Start {

    private final StartPage startPage;
    private final SignInPage signInPage;
    private SeleniumConnector seleniumConnector;


    @EventListener({ContextRefreshedEvent.class})
    public void start() {
        WebDriver webDriver = seleniumConnector.connect();
        startPage.openStartPage(webDriver);
        startPage.startAuthentication(webDriver);
        signInPage.signIn(webDriver);
    }

}
