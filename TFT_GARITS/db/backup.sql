--
-- PostgreSQL database dump
--

-- Dumped from database version 11.2
-- Dumped by pg_dump version 11.2

-- Started on 2019-04-04 00:25:19 BST

SET statement_timeout = 0;
SET lock_timeout = 0;
SET idle_in_transaction_session_timeout = 0;
SET client_encoding = 'UTF8';
SET standard_conforming_strings = on;
SELECT pg_catalog.set_config('search_path', '', false);
SET check_function_bodies = false;
SET client_min_messages = warning;
SET row_security = off;

--
-- TOC entry 1 (class 3079 OID 16384)
-- Name: adminpack; Type: EXTENSION; Schema: -; Owner: 
--

CREATE EXTENSION IF NOT EXISTS adminpack WITH SCHEMA pg_catalog;


--
-- TOC entry 3243 (class 0 OID 0)
-- Dependencies: 1
-- Name: EXTENSION adminpack; Type: COMMENT; Schema: -; Owner: 
--

COMMENT ON EXTENSION adminpack IS 'administrative functions for PostgreSQL';


SET default_tablespace = '';

SET default_with_oids = false;

--
-- TOC entry 213 (class 1259 OID 30835)
-- Name: accountholder; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.accountholder (
    accountid integer NOT NULL,
    customer_no integer NOT NULL,
    discount_type integer DEFAULT 0 NOT NULL,
    discount_amount double precision,
    check_limit double precision,
    monthly_spending double precision DEFAULT 0
);


ALTER TABLE public.accountholder OWNER TO postgres;

--
-- TOC entry 212 (class 1259 OID 30833)
-- Name: accountholder_accountid_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public.accountholder_accountid_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.accountholder_accountid_seq OWNER TO postgres;

--
-- TOC entry 3244 (class 0 OID 0)
-- Dependencies: 212
-- Name: accountholder_accountid_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE public.accountholder_accountid_seq OWNED BY public.accountholder.accountid;


--
-- TOC entry 198 (class 1259 OID 21573)
-- Name: customer; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.customer (
    customer_no integer NOT NULL,
    customer_name character varying NOT NULL,
    address character varying NOT NULL,
    tel integer,
    post_code character varying NOT NULL,
    email character varying,
    fax character varying
);


ALTER TABLE public.customer OWNER TO postgres;

--
-- TOC entry 197 (class 1259 OID 21571)
-- Name: customer_customer_no_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public.customer_customer_no_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.customer_customer_no_seq OWNER TO postgres;

--
-- TOC entry 3245 (class 0 OID 0)
-- Dependencies: 197
-- Name: customer_customer_no_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE public.customer_customer_no_seq OWNED BY public.customer.customer_no;


--
-- TOC entry 207 (class 1259 OID 24418)
-- Name: job; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.job (
    job_no integer NOT NULL,
    customer_no integer NOT NULL,
    status character varying DEFAULT 'Pending'::character varying NOT NULL,
    date_booked date NOT NULL,
    reg_no character varying NOT NULL,
    staff_no integer,
    estimated_time double precision NOT NULL,
    completion_date date,
    reminder_state integer DEFAULT 0 NOT NULL,
    invoice_date date,
    totalamount double precision DEFAULT 0
);


ALTER TABLE public.job OWNER TO postgres;

--
-- TOC entry 206 (class 1259 OID 24416)
-- Name: job_job_no_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public.job_job_no_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.job_job_no_seq OWNER TO postgres;

--
-- TOC entry 3246 (class 0 OID 0)
-- Dependencies: 206
-- Name: job_job_no_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE public.job_job_no_seq OWNED BY public.job.job_no;


--
-- TOC entry 205 (class 1259 OID 21662)
-- Name: login; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.login (
    id integer NOT NULL,
    user_name character varying NOT NULL,
    password character varying NOT NULL,
    account_type character varying NOT NULL
);


ALTER TABLE public.login OWNER TO postgres;

