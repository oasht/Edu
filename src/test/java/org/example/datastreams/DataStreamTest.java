package org.example.datastreams;

import org.junit.jupiter.api.Test;

import java.util.List;

class DataStreamTest {

    @Test
    void testAction(){
        PredicateAction<Integer> pred = PredicateAction.of(x->x>0);

        List<Integer> list = List.of(-2,-1,0,1,2,3);
        for(Integer i : list){
            System.out.println(pred.apply(i));
        }

        MapAction<Integer, Integer> mapAct=MapAction.of(x->x*2);
        for(Integer i : list){
            System.out.println(mapAct.apply(i));
        }
    }

}