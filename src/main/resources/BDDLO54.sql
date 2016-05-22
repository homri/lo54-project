/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 * Author:  khalil
 * Created: 22 mai 2016
 */
# -----------------------------------------------------------------------------
#       TABLE : COURSE_SESSION
# -----------------------------------------------------------------------------

CREATE TABLE IF NOT EXISTS COURSE_SESSION
 (
   COURSE_SESSION_ID INTEGER(4) primary key NOT NULL AUTO_INCREMENT ,
   ID_LOCATION INTEGER(4) NOT NULL  ,
   COURSE_CODE VARCHAR(4) NOT NULL  ,
   START_DATE DATE NOT NULL  ,
   END_DATE DATE NOT NULL  
 ) ;

# -----------------------------------------------------------------------------
#       INDEX DE LA TABLE COURSE_SESSION
# -----------------------------------------------------------------------------


CREATE  INDEX I_FK_COURSE_SESSION_LOCATION
     ON COURSE_SESSION (ID_LOCATION ASC);

CREATE  INDEX I_FK_COURSE_SESSION_COURSE
     ON COURSE_SESSION (COURSE_CODE ASC);

# -----------------------------------------------------------------------------
#       TABLE : CLIENT
# -----------------------------------------------------------------------------

CREATE TABLE IF NOT EXISTS CLIENT
 (
   CLIENT_ID INTEGER(4) primary key NOT NULL AUTO_INCREMENT ,
   COURSE_SESSION_ID INTEGER(4) NULL  ,
   LASTNAME VARCHAR(32) NOT NULL  ,
   FIRSTNAME VARCHAR(32) NOT NULL  ,
   ADRESS VARCHAR(32) NOT NULL  ,
   PHONE VARCHAR(13) NOT NULL  ,
   EMAIL VARCHAR(32) NULL  
 ) ;

# -----------------------------------------------------------------------------
#       INDEX DE LA TABLE CLIENT
# -----------------------------------------------------------------------------


CREATE  INDEX I_FK_CLIENT_COURSE_SESSION
     ON CLIENT (COURSE_SESSION_ID ASC);

# -----------------------------------------------------------------------------
#       TABLE : COURSE
# -----------------------------------------------------------------------------

CREATE TABLE IF NOT EXISTS COURSE
 (
   COURSE_CODE VARCHAR(4) primary key NOT NULL  ,
   TITLE VARCHAR(32) NOT NULL  
 ) ;

# -----------------------------------------------------------------------------
#       TABLE : LOCATION
# -----------------------------------------------------------------------------

CREATE TABLE IF NOT EXISTS LOCATION
 (
   ID_LOCATION INTEGER(4) primary key NOT NULL AUTO_INCREMENT ,
   CITY VARCHAR(32) NOT NULL  
 ) ;


# -----------------------------------------------------------------------------
#       CREATION DES REFERENCES DE TABLE
# -----------------------------------------------------------------------------


ALTER TABLE COURSE_SESSION 
  ADD FOREIGN KEY FK_COURSE_SESSION_LOCATION (ID_LOCATION)
      REFERENCES LOCATION (ID_LOCATION) ;


ALTER TABLE COURSE_SESSION 
  ADD FOREIGN KEY FK_COURSE_SESSION_COURSE (COURSE_CODE)
      REFERENCES COURSE (COURSE_CODE) ;


ALTER TABLE CLIENT 
  ADD FOREIGN KEY FK_CLIENT_COURSE_SESSION (COURSE_SESSION_ID)
      REFERENCES COURSE_SESSION (COURSE_SESSION_ID) ;