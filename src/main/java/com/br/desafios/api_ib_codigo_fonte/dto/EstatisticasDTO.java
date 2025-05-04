package com.br.desafios.api_ib_codigo_fonte.dto;

import lombok.Getter;

import java.util.DoubleSummaryStatistics;

@Getter
public class EstatisticasDTO {

    private long count;
    private double sum;
    private double avg;
    private double min;
    private double max;

    public EstatisticasDTO(DoubleSummaryStatistics statistics) {
        this.count = statistics.getCount();
        this.sum = statistics.getSum();
        this.avg = statistics.getAverage();
        this.min = statistics.getMin();
        this.max = statistics.getMax();
    }
}
