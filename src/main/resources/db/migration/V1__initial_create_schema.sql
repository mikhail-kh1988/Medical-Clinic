
CREATE TABLE IF NOT EXISTS public.analysis
(
    id bigint NOT NULL GENERATED BY DEFAULT AS IDENTITY ( INCREMENT 1 START 1 MINVALUE 1 MAXVALUE 9223372036854775807 CACHE 1 ),
    describe character varying(255) COLLATE pg_catalog."default",
    name character varying(255) COLLATE pg_catalog."default",
    price integer NOT NULL,
    CONSTRAINT analysis_pkey PRIMARY KEY (id)
)
WITH (
    OIDS = FALSE
);

CREATE TABLE IF NOT EXISTS public.analysis_service_result
(
    id bigint NOT NULL GENERATED BY DEFAULT AS IDENTITY ( INCREMENT 1 START 1 MINVALUE 1 MAXVALUE 9223372036854775807 CACHE 1 ),
    create_date date,
    marks character varying(255) COLLATE pg_catalog."default",
    result character varying(255) COLLATE pg_catalog."default",
    submit_date date,
    title character varying(255) COLLATE pg_catalog."default",
    analysis_id bigint,
    bill_id bigint,
    client_id bigint,
    department_id bigint,
    service_id bigint,
    whomakecheck_id bigint,
    whosender_id bigint,
    CONSTRAINT analysis_service_result_pkey PRIMARY KEY (id)
)
WITH (
    OIDS = FALSE
);

CREATE TABLE IF NOT EXISTS public.bill
(
    id bigint NOT NULL GENERATED BY DEFAULT AS IDENTITY ( INCREMENT 1 START 1 MINVALUE 1 MAXVALUE 9223372036854775807 CACHE 1 ),
    create_date date,
    paid boolean,
    paid_date date,
    sum integer,
    client_id bigint,
    doctor_id bigint,
    CONSTRAINT bill_pkey PRIMARY KEY (id)
)
WITH (
    OIDS = FALSE
);

CREATE TABLE IF NOT EXISTS public.comments
(
    id bigint NOT NULL GENERATED BY DEFAULT AS IDENTITY ( INCREMENT 1 START 1 MINVALUE 1 MAXVALUE 9223372036854775807 CACHE 1 ),
    create_date date,
    description character varying(255) COLLATE pg_catalog."default",
    createuser_id bigint,
    CONSTRAINT comments_pkey PRIMARY KEY (id)
)
WITH (
    OIDS = FALSE
);

CREATE TABLE IF NOT EXISTS public.department
(
    id bigint NOT NULL GENERATED BY DEFAULT AS IDENTITY ( INCREMENT 1 START 1 MINVALUE 1 MAXVALUE 9223372036854775807 CACHE 1 ),
    dep_name character varying(255) COLLATE pg_catalog."default",
    CONSTRAINT department_pkey PRIMARY KEY (id)
)
WITH (
    OIDS = FALSE
);

CREATE TABLE IF NOT EXISTS public.department_users
(
    department_id bigint NOT NULL,
    doctorlist_id bigint NOT NULL
)
WITH (
    OIDS = FALSE
);

CREATE TABLE IF NOT EXISTS public.diseases
(
    id bigint NOT NULL GENERATED BY DEFAULT AS IDENTITY ( INCREMENT 1 START 1 MINVALUE 1 MAXVALUE 9223372036854775807 CACHE 1 ),
    external_code character varying(255) COLLATE pg_catalog."default",
    internal_code character varying(255) COLLATE pg_catalog."default",
    name character varying(255) COLLATE pg_catalog."default",
    world_code character varying(255) COLLATE pg_catalog."default",
    CONSTRAINT diseases_pkey PRIMARY KEY (id)
)
WITH (
    OIDS = FALSE
);

CREATE TABLE IF NOT EXISTS public.drugs
(
    id bigint NOT NULL GENERATED BY DEFAULT AS IDENTITY ( INCREMENT 1 START 1 MINVALUE 1 MAXVALUE 9223372036854775807 CACHE 1 ),
    active_element character varying(255) COLLATE pg_catalog."default",
    composition character varying(255) COLLATE pg_catalog."default",
    dosage character varying(255) COLLATE pg_catalog."default",
    name character varying(255) COLLATE pg_catalog."default",
    CONSTRAINT drugs_pkey PRIMARY KEY (id)
)
WITH (
    OIDS = FALSE
);

