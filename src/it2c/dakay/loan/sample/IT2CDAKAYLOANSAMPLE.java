
package it2c.dakay.loan.sample;


import java.util.Scanner;


public class IT2CDAKAYLOANSAMPLE {


    
      public void addApplicant(){
        Scanner sc = new Scanner(System.in);
        config conf = new config();
        System.out.print("First Name: ");
        String fname = sc.next();
         System.out.print("Last Name: ");
        String lname = sc.next();
        System.out.print("Age: ");
        String age = sc.next();
        System.out.print("Status (Employed,Unemployed): ");
        String status = sc.next();
        System.out.print("Monthly income: ");
        String monthlyincome = sc.next();

        String sql = "INSERT INTO tbl_applicant (a_fname, a_lname, a_age, a_status, a_monthlyincome) VALUES (?, ?, ?, ?, ?)";


        conf.addRecord(sql, fname, lname, age, status, monthlyincome);


    }
         
    public static void main(String[] args) {
        Scanner sc = new Scanner (System.in);
        String response;
       
        do{
            System.out.println("\n1. Add Person");
            System.out.println("2. View Persons");
            System.out.println("3. Update Person");
            System.out.println("4. Delete Person");
            System.out.println("5. Back to Main Menu");
            System.out.print("\nChoose an option: ");
           
            System.out.print("\n Enter Action: ");
            int action = sc.nextInt();
            IT2CDAKAYLOANSAMPLE demo = new IT2CDAKAYLOANSAMPLE();
         
          switch(action){
                
                case 1:    
                demo.addApplicant();            
                break;
                
                case 2:
                demo.viewApplicant();
                    break;
                case 3:
                demo.viewApplicant();
                demo.updateApplicant();
                break;
                case 4:
                demo.viewApplicant();
                demo.deleteApplicant(); 
                demo.viewApplicant();
                break;
           
        
            }
            System.out.print("continue (YES/NO): ");
    response = sc.next();
    
        }while(response.equals("yes"));
        System.out.println("thank you . see you again ");
        
    }
    
 
    
    

private void viewApplicant() {
        String aqry = "SELECT * FROM tbl_applicant";
        String[] hrds = {"ID", "FIRST Name", "LAST NAME", "AGE", "STATUS", "MONTHLY INCOME"};
        String[] clmns = {"a_id", "a_fname", "a_lname", "a_age", "a_status", "a_monthlyincome"};
        config conf = new config();
        conf.viewRecords(aqry, hrds, clmns);
    }



   private void updateApplicant(){
   Scanner sc = new Scanner(System.in);
   
   System.out.print("Enter Applicant ID: ");
   int id = sc.nextInt();
    
      System.out.print("Enter new first name: ");
      String ufname = sc.next();
    
      System.out.print("Enter new last name: ");
      String ulname = sc.next();
      
      System.out.print("Enter new age: ");
      String uage = sc.next();
    
     System.out.print("new Status (Employed,Unemployed): ");
     String ustatus = sc.next();
        
     System.out.print("new Monthly income: ");
     String umonthlyincome = sc.next();
      
      
      String qry = "UPDATE tbl_applicant SET a_fname = ?, a_lname = ?, a_age = ?, a_status = ?, a_monthlyincome = ? WHERE a_id = ? ";
    
   config conf = new config();
   conf.updateRecord(qry, ufname, ulname, uage, ustatus, umonthlyincome, id);
   
   
   
   }
   
   
   
   
  private void deleteApplicant(){

       Scanner sc = new Scanner(System.in);
   System.out.print("Enter Applicant ID to delete: ");
   int id = sc.nextInt(); 
   
   String sqlDelete = "DELETE FROM tbl_applicant WHERE a_id = ?";
   config conf = new config();
   conf.deleteRecord(sqlDelete, id);
    }
  
  
  
  
  
  
  
} 
   
   
   
   