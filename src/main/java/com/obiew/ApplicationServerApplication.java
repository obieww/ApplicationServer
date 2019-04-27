package com.obiew;

import io.grpc.examples.obiew.Server;
import com.obiew.Repositories.RemoteUserRepository;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

@SpringBootApplication(scanBasePackages = {"com.obiew.Controllers",
        "com.obiew.Entities",
        "com.obiew.Repositories",
        "io.grpc.examples.obiew"
        })
@EnableSwagger2
public class ApplicationServerApplication {

    @Bean
    public Server getServer() throws Exception {
        Registry registry = LocateRegistry.getRegistry(8000);
        Server server = (Server) registry
                .lookup("Server");
        return server;
    }

    @Bean
    public RemoteUserRepository getRemoteUserRepository() {
        return new RemoteUserRepository();
    }

    public static void main(String[] args) {
        SpringApplication.run(ApplicationServerApplication.class, args);
    }

}
