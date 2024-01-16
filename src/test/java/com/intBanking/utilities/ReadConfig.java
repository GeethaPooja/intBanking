package com.intBanking.utilities;

import java.io.File;
import java.io.FileInputStream;
import java.util.Properties;

public class ReadConfig {
	
	Properties pro;
	
	public ReadConfig()
	{
		File src=new File("./Configuration/config.properties"); //reading data
		
		try
		{
			FileInputStream fis=new FileInputStream(src); //import using fileinputstream or file in read mode
			pro=new Properties();
			pro.load(fis);
		}catch(Exception e) {
			System.out.println("Exception is "+e.getMessage());
		}
	}
		
		public String getApplicationURL()
		{
		String url=pro.getProperty("baseURL");
		return url;
		}
		
		public String getUsername()
		{
		String username=pro.getProperty("username");
		return username;
		}
		
		public String getPassword()
		{
		String password=pro.getProperty("password");
		return password;
		}
		
		public String getChromePath()
		{
		String chromepath=pro.getProperty("chromepath");
		return chromepath;
		}
		
		public String getEdgePath()
		{
		String edgepath=pro.getProperty("edgepath");
		return edgepath;
		}
		
		public String getIEPath()
		{
		String iepath=pro.getProperty("iepath");
		return iepath;
		}
		
	}


	


