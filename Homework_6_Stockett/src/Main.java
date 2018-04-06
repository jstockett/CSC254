import java.sql.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class Main {

    public static void main(String[] args){

        ArrayList<Section> list = new ArrayList<>();

        while(true) {
            System.out.print("Enter course prefix(Such as CSC or FRE) or enter q to quit: ");
            Scanner input = new Scanner(System.in);
            String discipline = input.nextLine().trim();
            if (discipline.equalsIgnoreCase("q"))
                System.exit(0);
            int n = getSelection(list, discipline);

            Collections.sort(list);

            if (n == 0)
                System.out.printf("No courses have the prefix \"%s\".\n\n", discipline);
            else {
                System.out.printf("\n%-10s %-7s %-30s  %-20s %-3s\n", "Course Id", "CRN", "Title", "Instructor", "seats available");
                print(list);
                System.out.println("");
                list.clear();
            }
        }

    }
    public static int getSelection(ArrayList list, String discipline){
        int numberRead = 0;
        String host = "jdbc:mysql://turing.cs.missouriwestern.edu:3306/schedule2";
        String user = "csc254";
        String password="age126";

        Connection conn;
        Statement stmt;
        ResultSet rs;

        String queryString =
                "SELECT courseId, crn, title, instructor, seatsAvailable FROM sections WHERE discipline LIKE ";
        queryString += String.format("'%s'", discipline);

        try {
            conn = DriverManager.getConnection(host, user, password);
            if(conn == null){
                System.out.println("Connection failed");
                System.exit(2);
            }
            stmt = conn.createStatement();
            rs = stmt.executeQuery(queryString);

            while(rs.next()){
                String courseId = rs.getString("courseId");
                String crn = rs.getString("crn");
                String title = rs.getString("title");
                String instructor = rs.getString("instructor");
                int seatsAvailable = rs.getInt("seatsAvailable");
                list.add(new Section(courseId,crn,title,instructor,seatsAvailable));
                numberRead++;
            }


            conn.close();
        } catch (SQLException e) {
            System.err.println(e.getMessage());
            e.printStackTrace();
            System.exit(1);
        }
        return numberRead;

    }
    public static <T>void print(ArrayList<T> list){
        for(T element : list){
            System.out.println(element);
        }
    }
}
