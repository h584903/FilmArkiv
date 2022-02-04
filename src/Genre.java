public enum Genre {
    ACTION, DRAMA, HISTORY, SCIFI;

    public static Genre finnSjanger(String navn) {
        Genre genre = null;
        for (Genre ge : Genre.values()) {
            if (ge.toString().equals((navn.toUpperCase()))) {
                genre = ge;
                break;
            }
        }
        return genre;
    }
}
