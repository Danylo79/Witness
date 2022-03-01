package dev.dankom.witness.file.jar;

import dev.dankom.bite.decompiler.RuntimeDecompiler;
import dev.dankom.file.jar.UnpackedJar;
import dev.dankom.file.type.Directory;
import dev.dankom.logger.LogManager;
import dev.dankom.logger.abztract.DefaultLogger;
import dev.dankom.logger.interfaces.ILogger;
import dev.dankom.util.general.ZipUtil;
import dev.dankom.util.reflection.JarClassLoader;
import org.apache.commons.io.FileUtils;

import java.io.File;
import java.io.IOException;
import java.net.URI;

public class JarFile extends File {
    private static final ILogger logger = LogManager.addLogger("decompiler", new DefaultLogger());

    public JarFile(String pathname) {
        super(pathname);
    }

    public JarFile(String parent, String child) {
        super(parent, child);
    }

    public JarFile(File parent, String child) {
        super(parent, child);
    }

    public JarFile(URI uri) {
        super(uri);
    }

    /**
     * Decompiles jar into .java files
     *
     * @param temp       Temporarily stores .class files (Will be deleted later)
     * @param decompiled Where .java files are put
     */
    public void decompile(Directory temp, Directory decompiled) {
        try {
            if (temp == null) {
                logger.info("JarFile", "Using default temp directory");
                temp = new Directory("./temp");
            }

            if (decompiled == null) {
                logger.info("JarFile", "Using default decompiled directory");
                decompiled = new Directory("./decompiled");
            }

            if (temp.exists()) {
                logger.info("JarFile", "Deleting old temp directory");
                FileUtils.deleteDirectory(temp);
                temp = new Directory(temp.getAbsolutePath());
            }

            if (decompiled.exists()) {
                logger.info("JarFile", "Deleting old decompiled directory");
                FileUtils.deleteDirectory(decompiled);
                decompiled = new Directory(decompiled.getAbsolutePath());
            }

            unpack(temp);
            RuntimeDecompiler.decompileAll(temp, decompiled);
            logger.info("JarFile", "Deleting temp directory");
            FileUtils.deleteDirectory(temp);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * Decompiles jar into .java files
     *
     * @param decompiled Where .java files are put
     */
    public void decompile(Directory decompiled) {
        decompile(null, decompiled);
    }

    /**
     * Decompiles jar into .java files
     */
    public void decompile() {
        decompile(null, null);
    }

    public UnpackedJar unpack(Directory output) {
        try {
            ZipUtil.unzip(this, output);
            return new UnpackedJar(output);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    public void run(String... args) {
        try {
            JarClassLoader loader = new JarClassLoader(toURL());
            String main = loader.getMainClassName();
            loader.invokeClass(main, args);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
