public class N_Quen {
    public static boolean issafe(char bord [][], int row,int col ){
     // verticle up 
     for(int i=row-1; i>=0; i--){
        if (bord[i][col]=='Q') {
            return false;
        }
     }
     // diagonal left up
     for(int i=row-1,j=col-1; i>=0 && j>=0; j--, i--){
        if (bord[i][j]=='Q') {
            return false;
        }
     }
     // diagonal right up
     for (int i =row-1, j=col+1;i>=0 && j < bord.length; i--,j++) {
        if (bord[i][j]=='Q') {
            return false;
        }
     }
     return true;
    }
    public static void nQuen(char bord [][], int row){
        if (row == bord.length) {
            printbord(bord);
            return;
        }
         for (int j = 0; j < bord.length; j++) {
           if (issafe(bord, row, j)) {
             bord[row][j] = 'Q';
            nQuen(bord, row+1);
            bord[row][j] =  'X';
           }
         
            
        }
    }
    public static void printbord(char bord[][]){
        System.out.println("-------bord-------");
        for (int i = 0; i < bord.length; i++) {
            for (int j = 0; j < bord.length; j++) {
                System.out.print(bord[i][j]+" ");
            }
            System.out.println();
        }
    }
    public static void main(String[] args) {
        int n  =4;
       char bord [][] = new char[n][n];
       for (int i = 0; i <n; i++) {
        for (int j = 0; j <n; j++) {
            bord [i][j] =  'x';
        }
       }
       nQuen(bord, 0);
       printbord(bord);
    }
    
}