CREATE TABLE IF NOT EXISTS public.medcard
(
    id bigint NOT NULL GENERATED BY DEFAULT AS IDENTITY ( INCREMENT 1 START 1 MINVALUE 1 MAXVALUE 9223372036854775807 CACHE 1 ),
    blood_group character varying(6) COLLATE pg_catalog."default",
    chronic_disease character varying(100) COLLATE pg_catalog."default",
    create_date date,
    describe character varying(255) COLLATE pg_catalog."default",
    client_id bigint,
    therapydoctor_id bigint,
    CONSTRAINT medcard_pkey PRIMARY KEY (id)
)
WITH (
    OIDS = FALSE
);

CREATE TABLE IF NOT EXISTS public.medicalcard_body
(
    create_date date,
    future_date_recipient date,
    therapy_closed boolean,
    doctor_id bigint NOT NULL,
    client_id bigint NOT NULL,
    comment_id bigint,
    department_id bigint,
    disease_id bigint,
    medicalcard_id bigint,
    therapy_id bigint,
    CONSTRAINT medicalcard_body_pkey PRIMARY KEY (client_id, doctor_id)
)
WITH (
    OIDS = FALSE
);

CREATE TABLE IF NOT EXISTS public.medicalcard_body_analysis
(
    medicalcardbody_client_id bigint NOT NULL,
    medicalcardbody_doctor_id bigint NOT NULL,
    analysislist_id bigint NOT NULL
)
WITH (
    OIDS = FALSE
);

CREATE TABLE IF NOT EXISTS public.medicalcard_body_drugs
(
    medicalcardbody_client_id bigint NOT NULL,
    medicalcardbody_doctor_id bigint NOT NULL,
    drugslist_id bigint NOT NULL
)
WITH (
    OIDS = FALSE
);

CREATE TABLE IF NOT EXISTS public.services
(
    id bigint NOT NULL GENERATED BY DEFAULT AS IDENTITY ( INCREMENT 1 START 1 MINVALUE 1 MAXVALUE 9223372036854775807 CACHE 1 ),
    active boolean NOT NULL,
    describe character varying(255) COLLATE pg_catalog."default",
    external_code character varying(255) COLLATE pg_catalog."default",
    name character varying(255) COLLATE pg_catalog."default",
    price integer NOT NULL,
    CONSTRAINT services_pkey PRIMARY KEY (id)
)
WITH (
    OIDS = FALSE
);

CREATE TABLE IF NOT EXISTS public.therapy
(
    id bigint NOT NULL GENERATED BY DEFAULT AS IDENTITY ( INCREMENT 1 START 1 MINVALUE 1 MAXVALUE 9223372036854775807 CACHE 1 ),
    describe_complaint character varying(255) COLLATE pg_catalog."default",
    therapy character varying(255) COLLATE pg_catalog."default",
    disease_id bigint,
    CONSTRAINT therapy_pkey PRIMARY KEY (id)
)
WITH (
    OIDS = FALSE
);

CREATE TABLE IF NOT EXISTS public.users
(
    type_user character varying(31) COLLATE pg_catalog."default" NOT NULL,
    id bigint NOT NULL GENERATED BY DEFAULT AS IDENTITY ( INCREMENT 1 START 1 MINVALUE 1 MAXVALUE 9223372036854775807 CACHE 1 ),
    age integer,
    email character varying(64) COLLATE pg_catalog."default",
    family_name character varying(255) COLLATE pg_catalog."default",
    first_symbol_name character(1) COLLATE pg_catalog."default",
    full_name character varying(255) COLLATE pg_catalog."default",
    login character varying(32) COLLATE pg_catalog."default",
    online boolean NOT NULL,
    password character varying(32) COLLATE pg_catalog."default",
    status_user character varying(16) COLLATE pg_catalog."default",
    about character varying(255) COLLATE pg_catalog."default",
    actual_address character varying(255) COLLATE pg_catalog."default",
    birth_day date,
    phone_number character varying(12) COLLATE pg_catalog."default",
    certificate_number character varying(255) COLLATE pg_catalog."default",
    specialization_name character varying(255) COLLATE pg_catalog."default",
    where_study character varying(255) COLLATE pg_catalog."default",
    CONSTRAINT users_pkey PRIMARY KEY (id)
)
WITH (
    OIDS = FALSE
);

