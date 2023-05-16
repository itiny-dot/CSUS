/*-------------------------------------------------------*/
/* This program counts words line by line                */ 
/* count_words.cpp                                       */

#include <stdio.h>
#include <stdlib.h>
#define FILENAME "Text1.dat"
#define NEWLINE '\n'
#define SPACE ' '

/* function prototype */
int word_cnt(int x[ ], int npts);

int main(void)
{
     int line[100], k = 0, count = 0;
     FILE *text1;
 
     text1 = fopen(FILENAME, "r");
     while ((line[k] = fgetc(text1)) != EOF)
     {
          if (line[k] == NEWLINE)
          {
			if (k != 0)
				count += word_cnt(line, k);
			k = 0;
          }
          else
			k++;
      }
	  if (k != 0)
          count += word_cnt(line, k);

      printf("%i words read. \n", count);
      system("pause");
      return EXIT_SUCCESS;
}
/*-------------------------------------------------------*/
/* Function to count number of words in an integer array */

int word_cnt(int x[ ], int npts)
{
     int count = 0, k = 0;
     while (k < npts)
     {
          while ((k < npts) && (x[k] == SPACE))
			  k++;

          if (k < npts)
			  count++;

          while (k < npts && x[k] != SPACE)
			  k++;
     }
     return count;
}
/*-------------------------------------------------------*/
