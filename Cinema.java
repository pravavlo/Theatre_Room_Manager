
import java.util.Scanner;
public class Cinema {
    static int rows;
    static int seats;// acts as columns.
    static char[][] arr;
    static Scanner scanner = new Scanner(System.in);
    static int rowNum;// this is for selection number of rows or certain rows in totalrows
    static int seatsNum;// this is for selection of certain column in totalcolumn or seats
    static int income;
    static int front,back;
    static float percent;
    static int currentPrice=0;
    static float totalSpace;
        public static void takeInputNum() {
            System.out.println("Enter the number of rows:");
            rows = scanner.nextInt();
            System.out.println("Enter the number of seats in each row:");
            seats = scanner.nextInt();
            System.out.println();
        }

        public static void showSeats() {
            System.out.println("Cinema:");
            System.out.print("  ");
            for (int i = 1; i <= seats; i++) {
                System.out.print(i + " ");
            }
            System.out.println();
            for (int i = 1; i <= rows; i++) {
                System.out.print(i + " ");
                for (int j = 1; j <= seats; j++) {
                    System.out.print(arr[i - 1][j - 1] + " ");
                }
                System.out.println();
            }
            System.out.println();
        }

        public static void buyTicket() {
            System.out.println("Enter a row number:");
            rowNum = scanner.nextInt();
            System.out.println("Enter a seat number in that row:");
            seatsNum = scanner.nextInt();
            System.out.println();
            try {
                if (arr[rowNum - 1][seatsNum - 1] == 'B') {
                    System.out.println("That ticket has already been purchased");
                    buyTicket();
                } else {
                    arr[rowNum - 1][seatsNum - 1] = 'B';
                    if (seats * rows < 60) {
                        System.out.println("Ticket price: $10");
                    } else {
                        if (rowNum <= rows / 2) {
                            System.out.println("Ticket price: $10");
                            currentPrice=currentPrice+10;
                        } else {
                            System.out.println("Ticket price: $8");
                            currentPrice=currentPrice+8;
                        }
                    }
                    System.out.println();
                }
            }
            catch(ArrayIndexOutOfBoundsException exception) {
                System.out.println("Wrong input!");
                buyTicket();
            }
        }
    public static int totalIncome() {
        if(seats * rows < 60){
            income = seats * rows * 10;
        } else if (rows % 2 == 0) {
            front = rows / 2;
            back = front;
            income= (front * 10 * seats) + (back * 8* seats);
        } else {
            front =rows / 2;
            back = front + 1;
            income = (front * 10 * seats) + (back * 8 * seats);
        }
        return income;
    }
        public static int numberOfPurchasedTickets(){
            int counter=0;
            for(char[] ticketsPurchased: arr){
                for(char val: ticketsPurchased){
                    if(val=='B') counter++;
                }
             }
            return counter;
        }
            public static int CurrentIncome(){
//              its calculation is in buyTicket() method...
                return currentPrice;
            }

            public static float percentage(){
            totalSpace= rows*seats;
            percent = (numberOfPurchasedTickets()/totalSpace) *100;
            return percent;
            }

            public static void statistics() {
            if (rowNum == 0 && seatsNum == 0){
                System.out.println("Number of purchased tickets:" + 0);
                System.out.printf("Percentage: %.2f%%\n", 0.00);
                System.out.println("Current Income: $" + 0);

            }else{
            System.out.printf("Number of purchased tickets: %d%n", numberOfPurchasedTickets());
            System.out.printf("Percentage: %.2f%%%n", percentage());
            System.out.printf("Current income: $%d%n", CurrentIncome());
            }
                System.out.printf("Total income: $%d%n", totalIncome());
            }

        public static void main(String[] args){
            Scanner scanner = new Scanner(System.in);
            takeInputNum();
            arr = new char[rows][seats];
            for (int i = 0; i < rows; i++) {
                for (int j = 0; j < seats; j++) {
                    arr[i][j] = 'S';
                }
            }

            while (true) {
                System.out.println("1. Show the seats \n2. Buy a ticket \n3. Statistics  \n0. Exit");
                int selectNum = scanner.nextInt();
                System.out.println();
                if (selectNum == 1) {
                    showSeats();
                } else if (selectNum == 2) {
                    buyTicket();
                } else if (selectNum == 3) {
                    statistics();
                } else if (selectNum == 0) {
                    break;
                }
            }
        }
    }
