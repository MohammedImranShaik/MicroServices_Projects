package com.apigateway.filter;

import java.util.List;
import java.util.Set;

import org.springframework.cloud.gateway.filter.GatewayFilterChain;
import org.springframework.cloud.gateway.filter.GlobalFilter;
import org.springframework.http.server.reactive.ServerHttpRequest;
import org.springframework.stereotype.Component;
import org.springframework.web.server.ServerWebExchange;

import reactor.core.publisher.Mono;

@Component
public class MyFilter implements GlobalFilter {

	@Override
	public Mono<Void> filter(ServerWebExchange exchange, GatewayFilterChain chain) {
		System.out.println("Filter() - executed.....");

		// TODO: Validate the Request

		ServerHttpRequest request = exchange.getRequest();
		org.springframework.http.HttpHeaders headers = request.getHeaders();
		Set<String> keySet = headers.keySet();

		if (!keySet.contains("Secret")) {
			throw new RuntimeException("Invalid Request");
		}

		List<String> list = headers.get("Secret");
		if (!list.get(0).equals("@Immu_1432")) {
			throw new RuntimeException("Invalid Request...");
		}

			return chain.filter(exchange);
	}

}
