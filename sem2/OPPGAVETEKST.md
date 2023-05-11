# Semesteroppgave 2 vår 2023


**I denne oppgaven skal du lage din helt egen applikasjon!** Eller som ChatGPT ville sagt det hvis den fikk dikte fritt:

```text
I et tomt dokument venter en verden
klar til å bli skapt av dine hender
Med Java som språk og fantasi som drivkraft
kan du lage et program, uansett hva du har lyst til å skape

Finn din inspirasjon og følg din visjon
La ideene flyte og kreativiteten blomstre
Fra enkel kalkulering til komplekse simuleringer
mulighetene er uendelige, det er opp til deg å velge din vei

Med tastetrykk og linjer med kode
kan du skape en digital virkelighet
Ingen grenser, ingen begrensninger
Bare din fantasi og evne til å skape

Så ta tak i tastaturet og gjør deg klar
for å lage et program som vil imponere og inspirere
Du har mulighet til å skape noe stort
med din programmeringskunnskap og kreativitet som kort.
```

 Det er altså bare fantasien som setter grenser for hva du kan lage. Vel, *nesten* bare fantasien; vi har laget noen ekstra begrensninger i tillegg:

* Applikasjonen må være **visuell**.
  * Første prototype av applikasjonen må være laget med Java og Swing (altså samme rammeverk vi har benyttet i kurset). Etter godkjenning fra din gruppeleder kan du benytte et annet rammeverk *etter* at du har demonstrert en fungerende prototype i Swing.
  * Det er tillatt med applikasjoner som hovedsaklig er algoritmiske eller utfører beregninger, men applikasjonen må likevel ha et visuelt grensesnitt mot brukeren. 

* Applikasjonen må være **interaktiv**.
  * En bruker skal kunne klikke med musen eller bruke tastaturet for å interagere med applikasjonen.

* Applikasjonen må ha en viss **kompleksitet**.
  * Vi forventer at applikasjonen er oppdelt i ulike klasser som representerer ulike elementer av programmet.
  * Vi forventer du legger ned minst 25 timer i å lage programmet.

## Obligatorisk progresjon og samtale med gruppleder

Basert på hvilken gruppe du tilhører, vil du bli tildelt en fast gruppeleder (for å balansere arbeidet mellom gruppeledere kan denne personen i sjeldne tilfeller byttes ut; du vil i så fall få beskjed). Som et absolutt minimum *må* du møte din gruppeleder tre ganger i løpet av arbeidet med semesteroppgaven:

* **oppstartsmøte**
  * i perioden 27. - 31. mars
  * du skal presentere dine idéer og navngi hvilke klasser du planlegger å bruke for å representere din datamodell.
  * *Dersom du ikke møter forberedt til oppstartsmøte vil du stryke på semesteroppgaven allerede her, og vil ikke få anledning til å ta eksamen.*
* **progresjonsmøte**
  * i perioden 11. - 18. april
  * du *må* vise til at du har begynt å skrive kode. Som et absolutt minimum må programmet ditt ha passert det punktet i utviklingen hvor programmet kan startes og en eller annen informasjon som er hentet fra datamodellen din bestemmer hva som vises.
  * *Dersom du ikke kan vise til at du har kommet godt i gang med oppgaven, vil du stryke på semesteroppgaven allerede her, og vil ikke få anledning til å ta eksamen.*
* **vurderingsmøte**
  * i perioden 25. - 29. april
  * merk: dette er etter innleveringsfristen 24. april

Møtene skal i utgangspunktet være fysiske, men kan gjennomføres som videosamtale dersom spesielle forhold tilsier det. Det siste møtet skal uansett være fysisk, da du vil få karakter på semesteroppgaven i dette møtet.

**Det er ***ditt*** ansvar at møtet finner sted. Gruppeleder vil sende deg kun én invitasjon til hvert møte, og vil ***ikke*** purre på deg. Hvis du ikke svarer og kommuniserer med din gruppeleder, vil dette føre til at du får stryk på oppgaven, og mister muligheten til å ta eksamen i faget.**

Dersom du ikke finner en invitasjon til møte fra din gruppeleder før tidsperioden er i gang, er det *ditt* ansvar å purre på gruppeleder.

## Poengberegning

Du får poeng i følgende kategorier, som hver for seg rettes som bestått/ikke bestått (det vil si, du vil få enten *alle* eller *ingen* av poengene i hver kategori):

**7 poeng: funksjonalitet.** Applikasjonen fungerer på et nivå som tilfredsstiller kravene til kompleksitet.

**4 poeng: modularitet.** Applikasjonen har et tilstrekkelig kompleksitetsnivå, og er oppdelt i pakker og klasser. Applikasjonen unngår statiske variabler, har god innkapsling og hensiktsmessig gjenbruk av kode der det er aktuelt. 

