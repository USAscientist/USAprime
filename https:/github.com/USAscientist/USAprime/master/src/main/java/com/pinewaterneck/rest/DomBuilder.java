package com.pinewaterneck.rest;

import java.io.StringWriter;
import java.io.UnsupportedEncodingException;
import java.util.HashMap;
import java.util.Map;

import org.dom4j.Attribute;
import org.dom4j.Document;
import org.dom4j.Element;
import org.dom4j.Namespace;
import org.dom4j.Node;
import org.dom4j.QName;
import org.dom4j.XPath;
import org.dom4j.io.HTMLWriter;
import org.dom4j.io.OutputFormat;
import org.dom4j.io.XMLWriter;
import org.dom4j.util.UserDataAttribute;
import org.dom4j.xpath.DefaultXPath;
import org.dom4j.DocumentFactory;

public class DomBuilder {
	
	public DomBuilder(){}
	public String getDom() {
		StringWriter sw = null;
		OutputFormat format = OutputFormat.createPrettyPrint();
		DefaultXPath path=null;
		Map spaces = new HashMap();
		spaces.put("h", "http://java.sun.com/jsf/html");
		spaces.put("f", "http://java.sun.com/jsf/core");
		spaces.put("p", "http://primefaces.org/ui");
		
		Document doc = DocumentFactory.getInstance().createDocument();
		String NS = new String("http://www.w3.org/1999/xhtml");
		Namespace H = new Namespace("h", "http://java.sun.com/jsf/html");
		Namespace F = new Namespace("f", "http://java.sun.com/jsf/core");
		Namespace P = new Namespace("p", "http://primefaces.org/ui");
		Element html = doc.addElement("html", NS).addAttribute("lang", "en");
		html.add(H);
		html.add(F);
		html.add(P);
		
		path = new DefaultXPath( "h:body//h:img[not(@alt)]" );
		path.setNamespaceURIs( spaces);
		Node node = path.selectSingleNode(doc);

		Attribute ns = new UserDataAttribute(new QName("xmlns"),"http//www.foo.man.chew") ;
		//html.add(ns);
		//html.add(nam);
		Element body = html.addElement("body");
		body.addElement("p:spinner");
		body.addText("FOOMANCHES");
		try {
			format.setXHTML(true);
			sw = new StringWriter();
			HTMLWriter writer = new HTMLWriter(sw,  format );
			writer.write(doc);
			writer.flush();
			
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return sw.toString();
	}
}
