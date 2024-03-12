package org.example.beans;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.ToString;
import org.springframework.context.ApplicationContext;

@AllArgsConstructor
public class TrafficLight {

    private final ApplicationContext ctx;

    public State next(){
        return ctx.getBean("nextTrafficLightState", State.class);
    }

    @RequiredArgsConstructor
    @Getter
    @ToString
    public static class State{
        final String name;
        final String nextState;
    }

}
