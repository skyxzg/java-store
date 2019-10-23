package com.taobao.yiwei.embeddedmysql;


import java.util.concurrent.TimeUnit;

import com.wix.mysql.EmbeddedMysql;
import com.wix.mysql.config.MysqldConfig;

import static com.wix.mysql.EmbeddedMysql.anEmbeddedMysql;
import static com.wix.mysql.distribution.Version.v5_6_23;
import static com.wix.mysql.ScriptResolver.classPathScript;
import static com.wix.mysql.config.MysqldConfig.aMysqldConfig;
import static com.wix.mysql.config.Charset.UTF8;

public class Sample {

    public static void main(String[] args) {

        MysqldConfig config = aMysqldConfig(v5_6_23)
            .withCharset(UTF8)
            .withPort(2215)
            .withUser("differentUser", "anotherPassword")
            .withTimeZone("Europe/Vilnius")
            .withTimeout(2, TimeUnit.MINUTES)
            .withServerVariable("max_connect_errors", 666)
            .build();

        EmbeddedMysql mysqld = anEmbeddedMysql(config)
            .addSchema("aschema", classPathScript("db/init.sql"))
            .start();

        //do work
        while (true) {
            try {
                Thread.sleep(5000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        //mysqld.stop(); //optional, as there is a shutdown hook
    }
}
