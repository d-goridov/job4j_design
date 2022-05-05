package ru.job4j.io;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class UsageLog4j {
    private static final Logger LOG = LoggerFactory.getLogger(UsageLog4j.class.getName());

    public static void main(String[] args) {
        byte age = 3;
        short engineCil = 4;
        int power = 101;
        float weight = 212.32f;
        double distance = 15004.54;
        long numberLot = 32456724L;
        boolean isCrushed = false;
        char color = 'R';

        LOG.debug("Motorcycle Info age: {}", age);
        LOG.debug("Motorcycle Info engineCil: {}", engineCil);
        LOG.debug("Motorcycle Info power: {}", power);
        LOG.debug("Motorcycle Info weight: {}", weight);
        LOG.debug("Motorcycle Info distance: {}", distance);
        LOG.debug("Motorcycle Info numberLot: {}", numberLot);
        LOG.debug("Motorcycle Info isCrushed: {}", isCrushed);
        LOG.debug("Motorcycle Info color: {}", color);

    }
}
