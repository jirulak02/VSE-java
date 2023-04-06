# Začarovaný labyrint

Tento kód, napsaný v jazyce Java, umožňuje spuštění jednoduché hry ovládané 
skrz textové rozhraní.

Hra probíhá v prostředí labyrintových místností, které
obsahují magické předměty. Úkolem hráče je utéct živý z labyrintu.

Autor: Jiří Šimeček
Verze: 1.0
Vytvořeno: Duben 2023


Dotazy:
/* Je přetypování na typ Prostor k něčemu? Přeci se tam nikdy nedostane,
   pokud již typu Prostor není ne? */
public boolean equals(Object o) {
    // porovnáváme jakého typu je parametr
    if (!(o instanceof Prostor)) {
        return false;    // pokud parametr není typu Prostor, vrátíme false
    }
    // přetypujeme parametr na typ Prostor
    Prostor druhy = (Prostor) o;
}