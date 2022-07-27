package com.tech.grpc.service;

import com.tech.grpc.GreetingRequest;
import com.tech.grpc.GreetingResponse;
import com.tech.grpc.GreetingServiceGrpc;
import io.grpc.stub.StreamObserver;
import net.devh.boot.grpc.server.service.GrpcService;

@GrpcService
public class GreetingServiceImpl extends GreetingServiceGrpc.GreetingServiceImplBase {

    @Override
    public void greeting(GreetingRequest request, StreamObserver<GreetingResponse> responseObserver) {
        String message = request.getMessage();

        System.out.println("The request is " + message);

        GreetingResponse greetingResponse = GreetingResponse.newBuilder().
                setMessage("Recieved your message: "  + message + ": Hello from Server").
                build();

        responseObserver.onNext(greetingResponse);
        responseObserver.onCompleted();
    }
}
