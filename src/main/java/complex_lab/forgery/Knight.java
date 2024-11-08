package complex_lab.forgery;

import java.util.HashMap;
import java.util.Map;

import complex_lab.equipment.Equipment;

public class Knight {
    private final Map<String, Equipment> knightEq;
    private final String knightType;

    public Knight(String knightTypeOption) {
        this.knightEq = new HashMap<>();
        switch (knightTypeOption) {
            case "a":
                knightType = "TEMPLARS";
                break;
            case "b":
                knightType = "BLADES";
                break;
            case "c":
                knightType = "WARDENS";
                break;
            default:
                knightType = "COMMONER";
                break;
        }
    }

    public String getKnightType() {return this.knightType;}
    public Map<String, Equipment> getCurrEquipment() {return this.knightEq;}
    
    public void addEquipment(Equipment eqp) {
        String pieceType = eqp.pieceType().toUpperCase();
        String pieceAffiliation = eqp.pieceAffiliation().toUpperCase();
        if (this.knightEq.get(pieceType) == null && this.getKnightType().equals(pieceAffiliation)) {
            this.knightEq.put(pieceType, eqp);
        } else {
            throw new IllegalArgumentException("[Cannot add equipment: already owned or wrong affiliation]");
        }
    }

    public void removeEquipment(String eqp) {
        this.knightEq.remove(eqp.toUpperCase());
    }

    public void displayKnightEq() {
        for (Map.Entry<String, Equipment> entry : this.knightEq.entrySet()) {
            String key = entry.getKey().toUpperCase();
            Equipment eqp = entry.getValue();
            System.out.println(key + ": " + eqp.toString());
        }
    }
}
