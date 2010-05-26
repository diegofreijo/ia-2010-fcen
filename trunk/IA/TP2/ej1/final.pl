%Aun no anda!
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
clausula1(Policia,Lugar,Ladron,Pais):-Pais = alemania,Lugar = bar,animal(Ladron).
%2_ Hurón no usó el barco que llegó a Inglaterra.
clausula2(Policia,Lugar,Ladron,Pais):-Lugar = barco,Pais = inglaterra,not(Ladron = huron).
%3_ Quien fue detenido en el tren no estaba en España ni en Austria.
clausula3(Policia,Lugar,Ladron,Pais):-clausula3_1(Policia,Lugar,Ladron,Pais),clausula3_2(Policia,Lugar,Ladron,Pais).
clausula3_1(Policia,Lugar,Ladron,Pais):-Lugar = tren,not(Pais = españa).
clausula3_2(Policia,Lugar,Ladron,Pais):-Lugar = tren,not(Pais = austria).
%4_ Dodero atrapó al Rata en España.
clausula4(Policia,Lugar,Ladron,Pais):-Policia = dodero,Ladron = rata,Pais = espana.
%5_ Ni el ladrón que fue atrapado por Elkin ni Dedos han estado en Alemania o Austria. Ninguno de estos dos arrestos se realizó en un avión.
clausula5(Policia,Lugar,Ladron,Pais):-clausula5_1(Policia,Lugar,Ladron,Pais),clausula5_2(Policia,Lugar,Ladron,Pais),clausula5_3(Policia,Lugar,Ladron,Pais),clausula5_4(Policia,Lugar,Ladron,Pais).
clausula5_1(Policia,Lugar,Ladron,Pais):-Policia = elkin,not(Ladron = dedos),not(Pais = alemania),not(Lugar = avion).
clausula5_2(Policia,Lugar,Ladron,Pais):-Ladron = dedos,not(Policia = elkin),not(Pais = alemania),not(Lugar = avion).
clausula5_3(Policia,Lugar,Ladron,Pais):-Policia = elkin,not(Ladron = dedos),not(Pais = austria),not(Lugar = avion).
clausula5_4(Policia,Lugar,Ladron,Pais):-Ladron = dedos,not(Policia = elkin),not(Pais = austria),not(Lugar = avion).
%6_ Sombra fue atrapado al salir de un cine pero no por Kesner o Frigerio.
clausula6(Policia,Lugar,Ladron,Pais):-clausula6_1(Policia,Lugar,Ladron,Pais),clausula6_2(Policia,Lugar,Ladron,Pais).
clausula6_1(Policia,Lugar,Ladron,Pais):-Lugar = cine,Ladron = sombra,not(Policia = kesner).
clausula6_2(Policia,Lugar,Ladron,Pais):-Lugar = cine,Ladron = sombra,not(Policia = frigerio).
%7_ Dodero, Elkin y Frigerio apresaron sendos ladrones al bajar de un transporte. En cambio, el Gato y Sombra fueron atrapados en lugares de esparcimiento.
clausula7(Policia,Lugar,Ladron,Pais):-clausula7_1(Policia,Lugar,Ladron,Pais),clausula7_2(Policia,Lugar,Ladron,Pais),clausula7_3(Policia,Lugar,Ladron,Pais),clausula7_4(Policia,Lugar,Ladron,Pais),clausula7_5(Policia,Lugar,Ladron,Pais).
clausula7_1(Policia,Lugar,Ladron,Pais):-Policia = dodero,transporte(Lugar).
clausula7_2(Policia,Lugar,Ladron,Pais):-Policia = elkin,transporte(Lugar).
clausula7_3(Policia,Lugar,Ladron,Pais):-Policia = frigerio,transporte(Lugar).
clausula7_4(Policia,Lugar,Ladron,Pais):-Ladron = gato,esparcimiento(Lugar).
clausula7_5(Policia,Lugar,Ladron,Pais):-Ladron = sombra,esparcimiento(Lugar).



%Arresto
%
arresto(Policia,Lugar,Ladron,Pais):-policia(Policia),lugar(Lugar),ladron(Ladron),pais(Pais),clausula1(Policia,Lugar,Ladron,Pais),clausula2(Policia,Lugar,Ladron,Pais),clausula3(Policia,Lugar,Ladron,Pais),clausula4(Policia,Lugar,Ladron,Pais),clausula5(Policia,Lugar,Ladron,Pais),clausula6(Policia,Lugar,Ladron,Pais),clausula7(Policia,Lugar,Ladron,Pais).









