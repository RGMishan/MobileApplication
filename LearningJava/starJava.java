class Simple{  
    public static void main(String args[]){  
     
     int height = 5;
     for (int i = 1; i<= height; i++){
      for (int j = height ; j>i ; j--){
       System.out.print(" ");
      }
      for (int j = 1; j<=i; j++){
       System.out.print("* ");
      }
      System.out.println("\n");
     }
    }  
}  
//-11*i+68
//-2*i+11