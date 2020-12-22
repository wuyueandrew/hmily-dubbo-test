package indi.wuyue.hmily.dubbo.test.app;

import indi.wuyue.hmily.dubbo.test.api.AccountChangeDTO;
import indi.wuyue.hmily.dubbo.test.api.AccountChangeServiceA;
import indi.wuyue.hmily.dubbo.test.api.TransferDTO;
import org.apache.dubbo.config.ApplicationConfig;
import org.apache.dubbo.config.ReferenceConfig;
import org.apache.dubbo.config.RegistryConfig;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.data.mongo.MongoDataAutoConfiguration;
import org.springframework.boot.autoconfigure.mongo.MongoAutoConfiguration;

@SpringBootApplication(exclude = {MongoAutoConfiguration.class, MongoDataAutoConfiguration.class})
public class Application {

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }


//    private static String zookeeperHost = System.getProperty("zookeeper.address", "127.0.0.1");
//
//    public static void main(String[] args) {
//        ReferenceConfig<AccountChangeServiceA> reference = new ReferenceConfig<>();
//        reference.setApplication(new ApplicationConfig("first-dubbo-consumer"));
//        reference.setRegistry(new RegistryConfig("zookeeper://" + zookeeperHost + ":2181"));
//        reference.setInterface(AccountChangeServiceA.class);
//        AccountChangeServiceA service = reference.get();
//
//        AccountChangeDTO dto = new AccountChangeDTO();
//        dto.setAccountId(1L);
//        dto.setFeeAmount(123L);
//
//        service.accountChange(dto);
//    }

}
