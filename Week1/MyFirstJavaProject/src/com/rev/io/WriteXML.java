package com.rev.io;

import java.io.File;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.w3c.dom.*;


public class WriteXML {

	static String filename = "src/logs/samplexml.xml";
			
	public static void main(String[] args) {
		try {
			DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
		
			DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
			
			Document doc = dBuilder.newDocument();
			
			//add elements:
			
			
			
			
			
			//root element:
			
			Element root = doc.createElement("cars");
			doc.appendChild(root);
			
			//other elements:
			
			/*Element 1
			 * luxury company = ferrari;
			 */
			Element lux = doc.createElement("luxury");
			root.appendChild(lux);
			
			Attr attr = doc.createAttribute("company");
			attr.setValue("Ferrari");
			lux.setAttributeNode(attr);
			
			/*Element 2
			 * broke ride = coop;
			 */
			
			Element broke = doc.createElement("Broke");
			root.appendChild(broke);
			
			Attr attrTwo = doc.createAttribute("Ride");
			attrTwo.setValue("Coop");
			broke.setAttributeNode(attrTwo);
			
			/*Element 3
			 *  wavy ride = lambo;
			 */

			Element wavy = doc.createElement("Wavy");
			root.appendChild(wavy);
			
			Attr attrThree = doc.createAttribute("Ride");
			attrThree.setValue("Lambo");
			wavy.setAttributeNode(attrThree);
			
			
			
			//write the content to xml
			
			TransformerFactory tf = TransformerFactory.newInstance();
			Transformer tr = tf.newTransformer();
			DOMSource source = new DOMSource(doc);
			StreamResult result = new StreamResult(new File(filename));
			tr.transform(source, result);
			StreamResult consoleResult = new StreamResult(System.out);
			tr.transform(source, consoleResult);
			
			
			
		}
		catch (Exception e) {
			e.printStackTrace();
		}
	}
		
}
