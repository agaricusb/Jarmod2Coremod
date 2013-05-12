package agaricus.mods.Jarmod2Coremod;

import cpw.mods.fml.common.FMLLog;
import cpw.mods.fml.relauncher.IClassTransformer;

import java.util.HashMap;
import java.util.Map;
import java.util.logging.Level;

public class JarmodTransformer implements IClassTransformer {

    private static Map<String, byte[]> classBytes = new HashMap<String, byte[]>();
    private static Map<String, String> classSources = new HashMap<String, String>();

    /**
     * Add a new jarmod class, overwriting any previous class of the same name
     * @param className Name of class (Java source name, .-separated)
     * @param bytes Raw class bytes
     * @param source Informative description of where this class came from (filename)
     */
    public static void put(String className, byte[] bytes, String source) {
        classBytes.put(className, bytes);
        classSources.put(className, source);
    }

    public static int size() {
        return classBytes.size();
    }

    public byte[] transform(String name, String transformedName, byte[] bytes) {

        if (classBytes.containsKey(name)) {
            FMLLog.log(Level.INFO, "[Jarmod2Coremod] Replacing " + name + " from " + classSources.get(name));

            return classBytes.get(name);
        }

        return bytes;
    }
}
