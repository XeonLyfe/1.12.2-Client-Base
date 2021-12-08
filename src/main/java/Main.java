import cf.vaccat.catclient.CatClient;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventHandler;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;

@Mod(modid = "catclient", version = "v1.0.0")
public class Main {

    @EventHandler
    public void init(FMLInitializationEvent event) {
    	CatClient.instance = new CatClient();
    	CatClient.instance.init();
    }
}
