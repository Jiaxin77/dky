package hci.dky.utils;

import java.io.File;

/**
 * @ClassName UploadUtils
 * @Description TODO
 * @Author jiaxin
 * @Date 2020/6/23 10:52 上午
 * @Version 1.0
 **/
public class UploadUtils {
    public final static String FILE_PATH_PREFIX = "static/upload/file";
    public static File getFileDirFile(){
// 构建上传文件的存放 “文件夹” 路径
        String fileDirPath = new String("src/main/resources/" + FILE_PATH_PREFIX);
        File fileDir = new File(fileDirPath);
        if(!fileDir.exists()){
// 递归生成文件夹
            fileDir.mkdirs();
        }
        return fileDir;
    }

}
