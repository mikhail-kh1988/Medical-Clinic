ALTER TABLE IF EXISTS public.diseases
    ADD COLUMN external_code character varying(255) COLLATE pg_catalog."default",
    ADD COLUMN internal_code character varying(255) COLLATE pg_catalog."default";

ALTER TABLE IF EXISTS public.services
    ADD COLUMN external_code character varying(255) COLLATE pg_catalog."default",
    ADD COLUMN describe character varying(255) COLLATE pg_catalog."default";