/*
Paul Winter 409827 
Daniel Toups 412364
*/

blau(sonnalm).
blau(arbiskogel).
blau(plattenalm).
blau(vorkogel).
blau(wiesenalm).

rot(isskogel).

schwarz(teufeltal).

start(sonnalm).
start(teufeltal).

endetIn(sonnalm,arbiskogel).
endetIn(arbiskogel,plattenalm).
endetIn(plattenalm,wiesenalm).
endetIn(wiesenalm,tal).

endetIn(sonnalm,vorkogel).
endetIn(vorkogel,isskogel).
endetIn(isskogel,tal).
endetIn(teufeltal,wiesenalm).

gleicherStartpunkt(X,Y) :- endetIn(Z,Y) , endetIn(Z,X).
erreichbar(X,Y) :- endetIn(X,Y); endetIn(X,S), erreichbar(S,Y).
moeglicheSchlusspiste(X,S) :-endetIn(S,tal) , erreichbar(X,S).
treffpisten(X,Y,T) :-  erreichbar(X,T) , erreichbar(Y,T), (T \= tal).
anfaengerGeeignet(X) :- endetIn(X,tal) , blau(X) ; blau(X) , endetIn(X,Y) , anfaengerGeeignet(Y).







pathOfLength(cons(tal,nil),0).
pathOfLength(cons(P,cons(Y,Rest)) , s(X)) :- endetIn(P,Y) ,pathOfLength(cons(Y,Rest),X).


anhaengen(nil,Ys,Ys).
anhaengen(cons(X,XS) , Ys , cons(X,Res)):- append(XS,Ys,Res).

add(X,0,X).
add(X , s(Y) , s(Z)) :- add(X,Y,Z).

tourofLength(cons(tal,nil),0).
/*
tourofLength(T,L) :- tourofLength(append(),add()).
*/

convert(nil , []).
convert(cons(X,nil) , [X]).
convert(cons(X, cons(Y,Z)) , [X|XS]) :-convert(cons(Y,Z) , [XS]).