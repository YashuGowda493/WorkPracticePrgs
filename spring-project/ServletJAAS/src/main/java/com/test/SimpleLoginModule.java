package com.test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

import javax.security.auth.Subject;
import javax.security.auth.callback.Callback;
import javax.security.auth.callback.CallbackHandler;
import javax.security.auth.callback.NameCallback;
import javax.security.auth.callback.PasswordCallback;
import javax.security.auth.login.LoginException;
import javax.security.auth.spi.LoginModule;

public class SimpleLoginModule implements LoginModule {
	private Subject subject;
	private CallbackHandler callbackhandler;
	private String username;
	private List<String> roles=new ArrayList<>();
	private List<UserPrincipal> principals=new ArrayList<>();
	@Override
	public void initialize(Subject subject, CallbackHandler callbackHandler, Map<String, ?> sharedState,
			Map<String, ?> options) {
		this.subject=subject;
		this.callbackhandler=callbackHandler;
		
	}

	@Override
	public boolean login() throws LoginException {
		NameCallback namecb=new NameCallback("username");
		PasswordCallback passCB=new PasswordCallback("password", false);
		try {
			callbackhandler.handle(new Callback[] {namecb,passCB});
			username=namecb.getName();
			String password=new String(passCB.getPassword());
			if("admin".equals(username) && "java".equals(password)) {
				roles=Arrays.asList("Admin","Manager");
				return true;
			}
			else if("user".equals(username) && "1234".equals(password)) {
				roles=Arrays.asList("User","enduser");
				return true;
			}
			
		}catch(Exception e) {
			e.printStackTrace();
		}
		
		return false;
	}

	@Override
	public boolean commit() throws LoginException {
		subject.getPrincipals().add(new UserPrincipal(username));
		for(String role:roles) {
			UserPrincipal p=new UserPrincipal(role);
			principals.add(p);
			subject.getPrincipals().add(p);
			
		}
		return true;
	}

	@Override
	public boolean abort() throws LoginException {
		
		return false;
	}

	@Override
	public boolean logout() throws LoginException {
		subject.getPrincipals().removeAll(principals);
		return true;
	}
	
}
