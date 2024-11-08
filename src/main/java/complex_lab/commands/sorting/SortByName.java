package complex_lab.commands.sorting;

import java.util.Comparator;
import java.util.List;

import complex_lab.commands.SortCommand;
import complex_lab.equipment.Equipment;

public class SortByName implements SortCommand {
    private final List<Equipment> equipment;

    public SortByName(List<Equipment> givenEquipment) {this.equipment = givenEquipment;}

    @Override
    public List<Equipment> execute() {
        equipment.sort(Comparator.comparing(Equipment::pieceName));
        return this.equipment;
    }
}
