package DAO;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import DTO.AccountDTO;
import DTO.UserDTO;

public class UserDAO {
    private Connection connection;

    // Constructor that takes a Connection parameter
    public UserDAO(Connection connection) {
        this.connection = connection;
    }

    // Method for registering a user
    public boolean registerUser(UserDTO userDTO) throws SQLException {
        String query = "INSERT INTO logindata (name, phone_no, address, email, pass, confirm_pass) VALUES (?, ?, ?, ?, ?, ?)";

        try (PreparedStatement ps = connection.prepareStatement(query)) {
            ps.setString(1, userDTO.getName());
            ps.setString(2, userDTO.getPhoneNo());
            ps.setString(3, userDTO.getAddress());
            ps.setString(4, userDTO.getEmail());
            ps.setString(5, userDTO.getPassword());
            ps.setString(6, userDTO.getConfirmPass());

            int count = ps.executeUpdate();

            return count > 0;
        }
    }

    // Method for validating a user during login
    public boolean validateUser(String username, String password) throws SQLException {
        String loginQuery = "SELECT name FROM logindata WHERE name=? AND pass=?";

        try (PreparedStatement ps = connection.prepareStatement(loginQuery)) {
            ps.setString(1, username);
            ps.setString(2, password);

            try (ResultSet rs = ps.executeQuery()) {
                return rs.next(); // Returns true if the user exists, false otherwise
            }
        }
    }
    // Method to get user details by name
    public List<AccountDTO> getAccountDetails(int userId) throws SQLException {
        List<AccountDTO> accountList = new ArrayList<>();

 
        String accountQuery = "SELECT * FROM bank_account WHERE user_id = ?";
        System.out.println("SQL Query: " + accountQuery);


        try (PreparedStatement ps = connection.prepareStatement(accountQuery)) {
            ps.setInt(1, userId);

            try (ResultSet rs = ps.executeQuery()) {
                while (rs.next()) {
                    AccountDTO account = new AccountDTO();
                    account.setId(rs.getInt("id"));
                    account.setAccountNumber(rs.getString("account_number"));
                    account.setIfscCode(rs.getString("ifsc_code"));
                    account.setBankName(rs.getString("bank_name"));
                    account.setAcctType(rs.getString("acct_type"));
                    account.setCurrBalance(rs.getDouble("curr_balance"));
                    account.setUserId(rs.getInt("user_id"));

                    accountList.add(account);
                }
            }
        }

        return accountList;
    }

    public UserDTO getUserDetails(String name, String pass) throws SQLException {
        UserDTO userDTO = null;

        String userDetailsQuery = "SELECT * FROM logindata WHERE name=? AND pass=?";

        try (PreparedStatement ps = connection.prepareStatement(userDetailsQuery)) {
            ps.setString(1, name);
            ps.setString(2, pass);

            try (ResultSet rs = ps.executeQuery()) {
                if (rs.next()) {
                    // User exists, create a UserDTO object and populate it with details
                    userDTO = new UserDTO();
                    userDTO.setId(rs.getInt("id"));
                    userDTO.setName(rs.getString("name"));
                    userDTO.setPhoneNo(rs.getString("phone_no"));
                    userDTO.setAddress(rs.getString("address"));
                    userDTO.setEmail(rs.getString("email"));
                    // Other details if needed

                    // You can add other user details based on your database schema
                }
            }
        }

        return userDTO;
    }
}
