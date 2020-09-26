CREATE TABLE doctors
(
  doctor_id    SERIAL PRIMARY KEY,
  first_name   varchar(30) NOT NULL,
  last_name    varchar(30) NOT NULL,
  title        varchar(40) NOT NULL,
  phone_number varchar(20) NULL
); 

CREATE TABLE patients
(
    patient_id    SERIAL        PRIMARY KEY,
    first_name    varchar(30)   NOT NULL,
    last_name     varchar(30)   NOT NULL
    phone_number  varchar(20)   NULL
);

CREATE TABLE appointment
(
  appointment_id         SERIAL                  PRIMARY KEY,
  patient_id             integer                 NOT NULL REFERENCES patients(patient_id),
  doctor_id              integer                 NOT NULL REFERENCES doctors(doctor_id),
  appointment_date       date                    NOT NULL,
  start_time             time without time zone  NOT NULL,
  end_date               time without time zone  NOT NULL
);
