/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.aws.hellolambda;

import com.amazonaws.services.lambda.runtime.Context;
import com.amazonaws.services.lambda.runtime.RequestHandler;

/**
 *
 * @author akash
 */
public class helloHandler implements RequestHandler<helloInput,helloOutput>{
    
    @Override
    public helloOutput handleRequest(helloInput i, Context cntxt) {
      helloOutput o = new helloOutput();
      o.setMessage("Hello "+i.getName());
      o.setFunctionName(cntxt.getFunctionName());
      o.setMemoryLimit(cntxt.getMemoryLimitInMB());
      cntxt.getLogger().log(i.getName()+ "said hello");
      return o; 
    }
}
    
  
