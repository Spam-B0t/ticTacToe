package tictactoe.spambot;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        char field[][]=new char[3][3];
        int n=0;
        //System.out.print("Enter cells: ");
        //String s = in.nextLine();
        String s="_________";
        for(int i=0; i<3; i++)for(int j=0; j<3; j++){field[i][j]=s.charAt(n); n++;}
        n=0;
        while(getState(field).equals("Game not finished")){
            drawBoard(field);
            if(n%2==0)putfig('X', field, in);
            else putfig('O', field, in);
            n=(n+1)%2;
        }
        System.out.println(getState(field));
    }
    
    static void drawBoard(char field[][]){
      for(int i=0; i<3*field.length; i++) System.out.print('-');
        System.out.println();
        for(int i=0; i<field.length; i++) {
          System.out.print("| ");
          for(int j=0; j<field.length; j++)System.out.print(field[i][j]+" ");
          System.out.println('|');
        }
        for(int i=0; i<3*field.length; i++) System.out.print('-');
        System.out.println();
    }
    
    static void putfig(char fig, char field[][], Scanner in){
      System.out.print("Enter the coordinates: ");
      try{
          int x=in.nextInt()-1, y=in.nextInt()-1, e=0, xn=0, on=0;
          if(field[2-y][x]=='_')field[2-y][x]=fig;
          else{
              System.out.println("This cell is occupied! Choose another one!");
              putfig(fig, field, in);
          }
      }
      catch(Exception e){
          System.out.println("You should enter numbers!");
          in.next();
          putfig(fig, field, in);
      }
      
    }
    
    static String getState(char field[][]){
      int x=0, o=0, e=0, xn=0, on=0;
      String out="";
      for(int i=0; i<field.length; i++)for(int j=0; j<field[i].length; j++)
          if(field[i][j]=='X')xn++; else if(field[i][j]=='O')on++; else e++;
      for(int i=0; i<field.length; i++){
        if(field[i][0]=='X' && field[i][1]=='X' && field[i][2]=='X')x++;
        else if(field[i][0]=='O' && field[i][1]=='O' && field[i][2]=='O')o++;
      }
      for(int i=0; i<field.length; i++){
        if(field[0][i]=='X' && field[1][i]=='X' && field[2][i]=='X')x++;
        else if(field[0][i]=='O' && field[1][i]=='O' && field[2][i]=='O')o++;
      }
      if(field[0][0]=='X' && field[1][1]=='X' && field[2][2]=='X')x++;
      else if(field[0][0]=='O' && field[1][1]=='O' && field[2][2]=='O')o++;
      if(field[0][2]=='X' && field[1][1]=='X' && field[2][0]=='X')x++;
      else if(field[0][2]=='O' && field[1][1]=='O' && field[2][0]=='O')o++;
      /*System.out.print("xn=");System.out.println(xn);
      System.out.print("on=");System.out.println(on);
      System.out.print("o=");System.out.println(o);
      System.out.print("x=");System.out.println(x);*/
      if(Math.abs(xn-on)>1 || (x>0 && o>0)) out="Impossible";
      else if(x==1 && o==0) out="X wins";
      else if(x==0 && o==1) out="O wins";
      else if(e==0) out="Draw";
      else if(e!=0) out="Game not finished";
      return out;
    }
    
    
    
}

/*
Enter cells: O_OXXO_XX
---------
| O _ O |
| X X O |
| _ X X |
---------
*/
/*
for(int i=0; i<9; i++) System.out.print('-');
        System.out.println();
        for(int i=0; i<9; i++) {
          if(i%3==0)System.out.print("| ");
          System.out.print(s.charAt(i)+" ");
          if(i%3==2)System.out.println('|');
        }
        for(int i=0; i<9; i++) System.out.print('-');
*/