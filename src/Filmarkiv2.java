import java.util.ArrayList;

public class Filmarkiv2 implements FilmarkivADT{

    private int antall;
    private LinearNode<Film> start;
    // private LinearNode<Film> instance;
    // Ingen referanse til siste, kun start

 /* Klassen skal ha de samme operasjoner som for Filmarkiv i
 øving 2, men pass på at implementeringen av alle metoder
 blir tilpasset den nye strukturen. */
    public Filmarkiv2(){
        this.antall = 0;
        this.start = new LinearNode<Film>();
    }

    private LinearNode<Film> instance(int iteration){
        LinearNode<Film> instance = this.start;
        for (int i = 0; i < iteration; i++){
            instance = instance.getNeste();
        }
        return instance;
    }

    @Override
    public void visFilm(int nr) {
        if (nr < this.antall)
            System.out.println(instance(nr).getElement().getTitle());
        else
            System.out.println("This instance dosen't exists");
    }

    @Override
    public void leggTilFilm(Film nyFilm) {
        LinearNode<Film> nynode = new LinearNode<Film>(nyFilm);
        if (this.antall != 0){
            instance(this.antall-1).setNeste(nynode);
        } else{
            this.start = nynode;
        }
        this.antall++;
    }

    @Override
    public boolean slettFilm(int filmnr) {
        if (filmnr < 0) {
            System.out.println("ERROR\nInput is negative, when deleting Film");
        }

        if (filmnr < this.antall && filmnr != 0){
            if (filmnr == this.antall-1){
                instance(filmnr).setElement(null);
            } else {
                instance(filmnr-1).setNeste(instance(filmnr-1));
            }
        }
        else if (filmnr == 0){
            if (this.antall > 1){
                this.start.setNeste(start.getNeste());
            } else {
                this.start.setElement(null);
            }
            this.antall--;

        }
        else
            System.out.println("This instance dosen't exists");
        return false;
    }

    @Override
    public Film[] soekTittel(String delstreng) {
        ArrayList<Film> result = new ArrayList<Film>();
        for (int i = 0;i < antall; i++){
            if (instance(i).getElement().title.contains(delstreng))
                result.add(instance(i).getElement());
        }
        Film[] search = result.toArray(new Film[0]);
        return search;
    }

    @Override
    public int antall(Genre genre) {
        int sum = 0;
        for (int i = 0;i < antall; i++){
            if (instance(i).getElement().getGenre() == genre){
                sum++;
            }
        }
        return sum;
    }

    @Override
    public int antall() {
        return this.antall;
    }

    @Override
    public Film[] soekProducer(String delstreng) {
        ArrayList<Film> result2 = new ArrayList<Film>();
        for (int i = 0;i < this.antall; i++){
            Film filmResult = instance(i).getElement();
            if (filmResult != null && filmResult.getProducer().contains(delstreng))
                result2.add(filmResult);
        }
        Film[] search = result2.toArray(new Film[0]);
        return search;
    }
}