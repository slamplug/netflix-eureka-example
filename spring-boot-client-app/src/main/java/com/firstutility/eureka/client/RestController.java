package com.firstutility.eureka.client;

import com.netflix.appinfo.InstanceInfo;
import com.netflix.discovery.DiscoveryClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.client.RestTemplate;

@Controller
@RequestMapping("/hello")

class RestController {

    @Autowired
    private DiscoveryClient discoveryClient;

    @RequestMapping(method=RequestMethod.GET)
    public @ResponseBody
    String sayHello(@RequestParam(value="name", required=false, defaultValue="Stranger") String name) {

        InstanceInfo instanceInfo = discoveryClient.getNextServerFromEureka("spring-boot-service-app", false);
        String url = instanceInfo.getHomePageUrl() + "/hello?name=" + name;

        RestTemplate restTemplate = new RestTemplate();
        return restTemplate.getForObject(url, String.class);
    }
}
