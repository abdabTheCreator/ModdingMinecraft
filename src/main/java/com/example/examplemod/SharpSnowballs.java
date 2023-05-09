package com.example.examplemod;

import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.item.PrimedTnt;
import net.minecraft.world.entity.projectile.Arrow;
import net.minecraft.world.entity.projectile.Snowball;
import net.minecraft.world.level.Level;
import net.minecraftforge.event.entity.EntityJoinWorldEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber(modid = "examplemod")
public class SharpSnowballs {
    @SubscribeEvent
    public static void replaceSnowballWithArrow(EntityJoinWorldEvent event) {
        Entity snowball = event.getEntity();
        Level level = event.getWorld();

        if (!(snowball instanceof Snowball)) {
            return;
        }

        if (!level.isClientSide) {
            //Uncomment below line for tnt
            Arrow arrow = EntityType.ARROW.create(level);
            //Uncomment the below lines to turn arrows into tnt explosives
            //PrimedTnt tnt = EntityType.TNT.create(level);
            //tnt.setFuse(80);
            arrow.moveTo(snowball.position());
            arrow.setDeltaMovement(snowball.getDeltaMovement());
            level.addFreshEntity(arrow);
        }

        event.setCanceled(true);
    }
}