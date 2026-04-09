package org.tron.demo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

/**
 * This is a DEMO file to test AI security audit.
 * It contains intentional security issues for testing purposes only.
 * DO NOT use in production.
 */
public class SecurityTestDemo {

    // Hardcoded credentials (security issue)
    private static final String DB_PASSWORD = "admin123456";
    private static final String PRIVATE_KEY = "aabbccdd11223344aabbccdd11223344aabbccdd11223344aabbccdd11223344";

    // SQL injection vulnerability (security issue)
    public void queryUser(String userId) throws Exception {
        Connection conn = DriverManager.getConnection("jdbc:mysql://localhost/test", "root", DB_PASSWORD);
        Statement stmt = conn.createStatement();
        String sql = "SELECT * FROM users WHERE id = '" + userId + "'";
        stmt.executeQuery(sql);
    }

    // Command injection vulnerability (security issue)
    public void checkAddress(String address) throws Exception {
        Runtime.getRuntime().exec("curl http://api.trongrid.io/v1/accounts/" + address);
    }

    // Insecure random for key generation (security issue)
    public String generateToken() {
        java.util.Random random = new java.util.Random();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < 32; i++) {
            sb.append(Integer.toHexString(random.nextInt(16)));
        }
        return sb.toString();
    }
}
