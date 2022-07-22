package shinywands.shinywands.commands;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import shinywands.shinywands.items.ItemManager;
import shinywands.shinywands.managers.ServerCommunicator;

public class ShinyWandCommand implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if(!(sender instanceof Player)){
            sender.sendMessage("Only players can use that command.");
            return true;
        }
        Player player = (Player) sender;

        if(command.getName().equalsIgnoreCase("shinywand")){
            if(player.getInventory().firstEmpty() != -1) {
                player.getInventory().addItem(ItemManager.ShinyWand);
                ServerCommunicator.sendChatMessageToPlayer(player, "You got a shiny wand.");
            }
            else ServerCommunicator.sendChatMessageToPlayer(player, "There is no empty space in your inventory.");
        }

        return true;
    }
}
