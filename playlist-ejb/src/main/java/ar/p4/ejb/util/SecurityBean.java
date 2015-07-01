package ar.p4.ejb.util;

import javax.annotation.Resource;
import javax.ejb.SessionContext;
import javax.ejb.Stateless;

/**
 * Session Bean implementation class SecurityBean
 */
@Stateless
public class SecurityBean {
	@Resource
	SessionContext ctx;

	/**
	 * Default constructor.
	 */
	public SecurityBean() {
		// TODO Auto-generated constructor stub
	}

	public String getPrincipalName() {
		String name = "";
		if (ctx != null) {
			name = ctx.getCallerPrincipal().getName();
		}
		return name;
	}

}
