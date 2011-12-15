package org.getspout.server.entity.monsters;

import org.bukkit.entity.Ghast;
import org.bukkit.inventory.ItemStack;
import org.getspout.server.SpoutServer;
import org.getspout.server.SpoutWorld;
import org.getspout.server.entity.Angerable;
import org.getspout.server.entity.Damager;
import org.getspout.server.item.ItemID;
import org.getspout.server.util.Parameter;

import java.util.ArrayList;
import java.util.List;

public class SpoutGhast extends SpoutFlying implements Ghast, Angerable {

    /**
     * Is this ghast angry?
     */
    private boolean angry;

    public SpoutGhast(SpoutServer server, SpoutWorld world) {
        super(server, world, 56);
    }

    @Override
    public List<ItemStack> getLoot(Damager damager) {
        List<ItemStack> loot = new ArrayList<ItemStack>();
        int amount = random.nextInt(3);
        if (amount > 0) loot.add(new ItemStack(ItemID.SULPHUR, amount));
        return loot;
    }

    public boolean isAngry() {
        return angry;
    }

    public void setAngry(boolean angry) {
        this.angry = angry;
        setMetadata(new Parameter<Byte>(Parameter.TYPE_BYTE, 16, (byte)(angry ? 1 : 0)));
    }
}