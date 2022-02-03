alter table public.medicalcard_body_drugs rename to medicalcard_body_pills;

ALTER TABLE IF EXISTS public.medicalcard_body DROP CONSTRAINT  medicalcard_body_pkey CASCADE;

ALTER TABLE public.medicalcard_body drop column doctor_id cascade;
ALTER TABLE public.medicalcard_body drop column client_id cascade;

ALTER TABLE IF EXISTS public.medicalcard_body
    add column doctor_id bigint,
    add column client_id bigint,
    add column id bigserial not null;

ALTER TABLE IF EXISTS public.medicalcard_body
    ADD CONSTRAINT medicalcard_body_pkey PRIMARY KEY (id);
