#How to calculate Time and Space complexity of a Algorithm?

<b>Time Complexity</b>

Let's start with basic mathematics. What are the basic operations that we can do in mathematics?

- _Addition_

- _Subtraction_

- _Multiplication_

- _Division_

	
	
When we talk about addition, say we have to add two 4 digit numbers i.e 3498 and 2309. How many times we have to do operation? 
4 times i.e Adding 8 with 9, 9 with 0, 4 with 3 and 3 with 2.

Same is the case with subtraction. We have to do operation 4 times. 
So for both addition and subtraction we have, 

- Number of Operations = Number of Elements 

_This results in linear complexity i.e O(N)_  


With respect to Multiplication, say we have to multiply two 4 digit numbers i.e 3498 and 2309. How many times we have to do operation? 
16 times i.e multiply each of the digit from second number to first number. So for two 4 digit numbers, we will end up doing 16 operations. 
Generic statement comes out to be,

- Number of Operations = (Number of Elements)²

_This results in quadratic complexity i.e O(N²)_ 


Now, Question comes what is O here?

- This is called as Big-Oh.
- Big-Oh is relative representation of complexity of Algorithm

	
	
Let's take Bubble Sort Algorithm now. We have collection of elements as X, and bubble sort can be represented as

```
1 LET N = LEN(X)
2  FOR I = 1 TO N
3   FOR J = 1 TO N
4     IF X[I] > X[J] THEN
5       LET T = X[I]
6       LET  X[I] = X[J]
7       LET  X[J] = T
8     END IF
9   NEXT J
10 NEXT I
```

Lines 5 to 7 is basically doing a swap and gets executed every time when list is out of order.

- if list is sorted, it will never get executed.
- If list is unsorted, it will get executed every time.

	 
Now, let's see how many times each of the line gets executed

- Line 1 - 1
- Line 2 - N
- Line 3 - N² since, we have outer loop running N times + inner loop N times
- Line 4 - N²
- Line 5 - if condition at line 4 is satisfied then N² times else 0 times 
- Line 6 - if condition at line 4 is satisfied then N² times else 0 times
- Line 7 - if condition at line 4 is satisfied then N² times else 0 times
- Line 8 - N²
- Line 9 - N²
- Line 10 - N

Worst Case of this Algorithm is when all the lines gets executed maximum times and best case is when minimum lines gets executed minimum times.

1. Worst Case : 7N² + 2N + 1
2. Best Case : 4N² + 2N + 1
3. General term : aN² + bN + c

Here N² is the fastest growing term and decides if algorithm is good or bad. So complexity comes out to be O(N²) 