--
-- TOC entry 204 (class 1259 OID 21660)
-- Name: login_id_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public.login_id_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.login_id_seq OWNER TO postgres;

--
-- TOC entry 3247 (class 0 OID 0)
-- Dependencies: 204
-- Name: login_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE public.login_id_seq OWNED BY public.login.id;


--
-- TOC entry 202 (class 1259 OID 21618)
-- Name: part; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.part (
    part_no integer NOT NULL,
    part_name character varying NOT NULL,
    description character varying NOT NULL,
    price double precision NOT NULL,
    stock_amount integer NOT NULL,
    threshold integer DEFAULT 10 NOT NULL
);


ALTER TABLE public.part OWNER TO postgres;

--
-- TOC entry 201 (class 1259 OID 21616)
-- Name: part_part_no_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public.part_part_no_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.part_part_no_seq OWNER TO postgres;

--
-- TOC entry 3248 (class 0 OID 0)
-- Dependencies: 201
-- Name: part_part_no_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE public.part_part_no_seq OWNED BY public.part.part_no;


--
-- TOC entry 200 (class 1259 OID 21596)
-- Name: staff; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.staff (
    staff_no integer NOT NULL,
    staff_name character varying NOT NULL,
    user_name character varying NOT NULL,
    hourly_rate numeric(6,2)
);


ALTER TABLE public.staff OWNER TO postgres;

--
-- TOC entry 199 (class 1259 OID 21594)
-- Name: staff_staff_no_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public.staff_staff_no_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.staff_staff_no_seq OWNER TO postgres;

--
-- TOC entry 3249 (class 0 OID 0)
-- Dependencies: 199
-- Name: staff_staff_no_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE public.staff_staff_no_seq OWNED BY public.staff.staff_no;


--
-- TOC entry 211 (class 1259 OID 28271)
-- Name: stock; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.stock (
    part_no integer NOT NULL,
    stock_change integer NOT NULL,
    date date DEFAULT CURRENT_TIMESTAMP NOT NULL
);


ALTER TABLE public.stock OWNER TO postgres;

--
-- TOC entry 209 (class 1259 OID 24500)
-- Name: task; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.task (
    task_no integer NOT NULL,
    job_no integer NOT NULL,
    task_desc character varying NOT NULL,
    status integer DEFAULT 0 NOT NULL
);


ALTER TABLE public.task OWNER TO postgres;

--
-- TOC entry 210 (class 1259 OID 24509)
-- Name: task_part; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.task_part (
    task_no integer,
    part_no integer,
    amount integer DEFAULT 1 NOT NULL
);


ALTER TABLE public.task_part OWNER TO postgres;

--
-- TOC entry 208 (class 1259 OID 24498)
-- Name: task_task_no_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public.task_task_no_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.task_task_no_seq OWNER TO postgres;

--
-- TOC entry 3250 (class 0 OID 0)
-- Dependencies: 208
-- Name: task_task_no_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE public.task_task_no_seq OWNED BY public.task.task_no;


--
-- TOC entry 203 (class 1259 OID 21644)
-- Name: vehicle; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.vehicle (
    reg_no character varying NOT NULL,
    customer_no integer NOT NULL,
    make character varying NOT NULL,
    model character varying NOT NULL,
    colour character varying,
    eng_serial character varying,
    chassis_no character varying,
    last_mot date
);


ALTER TABLE public.vehicle OWNER TO postgres;

--
-- TOC entry 3071 (class 2604 OID 30838)
-- Name: accountholder accountid; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.accountholder ALTER COLUMN accountid SET DEFAULT nextval('public.accountholder_accountid_seq'::regclass);


--
-- TOC entry 3058 (class 2604 OID 21576)
-- Name: customer customer_no; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.customer ALTER COLUMN customer_no SET DEFAULT nextval('public.customer_customer_no_seq'::regclass);


--
-- TOC entry 3063 (class 2604 OID 24421)
-- Name: job job_no; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.job ALTER COLUMN job_no SET DEFAULT nextval('public.job_job_no_seq'::regclass);


