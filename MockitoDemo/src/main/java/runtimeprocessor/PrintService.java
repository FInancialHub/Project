package runtimeprocessor;
 
 
public class PrintService implements Observable {
 private static Observable instance;
 private PrintService(){
   
 }
 public static Observable getInstance() {
  if (instance == null) {   
   instance = (Observable) TestingProxy.getNewProxy(new PrintService(),
     Observable.class);   
  }
  return instance;
 }
  
 @Testing
 public void print1() {
  System.out.println("1 - Text in annotated method");
 }
  
 public void print2() {
  System.out.println("2 - Just ususal text");
 }
}