class catalogue {
    protected String title;
    protected int releaseYear;
    protected Double price;

    catalogue(String title, int releaseYear, Double price) {
        if (title.length() >= 255) {
            throw new IllegalArgumentException("Title too long!");
        } else {
            this.title = title;
        }
        if (releaseYear < 1800 || releaseYear > 2026) {
            throw new IllegalArgumentException("Release year is not in the range of 1800-2026!");
        } else {
            this.releaseYear = releaseYear;
        }
        if (price < 0) {
            throw new IllegalArgumentException("Price cannot be negative!");
        } else {
            this.price = price;
        }
    }

    protected void getDescription() {
        System.out.println("Title: " + title);
        System.out.println("Release Year: " + releaseYear);
        System.out.println("Price: " + price.intValue());
    }
}

class DVD extends catalogue {
    protected Double runtime;

    DVD(String title, int releaseYear, Double price, Double runtime) {
        super(title, releaseYear, price);
        if (runtime >= 720) {
            throw new IllegalArgumentException("Runtime cannot be more than 720 minutes!");
        } else {
            this.runtime = runtime;
        }
    }

    @Override
    protected void getDescription() {
        super.getDescription();
        System.out.println("Runtime: " + runtime.intValue() + " minutes");
    }
}

class Vinyl extends catalogue {
    protected int size;

    Vinyl(String title, int releaseYear, Double price, int size) {
        super(title, releaseYear, price);
        if (size > 12) {
            throw new IllegalArgumentException("Size is too big!");
        } else {
            this.size = size;
        }
    }

    @Override
    protected void getDescription() {
        super.getDescription();
        System.out.println("Size in inches: " + size);
    }
}

class Magazine extends catalogue {
    protected int numPages;
    protected String author;

    Magazine(String title, int releaseYear, Double price, String author, int numPages) {
        super(title, releaseYear, price);
        if (author.length() > 50) {
            throw new IllegalArgumentException("Author name too long!");
        } else {
            this.author = author;
        }
        if (numPages < 0) {
            throw new IllegalArgumentException("Number of pages cannot be negative!");
        } else {
            this.numPages = numPages;
        }
    }

    @Override
    protected void getDescription() {
        super.getDescription();
        System.out.println("Author: " + author);
        System.out.println("Number of Pages: " + numPages);
    }
}

public class Main {
    public static void main(String[] args) {
        catalogue[] products = new catalogue[3];
        products[0] = new DVD("Baby be Mine", 1982, 50000.0, 4.0);
        products[1] = new Magazine("Nintendo Power #82", 1997, 25000.0, "Nintendo", 36);
        products[2] = new Vinyl("Song of The Wind", 1967, 350000.0, 12);

        for (int i = 0; i < products.length; i++) {
            products[i].getDescription();
            System.out.println();
        }
    }
}
