package agaricus.mods.Jarmod2Coremod;

import com.google.common.io.ByteStreams;
import cpw.mods.fml.common.FMLCommonHandler;
import cpw.mods.fml.common.FMLLog;
import cpw.mods.fml.relauncher.IFMLCallHook;

import java.io.DataInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.*;
import java.util.jar.JarEntry;
import java.util.jar.JarFile;
import java.util.logging.Level;
import java.util.zip.ZipEntry;
import java.util.zip.ZipException;
import java.util.zip.ZipFile;

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
        log("XXX loading");
        log("XXX instance="+FMLCommonHandler.instance());
        log("XXX side="+FMLCommonHandler.instance().getSide());
        log("XXX side isServer="+FMLCommonHandler.instance().getSide().isServer());
        if (!FMLCommonHandler.instance().getSide().isServer()) {
            log("Jarmod2Coremod on non-server, skipping load"); // just use multimc
            return null;
        }

        log("Jarmod2Coremod loading...");
        //log(Level.INFO, "coremodLocation = "+coremodLocation);

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

        log("jarmod directory: " + jarmodsDir);

        File[] files = jarmodsDir.listFiles();
        Arrays.sort(files); // TODO: customizable priority

        for (File file : files) {
            log("Jarmod found: " + file);
            try {
                loadJarmod(file);
            } catch (Exception ex) {
                FMLLog.log(Level.SEVERE, "[Jarmod2Coremod] Failed to load jarmod: "+ file + ": " + ex.getLocalizedMessage());
                ex.printStackTrace();
            }
        }

        log("Preloaded "+JarmodTransformer.classes.size()+" classes");

        //System.exit(0); // for testing
        return null;
    }

    private void log(String msg) {
        FMLLog.log(Level.INFO, "[Jarmod2Coremod] " + msg); // TODO
    }

    private void loadJarmod(File file) throws ZipException, IOException {
        ZipFile zipFile = new ZipFile(file);

        for (Enumeration<? extends ZipEntry> entr = zipFile.entries(); entr.hasMoreElements();) {
            ZipEntry entry = entr.nextElement();
            String className = entry.getName().replace(".class", "").replace('/', '.');

            byte[] bytes = new byte[(int) entry.getSize()];
            DataInputStream dataInputStream = new DataInputStream(zipFile.getInputStream(entry));
            dataInputStream.readFully(bytes);

            JarmodTransformer.classes.put(className, bytes);
        }
    }
}
