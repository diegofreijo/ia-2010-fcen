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
% arresto(Policia,Lugar,Ladron,Pais):-policia(Policia),lugar(Lugar),ladron(Ladron),pais(Pais).
% falta decir que los arrestos son disjuntos
%1_ Uno de los ladrones que tiene como alias el nombre de un animal fue atrapado en un bar de Alemania.
arresto(Policia,Lugar,Ladron,Pais):-Pais = alemania,animal(Ladron),policia(Policia),lugar(Lugar),ladron(Ladron).
%2_ Hur�n no us� el barco que lleg� a Inglaterra.
arresto(Policia,Lugar,Ladron,Pais):-Lugar = barco,Pais = inglaterra, policia(Policia),ladron(Ladron).
arresto(Policia,Lugar,Ladron,Pais):-Ladron = huron,policia(Policia),ladron(Ladron),pais(Pais),not(Lugar = barco).
arresto(Policia,Lugar,Ladron,Pais):-Ladron = huron,policia(Policia),ladron(Ladron),lugar(Lugar),not(Pais = inglaterra).
%3_ Quien fue detenido en el tren no estaba en Espa�a ni en Austria.
arresto(Policia,Lugar,Ladron,Pais):-Lugar = tren,policia(Policia),ladron(Ladron),not(Pais = espa�a).
arresto(Policia,Lugar,Ladron,Pais):-Lugar = tren,policia(Policia),ladron(Ladron),not(Pais = austria).
%4_ Dodero atrap� al Rata en Espa�a.
arresto(Policia,Lugar,Ladron,Pais):-Policia = dodero,Ladron = rata,Pais = espa�a,lugar(Lugar).
%5_ Ni el ladr�n que fue atrapado por Elkin ni Dedos han estado en Alemania o Austria. Ninguno de estos dos arrestos se realiz� en un avi�n.
arresto(Policia,Lugar,Ladron,Pais):-Policia = elkin,ladron(Ladron),lugar(Lugar),pais(Pais),not(Ladron = dedos),not(Pais = alemania),not(Lugar = avion).
arresto(Policia,Lugar,Ladron,Pais):-Ladron = dedos,policia(Policia),lugar(Lugar),pais(Pais),not(Policia = elkin),not(Pais = alemania),not(Lugar = avion).
arresto(Policia,Lugar,Ladron,Pais):-Policia = elkin,ladron(Ladron),lugar(Lugar),pais(Pais),not(Ladron = dedos),not(Pais = austria),not(Lugar = avion).
arresto(Policia,Lugar,Ladron,Pais):-Ladron = dedos,policia(Policia),lugar(Lugar),pais(Pais),not(Policia = elkin),not(Pais = austria),not(Lugar = avion).
%6_ Sombra fue atrapado al salir de un cine pero no por Kesner o Frigerio.
arresto(Policia,Lugar,Ladron,Pais):-Lugar = cine,Ladron = sombra,policia(Policia),pais(Pais).
arresto(Policia,Lugar,Ladron,Pais):-Ladron = sombra,policia(Policia),lugar(Lugar),pais(Pais),not(Policia = kesner).
arresto(Policia,Lugar,Ladron,Pais):-Ladron = sombra,policia(Policia),lugar(Lugar),pais(Pais),not(Policia = frigerio).
%7_ Dodero, Elkin y Frigerio apresaron sendos ladrones al bajar de un transporte. En cambio, el Gato y Sombra fueron atrapados en lugares de esparcimiento.
arresto(Policia,Lugar,Ladron,Pais):-Policia = dodero,transporte(Lugar),ladron(Ladron),pais(Pais).
arresto(Policia,Lugar,Ladron,Pais):-Policia = elkin,transporte(Lugar),ladron(Ladron),pais(Pais).
arresto(Policia,Lugar,Ladron,Pais):-Policia = frigerio,transporte(Lugar),ladron(Ladron),pais(Pais).
arresto(Policia,Lugar,Ladron,Pais):-Ladron = gato,esparcimiento(Lugar),policia(Policia),pais(Pais).
arresto(Policia,Lugar,Ladron,Pais):-Ladron = sombra,esparcimiento(Lugar),policia(Policia),pais(Pais).





