/*==============================================================*/
/* DBMS name:      PostgreSQL 8                                 */
/* Created on:     2014/3/27 11:35:44                           */
/*==============================================================*/




/*==============================================================*/
/* Table: ACT_GE_BYTEARRAY                                      */
/*==============================================================*/
create table ACT_GE_BYTEARRAY (
	ID_                  varchar(64)          not null,
	REV_                 integer              null,
	NAME_                varchar(255)         null,
	DEPLOYMENT_ID_       varchar(64)          null,
	BYTES_               bytea                null,
	GENERATED_           boolean              null,
	constraint PK_ACT_GE_BYTEARRAY primary key (ID_)
);

/*==============================================================*/
/* Index: ACT_IDX_BYTEAR_DEPL                                   */
/*==============================================================*/
create  index ACT_IDX_BYTEAR_DEPL on ACT_GE_BYTEARRAY (
	DEPLOYMENT_ID_
);

/*==============================================================*/
/* Table: ACT_GE_PROPERTY                                       */
/*==============================================================*/
create table ACT_GE_PROPERTY (
	NAME_                varchar(64)          not null,
	VALUE_               varchar(300)         null,
	REV_                 integer              null,
	constraint PK_ACT_GE_PROPERTY primary key (NAME_)
);

/*==============================================================*/
/* Table: ACT_HI_ACTINST                                        */
/*==============================================================*/
create table ACT_HI_ACTINST (
	ID_                  varchar(64)          not null,
	PROC_DEF_ID_         varchar(64)          not null,
	PROC_INST_ID_        varchar(64)          not null,
	EXECUTION_ID_        varchar(64)          not null,
	ACT_ID_              varchar(255)         not null,
	TASK_ID_             varchar(64)          null,
	CALL_PROC_INST_ID_   varchar(64)          null,
	ACT_NAME_            varchar(255)         null,
	ACT_TYPE_            varchar(255)         not null,
	ASSIGNEE_            varchar(255)         null,
	START_TIME_          timestamp            not null,
	END_TIME_            timestamp            null,
	DURATION_            bigint               null,
	constraint PK_ACT_HI_ACTINST primary key (ID_)
);

/*==============================================================*/
/* Index: ACT_IDX_HI_ACT_INST_START                             */
/*==============================================================*/
create  index ACT_IDX_HI_ACT_INST_START on ACT_HI_ACTINST (
	START_TIME_
);

/*==============================================================*/
/* Index: ACT_IDX_HI_ACT_INST_END                               */
/*==============================================================*/
create  index ACT_IDX_HI_ACT_INST_END on ACT_HI_ACTINST (
	END_TIME_
);

/*==============================================================*/
/* Index: ACT_IDX_HI_ACT_INST_PROCINST                          */
/*==============================================================*/
create  index ACT_IDX_HI_ACT_INST_PROCINST on ACT_HI_ACTINST (
	PROC_INST_ID_,
	ACT_ID_
);

/*==============================================================*/
/* Index: ACT_IDX_HI_ACT_INST_EXEC                              */
/*==============================================================*/
create  index ACT_IDX_HI_ACT_INST_EXEC on ACT_HI_ACTINST (
	EXECUTION_ID_,
	ACT_ID_
);

/*==============================================================*/
/* Table: ACT_HI_ATTACHMENT                                     */
/*==============================================================*/
create table ACT_HI_ATTACHMENT (
	ID_                  varchar(64)          not null,
	REV_                 integer              null,
	USER_ID_             varchar(255)         null,
	NAME_                varchar(255)         null,
	DESCRIPTION_         varchar(4000)        null,
	TYPE_                varchar(255)         null,
	TASK_ID_             varchar(64)          null,
	PROC_INST_ID_        varchar(64)          null,
	URL_                 varchar(4000)        null,
	CONTENT_ID_          varchar(64)          null,
	constraint PK_ACT_HI_ATTACHMENT primary key (ID_)
);

/*==============================================================*/
/* Table: ACT_HI_COMMENT                                        */
/*==============================================================*/
create table ACT_HI_COMMENT (
	ID_                  varchar(64)          not null,
	TYPE_                varchar(255)         null,
	TIME_                timestamp            not null,
	USER_ID_             varchar(255)         null,
	TASK_ID_             varchar(64)          null,
	PROC_INST_ID_        varchar(64)          null,
	ACTION_              varchar(255)         null,
	MESSAGE_             varchar(4000)        null,
	FULL_MSG_            bytea                null,
	constraint PK_ACT_HI_COMMENT primary key (ID_)
);

/*==============================================================*/
/* Table: ACT_HI_DETAIL                                         */
/*==============================================================*/
create table ACT_HI_DETAIL (
	ID_                  varchar(64)          not null,
	TYPE_                varchar(255)         not null,
	PROC_INST_ID_        varchar(64)          null,
	EXECUTION_ID_        varchar(64)          null,
	TASK_ID_             varchar(64)          null,
	ACT_INST_ID_         varchar(64)          null,
	NAME_                varchar(255)         not null,
	VAR_TYPE_            varchar(64)          null,
	REV_                 integer              null,
	TIME_                timestamp            not null,
	BYTEARRAY_ID_        varchar(64)          null,
	DOUBLE_              double precision     null,
	LONG_                bigint               null,
	TEXT_                varchar(4000)        null,
	TEXT2_               varchar(4000)        null,
	constraint PK_ACT_HI_DETAIL primary key (ID_)
);

/*==============================================================*/
/* Index: ACT_IDX_HI_DETAIL_PROC_INST                           */
/*==============================================================*/
create  index ACT_IDX_HI_DETAIL_PROC_INST on ACT_HI_DETAIL (
	PROC_INST_ID_
);

/*==============================================================*/
/* Index: ACT_IDX_HI_DETAIL_ACT_INST                            */
/*==============================================================*/
create  index ACT_IDX_HI_DETAIL_ACT_INST on ACT_HI_DETAIL (
	ACT_INST_ID_
);

