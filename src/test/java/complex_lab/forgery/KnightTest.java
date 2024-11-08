package complex_lab.forgery;

import complex_lab.equipment.Equipment;
import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;

class KnightTest {
    @Test
    public void testKnightConstructor() {
        Knight knight1 = new Knight("a");
        assertEquals(knight1.getKnightType(), "TEMPLARS");

        Knight knight2 = new Knight("b");
        assertEquals(knight2.getKnightType(), "BLADES");

        Knight knight3 = new Knight("c");
        assertEquals(knight3.getKnightType(), "WARDENS");

        Knight knight4 = new Knight("random option");
        assertEquals(knight4.getKnightType(), "COMMONER");
    }

    @Test
    public void testGetCurrEquipment() {
        Map<String, Equipment> testEquipment = new HashMap<>();
        Equipment headwear = new Equipment("TH-1", "Templar helmet", "Headwear", "Templars", 18, 340);
        testEquipment.put("HEADWEAR", headwear);

        Knight testKnight = new Knight("a");
        testKnight.addEquipment(headwear);

        assertEquals(testKnight.getCurrEquipment(), testEquipment);
    }

    @Test
    public void testAddEquipment() {
        Knight testKnight1 = new Knight("a");
        Knight testKnight2 = new Knight("b");
        Map<String, Equipment> testEquipment = new HashMap<>();
        Equipment headwear = new Equipment("TH-1", "Templar helmet", "Headwear", "Templars", 18, 340);

        testEquipment.put("HEADWEAR", headwear);

        testKnight1.addEquipment(headwear);
        assertEquals(testKnight1.getCurrEquipment(), testEquipment);

        assertThrows(IllegalArgumentException.class, () -> testKnight2.addEquipment(headwear));
    }

    @Test
    public void testRemoveEquipment() {
        Knight testKnight1 = new Knight("a");
        Equipment headwear = new Equipment("TH-1", "Templar helmet", "Headwear", "Templars", 18, 340);
        testKnight1.addEquipment(headwear);

        testKnight1.removeEquipment("HEADWEAR");
        assertEquals(testKnight1.getCurrEquipment(), new HashMap<String, Equipment>());
    }
}