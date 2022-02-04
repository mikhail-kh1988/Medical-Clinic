ALTER TABLE IF EXISTS public.diseases
    ADD COLUMN external_code character varying(255),
    ADD COLUMN internal_code character varying(255);

ALTER TABLE IF EXISTS public.services
    ADD COLUMN external_code character varying(255),
    ADD COLUMN describe character varying(255);