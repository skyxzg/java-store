package com.taobao.yiwei.file;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Arrays;
import java.util.HashMap;

/**
 * @author zhigang.xzg
 * @date 2019/11/7
 */
public class FileUtil {
    /**
     * 文件头信息
     */
    private static final HashMap<String, String> FILE_HEADER_MAP = new HashMap<String, String>();
    static {
        FILE_HEADER_MAP.put("EDABEEDB", "rpm");
    }

    public static String getFileType(String filePath) {
        byte[] content = getContent(filePath);
        return getFileType(content);
    }

    private static byte[] getContent(String filePath) {
        File file = new File(filePath);
        long fileSize = file.length();
        if (fileSize > Integer.MAX_VALUE) {
            System.out.println("file too big...");
            return null;
        }
        byte[] content = new byte[(int) fileSize];

        try (FileInputStream fi = new FileInputStream(file)) {
            int offset = 0;
            int numRead = 0;
            while (offset < content.length
                && (numRead = fi.read(content, offset, content.length - offset)) >= 0) {
                offset += numRead;
            }
            // 确保所有数据均被读取
            if (offset != content.length) {
                throw new IOException("Could not completely read file " + file.getName());
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return content;
    }

    public static String getFileType(byte[] content) {
        return FILE_HEADER_MAP.get(getFileHeader(content));
    }

    private static String getFileHeader(byte[] content) {
        byte[] headerCode = Arrays.copyOf(content, 4);
        return bytesToHexString(headerCode);
    }

    private static String bytesToHexString(byte[] src) {
        StringBuilder builder = new StringBuilder();
        if (src == null || src.length <= 0) {
            return null;
        }
        String hv;
        for (int i = 0; i < src.length; i++) {
            // 以十六进制（基数 16）无符号整数形式返回一个整数参数的字符串表示形式，并转换为大写
            hv = Integer.toHexString(src[i] & 0xFF).toUpperCase();
            if (hv.length() < 2) {
                builder.append(0);
            }
            builder.append(hv);
        }
        return builder.toString();
    }
}
