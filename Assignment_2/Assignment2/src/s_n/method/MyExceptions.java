/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package s_n.method;

public class MyExceptions extends RuntimeException {
    public MyExceptions(){
        super();
    }
    
    public MyExceptions(String messgage){
        super(messgage);
    }
}
