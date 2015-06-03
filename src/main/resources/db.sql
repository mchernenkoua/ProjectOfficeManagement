--
-- PostgreSQL database
--


CREATE TABLE bank_account (
    id bigint NOT NULL,
    name character varying,
    bank_name character varying,
    currency character(3)
);

CREATE SEQUENCE bank_account_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;
ALTER SEQUENCE bank_account_id_seq OWNED BY bank_account.id;

CREATE TABLE cash_movement (
    id bigint NOT NULL,
    date timestamp with time zone,
    bank_account_id bigint,
    currency character(3),
    sum numeric(15,2) DEFAULT 0 NOT NULL,
    doc_id bigint,
    doc_type character varying
);

CREATE SEQUENCE cash_movement_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;
ALTER SEQUENCE cash_movement_id_seq OWNED BY cash_movement.id;

CREATE TABLE cost_items (
    id bigint NOT NULL,
    name character varying,
    type character varying,
    parent bigint DEFAULT 0
);

CREATE SEQUENCE cost_items_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;
ALTER SEQUENCE cost_items_id_seq OWNED BY cost_items.id;

CREATE TABLE exchange_rates (
    id bigint NOT NULL,
    date timestamp with time zone,
    from_currency character(3),
    to_currency character(3),
    multiplicity numeric(10,0),
    rate numeric(10,0)
);

CREATE SEQUENCE exchange_rates_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;
ALTER SEQUENCE exchange_rates_id_seq OWNED BY exchange_rates.id;

CREATE TABLE payment_document (
    id bigint NOT NULL,
    date timestamp with time zone,
    bank_account_id bigint,
    checked boolean,
    description character varying,
    sum numeric(15,2),
    currency character(3)
);

CREATE TABLE payment_document_details (
    id bigint NOT NULL,
    project_id bigint,
    project_stage_id bigint,
    cost_item_id bigint,
    currency character(3),
    sum numeric(15,2),
    doc_id bigint NOT NULL,
    row_number bigint
);

CREATE SEQUENCE payment_document_details_doc_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;
ALTER SEQUENCE payment_document_details_doc_id_seq OWNED BY payment_document_details.doc_id;

CREATE SEQUENCE payment_document_details_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;
ALTER SEQUENCE payment_document_details_id_seq OWNED BY payment_document_details.id;

CREATE SEQUENCE payment_document_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;
ALTER SEQUENCE payment_document_id_seq OWNED BY payment_document.id;

CREATE TABLE project_fin_result (
    id bigint NOT NULL,
    date timestamp with time zone,
    cost_item_id bigint,
    project_id bigint NOT NULL,
    project_stage_id bigint NOT NULL,
    sum numeric(15,2) DEFAULT 0 NOT NULL,
    profit_type character varying,
    currency character(3),
    doc_id bigint,
    doc_type character varying
);

CREATE SEQUENCE project_fin_result_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;
ALTER SEQUENCE project_fin_result_id_seq OWNED BY project_fin_result.id;

CREATE SEQUENCE project_fin_result_project_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;
ALTER SEQUENCE project_fin_result_project_id_seq OWNED BY project_fin_result.project_id;

CREATE SEQUENCE project_fin_result_project_stage_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;
ALTER SEQUENCE project_fin_result_project_stage_id_seq OWNED BY project_fin_result.project_stage_id;

CREATE TABLE project_stages (
    id bigint NOT NULL,
    name character varying,
    description character varying,
    parent bigint NOT NULL
);


CREATE SEQUENCE project_stages_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;
ALTER SEQUENCE project_stages_id_seq OWNED BY project_stages.id;

CREATE TABLE projects (
    id bigint NOT NULL,
    name character varying,
    description character varying,
    type character varying,
    active boolean,
    pm character varying
);

CREATE SEQUENCE projects_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;
ALTER SEQUENCE projects_id_seq OWNED BY projects.id;

--
--

