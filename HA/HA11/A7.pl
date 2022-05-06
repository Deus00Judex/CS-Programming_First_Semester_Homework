multiples(X,1,[A,B|Rest]):- [X].
multiples(1,X,[A,B|Rest]):- [X|multiples(1,-(X,1))]
multiples(X,N,[A,B|Rest]):- is/2(X) ; >/2(X) , is/2(N) ; >/2(N) , 