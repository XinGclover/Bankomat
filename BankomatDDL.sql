CREATE TABLE Anstalld (
  idAnstalld int(11) NOT NULL AUTO_INCREMENT,
  number int(11) NOT NULL,
  name varchar(30) ,
  PRIMARY KEY (idAnstalld)
) ;

CREATE TABLE Kund (
  idKund int(11) NOT NULL AUTO_INCREMENT,
  personnummer int(11) NOT NULL,
  PIN int(11) ,
  namn varchar(45) ,
  address varchar(45) ,
  telefon varchar(45) ,
  skapaAnstalldId int(11) ,
  skapaDate datetime ,
  PRIMARY KEY (idKund),
  UNIQUE (personnummer),
  FOREIGN KEY (skapaAnstalldId) REFERENCES anstalld (idanstalld) ON DELETE SET NULL ON UPDATE CASCADE
) ;

CREATE TABLE Konto (
  idKonto int(11) NOT NULL AUTO_INCREMENT,
  number int(11) NOT NULL,
  kundId int(11) ,
  saldo int(11) DEFAULT '0',
  sparaRantesats decimal(3,1) DEFAULT '0.0',
  avsluta tinyint(4) DEFAULT '0',
  PRIMARY KEY (idKonto),
  UNIQUE (number),
  FOREIGN KEY (kundId) REFERENCES kund (idkund) ON DELETE SET NULL ON UPDATE CASCADE
) ;



CREATE TABLE Lan (
  idLan int(11) NOT NULL AUTO_INCREMENT,
  LanNumber int(11) NOT NULL,
  kundId int(11) DEFAULT NULL,
  lanAntal int(11) DEFAULT '0',
  lanRantesats decimal(3,1) DEFAULT '0.0',
  betalplan date ,
  bevilja tinyint(4) DEFAULT '0',
  PRIMARY KEY (idLan),
  FOREIGN KEY (kundId) REFERENCES kund(idkund) ON DELETE SET NULL ON UPDATE CASCADE
) ;


CREATE TABLE hanteraKonto (
  idhantering int(11) NOT NULL AUTO_INCREMENT,
  kontoId int(11) ,
  sattainsaldo int(11) ,
  tautsaldo int(11) ,
  rantesats decimal(3,1) ,
  skapa tinyint(4),
  avsluta tinyint(4) ,
  anstalldId int(11) ,
  kundId int(11) ,
  date datetime ,
  PRIMARY KEY (idhantering),
  FOREIGN KEY (anstalldId) REFERENCES anstalld (idanstalld) ON DELETE SET NULL ON UPDATE CASCADE,
  FOREIGN KEY (kontoId) REFERENCES konto(idkonto) ON DELETE SET NULL ON UPDATE CASCADE,
  FOREIGN KEY (kundId) REFERENCES kund(idkund) ON DELETE SET NULL ON UPDATE CASCADE
) ;

CREATE TABLE hanteraLan (
  idhanteraLan int(11) NOT NULL AUTO_INCREMENT,
  lanId int(11) DEFAULT NULL,
  bevilja tinyint(4) ,
  lanrantesats decimal(3,1) ,
  betalplan date ,
  anstalldId int(11) ,
  date datetime ,
  PRIMARY KEY (idhanteraLan),
  FOREIGN KEY (anstalldId) REFERENCES anstalld (idanstalld) ON DELETE SET NULL ON UPDATE CASCADE,
  FOREIGN KEY (lanId) REFERENCES lan(idlan) ON DELETE SET NULL ON UPDATE CASCADE
) ;



create index IX_clientPersonNumber on Kund(personnummer);

create index IX_accountNumber on Konto(number);

create index IX_loanNumber on Lan(LanNumber);

create database bank;
use bank;

insert into Anstalld(number) values
(10001),(10002),(10003),(10004),
(10005),(10006),(10007),(10008);

insert into Lan(LanNumber,kundId,lanAntal,betalplan) values
(201,1,20000,'2021-05-03'),(202,2,10000,'2021-03-02'),(203,3,5000,'2019-08-08'),(204,1,10000,'2021-02-07');