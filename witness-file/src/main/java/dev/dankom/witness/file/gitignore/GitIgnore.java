package dev.dankom.witness.file.gitignore;

import dev.dankom.witness.file.type.file.SimpleFile;

import java.io.File;

public class GitIgnore extends SimpleFile {
    public GitIgnore(File path, String contents, boolean override) {
        super("", path, ".gitignore", contents, override);
    }
}
