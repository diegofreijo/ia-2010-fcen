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
pais(espa�a).
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
clausula1(Policia,Lugar,Ladron,Pais):-Pais = alemania,Lugar = bar,animal(Ladron);Pais \= alemania,Lugar \= bar.
%2_ Hur�n no us� el barco que lleg� a Inglaterra
clausula2(Policia,Lugar,Ladron,Pais):-Lugar = barco,Pais = inglaterra,Ladron \= huron;Lugar \= barco,Pais \= inglaterra.
%3_ Quien fue detenido en el tren no estaba en Espa�a ni en Austria.
clausula3(Policia,Lugar,Ladron,Pais):-Lugar = tren,Pais \= espa�a,Pais \= austria;Pais = austria,Lugar \= tren;Pais = espa�a,Lugar \=tren;Lugar \= tren,Pais \= espa�a,Pais \= austria.
%4_ Dodero atrap� al Rata en Espa�a.
clausula4(Policia,Lugar,Ladron,Pais):-Policia = dodero,Ladron = rata,Pais = espa�a;Policia \= dodero,Ladron \= rata,Pais \= espa�a.
%5_ Ni el ladr�n que fue atrapado por Elkin ni Dedos han estado en Alemania o Austria. Ninguno de estos dos arrestos se realiz� en un avi�n.
clausula5(Policia,Lugar,Ladron,Pais):-Policia = elkin,Ladron \= dedos,Lugar \= avion,Pais \= alemania,Pais \= austria;Ladron = dedos,Policia \= elkin,Lugar \= avion,Pais \= alemania,Pais \= austria;Policia \= elkin,Ladron \= dedos.
%6_ Sombra fue atrapado al salir de un cine pero no por Kesner o Frigerio.
clausula6(Policia,Lugar,Ladron,Pais):-Lugar = cine,Ladron = sombra,Policia \= kesner,Policia \= frigerio;Ladron \= sombra.
%7_ Dodero, Elkin y Frigerio apresaron sendos ladrones al bajar de un transporte. En cambio, el Gato y Sombra fueron atrapados en lugares de esparcimiento.
clausula7(Policia,Lugar,Ladron,Pais):-Policia = dodero,transporte(Lugar),Ladron \= gato,Ladron \= sombra;Policia = elkin,transporte(Lugar),Ladron \= gato,Ladron \= sombra;Policia = frigerio,transporte(Lugar),Ladron \= gato,Ladron \= sombra;Ladron = gato,esparcimiento(Lugar),Policia \= dodero,Policia \= elkin,Policia \= frigerio;Ladron = sombra,esparcimiento(Lugar),Policia \= dodero,Policia \= elkin,Policia \= frigerio.

% arresto(Policia,Lugar,Ladron,Pais):-policia(Policia),lugar(Lugar),ladron(Ladron),pais(Pais),clausula1(Policia,Lugar,Ladron,Pais),clausula2(Policia,Lugar,Ladron,Pais),clausula3(Policia,Lugar,Ladron,Pais),clausula4(Policia,Lugar,Ladron,Pais),clausula5(Policia,Lugar,Ladron,Pais).

arresto(Policia,Lugar,Ladron,Pais):-policia(Policia),lugar(Lugar),ladron(Ladron),pais(Pais),clausula1(Policia,Lugar,Ladron,Pais),clausula2(Policia,Lugar,Ladron,Pais),clausula3(Policia,Lugar,Ladron,Pais),clausula4(Policia,Lugar,Ladron,Pais),clausula5(Policia,Lugar,Ladron,Pais),clausula6(Policia,Lugar,Ladron,Pais),clausula7(Policia,Lugar,Ladron,Pais).







