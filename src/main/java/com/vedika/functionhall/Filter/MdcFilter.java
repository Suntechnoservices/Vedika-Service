package com.vedika.functionhall.Filter;

import java.io.IOException;
import java.util.UUID;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.slf4j.MDC;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import com.vedika.functionhall.controller.OwnerController;
import com.vedika.functionhall.model.Owner;

@Component
public class MdcFilter extends OncePerRequestFilter {
	
	Logger logger=LoggerFactory.getLogger(OwnerController.class);

	@Override
	protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
			throws ServletException, IOException {
		try {
            MDC.put("Id", getCorrelationId());
            logger.info("User Enters in");
            filterChain.doFilter(request, response);
        } finally {
            MDC.remove("CorrelationId");
        }
		
		
		
	}
	private String getCorrelationId() {
        return UUID.randomUUID().toString();
    }

}
