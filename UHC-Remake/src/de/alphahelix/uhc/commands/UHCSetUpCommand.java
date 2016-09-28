package de.alphahelix.uhc.commands;

import java.util.List;

import org.bukkit.Bukkit;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import de.alphahelix.uhc.UHC;
import de.popokaka.alphalibary.command.SimpleCommand;
import net.md_5.bungee.api.chat.ClickEvent;
import net.md_5.bungee.api.chat.ClickEvent.Action;
import net.md_5.bungee.api.chat.TextComponent;

public class UHCSetUpCommand extends SimpleCommand<UHC> {

	public UHCSetUpCommand(UHC plugin, String command, String description, String... aliases) {
		super(plugin, command, description, aliases);
	}

	@Override
	public boolean execute(CommandSender cs, String label, String[] args) {
		
		if (!(cs instanceof Player))
			return true;

		Player p = (Player) cs;

		if (!p.hasPermission("uhc.admin")) {
			p.sendMessage((UHC.getInstance().getPrefix() + UHC.getInstance().getRegister().getMessageFile().getColorString("No Permissions")));
			return true;
		}

		if (args.length == 0) {
			TextComponent msg = new TextComponent(
					UHC.getInstance().getPrefix() + "�7Please click �chere �7to see the wiki");
			msg.setClickEvent(new ClickEvent(Action.OPEN_URL, "https://github.com/AlphaHelixDev/UHC-Spigot/wiki"));
			p.spigot().sendMessage(msg);
			return true;
		} else if(args.length == 1) {
			if(args[0].equalsIgnoreCase("setLobby")) {
				UHC.getInstance().getRegister().getLocationsFile().setLobby(p.getLocation());
				p.sendMessage(UHC.getInstance().getPrefix() + "You've set the lobby to �ayour Location�7!");
			} else if(args[0].equalsIgnoreCase("setArena")) {
				UHC.getInstance().getRegister().getLocationsFile().setArena(p.getLocation());
				p.sendMessage(UHC.getInstance().getPrefix() + "You've set the arenaspawn to �ayour Location�7!");
			} else if(args[0].equalsIgnoreCase("setDeathmatch")) {
				UHC.getInstance().getRegister().getLocationsFile().setDeathmatch(p.getLocation());
				p.sendMessage(UHC.getInstance().getPrefix() + "You've set the deathmatch spot to �ayour Location�7!");
			} else if(args[0].equals("setNether")) {
				UHC.getInstance().getRegister().getLocationsFile().setNetherArena(p.getLocation());
				p.sendMessage(UHC.getInstance().getPrefix() + "You've set the nether spot to �ayour Location�7!");
			}
		} else if(args[0].equalsIgnoreCase("createHologram")) {
			String name = "";
			if(args[1].equalsIgnoreCase("lower")) {
				for (Player all : Bukkit.getOnlinePlayers()) {
	                for (int i = 3; i < args.length; i++) {
	                    name = name + args[i] + " ";
	                }
	                
	                UHC.getInstance().getRegister().getHologramFile().addHologram(name, p.getLocation(), Double.parseDouble(args[2]));

	                for (int i = 0; i < UHC.getInstance().getRegister().getHologramFile().getHologramcount(); i++) {
	                    UHC.getInstance().getRegister().getHologramUtil().createHologram(all, i, Double.parseDouble(args[2]));
	                }
	            }
	            p.sendMessage(UHC.getInstance().getPrefix() + "�7You have created a new Hologram");
	            return true;
			} else {
				for (Player all : Bukkit.getOnlinePlayers()) {
                    for (int i = 1; i < args.length; i++) {
                        name = name + args[i] + " ";
                    }

                    UHC.getInstance().getRegister().getHologramFile().addHologram(name, p.getLocation(), 0);

                    for (int i = 0; i < UHC.getInstance().getRegister().getHologramFile().getHologramcount(); i++) {
                        UHC.getInstance().getRegister().getHologramUtil().createHologram(all, i, 0);
                    }
                }
                p.sendMessage(UHC.getInstance().getPrefix() + "�7You have created a new Hologram");
                return true;
			}
		} else {
			TextComponent msg = new TextComponent(
					UHC.getInstance().getPrefix() + "�7Please click �chere �7to see the wiki");
			msg.setClickEvent(new ClickEvent(Action.OPEN_URL, "https://github.com/AlphaHelixDev/UHC-Spigot/wiki"));
			p.spigot().sendMessage(msg);
			return true;
		}
		
		return true;
	}

	@Override
	public List<String> tabComplete(CommandSender cs, String label, String[] args) {
		return null;
	}

}
