
# Sam-and-substrings

HackerRank>Practice>Algorithms>Dynamic Programming>Sam and substrings

https://www.hackerrank.com/challenges/sam-and-substrings/problem

The code has to be very optimizied, otherwise the test cases with large input will time out.
Thus, taking the most obvious solution by composing all possible substrings and summing up their value will result in time out.

However, there is a nice mathematical shortcut that solves the problem within the strict time frames, stipulated by this challenge.
The sum of a digit, part of a string of digits, that is contained in all possible substrings, could be obtained as follows:

(number of preceding digits) 

multiplied by

(value of the digit) 

multiplied by

(sum of all members of a geometric progression, where: 
first memeber=1, multiplier=10, total members = 'number of digits, from the current digit (inclusive) to the end digit (inclusive) in the string')

Example: 

Number: xxxx8zzzzzz

Current Digit: 8.

Preceding Digits: x, total number = 4.

Following Digits: z, total number = 6, including the current digit '8', total number = 6+1;

Expression for current digit '8': 


4 

multiplied by

8

multiplied by 

the formula for the sum of all members of a geometric porgression: 

first memeber * (Math.pow(multiplier, total members) - 1) / (multiplier-1);

Thus, for digit '8' in xxxx8zzzzzz, the total is: 4 * 8 * 1 * (Math.pow(10, (6+1))-1) / (10-1);

Since the result has to be presented as modulo (Math.pow(10,9)+7), we should structure 
the code in such a way that at every interation through the input, by applying the modulo, 
we avoid the processing of large numbers that could result from Math.pow(muliplier, total members) 
that is part of this version of the formula.

The sum of all members of a geomeric progression, could also be expressed as follows:

(first member) + (value of sum for the previous members) * multiplier. 

In this way, we could apply modulo (Math.pow(10,9)+7) at every iteration and thus avoid the processing 
of the large numbers from the first version of the formula.

Example: sum of all members in this geometric progression with
first memeber=1, multiplier=10, where each iteration represents the sum 
of all the members up to the current iteration (inclusive):

first iteration:          1 % modulo

second iteration:         (1+1*10) % modulo

third iteration:          (1+(1+1*10)*10) % modulo

fourth iteration:         (1+ (1+(1+1*10)*10)*10) % modulo

etc.

So, to summarize it for the example with xxxx8zzzzzz:

4 * 8 * (seventh iteration)
