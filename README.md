# spiral traverser

This project is a coding exercise to traverse a matrix in a spiral order and return the output of that spiral. You can choose counter or clockwise, default is clockwise.

Here is the problem statement for clockwise:

Assume you have a two dimensional array. Each element will be an integer starting from 1, at `[0][0]`, and increasing left to right, then top to bottom. For example: 

``` 
 1  2  3  4
 5  6  7  8 
 9 10 11 12 
13 14 15 16 
``` 

Write a program that walks the matrix in a clockwise spiral, starting from `[0][0]` and spiraling inward. The output of the program should be the value stored at each cell of the matrix, in the order of traversal. 

For the example matrix above, the correct output of the problem would be

Clockwise: 

``` 
1 2 3 4 8 12 16 15 14 13 9 5 6 7 11 10
```

Counter Clock-Wise:

```
1 5 9 13 14 15 16 12 8 4 3 2 6 10 11 7
```

