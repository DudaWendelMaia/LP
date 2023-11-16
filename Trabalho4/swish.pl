% Pais
pai(jose, ana).
pai(simao, ivo).
pai(willy, bia).
pai(jose, gil).
pai(ivo, eva).
pai(gil, rai).
pai(gil, clo).
pai(gil, ary).
pai(rai, noe).
pai(ary, gal).

pai(ary, leo). % Novos descendentes
pai(rai, mia).

% Mães
mae(joana, ana).
mae(matilde, ivo).
mae(camelia, bia).
mae(joana, gil).
mae(ana, eva).
mae(bia, rai).
mae(bia, clo).
mae(bia, ary).
mae(eva, noe).
mae(lia, gal).

mae(lia, leo). % Novos descendentes
mae(eva, mia).

% Homens
homem(jose).
homem(simao).
homem(willy).
homem(gil).
homem(ivo).
homem(rai).
homem(ary).
homem(noe).

homem(leo). %novo descendente

% Mulheres
mulher(ana).
mulher(joana).
mulher(matilde).
mulher(camelia).
mulher(eva).
mulher(clo).
mulher(lia).
mulher(gal).
mulher(bia).

mulher(mia). %nova descendente

%Regra Gerou
gerou(X, Y) :- pai(X, Y).
gerou(X, Y) :- mae(X, Y).


% Filho e Filha
filho(X, Y) :- gerou(Y, X), homem(X).
filha(X, Y) :- gerou(Y, X), mulher(X).

% Irmao
irmao(X, Y) :-
    gerou(Pai, X), gerou(Pai, Y), gerou(Mae, X), gerou(Mae, Y), homem(X),
    X \= Y. % Para garantir que X e Y são diferentes (não são a mesma pessoa).

irma(X, Y) :-
    gerou(Pai, X), gerou(Pai, Y), gerou(Mae, X), gerou(Mae, Y), mulher(X),
    X \= Y. 

% Tio e Tia
tio(X, Y) :- (irmao(X, Z) ; irma(X, Z)), gerou(Z, Y), homem(X).
tia(X, Y) :- (irmao(X, Z) ; irma(X, Z)), gerou(Z, Y), mulher(X).

% Primo e Prima
primo(X, Y) :- gerou(Z, X), gerou(W, Y), (irmao(Z, W) ; irma(Z, W)), homem(X).
prima(X, Y) :- gerou(Z, X), gerou(W, Y), (irmao(Z, W) ; irma(Z, W)), mulher(X).

% Avô e Avó
avo(X, Y) :- gerou(X, Z), gerou(Z, Y), homem(X).
avó(X, Y) :- gerou(X, Z), gerou(Z, Y), mulher(X).
