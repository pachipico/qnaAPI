package com.bootproject.filter;

import java.io.IOException;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.www.BasicAuthenticationFilter;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.bootproject.securiy.PrincipalDetails;
import com.bootproject.user.domain.User;
import com.bootproject.user.repository.UserMapper;

import lombok.extern.slf4j.Slf4j;

@Slf4j
// 인증이 필요한 요청이 있을때의 처리 담당
public class JwtAuthorizationFilter extends BasicAuthenticationFilter {
	
	private UserMapper mapper;
	
	public JwtAuthorizationFilter(AuthenticationManager authenticationManager, UserMapper mapper) {
		super(authenticationManager);
		this.mapper = mapper; 
	}

	@Override
	protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain chain)
			throws IOException, ServletException {

		String jwtHeader = request.getHeader("Authorization");

		if (jwtHeader == null || !jwtHeader.startsWith("Bearer ")) {
			chain.doFilter(request, response);
			return;
		}
		
		String jwtToken = jwtHeader.replace("Bearer ", "");
		
		String email = JWT.require(Algorithm.HMAC512("비밀키")).build().verify(jwtToken).getClaim("email").asString();
		if(email != null) {
			User user = mapper.getUserInfo(email);
			PrincipalDetails principalDetails = new PrincipalDetails(user);
			
			Authentication authentication = new UsernamePasswordAuthenticationToken(principalDetails, null, principalDetails.getAuthorities());
			
			SecurityContextHolder.getContext().setAuthentication(authentication);
			chain.doFilter(request, response);
		}
		
	}

}
