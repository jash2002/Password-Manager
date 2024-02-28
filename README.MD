# **Jonathan A - Insights Project 2022**

## What is it? 
* A password auditor and a makeshift manager using mysql database
* A password is also generated for the user to use on chosen website/account
* The original password is hashed via MD5 then encrypted via a Caesar Cipher, the key can be customised 

(LINUX)

How to set up:
**FILES NEED TO BE DOWNLOADED TO BE USED IN CHECKER**

1. Run the sql file attached, this will create the required tables 
2. Create a user with max privileges on a mysql database
   * Either change Upload.java creds to your own or use the following creds for user 
   * User: test
   * Pass: P@$$w0rd

3. From Command Line:
     ```bash
    chmod +x run.sh
    bash run.sh
    ```
4. VSCODE
    * Open project 
    * Run Main.java 

TODO: 
* Create Ant Build File
* Fix windows suggestor 
* Build GUI
