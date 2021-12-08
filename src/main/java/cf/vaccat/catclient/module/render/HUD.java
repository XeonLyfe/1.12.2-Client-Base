package cf.vaccat.catclient.module.render;

import cf.vaccat.catclient.CatClient;
import cf.vaccat.catclient.module.Category;
import cf.vaccat.catclient.module.Module;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.FontRenderer;
import net.minecraft.client.gui.ScaledResolution;
import net.minecraftforge.client.event.RenderGameOverlayEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

public class HUD extends Module {

	public HUD() {
		super("HUD", "modules on screen", Category.RENDER);
	}
	
	@SubscribeEvent
	public void onRender(RenderGameOverlayEvent egoe) {
		/*if (!egoe.type.equals(egoe.type.CROSSHAIRS)) {
			return;
		}*/
		ScaledResolution sr = new ScaledResolution(Minecraft.getMinecraft());
		int y = 2;
		for (Module mod : CatClient.instance.moduleManager.getModuleList()) {
			if (!mod.getName().equalsIgnoreCase("HUD") && mod.isToggled() && mod.visible) {
				FontRenderer fr = Minecraft.getMinecraft().fontRenderer;
				fr.drawString(mod.getName(), sr.getScaledWidth() - fr.getStringWidth(mod.getName()) - 1, y, 0xFFFFFF);
				y += fr.FONT_HEIGHT;
			}
		}
	}
}
