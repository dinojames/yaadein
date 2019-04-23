%{
#include<stdio.h>
#include<math.h>
%}
%union {float num;}
%start line
%token cos1
%token sin1
%token tan1
%token <num> number
%type <num> exp
%%
line : exp
| line exp
;
exp :number {$$=$1;}
|exp '+' number {$$=$1+$3;printf("\n%f+%f=%f\n",$1,$3,$$);}
|exp '-' number {$$=$1-$3;printf("\n%f-%f=%f\n",$1,$3,$$);}
|exp '*' number {$$=$1*$3;printf("\n%f*%f=%f\n",$1,$3,$$);}
|exp '/' number {$$=$1/$3;printf("\n%f/%f=%f\n",$1,$3,$$);}
|cos1 number {printf("%f",cos(($2/180)*3.14));}
|sin1 number {printf("%f",sin(($2/180)*3.14));}
|tan1 number {printf("%f",tan(($2/180)*3.14));}
;
%%
int main(){
yyparse();
return 0;
}
int yyerror(){
exit(0);
}

