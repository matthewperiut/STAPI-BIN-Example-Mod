package net.glasslauncher.example.events.ingame;

import net.fabricmc.loader.api.FabricLoader;
import net.glasslauncher.example.events.init.AchievementListener;
import net.glasslauncher.example.events.init.KeyBindingListener;
import net.mine_diver.unsafeevents.listener.EventListener;
import net.minecraft.client.Minecraft;
import net.minecraft.entity.Item;
import net.minecraft.entity.player.PlayerBase;
import net.minecraft.item.ItemBase;
import net.minecraft.item.ItemInstance;
import net.minecraft.level.Level;
import net.modificationstation.stationapi.api.client.event.keyboard.KeyStateChangedEvent;
import org.lwjgl.input.Keyboard;

public class KeyPressedListener {

    @EventListener
    public void keyPressed(KeyStateChangedEvent event) {
        if (Keyboard.getEventKeyState() && Keyboard.isKeyDown(KeyBindingListener.keyBinding.key)) {
            ((Minecraft) FabricLoader.getInstance().getGameInstance()).player.increaseStat(AchievementListener.achievement, 1);
        }
        if (Keyboard.getEventKeyState() && Keyboard.isKeyDown(KeyBindingListener.keyBinding2.key)) {
            ((Minecraft)FabricLoader.getInstance().getGameInstance()).player.increaseStat(AchievementListener.achievement2, 1);
        }
        if (Keyboard.getEventKeyState() && Keyboard.isKeyDown(KeyBindingListener.keyBinding3.key)) {
            if (((Minecraft) FabricLoader.getInstance().getGameInstance()).player != null)
            {
                PlayerBase player = ((Minecraft) FabricLoader.getInstance().getGameInstance()).player;
                Level level = player.level;

                level.spawnEntity(new Item(level, player.x, player.y, player.z, new ItemInstance(ItemBase.apple, 1)));
            }
        }
    }
}
