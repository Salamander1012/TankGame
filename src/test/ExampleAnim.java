/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package test;

/**
 *
 * @author salmanfakhri
 */
public class ExampleAnim implements Runnable{
    
    private int x;
    
    public ExampleAnim(){
        
    }
    
    @Override
    public void run(){
    
        while(Thread.currentThread().isAlive()){
        
            x += .01;
            
            try{
            Thread.sleep(10);
            }catch(Exception e){}
        
        }
        
    }
    
    
    public int getX(){
        return x;
    }
    
    public void setX(int x){
        this.x = x;
    }
    
    
}
