package com.qa.app;

import com.qa.account.Account;
import com.qa.account.AccountManager;

public class App {
	private App(){
		
	}
	public static void main(String[] args) {
		System.out.println("hello world to the standard out");
		Account a1  = new Account("Harrison", "Groome", 1234);
		Account a2  = new Account("Alvin", "Alvin", 1235);
		AccountManager am  = new AccountManager();
		am.addAccount(a1);
		am.addAccount(a2);
		System.out.println(am.getAccounts());
		am.deleteAccount(1234);
		System.out.println(am.getAccounts());
	}

}
