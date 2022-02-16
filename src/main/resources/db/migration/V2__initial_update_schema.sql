ALTER TABLE IF EXISTS public.diseases
    ADD COLUMN external_code varchar(255),
    ADD COLUMN internal_code varchar(255);

ALTER TABLE IF EXISTS public.services
    ADD COLUMN external_code varchar(255),
    ADD COLUMN describe varchar(255);