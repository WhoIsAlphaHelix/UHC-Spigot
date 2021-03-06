package de.alphahelix.uhc.listeners.scenarios;

import de.alphahelix.alphalibary.listener.SimpleListener;
import de.alphahelix.alphalibary.utils.Util;
import de.alphahelix.uhc.enums.Scenarios;
import de.alphahelix.uhc.events.timers.LobbyEndEvent;
import de.alphahelix.uhc.util.PlayerUtil;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.inventory.ItemStack;

import java.util.Random;

public class CertainCircumstancesListener extends SimpleListener {

    @EventHandler
    public void onEnd(LobbyEndEvent e) {
        if (!Scenarios.isPlayedAndEnabled(Scenarios.CERTAIN_CIRCUMSTANCES)) return;
        for (Player p : Util.makePlayerArray(PlayerUtil.getSurvivors())) {
            p.getInventory().addItem(new ItemStack(getRandomMaterial()));
        }
    }

    private Material getRandomMaterial() {
        int index = new Random().nextInt(Material.values().length);
        return Material.values()[index];
    }
}
