
CREATE TABLE IF NOT EXISTS public.analysis
(
    id bigserial NOT NULL,
    describe varchar(255),
    name varchar(255),
    price integer NOT NULL,
    CONSTRAINT analysis_pkey PRIMARY KEY (id)
);

CREATE TABLE IF NOT EXISTS public.analysis_service_result
(
    id bigserial NOT NULL,
    create_date date,
    marks varchar(255),
    result varchar(255),
    submit_date date,
    title varchar(255),
    analysis_id bigint,
    bill_id bigint,
    client_id bigint,
    department_id bigint,
    service_id bigint,
    whomakecheck_id bigint,
    whosender_id bigint,
    CONSTRAINT analysis_service_result_pkey PRIMARY KEY (id)
);

CREATE TABLE IF NOT EXISTS public.bill
(
    id bigserial NOT NULL,
    create_date date,
    paid boolean,
    paid_date date,
    sum integer,
    client_id bigint,
    doctor_id bigint,
    CONSTRAINT bill_pkey PRIMARY KEY (id)
);

CREATE TABLE IF NOT EXISTS public.comments
(
    id bigserial NOT NULL,
    create_date date,
    description varchar(255),
    createuser_id bigint,
    CONSTRAINT comments_pkey PRIMARY KEY (id)
);

CREATE TABLE IF NOT EXISTS public.department
(
    id bigserial NOT NULL,
    dep_name varchar(255),
    CONSTRAINT department_pkey PRIMARY KEY (id)
);

CREATE TABLE IF NOT EXISTS public.department_users
(
    department_id bigint NOT NULL,
    doctorlist_id bigint NOT NULL
);

CREATE TABLE IF NOT EXISTS public.diseases
(
    id bigserial NOT NULL,
    name varchar(255),
    world_code varchar(255),
    CONSTRAINT diseases_pkey PRIMARY KEY (id)
);

CREATE TABLE IF NOT EXISTS public.pills
(
    id bigserial NOT NULL,
    active_element varchar(255),
    composition varchar(255),
    dosage varchar(255),
    name varchar(255),
    CONSTRAINT drugs_pkey PRIMARY KEY (id)
);

CREATE TABLE IF NOT EXISTS public.medcard
(
    id bigserial NOT NULL,
    blood_group varchar(6),
    chronic_disease varchar(100),
    create_date date,
    describe varchar(255),
    client_id bigint,
    therapydoctor_id bigint,
    CONSTRAINT medcard_pkey PRIMARY KEY (id)
);

CREATE TABLE IF NOT EXISTS public.medicalcard_body
(
    create_date date,
    future_date_recipient date,
    doctor_id bigint NOT NULL,
    client_id bigint NOT NULL,
    comment_id bigint,
    department_id bigint,
    disease_id bigint,
    medicalcard_id bigint,
    therapy_id bigint,
    CONSTRAINT medicalcard_body_pkey PRIMARY KEY (client_id, doctor_id)
);

CREATE TABLE IF NOT EXISTS public.medicalcard_body_analysis
(
    medicalcardbody_client_id bigint NOT NULL,
    medicalcardbody_doctor_id bigint NOT NULL,
    analysislist_id bigint NOT NULL
);

CREATE TABLE IF NOT EXISTS public.medicalcard_body_pills
(
    medicalcardbody_client_id bigint NOT NULL,
    medicalcardbody_doctor_id bigint NOT NULL,
    drugslist_id bigint NOT NULL
);

CREATE TABLE IF NOT EXISTS public.services
(
    id bigserial NOT NULL,
    active boolean NOT NULL,
    name varchar(255),
    price integer NOT NULL,
    CONSTRAINT services_pkey PRIMARY KEY (id)
);

CREATE TABLE IF NOT EXISTS public.therapy
(
    id bigserial NOT NULL,
    describe_complaint varchar(255),
    therapy varchar(255),
    disease_id bigint,
    CONSTRAINT therapy_pkey PRIMARY KEY (id)
);

CREATE TABLE IF NOT EXISTS public.users
(
    type_user varchar(31) NOT NULL,
    id bigserial NOT NULL,
    age integer,
    email varchar(64),
    family_name varchar(255),
    first_symbol_name character(1),
    full_name varchar(255),
    login varchar(32),
    online boolean NOT NULL,
    password varchar(32),
    status_user varchar(16),
    about varchar(255),
    actual_address varchar(255),
    birth_day date,
    phone_number varchar(12),
    certificate_number varchar(255),
    specialization_name varchar(255),
    where_study varchar(255),
    CONSTRAINT users_pkey PRIMARY KEY (id)
);

CREATE TABLE IF NOT EXISTS public.users_services
(
    doctor_id bigint NOT NULL,
    myservices_id bigint NOT NULL,
    CONSTRAINT users_services_pkey PRIMARY KEY (doctor_id, myservices_id)
);

CREATE TABLE IF NOT EXISTS public.workflow
(
    id bigserial NOT NULL,
    start_date timestamp,
    end_date timestamp,
    size_client integer,
    worked boolean NOT NULL,
    doctor_id bigint,
    service_id bigint,
    CONSTRAINT workflow_pkey PRIMARY KEY (id)
);

CREATE TABLE IF NOT EXISTS public.workflow_body
(
    create_date date,
    describe_complaint varchar(255),
    doctor_id bigint NOT NULL,
    client_id bigint NOT NULL,
    service_id bigint,
    workflow_id bigint,
    CONSTRAINT workflow_body_pkey PRIMARY KEY (client_id, doctor_id)
);
