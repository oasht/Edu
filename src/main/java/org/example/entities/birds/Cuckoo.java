package org.example.entities.birds;

import java.util.Random;

public class Cuckoo extends Bird {
    @Override
    public String sing() {
        Random r = new Random();
        int n = r.nextInt(1, 11);
        StringBuilder builder = new StringBuilder();
        for (int i = 0; i <= n; i++) {
            builder.append("ку-ку ");
        }
        return builder.toString().trim();

    }
}
