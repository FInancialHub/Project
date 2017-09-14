package runtimeprocessor;
 
public class Application {
 public static void main(String[] args) {
  Observable printService = PrintService.getInstance();  
  printService.print1();  
  printService.print2();
 }
}