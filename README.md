# C-SCAN Analysis

Repository for versioning code used in the Operating Systems course report on the C-SCAN algorithm.
It is possible to provide the following disk characteristics as parameters:

- Sector size
- Number of tracks
- Number of sectors per track
- Transfer rate
- Seek time
- Rotation time
- Initial sector

Click [here](https://docs.google.com/document/d/1yB46UXTxB3JjAze1ii0SP1VVJovRRW1g5hddzQgeCr4/edit?usp=sharing) to access the report.

# Implementation

The algorithm was implemented in Java, following object-oriented concepts and using data structure libraries of the language such as `java.util.ArrayList`.
It uses a right-hand pattern, searching the sectors by moving from left to right.

For comparisons between random and linear requests and more details about the functioning of a disk and the algorithm, access the project report.

# Usage

To run the algorithm, access the class `./src/cscan/RunCSCAN.java`, modify the disk parameters and the random request draw to your liking, and then execute the
`main` function.

The algorithm can support up to a range of 14000 sectors requested at the same time. To test, modify the parameters of the random request draw in the `RunCSCAN` class
(not recommended, use smaller values).

> If the execution gets stuck in an infinite loop, most likely the parameter values provided are not correct or the user wanted to venture with more requests than allowed.

## Formatted Output

The output in the terminal follows the model shown below, displaying the drawn requests, the order of access to each sector based on the disk parameters, the initial head position
and the total time in milliseconds of the entire request.

```
Requests:
[7, 35, 1, 22, 19, 7, 16, 30, 1, 7, 3, 26, 14, 18, 33, 24, 15, 29, 25, 30]

Accessed sectors:
[33, 35, 24, 25, 26, 29, 30, 30, 7, 7, 7, 1, 1, 3, 15, 16, 18, 19, 22, 14]
Initial head position: 31
13.95 ms
```

# For the Students

This work received a grade of 9.0 out of 10.0. You may use the algorithm and the document as a model for your reports, but, of course, "just don't copy it exactly". A tip is to change the language, don't use Java,
use a simpler scripting language like Python. Regarding the graphs, feel free to choose between a graph plotting library of your favorite language or use Google Sheets tables as I did, they are very customizable and easy to use.
