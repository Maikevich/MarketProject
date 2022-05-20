package com.example.webparser;

import com.example.webparser.interfaces.pages.SignInPage;
import com.example.webparser.interfaces.pages.StartPage;
import com.example.webparser.util.SeleniumConnector;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.openqa.selenium.WebDriver;

import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class StartTest {
    @Mock
    private StartPage startPage;
    @Mock
    private SignInPage signInPage;
    @Mock
    private SeleniumConnector seleniumConnector;
    @InjectMocks
    private Start start;
    @Mock
    WebDriver webDriver;

    @BeforeEach
      void init() {
        when(seleniumConnector.connect()).thenReturn(webDriver);

    }

    @Test
      void startTest_should_use_connect_method() {

        start.start();
        verify(seleniumConnector, atLeastOnce()).connect();
    }

    @Test
      void startTest_should_use_openStartPage_method() {
        start.start();
        verify(startPage, atLeastOnce()).openStartPage(seleniumConnector.connect());
    }

    @Test
      void startTest_should_use_startAuthentication_method() {
        start.start();
        verify(startPage, atLeastOnce()).startAuthentication(seleniumConnector.connect());
    }

    @Test
      void startTest_should_use_signIn_method() {
        start.start();
        verify(signInPage, atLeastOnce()).signIn(seleniumConnector.connect());
    }

}