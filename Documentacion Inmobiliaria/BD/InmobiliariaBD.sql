/****Address****/

/*CREATE TABLE Address (
address_id NUMBER(8),
city VARCHAR2(50) not null,
street VARCHAR2(50) not null,
house_no NUMBER(8) not null,
CONSTRAINT address_pk PRIMARY KEY (address_id)
)*/

/*CREATE SEQUENCE address_seq 
START WITH 1
INCREMENT by 1;*/

/*CREATE TRIGGER TAddress_SEQ
Before insert on ADDRESS
for each row
begin
  SELECT address_seq.NEXTVAL INTO :NEW.address_id FROM DUAL;
end;*/

--Insert into ADDRESS(CITY,STREET,HOUSE_NO) VALUES('Cotorro','Calle Cisneros', 2518);

/****Proprietor****/

/*CREATE TABLE Proprietor(
proprietor_id int,
address NUMBER(8),
name VARCHAR2(50) not null,
telephone VARCHAR2(15) not null,
CONSTRAINT proprietor_pk PRIMARY KEY (proprietor_id),
CONSTRAINT address_fk FOREIGN KEY (address) REFERENCES ADDRESS(address_id) 
)*/

/*CREATE SEQUENCE proprietor_seq 
START WITH 1
INCREMENT by 1;*/

/*CREATE TRIGGER TProprietor_SEQ
Before insert on PROPRIETOR
for each row
begin
  SELECT proprietor_seq.NEXTVAL INTO :NEW.proprietor_id FROM DUAL;
end;*/

--Insert into PROPRIETOR(NAME,ADDRESS,TELEPHONE) VALUES('PEDRO PICAPIEDRA SANCHEZ',3, '0991218099');

/****JOURNAL****/

/*CREATE TABLE JOURNAL(
JOURNAL_id int,
JOURNAL_address NUMBER(8) NOT NULL,
JOURNAL_name VARCHAR2(50) not null,
JOURNAL_telephone VARCHAR2(15) not null,
JOURNAL_FAX VARCHAR2(15),
JOURNAL_CONTACT VARCHAR2(50) not null,
CONSTRAINT journal_pk PRIMARY KEY (JOURNAL_id),
CONSTRAINT jou_address_fk FOREIGN KEY (JOURNAL_address) REFERENCES ADDRESS(address_id) 
)*/

/*CREATE SEQUENCE journal_seq 
START WITH 1
INCREMENT by 1;*/

/*CREATE TRIGGER TJournal_SEQ
Before insert on JOURNAL
for each row
begin
  SELECT journal_seq.NEXTVAL INTO :NEW.JOURNAL_id FROM DUAL;
end;*/

--Insert into JOURNAL(JOURNAL_NAME,JOURNAL_ADDRESS,JOURNAL_TELEPHONE,JOURNAL_FAX,JOURNAL_CONTACT) VALUES('NEW YORK TIME',2, '058987258787','2525888','JHON SMITH');

/****MANAGER****/
/*CREATE TABLE MANAGER
  (
    DATE_IN     DATE NOT NULL ,
    MANAGER_ID  INTEGER NOT NULL ,
    CAR_EXPENSE NUMBER (8,2) ,
    BONUS       NUMBER (8,2)
  )
ALTER TABLE INMOBILIARIA.MANAGER ADD CONSTRAINT MANAGER_PK PRIMARY KEY ( MANAGER_ID ) ;*/

/*CREATE SEQUENCE manager_seq 
START WITH 1
INCREMENT by 1;*/

/*CREATE TRIGGER TManager_SEQ
Before insert on MANAGER
for each row
begin
  SELECT manager_seq.NEXTVAL INTO :NEW.MANAGER_id FROM DUAL;
end;*/


/****PARIENTE****/

