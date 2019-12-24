package learningselenium.testdata.generic;

import java.io.FileInputStream;
import java.util.Properties;

public class Property {
	public static String getproperty(String filepath,String key)
	{
		String s="";
		try {
		Properties p=new Properties();
		p.load(new FileInputStream(filepath));
	 s = p.getProperty(key);
		}
		catch(Exception e)
		{
			
		}
		return s;
	}

}
