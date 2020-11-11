package consumer.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import javax.servlet.http.HttpServletRequest;

/*
oss 文件上传的坑：
1、上传时携带的参数顺序有要求：
                    formdata.append("policy",beforeResult.msg.policy);
                    formdata.append("signature",beforeResult.msg.signature);
                    formdata.append("key",beforeResult.msg.key);
                    formdata.append("ossaccessKeyId",beforeResult.msg.accessKeyId);
                    formdata.append("dir",beforeResult.msg.dir);
                    formdata.append("host",beforeResult.msg.host);
                    formdata.append("callback",beforeResult.msg.callback);
2、Private address is forbidden to callback：回调地址不能是私网地址，必须是公网地址
  使用公网 ip，公网ip 直接在百度上搜 ip 即可
3、The specified object is not valid
  aliyun.oss.dir.prefix=community/management/sign/content 前缀不要以 / 开头
4、
203 错误，上传成功但无法回调自定义函数
Error status : -1.OSS can not connect to your callbackUrl, please check it
5、The specified key does not exist
 */
// oss controller
@Controller
@RequestMapping("/aliyun/oss")
public class OssController {
//    @Autowired
//    private OssService ossService;
//
//    @RequestMapping(value = "/policy", method = RequestMethod.GET)
//    @ResponseBody
//    public OssPolicyResult policy() {
//        OssPolicyResult result = ossService.policy();
//        return result;
//    }
//
//    @RequestMapping(value = "/callback", method = RequestMethod.POST)
//    @ResponseBody
//    public OssCallbackResult callback(HttpServletRequest request) {
//        OssCallbackResult ossCallbackResult = ossService.callback(request);
//        return ossCallbackResult;
//    }
}