CREATE TABLE IF NOT EXISTS public.users_services
(
    doctor_id bigint NOT NULL,
    myservices_id bigint NOT NULL,
    CONSTRAINT users_services_pkey PRIMARY KEY (doctor_id, myservices_id)
)
WITH (
    OIDS = FALSE
);

CREATE TABLE IF NOT EXISTS public.workflow
(
    id bigint NOT NULL GENERATED BY DEFAULT AS IDENTITY ( INCREMENT 1 START 1 MINVALUE 1 MAXVALUE 9223372036854775807 CACHE 1 ),
    end_date date,
    size_client integer,
    start_date date,
    worked boolean NOT NULL,
    doctor_id bigint,
    service_id bigint,
    CONSTRAINT workflow_pkey PRIMARY KEY (id)
)
WITH (
    OIDS = FALSE
);

CREATE TABLE IF NOT EXISTS public.workflow_body
(
    create_date date,
    describe_complaint character varying(255) COLLATE pg_catalog."default",
    receipt boolean,
    receipt_date date,
    doctor_id bigint NOT NULL,
    client_id bigint NOT NULL,
    service_id bigint,
    workflow_id bigint,
    CONSTRAINT workflow_body_pkey PRIMARY KEY (client_id, doctor_id)
)
WITH (
    OIDS = FALSE
);

ALTER TABLE IF EXISTS public.analysis_service_result
    ADD CONSTRAINT fk5j8howkefwtlmx3tb704dh8o6 FOREIGN KEY (department_id)
    REFERENCES public.department (id) MATCH SIMPLE
    ON UPDATE NO ACTION
    ON DELETE NO ACTION;


ALTER TABLE IF EXISTS public.analysis_service_result
    ADD CONSTRAINT fkbrftlv1k176ju47vtqcixsog1 FOREIGN KEY (client_id)
    REFERENCES public.users (id) MATCH SIMPLE
    ON UPDATE NO ACTION
    ON DELETE NO ACTION;


ALTER TABLE IF EXISTS public.analysis_service_result
    ADD CONSTRAINT fkhpme9k3n3vfrpnjau4rg52f28 FOREIGN KEY (service_id)
    REFERENCES public.services (id) MATCH SIMPLE
    ON UPDATE NO ACTION
    ON DELETE NO ACTION;


ALTER TABLE IF EXISTS public.analysis_service_result
    ADD CONSTRAINT fkibnth3x4hyl9p3qv7h0hf1d01 FOREIGN KEY (bill_id)
    REFERENCES public.bill (id) MATCH SIMPLE
    ON UPDATE NO ACTION
    ON DELETE NO ACTION;


ALTER TABLE IF EXISTS public.analysis_service_result
    ADD CONSTRAINT fklet7h5r5qar0rqlk1diwscly3 FOREIGN KEY (whomakecheck_id)
    REFERENCES public.users (id) MATCH SIMPLE
    ON UPDATE NO ACTION
    ON DELETE NO ACTION;


ALTER TABLE IF EXISTS public.analysis_service_result
    ADD CONSTRAINT fkode9gwxfi1x9ossdyjhhnoubf FOREIGN KEY (whosender_id)
    REFERENCES public.users (id) MATCH SIMPLE
    ON UPDATE NO ACTION
    ON DELETE NO ACTION;


ALTER TABLE IF EXISTS public.analysis_service_result
    ADD CONSTRAINT fks5uqiwbx0ymshja38ddhrg609 FOREIGN KEY (analysis_id)
    REFERENCES public.analysis (id) MATCH SIMPLE
    ON UPDATE NO ACTION
    ON DELETE NO ACTION;


ALTER TABLE IF EXISTS public.bill
    ADD CONSTRAINT fkjes30gh7rbw3hs7xas354x3so FOREIGN KEY (client_id)
    REFERENCES public.users (id) MATCH SIMPLE
    ON UPDATE NO ACTION
    ON DELETE NO ACTION;


ALTER TABLE IF EXISTS public.bill
    ADD CONSTRAINT fkk0f22c47tms3dupoa90tp4jat FOREIGN KEY (doctor_id)
    REFERENCES public.users (id) MATCH SIMPLE
    ON UPDATE NO ACTION
    ON DELETE NO ACTION;


ALTER TABLE IF EXISTS public.comments
    ADD CONSTRAINT fkcbvf8i6cgn4uq3ykg1ybpuml0 FOREIGN KEY (createuser_id)
    REFERENCES public.users (id) MATCH SIMPLE
    ON UPDATE NO ACTION
    ON DELETE NO ACTION;


