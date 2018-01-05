package com.radiofc;

import org.apache.log4j.Logger;

import java.util.ArrayList;
import java.util.List;

public class Main {
    private static final Logger LOGGER = Logger.getLogger(InputFileReader.class);

        public static void main(String[] args) {
            List<String> jumpOffsets = InputFileReader.readFile("C:\\Users\\eshamcc\\Dropbox\\git\\AOC-2017-5-TwistyMaze\\src\\main\\resources\\input.txt");

            int jumpOffsetNumbers[] = new int[jumpOffsets.size()];

            int pointer = 0;
            for (String jumpOffset : jumpOffsets) {
                jumpOffsetNumbers[pointer] = Integer.parseInt(jumpOffset);
                pointer++;
            }

            pointer = 0;
            int stepCounter = 0;
            while ((pointer >= 0) && (pointer < jumpOffsets.size())) {

                int currValue = jumpOffsetNumbers[pointer];
                if ((pointer == 0) && (currValue == 0)) {
                    jumpOffsetNumbers[pointer] = 1;
                } else {
                    if (currValue >= 3) {
                        jumpOffsetNumbers[pointer] = currValue - 1;
                    } else {
                        jumpOffsetNumbers[pointer] = currValue + 1;
                    }
                    pointer += currValue;
                }
                stepCounter++;
            }
            LOGGER.info("Number of steps: "+stepCounter);
    }
}
