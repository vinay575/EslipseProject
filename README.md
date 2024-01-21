use serverdata;
	-------------------------------------------------------------------------------------------------------------------
CREATE TABLE logindata (
    Id INT AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(255) NOT NULL,
    phone_no VARCHAR(15) NOT NULL,
    address VARCHAR(255) NOT NULL,
    email VARCHAR(255) NOT NULL,
    pass VARCHAR(255) NOT NULL,
    confirm_pass VARCHAR(255) NOT NULL
);

INSERT INTO logindata (name, phone_no, address, email, pass, confirm_pass)
VALUES ('vinay', '1234567890', '123 Main St', 'vinay@example.com', '123', '123');

INSERT INTO logindata (name, phone_no, address, email, pass, confirm_pass)
VALUES ('teja', '9876543210', '456 Oak St', 'teja@example.com', '123', '123');


INSERT INTO logindata (name, phone_no, address, email, pass, confirm_pass)
VALUES ('rakesh', '9876543210', '789 Oak St', 'rakesh@example.com', '123', '123');
----------------------------------------------------------------------------------------------------------------------

CREATE TABLE bank_account (
    id INT AUTO_INCREMENT PRIMARY KEY,
    account_number VARCHAR(255) NOT NULL,
    ifsc_code VARCHAR(255) NOT NULL,
    bank_name VARCHAR(255) NOT NULL,
    acct_type VARCHAR(255) NOT NULL,
    curr_balance DOUBLE NOT NULL,
    user_id INT NOT NULL,
    FOREIGN KEY (user_id) REFERENCES logindata(Id),
    INDEX idx_account_number (account_number)  --  line to create an index on account_number
);


-- Fake data for bank_account table
INSERT INTO bank_account (account_number, ifsc_code, bank_name, acct_type, curr_balance, user_id)
VALUES ('9876543210', 'ABC123', 'Fake Bank 1', 'Savings', 5000.00, 1);

INSERT INTO bank_account (account_number, ifsc_code, bank_name, acct_type, curr_balance, user_id)
VALUES ('9876543210', 'ABC456', 'Fake Bank 2', 'Checking', 5000.00, 1);


INSERT INTO bank_account (account_number, ifsc_code, bank_name, acct_type, curr_balance, user_id)
VALUES ('1234567890', 'XYZ789', 'Fake Bank 2', 'Checking', 8000.00, 2);


INSERT INTO bank_account (account_number, ifsc_code, bank_name, acct_type, curr_balance, user_id)
VALUES ('1234567890', 'XYZ789', 'Fake Bank 3', 'Checking', 8000.00, 3);
--------------------------------------------------------------------------------------------------------------------------------

CREATE TABLE statement (
    S_no INT AUTO_INCREMENT PRIMARY KEY,
    transaction_id INT NOT NULL,
    transaction_date TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    user_id INT NOT NULL,
    Description VARCHAR(255) NOT NULL,
    Amount_Sent DOUBLE NOT NULL,
    From_Acc_no VARCHAR(255) NOT NULL,
    To_Acc_no VARCHAR(255) NOT NULL,
    Current_Balance DOUBLE NOT NULL,
    FOREIGN KEY (transaction_id) REFERENCES money_transfer(transaction_id),
    FOREIGN KEY (user_id) REFERENCES logindata(Id),
    FOREIGN KEY (From_Acc_no) REFERENCES bank_account(account_number),
    FOREIGN KEY (To_Acc_no) REFERENCES bank_account(account_number)
);


------------------------------------------------------------------------------------------------------------------------------
CREATE TABLE money_transfer (
    transaction_id INT AUTO_INCREMENT PRIMARY KEY,
    transaction_date TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    user_id INT NOT NULL,
    Description VARCHAR(255) NOT NULL,
    Amount_Sent DOUBLE NOT NULL,
    From_Acc_no VARCHAR(255) NOT NULL,
    To_Acc_no VARCHAR(255) NOT NULL,
    Current_Balance DOUBLE NOT NULL,
    FOREIGN KEY (user_id) REFERENCES logindata(Id),
    FOREIGN KEY (From_Acc_no) REFERENCES bank_account(account_number),
    FOREIGN KEY (To_Acc_no) REFERENCES bank_account(account_number)
);
