public class Meny {
    private Tekstgrensesnitt tekstgr;
    private FilmarkivADT filmarkiv2;
    public Meny(FilmarkivADT filmarkiv){
        tekstgr = new Tekstgrensesnitt();
        this.filmarkiv2 = filmarkiv;
    }
    public void start(){
        Film f1 = new Film(000,"Petter Tesdal","The adventure",1999,Genre.ACTION);
        Film f2 = new Film(001,"Daniel Thrasher","The Main man",2022,Genre.SCIFI);
        Film f3 = new Film(002,"Mora Di","The Story",1203,Genre.HISTORY);
        Film f4 = new Film(003,"Petter Tesdal","The adventure 2",2000,Genre.ACTION);
        filmarkiv2.leggTilFilm(f1);
        filmarkiv2.leggTilFilm(f2);
        filmarkiv2.leggTilFilm(f3);
        filmarkiv2.leggTilFilm(f4);
        tekstgr.skrivUtFilmProdusent(filmarkiv2,"Pett");
        System.out.println(filmarkiv2.antall());
    }
}