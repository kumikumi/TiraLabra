Dijkstran algoritmi toimii kuten leveyssuuntainen haku, mutta se ottaa lisäksi huomioon maaston sijaintien liikkumiskustannukset. Dijkstran algoritmi löytää ruudukossa aina lyhimmän mahdollisen reitin.

Dijkstran algoritmi eroaa leveyssuuntaisesta hausta siten, että siinä missä leveyssuuntainen haku etenee tasaisesti joka suuntaan, dijkstran algoritmi suosii edetessään solmuja, joilla on alhaisempi liikkumiskustannus. Dijkstran algoritmi toisin sanoen levittäytyy tasaisesti joka suuntaan jo liikutun matkan (kustannuksen) mielessä, ei pelkän etäisyyden mielessä kuten leveyssuuntainen haku.

Haku käyttää hyväkseen Prioriteettikeko-tietorakennetta, josta valitaan tutkittavaksi solmuksi aina sellainen solmu, jossa tähän saakka kuljettu matka on mahdollisimman pieni. Aluksi lisätään aloituspiste tähän listaan. Lisäksi pidetään yllä taulukkoa, johon kirjataan parhaat lyhimmät matkat, joka kulkemalla on päästy kuhunkin pisteeseen maailmassa.

Niin kauan kuin tutkittavien listassa riittää alkioita, otetaan sieltä ulos seuraava, ja jos ei olla maalissa, lisätään tutkittavien listaan tämän sijainnin naapurit, joihin ei olla vielä päästy vähintään yhtä hyvää reittiä pitkin. Jatketaan tätä kunnes päästään maaliin tai tutkittavien alkioiden joukko on tyhjä, jolloin reittiä ei löytynyt.

Lähde: http://www.redblobgames.com/pathfinding/a-star/introduction.html kohta Dijkstra