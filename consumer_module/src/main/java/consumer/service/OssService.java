package consumer.service;

import api.pojo.oss.OssCallbackResult;
import api.pojo.oss.OssPolicyResult;

import javax.servlet.http.HttpServletRequest;

public interface OssService {

    /**
     * oss上传策略生成
     */
    OssPolicyResult policy();

    /**
     * oss上传成功回调
     */
    OssCallbackResult callback(HttpServletRequest request);
}
