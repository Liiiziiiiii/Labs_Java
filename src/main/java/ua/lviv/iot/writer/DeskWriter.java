package ua.lviv.iot.writer;

import ua.lviv.iot.models.Desk;

import java.io.*;
import java.util.*;


public class DeskWriter {
    public static final String DEFAULT_FILENAME = "RESULT.CSV";

    public String writeToFile(List<Desk> desks) throws IOException {
        if (desks == null || desks.isEmpty()) {
            return null;
        }

        desks.sort(Comparator.comparing(o -> o.getClass().getName()));
        try (BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(DEFAULT_FILENAME))) {
            String previouslyWrittenDesk = null;
            for (var desk : desks) {
                if (!desk.getClass().getName().equals(previouslyWrittenDesk)) {
                    bufferedWriter.write(desk.getHeaders() + System.lineSeparator());
                    previouslyWrittenDesk = desk.getClass().getName();
                }
                bufferedWriter.write(desk.toCSV());
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return DEFAULT_FILENAME;
    }

}
