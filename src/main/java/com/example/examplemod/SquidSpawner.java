package com.example.examplemod;

import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.animal.Squid;
import net.minecraft.world.level.block.Blocks;

import net.minecraftforge.event.world.BlockEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber(modid = "examplemod")
public class SquidSpawner {
    @SubscribeEvent
    public static void spawnDragon(BlockEvent.EntityPlaceEvent event) {
        if (event.getPlacedBlock() == Blocks.SPONGE.defaultBlockState()) {
            event.getWorld().removeBlock(event.getPos(), false); // false = no flags
            Squid squid = EntityType.SQUID.create(event.getEntity().level);
            squid.moveTo(event.getPos(), 0, 0);
            event.getWorld().addFreshEntity(squid);
        }
    }
}