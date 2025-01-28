import java.util.Scanner;

public class SafeInputObj {
    private Scanner pipe;

    /**
     * Default constructor that uses System.in as the input pipe
     */
    public SafeInputObj() {
        this.pipe = new Scanner(System.in);
    }

    /**
     * Constructor that uses a Scanner instance as the input pipe
     * @param pipe - Scanner instance to read the data System.in in most cases
     */
    public SafeInputObj(Scanner pipe) {
        this.pipe = pipe;
    }

    /**
     * Get a string that is not zero length
     * @param prompt - prompt for user
     * @return a non-zero length string
     */
    public String getNonZeroLenString(String prompt) {
        String retString = "";
        do
        {
            System.out.print("\n" + prompt + ": ");
           retString = pipe.nextLine();
        }while(retString.length() == 0); // until we have some characters
       
        return retString;
    }
    /**
     * Get an int value within a specified numeric range
     * @param prompt - input prompt msg should not include range info
     * @param low - low end of inclusive range
     * @param high - high end of inclusive range
     * @return - int value within the inclusive range
     */
    public int getRangedInt(String prompt, int low, int high)
    {
       int retVal = 0;
       String trash = "";
       boolean done = false;
       
       do
       {
           System.out.print("\n" + prompt + "[" + low + "-" + high + "]: ");
           if(pipe.hasNextInt())
           {
               retVal = pipe.nextInt();
               pipe.nextLine();
               if(retVal >= low && retVal <= high)
               {
                  done = true;
               }
               else
               {
                   System.out.println("\nNumber is out of range [" + low + "-" + high + "]: " + retVal);
               }
           }
           else
           {
               trash = pipe.nextLine();
               System.out.println("You must enter an int: " + trash);
           }
       }while(!done);
       
       return retVal;
    }
    /**
     * Get an int value with no constraints
     * @param prompt - input prompt msg should not include range info
     * @return - int value
     */
    public int getInt(String prompt)
    {
       int retVal = 0;
       String trash = "";
       boolean done = false;
       
       do
       {
           System.out.print("\n" + prompt + ": ");
           if(pipe.hasNextInt())
           {
               retVal = pipe.nextInt();
               pipe.nextLine();
               done = true;               
           }
           else
           {
               trash = pipe.nextLine();
               System.out.println("You must enter an int: " + trash);
           }
       }while(!done);
       
       return retVal;
    }
    /**
     * Get a double value within a specified numeric range
     * @param prompt - input prompt msg should not include range info
     * @param low - low end of inclusive range
     * @param high - high end of inclusive range
     * @return - double value within the inclusive range
     */
    public double getRangedDouble( String prompt, double low, double high)
    {
       double retVal = 0;
       String trash = "";
       boolean done = false;
       
       do
       {
           System.out.print("\n" + prompt + "[" + low + "-" + high + "]: ");
           if(pipe.hasNextDouble())
           {
               retVal = pipe.nextDouble();
               pipe.nextLine();
               if(retVal >= low && retVal <= high)
               {
                  done = true;
               }
               else
               {
                   System.out.println("\nNumber is out of range [" + low + "-" + high + "]: " + retVal);
               }
           }
           else
           {
               trash = pipe.nextLine();
               System.out.println("You must enter a double: " + trash);
           }
       }while(!done);
       
       return retVal;
    }
    /**
     * Get a double value with no constraints
     * @param prompt - input prompt msg should not include range info
     * @return - double value
     */
    public double getDouble(String prompt)
    {
       double retVal = 0;
       String trash = "";
       boolean done = false;
       
       do
       {
           System.out.print("\n" + prompt + ": ");
           if(pipe.hasNextDouble())
           {
               retVal = pipe.nextDouble();
               pipe.nextLine();
               done = true;
           }
           else
           {
               trash = pipe.nextLine();
               System.out.println("You must enter a double: " + trash);
           }
       }while(!done);
       
       return retVal;
    }
    /**
     * Get a boolean value from the user
     * @param prompt - input prompt msg should not include range info
     * @return - boolean value
     */
    public boolean getYNConfirm(String prompt)
    {
        boolean retVal = true;
        String response = "";
        boolean gotAVal = false;
        
        do
        {
            System.out.print("\n" + prompt + " [Y/N] ");
            response = pipe.nextLine();
            if(response.equalsIgnoreCase("Y"))
            {
                gotAVal = true;
                retVal = true;
            }
            else if(response.equalsIgnoreCase("N"))
            {
                gotAVal = true;
                retVal = false;
            }
            else
            {
                System.out.println("You must answere [Y/N]! " + response );
            }
            
        }while(!gotAVal);
        
        return retVal;
    }
    /**
     * Get a string that matches a regular expression pattern
     * @param prompt - input prompt msg should not include range info
     * @param regExPattern - regular expression pattern to match
     * @return - string that matches the regular expression pattern
     */
    public String getRegExString(String prompt, String regExPattern)
    {
        String response = "";
        boolean gotAVal = false;
        
        do
        {
            System.out.print("\n" + prompt + ": ");
            response = pipe.nextLine();
            if(response.matches(regExPattern))
            {
                gotAVal = true;                
            }
            else
            {
                System.out.println("\n" + response + " must match the pattern " + regExPattern);
                System.out.println("Try again!");
            } 
            
        }while(!gotAVal);
        
        return response;
    }

}
