import java.util.Scanner;


public class DepositCalculate {
    double calculateComplexPercent(double amount, double yearRate, int depositPeriod) {

        double pay = amount * Math.pow((1 + yearRate / 12), 12 * depositPeriod);
        return roundAvoid(pay, 2);
    }

    double calculateSimplePercent(double amount, double yearRate, int depositPeriod) {

        double pay = amount + amount * yearRate * depositPeriod;
        return roundAvoid(pay, 2);
    }

    double roundAvoid(double value, int places) {
        double scale = Math.pow(10, places);
        return Math.round(value * scale) / scale;
    }

    public void calculatePercentOnDeposit() {
        int period;
        int typeDeposit;
        double accruedPercent = 0;

        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите сумму вклада в рублях:");
        int amount = scanner.nextInt();
        System.out.println("Введите срок вклада в годах:");
        period = scanner.nextInt();
        System.out.println("Выберите тип вклада, 1 - вклад с обычным процентом, 2 - вклад с капитализацией:");
        typeDeposit = scanner.nextInt();

        if (typeDeposit == 1) {
            accruedPercent = calculateSimplePercent(amount, 0.06, period);
        } else if (typeDeposit == 2) {
            accruedPercent = calculateComplexPercent(amount, 0.06, period);
        }

        System.out.println("Результат вклада: " + amount + " за " + period + " лет превратятся в " + accruedPercent);
    }

    public static void main(String[] args) {
        new DepositCalculate().calculatePercentOnDeposit();
    }


}
