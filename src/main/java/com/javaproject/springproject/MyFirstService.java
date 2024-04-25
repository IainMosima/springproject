package com.javaproject.springproject;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.annotation.PropertySources;
import org.springframework.stereotype.Service;

@Service
// @PropertySource("classpath:custom.properties")
@PropertySources({
    @PropertySource("classpath:custom.properties"),
    @PropertySource("classpath:custom2.properties")
})
public class MyFirstService {

    private MyFirstClass myFisrtClass;

    @Value("${my.name}")
    private String muCustomProp;

    @Value("${my.custom.property}")
    private String customProperty;


    public void setCustomProperty(String customProperty) {
        this.customProperty = customProperty;
    }

    public MyFirstService(MyFirstClass myFisrtClass) {
        this.myFisrtClass = myFisrtClass;
    }

    public String tellAStory() {
        
        return "The dependency is saying: " + myFisrtClass.sayHello();

    }

    public String getCustomProperty() {
        return customProperty;
    }

}

// public String getJavaVersion() {
// return environment.getProperty("java.version");

// }

// public String getOsName() {
// return environment.getProperty("os.name");

// }

// public String readProperty() {
// return environment.getProperty("my.custom.property");

// }