/*==============================================================*/
/* Index: ACT_IDX_HI_DETAIL_TIME                                */
/*==============================================================*/
create  index ACT_IDX_HI_DETAIL_TIME on ACT_HI_DETAIL (
	TIME_
);

/*==============================================================*/
/* Index: ACT_IDX_HI_DETAIL_NAME                                */
/*==============================================================*/
create  index ACT_IDX_HI_DETAIL_NAME on ACT_HI_DETAIL (
	NAME_
);

/*==============================================================*/
/* Index: ACT_IDX_HI_DETAIL_TASK_ID                             */
/*==============================================================*/
create  index ACT_IDX_HI_DETAIL_TASK_ID on ACT_HI_DETAIL (
	TASK_ID_
);

/*==============================================================*/
/* Table: ACT_HI_IDENTITYLINK                                   */
/*==============================================================*/
create table ACT_HI_IDENTITYLINK (
	ID_                  varchar(64)          not null,
	GROUP_ID_            varchar(255)         null,
	TYPE_                varchar(255)         null,
	USER_ID_             varchar(255)         null,
	TASK_ID_             varchar(64)          null,
	PROC_INST_ID_        varchar(64)          null,
	constraint PK_ACT_HI_IDENTITYLINK primary key (ID_)
);

/*==============================================================*/
/* Index: ACT_IDX_HI_IDENT_LNK_USER                             */
/*==============================================================*/
create  index ACT_IDX_HI_IDENT_LNK_USER on ACT_HI_IDENTITYLINK (
	USER_ID_
);

/*==============================================================*/
/* Index: ACT_IDX_HI_IDENT_LNK_TASK                             */
/*==============================================================*/
create  index ACT_IDX_HI_IDENT_LNK_TASK on ACT_HI_IDENTITYLINK (
	TASK_ID_
);

/*==============================================================*/
/* Index: ACT_IDX_HI_IDENT_LNK_PROCINST                         */
/*==============================================================*/
create  index ACT_IDX_HI_IDENT_LNK_PROCINST on ACT_HI_IDENTITYLINK (
	PROC_INST_ID_
);

/*==============================================================*/
/* Table: ACT_HI_PROCINST                                       */
/*==============================================================*/
create table ACT_HI_PROCINST (
	ID_                  varchar(64)          not null,
	PROC_INST_ID_        varchar(64)          not null,
	BUSINESS_KEY_        varchar(255)         null,
	PROC_DEF_ID_         varchar(64)          not null,
	START_TIME_          timestamp            not null,
	END_TIME_            timestamp            null,
	DURATION_            bigint               null,
	START_USER_ID_       varchar(255)         null,
	START_ACT_ID_        varchar(255)         null,
	END_ACT_ID_          varchar(255)         null,
	SUPER_PROCESS_INSTANCE_ID_ varchar(64)          null,
	DELETE_REASON_       varchar(4000)        null,
	constraint PK_ACT_HI_PROCINST primary key (ID_),
	constraint AK_KEY_2_ACT_HI_P unique (PROC_INST_ID_),
	constraint AK_KEY_3_ACT_HI_P unique (PROC_DEF_ID_, BUSINESS_KEY_)
);

/*==============================================================*/
/* Index: ACT_IDX_HI_PRO_INST_END                               */
/*==============================================================*/
create  index ACT_IDX_HI_PRO_INST_END on ACT_HI_PROCINST (
	END_TIME_
);

/*==============================================================*/
/* Index: ACT_IDX_HI_PRO_I_BUSKEY                               */
/*==============================================================*/
create  index ACT_IDX_HI_PRO_I_BUSKEY on ACT_HI_PROCINST (
	BUSINESS_KEY_
);

/*==============================================================*/
/* Table: ACT_HI_TASKINST                                       */
/*==============================================================*/
create table ACT_HI_TASKINST (
	ID_                  varchar(64)          not null,
	PROC_DEF_ID_         varchar(64)          null,
	TASK_DEF_KEY_        varchar(255)         null,
	PROC_INST_ID_        varchar(64)          null,
	EXECUTION_ID_        varchar(64)          null,
	NAME_                varchar(255)         null,
	PARENT_TASK_ID_      varchar(64)          null,
	DESCRIPTION_         varchar(4000)        null,
	OWNER_               varchar(255)         null,
	ASSIGNEE_            varchar(255)         null,
	START_TIME_          timestamp            not null,
	CLAIM_TIME_          timestamp            null,
	END_TIME_            timestamp            null,
	DURATION_            bigint               null,
	DELETE_REASON_       varchar(4000)        null,
	PRIORITY_            integer              null,
	DUE_DATE_            timestamp            null,
	FORM_KEY_            varchar(255)         null,
	constraint PK_ACT_HI_TASKINST primary key (ID_)
);

/*==============================================================*/
/* Table: ACT_HI_VARINST                                        */
/*==============================================================*/
create table ACT_HI_VARINST (
	ID_                  varchar(64)          not null,
	PROC_INST_ID_        varchar(64)          null,
	EXECUTION_ID_        varchar(64)          null,
	TASK_ID_             varchar(64)          null,
	NAME_                varchar(255)         not null,
	VAR_TYPE_            varchar(100)         null,
	REV_                 integer              null,
	BYTEARRAY_ID_        varchar(64)          null,
	DOUBLE_              double precision     null,
	LONG_                bigint               null,
	TEXT_                varchar(4000)        null,
	TEXT2_               varchar(4000)        null,
	constraint PK_ACT_HI_VARINST primary key (ID_)
);

/*==============================================================*/
/* Index: ACT_IDX_HI_PROCVAR_PROC_INST                          */
/*==============================================================*/
create  index ACT_IDX_HI_PROCVAR_PROC_INST on ACT_HI_VARINST (
	PROC_INST_ID_
);

/*==============================================================*/
/* Index: ACT_IDX_HI_PROCVAR_NAME_TYPE                          */
/*==============================================================*/
create  index ACT_IDX_HI_PROCVAR_NAME_TYPE on ACT_HI_VARINST (
	NAME_,
	VAR_TYPE_
);

