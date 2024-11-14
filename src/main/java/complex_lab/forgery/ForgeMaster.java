package complex_lab.forgery;

import java.io.IOException;
import java.util.List;
import java.util.Map;

import complex_lab.commands.FindCommand;
import complex_lab.commands.SortCommand;
import complex_lab.equipment.Equipment;
import complex_lab.logger.BasicLogger;

public class ForgeMaster {
    private final BasicLogger logger = new BasicLogger("logs/fm_actions");
    private final List<Equipment> eq;
    
    Knight knight;
    double eqPrice = 0;

    SortCommand sortCommand;
    FindCommand findCommand;

    public ForgeMaster(List<Equipment> equipment) throws IOException {
        this.eq = equipment;
    }

    public void createKnight(String knightType) throws IOException {
        this.knight = new Knight(knightType);
        logger.recordAction("Created knight of type " + knightType + "\n");
    }

    public void setSortCommand(SortCommand newSortCommand) throws IOException {
        this.sortCommand = newSortCommand;
        logger.recordAction("Set sort command " + newSortCommand + "\n");
    }
    public void setFindCommand(FindCommand newFindCommand) throws IOException {
        this.findCommand = newFindCommand;
        logger.recordAction("Set find command " + newFindCommand + "\n");
    }

    public List<Equipment> executeSort() throws IOException {
        logger.recordAction("Executed sort command\n");
        return this.sortCommand.execute();
    }
    public List<Equipment> executeFind() throws IOException {
        logger.recordAction("Executed find command\n");
        return this.findCommand.execute();
    }

    public List<Equipment> getAvailableEquipment() throws IOException {
        logger.recordAction("Requested available equipment. Request granted\n");
        return this.eq;
    }
    public double getTotalPrice() throws IOException {
        logger.close();
        return this.eqPrice;
    }

    public void addEquipment(Equipment newEquipment) throws IOException {
        this.knight.addEquipment(newEquipment);
        calculateEquipmentPrice();
        logger.recordAction("Added equipment " + newEquipment + "\n");
    }

    public void removeEquipment(String eqType) throws IOException {
        this.knight.removeEquipment(eqType);
        calculateEquipmentPrice();
        logger.recordAction("Removed equipment of type " + eqType + "\n");
    }

    public void calculateEquipmentPrice() {
        double newTotalPrice = 0;
        Map<String, Equipment> knightEq = this.knight.getCurrEquipment();
        for (Equipment equipment : knightEq.values()) {
            newTotalPrice += equipment.piecePrice();
        }
        this.eqPrice = newTotalPrice;
    }

    public Equipment findEquipmentById(String equipmentId) {
        for (Equipment equipment : this.eq) {
            if (equipmentId.equalsIgnoreCase(equipment.pieceID())) {
                return equipment;
            }
        }
        return null;
    }

    public void displayKnight() {
        this.knight.displayKnightEq();
    }
}
