import org.w3c.dom.ls.LSOutput;

public class Tekstgrensesnitt {
    // lese opplysningene om en FILM fra tastatur
    public Film lesFilm(){
// TODO
        return null;
    }
    // vise en film med alle opplysninger på skjerm (husk tekst for sjanger)
    public void visFilm(Film film) {
        System.out.println(film.getNr() + " " + film.getGenre().toString() + ":" + film.getTitle());
        System.out.println("Produced in " + film.getYear() + " by " + film.getProducer());
    }
    // Skrive ut alle Filmer med en spesiell delstreng i tittelen
    public void skrivUtFilmDelstrengITittel(FilmarkivADT filma, String delstreng) {
        Film[] search = filma.soekTittel(delstreng);
        for (int i = 0; i < search.length; i++){
            visFilm(search[i]);
        }
    }
    // Skriver ut alle Filmer av en produsent / en gruppe
    public void skrivUtFilmProdusent(FilmarkivADT filma, String delstreng) {
        Film[] search = filma.soekProducer(delstreng);
        for (Film f : search){
            visFilm(f);
        }
    }
    // Skrive ut en enkel statistikk som inneholder antall Filmer totalt
// og hvor mange det er i hver sjanger
    public void skrivUtStatistikk(FilmarkivADT filma) {
        System.out.println("Amount of films: " + filma.antall() + "\n");
        System.out.println("Amount of SciFi: " + filma.antall(Genre.SCIFI));
        System.out.println("Amount of Action: " + filma.antall(Genre.ACTION));
        System.out.println("Amount of Drama: " + filma.antall(Genre.DRAMA));
        System.out.println("Amount of History: " + filma.antall(Genre.HISTORY));
        System.out.println();
    }
// … Ev. andre metoder
}
