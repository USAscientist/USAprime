package com.pinewaterneck.beans;

import java.io.Serializable;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;

@ManagedBean
public class TerminalView implements Serializable {
	
	@PostConstruct
	public void initialize() {
		System.out.println("TerminalView-----    initialize");
	}
	public String handleCommand(String command, String[] param) {
		String s = new String();
		System.out.println("TerminalView-----    handlecommand");
		return s;	
	}

}
