import Listener.RandomPlaceListener;
import org.bukkit.plugin.java.JavaPlugin;

public class RandomPlace extends JavaPlugin {
    
    private static JavaPlugin plugin;
    public static RandomPlaceListener randomPlaceListener;

    @Override
    public void onEnable() {
        plugin = this;

        randomPlaceListener = new RandomPlaceListener();
        getServer().getPluginManager().registerEvents(randomPlaceListener,this);

        this.getLogger().info("[RandomPlace] プラグインが有効になった");
    }

    @Override
    public void onDisable(){
        this.getLogger().info("[RandomPlace] プラグインが無効になった");
    }

    public static JavaPlugin getPlugin(){ return plugin; }

}
