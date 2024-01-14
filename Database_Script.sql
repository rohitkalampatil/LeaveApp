-- Create database
CREATE DATABASE IF NOT EXISTS studentapp;

-- Use the database
USE studentapp;

-- Create HOD table
CREATE TABLE IF NOT EXISTS hod (
    hodname VARCHAR(30),
    mobile BIGINT,
    email VARCHAR(80),
    userid VARCHAR(30) PRIMARY KEY,
    PASSWORD VARCHAR(30),
    branch VARCHAR(30)
);

-- Create Student table
CREATE TABLE IF NOT EXISTS student (
    name VARCHAR(30),
    rollno INT(11),
    prn INT(11) PRIMARY KEY,
    contact BIGINT(20),
    branch VARCHAR(30),
    year VARCHAR(30),
    semail VARCHAR(30),
    PASSWORD VARCHAR(12),
    rdate VARCHAR(30)
);

-- Create LeaveApplications table
CREATE TABLE IF NOT EXISTS leaveapplications (
    applicationid INT(11) PRIMARY KEY,
    applicationdate VARCHAR(30),
    NAME VARCHAR(30),
    prn INT(11),
    branch VARCHAR(30),
    contact BIGINT(20),
    semail VARCHAR(30),
    leavetype VARCHAR(30),
    leavefrom VARCHAR(30),
    leaveto VARCHAR(30),
    REASON VARCHAR(150),
    STATUS VARCHAR(30)
);

-- Create College table
CREATE TABLE IF NOT EXISTS collage (
    college_name VARCHAR(50),
    college_email VARCHAR(80) PRIMARY KEY,
    college_id VARCHAR(30),
    PASSWORD VARCHAR(30)
);

-- Commit changes
COMMIT;
