package dev.dankom.witness.file.jar;

import dev.dankom.bite.asm.lib.tree.BiteClassNode;
import dev.dankom.file.type.Directory;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class UnpackedJar extends Directory {
    public UnpackedJar(String name) {
        super(name);
    }

    public UnpackedJar(File parent, String name) {
        super(parent, name);
    }

    public UnpackedJar(String parent, String child) {
        super(parent, child);
    }

    public UnpackedJar(Directory output) {
        super(output.getAbsolutePath());
    }

    public List<BiteClassNode> getClasses() {
        List<BiteClassNode> out = new ArrayList<>();
        for (File cf : getFiles()) {
            if (!cf.isDirectory() && cf.getName().contains(".class")) {
                out.add(getClass(cf));
            }
        }
        return out;
    }

    public BiteClassNode getClass(String className) {
        return getClass(new File(className));
    }

    public BiteClassNode getClass(File classFile) {
        return new BiteClassNode(classFile);
    }
}
