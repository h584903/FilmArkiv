import java.util.ArrayList;

public class Filmarkiv implements FilmarkivADT {

    Film[] arkiv;
    int films;
    Filmarkiv(int size){
        arkiv = new Film[size];
        films = 0;
    }

    @Override
    public void visFilm(int nr) {
        for (Film f : this.arkiv){
            if (f.getNr() == nr){
                System.out.println(f.getTitle());
                return;
            }
        }
        System.out.println("Error:\nThere was no film by that nr.");
    }

    @Override
    public void leggTilFilm(Film nyFilm) {
        if (this.arkiv.length == this.films || this.films > this.arkiv.length){
            System.out.println("Error:\nArchive length is the same or bigger than max");
            System.out.println("Amount of films: " + this.films);
            System.out.println("Size: " + this.arkiv.length);
            return;
        }
        this.arkiv[films] = nyFilm;
        this.films++;
    }

    @Override
    public boolean slettFilm(int filmnr) {
        for (int i = 0; i < this.films; i++){
            if (this.arkiv[i].getNr() == filmnr){
                System.out.println(this.arkiv[i].getTitle() + "has been deleted");
                this.films++;
                return true;
            }
        }
        return false;
    }

    @Override
    public Film[] soekTittel(String delstreng) {
        ArrayList<Film> result = new ArrayList<Film>();
        for (Film f : this.arkiv){
            if (f.title.contains(delstreng))
                result.add(f);
        }
        Film[] search = result.toArray(new Film[0]);
        return search;
    }

    @Override
    public int antall(Genre genre) {
        int sum = 0;
        for (Film f : this.arkiv){
            if (f.getGenre() == genre){
                sum++;
            }
        }
        return sum;
    }

    @Override
    public int antall() {
        return this.films;
    }

    @Override
    public Film[] soekProducer(String delstreng) {
        ArrayList<Film> result2 = new ArrayList<Film>();
        for (Film f : this.arkiv){
            if (f != null && f.getProducer().contains(delstreng))
                result2.add(f);
        }
        Film[] search = result2.toArray(new Film[0]);
        return search;
    }
}
