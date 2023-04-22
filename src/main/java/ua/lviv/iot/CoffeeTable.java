package ua.lviv.iot;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;


@Setter
@Getter
@ToString(callSuper = true)
public class CoffeeTable extends Desk {
    private int numberOfGuests;
    private int numberOfShelves;
    private int miniHeight;
    private int maxHeight;

    public CoffeeTable(final String name, final int height, final int width, final int length, final boolean hasKeyboardTray, final int numberOfGuests, final int numberOfShelves, final int miniHeight, final int maxHeight) {
        super(name, height, width, length, hasKeyboardTray);
        this.numberOfGuests = numberOfGuests;
        this.numberOfShelves = numberOfShelves;
        this.maxHeight = maxHeight;
        this.miniHeight = miniHeight;
    }


    @Override
    public void increaseTheHeightOfTheTableToTheMaximum(final int centimeters) {
        if ((getHeight() + centimeters) < maxHeight) {
            setHeight(Math.abs((getHeight() + centimeters) - maxHeight));
        } else {
            setHeight(0);
        }
    }

    @Override
    public void moveDown(final int centimeters) {
        if ((getHeight() + centimeters) < maxHeight) {
            setHeight(getHeight() + centimeters);
        } else {
            setHeight(0);
        }
    }


    public String getHeaders(){
        return HEADER + ", numberOfShelves" +", numberOfGuests" + ", miniHeight" + ", maxHeight \n";
    }

    public String toCSV() {
        return super.toCSV() + "," + numberOfShelves + "," + numberOfGuests + "," + miniHeight + "," + maxHeight + "\n";
    }
}
