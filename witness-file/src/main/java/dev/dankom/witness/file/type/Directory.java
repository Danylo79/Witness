package dev.dankom.witness.file.type;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class Directory extends File {
    public String name;

    public Directory(String name) {
        super(name);
        this.name = name;

        this.mkdirs();
    }

    public Directory(File parent, String name) {
        super(parent, name);
        this.name = name;

        this.mkdirs();
    }

    public Directory(String parent, String child) {
        super(parent, child);
        this.name = child;

        this.mkdirs();
    }

    public List<File> getChildren() {
        List<File> out = new ArrayList<>();

        String[] names = list();
        for (String name : names) {
            out.add(new File(new File(this, name).getAbsolutePath()));
        }

        return out;
    }

    public List<File> getFiles(Directory dir) {
        List<File> out = new ArrayList<>();
        for (final File f : dir.listFiles()) {
            if (f.isDirectory()) {
                out.add(f);
                for (File dirFile : getFiles(new Directory(f.getAbsolutePath()))) {
                    out.add(dirFile);
                }
            } else {
                out.add(f);
            }
        }
        return out;
    }

    public List<File> getFiles() {
        return getFiles(this);
    }

    public File newFile(String fileName) {
        return new File(this, fileName);
    }
}