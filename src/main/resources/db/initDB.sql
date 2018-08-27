drop table BuchungsDaten;
drop table Flug;
drop table Linie;
drop table Flughafen;
drop table Passagier;
drop table Adresse;
drop table Ort;
drop table Land;
drop table Anrede;
drop table Fluggesellschaft;
drop table FlugzeugTyp;

create table FlugzeugTyp
(
  FT_ID   int   not null
  constraint FT_ID_PK
  primary key,
  Typ        varchar(15) not null,
  Kapaz      int         not null,
  Hersteller varchar(50) not null
);

create table Fluggesellschaft
(
  FG_ID char(2)      not null
    constraint FG_ID_PK
    primary key
    constraint FG_ID_check
    check ([FG_ID] like '[A-Z][A-Z]'),
  Name  varchar(100) not null
);

create table Anrede
(
  A_ID        int
    constraint A_ID_PK
    primary key,
  Bezeichnung varchar(40) not null
);

create table Land
(
  L_ID     int  not null
    constraint L_ID_PK
    primary key,
  Bezeichnung varchar(40) not null
);

create table Ort
(
  O_ID        int
    constraint O_ID_PK
    primary key,
  Bezeichnung varchar(100) not null,
  L_ID        int   not null
    constraint L_ID_FK
    references Land
);

create table Adresse
(
  Adr_ID  int
    constraint Adr_ID_PK
    primary key,
  PLZ     varchar(10),
  Strasse varchar(100),
  O_ID    int not null
    constraint O_ID_Adr_FK
    references Ort
);

create table Passagier
(
  P_ID   int
    constraint P_ID_PK
    primary key,
  Name   varchar(100) not null,
  A_ID   int
    constraint A_ID_Pass_FK
    references Anrede,
  Adr_ID int          not null
    constraint Adr_ID_Pass_FK
    references Adresse
);

create table Flughafen
(
  FH_ID char(3) not null
    constraint FH_ID_PK
    primary key
    constraint FH_ID_check
    check ([FH_ID] like '[A-Z][A-Z][A-Z]'),
  O_ID  int     not null
    constraint O_ID_Flugha_FK
    references Ort
);

create table Linie
(
  LI_ID int     not null
    constraint LI_ID_PK
    primary key,
  Von   char(3) not null
    constraint Von_FK
    references Flughafen,
  Nach  char(3) not null
    constraint Nach_FK
    references Flughafen,
  FG_ID char(2) not null
    constraint FG_FK
    references Fluggesellschaft,
  Dauer time    not null
);

create table Flug
(
  FL_ID int
    constraint FL_ID_PK
    primary key,
  Datum date          not null,
  Preis decimal(8, 2) not null,
  Platz int           not null,
  LI_ID int           not null
    constraint FL_Linie_FK
    references Linie,
  FT_ID int           not null
    constraint FL_Flugzeug_FK
   references FlugzeugTyp
);

create table BuchungsDaten
(
  BD_ID int not null,
  Nummer int  not null,
  Datum  date not null,
  P_ID   int  not null
    constraint P_ID_FK
    references Passagier,
  FL_ID  int  not null
    constraint FL_ID_FK
    references Flug
  );