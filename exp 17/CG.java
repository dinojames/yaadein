import java.io.*;
import java.util.*;
class CG
{
public static void main(String args[])
{
String e1;
Scanner sc=new Scanner(System.in);
System.out.println("Enter equation 1: ");
e1=sc.nextLine();
System.out.println("LDF R1,"+ e1.charAt(2));
System.out.println("LDF R2,"+ e1.charAt(4));
char ar=e1.charAt(3);
switch(ar)
{
case '+' :
System.out.println("ADDF R1,R2");
break;
case '-' :
System.out.println("SUBF R1,R2");
break;
case '*' :
System.out.println("MULF R1,R2");
break;
case '/' :
System.out.println("DIVF R1,R2");
break;
default :
System.out.println("Invalid input!");
}
System.out.println("STF R1");
}
}
