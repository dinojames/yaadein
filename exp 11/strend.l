%{
#include <stdio.h>
%}
%%
(a|A)[a-z]*[0-9]*(b|B)    {printf("matching");}

.*    {printf("not matching");}
%%
int main()
{
yylex();
return 0;
}
int yywrap()
{
}
