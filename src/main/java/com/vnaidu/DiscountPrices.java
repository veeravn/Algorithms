package com.vnaidu;

public class DiscountPrices extends Base {

    public String discountPrices(String sentence, int discount) {
        String[] x = sentence.split(" ");
        StringBuilder sb = new StringBuilder();
        for (String s : x) {
            if (isPrice(s)) {
                String calcVal = calc(Double.parseDouble(s.substring(1)), discount);
                sb.append(calcVal).append(" ");
            } else {
                sb.append(s).append(" ");
            }
        }
        sb.deleteCharAt(sb.length() - 1);
        return sb.toString();
    }

    boolean isPrice(String s) {
        return s.startsWith("$") && s.substring(1).matches("\\d+");
    }

    String calc(double num, double discount) {
        double ans = num - (num * discount / 100.00);
        return "$" + String.format("%.2f", ans);
    }
}
