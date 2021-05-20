# CA2QA

## Sprint Backlog

Tasks - Story Points

1. Create a Rubric - 2
1. Add a criterion to a Rubric - 5
1. Get a list of all Rubrics - 1
1. Get a specific Rubric by name - 2
1. Creating a new StudentGrade - 8
1. Adding a score for a particular criterion to a grade - 8
1. Getting all StudentGrades associated with a specific Rubric - 3
1. Provide summary calculations across all graded students, including the average, standard deviation,  minimum and maximum score for a Rubric - 13
1. Provide the average, standard deviation, minimum and maximum score for a specific criterion of a Rubric - 13

----

Sprint 1 : Tasks 1, 2, 3, 4, 5, 6 & 7 - 27 points                                                                      
Sprint 2 : Tasks 8 & 9 - 26 points

## Estimates Calculation

Choosing the estimates for this project is determined based on how tough each tasks is to do by comparing one to another and deciding the easiest and the hardests tasks.
For example, task 3 is much simpler than task 9.

## Velocity Metric

To calclate the Velocity metric, simply add up the total of story points completed from each sprint, then divide by the number of sprints.
If you completed 96 story points in 3 sprints, your average sprint velocity is 96 ÷ 3 = 32. You can now base the amount of work to be done in future sprints on the average of
32 story points.

## TDD

TDD or Test Driven Deployment is the process of writing test cases for the code before you write the actual code, and tracking all software development by repeatedly testing
the software against all test cases.

For example, task 1 - Create a Rubric will have multiple test cases, but one of them would be;
When a user attempts to add a new Rubric the Rubrics name is checked to see if it exists already

## Code Coverage

Jacoco is a code coverage reports generator for Java projects. To run the tool we just need to run the tests in the project and it generates a coverage report in binary
format in the target directory – *target/jacoco.exec.*

The tool helps identify gaps in test coverage checking all the lines of code from the method you are testing to check if all use cases are tested. When you close a gap the
test cover will increase on the percentage bar displayed.

## Team Version Control

Version control is the process within software development where there is a tracking and managing of changes to a code base. This is done with the use of source control tools
such as Git and GitFlow. A developer would use these control systems to create branches to put code changes into and merge them together to create a master copy of the work.
Within GitFlow there are many branch naming conventions such as master, develop, feature and release, these branches were all used in this project.

## Code Review

When performing a code review the reviewer should have a checklist of things to check before accepting this request to merge the new code. A list of items I would look out for
is, tests being created for the new code, updates to existing tests where necessary, no leftover commented out code that isn't necessary, clean code done through
'best practices' and appropriate comments about what the new commit contains.
