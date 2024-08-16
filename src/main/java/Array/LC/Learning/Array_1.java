package Array.LC.Learning;

public class Array_1 {
    // The actual code for creating an Array to hold DVD's.
    DVD[] dvdCollection = new DVD[15];

    public static void main(String[] args) {
        Array_1 arr = new Array_1();
        DVD avengersDVD = new DVD("The Avengers", 2012, "Joss Whedon");
//        arr.dvdCollection = new DVD[]{new DVD("abc", 2012, "piyush")};
        arr.dvdCollection[7] = avengersDVD;

        System.out.println(arr.dvdCollection[0]);
    }

    // A simple definition for a DVD.
    public static class DVD {
        public String name;
        public int releaseYear;
        public String director;

        public DVD(String name, int releaseYear, String director) {
            this.name = name;
            this.releaseYear = releaseYear;
            this.director = director;
        }

        public String toString() {
            return this.name + ", directed by " + this.director + ", released in " + this.releaseYear;
        }
    }
}