/*==============================================================*/
/* Table: ACT_ID_GROUP                                          */
/*==============================================================*/
create table ACT_ID_GROUP (
	ID_                  varchar(64)          not null,
	REV_                 integer              null,
	NAME_                varchar(255)         null,
	TYPE_                varchar(255)         null,
	constraint PK_ACT_ID_GROUP primary key (ID_)
);

/*==============================================================*/
/* Table: ACT_ID_INFO                                           */
/*==============================================================*/
create table ACT_ID_INFO (
	ID_                  varchar(64)          not null,
	REV_                 integer              null,
	USER_ID_             varchar(64)          null,
	TYPE_                varchar(64)          null,
	KEY_                 varchar(255)         null,
	VALUE_               varchar(255)         null,
	PASSWORD_            bytea                null,
	PARENT_ID_           varchar(255)         null,
	constraint PK_ACT_ID_INFO primary key (ID_)
);

/*==============================================================*/
/* Table: ACT_ID_MEMBERSHIP                                     */
/*==============================================================*/
create table ACT_ID_MEMBERSHIP (
	USER_ID_             varchar(64)          not null,
	GROUP_ID_            varchar(64)          not null,
	constraint PK_ACT_ID_MEMBERSHIP primary key (USER_ID_, GROUP_ID_)
);

/*==============================================================*/
/* Index: ACT_IDX_MEMB_GROUP                                    */
/*==============================================================*/
create  index ACT_IDX_MEMB_GROUP on ACT_ID_MEMBERSHIP (
	GROUP_ID_
);

/*==============================================================*/
/* Index: ACT_IDX_MEMB_USER                                     */
/*==============================================================*/
create  index ACT_IDX_MEMB_USER on ACT_ID_MEMBERSHIP (
	USER_ID_
);

/*==============================================================*/
/* Table: ACT_ID_USER                                           */
/*==============================================================*/
create table ACT_ID_USER (
	ID_                  varchar(64)          not null,
	REV_                 integer              null,
	FIRST_               varchar(255)         null,
	LAST_                varchar(255)         null,
	EMAIL_               varchar(255)         null,
	PWD_                 varchar(255)         null,
	PICTURE_ID_          varchar(64)          null,
	constraint PK_ACT_ID_USER primary key (ID_)
);

/*==============================================================*/
/* Table: ACT_RE_DEPLOYMENT                                     */
/*==============================================================*/
create table ACT_RE_DEPLOYMENT (
	ID_                  varchar(64)          not null,
	NAME_                varchar(255)         null,
	CATEGORY_            varchar(255)         null,
	DEPLOY_TIME_         timestamp            null,
	constraint PK_ACT_RE_DEPLOYMENT primary key (ID_)
);

/*==============================================================*/
/* Table: ACT_RE_MODEL                                          */
/*==============================================================*/
create table ACT_RE_MODEL (
	ID_                  varchar(64)          not null,
	REV_                 integer              null,
	NAME_                varchar(255)         null,
	KEY_                 varchar(255)         null,
	CATEGORY_            varchar(255)         null,
	CREATE_TIME_         timestamp            null,
	LAST_UPDATE_TIME_    timestamp            null,
	VERSION_             integer              null,
	META_INFO_           varchar(4000)        null,
	DEPLOYMENT_ID_       varchar(64)          null,
	EDITOR_SOURCE_VALUE_ID_ varchar(64)          null,
	EDITOR_SOURCE_EXTRA_VALUE_ID_ varchar(64)          null,
	constraint PK_ACT_RE_MODEL primary key (ID_)
);

/*==============================================================*/
/* Index: ACT_IDX_MODEL_SOURCE                                  */
/*==============================================================*/
create  index ACT_IDX_MODEL_SOURCE on ACT_RE_MODEL (
	EDITOR_SOURCE_VALUE_ID_
);

/*==============================================================*/
/* Index: ACT_IDX_MODEL_SOURCE_EXTRA                            */
/*==============================================================*/
create  index ACT_IDX_MODEL_SOURCE_EXTRA on ACT_RE_MODEL (
	EDITOR_SOURCE_EXTRA_VALUE_ID_
);

/*==============================================================*/
/* Index: ACT_IDX_MODEL_DEPLOYMENT                              */
/*==============================================================*/
create  index ACT_IDX_MODEL_DEPLOYMENT on ACT_RE_MODEL (
	DEPLOYMENT_ID_
);

/*==============================================================*/
/* Table: ACT_RE_PROCDEF                                        */
/*==============================================================*/
create table ACT_RE_PROCDEF (
	ID_                  varchar(64)          not null,
	REV_                 integer              null,
	CATEGORY_            varchar(255)         null,
	NAME_                varchar(255)         null,
	KEY_                 varchar(255)         not null,
	VERSION_             integer              not null,
	DEPLOYMENT_ID_       varchar(64)          null,
	RESOURCE_NAME_       varchar(4000)        null,
	DGRM_RESOURCE_NAME_  varchar(4000)        null,
	DESCRIPTION_         varchar(4000)        null,
	HAS_START_FORM_KEY_  boolean              null,
	SUSPENSION_STATE_    integer              null,
	constraint PK_ACT_RE_PROCDEF primary key (ID_),
	constraint ACT_UNIQ_PROCDEF unique (KEY_, VERSION_)
);

/*==============================================================*/
/* Table: ACT_RU_EVENT_SUBSCR                                   */
/*==============================================================*/
create table ACT_RU_EVENT_SUBSCR (
	ID_                  varchar(64)          not null,
	REV_                 integer              null,
	EVENT_TYPE_          varchar(255)         not null,
	EVENT_NAME_          varchar(255)         null,
	EXECUTION_ID_        varchar(64)          null,
	PROC_INST_ID_        varchar(64)          null,
	ACTIVITY_ID_         varchar(64)          null,
	CONFIGURATION_       varchar(255)         null,
	CREATED_             timestamp            not null,
	constraint PK_ACT_RU_EVENT_SUBSCR primary key (ID_)
);

