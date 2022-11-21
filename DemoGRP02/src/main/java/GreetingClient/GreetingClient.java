package GreetingClient;

import com.proto.dummy.DummyServiceGrpc;
import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;

public class GreetingClient {

    public static void main(String[] args){
        System.out.println("Hello qRPC Client");
        ManagedChannel channel = ManagedChannelBuilder
                .forAddress("localhost", 5055)
                .usePlaintext()
                .build();
        System.out.println("Creating stub");
        DummyServiceGrpc.DummyServiceBlockingStub syncClient
                = DummyServiceGrpc.newBlockingStub(channel);

        System.out.println("Shutting down channel");
        channel.shutdown();
    }
}
