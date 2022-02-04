public class Film {
    // data som skal være med:
    int nr;
    String producer;
    String title;
    int year;
    Genre genre;

    Film() {
    }

    Film(int Nr, String Producer, String Title, int Year, Genre GEnre) {
        nr = Nr;
        producer = Producer;
        title = Title;
        year = Year;
        genre = GEnre;
    }
    public int getNr() {
        return nr;
    }
    public void setNr(int nr) {
        this.nr = nr;
    }
    public String getProducer() {
        return producer;
    }
    public void setProducer(String producer) {
        this.producer = producer;
    }
    public String getTitle() {
        return title;
    }
    public void setTitle(String title) {
        this.title = title;
    }
    public int getYear() {
        return year;
    }
    public void setYear(int year) {
        this.year = year;
    }
    public Genre getGenre() {
        return genre;
    }
    public void setGenre(Genre genre) {
        this.genre = genre;
    }
    public boolean equals(Film b) {
        if (this.getNr() == b.getNr())
        return true;
    return false;
    }

    @Override
    public int hashCode() {
        Integer temp = nr;
        return temp.hashCode();
    }
}
