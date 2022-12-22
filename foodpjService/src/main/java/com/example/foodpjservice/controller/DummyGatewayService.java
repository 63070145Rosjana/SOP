package com.example.foodpjservice.controller;

import com.proto.greet.*;
import io.grpc.*;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DummyGatewayService {

    @Autowired
    private RabbitTemplate rabbitTemplate;


    @RequestMapping(value = "/dummy.gateway/{name}", method = RequestMethod.GET)
    public String test2(@PathVariable("name") String name) {
    ManagedChannel channel = ManagedChannelBuilder.forAddress("localhost",50055)
                .usePlaintext().build();
        DummyServiceGrpc.DummyServiceBlockingStub syncClient
                = DummyServiceGrpc.newBlockingStub(channel);

        DummyServiceGrpc.DummyServiceBlockingStub dummyClient
                = DummyServiceGrpc.newBlockingStub(channel);
// created a protocol buffer greeting message
        DummyMessage requestMessage = DummyMessage.newBuilder().setTxt(name).build();
// call the RPC and get back a GreetResponse (Protocol Buffers)
        DummyMessage responseMessage = dummyClient.sayHi(requestMessage);
        channel.shutdown();
        return responseMessage.getTxt();
}}
