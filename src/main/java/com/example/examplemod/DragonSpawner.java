package com.example.examplemod;

import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.boss.enderdragon.EnderDragon;
import net.minecraft.world.entity.boss.enderdragon.phases.EnderDragonPhase;
import net.minecraft.world.level.block.Blocks;

import net.minecraftforge.event.world.BlockEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber(modid = "examplemod")
public class DragonSpawner {
    @SubscribeEvent
    public static void spawnDragon(BlockEvent.EntityPlaceEvent event) {
        if (event.getPlacedBlock().getBlock() == Blocks.DRAGON_EGG) {
            event.getWorld().removeBlock(event.getPos(), false); // false = no flags
            EnderDragon dragon = EntityType.ENDER_DRAGON.create(event.getEntity().getLevel());
            dragon.moveTo(event.getPos(), 0, 0);
            dragon.getPhaseManager().setPhase(EnderDragonPhase.LANDING_APPROACH);
            event.getWorld().addFreshEntity(dragon);
        }
    }
}