/*==============================================================*/
/* Index: ACT_IDX_EVENT_SUBSCR_CONFIG_                          */
/*==============================================================*/
create  index ACT_IDX_EVENT_SUBSCR_CONFIG_ on ACT_RU_EVENT_SUBSCR (
	CONFIGURATION_
);

/*==============================================================*/
/* Index: ACT_IDX_EVENT_SUBSCR                                  */
/*==============================================================*/
create  index ACT_IDX_EVENT_SUBSCR on ACT_RU_EVENT_SUBSCR (
	EXECUTION_ID_
);

/*==============================================================*/
/* Table: ACT_RU_EXECUTION                                      */
/*==============================================================*/
create table ACT_RU_EXECUTION (
	ID_                  varchar(64)          not null,
	REV_                 integer              null,
	PROC_INST_ID_        varchar(64)          null,
	BUSINESS_KEY_        varchar(255)         null,
	PARENT_ID_           varchar(64)          null,
	PROC_DEF_ID_         varchar(64)          null,
	SUPER_EXEC_          varchar(64)          null,
	ACT_ID_              varchar(255)         null,
	IS_ACTIVE_           boolean              null,
	IS_CONCURRENT_       boolean              null,
	IS_SCOPE_            boolean              null,
	IS_EVENT_SCOPE_      boolean              null,
	SUSPENSION_STATE_    integer              null,
	CACHED_ENT_STATE_    integer              null,
	constraint PK_ACT_RU_EXECUTION primary key (ID_),
	constraint AK_KEY_2_ACT_RU_E unique (PROC_DEF_ID_, BUSINESS_KEY_)
);

/*==============================================================*/
/* Index: ACT_IDX_EXEC_BUSKEY                                   */
/*==============================================================*/
create  index ACT_IDX_EXEC_BUSKEY on ACT_RU_EXECUTION (
	BUSINESS_KEY_
);

/*==============================================================*/
/* Index: ACT_IDX_EXE_PROCINST                                  */
/*==============================================================*/
create  index ACT_IDX_EXE_PROCINST on ACT_RU_EXECUTION (
	PROC_INST_ID_
);

/*==============================================================*/
/* Index: ACT_IDX_EXE_PARENT                                    */
/*==============================================================*/
create  index ACT_IDX_EXE_PARENT on ACT_RU_EXECUTION (
	PARENT_ID_
);

/*==============================================================*/
/* Index: ACT_IDX_EXE_SUPER                                     */
/*==============================================================*/
create  index ACT_IDX_EXE_SUPER on ACT_RU_EXECUTION (
	SUPER_EXEC_
);

/*==============================================================*/
/* Index: ACT_IDX_EXE_PROCDEF                                   */
/*==============================================================*/
create  index ACT_IDX_EXE_PROCDEF on ACT_RU_EXECUTION (
	PROC_DEF_ID_
);

/*==============================================================*/
/* Table: ACT_RU_IDENTITYLINK                                   */
/*==============================================================*/
create table ACT_RU_IDENTITYLINK (
	ID_                  varchar(64)          not null,
	REV_                 integer              null,
	GROUP_ID_            varchar(255)         null,
	TYPE_                varchar(255)         null,
	USER_ID_             varchar(255)         null,
	TASK_ID_             varchar(64)          null,
	PROC_INST_ID_        varchar(64)          null,
	PROC_DEF_ID_         varchar (64)         null,
	constraint PK_ACT_RU_IDENTITYLINK primary key (ID_)
);

/*==============================================================*/
/* Index: ACT_IDX_IDENT_LNK_USER                                */
/*==============================================================*/
create  index ACT_IDX_IDENT_LNK_USER on ACT_RU_IDENTITYLINK (
	USER_ID_
);

/*==============================================================*/
/* Index: ACT_IDX_IDENT_LNK_GROUP                               */
/*==============================================================*/
create  index ACT_IDX_IDENT_LNK_GROUP on ACT_RU_IDENTITYLINK (
	GROUP_ID_
);

/*==============================================================*/
/* Index: ACT_IDX_TSKASS_TASK                                   */
/*==============================================================*/
create  index ACT_IDX_TSKASS_TASK on ACT_RU_IDENTITYLINK (
	TASK_ID_
);

/*==============================================================*/
/* Index: ACT_IDX_ATHRZ_PROCEDEF                                */
/*==============================================================*/
create  index ACT_IDX_ATHRZ_PROCEDEF on ACT_RU_IDENTITYLINK (
	PROC_DEF_ID_
);

/*==============================================================*/
/* Index: ACT_IDX_IDL_PROCINST                                  */
/*==============================================================*/
create  index ACT_IDX_IDL_PROCINST on ACT_RU_IDENTITYLINK (
	PROC_INST_ID_
);

/*==============================================================*/
/* Table: ACT_RU_JOB                                            */
/*==============================================================*/
create table ACT_RU_JOB (
	ID_                  varchar(64)          not null,
	REV_                 integer              null,
	TYPE_                varchar(255)         not null,
	LOCK_EXP_TIME_       timestamp            null,
	LOCK_OWNER_          varchar(255)         null,
	EXCLUSIVE_           boolean              null,
	EXECUTION_ID_        varchar(64)          null,
	PROCESS_INSTANCE_ID_ varchar(64)          null,
	PROC_DEF_ID_         varchar(64)          null,
	RETRIES_             integer              null,
	EXCEPTION_STACK_ID_  varchar(64)          null,
	EXCEPTION_MSG_       varchar(4000)        null,
	DUEDATE_             timestamp            null,
	REPEAT_              varchar(255)         null,
	HANDLER_TYPE_        varchar(255)         null,
	HANDLER_CFG_         varchar(4000)        null,
	constraint PK_ACT_RU_JOB primary key (ID_)
);

/*==============================================================*/
/* Index: ACT_IDX_JOB_EXCEPTION                                 */
/*==============================================================*/
create  index ACT_IDX_JOB_EXCEPTION on ACT_RU_JOB (
	EXCEPTION_STACK_ID_
);

