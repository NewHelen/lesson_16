package main.lesson16;

public class Main {
    static BankApplication app = new BankApplication();

    final static String EXCEPTION = "java.lang.Exception";
    //WrongAccountException.class.getCanonicalName();

    final static String ACCOUNT_EXCEPTION = "main.lesson16.exceptions.WrongAccountException";
    final static String CURRENCY_EXCEPTION = "main.lesson16.exceptions.WrongCurrencyException";
    final static String OPERATION_EXCEPTION = "main.lesson16.exceptions.WrongOperationException";

    public static void processWrapper(String accountId, int amount, String currency) {

        try {
            app.process(accountId, amount, currency);
        } catch (Exception e) {
            switch (e.getClass().getCanonicalName()) {
                case ACCOUNT_EXCEPTION:
                    System.out.println("Такого акаунту не існує");
                    break;
                case CURRENCY_EXCEPTION:
                    System.out.println("Акаунт має рахунок в іншій валюті");
                    break;
                case OPERATION_EXCEPTION:
                    System.out.println("Акаунт не має достатньо коштів");
                    break;
                case EXCEPTION:
                    System.out.println("Сталася помилка при процесінгу, спробуйте ще раз");
                    break;
            }
        } finally {
            System.out.println("Дякуємо, що скористалися нашим сервісом\n");
        }
    }

    static public void main(String[] args) {

        processWrapper("accountId000", 50, "USD");
        processWrapper("accountId003", 250, "HRV");
        processWrapper("accountId001", 50, "EUR");
        processWrapper("accountId001", 50, "USD");
        processWrapper("accountId001", 200, "USD");

    }
}