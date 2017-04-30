package de.alphahelix.uhc.listeners.scenarios;

import de.alphahelix.alphalibary.listener.SimpleListener;
import de.alphahelix.uhc.UHC;
import de.alphahelix.uhc.enums.Scenarios;
import de.alphahelix.uhc.events.timers.LobbyEndEvent;
import org.bukkit.Bukkit;
import org.bukkit.World;
import org.bukkit.event.EventHandler;
import org.bukkit.scheduler.BukkitRunnable;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by AlphaHelixDev.
 */
public class RealTimeListener extends SimpleListener {

    private static Integer getTime() {
        SimpleDateFormat time = new SimpleDateFormat("HH:mm");
        String[] args = time.format(new Date()).split(":");
        Integer hours = Integer.parseInt(args[0]) * 1000;
        Integer minutes = Integer.parseInt(args[1]) * (1000 / 60);
        return hours + minutes + 18000;
    }

    @EventHandler
    public void onEnd(LobbyEndEvent e) {
        if (!Scenarios.isPlayedAndEnabled(Scenarios.REAL_TIME)) return;
        new BukkitRunnable() {

            @Override
            public void run() {

                for (World w : Bukkit.getWorlds()) {
                    w.setTime(getTime());
                }

            }
        }.runTaskTimer(UHC.getInstance(), 0L, 20 * 6);
    }
}
