% UBA - DC - IA - 1C 2010
% TP2 ejercicio1
%
% Pablo Carbajo
% Diego Freijo
% Ignacio Iacobacci


policia(dodero).
policia(elkin).
policia(frigerio).
policia(kesner).
policia(minari).

lugar(avion).
lugar(bar).
lugar(barco).
lugar(cine).
lugar(tren).

ladron(gato).
ladron(dedos).
ladron(huron).
ladron(rata).
ladron(sombra).

pais(alemania).
pais(austria).
pais(españa).
pais(francia).
pais(inglaterra).

animal(gato).
animal(huron).
animal(rata).

transporte(avion).
transporte(barco).
transporte(tren).

esparcimiento(X):-lugar(X),not(transporte(X)).

%1_ Uno de los ladrones que tiene como alias el nombre de un animal fue atrapado en un bar de Alemania.
clausula1(Policia,Lugar,Ladron,Pais) :- 
  Pais = alemania,Lugar = bar,animal(Ladron);
  Pais \= alemania,Lugar \= bar.

%2_ Hurón no usó el barco que llegó a Inglaterra
clausula2(Policia,Lugar,Ladron,Pais) :-
  Lugar = barco, Pais = inglaterra, Ladron \= huron;
  Lugar \= barco, Pais \= inglaterra.

%3_ Quien fue detenido en el tren no estaba en España ni en Austria.
clausula3(Policia,Lugar,Ladron,Pais) :-
 Lugar = tren,Pais \= españa,Pais \= austria;
 Pais = austria,Lugar \= tren;
 Pais = españa,Lugar \=tren;
 Lugar \= tren,Pais \= españa,Pais \= austria.

%4_ Dodero atrapó al Rata en España.
clausula4(Policia,Lugar,Ladron,Pais) :-
  Policia = dodero,Ladron = rata,Pais = españa;
  Policia \= dodero,Ladron \= rata,Pais \= españa.

%5_ Ni el ladrón que fue atrapado por Elkin ni Dedos han estado en Alemania o Austria.
%   Ninguno de estos dos arrestos se realizó en un avión.
clausula5(Policia,Lugar,Ladron,Pais):-
  Policia = elkin,Ladron \= dedos,Lugar \= avion,Pais \= alemania,Pais \= austria;
  Ladron = dedos,Policia \= elkin,Lugar \= avion,Pais \= alemania,Pais \= austria;
  Policia \= elkin,Ladron \= dedos.

%6_ Sombra fue atrapado al salir de un cine pero no por Kesner o Frigerio.
clausula6(Policia,Lugar,Ladron,Pais):-
  Lugar = cine,Ladron = sombra,Policia \= kesner,Policia \= frigerio;
  Ladron \= sombra.

%7_ Dodero, Elkin y Frigerio apresaron sendos ladrones al bajar de un transporte.
%  En cambio, el Gato y Sombra fueron atrapados en lugares de esparcimiento.
clausula7(Policia,Lugar,Ladron,Pais) :-
  Policia = dodero,transporte(Lugar),Ladron \= gato,Ladron \= sombra;
  Policia = elkin,transporte(Lugar),Ladron \= gato,Ladron \= sombra;
  Policia = frigerio,transporte(Lugar),Ladron \= gato,Ladron \= sombra;
  Ladron = gato,esparcimiento(Lugar),Policia \= dodero,Policia \= elkin,Policia \= frigerio;
  Ladron = sombra,esparcimiento(Lugar),Policia \= dodero,Policia \= elkin,Policia \= frigerio.

arresto(Policia,Lugar,Ladron,Pais) :-
  policia(Policia),lugar(Lugar),ladron(Ladron),pais(Pais),
  clausula1(Policia,Lugar,Ladron,Pais),
  clausula2(Policia,Lugar,Ladron,Pais),
  clausula3(Policia,Lugar,Ladron,Pais),
  clausula4(Policia,Lugar,Ladron,Pais),
  clausula5(Policia,Lugar,Ladron,Pais),
  clausula6(Policia,Lugar,Ladron,Pais),
  clausula7(Policia,Lugar,Ladron,Pais).


% esto encuentra 5 arrestos que tengan todo distinto, implementando el axioma de mundo cerrado.
% (y la idea de que no pueden repetirse cosas: si dodero atrapo a rata, nadie mas atrapo a rata,
%  y dodero no atrapo a ningun otro ademas de rata)
arrestos( A, B, C, D, R1, R2, R3, R4, 5 ) :- R1 = A, R2 = B, R3 = C, R4 = D.
arrestos( PoL,LuL,LaL,PaL,R1,R2,R3,R4, C ) :-
  arresto(Po,Lu,La,Pa),
  not( member( Po, PoL ) ), not( member( Lu, LuL ) ), not( member( La, LaL ) ), not( member( Pa, PaL ) ),
  D is C+1,
  arrestos( [Po|PoL],[Lu|LuL],[La|LaL],[Pa|PaL], R1,R2,R3,R4, D ),
  !.   % el cut este es para evitar las permutaciones


% para usar, copiar lo siguiente: 
% arrestos( [],[],[],[], Policias, Lugares, Ladrones, Paises, 0 ).


% retorna algo asi:
% Policias = [minari, kesner, frigerio, elkin, dodero],
% Lugares = [cine, bar, barco, tren, avion],
% Ladrones = [sombra, gato, dedos, huron, rata],
% Paises = [austria, alemania, inglaterra, francia, españa].
%
% Lo cual es correcto, si se interpreta como que dodero atrapo a rata en un avion en espana,
% elkin atrapo a huron en un tren de francia, y etc. hasta minari-cine-sombra-austria.
% ademas, funciona instantaneamente!

