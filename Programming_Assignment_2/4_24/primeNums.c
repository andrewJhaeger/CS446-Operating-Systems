/*******************************************************************************/
/*  Programmer Name:  Andrew Haeger, Ryan Gillet                               */
/*  Course Title:  CS446		Section No:  01                                */
/*  Assignment Number:  2		Due Date: 03/12/13                             */
/*  Instructor:  Dr.  Farid Hallouche                                          */
/*******************************************************************************/
/*  Program Definition:  This program prompts the user for a whole number.  It */
/*    then creates a seperate thread and displays all prime numbers less then  */
/*    or equal to the number that was entered.                                 */
/*******************************************************************************/
/*  tid:  new thread id.                                                       */
/*  attr:  new thread attributes.                                              */
/*  userNum:  Number entered by the user.                                      */
/*******************************************************************************/
/*  Development History                                                        */
/*  03/10/13 - Version 1.0                                                     */
/*           - Code main function.  Prompt user.  Create Thread.  Find primes. */
/*******************************************************************************/

#include <pthread.h>
#include <stdio.h>
#include <stdlib.h>

void *runner(void *param); /* the thread */

int main()
{
    pthread_t tid; 			// New thread id
    pthread_attr_t attr; 		// New thread attributes
    int userNum;			// User input
    
    // Clear screen and descript program to user
    system("clear");
    printf("This program will display all prime numbers less then or equal");
    printf(" to the \nnumber entered. \n\nPress any key to continue...");
    getchar();
    system("clear");
    
    // Prompt user for their entry.
    printf("Enter a Whole Number: ");
    scanf("%d", &userNum);
    
    // Set up thread and send it the information needed
    pthread_attr_init(&attr);
    pthread_create(&tid, &attr, runner, (void*) &userNum);
    pthread_join(tid,NULL);
    
    return 0;
}

// The new thread
void *runner(void *param) 
{
    // Clear screen
    system("clear");
    int i, result;			// Loop and prime variables
    int* temp = (int*) param;	// Pointer to user input
    int number = *temp;		// Integer of user input
    
    // Tell user the inputed number.
    printf("List of Prime Numbers <= %d \n", number);
    
    // Check every number from 2 to users number.
    for (i = number; i > 1; i--) {
        result = isPrime(i);
        
        if (result == 1) {
            printf("%d \n", i);	// If prime, print number to screen
        }
    }
    
    pthread_exit(0);
}

// Function to determine if number is prime.
int isPrime(int check) 
{
    int j;
    
    for (j = 2; j < check; j++) {
        if(check % j == 0) {
            return 0;			// Return 0 if not prime
        }
    }
    return 1;				// Return 1 if prime
}
