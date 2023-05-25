# Beadandó feladat Mesterséges intelligencia tárgyra
A PuzzleN osztály, **mélységi**, **szélességi**, vagy **legjobbat-először (A\*)** keresők egyikével jut el, a kezdőállapotból a végállapotba.
#### Műveletek:
- sorcsere
- oszlopcsere

**Lépés költsége: 1**, (nem része az implementációnak).

A kezdő és végállapotok a `tables.xml` fájlból kerülnek beolvasásra.<br/>
Az állapotok tartalmilag tetszőlegesek stringet tartalmazhatnak, de minimum **2x2**-esnek, és **szimmetrikusnak** kell lenniük.

Az adott csomópont **heurisztikáját**  azok az elemek száma adja, amelyek különböznek a célállapot ugyanazon a koordiánátáin elhelyezkedő értékeitől.<br/>
Tehát a célcsomópont heurisztikája **0**.

------------

### Példa:
#### <ins>Kezdőállapot:</ins>
|  | 0 | 1 | 2 |
| ------ | ------ | ------ | ------ |
| **0** | O | I | O |
| **1** | I | O | I |
| **2** | O | I | O |

**Heurisztika: 6** (mivel a **2.** és a **3.** sor elemei **nem egyeznek** a célállapot **2.** és **3.** sor elemeivel. )

**Művelet: 1.** és **2.** indexű **sorok cseréje.**
#### <ins>Célállapot:</ins>
|  | 0 | 1 | 2 |
| ------ | ------ | ------ | ------ |
| **0** | O | I | O |
| **1** | O | I | O |
| **2** | I | O | I |

**Heurisztika: 0**

## Jegyzetek📝

#### A lehetséges műveletek kiszámításának logikája:
![A lehetséges műveletek kiszámításának logikája](https://i.imgur.com/l49mYyh.png)
#### Oszlopcsere logikája:
![Oszlopcsere logikája](https://i.imgur.com/GqlXhkR.png)
