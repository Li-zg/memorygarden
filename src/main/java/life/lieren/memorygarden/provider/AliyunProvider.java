package life.lieren.memorygarden.provider;

import com.aliyun.oss.OSS;
import com.aliyun.oss.OSSClient;
import com.aliyun.oss.OSSClientBuilder;
import com.aliyun.oss.model.CannedAccessControlList;
import com.aliyun.oss.model.ObjectMetadata;
import com.aliyun.oss.model.PutObjectResult;
import org.apache.commons.lang.StringUtils;
import org.joda.time.DateTime;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.util.Date;
import java.util.List;
import java.util.Random;
import java.util.UUID;

@Service
public class AliyunProvider {
    //阿里云OSS地址，这里看根据你的oss选择
    @Value("${aliyun.oss.endpoint}")
    String endpoint;
    //阿里云OSS账号
    @Value("${aliyun.ramuser.accesskey.id}")
    String accessKeyId;
    //阿里云OSS密钥
    @Value("${aliyun.ramuser.accesskey.secret}")
    String accessKeySecret;
    //阿里云OSS上的存储块bucket名字
    @Value("${aliyun.oss.bucketName}")
    private String bucketName;


    /**
     * 创建存储空间
     */

    public void createBucket() {
        // 创建OSSClient实例。
        OSS ossClient = new OSSClientBuilder().build(endpoint, accessKeyId, accessKeySecret);
        if(ossClient.doesBucketExist(bucketName)){
            throw new RuntimeException(bucketName + "在对象存储的Bucket列表中已经存在");
        }
        // 创建存储空间。
        ossClient.createBucket(bucketName);
        // 关闭OSSClient。
        ossClient.shutdown();
    }

    /**
     * 上传文件
     *
     * @param file
     * @return
     */

    public String upload(MultipartFile file) {
        String uploadUrl = null;
        try{
            OSS ossClient = new OSSClientBuilder().build(endpoint, accessKeyId, accessKeySecret);
            if(!ossClient.doesBucketExist(bucketName)){
                ossClient.createBucket(bucketName);
                ossClient.setBucketAcl(bucketName, CannedAccessControlList.PublicRead);
            }
            InputStream inputStream = file.getInputStream();
            //构建日期的文件夹路径
            String datePath = new DateTime().toString("yyyy/MM/dd");
            //获取文件名称
            String original = file.getOriginalFilename();
            //获取uuid
            String fileName = UUID.randomUUID().toString().replaceAll("-", "");
            //获取上传文件的扩展名
            String fileType = original.substring(original.lastIndexOf("."));
            //拼接文件名称
            String newName = fileName + fileType;
            //生成文件夹
            fileName = datePath + "/" + newName;
            //如果想要图片预览的效果，要设置一下几点
            //1.设置文件的ACL(权限) 要么是公共读，要么是公共读写
            //2.一定要设置文本类型
            ObjectMetadata objectMetadata = new ObjectMetadata();
            //设置公共读权限
            objectMetadata.setObjectAcl(CannedAccessControlList.PublicRead);
            objectMetadata.setContentType(fileType);

            //每次上传得到的名字不能相同，在Java中如何让每次生成的名字不一样
            //uuid redis 分布式Id 雪花算法 为了更加方便的区分这边的文件格式yyyy/MM/dd+uuid
            ossClient.putObject(bucketName, fileName, inputStream, objectMetadata);
            ossClient.shutdown();
            //设置过期时间  10年不过期  可以直接预览
            Date expiration = new Date(System.currentTimeMillis()+ 3600L * 1000 * 24 * 365 * 10);
            uploadUrl = ossClient.generatePresignedUrl(bucketName, fileName, expiration).toString();
            //uploadUrl = " https://" + bucketName + "." + endpoint + "/" + fileName;

        }catch(Exception e) {
            e.printStackTrace();
        }
        // 创建OSSClient实例。
        return uploadUrl.substring(0, uploadUrl.indexOf("?"));
    }
}
