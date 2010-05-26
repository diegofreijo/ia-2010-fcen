arresto(Policia,Lugar,Ladron,Pais):-policiaLadron(Policia,Ladron),policiaLugar(Policia,Lugar),policiaPais(Policia,Pais),lugarLadron(Lugar,Ladron),lugarPais(Lugar,Pais),ladronPais(Ladron,Pais).
% falta decir que los arrestos son disjuntos
%1_ Uno de los ladrones que tiene como alias el nombre de un animal fue atrapado en un bar de Alemania.
lugarLadron(bar,gato).
lugarLadron(bar,huron).
lugarLadron(bar,rata).
lugarPais(bar,alemania).
ladronPais(gato,alemania).
ladronPais(huron,alemania).
ladronPais(rata,alemania).
%2_ Hurón no usó el barco que llegó a Inglaterra.
lugarLadron(barco,gato).
lugarLadron(barco,dedos).
lugarLadron(barco,rata).
lugarLadron(barco,sombra).
lugarPais(barco,inglaterra).
ladronPais(gato,inglaterra).
ladronPais(dedos,inglaterra).
ladronPais(rata,inglaterra).
ladronPais(sombra,inglaterra).
%3_ Quien fue detenido en el tren no estaba en España ni en Austria.
lugarPais(tren,alemania).
lugarPais(tren,inglaterra).
lugarPais(tren,francia).
%4_ Dodero atrapó al Rata en España.
policiaLadron(dodero,rata).
policiaPais(dodero,espana).
ladronPais(rata,espana).
5_ Ni el ladrón que fue atrapado por Elkin ni Dedos han estado  en Alemania o Austria. Ninguno de estos dos arrestos se realizó en un avión.
policiaPais(elkin,inglaterra).
policiaPais(elkin,francia).
policiaPais(elkin,espana).
ladronPais(dedos,inglaterra).
ladronPais(dedos,francia).
ladronPais(dedos,espana).
%6_ Sombra fue atrapado al salir de un cine pero no por Kesner o Frigerio.
policiaLugar(dodero,cine).
policiaLugar(elkin,cine).
policiaLugar(minari,cine).
policiaLadron(dodero,sombra).
policiaLadron(elkin,sombra).
policiaLadron(minari,sombra).
lugarLadron(cine,sombra).
%7_ Dodero, Elkin y Frigerio apresaron sendos ladrones al bajar de un transporte. En cambio, el Gato y Sombra fueron atrapados en lugares de esparcimiento.
policiaLugar(dodero,barco).
policiaLugar(dodero,tren).
policiaLugar(dodero,avion).
policiaLugar(elkin,barco).
policiaLugar(elkin,tren).
policiaLugar(elkin,avion).
policiaLugar(frigerio,barco).
policiaLugar(frigerio,tren).
policiaLugar(frigerio,avion).
lugarLadron(bar,gato).
lugarLadron(cine,gato).
lugarLadron(bar,sombra).
lugarLadron(cine,sombra).



