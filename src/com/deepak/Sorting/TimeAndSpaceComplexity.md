#How to calculate Time and Space complexity of a Algorithm?

<b>Time Complexity</b>

Let's start with basic mathematics. What are the basic operations that we can do in mathematics?

- _Addition_

- _Subtraction_

- _Multiplication_

- _Division_   

When we talk about addition, say we have to add two 4 digit numbers i.e 3498 and 2309. How many times we have to do operation? 4 times i.e Adding 8 with 9, 9 with 0, 4 with 3 and 3 with 2. Same is the case with subtraction. We have to do operation 4 times.   
So for both addition and subtraction we have, 

- Number of Operations = Number of Elements 

_This results in linear complexity i.e O(N)_      

With respect to Multiplication, say we have to multiply two 4 digit numbers i.e 3498 and 2309. How many times we have to do operation? 16 times i.e multiply each of the digit from second number to first number. So for two 4 digit numbers, we will end up doing 16 operations. 
Generic statement comes out to be,

- Number of Operations = (Number of Elements)²

_This results in quadratic complexity i.e O(N²)_ 


Now, Question comes what is O here?

- This is called as Big-Oh.
- Big-Oh is relative representation of complexity of Algorithm

#### Bubble Sort Example 
	
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

```
Line 1 - 1
Line 2 - N
Line 3 - N² since, we have outer loop running N times + inner loop N times
Line 4 - N²
Line 5 - if condition at line 4 is satisfied then N² times else 0 times 
Line 6 - if condition at line 4 is satisfied then N² times else 0 times
Line 7 - if condition at line 4 is satisfied then N² times else 0 times
Line 8 - N²
Line 9 - N²
Line 10 - N
```

Worst Case of this Algorithm is when all the lines gets executed maximum times and best case is when minimum lines gets executed minimum times.

```
Worst Case : 7N² + 2N + 1
Best Case : 4N² + 2N + 1
General term : aN² + bN + c
```

Here N² is the fastest growing term and decides if algorithm is good or bad. So complexity comes out to be O(N²) 

#### Phone Book Example 

Mostly numbers in phone book are stored by last name, first name. Everyone of us once in a lifetime has searched a number from phone book for sure. While doing that very few on us knew that we use Binary search. How does this work?
* In binary search we pick up a middle element and compare it with the element we have to search.
* We have 3 possible cases now, 
   * Search element matches with middle element
   * Search element is smaller then middle element
   * Search element is greater then middle element
* If search element matches, we break else we pick up either left collection or right collection based on the condition above
* Again we find middle element in new collection and repeat the steps

How many comparisons we need for this?
* If we have 3 elements we need 2 comparisons at max
* If we have 7 elements we need 3 comparisons at max and so on
	
Here, complexity is logarithmic. i.e O(logN)

Worst Case of this Algorithm is when we have to traverse through all the elements and best case is when we get the element in first go.

```
Worst Case : O(logN)
Best Case : O(1)
```

#### Traveling Salesman Example 

This is quiet famous example in programming. In this problem you have N towns. 
Each of those towns is linked to 1 or more other towns by a road of a certain distance. 
The traveling Salesman problem is to find the shortest tour that visits every town. 

Say we have 3 towns A, B and C. Below is the possible combination

```
1. A -> B -> C
2. A -> C -> B
3. B -> A -> C
4. B -> C -> A
5. C -> A -> B
6. C -> B -> A
```

We will count them as 6 but in Actual there are only 3 possibilities since 1 is same as 6, 2 is same as 4 and 3 is same as 5 just the route is opposite but same distance.
This number increase to 12 when there are 4 towns and number becomes 120 when 5 towns.
There is a pattern in this, 

```
3! = 3 * 2 * 1 = 6
4! = 4 * 3 * 2 * 1 = 24
5! = 5 * 4 * 3 * 2 * 1 = 120 and so on
```  

Here, complexity is factorial. i.e O(N!)

Worst Case of this Algorithm is when we have to traverse through all the possible combinations and best case is when we have only one combination available.

```
Worst Case : O(N!)
Best Case : O(1)
``` 


### Summary

* Type of Complexity are as follows, 
	* Linear
	* Quadratic
	* Logarithmic
	* Factorial
	
* Points to consider for Time Complexity
	* Operations
	* Comparisons
	* Loops
	* Pointer references
	* Function calls to outside
	
* Points to consider for Space Complexity
	* Variables
	* Data Structures
	* Allocations
	* Function Calls


### Quick facts about calculation

<b>Time Complexity<b>

	* If you have just 1 for loop, then time complexity is O(N).
	* If you have 1 for loop inside another for loop, then it is O(N squared).
	* If you have 1 for loop inside another for loop, which is inside yet another for loop, then it is O(N cubed).
	* If you are using something like binary search or binary tree, then time complexity is O(log N), this is because you are cutting your domain by half each time, so it is log N base 2.
	* If you have a for loop which loops all N elements and inside it is another for loop but only loops till K elements each time, then time complexity is O(K*N)
	* If you have some elements and combination is required then it is O(N factorial) complexity

<b>Space Complexity</b>

	* If you just use the array of N elements you have without using more space then space complexity is either O (1) or O (log N)
	* If you use a Copy of the array of N elements, i.e. using more space then space complexity is O (N)
	
### Complexity for Sorting Algorithms

```
**************************************************************************************************
| 	Algorithm 	|						Time Complexity 				  |   Space Complexity   |
**************************************************************************************************
|				|		Best		 |		Average		|		Worst	  |		   Worst		 |
**************************************************************************************************
| Quicksort		|	O(n log(n))		 |	O(n log(n))		|	O(n^2)	  	  |	    O(log(n))		 |
--------------------------------------------------------------------------------------------------
| Mergesort		|	O(n log(n))		 |	O(n log(n))		|	O(n log(n))	  |		O(n)		 	 |
--------------------------------------------------------------------------------------------------
| Timsort		|	O(n)		 	 |	O(n log(n))		|	O(n log(n))	  |		O(n)		 	 |
--------------------------------------------------------------------------------------------------
| Heapsort		|	O(n log(n))		 |	O(n log(n))		|	O(n log(n))	  |		O(1)		 	 |
--------------------------------------------------------------------------------------------------
| Bubble Sort	|	O(n)		     |	O(n^2)			|	O(n^2)	  	  |		O(1)		 	 |
--------------------------------------------------------------------------------------------------
| Insertion Sort|	O(n)		 	 |	O(n^2)			|	O(n^2)	      |		O(1)		 	 |
--------------------------------------------------------------------------------------------------
| Selection Sort|	O(n^2)		 	 |	O(n^2)			|	O(n^2)	      |		O(1)		 	 |
--------------------------------------------------------------------------------------------------
| Shell Sort	|	O(n)		 	 |	O((nlog(n))^2)	|	O((nlog(n))^2)|		O(1)		 	 |
--------------------------------------------------------------------------------------------------
| Bucket Sort	|	O(n+k)		 	 |	O(n+k)			|	O(n^2)	      |		O(n)		 	 |
--------------------------------------------------------------------------------------------------
| Radix Sort	|	O(nk)		 	 |	O(nk)			|	O(nk)	      |		O(n+k)		 	 |
--------------------------------------------------------------------------------------------------
```
Reference : [Complexity Cheat Sheet](http://bigocheatsheet.com/)