ALTER TABLE bank_account OWNER TO admin9bx5nlz;
ALTER TABLE bank_account_id_seq OWNER TO admin9bx5nlz;
ALTER TABLE cash_movement OWNER TO admin9bx5nlz;
ALTER TABLE cash_movement_id_seq OWNER TO admin9bx5nlz;
ALTER TABLE cost_items OWNER TO admin9bx5nlz;
ALTER TABLE cost_items_id_seq OWNER TO admin9bx5nlz;
ALTER TABLE exchange_rates OWNER TO admin9bx5nlz;
ALTER TABLE exchange_rates_id_seq OWNER TO admin9bx5nlz;
ALTER TABLE payment_document OWNER TO admin9bx5nlz;
ALTER TABLE payment_document_details OWNER TO admin9bx5nlz;
ALTER TABLE payment_document_details_doc_id_seq OWNER TO admin9bx5nlz;
ALTER TABLE payment_document_details_id_seq OWNER TO admin9bx5nlz;
ALTER TABLE payment_document_id_seq OWNER TO admin9bx5nlz;
ALTER TABLE project_fin_result OWNER TO admin9bx5nlz;
ALTER TABLE project_fin_result_id_seq OWNER TO admin9bx5nlz;
ALTER TABLE project_fin_result_project_id_seq OWNER TO admin9bx5nlz;
ALTER TABLE project_fin_result_project_stage_id_seq OWNER TO admin9bx5nlz;
ALTER TABLE project_stages OWNER TO admin9bx5nlz;
ALTER TABLE project_stages_id_seq OWNER TO admin9bx5nlz;
ALTER TABLE projects OWNER TO admin9bx5nlz;
ALTER TABLE projects_id_seq OWNER TO admin9bx5nlz;

--
-- 

ALTER TABLE ONLY bank_account ALTER COLUMN id SET DEFAULT nextval('bank_account_id_seq'::regclass);
ALTER TABLE ONLY cash_movement ALTER COLUMN id SET DEFAULT nextval('cash_movement_id_seq'::regclass);
ALTER TABLE ONLY cost_items ALTER COLUMN id SET DEFAULT nextval('cost_items_id_seq'::regclass);
ALTER TABLE ONLY exchange_rates ALTER COLUMN id SET DEFAULT nextval('exchange_rates_id_seq'::regclass);
ALTER TABLE ONLY payment_document ALTER COLUMN id SET DEFAULT nextval('payment_document_id_seq'::regclass);
ALTER TABLE ONLY payment_document_details ALTER COLUMN id SET DEFAULT nextval('payment_document_details_id_seq'::regclass);
ALTER TABLE ONLY payment_document_details ALTER COLUMN doc_id SET DEFAULT nextval('payment_document_details_doc_id_seq'::regclass);
ALTER TABLE ONLY project_fin_result ALTER COLUMN id SET DEFAULT nextval('project_fin_result_id_seq'::regclass);
ALTER TABLE ONLY project_fin_result ALTER COLUMN project_id SET DEFAULT nextval('project_fin_result_project_id_seq'::regclass);
ALTER TABLE ONLY project_fin_result ALTER COLUMN project_stage_id SET DEFAULT nextval('project_fin_result_project_stage_id_seq'::regclass);
ALTER TABLE ONLY project_stages ALTER COLUMN id SET DEFAULT nextval('project_stages_id_seq'::regclass);
ALTER TABLE ONLY projects ALTER COLUMN id SET DEFAULT nextval('projects_id_seq'::regclass);

--
--

ALTER TABLE ONLY bank_account
    ADD CONSTRAINT bank_account_pkey PRIMARY KEY (id);

ALTER TABLE ONLY cash_movement
    ADD CONSTRAINT cash_movement_pkey PRIMARY KEY (id);

ALTER TABLE ONLY cost_items
    ADD CONSTRAINT cost_items_pkey PRIMARY KEY (id);

ALTER TABLE ONLY exchange_rates
    ADD CONSTRAINT exchange_rates_pkey PRIMARY KEY (id);

ALTER TABLE ONLY payment_document_details
    ADD CONSTRAINT payment_document_details_pkey PRIMARY KEY (id);

ALTER TABLE ONLY payment_document
    ADD CONSTRAINT payment_document_pkey PRIMARY KEY (id);

ALTER TABLE ONLY project_fin_result
    ADD CONSTRAINT project_fin_result_pkey PRIMARY KEY (id);