/*CREATE TABLE INMOBILIARIA.PARIENTE
  (
    RELATION           VARCHAR2 (50 CHAR) NOT NULL ,
    PARIENTE_ID        NUMBER(8,0) NOT NULL ,
    PARIENTE_NAME      VARCHAR2 (50 CHAR) NOT NULL ,
    PARIENTE_TELEPHONE NUMBER(8,0) NOT NULL ,
    PARIENTE_ADDRESS   NUMBER (8) NOT NULL
  )
  LOGGING ;
ALTER TABLE INMOBILIARIA.PARIENTE ADD CONSTRAINT PARIENTE_PK PRIMARY KEY ( PARIENTE_ID ) ;
ALTER TABLE INMOBILIARIA.PARIENTE ADD CONSTRAINT PARIENTE_ADDRESS_FK FOREIGN KEY ( PARIENTE_ADDRESS ) REFERENCES INMOBILIARIA.ADDRESS ( ADDRESS_ID );


CREATE SEQUENCE INMOBILIARIA.pariente_seq START WITH 1 ;

CREATE OR REPLACE TRIGGER INMOBILIARIA.TPariente_seq BEFORE
  INSERT ON INMOBILIARIA.PARIENTE FOR EACH ROW BEGIN :NEW.PARIENTE_ID := INMOBILIARIA.pariente_seq.NEXTVAL;
END;
*/


/****EMPLOYEE****/

/* CREATE TABLE EMPLOYEE(
EMPLOYEE_ID NUMBER(8,0) NOT NULL,
EMPLOYEE_NAME VARCHAR2(50) NOT NULL,
EMPLOYEE_ADDRESS NUMBER(8,0),
EMPLOYEE_TELEPHONE NUMBER(15,0) NOT NULL,
EMPLOYEE_BIRTHDAY DATE NOT NULL,
DNI NUMBER(20,0) NOT NULL,
EMPLOYEE_JOB VARCHAR2(50) NOT NULL,
EMPLOYEE_DATEIN DATE DEFAULT SYSDATE NOT NULL,
SALARY FLOAT(8) NOT NULL,
WRITE_SPEED NUMBER(8)
);

ALTER TABLE EMPLOYEE ADD CONSTRAINT EMPLOYEE_PK PRIMARY KEY (EMPLOYEE_ID);
ALTER TABLE EMPLOYEE ADD CONSTRAINT EMPLOYEE_ADDRESS_PK FOREIGN KEY (EMPLOYEE_ADDRESS) REFERENCES ADDRESS(ADDRESS_ID);
ALTER TABLE EMPLOYEE ADD EMPLOYEE_PARIENTE NUMBER(38) NOT NULL;
ALTER TABLE EMPLOYEE ADD CONSTRAINT EMPLOYEE_PARIENTE_FK FOREIGN KEY ( EMPLOYEE_PARIENTE ) REFERENCES PARIENTE (PARIENTE_ID );


ALTER TABLE MANAGER ADD CONSTRAINT MANAGER_EMPLOYEE_FK FOREIGN KEY (MANAGER_ID) REFERENCES EMPLOYEE(EMPLOYEE_ID);

CREATE SEQUENCE EMPLOYEE_SEQ START WITH 1
INCREMENT BY 1;

CREATE OR REPLACE TRIGGER TEmployee_SEQ BEFORE INSERT ON EMPLOYEE
FOR EACH ROW 
BEGIN
  :NEW.EMPLOYEE_ID := EMPLOYEE_SEQ.NEXTVAL;
END;
*/


/****OFFICE****/

/*CREATE TABLE OFFICE(
OFFICE_ID NUMBER(8,0) NOT NULL,
OFFICE_FAX NUMBER(20),
OFFICE_TELEPHONE NUMBER(15) NOT NULL,
OFFICE_ADDRESS NUMBER(8) NOT NULL,
OFFICE_MANAGER NUMBER(8) NOT NULL
);*/


--ALTER TABLE OFFICE ADD CONSTRAINT OFFICE_PK PRIMARY KEY (OFFICE_ID);
--ALTER TABLE OFFICE ADD CONSTRAINT ADDRESS_OFFICE_FK FOREIGN KEY (OFFICE_ADDRESS) REFERENCES ADDRESS(ADDRESS_ID);
--ALTER TABLE OFFICE ADD CONSTRAINT OFFICE_MANAGER_FK FOREIGN KEY (OFFICE_MANAGER) REFERENCES MANAGER(MANAGER_ID);
--ALTER TABLE EMPLOYEE ADD EMPLOYEE_OFFICE NUMBER(8) NOT NULL;
--ALTER TABLE EMPLOYEE ADD CONSTRAINT EMPLOYEE_OFFICE_FK FOREIGN KEY (EMPLOYEE_OFFICE) REFERENCES OFFICE(OFFICE_ID);


/*CREATE SEQUENCE OFFICE_SEQ
START WITH 1
INCREMENT BY 1;

CREATE TRIGGER TOFFICCE_SEQ BEFORE INSERT ON OFFICE
FOR EACH ROW 
BEGIN
:NEW.OFFICE_ID := OFFICE_SEQ.NEXTVAL;
END;*/


