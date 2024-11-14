package complex_lab.forgery;

import complex_lab.commands.FindCommand;
import complex_lab.commands.SortCommand;
import complex_lab.commands.finding.FindByPrice;
import complex_lab.commands.sorting.SortByName;
import complex_lab.commands.sorting.SortByPrice;
import complex_lab.equipment.Equipment;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;

class ForgeMasterTest {

    @Test
    public void testConstructor() throws IOException {
        Equipment testEquipment = new Equipment("test", "test", "test", "test", 0, 0);
        List<Equipment> equipmentList = new ArrayList<>();
        equipmentList.add(testEquipment);

        ForgeMaster testFM = new ForgeMaster(equipmentList);
        assertEquals(testFM.getAvailableEquipment(), equipmentList);
    }

    @Test
    public void testCreateKnight() throws IOException {
        ForgeMaster testFM = new ForgeMaster(List.of(new Equipment("test", "test", "test", "test", 0, 0)));

        testFM.createKnight("a");
        assertEquals(testFM.knight.getKnightType(), "TEMPLARS");

        testFM.createKnight("b");
        assertEquals(testFM.knight.getKnightType(), "BLADES");

        testFM.createKnight("c");
        assertEquals(testFM.knight.getKnightType(), "WARDENS");

        testFM.createKnight("random option");
        assertEquals(testFM.knight.getKnightType(), "COMMONER");
    }

    @Test
    public void testSetSortCommand() throws IOException {
        ForgeMaster testFM = new ForgeMaster(List.of(new Equipment("test", "test", "test", "test", 0, 0)));

        Equipment testEquipment = new Equipment("test", "test", "test", "test", 0, 0);
        List<Equipment> equipmentList = new ArrayList<>();
        equipmentList.add(testEquipment);

        SortCommand sortCmd = new SortByName(equipmentList);
        testFM.setSortCommand(sortCmd);

        assertNotEquals(testFM.sortCommand, null);
    }

    @Test
    public void testSetFindCommand() throws IOException {
        ForgeMaster testFM = new ForgeMaster(List.of(new Equipment("test", "test", "test", "test", 0, 0)));

        Equipment testEquipment = new Equipment("test", "test", "test", "test", 0, 0);
        List<Equipment> equipmentList = new ArrayList<>();
        equipmentList.add(testEquipment);

        FindCommand findCmd = new FindByPrice(equipmentList, 10);
        testFM.setFindCommand(findCmd);

        assertNotEquals(testFM.findCommand, null);
    }

    @Test
    public void testExecuteSort() throws IOException {
        Equipment testEquipment1 = new Equipment("test", "test", "test", "test", 0, 10);
        Equipment testEquipment2 = new Equipment("test", "test", "test", "test", 0, 20);
        List<Equipment> equipmentList = new ArrayList<>();
        equipmentList.add(testEquipment2);
        equipmentList.add(testEquipment1);

        List<Equipment> expected = List.of(testEquipment1, testEquipment2);

        ForgeMaster testFM = new ForgeMaster(equipmentList);
        testFM.setSortCommand(new SortByPrice(equipmentList));
        List<Equipment> result = testFM.executeSort();

        assertEquals(result, expected);
    }

    @Test
    public void testExecuteFind() throws IOException {
        Equipment testEquipment1 = new Equipment("test", "test", "test", "test", 0, 10);
        Equipment testEquipment2 = new Equipment("test", "test", "test", "test", 0, 20);
        List<Equipment> equipmentList = new ArrayList<>();
        equipmentList.add(testEquipment2);
        equipmentList.add(testEquipment1);

        List<Equipment> expected = List.of(testEquipment1);

        ForgeMaster testFM = new ForgeMaster(equipmentList);
        testFM.setFindCommand(new FindByPrice(equipmentList, 15));
        List<Equipment> result = testFM.executeFind();

        assertEquals(result, expected);
    }

    @Test
    public void testGetTotalPrice1() throws IOException {
        ForgeMaster testFM = new ForgeMaster(List.of(new Equipment("test", "test", "test", "test", 0, 10)));
        assertEquals(testFM.getTotalPrice(), 0);
    }

    @Test
    public void testGetTotalPrice2() throws IOException{
        ForgeMaster newTestFM = new ForgeMaster(new ForgeryInit().generateAvailableEquipment());
        newTestFM.createKnight("a");

        newTestFM.addEquipment(new Equipment("test1", "test", "test1", "TEMPLARS", 0, 10));
        newTestFM.addEquipment(new Equipment("test2", "test", "test2", "TEMPLARS", 0, 10));

        assertEquals(newTestFM.getTotalPrice(), 20);
    }

    @Test
    public void testAddEquipment() throws IOException {
        ForgeMaster newTestFM = new ForgeMaster(new ForgeryInit().generateAvailableEquipment());
        newTestFM.createKnight("a");

        newTestFM.addEquipment(new Equipment("test1", "test", "test1", "TEMPLARS", 0, 10));

        Map<String, Equipment> expected = new HashMap<>();
        expected.put("TEST1", new Equipment("test1", "test", "test1", "TEMPLARS", 0, 10));

        assertEquals(newTestFM.knight.getCurrEquipment(), expected);
    }

    @Test
    public void testRemoveEquipment() throws IOException {
        ForgeMaster newTestFM = new ForgeMaster(new ForgeryInit().generateAvailableEquipment());
        newTestFM.createKnight("a");

        newTestFM.addEquipment(new Equipment("test1", "test", "HEADWEAR", "TEMPLARS", 0, 10));

        Map<String, Equipment> expected = new HashMap<>();

        newTestFM.removeEquipment("HEADWEAR");

        assertEquals(newTestFM.knight.getCurrEquipment(), expected);
    }

    @Test
    public void testFindEquipmentByID() throws IOException {
        ForgeMaster testFM = new ForgeMaster(new ForgeryInit().generateAvailableEquipment());
        Equipment testEquipment = new Equipment("TS-1", "Templar sword", "Weapon", "Templars", 12, 310);

        assertEquals(testFM.findEquipmentById("TS-1"), testEquipment);
        assertEquals(testFM.findEquipmentById("ts-1"), testEquipment);
        assertEquals(testFM.findEquipmentById("Ts-1"), testEquipment);
        assertEquals(testFM.findEquipmentById("tS-1"), testEquipment);
        assertNull(testFM.findEquipmentById("RR-1"));
    }
}