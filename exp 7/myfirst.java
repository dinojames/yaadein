import java.util.*;
import java.io.*;
class myfirst
{
static char nonterminal[],terminal[];
static int nonterminal_len,terminal_len;
static String grammer[][],first[];
public static void main(String args[]) throws IOException
{
String nt,t;
int i,j,n;
BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
System.out.println("Enter the non-terminals");
nt=br.readLine();
nonterminal_len=nt.length();
nonterminal=new char[nonterminal_len];
nonterminal=nt.toCharArray();
System.out.println("Enter the terminals");
t=br.readLine();
terminal_len=t.length();
terminal=new char[terminal_len];
terminal=t.toCharArray();
System.out.println("Specify the grammar(Enter 9 for epsilon production)");
grammer=new String[nonterminal_len][];
for(i=0;i<nonterminal_len;i++)
{
System.out.println("Enter the number of productions for "+nonterminal[i]);
n=Integer.parseInt(br.readLine());
grammer[i]=new String[n];
System.out.println("Enter the productions");
for(j=0;j<n;j++)
grammer[i][j]=br.readLine();
}
first=new String[nonterminal_len];
for(i=0;i<nonterminal_len;i++)
first[i]=first(i);
System.out.println("First Set");
for(i=0;i<nonterminal_len;i++)
System.out.println(removeDuplicates(first[i]));

}
static String first(int i)
{
int j,k,l=0,found=0;
String temp="",str="";
for(j=0;j<grammer[i].length;j++) //number of productions
{
for(k=0;k<grammer[i][j].length();k++,found=0) //when nonterminal has epsilon production
{
for(l=0;l<nonterminal_len;l++) //finding nonterminal
{
if(grammer[i][j].charAt(k)==nonterminal[l]) //for nonterminal in first set
{
str=first(l);
if(!(str.length()==1 && str.charAt(0)=='9')) //when epsilon production is the only nonterminal production
temp=temp+str;
found=1;
break;
}
}
if(found==1)
{
if(str.contains("9")) //here epsilon will lead to next nonterminal's first set
continue;
}
else //if first set includes terminal
temp=temp+grammer[i][j].charAt(k);
break;
}
}
return temp;
}

static String removeDuplicates(String str)
{
int i;
char ch;
boolean seen[] = new boolean[256];
StringBuilder sb = new StringBuilder(seen.length);
for(i=0;i<str.length();i++)
{
ch=str.charAt(i);
if (!seen[ch])
{
seen[ch] = true;
sb.append(ch);
}
}
return sb.toString();
}
}