/*==============================================================*/
/* Table: ACT_RU_TASK                                           */
/*==============================================================*/
create table ACT_RU_TASK (
	ID_                  varchar(64)          not null,
	REV_                 integer              null,
	EXECUTION_ID_        varchar(64)          null,
	PROC_INST_ID_        varchar(64)          null,
	PROC_DEF_ID_         varchar(64)          null,
	NAME_                varchar(255)         null,
	PARENT_TASK_ID_      varchar(64)          null,
	DESCRIPTION_         varchar(4000)        null,
	TASK_DEF_KEY_        varchar(255)         null,
	OWNER_               varchar(255)         null,
	ASSIGNEE_            varchar(255)         null,
	DELEGATION_          varchar(64)          null,
	PRIORITY_            integer              null,
	CREATE_TIME_         timestamp            null,
	DUE_DATE_            timestamp            null,
	SUSPENSION_STATE_    integer              null,
	constraint PK_ACT_RU_TASK primary key (ID_)
);

/*==============================================================*/
/* Index: ACT_IDX_TASK_CREATE                                   */
/*==============================================================*/
create  index ACT_IDX_TASK_CREATE on ACT_RU_TASK (
	CREATE_TIME_
);

/*==============================================================*/
/* Index: ACT_IDX_TASK_EXEC                                     */
/*==============================================================*/
create  index ACT_IDX_TASK_EXEC on ACT_RU_TASK (
	EXECUTION_ID_
);

/*==============================================================*/
/* Index: ACT_IDX_TASK_PROCINST                                 */
/*==============================================================*/
create  index ACT_IDX_TASK_PROCINST on ACT_RU_TASK (
	PROC_INST_ID_
);

/*==============================================================*/
/* Index: ACT_IDX_TASK_PROCDEF                                  */
/*==============================================================*/
create  index ACT_IDX_TASK_PROCDEF on ACT_RU_TASK (
	PROC_DEF_ID_
);

/*==============================================================*/
/* Table: ACT_RU_VARIABLE                                       */
/*==============================================================*/
create table ACT_RU_VARIABLE (
	ID_                  varchar(64)          not null,
	REV_                 integer              null,
	TYPE_                varchar(255)         not null,
	NAME_                varchar(255)         not null,
	EXECUTION_ID_        varchar(64)          null,
	PROC_INST_ID_        varchar(64)          null,
	TASK_ID_             varchar(64)          null,
	BYTEARRAY_ID_        varchar(64)          null,
	DOUBLE_              double precision     null,
	LONG_                bigint               null,
	TEXT_                varchar(4000)        null,
	TEXT2_               varchar(4000)        null,
	constraint PK_ACT_RU_VARIABLE primary key (ID_)
);

/*==============================================================*/
/* Index: ACT_IDX_VARIABLE_TASK_ID                              */
/*==============================================================*/
create  index ACT_IDX_VARIABLE_TASK_ID on ACT_RU_VARIABLE (
	TASK_ID_
);

/*==============================================================*/
/* Index: ACT_IDX_VAR_EXE                                       */
/*==============================================================*/
create  index ACT_IDX_VAR_EXE on ACT_RU_VARIABLE (
	EXECUTION_ID_
);

/*==============================================================*/
/* Index: ACT_IDX_VAR_PROCINST                                  */
/*==============================================================*/
create  index ACT_IDX_VAR_PROCINST on ACT_RU_VARIABLE (
	PROC_INST_ID_
);

/*==============================================================*/
/* Index: ACT_IDX_VAR_BYTEARRAY                                 */
/*==============================================================*/
create  index ACT_IDX_VAR_BYTEARRAY on ACT_RU_VARIABLE (
	BYTEARRAY_ID_
);

/*==============================================================*/
/* Table: dict_def                                              */
/*==============================================================*/
create table dict_def (
	id_                  character varying(64) not null,
	code_                character varying(64) not null,
	type_                character varying(2) not null,
	name_                character varying(64) not null,
	value_               character varying(128) null,
	constraint AK_KEY_1_DICT_DEF unique (code_),
	constraint AK_KEY_2_DICT_DEF unique (id_)
);

/*==============================================================*/
/* Table: my_calendar_event                                     */
/*==============================================================*/
create table my_calendar_event (
	id_                  character varying(64) not null,
	own_user_            character varying(64) null,
	creation_date_       TIMESTAMP            null,
	last_update_         TIMESTAMP            null,
	start_date_          TIMESTAMP            null,
	end_date_            TIMESTAMP            null,
	caption_             character varying(500) null,
	description_         character varying(2000) null,
	style_name_          character varying(500) null,
	all_day_             boolean              null,
	related_todo_        character varying(64) null,
	constraint AK_KEY_1_MY_CALEN unique (id_)
);

/*==============================================================*/
/* Table: outsourcing_project                                   */
/*==============================================================*/
create table outsourcing_project (
	id_                  character varying(64) not null,
	creation_date_       TIMESTAMP            null,
	own_user_            character varying(64) null,
	last_update_         TIMESTAMP            null,
	description_         character varying(2000) null,
	related_todo_        character varying(64) null,
	name_                character varying(500) null,
	company_name_        character varying(500) null,
	bounty_              numeric              null,
	prg_status_          character(1)         null,
	deadline_            TIMESTAMP            null,
	flow_type_           character(1)         null,
	type_                character(1)         null,
	proc_inst_id_        character varying(64) null,
	picture_id_          character varying(64) null,
	constraint AK_KEY_1_OUTSOURC unique (id_)
);

/*==============================================================*/
/* Table: outsourcing_project2                                  */
/*==============================================================*/
create table outsourcing_project2 (
	id_                  character varying(64) not null,
	creation_date_       timestamp            null,
	own_user_            character varying(64) null,
	last_update_         timestamp            null,
	description_         character varying(2000) null,
	related_todo_        character varying(64) null,
	name_                character varying(500) null,
	company_name_        character varying(500) null,
	bounty_              numeric              null,
	prg_status_          character(1)         null,
	deadline_            timestamp            null,
	type_                character(1)         null,
	proc_inst_id_        character varying(64) null,
	picture_id_          character varying(64) null
);

