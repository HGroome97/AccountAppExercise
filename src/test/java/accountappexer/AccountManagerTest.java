package accountappexer;

import static org.junit.Assert.*;

import org.junit.Assert;
import org.junit.Test;

import com.qa.business.service.AccountManagerImpl;
import com.qa.persistence.domain.Account;

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
}
