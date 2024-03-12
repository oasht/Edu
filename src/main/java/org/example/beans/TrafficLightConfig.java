package org.example.beans;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Primary;
import org.springframework.context.annotation.Scope;

public class TrafficLightConfig {
    @Bean
    @Primary
    TrafficLight.State green() {
        return new TrafficLight.State("green", "yellow");
    }

    @Bean
    TrafficLight.State yellow() {
        return new TrafficLight.State("yellow", "red");
    }

    @Bean
    TrafficLight.State red() {
        return new TrafficLight.State("red", "green");
    }

    @Bean
    TrafficLight trafficLight(ApplicationContext ctx){
        return new TrafficLight(ctx);
    }


    TrafficLight.State currentState;
    @Bean
    @Scope("prototype")
    TrafficLight.State nextTrafficLightState(TrafficLight.State primaryState, ApplicationContext context) {
        if(currentState == null) {
            currentState = primaryState;
            return currentState;
        }
        currentState = context.getBean(currentState.nextState, TrafficLight.State.class);
        return currentState;
    }
}