--
-- TOC entry 3062 (class 2604 OID 21665)
-- Name: login id; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.login ALTER COLUMN id SET DEFAULT nextval('public.login_id_seq'::regclass);


--
-- TOC entry 3060 (class 2604 OID 21621)
-- Name: part part_no; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.part ALTER COLUMN part_no SET DEFAULT nextval('public.part_part_no_seq'::regclass);


--
-- TOC entry 3059 (class 2604 OID 21599)
-- Name: staff staff_no; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.staff ALTER COLUMN staff_no SET DEFAULT nextval('public.staff_staff_no_seq'::regclass);


--
-- TOC entry 3067 (class 2604 OID 24503)
-- Name: task task_no; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.task ALTER COLUMN task_no SET DEFAULT nextval('public.task_task_no_seq'::regclass);


--
-- TOC entry 3237 (class 0 OID 30835)
-- Dependencies: 213
-- Data for Name: accountholder; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.accountholder (accountid, customer_no, discount_type, discount_amount, check_limit, monthly_spending) FROM stdin;
\.


--
-- TOC entry 3222 (class 0 OID 21573)
-- Dependencies: 198
-- Data for Name: customer; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.customer (customer_no, customer_name, address, tel, post_code, email, fax) FROM stdin;
1	ravaf	fasva	2	avasv	vasva	-1
2	sdfasf	adsfa	3	asdfaf	asdfa	-1
3	J. Smith	27 Sainsbury Close, Stratford, Essex	2089363756	EJ6 5TJ	email	-1
0	ravaf	fasva	324	avasv	vasva	-1
\.


--
-- TOC entry 3231 (class 0 OID 24418)
-- Dependencies: 207
-- Data for Name: job; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.job (job_no, customer_no, status, date_booked, reg_no, staff_no, estimated_time, completion_date, reminder_state, invoice_date, totalamount) FROM stdin;
13	3	Complete	2018-10-18	DF65 POT	2	5.5	2018-10-18	5	2019-04-02	0
1	1	Complete	2019-03-31	reg no	2	5.5	2019-04-03	1	2019-04-02	0
15	3	Complete	2019-04-02	BEEG CAAR	2	4.09000015258789062	2019-04-03	1	2019-04-03	0
8	1	In Progress	2019-03-31	1234	\N	5.5	2019-03-31	4	\N	0
9	2	In Progress	2019-03-31	adfdddasdf	\N	5.5	2019-03-31	4	\N	0
10	1	Not Started	2019-03-31	124 123o	2	5.5	2019-03-31	1	2019-04-02	0
\.


--
-- TOC entry 3229 (class 0 OID 21662)
-- Dependencies: 205
-- Data for Name: login; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.login (id, user_name, password, account_type) FROM stdin;
1	admin	tft	Admin
2	frank	frank	Franchisee
3	mech	mech	Mechanic
\.


--
-- TOC entry 3226 (class 0 OID 21618)
-- Dependencies: 202
-- Data for Name: part; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.part (part_no, part_name, description, price, stock_amount, threshold) FROM stdin;
4	beep boop 2	nine	9.5	5	1
8	human hair	smells gross	555	-2	3
2	beep boop	its an robot	50	3	10
3	round	adfaf	5	0	10
5	widget	widge	1000	3	10
6	spacer	bit of metal	56	1	10
7	large hadron collider	big ring thing	10	58	10
\.


--
-- TOC entry 3224 (class 0 OID 21596)
-- Dependencies: 200
-- Data for Name: staff; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.staff (staff_no, staff_name, user_name, hourly_rate) FROM stdin;
1	asdfaf	frank	\N
2	mech	mech	105.00
\.


--
-- TOC entry 3235 (class 0 OID 28271)
-- Dependencies: 211
-- Data for Name: stock; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.stock (part_no, stock_change, date) FROM stdin;
5	-1	2019-04-03
6	-1	2019-04-03
3	-1	2019-04-03
2	-1	2019-04-03
4	-1	2019-04-03
7	-1	2019-04-03
8	-1	2019-04-03
8	-6	2019-04-03
2	0	2019-04-03
4	0	2019-04-03
5	0	2019-04-03
6	0	2019-04-03
7	0	2019-04-03
3	1	2019-04-03
8	2	2019-04-03
8	-1	2019-04-03
4	-3	2019-04-03
8	-1	2019-04-03
\.