/*==============================================================*/
/* Table: project                                               */
/*==============================================================*/
create table project (
	id                   character varying(64) not null,
	creationdate         TIMESTAMP            null,
	ownuser              character varying(64) null,
	lastupdate           TIMESTAMP            null,
	description          character varying(255) null,
	name                 character varying(250) null,
	constraint AK_KEY_1_PROJECT unique (id)
);

/*==============================================================*/
/* Table: project_participants                                  */
/*==============================================================*/
create table project_participants (
	id_                  character varying(64) not null,
	user_id_             character varying(64) null,
	out_prg_id_          character varying(64) null,
	participants_type_   character(1)         null,
	current_task_id_     character varying(64) null,
	score_               numeric(6,2)         null,
	score_user_id_       character varying(64) null,
	is_winner_           boolean              null,
	winning_amount       numeric(10,2)        null,
	handle_status_       character(1)         null,
	work_attachment      character varying(64) null,
	proc_inst_id_        character varying(64) null,
	last_update_         TIMESTAMP            null,
	work_comment_        character varying(2000) null,
	win_reson_           character varying(2000) null,
	assessed_task_id_    character varying(64) null,
	constraint AK_KEY_1_PROJECT_ unique (id_),
	constraint AK_KEY_2_PROJECT_ unique (id_)
);

/*==============================================================*/
/* Table: resources_assign_manager                              */
/*==============================================================*/
create table resources_assign_manager (
	id_                  character varying(64) not null,
	entity_id_           character varying(64) null,
	entity_type_         character varying(64) null,
	team_id_             character varying(64) not null,
	type_                character varying(64) null,
	last_update_         timestamp            null
)
WITH (
OIDS=FALSE
);

comment on column resources_assign_manager.entity_id_ is
'实体id';

comment on column resources_assign_manager.entity_type_ is
'用来区分 不同实体,账号、用户、还是其它';

comment on column resources_assign_manager.team_id_ is
'团队id';

comment on column resources_assign_manager.type_ is
'用来区分一个资源，可能不同类型的团队';

/*==============================================================*/
/* Table: social_use_authority_list                             */
/*==============================================================*/
create table social_use_authority_list (
	id_                  character varying(64) not null,
	manager_group_id_    character varying(64) null,
	key_                 character varying(255) null,
	last_update_         timestamp            null
)
WITH (
OIDS=FALSE
);

comment on column social_use_authority_list.key_ is
'数据字典的key';

/*==============================================================*/
/* Table: social_user_account                                   */
/*==============================================================*/
create table social_user_account (
	id_                  character varying(64) not null,
	weibo_uid_           character varying(64) null default NULL,
	status_              integer              null default '0',
	account_selected_    integer              null default '0',
	expired_time_        timestamp            null,
	own_user_            character varying(64) null,
	name_                character varying(128) null,
	last_update_         TIMESTAMP            null,
	type_                integer              null,
	user_screen_name_    character varying(128) null default NULL,
	url_                 character varying(2000) null,
	constraint AK_KEY_1_SOCIAL_U unique (id_)
);

/*==============================================================*/
/* Table: social_user_account2                                  */
/*==============================================================*/
create table social_user_account2 (
	id_                  character varying(64) not null,
	weibo_uid_           character varying(64) null default NULL,
	status_              integer              null,
	account_selected_    integer              null default '0',
	expired_time_        timestamp            null,
	own_user_            character varying(64) null,
	name_                character varying(128) null,
	last_update_         timestamp            null,
	type_                integer              null
);

/*==============================================================*/
/* Table: social_user_account_info                              */
/*==============================================================*/
create table social_user_account_info (
	id_                  character varying(64) not null,
	account_id_          character varying(64) null,
	type_                character varying(64) null,
	key_                 character varying(255) null,
	value_type_          integer              null,
	value_               character varying(2000) null,
	value_string_        character varying(2000) null,
	value_date_          timestamp            null,
	value_double_        numeric              null,
	last_update_         timestamp            null,
	user_id_             character varying(255) null,
	value_int_           integer              null,
	entity_id_           character varying(64) null,
	constraint pk_social_user_account_info primary key (id_),
	constraint AK_KEY_2_SOCIAL_U unique (id_)
)
WITH (
OIDS=FALSE
);

comment on column social_user_account_info.entity_id_ is
'瀹炰綋id';

/*==============================================================*/
/* Table: social_user_account_info2                             */
/*==============================================================*/
create table social_user_account_info2 (
	id_                  character varying(64) not null,
	account_id_          character varying(64) null,
	type_                character varying(64) null,
	key_                 character varying(255) null,
	value_type_          integer              null,
	value_               character varying(2000) null,
	value_string_        character varying(2000) null,
	value_date_          timestamp            null,
	value_double_        numeric              null,
	last_update_         timestamp            null
);

/*==============================================================*/
/* Table: social_user_weibo                                     */
/*==============================================================*/
create table social_user_weibo (
	id_                  character varying(64) not null,
	retweeted_id_        character varying(64) null,
	user_account_id_     character varying(64) null default NULL,
	owner_               character varying(64) null,
	create_at_           timestamp            null,
	weibo_id_            character varying(64) null default NULL,
	text_                character varying(2048) null default NULL,
	source_              character varying(256) null default NULL,
	favorited_           integer              null,
	truncated_           integer              null,
	in_reply_to_status_id_ character varying(32) null default NULL,
	in_reply_to_user_id_ character varying(16) null default NULL,
	in_reply_to_screen_name_ character varying(128) null default NULL,
	mid_                 character varying(32) null default NULL,
	reposts_count_       integer              null,
	comments_count_      integer              null,
	weibo_uid_follower_  integer              null,
	weibo_uid_           character varying(32) null default NULL,
	user_screen_name_    character varying(128) null default NULL,
	user_name_           character varying(128) null default NULL,
	user_profile_image_url_ character varying(256) null default NULL,
	user_domain_         character varying(128) null default NULL,
	thumbnail_pic_       character varying(256) null default NULL,
	original_pic_        character varying(256) null default NULL,
	bmiddle_pic_         character varying(256) null default NULL,
	user_verified_       integer              null,
	weibo_type_          integer              null,
	weibo_handle_type_   integer              null,
	last_update_         timestamp            null,
	type_                integer              null
);

