package br.senai.sc.editoralivros.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.messaging.simp.config.MessageBrokerRegistry;
import org.springframework.web.socket.config.annotation.EnableWebSocketMessageBroker;
import org.springframework.web.socket.config.annotation.StompEndpointRegistry;
import org.springframework.web.socket.config.annotation.WebSocketMessageBrokerConfigurer;

@Configuration
@EnableWebSocketMessageBroker
public class WebSocketConfig implements WebSocketMessageBrokerConfigurer {

    @Override
    public void configureMessageBroker(MessageBrokerRegistry registry) {
        registry.setApplicationDestinationPrefixes("/editora-livros-api");
//        WebSocketMessageBrokerConfigurer.super.configureMessageBroker(registry);
    }

    @Override
    public void registerStompEndpoints(StompEndpointRegistry registry) {
        registry.addEndpoint("/editora-livros-api/websocket")
                .setAllowedOrigins("http://localhost:3000")
                .withSockJS()
                .setSessionCookieNeeded(true);
//        WebSocketMessageBrokerConfigurer.super.registerStompEndpoints(registry);
    }
}
