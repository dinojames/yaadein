import java.util.*;
import java.io.*;
class first_and_follow
{
static char nonterminal[],terminal[];
static int nonterminal_len,terminal_len;
static String grammer[][],first[],follow[];
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
follow=new String[nonterminal_len];
for(i=0;i<nonterminal_len;i++)
follow[i]=follow(i);
System.out.println("Follow Set");
for(i=0;i<nonterminal_len;i++)
System.out.println(removeDuplicates(follow[i]));
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
if(str.contains("9")) //here epsilon will lead to next nonterminal’s first set
continue;
}
else //if first set includes terminal
temp=temp+grammer[i][j].charAt(k);
break;
}
}
return temp;
}
static String follow(int i)
{
char pro[],chr[];
String temp="";
int j,k,l,m,n,found=0;
if(i==0)
temp="$";
for(j=0;j<nonterminal_len;j++)
{
for(k=0;k<grammer[j].length;k++) //entering grammar matrix
{
pro=new char[grammer[j][k].length()];
pro=grammer[j][k].toCharArray();
for(l=0;l<pro.length;l++) //entering each production
{
if(pro[l]==nonterminal[i]) //finding the nonterminal whose follow set is to be found
{
if(l==pro.length-1) //if it is the last terminal/non-terminal then follow of current non-terminal
{
if(j<i)
temp=temp+follow[j];
}
else
{
for(m=0;m<nonterminal_len;m++)
{
if(pro[l+1]==nonterminal[m]) //first of next non-terminal otherwise (else later…)
{
chr=new char[first[m].length()];
chr=first[m].toCharArray();
for(n=0;n<chr.length;n++)
{
if(chr[n]=='9') //if first includes epsilon
{
if(l+1==pro.length-1)
temp=temp+follow(j); //when non-terminal is second last
else
temp=temp+follow(m);
}
else
temp=temp+chr[n]; //include whole first set except epsilon
}
found=1;
}
}
if(found!=1)
temp=temp+pro[l+1]; //follow set will include terminal(else is here)
}
}
}
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
