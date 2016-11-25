package com.lynda.files;

import java.io.IOException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

public class ReadXML {

	public static void main(String[] args) {

		try {
			DocumentBuilderFactory factory =
					DocumentBuilderFactory.newInstance();
			DocumentBuilder builder = factory.newDocumentBuilder();
			Document doc = builder.parse("http://services.explorecalifornia.org/rss/tours.php");
			
			NodeList list = doc.getElementsByTagName("title");
			System.out.println("There are " + list.getLength() + " items");

			for (int i = 0; i < list.getLength(); i++) {
				Element item = (Element)list.item(i);
				System.out.println(item.getFirstChild().getNodeValue());
			}
			
		} catch (ParserConfigurationException e) {
			e.printStackTrace();
		} catch (SAXException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		
	}

}
