package com.udacity.course3.lesson1.exercise1.exercise1;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

import org.flywaydb.core.Flyway;

public class Application {

    public static void main(String[] args) {
        try {
            // STEP 1: Create the JDBC URL for JDND-C3 database
            String JDBC_URL = "jdbc:mysql://localhost/JDNDC3" + "?user=rchint1&password=password"
                    + "&useUnicode=true&useJDBCCompliantTimezoneShift=true"
                    + "&useLegacyDatetimeCode=false&serverTimezone=UTC";

            // STEP 2: Setup and Run Flyway migration that creates the member table using
            // its Java API
            // https://flywaydb.org/getstarted/firststeps/api#integrating-flyway
            // Note the above link talks about connecting to H2 database, for this exercise,
            // MySQL is used. Adapt the code accordingly.
            Flyway flyway = Flyway.configure().dataSource(JDBC_URL, null, null).load();
            // Start the migration
            flyway.baseline();
            flyway.migrate();

            // STEP 3: Obtain a connection to the JDND-C3 database
            try (Connection conn = DriverManager.getConnection(JDBC_URL)) {
                System.out.println("Connected to " + conn.getMetaData().getDatabaseProductName());

                // STEP 4: Use Statement to INSERT 2 records into the member table
                // NOTE: The member table is created using Flyway by placing the migration file
                // in src/main/resources/db/migration
                String insertTableSQL = "INSERT INTO MEMBER (ID, NAME) VALUES (?,?)";
                try (PreparedStatement ps = conn.prepareStatement(insertTableSQL)) {
                    ps.setInt(1, 100);
                    ps.setString(2, "jdoe");
                    ps.executeUpdate();
                }

                // STEP 5: Read ALL the rows from the member table and print them here
                try (Statement stmt = conn.createStatement()) {
                    ResultSet rs = stmt.executeQuery("select * from MEMBER");
                    while (rs.next()) {
                        int memberId = rs.getInt("ID");
                        String name = rs.getString("NAME");
                        // STEP 6: verify that all inserted rows have been printed
                        System.out.println("Member ID : " + memberId);
                        System.out.println("Name : " + name);
                    }
                }
            }

        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

}