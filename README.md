
sql tables used in this project

use serverdata;


-------------------------------logindata table------------------------------
 
CREATE TABLE logindata (
    Id INT AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(255) NOT NULL,
    phone_no VARCHAR(15) NOT NULL,
    address VARCHAR(255) NOT NULL,
    email VARCHAR(255) NOT NULL,
    pass VARCHAR(255) NOT NULL,
    confirm_pass VARCHAR(255) NOT NULL
);


-------------------------bank_account table-----------------------------------

CREATE TABLE bank_account (
    id INT AUTO_INCREMENT PRIMARY KEY,
    account_number VARCHAR(255) NOT NULL,
    ifsc_code VARCHAR(255) NOT NULL,
    bank_name VARCHAR(255) NOT NULL,
    acct_type VARCHAR(255) NOT NULL,
    curr_balance DOUBLE NOT NULL,
    user_id INT NOT NULL,
    FOREIGN KEY (user_id) REFERENCES logindata(Id)
);


------------------------- statement table----------------------------

CREATE TABLE statement (
    statement_id INT AUTO_INCREMENT PRIMARY KEY,
    user_id INT NOT NULL,
    account_id INT NOT NULL,
    transaction_type VARCHAR(50) NOT NULL,
    amount DECIMAL(10, 2) NOT NULL,
    transaction_date TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    FOREIGN KEY (user_id) REFERENCES logindata(Id),
    FOREIGN KEY (account_id) REFERENCES bank_account(id)
);



------------------------------money_transfer table-------------------------------

CREATE TABLE money_transfer (
    transfer_id INT AUTO_INCREMENT PRIMARY KEY,
    source_user INT NOT NULL,
    target_user INT NOT NULL,
    source_account INT NOT NULL,
    target_account INT NOT NULL,
    amount DECIMAL(10, 2) NOT NULL,
    transfer_date TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    FOREIGN KEY (source_user) REFERENCES logindata(Id),
    FOREIGN KEY (target_user) REFERENCES logindata(Id),
    FOREIGN KEY (source_account) REFERENCES bank_account(id),
    FOREIGN KEY (target_account) REFERENCES bank_account(id)
);
