/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.aws.lambdacaller;

import com.amazonaws.auth.profile.ProfileCredentialsProvider;
import com.amazonaws.regions.Regions;
import com.amazonaws.services.lambda.AWSLambdaAsyncClient;
import com.amazonaws.services.lambda.model.InvokeRequest;
import com.amazonaws.services.lambda.model.InvokeResult;
import com.aws.hellolambda.helloInput;
import com.aws.hellolambda.helloOutput;
import com.google.gson.Gson;
import java.nio.charset.StandardCharsets;

/**
 *
 * @author akash
 */
public class HelloLambdaCaller {
    
    public static void main(String args[]){
        String name ="akash singh";
        String region="us-east-1";
        
         if(args.length>0){
            name = args[0];
           }   
         if(args.length>1) {
            region = args[1];
           } 
        
        
        
        Gson g = new Gson();
        AWSLambdaAsyncClient client = new AWSLambdaAsyncClient(new ProfileCredentialsProvider("helloLambda"))
        .withRegion(Regions.fromName(region));
        
         helloInput in  = new helloInput();
         in.setName(name);
         InvokeRequest request = new InvokeRequest().withFunctionName("helloLambda").withPayload(g.toJson(in));
         InvokeResult result = client.invoke(request);
         String s = StandardCharsets.UTF_8.decode(result.getPayload()).toString();
         
         helloOutput out = g.fromJson(s,helloOutput.class);
         System.out.println("Message: "+out.getMessage());
         System.out.println("FunctionName: "+out.getFunctionName());
         System.out.println("MemoryLimit: "+out.getMemoryLimit());
    }
    
}
