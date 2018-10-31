package accountappexer;

import static org.junit.Assert.*;

import org.junit.Assert;
import org.junit.Test;

import com.qa.account.Account;
import com.qa.account.AccountManager;

public class AccountManagerTest {

	@Test
	public void noStreamTest() {
		
		Account a1  = new Account("Harrison", "Groome", 1234);
		Account a2  = new Account("Alvin", "Alvin", 1235);
		Account a3 = new Account("Alvin", "Test", 1236);
		AccountManager am  = new AccountManager();
		am.addAccount(a1);
		am.addAccount(a2);
		am.addAccount(a3);
		int count = am.countNameOccurences("Alvin");
		
		Assert.assertEquals(2, count);
		
	}
	
	@Test
	public void streamTest() {
		
		Account a1  = new Account("Harrison", "Groome", 1234);
		Account a2  = new Account("Alvin", "Alvin", 1235);
		Account a3 = new Account("Alvin", "Test", 1236);
		AccountManager am  = new AccountManager();
		am.addAccount(a1);
		am.addAccount(a2);
		am.addAccount(a3);
		long count = am.countNameOccurencesStream("Alvin");
		Assert.assertEquals(2, count);
		
	}
}
