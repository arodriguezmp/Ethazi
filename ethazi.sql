drop database if exists agentzia;
create database agentzia character set utf8 COLLATE utf8_bin;
use agentzia;
create table pertsonak(
    nan varchar(9) PRIMARY KEY,
    izena varchar(15),
    abizena varchar(20),
    email varchar(50),
    tfno varchar(9)
);

create table langileak(
    nan varchar(9) PRIMARY KEY,
    admin varchar(3) DEFAULT 'ez',
    lan_postua varchar(20),
    CONSTRAINT FK1
        FOREIGN KEY (nan)
            REFERENCES pertsonak (nan)
);
create table bezeroak(
    nan varchar(9) PRIMARY KEY,
    bezero_zbk int,
    CONSTRAINT FK2
        FOREIGN KEY (nan)
            REFERENCES pertsonak (nan)
);
create table ostatuak(
    kod_ostatua int AUTO_INCREMENT PRIMARY KEY,
    pertsona_kop_max int
);
create table hotelak(
    kod_ostatua int PRIMARY KEY,
    gela_mota varchar(20),
    gela_zenb int(3),
    CONSTRAINT FK5
        FOREIGN KEY (kod_ostatua)
            REFERENCES ostatuak (kod_ostatua)
);
create table apartamentuak(
    kod_ostatua int PRIMARY KEY,
    komun_kop int,
    logela_kop int,
    CONSTRAINT FK6
        FOREIGN KEY (kod_ostatua)
            REFERENCES ostatuak (kod_ostatua)
);
create table kruzeroak(
    kod_ostatua int PRIMARY KEY,
    kamarote_zenb int(3),
    klasea varchar(30),
    kamarote_mota varchar(100),
    CONSTRAINT FK7
        FOREIGN KEY (kod_ostatua)
            REFERENCES ostatuak (kod_ostatua)
);
create table erreserbak(
    nan varchar(9),
    kod_ostatua int,
    hasiera_data date,
    amaiera_data date,
    prezioa int,
    PRIMARY KEY (nan, kod_ostatua),
    CONSTRAINT FK3
        FOREIGN KEY (nan)
            REFERENCES bezeroak (nan),
    CONSTRAINT FK4
        FOREIGN KEY (kod_ostatua)
            REFERENCES ostatuak (kod_ostatua)
);

/*--------------------------------------------------PERTSONAK--------------------------------------------------*/
INSERT INTO pertsonak (nan, izena, abizena, email, tfno) 
VALUES ('11111111A', 'Aimar', 'Rodriguez', 'a_rodriguezm@fpzornotza.com', '111111111');

INSERT INTO pertsonak (nan, izena, abizena, email, tfno) 
VALUES ('22222222B', 'Unatz', 'Garcia', 'u_garcia@fpzornotza.com', '222222222');

INSERT INTO pertsonak (nan, izena, abizena, email, tfno) 
VALUES ('33333333C', 'Josu', 'Foruria', 'j_foruria@fpzornotza.com', '333333333');

INSERT INTO pertsonak (nan, izena, abizena, email, tfno) 
VALUES ('44444444D', 'Ugaitz', 'Bilbao', 'u_bilbao@fpzornotza.com', '444444444');

INSERT INTO pertsonak (nan, izena, abizena, email, tfno) 
VALUES ('55555555E', 'Eider', 'Galarraga', 'e_galarraga@fpzornotza.com', '555555555');

INSERT INTO pertsonak (nan, izena, abizena, email, tfno) 
VALUES ('66666666F', 'Leire', 'Trabado', 'l_trabado@fpzornotza.com', '666666666');

INSERT INTO pertsonak (nan, izena, abizena, email, tfno) 
VALUES ('77777777G', 'Alots', 'Ayarza', 'a_ayarza@fpzornotza.com', '777777777');

INSERT INTO pertsonak (nan, izena, abizena, email, tfno) 
VALUES ('88888888H', 'Asier', 'Iza', 'a_iza@fpzornotza.com', '888888888');

/*--------------------------------------------------LANGILEAK--------------------------------------------------*/
INSERT INTO langileak (nan, admin, lan_postua) 
VALUES ('11111111A', 'bai', 'Administratzailea');

INSERT INTO langileak (nan, admin, lan_postua) 
VALUES ('22222222B', 'ez', 'Programatzailea');

INSERT INTO langileak (nan, admin, lan_postua) 
VALUES ('33333333C', 'bai', 'Administratzailea');

INSERT INTO langileak (nan, admin, lan_postua) 
VALUES ('44444444D', 'bai', 'Administratzailea');

/*--------------------------------------------------BEZEROAK---------------------------------------------------*/
INSERT INTO bezeroak (nan, bezero_zbk) 
VALUES ('55555555E', 1);

INSERT INTO bezeroak (nan, bezero_zbk) 
VALUES ('66666666F', 2);

INSERT INTO bezeroak (nan, bezero_zbk) 
VALUES ('77777777G', 3);

INSERT INTO bezeroak (nan, bezero_zbk) 
VALUES ('88888888H', 4);

/*--------------------------------------------------OSTATUAK---------------------------------------------------*/
INSERT INTO ostatuak (pertsona_kop_max)
VALUES (5);

INSERT INTO ostatuak (pertsona_kop_max)
VALUES (12);

