package ar.p4.util;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet Filter implementation class FiltroAutenticacao
 */
@WebFilter(filterName = "filtrologin", urlPatterns = { "/app/*" })
public class FiltroAutenticacao implements Filter {

	/**
	 * Default constructor.
	 */
	public FiltroAutenticacao() {

	}

	/**
	 * @see Filter#destroy()
	 */
	public void destroy() {

	}

	/**
	 * @see Filter#doFilter(ServletRequest, ServletResponse, FilterChain)
	 */
	public void doFilter(ServletRequest request, ServletResponse response,
			FilterChain chain) throws IOException, ServletException {

		HttpServletRequest pedido = (HttpServletRequest) request;
		HttpServletResponse resposta = (HttpServletResponse) response;

		HttpSession sessao = (HttpSession) pedido.getSession(false);
		try {
			if (sessao.getAttribute("isLogged") == null
					|| (boolean) sessao.getAttribute("isLogged") == false) {
				// fazer redirect para pagina de login
				resposta.sendRedirect(pedido.getContextPath() + "/index.xhtml");
			} else {
				chain.doFilter(request, response);
			}
		} catch (Exception e) {
			resposta.sendRedirect(pedido.getContextPath() + "/index.xhtml");
		}

	}

	/**
	 * @see Filter#init(FilterConfig)
	 */
	public void init(FilterConfig fConfig) throws ServletException {

	}

}
