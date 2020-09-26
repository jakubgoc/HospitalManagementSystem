INSERT INTO doctors (doctor_id,first_name,last_name,title,phone_number)
VALUES 
  (1,'Sergio','Decker','Head Chief of Medicine',111111111),
  (2,'James','Clark','Attending Psychiatrist',222222222),
  (3,'Barbara','White','Senior Attending Physician',333333333),
  (4,'Andrew','Johnson','Staff Internist',444444444),
  (5,'Sam','Smith','MD Resident',555555555);

INSERT INTO patients (patient_id,first_name,last_name,phone_number)
VALUES 
  (1,'Thane','Molly',321456827),
  (2,'Mahim','Richard',938726351),
  (3,'James','McFlurren',998735142),
  (4,'Abraham','Doe',555472133);

INSERT INTO appointments (appointment_id,patient_id,doctor_id,appointment_date,start_time,end_time)
VALUES 
  (1,2,2,'2020-04-09','9:00','9:45'),
  (2,4,5,'2020-04-09','10:00','11:00'),
  (3,1,3,'2020-04-10','11:30','12:00');