/****SUPERVISOR****/

/*CREATE TABLE SUPERVISOR(
SUPERVISOR_IDEMPLOYEE NUMBER(8) NOT NULL PRIMARY KEY,
SUPERVISOR_OFFICE NUMBER(8) NOT NULL
);*/

--ALTER TABLE SUPERVISOR ADD CONSTRAINT SUPERVISOR_OFFICE_FK FOREIGN KEY (SUPERVISOR_OFFICE) REFERENCES OFFICE(OFFICE_ID);
--ALTER TABLE SUPERVISOR ADD CONSTRAINT SUPERVISOR_EMPLOYEE_FK FOREIGN KEY (SUPERVISOR_IDEMPLOYEE) REFERENCES EMPLOYEE(EMPLOYEE_ID);

--ALTER TABLE EMPLOYEE ADD EMPLOYEE_SUPERVISOR NUMBER(8) NOT NULL;
--ALTER TABLE EMPLOYEE ADD CONSTRAINT EMPLOYEE_SUPERVISOR_FK FOREIGN KEY (EMPLOYEE_SUPERVISOR) REFERENCES SUPERVISOR(SUPERVISOR_IDEMPLOYEE);

/****INMUEBLE_TYPE****/
/*CREATE TABLE INMUEBLE_TYPE(
TYPE_ID NUMBER(8) NOT NULL PRIMARY KEY,
TYPE_NAME VARCHAR2(50 CHAR) NOT NULL
);

CREATE SEQUENCE INMUEBLE_TYPE_SEQ
START WITH 1
INCREMENT BY 1;

CREATE TRIGGER TTYPE_SEQ BEFORE
INSERT ON INMUEBLE_TYPE
FOR EACH ROW 
BEGIN
:NEW.TYPE_ID := INMUEBLE_TYPE_SEQ.NEXTVAL;
END;*/

/****INQUILINO****/
/*CREATE TABLE INQUILINO(
INQUILINO_ID NUMBER(8) NOT NULL PRIMARY KEY,
INQUILINO_NAME VARCHAR2(50 CHAR) NOT NULL,
INQUILINO_ADDRESS NUMBER(8) NOT NULL,
INQUILINO_TELEPHONE NUMBER(15) NOT NULL,
INMUEBLE_TYPE NUMBER(8) NOT NULL,
MAX_IMPORT NUMBER(8,2) NOT NULL,
INQUILINO_OFFICE NUMBER(8) NOT NULL
);
ALTER TABLE INQUILINO ADD CONSTRAINT INQUILINO_ADDRESS_FK FOREIGN KEY (INQUILINO_ADDRESS) REFERENCES ADDRESS(ADDRESS_ID);
ALTER TABLE INQUILINO ADD CONSTRAINT INQUILINO_INMUEBLETYPE_FK FOREIGN KEY (INMUEBLE_TYPE) REFERENCES INMUEBLE_TYPE(TYPE_ID);
ALTER TABLE INQUILINO ADD CONSTRAINT INQUILINO_OFFICE_FK FOREIGN KEY (INQUILINO_OFFICE) REFERENCES OFFICE(OFFICE_ID);
CREATE SEQUENCE INQUILINO_SEQ
START WITH 1
INCREMENT BY 1;

CREATE TRIGGER TINQUILINO_SEQ
BEFORE INSERT ON INQUILINO
FOR EACH ROW
BEGIN
:NEW.INQUILINO_ID := INQUILINO_SEQ.NEXTVAL;
END;*/


/****INTERVIEW****/
/*CREATE TABLE INTERVIEW(
INTERVIEW_ID NUMBER(8) NOT NULL PRIMARY KEY,
INTERVIEW_DATE DATE NOT NULL,
INTERVIEW_EMPLOYEE NUMBER(8) NOT NULL,
INTEVIEW_COMMENTS VARCHAR2(100 CHAR),
INTERVIEW_INQUILINO NUMBER(8) NOT NULL
);

ALTER TABLE INTERVIEW ADD CONSTRAINT INTERVIEW_EMPLOYEE_FK FOREIGN KEY (INTERVIEW_EMPLOYEE) REFERENCES EMPLOYEE(EMPLOYEE_ID);
ALTER TABLE INTERVIEW ADD CONSTRAINT INTERVIEW_INQUILINO_FK FOREIGN KEY (INTERVIEW_INQUILINO) REFERENCES INQUILINO(INQUILINO_ID);

CREATE SEQUENCE INTERVIEW_SEQ
START WITH 1
INCREMENT BY 1;

CREATE TRIGGER TINTERVIEW_SEQ BEFORE
INSERT ON INTERVIEW 
FOR EACH ROW
BEGIN
 :NEW.INTERVIEW_ID  := INTERVIEW_SEQ.NEXTVAL;
END;*/


