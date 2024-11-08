package complex_lab.forgery;

import java.util.ArrayList;
import java.util.List;

import complex_lab.equipment.Equipment;

public class ForgeryInit {
    private List<Equipment> generateTemplarEquipment() {
        List<Equipment> eq = new ArrayList<>();

        eq.add(new Equipment("TS-1", "Templar sword", "Weapon", "Templars", 12, 310));
        eq.add(new Equipment("TH-1", "Templar helmet", "Headwear", "Templars", 18, 340));
        eq.add(new Equipment("TT-1", "Templar armor", "Armor", "Templars", 30, 380));
        eq.add(new Equipment("TG-1", "Templar gauntlets", "Gauntlets", "Templars", 8, 290));
        eq.add(new Equipment("TL-1", "Templar boots", "Boots", "Templars", 10, 330));

        return eq;
    }

    private List<Equipment> generateBladesEquipment() {
        List<Equipment> eq = new ArrayList<>();

        eq.add(new Equipment("BW-1", "Akaviri katana", "Weapon", "Blades", 10, 300));
        eq.add(new Equipment("BW-2", "Akaviri daikatana", "Weapon", "Blades", 15, 350));
        eq.add(new Equipment("BW-3", "Akaviri tachi", "Weapon", "Blades", 5, 120));
        eq.add(new Equipment("BW-4", "Akaviri longbow", "Weapon", "Blades", 8, 240));

        eq.add(new Equipment("BH-1", "Akaviri helmet", "Headwear", "Blades", 16, 300));
        eq.add(new Equipment("BT-1", "Akaviri armor", "Armor",  "Blades", 25, 350));
        eq.add(new Equipment("BG-1", "Akaviri gloves", "Gauntlets",  "Blades", 6, 280));
        eq.add(new Equipment("BL-1", "Akaviri boots", "Boots", "Blades", 8, 320));

        return eq;
    }

    private List<Equipment> generateGreyWardenEquipment() {
        List<Equipment> eq = new ArrayList<>();

        eq.add(new Equipment("WW-1", "Grey Warden sword", "Weapon", "Grey Wardens", 13, 315));
        eq.add(new Equipment("WH-1", "Warden helmet", "Headwear",  "Grey Wardens", 14, 295));
        eq.add(new Equipment("WT-1", "Warden armor", "Armor", "Grey Wardens", 24, 335));
        eq.add(new Equipment("WG-1", "Warden gloves", "Gauntlets", "Grey Wardens", 7, 270));
        eq.add(new Equipment("WL-1", "Warden boots", "Boots", "Grey Wardens", 9, 310));

        return eq;
    }

    public List<Equipment> generateAvailableEquipment() {
        List<Equipment> eq = new ArrayList<>();

        List<Equipment> templarEq = generateTemplarEquipment();
        List<Equipment> bladesEq = generateBladesEquipment();
        List<Equipment> wardensEq = generateGreyWardenEquipment();

        eq.addAll(templarEq);
        eq.addAll(bladesEq);
        eq.addAll(wardensEq);

        return eq;
    }
}
