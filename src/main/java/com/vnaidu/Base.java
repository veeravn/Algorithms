package com.vnaidu;

import java.util.Arrays;
import java.util.logging.Logger;

public abstract class Base {

    protected static final Logger logger = Logger.getLogger(Base.class.getName());

    // Example method that uses the logger
    public void logInfo(String message) {
        logger.info(message);
    }

    public void logWarning(String message) {
        logger.warning(message);
    }

    public void logSevere(String message) {
        logger.severe(message);
    }

    public static String matrixString(int[][] matrix) {
        return Arrays.deepToString(matrix);
    }
}
