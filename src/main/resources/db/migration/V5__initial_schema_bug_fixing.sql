alter table public.medicalcard_body_drugs rename to medicalcard_body_pills;

ALTER TABLE IF EXISTS public.medicalcard_body DROP CONSTRAINT  medicalcard_body_pkey CASCADE;

ALTER TABLE IF EXISTS public.medicalcard_body
    ADD COLUMN id Serial NOT NULL;

ALTER TABLE IF EXISTS public.medicalcard_body
    ADD CONSTRAINT medicalcard_body_pkey PRIMARY KEY (id);
