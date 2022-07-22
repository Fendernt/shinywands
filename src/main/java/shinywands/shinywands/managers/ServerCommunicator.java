package shinywands.shinywands.managers;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;

public class ServerCommunicator {

    private static final String consolePrefix =
             ChatColor.GRAY+"["
            + ChatColor.LIGHT_PURPLE +"ShinyWands"
            +ChatColor.GRAY+"]"
            +ChatColor.WHITE+": ";

    private static final String chatPrefix = ChatColor.GRAY+"["+ChatColor.DARK_PURPLE+"Shiny"+ChatColor.LIGHT_PURPLE+"Wands"+ChatColor.GRAY+"]";

    public static void sendConsoleMessage(String message){
        Bukkit.getServer().getConsoleSender().sendMessage(consolePrefix+": " + message);
    }

    public static void sendChatMessage(String message){
        Bukkit.getServer().broadcastMessage(chatPrefix+": " + message);
    }

    public static void sendChatMessageToPlayer(Player player, String message){
        player.sendMessage(chatPrefix+": " + message);
    }

    public static String getChatPrefix() {
        return chatPrefix;
    }
}
