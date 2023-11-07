# Classi anonime, classi innestate, enumerazioni

**Fare correggere ad ogni parte dell'esercizio, non solo al termine di tutte le parti.**

## Parte 1: classe anonima

Si osservi la classe Function, che modella una singola funzione con un solo input ed un solo output di tipo arbitrario.
Si implementi il metodo `identity()`, che deve restituire la funzione identià
(ossia, che restituisce l'input passato in ingresso senza modifica alcuna)
tramite una classe anonima.
Si osservi `TestFunctionalLibrary` per trovare esempi di classi anonime che implementano function.
Ci si prepari a rispondere alla seguente domanda al momento della correzione:
> perché `identity()` è un metodo, e non una costante `public static`?
-------------
Il metodo `identity()` nella tua interfaccia `Function` è un metodo statico che restituisce un'istanza di `Function`. Questo metodo crea una nuova istanza di `Function` ogni volta che viene chiamato. Questo è utile se vuoi avere più istanze separate della funzione identità, o se vuoi evitare di condividere lo stato tra diverse parti del tuo codice.

Se `identity()` fosse una costante `public static`, avrebbe un solo valore che sarebbe condiviso tra tutte le parti del tuo codice che lo usano. Questo potrebbe essere problematico se la tua funzione avesse uno stato interno che potrebbe essere modificato, ma nel caso della funzione identità, che è senza stato, non ci sarebbero differenze pratiche tra i due approcci.

In generale, l'uso di metodi statici per creare nuove istanze di oggetti (spesso chiamati metodi factory) può offrire più flessibilità rispetto all'uso di costanti statiche, perché ti permette di cambiare l'implementazione del metodo in futuro senza cambiare il codice che lo chiama. Ad esempio, potresti decidere in seguito di voler limitare il numero di istanze della tua funzione identità che vengono create, e potresti farlo modificando il metodo `identity()` per restituire una singola istanza condivisa invece di creare sempre una nuova istanza. Se avessi usato una costante statica, non avresti questa opzione senza cambiare tutto il codice che usa la costante.
------------

## Parte 2: sfruttare le classi anonime per costruire una libreria funzionale

Si implementino le funzioni di utilità non ancora implementate all'interno di `Transformers`.
Queste funzioni rappresentano manipolazioni di tipo *funzionale* di collezioni.
Si leggano con attenzione i commenti Javadoc presenti per trovare la soluzione più compatta per implementare le funzioni
richieste.
Si minimizzino le duplicazioni di codice, e non si utilizzino metodi "di appoggio".

## Parte 3: classi innestate ed enum

All'interno della classe MonthSorterNested, si crei una `enum Month` che modella i mesi dell'anno.
Si suggerisce di valutare l'utilizzo di un campo che modella il numero di giorni del mese.
Questa enum *deve* avere un metodo `Month fromString(String)` che, data una stringa di testo, restituisce il `Month`
che meglio la rappresenta. A tal proposito, si legga con molta attenzione la Javadoc di `MonthSorter`.

Utilizzare questa `enum` come supporto per la costruzione di due classi innestate: `SortByMonthOrder` e `SortByDate`
che implementano `Comparator<String>` e rappresentano, rispettivamente, un comparatore che ordina delle stringhe
(interpretandole come mesi) in base al loro ordine nell'anno, ed un comparatore che le ordina invece in base al numero
di giorni che il mese ha.
