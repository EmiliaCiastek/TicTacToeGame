## Requirements

|  Requirements | Date  | Comments |
|  ----- | -------------   | ------------- |
| It is "best of three", though I can quit mid-way through. | |
| Characters: O (naught) and X (cross) | |
| Players have names and scores. | |
| Winner has better score. Draw is possible. | |
| it should accept players instructions about each move | |
| it should ask who begins | |
| it informs about session result, who’s turn it is now and the like | |
| Match gives points: win 3, draw 1, loss 0. 3 matches == game. | |
| Game works with square or rectangular board. | |
| Player wins, if he has unbroken line of his characters, in a row, in a column or diagonally. | |
| Winning is announced in a message: Wygrywa O. O: 1 X: 0 (numbers are current points). | |
| Board dimensions: 3x3, 4x4, 99x101, etc. (user provides) | |
| Winning condition has variable number of characters: 3, 4, 5, etc. (user provides) | |
| Game messages should have configurable target: console (System.out) or logs (for the sake of this exercise it’s OK to make it System.err), or external printer. | |
| before game starts it asks who goes first, O or X | |
| We are bi-lingual: Polish and English are fine. In future we want to add more languages: messages are to be read from a file for chosen language. Choosing the language depends on configuration variable. | |
#

|  Non-Functional Requirements | Date  | Comments |
|  ----- | -------------   | ------------- |
| It must work (it it doesn’t, it’s disqualified): if I cannot play, it doesn't work.| | |
| 60% unit test code coverage. | |
| Functions in accordance with functional requirements. | |
| Code quality – non-OO code is tolerated in little amounts. | |
| Project mantra followed (Git, Maven, test cases, etc.). | |
| Console UI, no graphics (though see extra reqs) | |
| Hot-seat game, no network (though see extra reqs) | |
| Both players are human (though see extra reqs) | |
| only Java API (JDK8, SE) and TestNG | |