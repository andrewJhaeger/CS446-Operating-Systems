// WILL FINISH LATER

#include <stdio.h>
#include <stdlib.h>
#include <fcntl.h>
#include <sys/shm.h>
#include <sys/stat.h>
#include <sys/mman.h>
#include <unistd.h>
#include <sys/types.h>


int main()
{
  const char *name = "HW1";
  const int SIZE = 4096;
  int USINGTHISNUM = 88; // PLACEHOLDER UNTIL I FIGURE OUT HOW TO GET INPUT IN C
  pid_t pid; // Holds process id when forked
  
  int shm_fd; // for shared memory segment
  void *ptr // address of mapped object
  int i; // not used because I'm straight rippin this code from the book.

  if (pid < 0) // error
  {
    fprintf(stderr, "Failed fork\n"); // failed fork
    return 1;
  }
  else if (pid == 0) // child
  {
    // MAKE SHARED MEMORY OBJECT HERE (Read/Write)
    while (USINGTHISNUM != 1)
    {
      if (USINGTHISNUM % 2 == 0)
      {
        USIGTHISNUM /= 2;
      }
      else
      {
        USINGTHISNUM = (USINGTHISNUM * 3) + 1;
      }
    }
    else // PARENT
    {
      // MAKE SHARED MEMORY OBJECT
       wait(); // NEED WAIT HERE?
      // READ FROM SHARED MEMORY OBJECT
    }
  }
  return 0;
}


