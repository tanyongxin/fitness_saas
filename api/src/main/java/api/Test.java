package api;

import org.apache.dubbo.config.annotation.Service;

@Service(
        version = "1.0.0",
        interfaceClass = TestInterface.class,
        cluster = "failfast",
        loadbalance = "roundrobin"
)
public class Test implements TestInterface {

    @Override
    public void test() {

    }
}
