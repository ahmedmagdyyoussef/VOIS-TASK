package ConfigurationManuplation;
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.OutputStream;
import java.util.Properties;

public class ConfigFileReader {
	
	private Properties properties;
	private final String propertyFilePath= "Config/Configuration.properties";


	public ConfigFileReader(){
		BufferedReader reader;
		try {
			reader = new BufferedReader(new FileReader(propertyFilePath));
			properties = new Properties();
			try {
				properties.load(reader);
				reader.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
			throw new RuntimeException("Configuration.properties not found at " + propertyFilePath);
		}		
	}
	
	public String GetDriverLocation(){
		String driverPath = properties.getProperty("DriverPath");
		if(driverPath!= null) return driverPath;
		else throw new RuntimeException("driverPath not specified in the Configuration.properties file.");		
	}
	
	
	public String GetPortalURL() {
		String url = properties.getProperty("URL");
		if(url != null) return url;
		else throw new RuntimeException("url not specified in the Configuration.properties file.");
	}
	public String GetCounter() {
		String email = properties.getProperty("Email");
		if(email != null) return email;
		else throw new RuntimeException("url not specified in the Configuration.properties file.");
	}
	public void SetRegisterMail(String Counter) throws IOException{
		FileInputStream in = new FileInputStream(propertyFilePath);
		Properties props = new Properties();
		props.load(in);
		in.close();

		FileOutputStream out = new FileOutputStream(propertyFilePath);
		props.setProperty("Email",Counter);
		props.store(out, null);
		out.close();
	
		
	}
}
