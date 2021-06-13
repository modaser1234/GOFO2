package GOFO;

import java.util.Scanner;

public class Main {


    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);
        int mainMenuChoice = 0;
        while(mainMenuChoice != 3)
        {
            System.out.println("Welcome to GOFO");
            System.out.println("1- Register new account");
            System.out.println("2- login to your account");
            System.out.println("3- Exit");
            mainMenuChoice = input.nextInt();
            switch(mainMenuChoice)
            {
                //Main Menu -> Register new account
                case 1:
                {
                    System.out.println("1- Player account");
                    System.out.println("2- Playground owner account");
                    System.out.println("3- Go back to Main Menu");
                    int accountChoice = input.nextInt();
                    switch(accountChoice)
                    {
                        //Register -> player account
                        case 1:
                        {
                            Player player = new Player();
                            System.out.println("Enter your name:");
                            player.setName(input.next());
                            System.out.println("Enter your e-mail:");
                            player.setEmail(input.next());
                            System.out.println("Enter password for account:");
                            player.setPassword(input.next());
                            System.out.println("Enter your phone number:");
                            player.setPhone(input.next());
                            System.out.println("Enter your address:");
                            player.setAddress(input.next());
                            //add the account to the system
                            SystemData.players.add(player);
                            System.out.println("Account registered successfully.");
                            System.out.println("-----------------------------------");
                            break;
                        }
                        //Register -> owner account
                        case 2:
                        {
                            PlaygroundOwner owner = new PlaygroundOwner();
                            System.out.println("Enter your name:");
                            owner.setName(input.next());
                            System.out.println("Enter your e-mail:");
                            owner.setEmail(input.next());
                            System.out.println("Enter password for account:");
                            owner.setPassword(input.next());
                            System.out.println("Enter your phone number:");
                            owner.setPhone(input.next());
                            System.out.println("Enter your address:");
                            owner.setAddress(input.next());
                            //add the account to the system
                            SystemData.owners.add(owner);
                            System.out.println("Account registered successfully.");
                            System.out.println("-----------------------------------");
                            break;
                        }
                        default:
                            break;
                    }
                    break;
                }
                //Main Menu -> login to your account
                case 2:
                {
                    System.out.println("1- Player account");
                    System.out.println("2- Playground owner account");
                    System.out.println("3- Go back to Main Menu");
                    int accountChoice = input.nextInt();
                    switch(accountChoice)
                    {
                        //Login -> player account
                        case 1:
                        {
                            System.out.println("Enter your e-mail:");
                            String email = input.next();
                            System.out.println("Enter your password:");
                            String pass = input.next();
                            boolean isValid = false;
                            int playerIndex = 0;
                            for(int i = 0; i < SystemData.players.size(); i++)
                            {
                                if (SystemData.players.get(i).getEmail().equals(email) && SystemData.players.get(i).getPassword().equals(pass))
                                {
                                    playerIndex = i;
                                    isValid = true;
                                    break;
                                }
                            }
                            if(!isValid)
                            {
                                System.out.println("Wrong email or password.");
                                break;
                            }
                            System.out.println("logged in successfully.");
                            System.out.println("------------------------------");

                            int playerMenuChoice = 0;
                            while(playerMenuChoice != 5)
                            {
                                //Player Menu
                                System.out.println("->Player Menu<-");
                                System.out.println("1- Book a playground");
                                System.out.println("2- Withdraw from eWallet");
                                System.out.println("3- Add credits to eWallet");
                                System.out.println("4- View your balance in eWallet");
                                System.out.println("5- Logout to Main Menu");
                                playerMenuChoice = input.nextInt();
                                switch(playerMenuChoice)
                                {
                                    //Player account -> book a playground
                                    case 1:
                                    {
                                        SystemData.players.get(playerIndex).bookPlayground();
                                        break;
                                    }
                                    //Player account -> withdraw from eWallet
                                    case 2:
                                    {
                                        System.out.println("Enter amount of money:");
                                        SystemData.players.get(playerIndex).withdraw(input.nextDouble());
                                        break;
                                    }
                                    //Player account -> Add credits to eWallet
                                    case 3:
                                    {
                                        System.out.println("Enter amount of money:");
                                        SystemData.players.get(playerIndex).addCredits(input.nextDouble());
                                        break;
                                    }
                                    //Player account -> View balance
                                    case 4:
                                    {
                                        System.out.println("Your balance is: " + SystemData.players.get(playerIndex).getBalance());
                                        break;
                                    }
                                    //Player account -> exit
                                    case 5:
                                        break;
                                    //Player account -> *wrong input*
                                    default:
                                        System.out.println("Invalid choice!");
                                        break;
                                }
                            }


                            break;
                        }
                        //Login -> owner account
                        case 2:
                        {
                            System.out.println("Enter your e-mail:");
                            String email = input.next();
                            System.out.println("Enter your password:");
                            String pass = input.next();
                            boolean isValid = false;
                            int ownerIndex = 0;
                            for(int i = 0; i < SystemData.owners.size(); i++)
                            {
                                if (SystemData.owners.get(i).getEmail().equals(email) && SystemData.owners.get(i).getPassword().equals(pass))
                                {
                                    ownerIndex = i;
                                    isValid = true;
                                    break;
                                }
                            }
                            if(!isValid)
                            {
                                System.out.println("Wrong email or password.");
                                break;
                            }
                            System.out.println("logged in successfully.");
                            System.out.println("------------------------------");

                            int ownerMenuChoice = 0;
                            while(ownerMenuChoice != 5)
                            {
                                //Playground Owner Menu
                                System.out.println("->Playground Owner Menu<-");
                                System.out.println("1- Add a playground");
                                System.out.println("2- Withdraw from eWallet");
                                System.out.println("3- Add credits to eWallet");
                                System.out.println("4- View your balance in eWallet");
                                System.out.println("5- Logout to Main Menu");
                                ownerMenuChoice = input.nextInt();
                                switch(ownerMenuChoice)
                                {
                                    //owner account -> add a playground
                                    case 1:
                                    {
                                        SystemData.owners.get(ownerIndex).addPlayground();
                                        break;
                                    }
                                    //owner account -> withdraw from eWallet
                                    case 2:
                                    {
                                        System.out.println("Enter amount of money:");
                                        SystemData.owners.get(ownerIndex).withdraw(input.nextDouble());
                                        break;
                                    }
                                    //owner account -> Add credits to eWallet
                                    case 3:
                                    {
                                        System.out.println("Enter amount of money:");
                                        SystemData.owners.get(ownerIndex).addCredits(input.nextDouble());
                                        break;
                                    }
                                    //Player account -> View balance
                                    case 4:
                                    {
                                        System.out.println("Your balance is: " + SystemData.owners.get(ownerIndex).getBalance());
                                        break;
                                    }
                                    //Player account -> exit
                                    case 5:
                                        break;
                                    //Player account -> *wrong input*
                                    default:
                                        System.out.println("Invalid choice!");
                                        break;
                                }
                            }
                            break;
                        }
                        default:
                            break;
                    }
                    break;
                }
                //Main Menu -> Exit
                case 3:
                    break;
                //Main Menu -> *wrong input*
                default:
                    System.out.println("Invalid choice!");
                    break;
            }
        }

    }

}
