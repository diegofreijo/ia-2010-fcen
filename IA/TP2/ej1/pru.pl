%listaUnoN(+long,-lista)
listaUnoN(0,[]).
listaUnoN(X,Y):-
	X>0,
	X1 is X-1,
	listaUnoN(X1,Y1),
	append(Y1,[X],Y).
	
%torreHanoi(+init,+fin,-pasos)
torreHanoi(XS,XS,[]).
%Desde torre 1
torreHanoi([[X|XS],[],Z],F,P):-torreHanoi([XS,[X],Z],F,PS),append(PS,[[X|XS],[],Z],P).
torreHanoi([[X|XS],Y,[]],F,P):-torreHanoi([XS,Y,[X]],F,PS),append(PS,[[X|XS],Y,[]],P).
torreHanoi([[X|XS],[Y|YS],Z],F,P):-X < Y,
		append([X],[Y|YS],YSS),
		torreHanoi([XS,YSS,Z],F,PS),
		not(member([[X|XS],[Y|YS],Z],PS)),
		append([[X|XS],[Y|YS],Z],PS,P).
torreHanoi([[X|XS],Y,[Z|ZS]],F,P):-X < Z,
		append([X],[Z|ZS],ZSS),
		torreHanoi([XS,Y,ZSS],F,PS),
		not(member([[X|XS],Y,[Z|ZS]],PS)),
		append([[X|XS],Y,[Z|ZS]],PS,P).
%Desde torre 2
torreHanoi([[],[Y|YS],Z],F,P):-torreHanoi([[Y],YS,Z],F,PS),append(PS,[[],[Y|YS],Z],P).
torreHanoi([X,[Y|YS],[]],F,P):-torreHanoi([X,YS,[Y]],F,PS),append(PS,[X,[Y|YS],[]],P).
torreHanoi([[X|XS],[Y|YS],Z],F,P):-Y < X,
		append([Y],[X|XS],XSS),
		torreHanoi([XSS,YS,Z],F,PS),
		not(member([[X|XS],[Y|YS],Z],PS)),
		append([[X|XS],[Y|YS],Z],PS,P).
torreHanoi([X,[Y|YS],[Z|ZS]],F,P):-Y < Z,
		append([Y],[Z|ZS],ZSS),
		torreHanoi([X,YS,ZSS],F,PS),
		not(member([[X|XS],[Y|YS],Z],PS)),
		append([[X|XS],[Y|YS],PS,Z],P).
%Desde torre 3
torreHanoi([[],Y,[Z|ZS]],F,P):-torreHanoi([[Z],Y,ZS],F,PS),append(PS,[[],Y,[Z|ZS]],P).
torreHanoi([X,[],[Z|ZS]],F,P):-torreHanoi([X,[Z],ZS],F,PS),append(PS,[X,[],[Z|ZS]],P).
torreHanoi([[X|XS],Y,[Z|ZS]],F,P):-Z < X,
		append([Z],[X|XS],XSS),
		torreHanoi([XSS,Y,ZS],F,PS),
		not(member([[X|XS],Y,[Z|ZS]],PS)),
		append([[X|XS],Y,[Z|ZS]],PS,P).
torreHanoi([X,[Y|YS],[Z|ZS]],F,P):-Z < Y,
		append([Z],[Y|YS],YSS),
		torreHanoi([X,YSS,ZS],F,PS),
		not(member([X,[Y|YS],[Z|ZS]],PS)),
		append([X,[Y|YS],PS,[Z|ZS]],P).
