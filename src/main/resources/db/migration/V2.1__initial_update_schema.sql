ALTER TABLE IF EXISTS public.workflow_body
    ADD COLUMN receipt boolean,
    ADD COLUMN receipt_date date;

ALTER TABLE IF EXISTS public.medicalcard_body
    ADD COLUMN  therapy_closed boolean;