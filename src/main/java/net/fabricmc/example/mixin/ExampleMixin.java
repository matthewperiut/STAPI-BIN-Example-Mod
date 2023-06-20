package net.fabricmc.example.mixin;

import net.fabricmc.example.ExampleStationMod;
import net.minecraft.client.gui.screen.ScreenBase;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(ScreenBase.class)
public class ExampleMixin
{
	@Inject(at = @At("HEAD"), method = "init()V")
	private void init(CallbackInfo info)
	{
		ExampleStationMod.LOGGER.info("This mixin is written by " + ExampleStationMod.MODID);
	}
}
