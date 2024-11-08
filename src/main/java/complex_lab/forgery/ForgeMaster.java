package complex_lab.forgery;

import java.util.List;
import java.util.Map;

import complex_lab.commands.FindCommand;
import complex_lab.commands.SortCommand;
import complex_lab.equipment.Equipment;

public class ForgeMaster {
    private final List<Equipment> eq;
    
    Knight knight;
    double eqPrice = 0;

    SortCommand sortCommand;
    FindCommand findCommand;

    public ForgeMaster(List<Equipment> equipment) {
        this.eq = equipment;
    }

    public void createKnight(String knightType) {
        this.knight = new Knight(knightType);
    }

    public void setSortCommand(SortCommand newSortCommand) {this.sortCommand = newSortCommand;}
    public void setFindCommand(FindCommand newFindCommand) {this.findCommand = newFindCommand;}

    public List<Equipment> executeSort() {return this.sortCommand.execute();}
    public List<Equipment> executeFind() {return this.findCommand.execute();}

    public List<Equipment> getAvailableEquipment() {return this.eq;}
    public double getTotalPrice() {return this.eqPrice;}

    public void addEquipment(Equipment newEquipment) {
        this.knight.addEquipment(newEquipment);
        calculateEquipmentPrice();
    }

    public void removeEquipment(String eqType) {
        this.knight.removeEquipment(eqType);
        calculateEquipmentPrice();
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
