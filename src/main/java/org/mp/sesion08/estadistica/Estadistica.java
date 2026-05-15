package org.mp.sesion08.estadistica;

import org.apache.commons.math3.stat.descriptive.DescriptiveStatistics;
import org.mp.sesion08.conjuntodatos.ConjuntoDatos;

public class Estadistica {

    private ConjuntoDatos cd;
    private DescriptiveStatistics stats;

    public Estadistica(ConjuntoDatos cd) {
        this.cd = cd;
        this.stats = new DescriptiveStatistics();
    }

    private void cargarDatos(String columna) {

        stats.clear();

        String[] valores = cd.getColumna(columna);

        for (String valor : valores) {

            if (valor == null || valor.isEmpty() || valor.equalsIgnoreCase("NaN")) {
                continue;
            }

            stats.addValue(Double.parseDouble(valor));
        }
    }

    public double max(String columna) {
        cargarDatos(columna);
        return stats.getMax();
    }

    public double min(String columna) {
        cargarDatos(columna);
        return stats.getMin();
    }

    public double suma(String columna) {
        cargarDatos(columna);
        return stats.getSum();
    }

    public double media(String columna) {
        cargarDatos(columna);
        return stats.getMean();
    }
}
