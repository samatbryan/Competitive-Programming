/*Let x, y, and z be strings. We want to know if z can be obtained only from x and y by interleaving
the characters from x and y such that the characters in x appear in order and the characters in
y appear in order. For example, if x = efficient and y = ALGORITHM, then it is true for
z = effALGiORciIenTHMt, but false for z = efficientALGORITHMS (extra characters), z =
effALGORITHMicien (missing the final t), and z = effOALGRicieITHMnt (out of order). How
can we answer this query efficiently? Your answer must be able to efficiently deal with strings with
lots of overlap, such as x = aaaaaaaaaab and y = aaaaaaaac.

*
