import java.util.Stack;

class Book {
    protected String title;
    protected String author;
    protected int year;

    Book(String title, String author, int year) {
        if (title.length() >= 255) {
            throw new IllegalArgumentException("Title is too long!");
        } else {
            this.title = title;
        }
        if (author.length() >= 50) {
            throw new IllegalArgumentException("Author is too long!");
        } else {
            this.author = author;
        }
        if (year <= 1800 || year >= 2026) {
            throw new IllegalArgumentException("Year is not in the range of 1800-2026!");
        } else {
            this.year = year;
        }
    }

    protected void getInfo() {
        System.out.println("Title: " + title);
        System.out.println("Author: " + author);
        System.out.println("Year of publication: " + year);
    }
}

class GeneralBook extends Book {
    protected String genre;

    GeneralBook(String title, String author, int year, String genre) {
        super(title, author, year);
        if (genre.length() > 30) {
            throw new IllegalArgumentException("Genre is too long!");
        } else {
            this.genre = genre;
        }
    }

    @Override
    protected void getInfo() {
        super.getInfo();
        System.out.println("Genre: " + genre);
    }
}

class ChildrenBook extends Book {
    protected int minAge;
    protected Boolean hasVisualisation;

    ChildrenBook(String title, String author, int year, int minAge, Boolean hasVisualisation) {
        super(title, author, year);
        if (minAge <= 3 || minAge >= 12) {
            throw new IllegalArgumentException("Minimum age is not in the range of 3-12!");
        } else {
            this.minAge = minAge;
        }
        this.hasVisualisation = hasVisualisation;
    }

    @Override
    protected void getInfo() {
        super.getInfo();
        System.out.println("Minimum Age: " + minAge);
        String visText = hasVisualisation ? "Yes" : "No";
        System.out.println("Has Visualisation: " + visText);
    }
}

public class Main {
    public static void main(String[] args) {
        Stack<Book> books = new Stack<>();

        Book[] booksArray = {
                new Book("Why Black Moves First", "Wesley So", 2025),
                new GeneralBook("Inside Black Mesa", "Dr. Isaac Kleiner", 1997, "Documentary"),
                new ChildrenBook("Got Science?", "Rachel Dawes", 2015, 5, true)
        };

        for (int i = booksArray.length - 1; i >= 0; i--) {
            books.push(booksArray[i]);
        }

        while (!books.isEmpty()) {
            books.pop().getInfo();
            System.out.println();
        }
    }
}