--
-- TOC entry 3233 (class 0 OID 24500)
-- Dependencies: 209
-- Data for Name: task; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.task (task_no, job_no, task_desc, status) FROM stdin;
3	1	1234123412341	0
5	8	take apart	1
4	8	build	1
6	10		0
7	10	fuck	1
8	10	build	1
9	13	f	1
10	15	fix	1
11	15	babababa	1
2	1	12341324	1
1	1	123414	1
\.


--
-- TOC entry 3234 (class 0 OID 24509)
-- Dependencies: 210
-- Data for Name: task_part; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.task_part (task_no, part_no, amount) FROM stdin;
1	4	3
1	8	1
3	5	1
3	6	1
2	8	1
4	5	1
4	8	2
4	7	1
7	2	1
8	5	1
8	6	1
9	3	1
10	3	1
10	4	1
10	5	1
10	6	1
10	7	1
10	8	1
10	2	1
11	8	6
\.


--
-- TOC entry 3227 (class 0 OID 21644)
-- Dependencies: 203
-- Data for Name: vehicle; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.vehicle (reg_no, customer_no, make, model, colour, eng_serial, chassis_no, last_mot) FROM stdin;
adsfa	2	sdfa	sdfa	\N	\N	\N	\N
beeop	2	efvef	dfva	\N	\N	\N	\N
vdfva	2	fvadfv	adfv	\N	\N	\N	\N
1234124	2	fafs	asv	\N	\N	\N	\N
DF65 POT	3	Opel	Vectra Estate	\N	\N	\N	\N
BEEG CAAR	3	big	car	blue	sss	faf	\N
adfasdf	2	123	134	\N	\N	\N	\N
adfdddasdf	2	123	134	\N	\N	\N	\N
car reg	1	make	model	\N	\N	\N	1999-01-08
qwer	1	qewr	qwer	\N	\N	\N	1999-01-08
1431	1	1234	1234	\N	\N	\N	1999-01-08
12	1	123	123	\N	\N	\N	1999-01-08
124	1	123	123	\N	\N	\N	1999-01-08
124123	1	123	123	\N	afdas	\N	1999-01-08
124 123	1	123	123	asdf	\N	\N	1999-01-18
124 123o	1	audi	r8	\N	\N	\N	1999-01-08
1234	1	123	123	\N	adf	\N	1999-01-08
reg no	1	asdf	asdf	\N	\N	\N	1999-02-08
\.


--
-- TOC entry 3251 (class 0 OID 0)
-- Dependencies: 212
-- Name: accountholder_accountid_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public.accountholder_accountid_seq', 1, false);


--
-- TOC entry 3252 (class 0 OID 0)
-- Dependencies: 197
-- Name: customer_customer_no_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public.customer_customer_no_seq', 3, true);


--
-- TOC entry 3253 (class 0 OID 0)
-- Dependencies: 206
-- Name: job_job_no_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public.job_job_no_seq', 15, true);


--
-- TOC entry 3254 (class 0 OID 0)
-- Dependencies: 204
-- Name: login_id_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public.login_id_seq', 3, true);


--
-- TOC entry 3255 (class 0 OID 0)
-- Dependencies: 201
-- Name: part_part_no_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public.part_part_no_seq', 8, true);


--
-- TOC entry 3256 (class 0 OID 0)
-- Dependencies: 199
-- Name: staff_staff_no_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public.staff_staff_no_seq', 2, true);


--
-- TOC entry 3257 (class 0 OID 0)
-- Dependencies: 208
-- Name: task_task_no_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public.task_task_no_seq', 11, true);


--
-- TOC entry 3089 (class 2606 OID 30842)
-- Name: accountholder accountholder_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.accountholder
    ADD CONSTRAINT accountholder_pkey PRIMARY KEY (accountid);


