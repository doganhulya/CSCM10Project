INSERT INTO TEMPERATURE (
   ID, CREATEDBY, CREATEDDATE, DEVICEID, MEASUREMENT, MEASUREMENTTYPE) 
VALUES ( 1, 1,(select CURRENT_TIMESTAMP()), 'RASPBERRY-PI-1265', 25, 0);