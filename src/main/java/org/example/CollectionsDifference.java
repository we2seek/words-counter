package org.example;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/**
 * Find difference between two collections
 */
public class CollectionsDifference {

    private static CollectionsDifference INSTANCE;

    private CollectionsDifference() {
    }

    public synchronized static CollectionsDifference getInstance() {
        if (INSTANCE == null) {
            INSTANCE = new CollectionsDifference();
        }
        return INSTANCE;
    }

    /**
     * Returns difference between two collections
     * diff([a], [b])   -> [a, b]
     * diff([a], [a])   -> []
     *
     * @param left  First collection, not null
     * @param right Second collection, not null
     * @param <T>   Type of collection
     * @return New collection of difference
     */
    public <T> List<T> diff(Collection<T> left, Collection<T> right) {
        ArrayList<T> leftCopy = new ArrayList<>(left);
        leftCopy.removeAll(right);
        ArrayList<T> rightCopy = new ArrayList<>(right);
        rightCopy.removeAll(left);

        leftCopy.addAll(rightCopy);
        return leftCopy;
    }


}
