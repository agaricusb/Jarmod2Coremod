package agaricus.mods.Jarmod2Coremod;

import cpw.mods.fml.common.FMLLog;
import cpw.mods.fml.relauncher.IFMLCallHook;

import java.io.File;
import java.util.Map;
import java.util.logging.Level;

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
        FMLLog.log(Level.INFO, "Jarmod2Coremod loading...");
        //FMLLog.log(Level.INFO, "coremodLocation = "+coremodLocation);

        File root, jarmodsDir;

        if (coremodLocation != null) {
            root = coremodLocation.getParentFile(); // root/coremods/us.jar -> root/coremods
            if (root != null) {
                root = root.getParentFile(); // root
            }
        } else {
            root = new File(".").getCanonicalFile();
        }

        jarmodsDir = new File(root.getCanonicalPath() + System.getProperty("file.separator") + "jarmods");
        jarmodsDir.mkdirs();

        FMLLog.log(Level.INFO, "jarmod directory: " + jarmodsDir);

        System.exit(0); // for testing
        return null;
    }
}
