package org.belyaeva.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.graphql.server.WebGraphQlHandler;
import org.springframework.graphql.server.webmvc.GraphQlWebSocketHandler;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.web.socket.config.annotation.EnableWebSocket;
import org.springframework.web.socket.config.annotation.WebSocketConfigurer;
import org.springframework.web.socket.config.annotation.WebSocketHandlerRegistry;

import java.time.Duration;

@Configuration
@EnableWebSocket
public class WebSocketConfig implements WebSocketConfigurer {

    @Value("${spring.graphql.websocket.path}")
    private String webSocketPath;

    private final MappingJackson2HttpMessageConverter converter;
    private final WebGraphQlHandler webGraphQlHandler;

    public WebSocketConfig(MappingJackson2HttpMessageConverter converter,
                           WebGraphQlHandler webGraphQlHandler) {
        this.converter = converter;
        this.webGraphQlHandler = webGraphQlHandler;
    }

    @Override
    public void registerWebSocketHandlers(WebSocketHandlerRegistry registry) {
        GraphQlWebSocketHandler handler = new GraphQlWebSocketHandler(
                webGraphQlHandler,
                converter,
                Duration.ofSeconds(60) // Таймаут инициализации соединения
        );

        registry.addHandler(handler, webSocketPath)
                .setAllowedOriginPatterns("*");
    }
}
