# 🏦 Bank Account Management System (Java + Oracle)

## 📌 Introduction
The Bank Account Management System is a Java-based console application developed using Object-Oriented Programming (OOP) principles and integrated with an Oracle Database using JDBC.  
The project simulates real-time banking operations such as account handling, deposits, withdrawals, balance inquiries, and fund transfers with appropriate validations and exception handling.

---

## 🎯 Problem Statement
The objective of this project is to design and implement a Bank Account Management System using Java with an object-oriented approach.

### The system allows:
- Creating and managing customer bank accounts  
- Performing core banking operations:
  - Deposit  
  - Withdrawal  
  - Balance inquiry  
  - Fund transfer  
- Maintaining account details such as:
  - Account Number  
  - Customer Name  
  - Current Balance  
- Applying validations:
  - Minimum balance check  
  - Handling invalid account numbers  
- Handling exceptions:
  - Insufficient balance  
  - Invalid operations  
- Displaying transaction updates through a clean console-based interface  
- Ensuring modular design using OOP concepts:
  - Encapsulation  
  - Inheritance  
  - Polymorphism  

---

## 🛠️ Technologies Used
- Programming Language: Java  
- IDE: Eclipse IDE  
- Database: Oracle 11g  
- JDBC: Oracle JDBC Driver  
- Architecture: Layered Architecture  

---

## 📂 Project Structure

packagecreationdemo
│
├── JRE System Library [JavaSE-22]
│
├── src
│   │
│   ├── com.wipro.bank.bean
│   │   └── TransferBean.java
│   │
│   ├── com.wipro.bank.dao
│   │   └── BankDAO.java
│   │
│   ├── com.wipro.bank.service
│   │   └── BankService.java
│   │
│   ├── com.wipro.bank.util
│   │   ├── DBUtil.java
│   │   └── InsufficientFundsException.java
│   │
│   └── com.wipro.bank.main
│       └── BankMain.java

---

## ⚙️ How to Run in Eclipse IDE

Step 1: Install Eclipse IDE  
Download from: https://www.eclipse.org/downloads/

Step 2: Create Java Project  
- Open Eclipse  
- Go to File → New → Java Project  
- Project Name: packagecreationdemo  
- Click Finish

Step 3: Create Packages  
Inside src, create the following packages:  
- com.wipro.bank.bean  
- com.wipro.bank.dao  
- com.wipro.bank.service  
- com.wipro.bank.util  
- com.wipro.bank.main

Step 4: Add Java Classes  
Create the following files and paste your code:  
- TransferBean.java  
- BankDAO.java  
- BankService.java  
- DBUtil.java  
- InsufficientFundsException.java  
- BankMain.java

Step 5: Run the Application  
- Navigate to com.wipro.bank.main → BankMain.java  
- Right-click → Run As → Java Application

---
```
## 🗄️ Database Setup (Oracle SQL)

Drop Existing Objects
DROP TABLE TRANSFER_TBL;
DROP TABLE ACCOUNT_TABLE;
DROP SEQUENCE transaction_seq;

Create Account Table
CREATE TABLE ACCOUNT_TABLE (
    Account_Number VARCHAR2(10) PRIMARY KEY,
    Account_Name   VARCHAR2(50),
    Balance        NUMBER(12,2)
);

Create Transaction Table
CREATE TABLE TRANSFER_TBL (
    Transaction_ID NUMBER PRIMARY KEY,
    Account_Number VARCHAR2(10) NOT NULL,
    Beneficiary_Account_Number VARCHAR2(10) NOT NULL,
    Transaction_Date DATE DEFAULT SYSDATE,
    Transaction_Amount NUMBER(12,2),
    CONSTRAINT fk_account_new
        FOREIGN KEY (Account_Number)
        REFERENCES ACCOUNT_TABLE(Account_Number),
    CONSTRAINT fk_beneficiary_new
        FOREIGN KEY (Beneficiary_Account_Number)
        REFERENCES ACCOUNT_TABLE(Account_Number)
);

Create Transaction Sequence
CREATE SEQUENCE transaction_seq
START WITH 1000
INCREMENT BY 1
NOCACHE;

Insert Sample Data
INSERT INTO ACCOUNT_TABLE VALUES ('ACC001', 'Ravi', 50000);
INSERT INTO ACCOUNT_TABLE VALUES ('ACC002', 'Kumar', 30000);
INSERT INTO ACCOUNT_TABLE VALUES ('ACC003', 'Anitha', 45000);

COMMIT;

View Tables
SELECT * FROM ACCOUNT_TABLE;
SELECT * FROM TRANSFER_TBL;

Reset Database (Optional)
TRUNCATE TABLE TRANSFER_TBL;

UPDATE ACCOUNT_TABLE SET Balance = 50000 WHERE Account_Number = 'ACC001';
UPDATE ACCOUNT_TABLE SET Balance = 30000 WHERE Account_Number = 'ACC002';
UPDATE ACCOUNT_TABLE SET Balance = 45000 WHERE Account_Number = 'ACC003';

COMMIT;

```

---

## 📸 Output

Eclipse Console Output

<img width="1712" height="364" alt="image" src="https://github.com/user-attachments/assets/13a6608d-c2b3-446a-9fa2-565c7b538806" />

<img width="1881" height="439" alt="image" src="https://github.com/user-attachments/assets/05f5b2b9-e34c-4757-9ccf-ea232804cba1" />


---

## 🔮 Future Scope
- Integrate a GUI using JavaFX or Swing  
- Add authentication and security features  
- Generate transaction reports  
- Extend to multi-branch banking simulation  

---

## 👩‍💻 Author Details
- Name: Kowsika M
- Roll No: 717823P324
- Project Type: Java & Oracle Database Mini Project
```
