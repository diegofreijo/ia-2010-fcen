% arresto(Policia,Lugar,Ladron,Pais):-policia(Policia),lugar(Lugar),ladron(Ladron),pais(Pais).
% falta decir que los arrestos son disjuntos
%1_ Uno de los ladrones que tiene como alias el nombre de un animal fue atrapado en un bar de Alemania.
arresto(Policia,bar,gato,alemania).
arresto(Policia,bar,huron,alemania).
arresto(Policia,bar,rata,alemania).
%2_ Hurón no usó el barco que llegó a Inglaterra.
arresto(Policia,barco,gato,inglaterra).
arresto(Policia,barco,dedos,inglaterra).
arresto(Policia,barco,rata,inglaterra).
arresto(Policia,barco,sombra,inglaterra).
%3_ Quien fue detenido en el tren no estaba en España ni en Austria.
arresto(Policia,tren,Ladron,alemania).
arresto(Policia,tren,Ladron,inglaterra).
arresto(Policia,tren,Ladron,francia).
%4_ Dodero atrapó al Rata en España.
arresto(dodero,Lugar,rata,espana).
%5_ Ni el ladrón que fue atrapado por Elkin ni Dedos han estado en Alemania o Austria. Ninguno de estos dos arrestos se realizó en un avión.
arresto(elkin,Lugar,Ladron,inglaterra).
arresto(elkin,Lugar,Ladron,francia).
arresto(elkin,Lugar,Ladron,espana).
arresto(Policia,Lugar,dedos,inglaterra).
arresto(Policia,Lugar,dedos,francia).
arresto(Policia,Lugar,dedos,espana).
%6_ Sombra fue atrapado al salir de un cine pero no por Kesner o Frigerio.
arresto(dodero,cine,sombra,Pais).
arresto(elkin,cine,sombra,Pais).
arresto(minari,Lugar,Ladron,Pais).
%7_ Dodero, Elkin y Frigerio apresaron sendos ladrones al bajar de un transporte. En cambio, el Gato y Sombra fueron atrapados en lugares de esparcimiento.
arresto(dodero,barco,Ladron,Pais).
arresto(dodero,tren,Ladron,Pais).
arresto(dodero,avion,Ladron,Pais).
arresto(elkin,barco,Ladron,Pais).
arresto(elkin,tren,Ladron,Pais).
arresto(elkin,avion,Ladron,Pais).
arresto(frigerio,barco,Ladron,Pais).
arresto(frigerio,tren,Ladron,Pais).
arresto(frigerio,avion,Ladron,Pais).
arresto(Policia,bar,gato,Pais).
arresto(Policia,cine,gato,Pais).
arresto(Policia,bar,sombra,Pais).
arresto(Policia,cine,sombra,Pais).





