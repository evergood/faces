package com.egar.store.util;

import org.w3c.dom.NodeList;

import javax.enterprise.context.ApplicationScoped;
import javax.xml.soap.MessageFactory;
import javax.xml.soap.MimeHeaders;
import javax.xml.soap.SOAPBody;
import javax.xml.soap.SOAPConnection;
import javax.xml.soap.SOAPConnectionFactory;
import javax.xml.soap.SOAPException;
import javax.xml.soap.SOAPMessage;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.time.LocalDateTime;

@ApplicationScoped
public class SoapParser {

    private final static String XML_INPUT = "<?xml version=\"1.0\" encoding=\"utf-8\"?>\n" +
            "<soap12:Envelope xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\" " +
            "xmlns:xsd=\"http://www.w3.org/2001/XMLSchema\" " +
            "xmlns:soap12=\"http://www.w3.org/2003/05/soap-envelope\">\n" +
            "  <soap12:Body>\n" +
            "    <GetLatestDateTime xmlns=\"http://web.cbr.ru/\" />\n" +
            "  </soap12:Body>\n" +
            "</soap12:Envelope>";

    static public LocalDateTime getSoapDate() throws SOAPException, IOException {
        MessageFactory factory = MessageFactory.newInstance();
        MimeHeaders mimeHeaders = new MimeHeaders();
        mimeHeaders.addHeader("Content-Type", "application/soap+xml; charset=utf-8");
        mimeHeaders.addHeader("Host", "www.cbr.ru");
        SOAPMessage message = factory.createMessage(mimeHeaders,
                new ByteArrayInputStream(XML_INPUT.getBytes(StandardCharsets.UTF_8)));
        SOAPConnectionFactory soapConnectionFactory = SOAPConnectionFactory.newInstance();
        SOAPConnection soapConnection = soapConnectionFactory.createConnection();
        String url = "http://www.cbr.ru/DailyInfoWebServ/DailyInfo.asmx";
        SOAPMessage soapResponse = soapConnection.call(message, url);
        SOAPBody body = soapResponse.getSOAPBody();
        soapConnection.close();
        NodeList returnList = body.getElementsByTagName("GetLatestDateTimeResponse");
        String dateValue = returnList.item(0).getTextContent();
        return LocalDateTime.parse(dateValue);
    }
}

