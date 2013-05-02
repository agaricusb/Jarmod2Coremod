package agaricus.mods.Jarmod2Coremod;

import cpw.mods.fml.relauncher.IFMLCallHook;

import java.util.Map;

public class Scanner implements IFMLCallHook {

    /*
     * Gives the mod coremod data if it wants it.
     */
    @Override
    public void injectData(Map<String, Object> data) {
    }

    @Override
    public Void call() throws Exception {
        System.out.println("PRELOADING XXX");
        return null;
    }
}
