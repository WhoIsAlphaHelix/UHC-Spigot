package de.alpha.uhc.Listener;

import de.alpha.uhc.Core;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageEvent.DamageCause;
import org.bukkit.event.entity.PlayerDeathEvent;

public class CustomDeathListener implements Listener {
	
	private Core pl;
	
	public CustomDeathListener(Core c) {
		this.pl = c;
	}

    private  String blockExplode;
    private  String contact;
    private  String drown;
    private  String pvp;
    private  String entityExplode;
    private  String fall;
    private  String anvil;
    private  String fire;
    private  String lava;
    private  String light;
    private  String potion;
    private  String arrow;
    private  String hunger;
    private  String burried;
    private  String kill;
    private  String thorns;
    private  String voidd;
    private  String wither;


    public  void setBlockExplode(String a) {
        blockExplode = a;
    }


    public  void setContact(String a) {
        contact = a;
    }


    public  void setDrown(String a) {
        drown = a;
    }


    public  void setPvp(String a) {
        pvp = a;
    }


    public  void setEntityExplode(String a) {
        entityExplode = a;
    }


    public  void setFall(String a) {
        fall = a;
    }


    public  void setAnvil(String a) {
        anvil = a;
    }


    public  void setFire(String a) {
        fire = a;
    }


    public  void setLava(String a) {
        lava = a;
    }


    public  void setLight(String a) {
        light = a;
    }


    public  void setPotion(String a) {
        potion = a;
    }


    public  void setArrow(String a) {
        arrow = a;
    }


    public  void setHunger(String a) {
        hunger = a;
    }


    public  void setBurried(String a) {
        burried = a;
    }


    public  void setKill(String a) {
        kill = a;
    }


    public  void setThorns(String a) {
        thorns = a;
    }


    public  void setVoidd(String a) {
        voidd = a;
    }


    public  void setWither(String a) {
        wither = a;
    }


    @EventHandler
    public void onDeath(PlayerDeathEvent e) {

        Player p = e.getEntity();
        DamageCause cause = p.getLastDamageCause().getCause();

        if (cause.equals(DamageCause.BLOCK_EXPLOSION)) {
            String a = blockExplode.replace("[player]", p.getDisplayName());
            e.setDeathMessage(pl.getPrefix() + a);
        }
        if (cause.equals(DamageCause.CONTACT)) {
            String a = contact.replace("[player]", p.getDisplayName());
            e.setDeathMessage(pl.getPrefix() + a);
        }
        if (cause.equals(DamageCause.DROWNING)) {
            String a = drown.replace("[player]", p.getDisplayName());
            e.setDeathMessage(pl.getPrefix() + a);
        }
        if (cause.equals(DamageCause.ENTITY_ATTACK)) {
            if (p.getKiller() != null) {
                String a = pvp.replace("[player]", p.getDisplayName()).replace("[killer]", p.getKiller().getDisplayName());
                e.setDeathMessage(pl.getPrefix() + a);
            } else {
                String a = pvp.replace("[player]", p.getDisplayName()).replace("[killer]", "a Mob");
                e.setDeathMessage(pl.getPrefix() + a);
            }
        }
        if (cause.equals(DamageCause.ENTITY_EXPLOSION)) {
            String a = entityExplode.replace("[player]", p.getDisplayName());
            e.setDeathMessage(pl.getPrefix() + a);
        }
        if (cause.equals(DamageCause.FALL)) {
            String a = fall.replace("[player]", p.getDisplayName());
            e.setDeathMessage(pl.getPrefix() + a);
        }
        if (cause.equals(DamageCause.FALLING_BLOCK)) {
            String a = anvil.replace("[player]", p.getDisplayName());
            e.setDeathMessage(pl.getPrefix() + a);
        }
        if (cause.equals(DamageCause.FIRE)) {
            String a = fire.replace("[player]", p.getDisplayName());
            e.setDeathMessage(pl.getPrefix() + a);
        }
        if (cause.equals(DamageCause.FIRE_TICK)) {
            String a = fire.replace("[player]", p.getDisplayName());
            e.setDeathMessage(pl.getPrefix() + a);
        }
        if (cause.equals(DamageCause.LAVA)) {
            String a = lava.replace("[player]", p.getDisplayName());
            e.setDeathMessage(pl.getPrefix() + a);
        }
        if (cause.equals(DamageCause.LIGHTNING)) {
            String a = light.replace("[player]", p.getDisplayName());
            e.setDeathMessage(pl.getPrefix() + a);
        }
        if (cause.equals(DamageCause.MAGIC)) {
            String a = potion.replace("[player]", p.getDisplayName());
            e.setDeathMessage(pl.getPrefix() + a);
        }
        if (cause.equals(DamageCause.POISON)) {
            String a = potion.replace("[player]", p.getDisplayName());
            e.setDeathMessage(pl.getPrefix() + a);
        }
        if (cause.equals(DamageCause.PROJECTILE)) {
            if (p.getKiller() instanceof Player) {
                String a = arrow.replace("[player]", p.getDisplayName()).replace("[killer]", p.getKiller().getDisplayName());
                e.setDeathMessage(pl.getPrefix() + a);
            } else {
                String a = arrow.replace("[player]", p.getDisplayName()).replace("[killer]", "a Mob");
                e.setDeathMessage(pl.getPrefix() + a);
            }
        }
        if (cause.equals(DamageCause.STARVATION)) {
            String a = hunger.replace("[player]", p.getDisplayName());
            e.setDeathMessage(pl.getPrefix() + a);
        }
        if (cause.equals(DamageCause.SUFFOCATION)) {
            String a = burried.replace("[player]", p.getDisplayName());
            e.setDeathMessage(pl.getPrefix() + a);
        }
        if (cause.equals(DamageCause.SUICIDE)) {
            String a = kill.replace("[player]", p.getDisplayName());
            e.setDeathMessage(pl.getPrefix() + a);
        }
        if (cause.equals(DamageCause.THORNS)) {
            String a = thorns.replace("[player]", p.getDisplayName());
            e.setDeathMessage(pl.getPrefix() + a);
        }
        if (cause.equals(DamageCause.VOID)) {
            String a = voidd.replace("[player]", p.getDisplayName());
            e.setDeathMessage(pl.getPrefix() + a);
        }
        if (cause.equals(DamageCause.WITHER)) {
            String a = wither.replace("[player]", p.getDisplayName());
            e.setDeathMessage(pl.getPrefix() + a);
        }
    }
}
