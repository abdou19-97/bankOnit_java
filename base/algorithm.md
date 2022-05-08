## Goal
To make a model ATM program, using JAVA, and learning inheritance.

## Input
This program has an optional input, as the 'filename'. If the input is not passed, then the file 'userData.txt' will be used as default file. The file must be in txt format. If the input file does not exist, then the program uses sample data, which is hardcoded into the program.

This program opens the file indicated in 'filename' and fills in the users and accounts from the filename. The same file will be used to save the users accounts information.
The format of the user account in the file is as follows:
Account-Number, Account-pin,  Checking-balance, Savings-balance

## Output
The program prompts the user to input account number and PIN.
If the account number is not found or the PIN is wrong, then the program exits with a prompt message.
If the account is Admin, then the admin menu shows.
If the account is a Customer, then the customer menu shows.

Also, before exiting the program, all the accounts will be saved in the file indicated in 'filename'.

## Steps
If an argument is passed, then use it as the DB path, otherwise, use 'userData,txt' as the DB path. DB is a text file in txt format.

### Read database
If the DB file does not exist, fill the accounts with the sample hardcoded data.
If the DB file does exist, then fill the accounts from that.

### Login
Show the Login menu.
Get the account number and PIN from the user.
Compare the account number and PIN against all accounts.
If the account does not exist or PIN is wrong, prompts the user and exits the program.
Otherwise, get that account.

### Menu
If the account is Admin, then show admin menu.
If the account is Customer, then show customer menu.
