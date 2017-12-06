package com.revature.io;

import java.io.File;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.w3c.dom.Attr;
import org.w3c.dom.Document;
import org.w3c.dom.Element;

public class WriteXML {

	static String filename = "src/logs/samplexml.xml";

	public static void main(String[] args) {
		try {
			DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();

			DocumentBuilder db = dbf.newDocumentBuilder();

			Document doc = db.newDocument();

			Element root = doc.createElement("cars");
			doc.appendChild(root);

			Element lux = doc.createElement("luxury");
			root.appendChild(lux);

			Attr attr = doc.createAttribute("company");
			attr.setValue("Ferrari");
			lux.setAttributeNode(attr);
			
			Element eco = doc.createElement("economy");
			root.appendChild(eco);

			Attr attr2 = doc.createAttribute("company");
			attr2.setValue("Nissan");
			eco.setAttributeNode(attr2);

			TransformerFactory tf = TransformerFactory.newInstance();
			Transformer tr = tf.newTransformer();
			DOMSource source = new DOMSource(doc);
			StreamResult result = new StreamResult(new File(filename));
			tr.transform(source, result);
			StreamResult consoleResult = new StreamResult(System.out);
			tr.transform(source, consoleResult);

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
