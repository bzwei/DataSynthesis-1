# DataSynthesis Loading Seeded Data
The easiest thing we could have done is make this a complete SaaS based offering.
We are cognizant of the potential for partners to build out potential services  
offering down the road. We also want to ensure that organizations can have control  
of the data.

# Data Loading 
While we focus a lot on MariaDB / MySQL all the data load files are nothing more than insert into files.
The scripts for simplicity are not hard coded and we do our best to test on multiple OS'es with the core databases that our teams use. 
However, with OS and RDBMS security enhancements always keep in mind there might be changes needed.
The intent of the Data Seeeding is to support loading all the data we provide, if you wish to reduce the loaded data feel free to customize them.
<br/>
As with everything we do we keep the complete history so everyone can see the work that has been done.


## MySql/MariaDB - Linux (CentOS/RHEL/Mac) and/or Windows

We have included Linux and Non-Linux scripts for every release to ensure we have better potential data loading experiences.

Steps to Run The Scripts:
1. Open Terminal Window or Command Prompt
2. Make sure all the scripts into a specific defined directory that aligns with what is defined for the
shell being used, for simplicity I put everything into the subdirectory DataSeeding. Then make sure the
directories have correct permissions, I used chmod 777 to ensure correct permissions (it is understood that
that these are very open permissions and system admins might not allow this level.

3. From the command prompt run the specific cli with the complete path to the scripts:
Mac Example (MySQL) <br/>
a. /Applications/MySQLWorkbench.app/Contents/MacOS/mysql -u root -p datasynthesis<br/>
b. Enter your password to the machine and then database server <br/>
c. source /DataLoaders/MariaDB-DataLoader-DataSynthesis-v16-Linux.sql <br/>

4. If you are using MariaDB on WIndows then: <br/>
a. mariadb -u root -p datasynthesis <br/>
b. Enter your password to the machine and then database server <br/>
c. source \DataLoaders\MariaDB-DataLoader-DataSynthesis-v16.sql <br/>




Happy coding!!!
