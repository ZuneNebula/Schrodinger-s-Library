package comp3350.schrodingers.presentation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Locale;

import comp3350.schrodingers.business.AccessPaymentInfo;
import comp3350.schrodingers.business.AccessBooks;
import comp3350.schrodingers.business.AccessUserInfo;
import comp3350.schrodingers.objects.User;
import comp3350.schrodingers.objects.User.Billing;
import comp3350.schrodingers.objects.User.Address;
import comp3350.schrodingers.objects.Book;


public class CLI  // command-line interface
{
    public static BufferedReader console;
    public static String inputLine;
    public static String[] inputTokens;

    public static User currentUser;
    public static Billing currentCard;

    public static String userEmail;
    public static long cardNum;


    public static String indent = "  ";

    public static void run() {
        try {
            console = new BufferedReader(new InputStreamReader(System.in));
            process();
            console.close();
        } catch (IOException ioe) {
            System.out.println(ioe.getMessage());
            ioe.printStackTrace();
        }
    }

    public static void process() {
        readLine();
        while ((inputLine != null) && (!inputLine.equalsIgnoreCase("exit"))
                && (!inputLine.equalsIgnoreCase("quit"))
                && (!inputLine.equalsIgnoreCase("q"))
                && (!inputLine.equalsIgnoreCase("bye"))) {    // use cntl-c or exit to exit
            inputTokens = inputLine.split("\\s+");
            parse();
            readLine();
        }
    }

    public static void readLine() {
        try {
            System.out.print(">");
            inputLine = console.readLine();
        } catch (IOException ioe) {
            System.out.println(ioe.getMessage());
            ioe.printStackTrace();
        }
    }

    public static void parse() {
        if (inputTokens[0].equalsIgnoreCase("get")) {
            processGet();
        } else {
            System.out.println("Invalid command.");
        }
    }

    public static void processGet() {
        if (inputTokens[1].equalsIgnoreCase("User")) {
            processGetUser();
        } else if (inputTokens[1].equalsIgnoreCase("Payment")) {
            processGetPayment();
        } else {
            System.out.println("Invalid data type");
        }
    }

    public static void processGetUser() {
        AccessUserInfo accessUserInfo;
        accessUserInfo = new AccessUserInfo();
        if(inputTokens.length>2){
            if(inputTokens[2].equalsIgnoreCase("orphan")){
                System.out.println(accessUserInfo.getUser().getUserName());
            }
        }
    }

    public static void processGetPayment() {
        AccessPaymentInfo accessPayInfo;
        accessPayInfo = new AccessPaymentInfo();
        if(inputTokens.length>2){
            if(inputTokens[2].equalsIgnoreCase("orphan")){
                System.out.println(accessPayInfo.getCard());
            }
        }
    }


}