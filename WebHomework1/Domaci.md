# Konkurentno programiranje

## Opis zadatka
N studenata pristupa odbrani domaćeg zadatka. Odbranu drže profesor i asistent. Asistent je u stanju da vrši uvid u rad samo jednog studenta dok je profesor sposoban da prati isključivo dve odbrane paralelno (ne želi da održi odbranu samo za jednog studenta). Odbranu ćemo simulirati zasebnim nitima - jedna za asistenta i dve za profesora. Obrane mogu početi onog trenutka kada su i asistentska i profesorske niti spremne za rad. Profesor i asistent su dostupni u narednih 5 sekundi od početka, nakon čega odbrane nisu više moguće.
Svaki student na odbranu dolazi u nekom vremenskom trenutku - random vrednostu u opesgu od  0 < x <= 1 sekund od trenutka početka odbrana. Svaki student brani zadatak svojim tempom - random vrednost u opsegu od 0.5 <=  X <= 1 sekund, nakon čega dobija ocenu i završava. Pošto odbrane traju 5 sekundi, odbrana koja je započeta mora biti prekinuta onog trenutka kada 5 sekundi istekne.
Profesor ne prihvata da radi uvid samo jednog studenta nego će sačekati dva studenta koji su spremni da brane i tek onda da započne uvid oba studenta paralelno, dok oba ne završe. 
Asistent radi uvid čim se neki student spremi za odbranu. 
Verovatnoća da student brani kod profesora ili asistenta neka bude po izboru (npr. 50% da će braniti kod profesora i 50% da će braniti kod asistenta).
Svaki student po završetku svoje odbrane dobija ocenu između 5 i 10. Dobijenu ocenu je potrebno dodati na sumu ocena svih studenata. Ova suma će se po završetku programa (nakon isteka 5 sekundi predviđenih za odbranu) podeliti sa brojem studenata i dobijeni prosek treba da se ispiše u konzoli. Ovaj prosek mora biti tačan bez obzira na broj studenata. 
Ne sme da se dogodi da isti student dva puta brani domaći. Ne sme da se dogodi da student brani domaći posle isteka vremena predviđenog za odbrane (5 sekindi), čak i ako je počeo pre završetka. Ne sme da se dogodi da profesor i asistent rade uvid istom studentu. 
Ulazni parameter sistema je N tj. broj studenata. 
Izlaz sistema treba da bude ispis sledećeg formata za sve student koji su stigli ili su prekinuti u odbrani rada: 
Thread: <Ime treda studenta> Arrival: <Vreme prispeća stundenta od početka odbrane> Prof: <Ime treda asistenta ili profesora> TTC: <Vreme koje je bilo potrebno da se pregleda domaći>:<vreme početka odbrane> Score: <Ocena koju je dobio od 5 do 10> 
Za kreiranje niti koristiti thread pool bilo kog tipa (sem singleThreadPool-a). Za profesora implementirati cyclicBarrier kad se ceka da dva studenta krenu sa odbranom kod njega. 
  

