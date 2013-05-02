package agaricus.mods.Jarmod2Coremod;

import cpw.mods.fml.relauncher.IFMLCallHook;
import cpw.mods.fml.relauncher.IFMLLoadingPlugin;

import java.util.Map;

public class Jarmod2Coremod implements IFMLLoadingPlugin {

    @Override
    /*
     * Use if you want to download libraries. Returns a list of classes that implement the ILibrarySet interface
     * eg return new String[] { "tutorial.asm.downloaders.DownloadUsefulLibrary " };
     */
    public String[] getLibraryRequestClass() {
        return null;
    }

    /*
     * The class(es) that do(es) the transforming. Needs to implement IClassTransformer in some way
     */
    @Override
    public String[] getASMTransformerClass() {
        return new String[] { "agaricus.mods.Jarmod2Coremod.JarmodTransformer" } ;
    }

    /*
     * The class that acts similarly to the @Mod annotation.
     */
    @Override
    public String getModContainerClass() {
        return null;
    }

    /*
     * If you want to do stuff BEFORE minecraft starts, but after your mod is loaded.
     */
    @Override
    public String getSetupClass() {
        return "agaricus.mods.Jarmod2Coremod.Scanner";
    }

    /*
     * Gives the mod coremod data if it wants it.
     */
    @Override
    public void injectData(Map<String, Object> data) {
    }



}
