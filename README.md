# Assignment 2: Insertion Sort Benchmark

## Project Overview
This project is part of Assignment 2: Algorithmic Analysis and Peer Code Review.  
The implementation focuses on **Insertion Sort**, optimized for nearly-sorted arrays.  
It includes performance tracking, unit tests, and a command-line interface for benchmarking.

## Features
- Optimized **Insertion Sort** algorithm.
- Tracks **comparisons, swaps, and execution time**.
- Supports arrays of different types:
  - Random
  - Sorted
  - Reverse
  - Nearly-sorted
- CLI benchmark runner to measure performance across different input sizes.
- Generates results in `benchmark_results.csv`.
- Comprehensive **unit tests** for edge cases (empty arrays, single elements, duplicates).

## Repository Structure
assignment2-insertion-sort/
├── src/main/java/
│ ├── algorithms/InsertionSort.java
│ ├── metrics/PerformanceTracker.java
│ └── cli/BenchmarkRunner.java
├── src/test/java/
│ └── algorithms/InsertionSortTest.java
├── docs/
│ ├── analysis-report.pdf
│ └── performance-plots/
├── README.md
├── benchmark_results.csv
└── pom.xml
