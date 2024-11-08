package complex_lab.commands;

import java.util.List;
import complex_lab.equipment.Equipment;

public interface FindCommand {
    List<Equipment> execute();
}
