package ua.lviv.iot;

import java.io.*;
import java.util.*;
import java.util.stream.Collectors;


public class DeskWriter {
    public String writeToFile(List<Desk> desk) throws IOException {

        String defaultFileName = "EXPECTED.CSV";

        if (desk == null || desk.isEmpty()) {
            return null;
        }

        try (BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(defaultFileName));) {
            Map result = desk.stream().collect(
                    Collectors.groupingBy(
                            Desk::getHeaders,
                            Collectors.mapping(Desk::toCSV, Collectors.toSet())));

            bufferedWriter.write(result.toString());

            bufferedWriter.close();


        } catch (IOException e) {


        }

        return defaultFileName;


    }
    public String writeToFiles(List<Desk> desk) throws IOException {

        String defaultFileName = "ACTUAL.CSV";

        if (desk == null || desk.isEmpty()) {
            return null;
        }

        try (BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(defaultFileName));) {
            Map result = desk.stream().collect(
                    Collectors.groupingBy(
                            Desk::getHeaders,
                            Collectors.mapping(Desk::toCSV, Collectors.toSet())));

            bufferedWriter.write(result.toString());

            bufferedWriter.close();


        } catch (IOException e) {


        }

        return defaultFileName;


    }

    public static void main(String[] args) throws IOException {
        DeskManager deskManager = new DeskManager();
        ChildrenTable childrenTable = new ChildrenTable("ChildrenTable", 11, 8, 10, false,
                2, 20);
        deskManager.addDesk(new CoffeeTable("CoffeeTable", 10, 9, 10, false,
                4, 5, 5, 20));
        deskManager.addDesk(new ChildrenTable("ChildrenTable", 11, 8, 10, false,
                2, 20));
        deskManager.addDesk(new DiningTable("DiningTable", 9, 3, 5, false,
                4, 20));
        deskManager.addDesk(new WritingDesk("WritingDesk", 11, 3, 10, true,
                5, 20));

        deskManager.addDesk(new CoffeeTable("CoffeeTable", 15, 15, 15, false, 5, 15, 5, 30));

        deskManager.addDesk(new ChildrenTable("ChildrenTable", 15, 15, 15, false, 1, 25));

        deskManager.addDesk(new DiningTable("DiningTable", 15, 15, 15, false, 8, 25));

        deskManager.addDesk(new WritingDesk("WritingDesk", 17, 17, 17, true, 5, 25));

        DeskWriter deskWriter = new DeskWriter();
        deskWriter.writeToFile(deskManager.getDesks());


    }

}