INSERT INTO ostatuak (pertsona_kop_max)
VALUES (2);

INSERT INTO ostatuak (pertsona_kop_max)
VALUES (1);

INSERT INTO ostatuak (pertsona_kop_max)
VALUES (2);

INSERT INTO ostatuak (pertsona_kop_max)
VALUES (4);

INSERT INTO ostatuak (pertsona_kop_max)
VALUES (3);

INSERT INTO ostatuak (pertsona_kop_max)
VALUES (7);

INSERT INTO ostatuak (pertsona_kop_max)
VALUES (1);

/*--------------------------------------------------APARTAMENTUAK---------------------------------------------------*/
INSERT INTO apartamentuak (kod_ostatua, komun_kop, logela_kop) VALUES (1, 2, 3);

INSERT INTO apartamentuak (kod_ostatua, komun_kop, logela_kop) VALUES (2, 4, 7);

INSERT INTO apartamentuak (kod_ostatua, komun_kop, logela_kop) VALUES (8, 3, 4);

/*--------------------------------------------------HOTELAK---------------------------------------------------*/
INSERT INTO hotelak (kod_ostatua, gela_mota, gela_zenb) VALUES (4, 'Bikoitza', 340);

INSERT INTO hotelak (kod_ostatua, gela_mota, gela_zenb) VALUES (5, 'Bakarra', 131);

INSERT INTO hotelak (kod_ostatua, gela_mota, gela_zenb) VALUES (7, 'Suite', 506);

/*--------------------------------------------------KRUZEROAK---------------------------------------------------*/
INSERT INTO kruzeroak (kod_ostatua, kamarote_zenb, klasea, kamarote_mota) VALUES (3, 004, '3. klasea', 'Itsasora bistak izango dituzu');

INSERT INTO kruzeroak (kod_ostatua, kamarote_zenb, klasea, kamarote_mota) VALUES (6, 055, '3.klasea', 'Kruzero barrualdera bistak izango dituzu');

INSERT INTO kruzeroak (kod_ostatua, kamarote_zenb, klasea, kamarote_mota) VALUES (9, 902, '1. klasea', 'Itsasora bistak izango dituzu kruzeroko pisurik altuenetik');

/*--------------------------------------------------ERRESERBAK---------------------------------------------------*/
INSERT INTO erreserbak (nan, kod_ostatua, hasiera_data, amaiera_data, prezioa) VALUES ('55555555E', 8, '2023-03-31', '2023-04-07', 500);

INSERT INTO erreserbak (nan, kod_ostatua, hasiera_data, amaiera_data, prezioa) VALUES ('88888888H', 8, '2023-07-12', '2023-07-15', 237);

INSERT INTO erreserbak (nan, kod_ostatua, hasiera_data, amaiera_data, prezioa) VALUES ('66666666F', 4, '2023-03-31', '2023-04-07', 150);

INSERT INTO erreserbak (nan, kod_ostatua, hasiera_data, amaiera_data, prezioa) VALUES ('77777777G', 5, '2023-09-01', '2023-09-30', 750);

INSERT INTO erreserbak (nan, kod_ostatua, hasiera_data, amaiera_data, prezioa) VALUES ('88888888H', 1, '2025-01-16', '2025-01-26', 100);

INSERT INTO erreserbak (nan, kod_ostatua, hasiera_data, amaiera_data, prezioa) VALUES ('77777777G', 2, '2023-08-27', '2023-09-01', 314);

INSERT INTO erreserbak (nan, kod_ostatua, hasiera_data, amaiera_data, prezioa) VALUES ('55555555E', 3, '2023-03-31', '2023-04-07', 500);

INSERT INTO erreserbak (nan, kod_ostatua, hasiera_data, amaiera_data, prezioa) VALUES ('66666666F', 6, '2024-10-25', '2024-11-25', 900);

INSERT INTO erreserbak (nan, kod_ostatua, hasiera_data, amaiera_data, prezioa) VALUES ('77777777G', 9, '2023-10-14', '2023-12-14', 1800);

CREATE TABLE langile_ezabatuak(
    nan varchar(9) PRIMARY KEY,
    admin varchar(3) DEFAULT 'ez',
    lan_postua varchar(20),
    fecha_eliminar date
);

DELIMITER $$
DROP TRIGGER IF EXISTS kopiatu_langile_ezabatua$$
CREATE TRIGGER kopiatu_langile_ezabatua
BEFORE DELETE
ON langileak FOR EACH ROW
BEGIN
INSERT INTO langile_ezabatuak(nan, admin, lan_postua, fecha_eliminar) VALUES(old.nan,old.admin,old.lan_postua,sysdate());
END $$

DELIMITER $$
DROP TRIGGER IF EXISTS langile_aldatuak$$
CREATE TRIGGER langile_aldatuak
BEFORE UPDATE
ON langileak FOR EACH ROW
BEGIN
INSERT into langile_aldatuak( nan , admin , lan_postua ,  fecha) values( OLD.nan , OLD.admin , OLD.lan_postua ,  sysdate());
END$$

DELIMITER $$
DROP PROCEDURE IF EXISTS listar_pertsona_bezero$$
CREATE PROCEDURE listar_pertsona_bezero ()
BEGIN
SELECT p.*,b.* 
FROM pertsonak p, bezeroak b;
end$$