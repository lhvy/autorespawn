package dev.lhvy.autorespawn.mixin;

import net.minecraft.client.MinecraftClient;
import net.minecraft.client.gui.screen.DeathScreen;

import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(DeathScreen.class)
public class DeathScreenMixin {
    private static final MinecraftClient CLIENT = MinecraftClient.getInstance();

    @Inject(method = "init", at = @At("TAIL"))
    public void onInit(CallbackInfo ci) {
        CLIENT.player.requestRespawn();
        CLIENT.setScreen(null);
    }
}
