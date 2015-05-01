# --- Created by Ebean DDL
# To stop Ebean DDL generation, remove this comment and start using Evolutions

# --- !Ups

create table workflow_entry (
  workflow_id               varchar(255) not null,
  registry_id               varchar(255),
  version_no                varchar(255),
  registor_id               varchar(255),
  register_time_stamp       varchar(255),
  register_note             varchar(1000),
  constraint pk_workflow_entry primary key (workflow_id))
;

create table workflow_meta (
  workflow_id               varchar(255),
  tags                      varchar(255))
;




# --- !Downs

SET FOREIGN_KEY_CHECKS=0;

drop table workflow_entry;

drop table workflow_meta;

SET FOREIGN_KEY_CHECKS=1;