--
-- TOC entry 3075 (class 2606 OID 21581)
-- Name: customer customer_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.customer
    ADD CONSTRAINT customer_pkey PRIMARY KEY (customer_no);


--
-- TOC entry 3085 (class 2606 OID 24427)
-- Name: job job_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.job
    ADD CONSTRAINT job_pkey PRIMARY KEY (job_no);


--
-- TOC entry 3083 (class 2606 OID 21670)
-- Name: login login_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.login
    ADD CONSTRAINT login_pkey PRIMARY KEY (user_name);


--
-- TOC entry 3079 (class 2606 OID 21627)
-- Name: part part_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.part
    ADD CONSTRAINT part_pkey PRIMARY KEY (part_no);


--
-- TOC entry 3077 (class 2606 OID 21604)
-- Name: staff staff_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.staff
    ADD CONSTRAINT staff_pkey PRIMARY KEY (staff_no);


--
-- TOC entry 3087 (class 2606 OID 24508)
-- Name: task task_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.task
    ADD CONSTRAINT task_pkey PRIMARY KEY (task_no);


--
-- TOC entry 3081 (class 2606 OID 21651)
-- Name: vehicle vehicle_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.vehicle
    ADD CONSTRAINT vehicle_pkey PRIMARY KEY (reg_no);


--
-- TOC entry 3099 (class 2606 OID 31398)
-- Name: accountholder accountholder_fk0; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.accountholder
    ADD CONSTRAINT accountholder_fk0 FOREIGN KEY (customer_no) REFERENCES public.customer(customer_no);


--
-- TOC entry 3092 (class 2606 OID 31363)
-- Name: job job_fk0; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.job
    ADD CONSTRAINT job_fk0 FOREIGN KEY (customer_no) REFERENCES public.customer(customer_no);


--
-- TOC entry 3093 (class 2606 OID 31368)
-- Name: job job_fk1; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.job
    ADD CONSTRAINT job_fk1 FOREIGN KEY (reg_no) REFERENCES public.vehicle(reg_no);


--
-- TOC entry 3094 (class 2606 OID 31373)
-- Name: job job_fk2; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.job
    ADD CONSTRAINT job_fk2 FOREIGN KEY (staff_no) REFERENCES public.staff(staff_no);


--
-- TOC entry 3090 (class 2606 OID 31378)
-- Name: staff staff_fk0; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.staff
    ADD CONSTRAINT staff_fk0 FOREIGN KEY (user_name) REFERENCES public.login(user_name);


--
-- TOC entry 3098 (class 2606 OID 31388)
-- Name: stock stock_fk0; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.stock
    ADD CONSTRAINT stock_fk0 FOREIGN KEY (part_no) REFERENCES public.part(part_no);


--
-- TOC entry 3095 (class 2606 OID 31383)
-- Name: task task_fk0; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.task
    ADD CONSTRAINT task_fk0 FOREIGN KEY (job_no) REFERENCES public.job(job_no);


--
-- TOC entry 3097 (class 2606 OID 24518)
-- Name: task_part task_part_part_no_fkey; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.task_part
    ADD CONSTRAINT task_part_part_no_fkey FOREIGN KEY (part_no) REFERENCES public.part(part_no) ON UPDATE CASCADE;


--
-- TOC entry 3096 (class 2606 OID 24513)
-- Name: task_part task_part_task_no_fkey; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.task_part
    ADD CONSTRAINT task_part_task_no_fkey FOREIGN KEY (task_no) REFERENCES public.task(task_no) ON UPDATE CASCADE ON DELETE CASCADE;


--
-- TOC entry 3091 (class 2606 OID 31393)
-- Name: vehicle vehicle_fk0; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.vehicle
    ADD CONSTRAINT vehicle_fk0 FOREIGN KEY (customer_no) REFERENCES public.customer(customer_no);


-- Completed on 2019-04-04 00:25:20 BST

--
-- PostgreSQL database dump complete
--

