#include <math.h>
#include <stdio.h>
#include <stdlib.h>
#include <time.h>
#include <string.h>

// Function to randomly generates password
void randomPasswordGeneration(int N)
{
    // Initialize counter
    int random, i;
    random = i = 0;

    srand((unsigned int)(time(NULL)));

    // Stores the password
    char* password = (char *) malloc(17);
  
    //Random number between 1 and 4
    random = rand() % 4;  
    for (i = 0; i < N; i++) {
  
        if (random == 1) {
            char* numbers = (char *) malloc (10);
            strncpy(numbers,"1234567890",10);
            *(password + i) = *((numbers) + (rand() % 10));
            random = rand() % 4;
            printf("%c", *(password + i));
            free(numbers);
        
        
        } else if (random == 2) {
            char* symbols = (char *) malloc (8);
            strncpy(symbols,"!$\%^&*@",8);
            *(password + i) = *((symbols) + (rand() % 8));
            random = rand() % 4;    
            printf("%c", *(password + i));
            free(symbols);
        
        
        } else if (random == 3) {
            
            char* upper = (char *) malloc(26);
            strncpy(upper, "ABCDEFGHIJKLMNOQPRSTUYWVZX", 26);
            *(password + i) = *((upper) + (rand() % 26));
            random = rand() % 4;
            printf("%c", *(password + i));
            free(upper);
        
        
        } else {
            char* letter = (char *) malloc(26);
            strncpy(letter, "abcdefghijklmnoqprstuvwyzx", 26);
            *(password + i) = *((letter) + (rand() % 26));;
            random = rand() % 4;
            printf("%c", *(password + i));
            free(letter);
        }
    }
    printf("\n");
    free(password);
}
  
// Driver Code
int main() {
  
    // Function Call
    srand(time(0));
    int number = (rand() % (20 - 14 + 1)) + 14;
    randomPasswordGeneration(number);
    return 0;
}
