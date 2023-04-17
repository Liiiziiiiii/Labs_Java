package ua.lviv.iot;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
//import com.opencsv.CSVWriter;
@Setter
@Getter
@ToString
@AllArgsConstructor
public abstract class Desk {
    private String name;
    private int height;
    private int width;
    private int length;
    protected boolean hasKeyboardTray;


    public static final String HEADER = "name, height, width, length, hasKeyboardTray";

    public abstract void increaseTheHeightOfTheTableToTheMaximum(int centimeters);
    public abstract void moveDown (int centimeters);

    public String getHeaders() {
        return HEADER;
    }

    public String toCSV() {
        return name + "," + height + "," + width + "," + length + "," + hasKeyboardTray;
    }

}