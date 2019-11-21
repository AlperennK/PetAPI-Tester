package com.epampets.domain.utils;

import java.util.Random;

public class NumberGenerateHelper {
    public static int getRandomPetId() {
        Random rnd = new Random();
        return 1000 + rnd.nextInt(999);
    }
}
