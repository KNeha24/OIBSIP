import java.util.*;

class OnlineExam{
    HashMap<String,Integer> loginto=new HashMap<>();
    public static String userID;
    Scanner sc=new Scanner(System.in);
    
    public void login()
    {
    	System.out.println("---------------- WELCOME TO ONLINE EXAM SYSTEM ----------------");
        System.out.print("Enter User-Id: ");
        userID = sc.next();
        System.out.print("Enter Password: ");
        int password = sc.nextInt();
        loginto.put("Neha",12345);
        loginto.put("Saanvi",67890);
        loginto.put("Sahasra",12312);
        
        if (loginto.containsKey(userID) && loginto.get(userID) == password)
        {
            System.out.println("\n" + "LOGIN SUCCESSFULLY...!");
            homepage();
        }
        else{
            System.out.println("\n" + "Invalid login credentials.!!! Please try again...");
            login();
        }
    }
    
    public void homepage()
    {
        System.out.println("-----------------------------------------------------");
        System.out.println("Online Examination System ---> Welcome " + OnlineExam.userID + "!");
        System.out.println("-----------------------------------------------------");
        System.out.println("Select 1 to Update password...");
        System.out.println("Select 2 to Start the test...");
        System.out.println("Select 3 to Logout...");
        System.out.println("-----------------------------------------------------");
        System.out.print("Select Option: ");
        int sp=sc.nextInt();
        switch(sp){
            case 1: 
            	loginto = update();
            	homepage();
            	break;
            case 2: 
            	solve();
            	homepage();
            	break;
            case 3: 
                System.out.println("\n" + "Logout Successfully...!");
                System.out.println("Thank You for Attending the Test...");
                System.out.println("-----------------------------------------------------");
            	System.exit(0);
            	break;
            default: 
            	System.out.println("\n" + "Invalid Option Choice.! Try again...");
            	homepage();
            	break;
        }
    }
    
    public HashMap<String,Integer> update()
    {
        Scanner sc=new Scanner(System.in);
        System.out.println("\n------------------ UPDATE PASSWORD ------------------");
        System.out.print("Enter Username: ");
        String uid = sc.nextLine();
        System.out.print("Enter Old Password: ");
        int pass = sc.nextInt();
        if(loginto.containsKey(uid))
        {
            if(pass == loginto.get(uid))
            {
                System.out.println("Old Password Verified...");
                while(true)
                {
                    System.out.print("\n" + "Enter New Password: ");
                    int newpass = sc.nextInt();
                    System.out.print("ReEnter/Verify New Password: ");
                    int connewpass = sc.nextInt();
                    if(connewpass == newpass)
                    {
                        System.out.println("Password matched...");
                        loginto.replace(uid,newpass);
                        System.out.println("\n" + "Password Update Successfully...!");
                        break;
                    }
                    else{
                        System.out.println("\n" + "Password did't match.!!! Please try again...");
                        System.out.println("-----------------------------------------------------");
                    }
                }
            }
            else{
                System.out.println("\n" + "Wrong Password.!!! Try again later...");
                update();
            }
        }
        else
        {
            System.out.println("\n" + "User does not exist...");
            System.out.println("Profile Update Failed.!");
        }
        return loginto;
    }
    
    public void solve(){
        long start = System.currentTimeMillis();
        long terminate = start + 60 * 1000;
        int score = 0;
        int c = 0, w = 0;
        char ans;
        System.out.println("\n\n----------------- STARTING THE TEST -----------------");
        System.out.println("You have 1 Minute to answer each question. Select the options wisely... ");
        System.out.println("Each question gives +5 marks for a correct answer and -1 mark for a wrong answer.");
        System.out.println("All the very best.!!");
        
        while(System.currentTimeMillis() < terminate)
        {
            System.out.println("----------------------------------------------------------------------------------------");
            System.out.println("(Coding)-Q1. Which of the following is not a Java features?");
            System.out.println("\n" + "Options ---> ");
            System.out.println("a. Dynamic\nb. Architecture Neutral\nc. Use of pointers\nd. Object-oriented");
            System.out.print("\n" + "Answer: ");
            ans = sc.next().charAt(0);
            if(ans == 'c')
            {
                c += 1;
            }
            else
                w += 1;
            
            System.out.println("----------------------------------------------------------------------------------------");
            System.out.println("(Coding)-Q2. Evaluate the following Java expression, if x=3, y=5, and z=10:\n ++z + y - y + z + x++");
            System.out.println("\n" + "Options ---> ");
            System.out.println("a. 24\nb. 23\nc. 20\nd. 25");
            System.out.print("\n" + "Answer: ");
            ans = sc.next().charAt(0);
            if(ans == 'd')
            {
                c += 1;
            }
            else
                w += 1;
            
            System.out.println("----------------------------------------------------------------------------------------");
            System.out.println("(Coding)-Q3. Which of the following creates a List of 3 visible items and multiple selections abled?");
            System.out.println("\n" + "Options ---> ");
            System.out.println("a. new List(false, 3)\nb. new List(3, true)\nc. new List(true, 3)\nd. new List(3, false)");
            System.out.print("\n" + "Answer: ");
            ans = sc.next().charAt(0);
            if(ans == 'b'){
                c += 1;
            }
            else
                w += 1;
            
            System.out.println("----------------------------------------------------------------------------------------");
            System.out.println("(Coding)-Q4. What does the expression float a = 35 / 0 return?");
            System.out.println("\n" + "Options ---> ");
            System.out.println("a. 0\nb. Not a Number\nc. Infinity\nd. Run time exception");
            System.out.print("\n" + "Answer: ");
            ans = sc.next().charAt(0);
            if(ans == 'c')
            {
                c += 1;
            }
            else
                w += 1;
            
            System.out.println("----------------------------------------------------------------------------------------");
            System.out.println("(Aptitude)-Q5. What is the return type of the hashCode() method in the Object class?");
            System.out.println("\n" + "Options ---> ");
            System.out.println("a. int\nb. Object\nc. long\nd. void ");
            System.out.print("\n" + "Answer: ");
            ans = sc.next().charAt(0);
            if(ans == 'a') 
            {
                c += 1;
            }
            else
                w += 1;
            break;
        }
        
        System.out.println("\n" + "Test Completed.!");
        score = ((c * 5) - w);
        System.out.println("Number of correct answers: " + c);
        System.out.println("Congratulations!! Your scored " + score + " points...");
    }
    
    public static void main(String args[]){
    	OnlineExam exam = new OnlineExam();
        exam.login();
    }
}