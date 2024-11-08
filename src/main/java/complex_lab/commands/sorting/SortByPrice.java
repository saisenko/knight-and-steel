package complex_lab.commands.sorting;

import java.util.Comparator;
import java.util.List;

import complex_lab.commands.SortCommand;
import complex_lab.equipment.Equipment;

public class SortByPrice implements SortCommand {
    private final List<Equipment> equipment;

    public SortByPrice(List<Equipment> givenEquipment) {this.equipment = givenEquipment;}

    @Override
    public List<Equipment> execute() {
        equipment.sort(Comparator.comparingDouble(Equipment::piecePrice));
        return this.equipment;
    }
}
