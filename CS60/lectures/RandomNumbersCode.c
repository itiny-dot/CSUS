/*--------------------------------------------------*/
/*  You may print this out for yourself, but you    */
/*  not required to turn it in.                     */
/*  This program generates and prints ten random    */
/*  integers between user-specified limits.         */

#include <stdio.h>
#include <stdlib.h>

int main(void)
{
   /*  Declare variables and function prototypes.  */
   unsigned int seed;
   int a;
   int b;
   int k;
   int rand_int(int a, int b); /* function prototype */
   char go_on[3] = "y";

   while (go_on[0] == 'y' || go_on[0] == 'Y')
   {
	  /*  Get seed value and interval limits.  */
	  printf("\nEnter a positive integer seed value:  ");
	  scanf("%u",&seed);
	  srand(seed);
	  printf("\nEnter integer limits a and b (a<b):  ");
	  scanf("%i %i",&a,&b);

	  /*  Generate and print ten random numbers  */
	  printf("\nRandom Numbers: \n\n");
	  for (k=1; k<=10; k++)
		printf("%i ",rand_int(a,b));
		
	  printf("\n\n");

	  printf("Enter \"y\" or \"Y\" for YES if you wish to continue:  ");
	  scanf("%s", go_on);
   }

   /*  Exit program.  */
   printf("\n");
   system("pause");
   return EXIT_SUCCESS;
}
/*---------------------------------------------------*/
/*  This function generates one random integer       */
/*  between specified limits a and b (a<b).          */

int rand_int(int a, int b)
{
   return rand()%(b - a + 1) + a;
}
/*---------------------------------------------------*/