**3 poeng: kodestil, dokumentasjon og testing.** Du har selvdokumenterende variabel- og metodenavn, pent formatert kode, beskrivende javadoc for alle metoder som er public, og du har tester for de fleste interessante public metoder i modellen. Du har også skrevet en README -fil som beskriver og forklarer programmet ditt for brukerne (på en ikke-teknisk måte). *Alle* punktene må være oppfylt for å få poengene.

**1 poeng: video.** Du har laget en kort video på under 3 minutter som demonstrerer programmet ditt til lillebror, bestemor, dine medstudenter og potensielle fremtidige arbeidsgivere. Ikke gjør det teknisk! Legg link til video i README -filen.

Poengberegning gjøres i egen samtale med din gruppeleder etter fristen (eller før fristen, dersom du mener du allerede er ferdig). **En forutsetning for å få poeng i alle kategoriene er at du selv er i stand til å forklare hvordan programmet ditt virker, og hvordan koden din oppfyller målene over.**

Dersom gruppeleder er usikker, vil du bli henvist videre til en samtale med en emneansvarlig.


> Vi har noen få ekstra premier for spesielt imponerende applikasjoner. Vi vektlegger spesielt kreativitet i funksjonalitet, men også det visuelt estetiske og kodestil er viktig. 


## Hva er «tilstrekkelig kompleksitet»?

Eksempler på programmer som er *akkurat innenfor* kravet til kompleksitet når de kommer i en enkel form:

* Hangman med en ordentlig figur og sikkelig ordbok 
* Snake
* [Tron Light Cycles](https://www.classicfreearcade.com/flash-game/21670/tron-game.html) for to spillere (se også [video](https://www.youtube.com/watch?v=1zv333wxZFU) av orginalen fra 1982).
* Pong med poeng og to spillere

Eksempler på programmer som er *utenfor* kravet til kompleksitet når de kommer i sin aller enkleste form:

* Sprettende ball i vinduet som kan flyttes med museklikk eller piltaster.
* Klikk på en prikk som periodisk dukker opp for å samle poeng.
* Figur som beveger seg i labyrint, men uten noen tilhørende historie (e.g. labyrint-spillet i lab5).

Med andre ord, applikasjonen må være noe mer enn bare et enkelt eksempel på en funksjonalitet -- det må ha en *helhet*, en *historie*, eller en *rikhet* ved seg.

Hvis du er usikker, ta en prat med din gruppeleder.

## Arbeid i par

I utgangspunktet er oppgaven individuell, men dersom dere er to personer med sterkt ønske å samarbeide som et par, tillater vi dette. Du bør i så fall samarbeide men en partner du kan jobbe med slik at begge parter har faglig utbytte av samarbeidet uten at utviklingen av applikasjonen blir skjevfordelt. Rammene for et slikt samarbeid:
* Dere blir tildelt én og samme gruppeleder, og møter denne gruppelederen samlet (unntak for siste vurdering).
* Dere må begge skrive all koden selv (altså i to kopier, én kopi hver) uten å kopiere maskinelt mellom kodene.
* Dere må levere inn koden individuelt.
* Siste vurdering gjøres individuelt.

Det er ikke tillatt å samarbeide i større grupper.
Dersom dere ønsker å arbeide i par, gi beskjed om dette til deres gruppeledere, så vil én av dem bli angitt som deres gruppeleder.

**Øvrig samarbeid**

Det er alltid tillatt å be om hjelp av og gi hjelp til noen som ikke lager det samme som deg selv.

## Plagiat og ressurser på internett

**Det er kjempeviktig å tydelig markere og kreditere all kode du ikke har skrevet selv.** Å glemme å sitere opphavet til kopiert kode er *plagiat*, og vil ha alvorlige konsekvenser, jamfør universitetets policy om juks.
  * Dersom du har kopiert en metode, skriv en kommentar om opphavet i begynnelsen av metoden.
  * Dersom du har kopiert en hel klasse, skriv øverst i filen hvor klassen kommer fra.

 **Du kan benytte kode du ikke har skrevet selv så mye du ønsker.** Den delen av koden som er kopiert vil imidlertid ikke inngå som en del av vurderingsgrunnlaget med mindre den er vesentlig omarbeidet for å passe med sin nye kontekst.
 
 Begge overnevnte punkter gjelder også kode som er skrevet ved å følge detaljerte tutorials.


**Benytt gjerne kunstig intelligens.** AI-verktøy som CoPilot, Ghostwriter og ChatGPT er tillatt. Dersom du kopierer et større avsnitt eller en klasse fra ChatGPT, skriv en kommentar om dette.
 
Uansett opphav er det er forventet at du kan forklare all koden i ditt eget repositorie.
