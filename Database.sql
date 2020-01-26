CREATE USER busadmin WITH
  LOGIN
  SUPERUSER
  INHERIT
  CREATEDB
  CREATEROLE
  REPLICATION
  PASSWORD 'busadmin1';

CREATE DATABASE busdata
    WITH 
    OWNER = busadmin
    ENCODING = 'UTF8'
    LC_COLLATE = 'English_United States.1252'
    LC_CTYPE = 'English_United States.1252'
    TABLESPACE = pg_default
    CONNECTION LIMIT = -1;
    
Create SCHEMA bus;

CREATE TABLE bus (bus varchar(20),
	PRIMARY KEY (bus));

CREATE TABLE busStops(busstop varchar(50),
	PRIMARY KEY (busstop));

CREATE TABLE schedule (
	Bus varchar(20) NOT NULL,
	busStop varchar(50) NOT NULL,
	dayOfTheWeek varchar(20),
	time Time,
	FOREIGN KEY  (bus) REFERENCES bus.bus(bus) ON DELETE CASCADE,
	FOREIGN KEY (busStop) REFERENCES bus.busstops(busstop) ON DELETE CASCADE);

CREATE TABLE delay(
	bus varchar(20) not null,
	busStop varchar(50) NOT NULL,
	delay INTEGER,
	date DATE,
	FOREIGN KEY (bus) REFERENCES bus.bus(bus) ON DELETE CASCADE,
	FOREIGN KEY (busStop) REFERENCES bus.busstops(busstop) ON DELETE CASCADE); 
	
INSERT INTO bus.bus (bus) VALUES('bus1');
INSERT INTO bus.bus (bus) VALUES('bus2');

INSERT INTO bus.busstops (busstop) VALUES('BUS DEPOT');
INSERT INTO bus.busstops (busstop) VALUES('HILL STREET');
INSERT INTO bus.busstops (busstop) VALUES('SHETLAND');
INSERT INTO bus.busstops (busstop) VALUES('KRATZ RD');
INSERT INTO bus.busstops (busstop) VALUES('MORGAN DR');
INSERT INTO bus.busstops (busstop) VALUES('MIDDLE SCHOOL');
INSERT INTO bus.busstops (busstop) VALUES('HIGH SCHOOL');

INSERT INTO bus.schedule (bus, busstop, dayoftheweek, "time") VALUES('bus1', 'BUS DEPOT', 'MONDAY', '08:00:00');
INSERT INTO bus.schedule (bus, busstop, dayoftheweek, "time") VALUES('bus1', 'HILL STREET', 'MONDAY', '09:00:00');
INSERT INTO bus.schedule (bus, busstop, dayoftheweek, "time") VALUES('bus1', 'SHETLAND', 'MONDAY', '10:00:00');
INSERT INTO bus.schedule (bus, busstop, dayoftheweek, "time") VALUES('bus1', 'KRATZ RD', 'MONDAY', '11:00:00');
INSERT INTO bus.schedule (bus, busstop, dayoftheweek, "time") VALUES('bus1', 'MORGAN DR', 'MONDAY', '12:00:00');
INSERT INTO bus.schedule (bus, busstop, dayoftheweek, "time") VALUES('bus1', 'MIDDLE SCHOOL', 'MONDAY', '13:00:00');
INSERT INTO bus.schedule (bus, busstop, dayoftheweek, "time") VALUES('bus1', 'HIGH SCHOOL', 'MONDAY', '14:00:00');

INSERT INTO bus.schedule (bus, busstop, dayoftheweek, "time") VALUES('bus2', 'BUS DEPOT', 'MONDAY', '08:00:00');
INSERT INTO bus.schedule (bus, busstop, dayoftheweek, "time") VALUES('bus2', 'HILL STREET', 'MONDAY', '09:00:00');
INSERT INTO bus.schedule (bus, busstop, dayoftheweek, "time") VALUES('bus2', 'SHETLAND', 'MONDAY', '10:00:00');
INSERT INTO bus.schedule (bus, busstop, dayoftheweek, "time") VALUES('bus2', 'KRATZ RD', 'MONDAY', '11:00:00');
INSERT INTO bus.schedule (bus, busstop, dayoftheweek, "time") VALUES('bus2', 'MORGAN DR', 'MONDAY', '12:00:00');
INSERT INTO bus.schedule (bus, busstop, dayoftheweek, "time") VALUES('bus2', 'MIDDLE SCHOOL', 'MONDAY', '13:00:00');
INSERT INTO bus.schedule (bus, busstop, dayoftheweek, "time") VALUES('bus2', 'HIGH SCHOOL', 'MONDAY', '14:00:00');



SELECT s.busstop , s."time" FROM bus.schedule s WHERE s.bus = 'bus1' AND s.dayoftheweek = 'MONDAY' ORDER BY s."time";

SELECT s.bus, s."time" , avg(d.delay) FROM bus.schedule s JOIN bus.delay d on d.bus = s.bus and d.busstop = s.busstop
WHERE s.busstop = 'HIGH SCHOOL' AND s.dayoftheweek = 'MONDAY' GROUP BY s."time", s.bus;

SELECT s.bus, s.time , avg(d.delay) FROM bus.schedule s JOIN bus.delay d on d.bus = s.bus and d.busstop = s.busstop
			WHERE s.busstop = 'busstop' AND s.dayoftheweek = 'day' GROUP BY s.time, s.bus;

SELECT s.bus, s.time FROM bus.schedule s WHERE s.busstop = 'HIGH SCHOOL' AND s.dayoftheweek = 'MONDAY' ORDER BY s."time";

SELECT s.busstop FROM bus.schedule s  WHERE s.bus = 'bus1';

SELECT d.delay FROM bus.delay d WHERE d.bus = 'bus2' and d.busstop = 'HIGH SCHOOL' and d."date" = '05/22/2017';
