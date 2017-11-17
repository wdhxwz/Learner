package com.wangdh.learner.base.ini;

import java.io.File;
import java.io.IOException;

import org.ini4j.Ini;
import org.ini4j.InvalidFileFormatException;
import org.ini4j.Profile.Section;

public class IniApp {

	public static void main(String[] args) throws InvalidFileFormatException, IOException {
		String filePath="D:/test/test.ini";
		Ini ini = new Ini(new File(filePath));
	
		Section section = ini.get("TestSect1");
		System.out.println(section.get("10012"));
		
		section.add("name", "wangdh");
		
		ini.add("section", "option", "value");
		
		ini.store();
	}
}
