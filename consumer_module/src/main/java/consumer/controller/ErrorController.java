package consumer.controller;

import api.pojo.Res;
import org.apache.dubbo.rpc.RpcException;
//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import javax.servlet.http.HttpServletRequest;

@RestController
public class ErrorController {

//    Logger logger = LoggerFactory.getLogger(ErrorController.class);

    @RequestMapping("/handleErr")
    public Res<Void> consumerErr(HttpServletRequest request){
        Object attribute = request.getAttribute(ConsumerControllerAdvice.ERR_TYPE);
        return attribute instanceof RpcException ? Res.offline : Res.failure;
    }
}
