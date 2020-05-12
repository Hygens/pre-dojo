PROBLEM
========
Given the following log of a first person shooter:

23/04/2013 15:34:22 - New match 11348965 has started
23/04/2013 15:36:04 - Roman killed Nick using M16
23/04/2013 15:36:33 - <WORLD> killed Nick by DROWN
23/04/2013 15:39:22 - Match 11348965 has ended

Write a code for
-----------------------
* Set up the ranking of each match, with the number of murders and the number of deaths of each player;

Comments:
* Murders carried out by the <WORLD> player must be disregarded.


Bonus
(Not required. Do it only if you identify with the problem or if you think there is something interesting to be shown in the solution)
-----
* Discover the winner's favorite weapon (the one that killed the most);
* Identify the largest sequence of murders carried out by a player (streak) without dying, within the game;
* Players who win a match without dying must win an "award";
* Players who kill 5 times in 1 minute must win an "award".


SOLUTION
=======
* Be creative;
* Make the most of object orientation;
* Create unit tests and try to use TDD;
* It is not necessary to use any framework, but it is up to you;