/****INMUEBLE****/
/*CREATE TABLE INMUEBLE(
INMUEBLE_ID NUMBER(8) NOT NULL PRIMARY KEY,
INMUEBLE_ADDRESS NUMBER(8) NOT NULL,
INMUEBLE_TYPE NUMBER(8) NOT NULL,
NO_ROOMS NUMBER(2) NOT NULL,
PRICE NUMBER(8,2) NOT NULL,
REGISTER_DATE DATE DEFAULT SYSDATE NOT NULL,
INMUEBLE_OFFICE NUMBER(8) NOT NULL,
INMUEBLE_PROPRIETOR NUMBER(8) NOT NULL,
INMUEBLE_EMPLOYEE NUMBER(8) NOT NULL
);

ALTER TABLE INMUEBLE ADD CONSTRAINT INMUEBLE_OFFICE_FK FOREIGN KEY (INMUEBLE_OFFICE) REFERENCES OFFICE(OFFICE_ID);
ALTER TABLE INMUEBLE ADD CONSTRAINT INMUEBLE_PROPRIETOR_FK FOREIGN KEY (INMUEBLE_PROPRIETOR) REFERENCES PROPRIETOR(PROPRIETOR_ID);
ALTER TABLE INMUEBLE ADD CONSTRAINT INMUEBLE_EMPLOYEE_FK FOREIGN KEY (INMUEBLE_EMPLOYEE) REFERENCES EMPLOYEE(EMPLOYEE_ID);
ALTER TABLE INMUEBLE ADD CONSTRAINT INMUEBLE_ADDRESS_FK FOREIGN KEY (INMUEBLE_ADDRESS) REFERENCES ADDRESS(ADDRESS_ID);
ALTER TABLE INMUEBLE ADD CONSTRAINT INMUEBLE_TYPE_FK FOREIGN KEY (INMUEBLE_TYPE) REFERENCES INMUEBLE_TYPE(TYPE_ID);

CREATE SEQUENCE INMUEBLE_SEQ
START WITH 1
INCREMENT BY 1;

CREATE TRIGGER TINMUEBLE_SEQ BEFORE
INSERT ON INMUEBLE 
FOR EACH ROW
BEGIN
 :NEW.INMUEBLE_ID  := INMUEBLE_SEQ.NEXTVAL;
END;*/


/****ANNOUNCE****/
/*CREATE TABLE ANNOUNCE(
ANNOUNCE_ID NUMBER(8) NOT NULL PRIMARY KEY,
ANNOUNCE_INMUEBLE NUMBER(8) NOT NULL,
ANNOUNCE_DATE DATE NOT NULL,
ANNOUNCE_COST NUMBER(8,2) NOT NULL,
ANNOUNCE_JOURNAL NUMBER(8) NOT NULL
);

ALTER TABLE ANNOUNCE ADD CONSTRAINT ANNOUNCE_INMUEBLE_FK FOREIGN KEY (ANNOUNCE_INMUEBLE) REFERENCES INMUEBLE(INMUEBLE_ID);
ALTER TABLE ANNOUNCE ADD CONSTRAINT ANNOUNCE_JOURNAL_FK FOREIGN KEY (ANNOUNCE_JOURNAL) REFERENCES JOURNAL(JOURNAL_ID);

CREATE SEQUENCE ANNOUNCE_SEQ
START WITH 1
INCREMENT BY 1;

CREATE OR REPLACE TRIGGER TANNOUNCE_SEQ BEFORE
INSERT ON ANNOUNCE 
FOR EACH ROW
BEGIN
 :NEW.ANNOUNCE_ID  := ANNOUNCE_SEQ.NEXTVAL;
END;*/


