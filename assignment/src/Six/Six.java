package Six;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

class SparseMatrix {
    // Inner class to represent a non-zero entry
    static class Entry {
        int row;
        int col;
        int value;

        Entry(int row, int col, int value) {
            this.row = row;
            this.col = col;
            this.value = value;
        }

        @Override
        public String toString() {
            return "(" + row + ", " + col + ", " + value + ")";
        }
    }

    // List to store non-zero entries
    ArrayList<Entry> entries = new ArrayList<>();

    // Method to add a non-zero entry to the sparse matrix
    void addEntry(int row, int col, int value) {
        if (value != 0) {
            entries.add(new Entry(row, col, value));
        }
    }

    // Method to transpose the sparse matrix
    SparseMatrix transpose() {
        SparseMatrix transposed = new SparseMatrix();

        // Swap rows and columns for each entry
        for (Entry entry : entries) {
            transposed.addEntry(entry.col, entry.row, entry.value);
        }

        // Sort in lexicographic order (row first, then column)
        Collections.sort(transposed.entries, Comparator
                .comparingInt((Entry e) -> e.row)
                .thenComparingInt(e -> e.col));

        return transposed;
    }

    // Method to print the sparse matrix entries
    void printEntries() {
        for (Entry entry : entries) {
            System.out.println(entry);
        }
    }

    public static void main(String[] args) {
        SparseMatrix matrix = new SparseMatrix();

        // Example: Adding non-zero elements to the sparse matrix
        matrix.addEntry(0, 2, 3);
        matrix.addEntry(1, 0, 4);
        matrix.addEntry(1, 2, 5);

        System.out.println("Original Sparse Matrix:");
        matrix.printEntries();

        // Transpose the sparse matrix
        SparseMatrix transposedMatrix = matrix.transpose();
        System.out.println("\nTransposed Sparse Matrix (Lexicographically Ordered):");
        transposedMatrix.printEntries();
    }
}

