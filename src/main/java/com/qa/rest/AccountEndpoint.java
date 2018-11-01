package com.qa.rest;

import javax.inject.Inject;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;

import org.apache.log4j.Logger;

import com.qa.business.service.AccountService;
import com.qa.persistence.domain.Account;
import com.qa.util.JsonObject;

@Path("/account")
public class AccountEndpoint {
	
	@Inject
	private AccountService service;
	
	@Inject
	private JsonObject jsonOb;

	@Path("/getAllAccounts")
	@GET
	@Produces({ "application/json" })
	public String getAllAccounts() {
		return service.getAllAccounts();
	}

	@Path("/createAccount")
	@POST
	@Produces({ "application/json" })
	public String addAccount(String account) {
		return service.addAccount(account);
	}

	@Path("/updateAccount")
	@PUT
	@Produces({ "application/json" })
	public String updateAccount(String account) {
		Account acc = jsonOb.JsonToObjectString(account);
		return service.updateAccount(acc);
	}
	
	@Path("/deleteAccount/{id}")
	@DELETE
	@Produces({ "application/json" })
	public String deleteAccount(@PathParam("id") int id) {
		return service.deleteAccount(id);
	}
	
	@Path("/getAccount/{id}")
	@GET
	@Produces({ "application/json" })
	public String getAccount(@PathParam("id") int id) {
		return service.getAccount(id);
	}

	public void setService(AccountService service) {
		this.service = service;
	}

}
