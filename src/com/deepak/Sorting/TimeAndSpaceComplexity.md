#When we talk about Algorithms, basic question arises, How to calculate Time and Space complexity of a Algorithm?

<b>Time Complexity</b>

Let's start with basic mathematics. What are the basic operations that we can do in mathematics?
	- Addition
	- Subtraction
	- Multiplication
	- Division
	
When we talk about addition, say we have to add two 4 digit numbers i.e 3498 and 2309.
How many times we have to do operation? 4 times i.e Adding 8 with 9, 9 with 0, 4 with 3 and 3 with 2.
Same is the case with subtraction. We have to do operation 4 times. 
So for both addition and subtraction we have, 
	Number of Operations = Number of Elements 
This results in linear complexity i.e O(N)  

With respect to Multiplication, say we have to multiply two 4 digit numbers i.e 3498 and 2309.
How many times we have to do operation? 16 times i.e multiply each of the digit from second number to first number.
So for two 4 digit numbers, we will end up doing 16 operations. Generic statement comes out to be,
	Number of Operations = (Number of Elements) ^ 2
This results in quadratic complexity i.e O(N^2) 

Now, Question comes what is O here?
	- This is called as Big-Oh.
	- Big-Oh is relative representation of complexity of Algorithm
	
Let's take Bubble Sort Algorithm now,
We have collection of elements as X, and bubble sort can be represented as

LET N = LEN(X) 
FOR I = 1 TO N
  FOR J = 1 TO N
    IF X[I] > X[J] THEN
      LET T = X[I]
      LET  X[I] = X[J]
      LET  X[J] = T
    END IF
  NEXT J
NEXT I

Lines 36 to 38 is basically doing a swap and gets executed every time when list is out of order.
	- If list is sorted, it will never get executed.
	- If list is unsorted, it will get executed every time.
	 
Now, let's see how many times each of the line gets executed
Line 32 - 1
Line 33 - N
Line 34 - N^2 since, we have outer loop running N times + inner loop N times
Line 35 - N^2
Line 36 - if condition at line 35 satisfies then N^2 times else 0 times 
Line 37 - if condition at line 35 satisfies then N^2 times else 0 times
Line 38 - if condition at line 35 satisfies then N^2 times else 0 times
Line 39 - N^2
Line 40 - N^2
Line 41 - N

Worst Case of this Algorithm is when all the lines gets executed maximum times and best case is when minimum lines gets executed minimum times.

Worst Case => 7N^2 + 2N + 1
Best Case => 4N^2 + 2N + 1
General term => aN^2 + bN + c

Here N^2 is the fastest growing term and decided if algorithm is good or bad. So complexity comes out to be O(N^2) 


 	
