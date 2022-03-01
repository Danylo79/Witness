package dev.dankom.witness.util.general;

import org.apache.commons.io.FileUtils;
import org.apache.commons.io.IOUtils;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.StandardCopyOption;
import java.util.ArrayList;
import java.util.Base64;
import java.util.List;

public class FileUtil {
    public static void copyDirectory(File source, File destination) {
        try {
            Files.copy(source.toPath(), destination.toPath(), StandardCopyOption.REPLACE_EXISTING);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static List<File> getChildren(File file) {
        List<File> out = new ArrayList<>();
        String[] directories = file.list((current, name) -> new File(current, name).isDirectory());

        for (String s : directories) {
            out.add(new File(s));
        }
        return out;
    }

    public static void writeFile(File f, byte[] bytes) {
        try {
            FileOutputStream output = new FileOutputStream(f.getPath());
            IOUtils.write(bytes, output);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static byte[] readBytes(File f) {
        try {
            return Files.readAllBytes(f.toPath());
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }
}
