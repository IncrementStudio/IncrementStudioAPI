package ru.incrementstudio.incapi.util;

import java.util.List;
import java.util.Random;

public class RandomUtil {
    private static final Random random = new Random();
    public static void setSeed(long seed) {
        random.setSeed(seed);
    }
    public static double getDouble(double min, double max) {
        return min + (max - min) * random.nextDouble();
    }
    public static int getInt(int min, int max) {
        return (int) (min + (max - min) * Math.random());
    }
    public static <T> T getRandomFromList(List<T> list) {
        return list.get(random.nextInt(list.size()));
    }
}
