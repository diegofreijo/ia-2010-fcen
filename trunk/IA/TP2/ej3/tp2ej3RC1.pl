% UBA - DC - IA - 1C 2010
% TP2 ejercicio3
%
% Pablo Carbajo
% Diego Freijo
% Ignacio Iacobacci

% Los bloques son 1, 2, 3, 4 y 5
% El piso lo llamamos simplemente "piso"

% "estaSobre(A,B,S)" es el unico fluent, indica si el bloque A esta sobre B
% en la situacion S. B puede ser otro bloque o el "piso".
% la funcion resultado de aplicar una accion es "do".
% las acciones son apilar(bloqueEnElPiso,bloqueQueQuedaAbajo) y
% desapilar(bloqueNoEnElPisoQueVaAQuedarEnElPiso)

% situaciones para usar
% ------------------------------------------------------------------------
% s0 - inicial - el bloque 2 sobre el 1, el resto en el piso.
estaSobre( 1, piso, s0 ).
estaSobre( 2, 1, s0 ).
estaSobre( 3, piso, s0 ).
estaSobre( 4, piso, s0 ).
estaSobre( 5, piso, s0 ).

% situacion s02: el bloque 1 sobre el 2, el resto en el piso.
s02( do(apilar(1,2),do(desapilar(2),s0)) ).

% consultas ejemplo:
% s02(S), secPoss(S), poss( do( apilar(B1, B2), S ) ).
% retorna todos los bloques que se pueden apilar en la situacion s02

% s02(S), secPoss( do(desapilar(2),S) ).
% retorna false porque la secuencia de acciones no es posible

% s02(S), secPoss( do(apilar(3,2),S) ).
% retorna false porque la secuencia de acciones no es posible

% s02(S), estaSobre( A, B, S ).
% retorna sobre quien esta cada bloque en s02.


% ------------------------------------------------------------------------

% axioma de efecto para accion apilar
estaSobre( A, B, do( apilar( A, B ), S ) ).

% axioma frame accion apilar
estaSobre( A, B, do( apilar( B1, B2 ), S ) ) :-
  estaSobre( A, B, S ), A \= B1.

% axioma de efecto para accion desapilar
estaSobre( A, piso, do( desapilar( A ), S ) ).

% axioma frame accion desapilar
estaSobre( A, B, do( desapilar( B1 ), S ) ) :-
  estaSobre( A, B, S ),  A \= B1.


% precondicion accion apilar
sePuedeApilar( A, B, S ) :-
  estaSobre( A, piso, S ),
  not( estaSobre( X, A, S ) ), % A esta arriba de todo
  estaSobre( B, BB, S ), % instanciar B
  not( estaSobre( X, B, S ) ), % B esta arriba de todo
  B \= piso,
  A \= B.

% precondicion accion desapilar
sePuedeDesapilar( A, S ) :-
  estaSobre( A, B, S ), B \= piso, % A no esta en el piso
  not( estaSobre( X, A, S ) ), % A esta arriba de todo
  A \= piso.

poss( do( apilar( B1, B2 ), S ) ) :- sePuedeApilar( B1, B2, S ).
poss( do( desapilar( B ), S ) ) :- sePuedeDesapilar( B, S ).

secPoss( s0 ).
secPoss( do( A, S ) ) :- poss( do( A, S ) ), secPoss(S).
