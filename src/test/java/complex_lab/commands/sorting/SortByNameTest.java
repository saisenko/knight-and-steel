package complex_lab.commands.sorting;

import complex_lab.equipment.Equipment;
import complex_lab.forgery.ForgeMaster;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class SortByNameTest {
    @Test
    public void testExecute1() {
        List<Equipment> eq = new ArrayList<>();
        eq.add(new Equipment("TS-1", "Templar sword", "Weapon", "Templars", 12, 310));
        eq.add(new Equipment("TH-1", "Templar helmet", "Headwear", "Templars", 18, 340));
        eq.add(new Equipment("TT-1", "Templar armor", "Armor", "Templars", 30, 380));
        ForgeMaster testFM = new ForgeMaster(eq);

        testFM.setSortCommand(new SortByName(testFM.getAvailableEquipment()));

        List<Equipment> expected = List.of(
                new Equipment("TT-1", "Templar armor", "Armor", "Templars", 30, 380),
                new Equipment("TH-1", "Templar helmet", "Headwear", "Templars", 18, 340),
                new Equipment("TS-1", "Templar sword", "Weapon", "Templars", 12, 310)
        );

        assertEquals(testFM.executeSort(), expected);
    }
}