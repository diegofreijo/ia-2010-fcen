encima(a, b).
encima(b, c).

verde(a).
verde(b). marron(b).
marron(c).

solucion(Bloque) :- verde(Bloque), encima(Bloque, Debajo), marron(Debajo).