ALTER TABLE ONLY project_stages
    ADD CONSTRAINT project_stages_pkey PRIMARY KEY (id);

ALTER TABLE ONLY projects
    ADD CONSTRAINT projects_pkey PRIMARY KEY (id);

--
--

CREATE INDEX fki_bank_account_fkey ON cash_movement USING btree (bank_account_id);
CREATE INDEX fki_cost_item_fk ON project_fin_result USING btree (cost_item_id);
CREATE INDEX fki_parent_key ON cost_items USING btree (parent);
CREATE INDEX fki_payment_document_bank_account_fkey ON payment_document USING btree (bank_account_id);
CREATE INDEX fki_payment_document_details_cost_item_fkey ON payment_document_details USING btree (cost_item_id);
CREATE INDEX fki_payment_document_details_doc_fkey ON payment_document_details USING btree (doc_id);
CREATE INDEX fki_payment_document_details_project_fkey ON payment_document_details USING btree (project_id);
CREATE INDEX fki_payment_document_details_project_stage_fkey ON payment_document_details USING btree (project_stage_id);
CREATE INDEX fki_project_fk ON project_fin_result USING btree (project_id);
CREATE INDEX fki_project_parent_key ON project_stages USING btree (parent);
CREATE INDEX fki_project_stage_fk ON project_fin_result USING btree (project_stage_id);

--
--

ALTER TABLE ONLY cash_movement
    ADD CONSTRAINT cash_movement_bank_account_id_fkey FOREIGN KEY (bank_account_id) REFERENCES bank_account(id);
ALTER TABLE ONLY project_fin_result
    ADD CONSTRAINT cost_item_fk FOREIGN KEY (cost_item_id) REFERENCES cost_items(id);
ALTER TABLE ONLY cost_items
    ADD CONSTRAINT cost_items_parent_fkey FOREIGN KEY (parent) REFERENCES cost_items(id) ON DELETE RESTRICT;
ALTER TABLE ONLY payment_document
    ADD CONSTRAINT payment_document_bank_account_fkey FOREIGN KEY (bank_account_id) REFERENCES bank_account(id);
ALTER TABLE ONLY payment_document_details
    ADD CONSTRAINT payment_document_details_cost_item_fkey FOREIGN KEY (cost_item_id) REFERENCES cost_items(id);
ALTER TABLE ONLY payment_document_details
    ADD CONSTRAINT payment_document_details_doc_fkey FOREIGN KEY (doc_id) REFERENCES payment_document(id);
ALTER TABLE ONLY payment_document_details
    ADD CONSTRAINT payment_document_details_project_fkey FOREIGN KEY (project_id) REFERENCES projects(id);
ALTER TABLE ONLY payment_document_details
    ADD CONSTRAINT payment_document_details_project_stage_fkey FOREIGN KEY (project_stage_id) REFERENCES project_stages(id);
ALTER TABLE ONLY project_fin_result
    ADD CONSTRAINT project_fk FOREIGN KEY (project_id) REFERENCES projects(id);
ALTER TABLE ONLY project_stages
    ADD CONSTRAINT project_parent_key FOREIGN KEY (parent) REFERENCES projects(id);
ALTER TABLE ONLY project_fin_result
    ADD CONSTRAINT project_stage_fk FOREIGN KEY (project_stage_id) REFERENCES project_stages(id);


--
-- 

GRANT ALL ON SCHEMA public TO postgres;
GRANT ALL ON SCHEMA public TO PUBLIC;

--
-- 

COPY bank_account (id, name, bank_name, currency) FROM stdin;
1	Текущий долларовый	Банк Аваль	USD
2	Текущий гривневый счет	Ощадбанк	UAH
\.

COPY cost_items (id, name, type, parent) FROM stdin;
1	Доходы	PROFIT	\N
2	Расходы	LOSTS	\N
3	Налоги	LOSTS	2
4	Доходы от проектной деятельности	PROFIT	1
5	Зарплата	LOSTS	2
\.


COPY projects (id, name, description, type, active, pm) FROM stdin;
1	Проект 1	Проект внедрения	OUTER	f	Иванов И.И.
2	Проект 2	Проект сопровождения	OUTER	t	Иванов И.И.
\.


