/*lex code to count the number of lines, 
    tabs and spaces used in the input*/
  
%{ 
#include<stdio.h> 
int lc=0, tc=0, wd=0, let=0, dg=0; /*Global variables*/

%} 
  
/*Rule Section*/

%%

\n { lc++; wd++;} //line counter 
[\t ' '] wd++; //word counter
\t tc++; //tab counter 
[A-Z] let++;
[a-z] let++; //letters counter
[0-9] dg++; //digits counter

%%


int main()
{ 
    // The function that starts the analysis 
    yyin=fopen("abc.txt","r");
    yylex();
      
    printf("\nNo. of lines=%d", lc);   
    printf("\nNo. of tabs=%d", tc); 
    printf("\nNo. of words=%d", wd); 
    printf("\nNo. of letters=%d", let);       
    printf("\nNo. of digits=%d\n", dg);       
   
}
	int yywrap()
{
	return 1;
}

