package complex_lab.commands.finding;

import complex_lab.equipment.Equipment;
import complex_lab.forgery.ForgeMaster;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class FindByWeightTest {
    @Test
    public void testExecute1()  throws IOException {
        List<Equipment> eq = new ArrayList<>();
        eq.add(new Equipment("TS-1", "Templar sword", "Weapon", "Templars", 12, 310));
        eq.add(new Equipment("TH-1", "Templar helmet", "Headwear", "Templars", 18, 340));
        eq.add(new Equipment("TT-1", "Templar armor", "Armor", "Templars", 30, 380));
        ForgeMaster testFM = new ForgeMaster(eq);

        testFM.setFindCommand(new FindByWeight(testFM.getAvailableEquipment(),15));

        List<Equipment> expected = List.of(new Equipment("TS-1", "Templar sword", "Weapon", "Templars", 12, 310));

        assertEquals(testFM.executeFind(), expected);
    }
}