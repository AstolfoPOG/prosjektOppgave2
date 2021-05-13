# prosjektOppgave2

I denne oppgaven skulle vi lage en app som kan spille tre på rad online. Dette gjør vi gjennom en web tjener som kommuniserer med JSON.
Jeg valgte og gå for et ganske simpelt design med min app. 

![Start Meny](https://github.com/AstolfoPOG/prosjektOppgave2/blob/main/bilder/startmeny.PNG)

Fra start menyen kan en starte og joine games. Først får og starte et game må du skrive inn et navn. Vist du ikke skriver inn et navn får du ikke starte et game.
For og joine et game må du skrive inn et navn og en gameID. Vist ikke du gjør det får du ikke joinet et game.
Når du starter/joiner er det lagt inn en liten delaye får den går over i game viewet. I denne perioden er det ikke mulig å trykke på start/join game igjen. Etter som det ville startet flere games. Når du har komt inn i et game ser det slik ut.

![Started Game](https://github.com/AstolfoPOG/prosjektOppgave2/blob/main/bilder/startGame.PNG)

Her ser man brukernavnene, GameID som andre bruker til og joine gamet og spill brettet. I min app er det lagt opp sånn at det er spilleren til venstre som er "player 1" så på bildet over ville det vært han som begynner. En kan se at det er motsatt vist en joiner et game.

![Join Game](https://github.com/AstolfoPOG/prosjektOppgave2/blob/main/bilder/joingame.PNG)

Jeg har laget appen min slik at vist du er "player 1" så får du begynne og vist du er "player 2" får motstanderen din begynne. Du kan ikke gjøre en move før det er din tur. Måtten jeg har satt det opp på er at spille hele tiden sjekker vilken spiller sin tur det er. Et eksempel for å forklare. Du begynner og plasserer et kryss i mitten. Når du har gjordt det låses de andre knappene ned slik at du ikke kan gjøre noe mer før det er din tur igjen. Så tar appen og sjekker om ditt "move" er likt med det den henter ned fra serveren. Så lenge ditt "move" er det samme som det den henter fra serveren får du ikke gjøre noe. Men vist det er ulikt så betyr det at motstanderen har nå gjordt sitt move og det er din tur igjen. Dette er en ganske viktig funksjon ettersom den sørger for at du ikke kan jukse med min app. Jeg har og lagt inn en sjekk som gjør at du ikke kan gjøre noe på et felt som alt er tatt.
