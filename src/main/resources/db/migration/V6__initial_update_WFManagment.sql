alter table if exists public.workflow_body
    drop column receipt_date,
    drop constraint workflow_body_pkey cascade;

alter table if exists public.workflow_body
    add column id bigserial,
    add column receipt_date timestamp,
    add constraint workflow_body_pkey primary key(id);

alter table if exists public.workflow
    drop column start_date;

alter table if exists public.workflow
    drop column end_date;

alter table if exists public.workflow
    add column start_date timestamp,
    add column end_date timestamp;