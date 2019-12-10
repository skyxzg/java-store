package com.taobao.yiwei.file;

/**
 * @author zhigang.xzg
 * @date 2019/11/7
 */
public class FileSample {
    public static void main(String[] args) {
        //String fileType = FileUtil.getFileType("/Users/zhigang.xzg/Downloads/ocp-release/ocp-setup/ocp_yh/home/admin/obztools_agent/libs/bzip2-1.0.6-13.el7.x86_64.rpm");
        String fileType = FileUtil.getFileType("/Users/zhigang.xzg/Downloads/test.rpm");
        System.out.println(fileType);
    }


}
