import java.sql.*;
import java.util.Arrays;
import java.util.Scanner;

public class Main {
    private static final int maxN = 20;

    public static void main(String[] args){
        Section[] list = new Section[maxN];
        boolean running = true;

        while(running) {
            System.out.print("\nEnter course prefix(Such as CSC or FRE) or enter q to quit: ");
            Scanner input = new Scanner(System.in);
            String discipline = input.nextLine().trim();
            if(discipline.equalsIgnoreCase("q"))
                System.exit(0);
            int n = getSelection(list, discipline, maxN);

            Arrays.sort(list, 0, n);

            if (n == 0)
                System.out.printf("No courses have the prefix \"%s\".\n", discipline);
            else {
                System.out.printf("\n%-10s %-7s %-30s  %-20s %-3s\n", "Course Id", "CRN", "Title", "Instructor", "seats available");
                print(list, n);
            }
        }

    }
    public static int getSelection(Section[] list, String discipline, int n){
        int numberRead = 0;
        String host = "jdbc:mysql://turing.cs.missouriwestern.edu:3306/schedule2";
        String user = "csc254";
        String password="age126";

        Connection conn;
        Statement stmt;
        ResultSet rs;

        String queryString =
                "SELECT courseId, crn, title, instructor, seatsAvailable FROM sections WHERE discipline LIKE ";
        queryString += String.format("'%s' LIMIT %d", discipline, n);

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
                list[numberRead] = new Section(courseId,crn,title,instructor,seatsAvailable);
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
    public static <T>void print(T[] list, int n){
        for(int i = 0; i < n; i++){
            System.out.println(list[i]);
        }
    }
}
