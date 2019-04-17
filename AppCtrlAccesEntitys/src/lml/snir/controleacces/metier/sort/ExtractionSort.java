package lml.snir.controleacces.metier.sort;

import java.util.Comparator;

public class ExtractionSort extends  Sort {

    @Override
    public long  sort(Comparable[] values) {
        this.start();
        for (int i = 0; i < values.length - 1; i++) {
            // looking for min
            Comparable min = values[i];
            int posMin = i;
            for (int j = i + 1; j < values.length ; j++) {
                if (values[j].compareTo(min) < 0) {
                    posMin = j;
                    min = values[j];
                }
            }

            // exchange with min
            values[posMin] = values[i];
            values[i] = min;
        }
        return this.stop();
    }

    @Override
    public long  sort(Object[] values, Comparator comparator) {
        this.start();
        for (int i = 0; i < values.length - 1; i++) {
            // looking for min
            Object min = values[i];
            int posMin = i;
            for (int j = i + 1; j < values.length ; j++) {
                if (comparator.compare(values[j], min) < 0) {
                    posMin = j;
                    min = values[j];
                }
            }

            // exchange with min
            values[posMin] = values[i];
            values[i] = min;
        }
        return this.stop();
    }

}
