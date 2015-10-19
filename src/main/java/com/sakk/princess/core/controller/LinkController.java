package com.sakk.princess.core.controller;

//import java.util.Collection;
//import java.util.HashSet;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
//import org.springframework.security.core.GrantedAuthority;
//import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

//import com.sakk.princess.core.model.User;

@Controller
public class LinkController {
	static Logger logger = LoggerFactory.getLogger(LinkController.class);

	@RequestMapping(value = "/link")
	public String mainPage() {

/*
		Collection<GrantedAuthority> authorities = getAuthorities();
		String rolename;


		for (GrantedAuthority authority : authorities) {
			rolename = authority.getAuthority();

			if (rolename.equals("ROLE_ADMIN")) {
				logger.debug("Directing to home page for: [" + rolename + "]");
				return "admin-home";
			}
			if (rolename.equals("ROLE_TRADER")) {
				logger.debug("Directing to home page for: [" + rolename + "]");
				return "trader-home";
			}
			if (rolename.equals("ROLE_USER")) {
				logger.debug("Directing to home page for: [" + rolename + "]");
				return "user-home";
			}
		}

		logger.error("Role not found - directing to home page for ROLE_USER");
		
*/

		return "home";
	}
	
/*
	private Collection<GrantedAuthority> getAuthorities() {
		Collection<GrantedAuthority> authorities = new HashSet<GrantedAuthority>();
		Object principal = SecurityContextHolder.getContext()
				.getAuthentication().getPrincipal();
		if (principal instanceof User) {
			authorities = ((User) principal).getAuthorities();
		} else {
			logger.error("Principal is not an instance of com.sakk.lovely.model.User");
		}
		return authorities;
	}

*/

}

