package main;

import model.Account;
import model.Amount;
import model.Client;
import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author ignac
 */

public class Bank {

    static Scanner sc = new Scanner(System.in);
    static ArrayList<Account> accounts = new ArrayList<>();

    public static void setUp(ArrayList<Account> accounts) {
        System.out.println(" BIENVENIDO A IGNACIO-BANK :)");
        

        for (int i = 0; i < 2; i++) {

            System.out.println("Creacion de la cuenta " + (i + 1));

            System.out.print("Introduce el nombre del titular: ");
            String name = sc.nextLine();

            System.out.print("Introduce el saldo inicial: ");
            double money = sc.nextDouble();
            sc.nextLine(); 

            System.out.print("el usuario es VIP? (true / false): ");
            boolean vip = sc.nextBoolean();
            sc.nextLine(); 

            System.out.print("Introduce la moneda de la cuenta: ");
            String currency = sc.nextLine();

            Client client = new Client(name, vip);
            Amount amount = new Amount(money, currency);

            Account account = new Account(i + 1, name, vip, money, currency);
            account.setHolder(client);
            account.setBalance(amount);

            accounts.add(account);

            System.out.println("Cuenta creada correctamente.");
        }
    }

    public static void main(String[] args) {

        int opcion;

        setUp(accounts);

        do {
            mostrarMenu();
            opcion = sc.nextInt();
            sc.nextLine();

            switch (opcion) {
                case 1 -> consultarSaldo();
                case 2 -> ingresarDinero();
                case 3 -> sacarDinero();
                case 4 -> realizarTransferencia();
                case 5 -> salir();
                default -> System.out.println("Opcion no valida.");
            }
        } while (opcion != 5);
    }

    public static void mostrarMenu() {
        System.out.println("MENU PRINCIPAL ");
        System.out.println("1. Consultar saldo");
        System.out.println("2. Ingresar dinero");
        System.out.println("3. Sacar dinero");
        System.out.println("4. Realizar transferencia");
        System.out.println("5. Salir");
        System.out.print("Seleccione una opcion: ");
    }

    public static void consultarSaldo() {

        System.out.println("CONSULTAR SALDO");
        System.out.print("Introduce el nombre del titular: ");
        String holder = sc.nextLine();

        Account account = findAccountHolder(holder);

        if (account != null) {
            Amount balance = account.getBalance();
            System.out.println("Saldo actual: "
                    + balance.getMoney() + " " + balance.getCurrency());
        } else {
            System.out.println("ERROR: No se ha encontrado la cuenta.");
        }
    }

    public static void ingresarDinero() {

        System.out.println("INGRESAR DINERO ");
        System.out.print("Introduce el nombre del titular: ");
        String holder = sc.nextLine();

        Account account = findAccountHolder(holder);

        if (account != null) {
            Amount balance = account.getBalance();

            System.out.println("Saldo actual: "
                    + balance.getMoney() + " " + balance.getCurrency());

            System.out.print("Introduce la cantidad a ingresar: ");
            double money = sc.nextDouble();
            sc.nextLine();

            if (money > 0) {
                balance.setMoney(balance.getMoney() + money);
                System.out.println("Ingreso realizado correctamente.");
                System.out.println("Nuevo saldo: "
                        + balance.getMoney() + " " + balance.getCurrency());
            } else {
                System.out.println("ERROR: La cantidad debe ser positiva.");
            }

        } else {
            System.out.println("ERROR: No se ha encontrado la cuenta.");
        }
    }

    public static void sacarDinero() {

        System.out.println("SACAR DINERO");
        System.out.print("Introduce el nombre del titular: ");
        String holder = sc.nextLine();

        Account account = findAccountHolder(holder);

        if (account != null) {
            Amount balance = account.getBalance();

            System.out.println("Saldo actual: "
                    + balance.getMoney() + " " + balance.getCurrency());

            System.out.print("Introduce la cantidad a retirar: ");
            double money = sc.nextDouble();
            sc.nextLine();

            if (money > 0) {
                if (balance.getMoney() >= money) {
                    balance.setMoney(balance.getMoney() - money);
                    System.out.println("Retirada realizada correctamente.");
                    System.out.println("Nuevo saldo: "
                            + balance.getMoney() + " " + balance.getCurrency());
                } else {
                    System.out.println("ERROR: Saldo insuficiente.");
                }
            } else {
                System.out.println("ERROR: La cantidad debe ser positiva.");
            }

        } else {
            System.out.println("ERROR: No se ha encontrado la cuenta.");
        }
    }

    public static void realizarTransferencia() {

        System.out.println("REALIZAR TRANSFERENCIA ");

        System.out.print("Introduce el nombre del titular ORIGEN: ");
        String holderOrigin = sc.nextLine();

        Account accountOrigin = findAccountHolder(holderOrigin);
        if (accountOrigin == null) {
            System.out.println("ERROR: La cuenta origen no existe.");
            return;
        }

        System.out.print("Introduce el nombre del titular DESTINO: ");
        String holderDestination = sc.nextLine();

        Account accountDestination = findAccountHolder(holderDestination);
        if (accountDestination == null) {
            System.out.println("ERROR: La cuenta destino no existe.");
            return;
        }

        Amount balanceOrigin = accountOrigin.getBalance();
        Amount balanceDestination = accountDestination.getBalance();

        if (!balanceOrigin.getCurrency().equals(balanceDestination.getCurrency())) {
            System.out.println("ERROR: Las cuentas usan monedas distintas.");
            return;
        }

        System.out.println("Saldo actual de " + holderOrigin + ": "
                + balanceOrigin.getMoney() + " " + balanceOrigin.getCurrency());

        System.out.print("Introduce la cantidad a transferir: ");
        double money = sc.nextDouble();
        sc.nextLine();

        if (money > 0) {
            if (balanceOrigin.getMoney() >= money) {
                balanceOrigin.setMoney(balanceOrigin.getMoney() - money);
                balanceDestination.setMoney(balanceDestination.getMoney() + money);

                System.out.println("Transferencia realizada correctamente.");
                System.out.println("Nuevo saldo de " + holderOrigin + ": "
                        + balanceOrigin.getMoney() + " " + balanceOrigin.getCurrency());
                System.out.println("Nuevo saldo de " + holderDestination + ": "
                        + balanceDestination.getMoney() + " " + balanceDestination.getCurrency());
            } else {
                System.out.println("ERROR: Saldo insuficiente en la cuenta origen.");
            }
        } else {
            System.out.println("ERROR: La cantidad debe ser positiva.");
        }
    }

    public static void salir() {
        System.out.println("Saliendo del programa. Gracias por usar Ignacio-Bank.");
    }

    public static Account findAccountHolder(String holderName) {
        for (Account account : accounts) {
            if (account.getHolder() != null
                    && account.getHolder().getName().equalsIgnoreCase(holderName)) {
                return account;
            }
        }
        return null;
    }
}