ALTER TABLE IF EXISTS public.department_users
    ADD CONSTRAINT fk65euopk2uidepg5txf4xtlnrs FOREIGN KEY (department_id)
    REFERENCES public.department (id) MATCH SIMPLE
    ON UPDATE NO ACTION
    ON DELETE NO ACTION;


ALTER TABLE IF EXISTS public.department_users
    ADD CONSTRAINT fkrqjoqr79fps187629xhaygfbh FOREIGN KEY (doctorlist_id)
    REFERENCES public.users (id) MATCH SIMPLE
    ON UPDATE NO ACTION
    ON DELETE NO ACTION;
CREATE INDEX IF NOT EXISTS uk_8dma589sbu76pv49hx5ue3sp5
    ON public.department_users(doctorlist_id);


ALTER TABLE IF EXISTS public.medcard
    ADD CONSTRAINT fkceifb357815l9kfcld0c9mxw2 FOREIGN KEY (therapydoctor_id)
    REFERENCES public.users (id) MATCH SIMPLE
    ON UPDATE NO ACTION
    ON DELETE NO ACTION;


ALTER TABLE IF EXISTS public.medcard
    ADD CONSTRAINT fkcnnablgecuvbjs9qncrj6fw03 FOREIGN KEY (client_id)
    REFERENCES public.users (id) MATCH SIMPLE
    ON UPDATE NO ACTION
    ON DELETE NO ACTION;


ALTER TABLE IF EXISTS public.medicalcard_body
    ADD CONSTRAINT fk1rob1xj0teps58f2o8ospemtv FOREIGN KEY (department_id)
    REFERENCES public.department (id) MATCH SIMPLE
    ON UPDATE NO ACTION
    ON DELETE NO ACTION;


ALTER TABLE IF EXISTS public.medicalcard_body
    ADD CONSTRAINT fk92vai7ruc1pwkag4sjjw5splg FOREIGN KEY (doctor_id)
    REFERENCES public.users (id) MATCH SIMPLE
    ON UPDATE NO ACTION
    ON DELETE NO ACTION;


ALTER TABLE IF EXISTS public.medicalcard_body
    ADD CONSTRAINT fkcg03tqk78kmtc42a1arinxfjd FOREIGN KEY (disease_id)
    REFERENCES public.diseases (id) MATCH SIMPLE
    ON UPDATE NO ACTION
    ON DELETE NO ACTION;


ALTER TABLE IF EXISTS public.medicalcard_body
    ADD CONSTRAINT fkd28fqtngdrlt5xwo4a3nygbmn FOREIGN KEY (comment_id)
    REFERENCES public.comments (id) MATCH SIMPLE
    ON UPDATE NO ACTION
    ON DELETE NO ACTION;


ALTER TABLE IF EXISTS public.medicalcard_body
    ADD CONSTRAINT fkfki1k5to3q0fv3bye3psakyxm FOREIGN KEY (client_id)
    REFERENCES public.users (id) MATCH SIMPLE
    ON UPDATE NO ACTION
    ON DELETE NO ACTION;


ALTER TABLE IF EXISTS public.medicalcard_body
    ADD CONSTRAINT fknvytusuo1tfr563va6daeu3sy FOREIGN KEY (medicalcard_id)
    REFERENCES public.medcard (id) MATCH SIMPLE
    ON UPDATE NO ACTION
    ON DELETE NO ACTION;


ALTER TABLE IF EXISTS public.medicalcard_body
    ADD CONSTRAINT fkr020b5r74ffqcnlswh7y1lny0 FOREIGN KEY (therapy_id)
    REFERENCES public.therapy (id) MATCH SIMPLE
    ON UPDATE NO ACTION
    ON DELETE NO ACTION;


ALTER TABLE IF EXISTS public.medicalcard_body_analysis
    ADD CONSTRAINT fkdpa5eix2kcjeyr67v09fqs842 FOREIGN KEY (medicalcardbody_client_id, medicalcardbody_doctor_id)
    REFERENCES public.medicalcard_body (client_id, doctor_id) MATCH SIMPLE
    ON UPDATE NO ACTION
    ON DELETE NO ACTION;


