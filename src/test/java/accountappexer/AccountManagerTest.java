package accountappexer;

import static org.junit.Assert.*;

import org.junit.Assert;
import org.junit.Test;

import com.qa.persistence.domain.Account;
import com.qa.persistence.repository.AccountManagerImpl;
import com.qa.util.JsonObject;

public class AccountManagerTest {

	@Test
	public void noStreamTest() {
		
		Account a1  = new Account(1234, "Groome", "Harrison");
		Account a2  = new Account(1235, "Alvin", "Alvin");
		Account a3 = new Account(1236, "Test", "Alvin");
		AccountManagerImpl am  = new AccountManagerImpl();
		am.addAccount(a1);
		am.addAccount(a2);
		am.addAccount(a3);
		int count = am.countNameOccurences("Alvin");
		
		Assert.assertEquals(1, count);
		
	}
	
	@Test
	public void streamTest() {
		
		Account a1  = new Account(1234, "Groome", "Harrison");
		Account a2  = new Account(1235, "Alvin", "Alvin");
		Account a3 = new Account(1236, "Test", "Alvin");
		AccountManagerImpl am  = new AccountManagerImpl();
		am.addAccount(a1);
		am.addAccount(a2);
		am.addAccount(a3);
		long count = am.countNameOccurencesStream("Alvin");
		Assert.assertEquals(1, count);
		
	}
	
	
	@Test
	public void jsonConvert() {
		
		//Account a1  = new Account(1234, "Groome", "Harrison");
		//Account a2  = new Account(1235, "Alvin", "Alvin");
	//	Account a3 = new Account("Test", "Alvin");
		//System.out.println(a3);
		
		String test ="{\"fName\": \"Alvin\",\"lName\": \"Taylor\"}";
		
		JsonObject jo = new JsonObject();
		Account a3 = jo.JsonToObjectString(test);
		System.out.println(a3);
		//Assert.assertEquals(1, count);
		
	}
}
