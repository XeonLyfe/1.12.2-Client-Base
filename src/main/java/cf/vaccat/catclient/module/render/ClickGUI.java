package cf.vaccat.catclient.module.render;

import cf.vaccat.catclient.CatClient;
import cf.vaccat.catclient.module.Category;
import cf.vaccat.catclient.module.Module;
import org.lwjgl.input.Keyboard;

public class ClickGUI extends Module {

	public ClickGUI() {
		super("ClickGUI", "menu.skeet", Category.RENDER);
		this.setKey(Keyboard.KEY_U);
	}
	
	@Override
	public void onEnable() {
		super.onEnable();
		mc.displayGuiScreen(CatClient.instance.clickGui);
		this.setToggled(false);
	}
}
