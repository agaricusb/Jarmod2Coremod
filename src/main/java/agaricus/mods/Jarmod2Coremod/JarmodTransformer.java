package agaricus.mods.Jarmod2Coremod;

import cpw.mods.fml.common.FMLLog;
import cpw.mods.fml.relauncher.IClassTransformer;

import java.util.HashMap;
import java.util.Map;
import java.util.logging.Level;

public class JarmodTransformer implements IClassTransformer {

    public static Map<String, byte[]> classes = new HashMap<String, byte[]>();

    public byte[] transform(String name, String transformedName, byte[] bytes) {

        if (classes.containsKey(name)) {
            FMLLog.log(Level.INFO, "[Jarmod2Coremod] Transforming " + name);

            return classes.get(name);
        }

        return bytes;
    }
}
