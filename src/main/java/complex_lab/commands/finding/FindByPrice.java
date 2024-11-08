package complex_lab.commands.finding;

import java.util.ArrayList;
import java.util.List;

import complex_lab.commands.FindCommand;
import complex_lab.equipment.Equipment;

public class FindByPrice implements FindCommand {
    private final List<Equipment> equipment;
    private final double price;

    public FindByPrice(
        List<Equipment> givenEquipment,
        double requestedPrice
    ) {
        this.equipment = givenEquipment;
        this.price = requestedPrice;
    }

    @Override
    public List<Equipment> execute() {
        List<Equipment> resultEq = new ArrayList<>();
        for (Equipment equipmentPiece : this.equipment) {
            if (equipmentPiece.piecePrice() <= this.price) {
                resultEq.add(equipmentPiece);
            }
        }
        return resultEq;
    }
}
