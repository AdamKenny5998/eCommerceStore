/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.eCommerceSpringBoot.exceptionHandlers;

/**
 *
 * @author Adam
 */
public class ResourceNotFoundException extends RuntimeException{
    public ResourceNotFoundException(){
        super();
    }
    
    public ResourceNotFoundException(final String message, final Throwable cause){
        super(message, cause);
    }
    
    public ResourceNotFoundException(final String message){
        super(message);
    }
    
    public ResourceNotFoundException(final Throwable cause){
        super(cause);
    }
}
