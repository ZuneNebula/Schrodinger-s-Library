package comp3350.schrodingers.objects;

public class UserBook {
    private final String book;
    private final String name;

    public UserBook(String book, String name) {
        this.book = book;
        this.name = name;
    }

    public String getBook() {
        return book;
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return "UserBook{" +
                "book='" + book + '\'' +
                ", name='" + name + '\'' +
                '}';
    }
}