/****INSPECTION****/
/*CREATE TABLE INSPECTION(
INSPECTION_ID NUMBER(8) NOT NULL PRIMARY KEY,
INSPECTION_DATE DATE DEFAULT SYSDATE NOT NULL,
INSPECTION_COMMENT VARCHAR2(100 CHAR) NOT NULL,
INSPECTION_INMUEBLE NUMBER(8) NOT NULL,
INSPECTION_EMPLOYEE NUMBER(8) NOT NULL
);

ALTER TABLE INSPECTION ADD CONSTRAINT INSPECTION_INMUEBLE_FK FOREIGN KEY (INSPECTION_INMUEBLE) REFERENCES INMUEBLE(INMUEBLE_ID);
ALTER TABLE INSPECTION ADD CONSTRAINT INSPECTION_EMPLOYEE_FK FOREIGN KEY (INSPECTION_EMPLOYEE) REFERENCES EMPLOYEE(EMPLOYEE_ID);

CREATE SEQUENCE INSPECTION_SEQ
START WITH 1
INCREMENT BY 1;

CREATE OR REPLACE TRIGGER TINSPECTION_SEQ BEFORE
INSERT ON INSPECTION 
FOR EACH ROW
BEGIN
 :NEW.INSPECTION_ID  := INSPECTION_SEQ.NEXTVAL;
END;
*/

/****VISIT****/
/*CREATE TABLE VISIT(
VISIT_ID NUMBER(8) NOT NULL PRIMARY KEY,
VISIT_DATE DATE DEFAULT SYSDATE NOT NULL,
VISIT_COMMENT VARCHAR2(100 CHAR) NOT NULL,
VISIT_INMUEBLE NUMBER(8) NOT NULL,
VISIT_INQUILINO NUMBER(8) NOT NULL
);

ALTER TABLE VISIT ADD CONSTRAINT VISIT_INMUEBLE_FK FOREIGN KEY (VISIT_INMUEBLE) REFERENCES INMUEBLE(INMUEBLE_ID);
ALTER TABLE VISIT ADD CONSTRAINT VISIT_INQUILINO_FK FOREIGN KEY (VISIT_INQUILINO) REFERENCES INQUILINO(INQUILINO_ID);

CREATE SEQUENCE VISIT_SEQ
START WITH 1
INCREMENT BY 1;

CREATE OR REPLACE TRIGGER TVISIT_SEQ BEFORE
INSERT ON VISIT 
FOR EACH ROW
BEGIN
 :NEW.VISIT_ID  := VISIT_SEQ.NEXTVAL;
END;*/



/****CONTRACT****/
/*CREATE TABLE CONTRACT(
CONTRACT_ID NUMBER(8) NOT NULL PRIMARY KEY,
DATE_IN DATE NOT NULL,
DATE_OUT DATE NOT NULL,
CONTRACT_IMPORT NUMBER(8,2) NOT NULL,
PAY_TYPE VARCHAR2(30 CHAR) NOT NULL,
DEPOSITED NCHAR(1) NOT NULL, --SI SE HA REALIZADO UN DEPOSITO '1' SINO '0'
DEPOSIT_IMPORT NUMBER(8,2),
TOTAL_MONTHS NUMBER(2) NOT NULL,
CONTRACT_EMPLOYEE NUMBER(8) NOT NULL,
CONTRACT_INMUEBLE NUMBER(8) NOT NULL,
CONTRACT_INQUILINO NUMBER(8) NOT NULL
);

ALTER TABLE CONTRACT ADD CONSTRAINT CONTRACT_INMUEBLE_FK FOREIGN KEY (CONTRACT_INMUEBLE) REFERENCES INMUEBLE(INMUEBLE_ID);
ALTER TABLE CONTRACT ADD CONSTRAINT CONTRACT_INQUILINO_FK FOREIGN KEY (CONTRACT_INQUILINO) REFERENCES INQUILINO(INQUILINO_ID);
ALTER TABLE CONTRACT ADD CONSTRAINT CONTRACT_EMPLOYEE_FK FOREIGN KEY (CONTRACT_EMPLOYEE) REFERENCES EMPLOYEE(EMPLOYEE_ID);

CREATE SEQUENCE CONTRACT_SEQ
START WITH 1
INCREMENT BY 1;

CREATE OR REPLACE TRIGGER TCONTRACT_SEQ BEFORE
INSERT ON CONTRACT 
FOR EACH ROW
BEGIN
 :NEW.CONTRACT_ID  := CONTRACT_SEQ.NEXTVAL;
END;*/