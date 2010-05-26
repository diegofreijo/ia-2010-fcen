bloque(a).
bloque(b).
bloque(c).

encima(a, b).
encima(b, c).

verde(a).
marron(c).

no_marron(Bloque) :- bloque(Bloque), not(marron(Bloque)).
no_verde(Bloque) :- bloque(Bloque), not(verde(Bloque)).

solucion(Bloque) :- no_marron(Bloque), encima(Bloque, Debajo), no_verde(Debajo).
