package com.epam.bench.e04.domandsax;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

public class DOMAndSAXFactories {

	public static void main(String[] args) throws ParserConfigurationException {
		createDocumentBuilderOldStyle();
		createDocumentBuilderNewStyle();
	}

	private static DocumentBuilder createDocumentBuilderOldStyle() throws ParserConfigurationException {
		DocumentBuilderFactory dbf = DocumentBuilderFactory.newDefaultInstance();
		dbf.setNamespaceAware(true);
		return dbf.newDocumentBuilder();
	}

	private static DocumentBuilder createDocumentBuilderNewStyle() throws ParserConfigurationException {
		return DocumentBuilderFactory.newDefaultNSInstance().newDocumentBuilder();
	}
}
