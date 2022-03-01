package dev.dankom.witness.util.general;

import dev.dankom.file.type.Directory;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;

public class ZipUtil {
    private static final int bufferSize = 2048;

    public static void unzip(File fileZip, File destDir) throws IOException {
        byte[] buffer = new byte[2048];
        ZipInputStream zis = new ZipInputStream(new FileInputStream(fileZip));
        ZipEntry zipEntry = zis.getNextEntry();
        while (zipEntry != null) {
            File newFile = newFile(destDir, zipEntry);
            if (!zipEntry.isDirectory()) {
                FileOutputStream fos = new FileOutputStream(newFile);
                int len;
                while ((len = zis.read(buffer)) > 0) {
                    fos.write(buffer, 0, len);
                }
                fos.close();
            } else {
                new Directory(newFile.getAbsolutePath());
            }
            zipEntry = zis.getNextEntry();
        }
        zis.closeEntry();
        zis.close();
    }

    private static File newFile(File destinationDir, ZipEntry zipEntry) throws IOException {
        File destFile = new File(destinationDir, zipEntry.getName());
        destFile.getParentFile().mkdirs();

        String destDirPath = destinationDir.getCanonicalPath();
        String destFilePath = destFile.getCanonicalPath();

        if (!destFilePath.startsWith(destDirPath + File.separator)) {
            throw new IOException("Entry is outside of the target dir: " + zipEntry.getName());
        }

        return destFile;
    }

    public static boolean isExtension(File file, String e) {
        String name = file.getName();
        String extension = name.substring(name.indexOf(".") + 1);
        return extension.equalsIgnoreCase(e);
    }
}
