package agaricus.mods.Jarmod2Coremod;

import cpw.mods.fml.relauncher.IClassTransformer;

public class JarmodTransformer implements IClassTransformer {
    public byte[] transform(String name, java.lang.String transformedName, byte[] bytes) {

        System.out.println("jarmod2coremod: " + name);
        return bytes;
    }
}