/*==============================================================*/
/* Table: social_user_weibo_comment                             */
/*==============================================================*/
create table social_user_weibo_comment (
	id_                  character varying(64) not null,
	user_account_id_     character varying(64) null default NULL,
	owner_               character varying(64) null,
	create_at_           timestamp            null,
	comment_id_          character varying(32) null default NULL,
	text_                character varying(2048) null default NULL,
	source_              character varying(256) null default NULL,
	mid_                 character varying(32) null default NULL,
	comment_uid_         character varying(32) null default NULL,
	user_screen_name_    character varying(128) null default NULL,
	user_name_           character varying(128) null default NULL,
	user_profile_image_url_ character varying(256) null default NULL,
	user_domain_         character varying(32) null default NULL,
	user_verified_       integer              null,
	rel_user_weibo_id_   character varying(32) null default NULL,
	status_weibo_id_     character varying(32) null default NULL,
	status_created_at_   timestamp            null,
	status_text_         character varying(2048) null default NULL,
	status_source_       character varying(256) null default NULL,
	status_mid_          character varying(32) null default NULL,
	status_user_uid_     character varying(32) null default NULL,
	status_user_screen_name_ character varying(128) null default NULL,
	status_user_name_    character varying(128) null default NULL,
	status_user_domain_  character varying(32) null default NULL,
	status_user_verified_ integer              null,
	comment_type_        integer              null,
	type_                integer              null,
	constraint PK_SOCIAL_USER_WEIBO_COMMENT primary key (id_)
)
WITH (
OIDS=FALSE
);

comment on column social_user_weibo_comment.comment_id_ is
'评论标识';

comment on column social_user_weibo_comment.comment_uid_ is
'评论者标识';

comment on column social_user_weibo_comment.rel_user_weibo_id_ is
'关联的本地微博id';

comment on column social_user_weibo_comment.status_weibo_id_ is
'微博id';

comment on column social_user_weibo_comment.status_source_ is
'微博来源';

comment on column social_user_weibo_comment.status_user_uid_ is
'微博所属人的标识';

comment on column social_user_weibo_comment.status_user_verified_ is
'所回复微博的编辑人是否认证';

comment on column social_user_weibo_comment.comment_type_ is
'评论类型 1：我发的评论 2：我收到的评论 0:代表某条微博的评论';

comment on column social_user_weibo_comment.type_ is
'类型';

/*==============================================================*/
/* Table: social_user_weibo_send                                */
/*==============================================================*/
create table social_user_weibo_send (
	id_                  character varying(64) not null,
	user_account_id_     character varying(64) null default NULL,
	owner_               character varying(64) null,
	create_time_         timestamp            null,
	weibo_id_            character varying(64) null default NULL,
	short_text_          character varying(500) null default NULL,
	text_                character varying(2048) null default NULL,
	weibo_type_          integer              null,
	type_                integer              null,
	status_              integer              null,
	plan_send_time_      timestamp            null,
	send_time_           timestamp            null,
	last_update_         timestamp            null
);

comment on column social_user_weibo_send.create_time_ is
'创建时间';

comment on column social_user_weibo_send.weibo_id_ is
'最后返回的微博id';

comment on column social_user_weibo_send.short_text_ is
'微博短内容';

comment on column social_user_weibo_send.text_ is
'微博内容';

comment on column social_user_weibo_send.weibo_type_ is
'新浪微博，还是腾讯';

comment on column social_user_weibo_send.type_ is
'直接发送、定时发送';

comment on column social_user_weibo_send.status_ is
'已经发送、未发送';

comment on column social_user_weibo_send.plan_send_time_ is
'计划发送时间';

comment on column social_user_weibo_send.send_time_ is
'发送时间';

/*==============================================================*/
/* Table: team                                                  */
/*==============================================================*/
create table team (
	id_                  character varying(64) not null,
	own_user_            character varying(64) null,
	name_                character varying(128) null,
	last_update_         TIMESTAMP            null,
	type_                character(1)         null,
	created_at_          timestamp            null,
	updated_at_          timestamp            null,
	constraint AK_KEY_1_TEAM unique (id_),
	constraint AK_KEY_2_TEAM unique (id_)
);

/*==============================================================*/
/* Table: team_membership                                       */
/*==============================================================*/
create table team_membership (
	user_id_             character varying(64) not null,
	team_id_             character varying(64) not null,
	constraint AK_KEY_1_TEAM_MEM unique (user_id_, team_id_)
);

/*==============================================================*/
/* Table: todo                                                  */
/*==============================================================*/
create table todo (
	id_                  character varying(64) not null,
	pid_                 character varying(64) null default '-1',
	is_container_        integer              null default '0',
	creation_date_       TIMESTAMP            null,
	description_         character varying(255) null,
	priority_            integer              null default '3',
	completed_           integer              null default '0',
	completion_date_     TIMESTAMP            null,
	pro_id_              character varying(64) null,
	due_date_            TIMESTAMP            null,
	assigned_user_       character varying(64) null,
	last_update_         TIMESTAMP            null,
	useup_               numeric(2,0)         null,
	status_              integer              null default '0',
	type_                integer              null default '0',
	tags_                character varying(255) null,
	related_task_id_     character varying(64) null,
	related_task_        boolean              null,
	name_                character varying(500) null,
	start_date_          TIMESTAMP            null,
	estimate_            numeric(4,1)         null,
	estimate_unit_       integer              null,
	related_calendar_    boolean              null,
	assigned_team_       character varying(64) null,
	constraint AK_KEY_1_TODO unique (id_)
);

