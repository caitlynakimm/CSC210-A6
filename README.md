# A8 Card Sorting

Your readme should include the following information. Each student needs to submit all of this information themselves, even when pair programming. 

## General Information
Programming Partner Name (if you'd like to be graded together):
- N/A

Other Collaborators (and kudos to helpful members of the class):
- N/A

Any references used besides JavaDoc and course materials:
- https://stackoverflow.com/questions/2102499/iterating-through-a-list-in-reverse-order-in-java

## Assignment Reflection

What did you notice about the differences in runtime across algorithms as you changed the number of cards you were sorting? If you had to split them into "slower" algorithms vs "faster" algorithms, which would you put in each category?
- After running each algorithm, I noticed as I increased the number of cards I was sorting, the ranking of the runtimes from slowest to fastest was the same: insertion sort, selection sort, quicksort, and merge sort.
- I would put selection sort and insertion sort into the "slower" algorithms category and merge sort and quicksort into the "faster" algorithms categeory.

Please reflect on your experience with this assignment. What was most challenging? What was most interesting?
- The most challenging thing for me was implementing the sort method for Quicksort. Implementing the recursion was simple, but I am still trying to understand how the recursive calls work and build on each other. Overall, I think it was really interesting to see how the different sorting algorithms begin (ex. starting with smallest/arbitrary card vs splitting all the cards into separate lists vs splitting cards into two partitions) and how the intermediate steps influenced how slow or fast the cards were sorted.