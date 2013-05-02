package agaricus.mods.Jarmod2Coremod;

import cpw.mods.fml.relauncher.IFMLCallHook;

import java.io.File;
import java.util.Map;

public class Scanner implements IFMLCallHook {

    public File coremodLocation;

    /*
     * Gives the mod coremod data if it wants it.
     */
    @Override
    public void injectData(Map<String, Object> data) {
        if (data.containsKey("coremodLocation")) {
            coremodLocation = (File) data.get("coremodLocation");
        }
    }

    @Override
    public Void call() throws Exception {
        System.out.println("PRELOADING XXX");
        System.out.println("coremodLocation = "+coremodLocation);

        System.exit(0); // for testing
        return null;
    }
}
