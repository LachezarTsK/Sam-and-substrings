
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
first memeber=1, multiplicant=10, total members = 'number of digits, from current digit (inclusive) to the end digit (inclusive) in the string')

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

Thus:  1 * (Math.pow(10, (6+1))-1) / (10-1);

This will optimize the code but it still will not be enough for some test cases with very large input
because Math.pow(muliplier, total members) could result in very large numbers. If the formula
for the sum of geometric progression is structured in this way, we still first have to obtain the value of
Math.pow(multiplier, total members) and only then reduce this value by modulo (Math.pow(10,9)+7).

Since the result has to be presented as modulo (Math.pow(10,9)+7), we should structure 
the code in such a way that at every interation through the input, by applying the modulo, 
we avoid the processing such large numbers. 

The sum of all members of a geomeric progression, with first memeber=1 and multiplier=10
will always result in a number, which is composed only of the digit '1', where the total number of '1s'
is equal to the total number of members in the geometric progression. Thus: 

total number of members in the geometric progression = 1, sum = 1;

total number of members in the geometric progression = 2, sum = 11;

total number of members in the geometric progression = 3, sum = 111;

total number of members in the geometric progression = 4, sum = 1111;

etc.

Having in mind this, we could structue the formula for the sum of all members in this geometric progression as follows:
1+(value of last member)*10. 

In this way we could apply modulo (Math.pow(10,9)+7) at every iteration and thus avoid the processing 
of the large numbers that could result from Math.pow(muliplier, total members).

Example, sum of all members in this geometric progression:

first iteration:          1 % modulo

second iteration:         (1+1*10) % modulo

third iteration:          (1+(1+1*10)*10) % modulo

fourth iteration:         (1+ (1+(1+1*10)*10)*10) % modulo

etc.

So, to summarize it for the example with xxxx8zzzzzz:

4 * 8 * (seventh iteration)






