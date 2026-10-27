import java.math.BigDecimal;
import java.math.RoundingMode;

public class Main {
    public static void main(String[] args) {
        double productCostDouble = 9.99;
        double vatRateDouble = 0.05;
        double vatAmountDouble = productCostDouble * vatRateDouble;

        int unitsSold = 10000;
        double totalNetDouble = 0.0;
        double totalVatDouble = 0.0;
        double totalGrossDouble = 0.0;

        for (int i = 0; i < unitsSold; i++) {
            totalNetDouble += productCostDouble;
            totalVatDouble += vatAmountDouble;
            totalGrossDouble += (productCostDouble + vatAmountDouble);
        }

        System.out.println("=== 1. CALCULATION USING DOUBLE (PRECISION ERROR) ===");
        System.out.println("Single Unit Net: " + productCostDouble);
        System.out.println("Single Unit VAT: " + vatAmountDouble);
        System.out.println("Total Net Sales: " + totalNetDouble);
        System.out.println("Total VAT Amount: " + totalVatDouble);
        System.out.println("Total Gross Value: " + totalGrossDouble);

        BigDecimal productCost = new BigDecimal("9.99");
        BigDecimal vatRate = new BigDecimal("0.05");
        BigDecimal vatAmount = productCost.multiply(vatRate);

        BigDecimal totalNetValue = BigDecimal.ZERO;
        BigDecimal totalVatAmount = BigDecimal.ZERO;
        BigDecimal totalGrossValue = BigDecimal.ZERO;

        for (int i = 0; i < unitsSold; i++) {
            totalNetValue = totalNetValue.add(productCost);
            totalVatAmount = totalVatAmount.add(vatAmount);
            totalGrossValue = totalGrossValue.add(productCost.add(vatAmount));
        }

        System.out.println("\n=== 2. CALCULATION USING BIGDECIMAL (EXACT RAW VALUES) ===");
        System.out.println("Single Unit Net: " + productCost);
        System.out.println("Single Unit VAT: " + vatAmount);
        System.out.println("Total Net Sales: " + totalNetValue);
        System.out.println("Total VAT Amount: " + totalVatAmount);
        System.out.println("Total Gross Value: " + totalGrossValue);

        System.out.println("\n=== 3. BIGDECIMAL WITH FINANCIAL ROUNDING (HALF_UP, 2 DECIMALS) ===");
        System.out.println("Single Unit Net: " + productCost.setScale(2, RoundingMode.HALF_UP));
        System.out.println("Single Unit VAT: " + vatAmount.setScale(2, RoundingMode.HALF_UP));
        System.out.println("Total Net Sales: " + totalNetValue.setScale(2, RoundingMode.HALF_UP));
        System.out.println("Total VAT Amount: " + totalVatAmount.setScale(2, RoundingMode.HALF_UP));
        System.out.println("Total Gross Value: " + totalGrossValue.setScale(2, RoundingMode.HALF_UP));
    }
}