# scalac

Sorry about the code it's a bit messy, ot much time was put into it, about 2-4 hours a day.
I spent more time on visual board representation than on algorithm. I named it algorithm v0.1 
because it's my first idea and it's the simplest one.
Maximum number of columns is 18278 because there is only 3 places for letters and maximum rows is 999, for the same reason.
There are no tests yet because I'm short on time.

Sample result:
```
   |  a|  b|  c|  d|  e|  f|  g|
---+---+---+---+---+---+---+---+
  1| K | . | . | . | B | . | . |
---+---+---+---+---+---+---+---+
  2| . | . | Q | . | . | . | . |
---+---+---+---+---+---+---+---+
  3| K | . | . | . | . |   | . |
---+---+---+---+---+---+---+---+
  4| . | . | . | . | . | N | N |
---+---+---+---+---+---+---+---+
  5| . | Q | . | . | . | . | . |
---+---+---+---+---+---+---+---+
  6| . | . | . | R | . | . | . |
---+---+---+---+---+---+---+---+
  7| B | . | . | . | N |   |   |
---+---+---+---+---+---+---+---+

K - King
Q - Queen
B - Bishop
R - Rook
N - kNight
. - space occupied by at least one of the pieces
```