/**
 * @Author: Tecoy
 * Contact: itecoy@163.com
 * @Date: 2022/7/5 18:31
 * @Version: 1.0
 * @Description:
 */
package net.tecoy.utils;

import com.qiniu.common.QiniuException;
import com.qiniu.http.Response;
import com.qiniu.storage.BucketManager;
import com.qiniu.storage.Configuration;
import com.qiniu.storage.Region;
import com.qiniu.storage.UploadManager;
import com.qiniu.storage.model.DefaultPutRet;
import com.qiniu.util.Auth;
import com.google.gson.Gson;

import java.io.UnsupportedEncodingException;

/**
 * 七牛云存储工具类
 *
 * @author Tecoy
 */
public class QiniuUtils {
    private static String accessKey = "";
    private static String secretKey = "";
    private static String bucket = "tecoy-net-space";
    private static String url = "rei1ffyyi.hn-bkt.clouddn.com/";
    private static UploadManager uploadManager;
    private static Configuration cfg;
    private static Auth auth;

    public static String getUrl() {
        return url;
    }

    static {
        //构造一个带指定 Region 对象的配置类
         cfg = new Configuration(Region.region2());
        uploadManager = new UploadManager(cfg);
        auth = Auth.create(accessKey, secretKey);
    }
    /**
     * 文件直传
     * @param filePath
     * @param fileName
     */
    public static void uploadQiniu(String filePath, String fileName) {
        String upToken = auth.uploadToken(bucket);
        try {
            Response response = uploadManager.put(filePath, fileName, upToken);
            //解析上传成功的结果
            DefaultPutRet putRet = new Gson().fromJson(response.bodyString(), DefaultPutRet.class);
            System.out.println(putRet.key);
            System.out.println(putRet.hash);
        } catch (QiniuException ex) {
            Response r = ex.response;
            System.err.println(r.toString());
            try {
                System.err.println(r.bodyString());
            } catch (QiniuException ex2) {
                //ignore
            }
        }
    }

    /**
     * 字节数组上传
     * @param bytes
     * @param fileName
     */
    public static void uploadQiniu(byte[] bytes, String fileName) {
        String upToken = auth.uploadToken(bucket);
        try {
            Response response = uploadManager.put(bytes, fileName, upToken);
            //解析上传成功的结果
            DefaultPutRet putRet = new Gson().fromJson(response.bodyString(), DefaultPutRet.class);
            System.out.println(putRet.key);
            System.out.println(putRet.hash);
        } catch (QiniuException ex) {
            Response r = ex.response;
            System.err.println(r.toString());
            try {
                System.err.println(r.bodyString());
            } catch (QiniuException ex2) {
                //ignore
            }
        }
    }

    /**
     * 删除文件
     * @param fileName
     */
    public static void deleteFileFromQiniu(String fileName) {
        BucketManager bucketManager = new BucketManager(auth, cfg);
        try {
            bucketManager.delete(bucket, fileName);
        } catch (QiniuException ex) {
            //如果遇到异常，说明删除失败
            System.err.println(ex.code());
            System.err.println(ex.response.toString());
        }
    }

    /**
     * 下载凭证
     * @param fileName
     * @return
     */
    public static String downloadUrl(String fileName) {
        return downloadUrl(fileName, 0);
    }

    /**
     * 下载凭证
     * @param fileName
     * @param expires – 有效时长，单位秒。默认3600s
     */
    public static String downloadUrl(String fileName, long expires) {
        return auth.privateDownloadUrl(url + fileName, expires);
    }

}
