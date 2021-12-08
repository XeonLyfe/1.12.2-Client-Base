package cf.vaccat.catclient.module.combat;

import cf.vaccat.catclient.CatClient;
import cf.vaccat.catclient.module.Category;
import cf.vaccat.catclient.module.Module;
import cf.vaccat.catclient.settings.Setting;
import net.minecraftforge.event.entity.living.LivingEvent.LivingUpdateEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

public class Velocity extends Module {

	public Velocity() {
		super("Anti Knockback", "i hate being knocked back", Category.COMBAT);
		CatClient.instance.settingsManager.rSetting(new Setting("Horizontal", this, 90, 0, 100, true));
		CatClient.instance.settingsManager.rSetting(new Setting("Vertical", this, 100, 0, 100, true));
	}
	
	@SubscribeEvent
	public void onLivingUpdate(LivingUpdateEvent e) {
		float horizontal = (float) CatClient.instance.settingsManager.getSettingByName(this, "Horizontal").getValDouble();
		float vertical = (float) CatClient.instance.settingsManager.getSettingByName(this, "Vertical").getValDouble();
		
		if (mc.player.hurtTime == mc.player.maxHurtTime && mc.player.maxHurtTime > 0) {
			mc.player.motionX *= (float) horizontal / 100;
			mc.player.motionY *= (float) vertical / 100;
			mc.player.motionZ *= (float) horizontal / 100;
		}
	}
}
