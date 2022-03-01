package dev.dankom.witness.util.general;

import dev.dankom.file.json.JsonObjectBuilder;
import dev.dankom.security.cipher.ciphers.aes.AES256;
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

    public static void encryptFile(String fileName, String key, String salt) {
        AES256 aes = new AES256(key, salt);
        File file = new File(fileName);
        JsonObjectBuilder builder = new JsonObjectBuilder();
        builder.addKeyValuePair("fileContents", Base64.getEncoder().encodeToString(readBytes(file)));
        String toEncode = aes.encrypt(builder.build().toJSONString());

        try {
            FileUtils.forceDelete(file);
        } catch (IOException e) {
            e.printStackTrace();
        }
        writeFile(new File(file.getParentFile(), aes.encrypt(file.getName())), toEncode.getBytes());
    }

    public static void decryptFile(String fileName, String key, String salt) {
        try {
            AES256 aes = new AES256(key, salt);
            File file = new File(aes.encrypt(new File(fileName).getName()));
            String decoded = aes.decrypt(new String(readBytes(file)));
            JSONObject jo = (JSONObject) new JSONParser().parse(decoded);

            try {
                FileUtils.forceDelete(file);
            } catch (IOException e) {
                e.printStackTrace();
            }
            writeFile(new File(file.getParentFile(), fileName), Base64.getDecoder().decode((String) jo.get("fileContents")));
        } catch (ParseException e) {
            e.printStackTrace();
        }
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
