package ua.edu.ukma.modulithdemo;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.modulith.core.ApplicationModules;
import org.springframework.modulith.docs.Documenter;

@SpringBootTest
class ModulithDemoApplicationTests {

    @Test
    void contextLoads() {
    }

    @Test
    void createApplicationModuleModel() {
        ApplicationModules modules = ApplicationModules.of(ModulithDemoApplication.class);
        modules.verify();
        modules.forEach(System.out::println);
//        new Documenter(modules)
//                .writeDocumentation()
//                .writeIndividualModulesAsPlantUml();
    }
}
