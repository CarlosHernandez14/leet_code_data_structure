package com.charly.referencia_metodos;

import java.util.List;

public class AmazonCountFailed {

    public static void main(String[] args) {


        List<Integer> requiredSequence = List.of(4, 2, 3, 5, 1, 6);
        List<Integer> actualSequence = List.of(2, 3, 5, 1, 6, 4);

        int countFailed = countFailedExecutions(requiredSequence, actualSequence);
        System.out.println("Count of failed executions: " + countFailed);

    }


    public static int countFailedExecutions(List<Integer> requiredSequence, List<Integer> actualSequence) {

        int indexRequired = 0;
        int indexActual = 0;
        int countFailed = 0;
        while(indexRequired < requiredSequence.size()) {

            if (requiredSequence.get(indexRequired) != actualSequence.get(indexActual)) {
                indexRequired++;
                countFailed++;
            }
            else {
                indexRequired++;
                indexActual++;
            }

        }


        return countFailed;

    }


    public static int countPromotionalPeriods(List<Integer> orders) {




        return 0;

    }

    public static int minOrders(int ordersI, int ordersJ) {
        return Math.min(ordersI, ordersJ);
    }

    public static int maxOrders(List<Integer> restOfDays) {
        int maxOrders = 0;
        for (int i = 0; i < restOfDays.size(); i++) {
            maxOrders = Math.max(maxOrders, restOfDays.get(i));
        }
        return maxOrders;
    }

}
