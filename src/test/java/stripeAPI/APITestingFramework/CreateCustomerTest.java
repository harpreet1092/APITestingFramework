package stripeAPI.APITestingFramework;
import static io.restassured.RestAssured.*;

import java.util.Hashtable;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.ctc.wstx.util.DataUtil;

import BaseFile.BaseSetup;
import excel.utilities.Datautil;
import io.restassured.response.Response;

public class CreateCustomerTest extends BaseSetup {
	
	@Test(dataProviderClass=Datautil.class,dataProvider="data")
	public void CreateCustomerData(Hashtable<String,String>data)
	{
	
		Response response =given().auth().basic(config.getProperty("validSecretKey"),"").formParam(data.get("Name")).formParam(data.get("Email")).post(config.getProperty("EndPoint"));
	    response.prettyPrint(); 
	    Assert.assertEquals(response.getStatusCode(), 200);
	
	
	}
	
	@Test(dataProviderClass=Datautil.class,dataProvider="data")
	public void invalidCustData(Hashtable<String,String>data)
	{
	
		Response response =given().auth().basic(config.getProperty("invalidSecretKey"),"").formParam(data.get("Name")).formParam(data.get("Email")).post(config.getProperty("EndPoint"));
	    response.prettyPrint(); 
	    Assert.assertEquals(response.getStatusCode(), 200);
	
	
	}
	
	
	

}
