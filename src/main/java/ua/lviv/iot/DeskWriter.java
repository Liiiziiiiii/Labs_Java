package ua.lviv.iot;

import java.io.*;
import java.lang.reflect.Field;
import java.util.LinkedList;
import java.util.List;


public class DeskWriter {
    public String writeToFile(List<Desk> desk) throws IOException {

        String defaultFileName = "EXPECTED.CSV";

        if (desk == null || desk.isEmpty()) {
            return null;
        }

        try (BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(defaultFileName));) {
            for (Desk desk_value : desk) {
                bufferedWriter.write(desk_value.getHeaders());
                bufferedWriter.newLine();
                bufferedWriter.write(desk_value.toCSV());
//                bufferedWriter.write(System.getProperty());
                bufferedWriter.newLine();
            }

            bufferedWriter.close();

//            desk.stream().forEach(desk1 -> (bufferedWriter.write(desk1.getHeaders())));

        } catch (IOException e) {

        }

        return defaultFileName;


    }

    public static void main(String[] args) throws IOException {
        DeskManager deskManager = new DeskManager();
        deskManager.addDesk(new CoffeeTable("CoffeeTable", 10, 9, 10, false,
                4, 5, 5, 20));
        deskManager.addDesk(new ChildrenTable("ChildrenTable", 11, 8, 10, false,
                2, 20));
        deskManager.addDesk(new DiningTable("DiningTable", 9, 3, 5, false,
                4, 20));
        deskManager.addDesk(new WritingDesk("WritingDesk", 11, 3, 10, true,
                5, 20));

        DeskWriter deskWriter = new DeskWriter();
        deskWriter.writeToFile(deskManager.getDesks());


    }
}