/*==============================================================*/
/* Table: user_data_statistics_                                 */
/*==============================================================*/
create table user_data_statistics_ (
	user_id_             character varying(64) not null,
	todo_task_total_     integer              null,
	overdue_todo_task_total_ integer              null,
	my_task_total_       integer              null,
	overdue_my_task_total_ integer              null,
	team_task_total_     integer              null,
	overdue_team_task_total_ integer              null,
	involved_task_total_ integer              null,
	overdue_involved_task_total_ integer              null,
	dirty_               boolean              null,
	last_update_         timestamp            null,
	constraint PK_USER_DATA_STATISTICS_ primary key (user_id_)
)
WITH (
OIDS=FALSE
);

comment on column user_data_statistics_.user_id_ is
'用户id';

comment on column user_data_statistics_.todo_task_total_ is
'代办任务数量';

comment on column user_data_statistics_.my_task_total_ is
'我的任务数量';

comment on column user_data_statistics_.team_task_total_ is
'团队任务数量';

comment on column user_data_statistics_.involved_task_total_ is
'参与任务数量';

comment on column user_data_statistics_.dirty_ is
'是否是脏数据';

alter table ACT_GE_BYTEARRAY
add constraint ACT_FK_BYTEARR_DEPL foreign key (DEPLOYMENT_ID_)
references ACT_RE_DEPLOYMENT (ID_)
on delete restrict on update restrict;

alter table ACT_ID_MEMBERSHIP
add constraint ACT_FK_MEMB_GROUP foreign key (GROUP_ID_)
references ACT_ID_GROUP (ID_)
on delete restrict on update restrict;

alter table ACT_ID_MEMBERSHIP
add constraint ACT_FK_MEMB_USER foreign key (USER_ID_)
references ACT_ID_USER (ID_)
on delete restrict on update restrict;

alter table ACT_RE_MODEL
add constraint ACT_FK_MODEL_DEPLOYMENT foreign key (DEPLOYMENT_ID_)
references ACT_RE_DEPLOYMENT (ID_)
on delete restrict on update restrict;

alter table ACT_RE_MODEL
add constraint ACT_FK_MODEL_SOURCE foreign key (EDITOR_SOURCE_VALUE_ID_)
references ACT_GE_BYTEARRAY (ID_)
on delete restrict on update restrict;

alter table ACT_RE_MODEL
add constraint ACT_FK_MODEL_SOURCE_EXTRA foreign key (EDITOR_SOURCE_EXTRA_VALUE_ID_)
references ACT_GE_BYTEARRAY (ID_)
on delete restrict on update restrict;

alter table ACT_RU_EVENT_SUBSCR
add constraint ACT_FK_EVENT_EXEC foreign key (EXECUTION_ID_)
references ACT_RU_EXECUTION (ID_)
on delete restrict on update restrict;

alter table ACT_RU_EXECUTION
add constraint ACT_FK_EXE_PARENT foreign key (PARENT_ID_)
references ACT_RU_EXECUTION (ID_)
on delete restrict on update restrict;

alter table ACT_RU_EXECUTION
add constraint ACT_FK_EXE_PROCDEF foreign key (PROC_DEF_ID_)
references ACT_RE_PROCDEF (ID_)
on delete restrict on update restrict;

alter table ACT_RU_EXECUTION
add constraint ACT_FK_EXE_PROCINST foreign key (PROC_INST_ID_)
references ACT_RU_EXECUTION (ID_)
on delete restrict on update restrict;

alter table ACT_RU_EXECUTION
add constraint ACT_FK_EXE_SUPER foreign key (SUPER_EXEC_)
references ACT_RU_EXECUTION (ID_)
on delete restrict on update restrict;

alter table ACT_RU_IDENTITYLINK
add constraint ACT_FK_ATHRZ_PROCEDEF foreign key (PROC_DEF_ID_)
references ACT_RE_PROCDEF (ID_)
on delete restrict on update restrict;

alter table ACT_RU_IDENTITYLINK
add constraint ACT_FK_IDL_PROCINST foreign key (PROC_INST_ID_)
references ACT_RU_EXECUTION (ID_)
on delete restrict on update restrict;

alter table ACT_RU_IDENTITYLINK
add constraint ACT_FK_TSKASS_TASK foreign key (TASK_ID_)
references ACT_RU_TASK (ID_)
on delete restrict on update restrict;

alter table ACT_RU_JOB
add constraint ACT_FK_JOB_EXCEPTION foreign key (EXCEPTION_STACK_ID_)
references ACT_GE_BYTEARRAY (ID_)
on delete restrict on update restrict;

alter table ACT_RU_TASK
add constraint ACT_FK_TASK_EXE foreign key (EXECUTION_ID_)
references ACT_RU_EXECUTION (ID_)
on delete restrict on update restrict;

alter table ACT_RU_TASK
add constraint ACT_FK_TASK_PROCDEF foreign key (PROC_DEF_ID_)
references ACT_RE_PROCDEF (ID_)
on delete restrict on update restrict;

alter table ACT_RU_TASK
add constraint ACT_FK_TASK_PROCINST foreign key (PROC_INST_ID_)
references ACT_RU_EXECUTION (ID_)
on delete restrict on update restrict;

alter table ACT_RU_VARIABLE
add constraint ACT_FK_VAR_BYTEARRAY foreign key (BYTEARRAY_ID_)
references ACT_GE_BYTEARRAY (ID_)
on delete restrict on update restrict;

alter table ACT_RU_VARIABLE
add constraint ACT_FK_VAR_EXE foreign key (EXECUTION_ID_)
references ACT_RU_EXECUTION (ID_)
on delete restrict on update restrict;

alter table ACT_RU_VARIABLE
add constraint ACT_FK_VAR_PROCINST foreign key (PROC_INST_ID_)
references ACT_RU_EXECUTION (ID_)
on delete restrict on update restrict;

