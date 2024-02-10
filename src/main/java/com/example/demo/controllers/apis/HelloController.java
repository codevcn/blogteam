// package com.example.demo.controllers.apis;

// import com.example.demo.DTOs.test.RequestBodyDTO.*;
// import com.example.demo.DTOs.test.ResponseBodyDTO.*;
// import java.util.concurrent.atomic.AtomicLong;
// import org.springframework.beans.factory.annotation.Autowired;
// import org.springframework.core.env.Environment;
// import org.springframework.web.bind.annotation.DeleteMapping;
// import org.springframework.web.bind.annotation.GetMapping;
// import org.springframework.web.bind.annotation.PathVariable;
// import org.springframework.web.bind.annotation.PostMapping;
// import org.springframework.web.bind.annotation.RequestBody;
// import org.springframework.web.bind.annotation.RequestMapping;
// import org.springframework.web.bind.annotation.RequestParam;
// import org.springframework.web.bind.annotation.RestController;

// @RestController
// @RequestMapping("api")
// public class HelloController {

//     private final String template = "Hello, %s!";
//     private final AtomicLong counter = new AtomicLong();

//     @Autowired
//     private Environment environment;

//     @GetMapping("greeting")
//     public ResBodyOneDTO greeting(@RequestParam(value = "name", defaultValue = "World") String name) {
//         return new ResBodyOneDTO(counter.incrementAndGet(), String.format(template, name), 20);
//     }

//     @GetMapping
//     public String home() {
//         // code more...
//         return "My Life And I'm fan of Will Smith =))";
//     }

//     @GetMapping("lalala-okay")
//     public String todo() {
//         return ">>> This is money???";
//     }

//     @PostMapping("send")
//     public ResBodyOneDTO send(@RequestBody ReqBodyOneDTO reqBody) {
//         System.out.printf("\n>>> ( \n");
//         System.out.print(reqBody);
//         System.out.printf("\n>>> ) \n");
//         return new ResBodyOneDTO(reqBody.reqId(), reqBody.reqContent(), 40);
//     }

//     @DeleteMapping
//     public Success delete() {
//         System.out.printf(">>> env 1 info: %s \n", environment.getProperty("rssenv.rssEnv1"));
//         System.out.printf(">>> env 2 info: %s \n", environment.getProperty("rssenv.rssEnv2"));
//         System.out.printf(">>> env 3 info: %s \n", environment.getProperty("rssenv.rssEnv3"));
//         return new Success();
//     }

//     @PostMapping("test-response-body-one")
//     public Success testResponseBodyOne(@RequestBody ReqBodyOneDTO reqBody) {
//         System.out.printf("\n>>> ( \n");
//         System.out.print(reqBody);
//         System.out.printf("\n>>> ) \n");
//         return new Success();
//     }

//     @PostMapping("test-response-body-two")
//     public Success testResponseBodyTwo(@RequestBody ReqBodyTwoDTO reqBody) {
//         System.out.printf("\n>>> ( \n");
//         System.out.print(reqBody);
//         System.out.printf("\n>>> ) \n");
//         return new Success();
//     }

//     @PostMapping("test-response-body-three")
//     public Success testResponseBodyThree(@RequestBody ReqBodyThreeDTO reqBody) {
//         System.out.printf("\n>>> ( \n");
//         System.out.print(reqBody);
//         System.out.printf("\n>>> ) \n");
//         return new Success();
//     }

//     @GetMapping("success")
//     public Success success() {
//         return new Success();
//     }

//     @GetMapping("param/{paramID}")
//     public Success pathVariable(@PathVariable("paramID") int paramID) {
//         System.out.printf(">>> paramID: %d \n", paramID);
//         return new Success("VCN path variable ID: " + paramID);
//     }
// }
