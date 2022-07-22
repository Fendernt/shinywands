package shinywands.shinywands.globalFunctions;

import org.bukkit.Location;
import org.bukkit.util.Vector;

public class PlayerMethods {

    public static Vector getPlayerLookVector(Location point1, Location point2){
        Vector p1 = point1.toVector();
        Vector p2 = point2.toVector();
        Vector vector = p2.clone().subtract(p1).normalize().multiply(1);
        return vector;
    }
}
