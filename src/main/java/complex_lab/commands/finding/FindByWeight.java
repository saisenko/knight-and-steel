package complex_lab.commands.finding;

import java.util.ArrayList;
import java.util.List;

import complex_lab.commands.FindCommand;
import complex_lab.equipment.Equipment;

public class FindByWeight implements FindCommand {
    private final List<Equipment> equipment;
    private final double weight;

    public FindByWeight(
        List<Equipment> givenEquipment,
        double requestedWeight
    ) {
        this.equipment = givenEquipment;
        this.weight = requestedWeight;
    }

    @Override
    public List<Equipment> execute() {
        List<Equipment> resultEq = new ArrayList<>();
        for (Equipment equipmentPiece : this.equipment) {
            if (equipmentPiece.pieceWeight() <= this.weight) {
                resultEq.add(equipmentPiece);
            }
        }
        return resultEq;
    }
}
