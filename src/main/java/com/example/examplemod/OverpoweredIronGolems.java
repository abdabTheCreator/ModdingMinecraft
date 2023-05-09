package com.example.examplemod;

import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.animal.IronGolem;
import net.minecraftforge.event.entity.EntityJoinWorldEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber(modid = "examplemod")
public class OverpoweredIronGolems {
    @SubscribeEvent
    public static void applyPotionEffectsToGolem(EntityJoinWorldEvent event) {
        if (!(event.getEntity() instanceof IronGolem)) {
            return;
        }

        IronGolem golem = (IronGolem) event.getEntity();
        golem.addEffect(new MobEffectInstance(MobEffects.MOVEMENT_SPEED, 1000000, 5));
        golem.addEffect(new MobEffectInstance(MobEffects.DAMAGE_BOOST, 1000000, 5));
        golem.addEffect(new MobEffectInstance(MobEffects.REGENERATION, 1000000, 5));
        golem.addEffect(new MobEffectInstance(MobEffects.FIRE_RESISTANCE, 1000000, 5));
    }
}