ALTER TABLE IF EXISTS public.medicalcard_body_analysis
    ADD CONSTRAINT fkorkmybrs13kcngw41tafqn8fh FOREIGN KEY (analysislist_id)
    REFERENCES public.analysis (id) MATCH SIMPLE
    ON UPDATE NO ACTION
    ON DELETE NO ACTION;
CREATE INDEX IF NOT EXISTS uk_m3wuphwlqehnqhci6dtdj9i8f
    ON public.medicalcard_body_analysis(analysislist_id);


ALTER TABLE IF EXISTS public.medicalcard_body_drugs
    ADD CONSTRAINT fkmaennod6vunmfnfio6yhm6ag7 FOREIGN KEY (medicalcardbody_client_id, medicalcardbody_doctor_id)
    REFERENCES public.medicalcard_body (client_id, doctor_id) MATCH SIMPLE
    ON UPDATE NO ACTION
    ON DELETE NO ACTION;


ALTER TABLE IF EXISTS public.medicalcard_body_drugs
    ADD CONSTRAINT fksr1o6vx87aftmqoq4rdrny68p FOREIGN KEY (drugslist_id)
    REFERENCES public.drugs (id) MATCH SIMPLE
    ON UPDATE NO ACTION
    ON DELETE NO ACTION;
CREATE INDEX IF NOT EXISTS uk_3plqscu6n8b38dmxxr1gv127y
    ON public.medicalcard_body_drugs(drugslist_id);


ALTER TABLE IF EXISTS public.therapy
    ADD CONSTRAINT fkqatnxy1q70q1al03dnjqcvohq FOREIGN KEY (disease_id)
    REFERENCES public.diseases (id) MATCH SIMPLE
    ON UPDATE NO ACTION
    ON DELETE NO ACTION;


ALTER TABLE IF EXISTS public.users_services
    ADD CONSTRAINT fk7sqopl0ua28985jwp7h189us2 FOREIGN KEY (doctor_id)
    REFERENCES public.users (id) MATCH SIMPLE
    ON UPDATE NO ACTION
    ON DELETE NO ACTION;


ALTER TABLE IF EXISTS public.users_services
    ADD CONSTRAINT fkadn8d6s6bqqe0byum88dpl9vx FOREIGN KEY (myservices_id)
    REFERENCES public.services (id) MATCH SIMPLE
    ON UPDATE NO ACTION
    ON DELETE NO ACTION;
CREATE INDEX IF NOT EXISTS uk_l7k9fe12ivy4q6b9mr2p1fax1
    ON public.users_services(myservices_id);


ALTER TABLE IF EXISTS public.workflow
    ADD CONSTRAINT fka0iyvvhg9lh8e6rbv6jxwy23i FOREIGN KEY (service_id)
    REFERENCES public.services (id) MATCH SIMPLE
    ON UPDATE NO ACTION
    ON DELETE NO ACTION;


ALTER TABLE IF EXISTS public.workflow
    ADD CONSTRAINT fkoefusc73ush4vferq6d5wygpv FOREIGN KEY (doctor_id)
    REFERENCES public.users (id) MATCH SIMPLE
    ON UPDATE NO ACTION
    ON DELETE NO ACTION;


ALTER TABLE IF EXISTS public.workflow_body
    ADD CONSTRAINT fk1ghwq27p1lqyo5pcc3gw61bbv FOREIGN KEY (client_id)
    REFERENCES public.users (id) MATCH SIMPLE
    ON UPDATE NO ACTION
    ON DELETE NO ACTION;


ALTER TABLE IF EXISTS public.workflow_body
    ADD CONSTRAINT fk2cwrtk8w42jk71qkrwghkes5o FOREIGN KEY (service_id)
    REFERENCES public.services (id) MATCH SIMPLE
    ON UPDATE NO ACTION
    ON DELETE NO ACTION;


ALTER TABLE IF EXISTS public.workflow_body
    ADD CONSTRAINT fkcraidrp7f3i4yykggqnuo30xl FOREIGN KEY (workflow_id)
    REFERENCES public.workflow (id) MATCH SIMPLE
    ON UPDATE NO ACTION
    ON DELETE NO ACTION;


ALTER TABLE IF EXISTS public.workflow_body
    ADD CONSTRAINT fkt7a2jhcwipjw1hqov4e3072gt FOREIGN KEY (doctor_id)
    REFERENCES public.users (id) MATCH SIMPLE
    ON UPDATE NO ACTION
    ON DELETE NO ACTION;