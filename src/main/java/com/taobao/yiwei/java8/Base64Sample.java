package com.taobao.yiwei.java8;

import java.nio.charset.StandardCharsets;
import java.util.Base64;

/**
 * 在Java8 中，Base64编码已经成为Java类库的标准。
 * Java8 内置了 Base64 编码的编码器和解码器。
 * Base64工具类提供了一套静态方法获取下面三种BASE64编解码器：
 *  1. 基本：输出被映射到一组字符A-Za-z0-9+/，编码不添加任何行标，输出的解码仅支持A-Za-z0-9+/。
 *  2. URL：输出映射到一组字符A-Za-z0-9+_，输出是URL和文件。
 *  3. MIME：输出隐射到MIME友好格式。输出每行不超过76字符，并且使用'\r'并跟随'\n'作为分割。编码输出最后没有行分割。
 *
 * 两个静态嵌套类：
 * Base64.Decoder 该类实现一个解码器用于，使用 Base64 编码来解码字节数据。
 * Base64.Encoder 该类实现一个编码器，使用 Base64 编码来编码字节数据。
 */
public class Base64Sample {
    public static void main(String[] args) {
        String originString = "Hello world!";
        System.out.println("原始字符串: " + originString);

        // 1. 使用基本编码
        String base64encodedString = Base64.getEncoder().encodeToString(originString.getBytes(StandardCharsets.UTF_8));
        System.out.println("Base64 编码字符串 (基本) :" + base64encodedString);
        byte[] base64decodedBytes = Base64.getDecoder().decode(base64encodedString);
        System.out.println("解码：" + new String(base64decodedBytes, StandardCharsets.UTF_8));

        // 2. 使用URL编码
        base64encodedString = Base64.getUrlEncoder().encodeToString(originString.getBytes(StandardCharsets.UTF_8));
        System.out.println("Base64 编码字符串 (URL) :" + base64encodedString);
        base64decodedBytes = Base64.getUrlDecoder().decode(base64encodedString);
        System.out.println("解码：" + new String(base64decodedBytes, StandardCharsets.UTF_8));

        // 3. 使用MIME编码
        base64encodedString = Base64.getMimeEncoder().encodeToString(originString.getBytes(StandardCharsets.UTF_8));
        System.out.println("Base64 编码字符串 (MIME) :" + base64encodedString);
        base64decodedBytes = Base64.getMimeDecoder().decode(base64encodedString);
        System.out.println("解码：" + new String(base64decodedBytes, StandardCharsets.UTF_8));
    }
}
